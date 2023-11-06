def parse_icr(icr):
    mips_output = []
    lines = icr.strip().split("\n")

    for line in lines:
        words = line.split()

        if not words:
            continue

        if "DECLARE CLASS" in line:
            mips_output.append(declare_class(words[-1]))
        elif "INIT" in line and len(words) > 2:
            mips_output.append(init_block(words[2]))
        elif "FINISHING" in line:
            mips_output.append(finish_block())
        elif "PUSHING" in line:
            mips_output.append(pushing(words[1]))
        elif "CALLING" in line and len(words) > 4:
            mips_output.append(calling_function(words[1], int(words[3])))
        
        elif "out_string" in line:
            string = line.split('"')[1]  
            mips_output.extend(handle_out_string(string))
        elif "out_int" in line:
            integer = int(words[-1])
            mips_output.extend(handle_out_int(integer))
    
        elif "FUNCTION" in line:
            mips_output.append(".globl {}".format(words[1]))  
            mips_output.append("{}:".format(words[1]))
            
        elif "=" in line and ("+" in line or "/" in line):
            result, _, operand1, op, operand2 = words[:5]
            mips_output.extend(arithmetic_operation(result, operand1, op, operand2))

    return mips_output



def declare_class(name):
    return f"\n# INIT class {name}\n"


def init_block(label):
    return f"\n{label}:\n"


def finish_block():
    return "\n# FIN bloque\n"


def pushing(value):
    if isinstance(value, str) and value.startswith("t"):
        return f"lw $sp, {value}\naddiu $sp, $sp, -4\n"
    else:
        return f"li $t0, {value}\nlw $sp, $t0\naddiu $sp, $sp, -4\n"


def calling_function(name, num_args):
    restore_sp = f"addiu $sp, $sp, {4*num_args}\n"
    return f"jal {name}\n{restore_sp}"


def arithmetic_operation(result, operand1, op, operand2):
    mips_instructions = []
    if op == "+":
        mips_instructions.append(f"add {result}, {operand1}, {operand2} # Suma\n")
    elif op == "/":
        mips_instructions.append(f"div {operand1}, {operand2} # División\n")
        mips_instructions.append(f"mflo {result}\n")
    return mips_instructions


def system_call(service_code):
    return [
        'li $v0, {}'.format(service_code),  
        'syscall'                           
    ]


def handle_out_string(string):
    mips_instructions = []
    string_label = "str{}".format(len(string))  
 
    mips_instructions.append('.data')
    mips_instructions.append('{}: .asciiz {}'.format(string_label, string))
    mips_instructions.append('.text')

    mips_instructions.append('la $a0, {}'.format(string_label))

    mips_instructions.extend(system_call(4))
    return mips_instructions


def handle_out_int(integer):
    mips_instructions = [
        'li $a0, {}'.format(integer),  
    ]
 
    mips_instructions.extend(system_call(1))
    return mips_instructions

