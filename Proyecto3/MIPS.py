# Sección para almacenar datos estáticos (por ejemplo, cadenas de texto).
data_section = []

# Diccionario para llevar un seguimiento de las etiquetas de las cadenas para evitar duplicados
string_labels = {}

# Analiza el ICR y genera el código MIPS correspondiente.


def parse_icr(icr):
    # Lista para almacenar las líneas de código MIPS generadas.
    mips_output = []
    # Divide el ICR en líneas y las procesa una por una.
    lines = icr.strip().split("\n")

    for line in lines:
        # Divide la línea en palabras para analizar los componentes.
        words = line.split()
        # Si la línea está vacía, continúa con la siguiente.
        if not words:
            continue
        # Procesa las declaraciones de clases.
        if "DECLARE CLASS" in line:
            mips_output.append("# INIT class {}\n".format(words[-1]))
        # Procesa la definición de funciones.
        elif "FUNCTION" in line:

            mips_output.append("main:\n")
        # Procesa el final de las funciones y clases.
        elif "FINISHING" in line:

            mips_output.append("    li $v0, 10\n    syscall\n")
        # Procesa la acción de empujar una cadena al stack.
        elif "PUSHING" in line:

            string_to_push = line[line.find('"')+1:line.rfind('"')]
            label = add_string_to_data_section(string_to_push)
            mips_output.append("    la $a0, {}\n".format(label))

            mips_output.append("    li $v0, 4\n    syscall\n")

    return mips_output

# Declara el inicio de una clase en el código MIPS.


def declare_class(name):
    return f"# INIT class {name}\n"

# Inicia un bloque de código con una etiqueta.


def init_block(label):
    return f"{label}:\n"

# Finaliza un bloque de código.


def finish_block():
    return "# FIN bloque\n"

# Añade una cadena a la sección de datos y retorna la etiqueta correspondiente.


def add_string_to_data_section(string):
    if string not in string_labels:
        label = "str{}".format(len(string_labels))
        data_section.append('{}: .asciiz "{}"\n'.format(label, string))
        string_labels[string] = label
    return string_labels[string]


# Prepara el código para empujar una cadena al stack.
def pushing(string):

    label = add_string_to_data_section(string)
    return [
        f"    la $t0, {label}",  # Carga la dirección de la cadena en $t0.
        # Decrementa el puntero de pila para hacer espacio.
        "    addiu $sp, $sp, -4",
        "    sw $t0, 0($sp)"  # Almacena la dirección en la cima de la pila.
    ]

# Genera código para llamar a una función.


def calling_function(name, num_args):
    # TODO: Finish function
    return []

# Realiza operaciones aritméticas y genera código MIPS correspondiente


def arithmetic_operation(result, operand1, op, operand2):
    if op == "+":
        return [f"    add {result}, {operand1}, {operand2}"]
    elif op == "/":
        return [f"    div {operand1}, {operand2}", f"    mflo {result}"]
    elif op == "-":
        return [f"    sub {result}, {operand1}, {operand2}"]
    else:
        # Si la operación no es reconocida, retorna una lista vacía.
        return []

# Realiza un llamado al sistema con un código de servicio dado.


def system_call(service_code):
    return f"    li $v0, {service_code}\n    syscall\n"


# Maneja la salida de cadenas de texto.
def handle_out_string(string):
    label = add_string_to_data_section(string)
    return [
        f'    la $a0, {label}',  # Carga la dirección de la cadena en $a0.
        '    li $v0, 4',  # Código de servicio para imprimir cadenas.
        '    syscall'  # Llamada al sistema.
    ]


# Maneja la salida de números enteros.
def handle_out_int(integer):
    return [
        f"    li $a0, {integer}",  # Carga el número entero en $a0.
        "    li $v0, 1",  # Código de servicio para imprimir enteros.
        "    syscall"  # Llamada al sistema.
    ]


# Genera el código MIPS completo a partir del ICR.
def generate_mips(icr):
    # Primero analiza el ICR para obtener el cuerpo principal del código MIPS.
    mips_body = parse_icr(icr)

    # Comienza a construir la salida MIPS.
    mips_output = ['.data']

    # Agrega las entradas de la sección de datos de cadenas.
    mips_output.extend(data_section)

    # Comienza la sección de texto.
    mips_output.append('\n.text\n.globl main\n')

    # Agrega el cuerpo del código MIPS.
    mips_output.extend(mips_body)

    # Genera el código MIPS completo como una única cadena de texto.
    mips_code = '\n'.join(mips_output)

    print("--- MIPS CODE ---\n")
    print(mips_code)

    # Escribe el código MIPS en el archivo de salida.
    with open('output.asm', 'w') as mips_file:
        mips_file.write(mips_code)

    return mips_code
