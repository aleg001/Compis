# Declare the data section
data_section = []
# Keep track of the labels for strings to avoid duplicates
string_labels = {}


def parse_icr(icr):
    mips_output = []
    lines = icr.strip().split("\n")

    for line in lines:
        words = line.split()

        if not words:
            continue

        if "DECLARE CLASS" in line:
            mips_output.append(declare_class(words[-1]))

        elif "FUNCTION" in line:
            mips_output.append(f"{words[1]}:\n")

        elif "FINISHING" in line:
            mips_output.append(f"    li $v0, 10\n    syscall\n")
        elif "PUSHING" in line:
            string_to_push = line[line.find('"')+1:line.rfind('"')]
            mips_output.append(pushing(string_to_push))
        if "CALLING" in line:

            if "out_string" in line and '"' in line:
                string_to_print = line.split('"')[1]
                mips_output.extend(handle_out_string(string_to_print))
            else:

                function_name = words[1]
                num_args = int(words[3]) if len(words) > 3 else 0
                mips_output.append(calling_function(function_name, num_args))

        elif "=" in line and any(op in line for op in ["+", "/"]):
            parts = line.split()
            mips_output.append(arithmetic_operation(
                parts[0], parts[2], parts[3], parts[4]))

    return mips_output


def declare_class(name):
    return f"# INIT class {name}\n"


def init_block(label):
    return f"{label}:\n"


def finish_block():
    return "# FIN bloque\n"


def add_string_to_data_section(string):
    if string not in string_labels:
        label = f"str{len(string_labels)}"
        data_section.append(f'{label}: .asciiz "{string}"')
        string_labels[string] = label
    return string_labels[string]


def pushing(string):
    label = add_string_to_data_section(string)
    return f"    la $a0, {label}\n"


def calling_function(name, num_args):
    return f"    jal {name}\n    addiu $sp, $sp, {num_args * 4}\n"


def arithmetic_operation(result, operand1, op, operand2):
    if op == "+":
        return f"    add {result}, {operand1}, {operand2}\n"
    elif op == "/":
        return f"    div {operand1}, {operand2}\n    mflo {result}\n"
    else:
        return ""


def system_call(service_code):
    return f"    li $v0, {service_code}\n    syscall\n"


def handle_out_string(string):
    label = add_string_to_data_section(string)
    return [
        f'    la $a0, {label}',
        '    li $v0, 4',
        '    syscall'
    ]


def handle_out_int(integer):
    return f"    li $a0, {integer}\n    {system_call(1)}"


def system_call(service_code):
    return f"    li $v0, {service_code}\n    syscall\n"


def generate_mips(icr):
    mips_output = []
    parse_icr(icr)
    mips_output.append('.data')
    for entry in data_section:
        mips_output.append(entry)
    mips_output.append('\n.text')
    mips_output.append('.globl main')
    mips_output.append('main:')
    mips_output.extend(parse_icr(icr))
    mips_output.append('    li $v0, 10')
    mips_output.append('    syscall')
    mips_code = '\n'.join(mips_output)

    print("\n--- MIPS CODE ---\n")
    print(mips_code)

    with open('output.asm', 'w') as mips_file:
        mips_file.write(mips_code)

    return mips_code
