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
        elif "=" in line and ("+" in line or "/" in line):
            result, _, operand1, op, operand2 = words[:5]
            mips_output.extend(arithmetic_operation(result, operand1, op, operand2))

    return mips_output


def declare_class(name):
    return f"\n# INIT clase {name}\n"


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
