import re
# Sección para almacenar datos estáticos (por ejemplo, cadenas de texto).
data_section = []

# Diccionario para llevar un seguimiento de las etiquetas de las cadenas para evitar duplicados
string_labels = {}

declaraciones = {}
# Analiza el ICR y genera el código MIPS correspondiente.


def parse_icr(icr):
    # Lista para almacenar las líneas de código MIPS generadas.

    diccionario = {}

    clase_actual = ""
    metodo_actual = ""

    extraccion = False

    N_pushing = []

    mips_output = []
    # Divide el ICR en líneas y las procesa una por una.
    lines = icr.strip().split("\n")

    for line in lines:


        # * Clase actual

        # * Metodo actual
        # Divide la línea en palabras para analizar los componentes.
        words = line.split()
        # Si la línea está vacía, continúa con la siguiente.
        if not words:
            continue

        # Procesa las declaraciones de clases.
        if "DECLARE CLASS" in line:

            clase_actual = words[-1]

            mips_output.append("# INIT class {}\n".format(words[-1]))
            mips_output.append("{}:\n".format(words[-1]))

            # if clase_actual == "Main":
            #     mips_output.append(f"        jal Main_main")
            #     mips_output.append(f"        ")

        # Procesa la definición de funciones.
        elif "String" in line and "EQUAL TO" in line:
            declaraciones[str(words[-1])] = []

            # print(declaraciones)

            # print(words[-1])
            declaraciones[str(words[-1])].append(words[1])

        elif "Int" in line and "EQUAL TO" in line:
            declaraciones[str(words[-1])] = []

            # print(declaraciones)

            # print(words[-1])
            declaraciones[str(words[-1])].append(words[1])
        elif "fp" in line and "=" in line:

            if 't' in words[-1] and len(words) == 3 and '"' not in line:
                declaraciones[words[0]].append('0')
                mips_output.append(f"\n\tsw ${words[-1]}, {declaraciones[words[0]][0] }")
            if words[-1].isdigit() and len(words) == 3 and '"' not in line:
                # declaraciones[words[0]].append('0')
                declaraciones[words[0]].append(words[-1])
            else:
                inicio = line.find('"')
                fin = line.rfind('"')
                subcadena = '"'+line[inicio + 1:fin]+'"'
                declaraciones[words[0]].append(subcadena)
            # pass
        elif "FUNCTION" in line and "FINISHING" not in line:
            mips_output.append(f"        jal Main_main")
            mips_output.append(f"        ")

            metodo_actual = words[-1]
            mips_output.append(f"# INIT METHOD {metodo_actual}\n")
            mips_output.append(f"{clase_actual}_{metodo_actual}:\n")
        # Procesa el final de las funciones y clases.
        elif "FINISHING" in line:

            if "FINISHING CLASS" in line:
                clase_actual = ''
            if "FINISHING FUNCTION" in line:
                metodo_actual = ''

        # elif "isvoid self" in line:
        #     mips_output.append(f"        jal {words[-1]}")
        #     mips_output.append(f"        move ${words[0]}, $s7")
        #     mips_output.append(f"")
        elif "NEW" in line:

            mips_output.append(f"        jal {words[-1]}")
            mips_output.append(f"        move ${words[0]}, $s7")
            mips_output.append(f"")
        elif "CALLING" in line:

            # * Si se llama al metodo especial type_name
            if "type_name" in line:

                partes = words[1].split(".")
                # * si se llama con self
                if partes[0] == 'self':
                    extraccion = True
                    mips_output.append(f"        jal Main_type_name")
                    mips_output.append(f"        move ${words[-1]}, $s7")
                    mips_output.append(f"")

                # * si se llama con palabra a secas
                elif '"' in line:

                    palabra_especial = partes[0][1:-1]

                    mips_output.append(f"\n\tli $a0, {len(palabra_especial)}\n\tli $v0, 9\n\tsyscall\n\tmove $t6, $v0")


                    for indice, caracter in enumerate(palabra_especial):
                        mips_output.append(f'        li $t5, {ord(caracter)}')
                        mips_output.append(f'        sb $t5, {indice}($t6)')

                    mips_output.append("\tmove $s7, $t6\n")
                    mips_output.append(f"\tmove ${words[-1]}, $s7\n")

                    pass
                # * si se llama con new
                else:
                    mips_output.append(f"        move ${words[-1]}, ${partes[0]}")
            elif "substr" in line:
                palabras = line.split()

                partes = words[1].split(".")
                out_string =partes[1]
                pop_value = palabras[3]
                t0_variable = palabras[5]
                # print(f'out_string: {out_string}, 1: {pop_value}, t0: {t0_variable}')

                #  * Preparando argumentos

                for x in range(int(palabras[3])):
                    mips_output.append(f"        move $a{x}, $t{9-x}")
                    N_pushing.pop()

                mips_output.append(f"        jal substr")
                mips_output.append(f"        ")
            else:
                palabras = line.split()

                out_string = palabras[1]
                pop_value = palabras[3]
                t0_variable = palabras[5]
                # print(f'out_string: {out_string}, 1: {pop_value}, t0: {t0_variable}')

                #  * Preparando argumentos

                for x in range(int(palabras[3])):
                    mips_output.append(f"        move $a{x}, $t{9-x}")
                    N_pushing.pop()

                mips_output.append(f"        jal {palabras[1]}")
                mips_output.append(f"        ")

        elif 't' in words[0] and '=' in line:
            if words[2].isdigit() and words[4].isdigit():
                if words[3] == '+':
                    mips_output.append(f"\n\taddi ${words[0]}, $zero, {int(words[2])}")
                    mips_output.append(f"\n\taddi ${words[0]}, ${words[0]}, {int(words[4])}")
                if words[3] == '-':
                    mips_output.append(f"\n\taddi ${words[0]}, $zero, {int(words[2])}")
                    mips_output.append(f"\n\tsubi ${words[0]}, ${words[0]}, {int(words[4])}")
            if 't' in words[2] and words[4].isdigit():
                if words[3] == '+':
                    mips_output.append(f"\n\taddi ${words[0]}, ${words[2]}, {int(words[4])}")
                if words[3] == '-':
                    mips_output.append(f"\n\tsubi ${words[0]}, ${words[2]}, {int(words[4])}")
            if 't' in words[2] and 't' in words[4]:
                if words[3] == '+':
                    mips_output.append(f"\n\tadd ${words[0]}, ${words[2]},${words[4]}")
                if words[3] == '-':
                    mips_output.append(f"\n\tsub ${words[0]}, ${words[2]}, ${words[4]}")

        # Procesa la acción de empujar una cadena al stack.
        elif "PUSHING" in line:

            partes = line.split()

            # * Si se pushea un string sin instanciar
            if '"' in partes[1]:
                # * Cadena a pushear
                inicio = line.find('"')
                fin = line.rfind('"')
                subcadena = line[inicio + 1:fin]
                espacio = len(subcadena)

                # * Crea en el heap espacio y lo mueve a la t9 (aqui se almacena la palabra)
                mips_output.append(f'')
                mips_output.append(f"        li $a0, {espacio}")
                # mips_output.append("        move $a0, $t5")
                mips_output.append("        li $v0, 9")
                mips_output.append("        syscall")
                mips_output.append(f"        move $t{9-len(N_pushing)}, $v0")
                mips_output.append(f'')

                # * Agrega cada palabra del outstring en asccii al espacio dinamico (t9)
                for indice, caracter in enumerate(subcadena):

                    # * Si encuentra un "\n"
                    if caracter == "\\" and subcadena[indice+1] == 'n':
                        mips_output.append(f'')
                        mips_output.append(f'        li $t5, 10')
                        mips_output.append(f'        sb $t5, {indice}($t{9-len(N_pushing)})')
                        mips_output.append(f'')
                    elif caracter == 'n' and subcadena[indice-1] == "\\":
                        pass

                    # * Si no es palabra reservada
                    else:
                        mips_output.append(f'')
                        mips_output.append(f'        li $t5, {ord(caracter)}')
                        mips_output.append(f'        sb $t5, {indice}($t{9-len(N_pushing)})')
                        mips_output.append(f'')

            # * Si se pushea un numero directamente

            elif partes[1].isdigit():

                # * Crea en el heap espacio y lo mueve a la t9 (aqui se almacena la palabra)


                mips_output.append(f'')
                mips_output.append(f'        li $t{9-len(N_pushing)}, {int(partes[1])}')
                mips_output.append(f'')

            # * Pusheando temporal
            elif "t" in partes[1]:
                mips_output.append(f'')
                mips_output.append(f'        move $t{9-len(N_pushing)}, ${partes[1]}')
                mips_output.append(f'')

            elif "fp" in line:
                if declaraciones[words[-1]][1].isdigit():
                    mips_output.append(f'')
                    mips_output.append(f'        lw $t{9-len(N_pushing)}, {declaraciones[words[-1]][0]}')
                    mips_output.append(f'')

                else:
                    mips_output.append(f'')
                    mips_output.append(f'        la $t{9-len(N_pushing)}, {declaraciones[words[-1]][0]}')
                    mips_output.append(f'')
                    # pass




            N_pushing.append(".")


    mips_output.append(f'\n\t# Terminando programa\n\tli $v0, 10\n\tsyscall\n')

    # * Funciones presentes siempre debido a IO
    mips_output.append("\nout_string:\n\tli $v0, 4\n\tsyscall\n\tj return")
    mips_output.append("\nout_int:\n\tli $v0, 1\n\tsyscall\n\t")
    mips_output.append("\nreturn:\n\tjr $ra")

    # * Funcion de substr, parametros t1 palabra, a0 inicio, a1 fin
    mips_output.append("\nsubstr:\n\tmove $s1, $a0\n\tli $a0, 20\n\tli $v0, 9\n\tsyscall\n\tmove $t0, $v0\n\tli $s0, 0\n\ntransfer:\n\tblt $s0, $s1, next\n\tlb $s2, 0($t1)\n\tsb $s2, 0($v0)\n\taddi $v0, $v0, 1\n\tbeq $s0, $a1, return\n\nnext:\n\taddi $s0, $s0, 1\n\taddi $t1, $t1, 1\n\tj transfer\n")

    if extraccion:

        # * Clase OBJECT que siempre tiene
        mips_output.append("Object:\n\tli $a0, 7\n\tli $v0, 9\n\tsyscall\n\tmove $t6, $v0")

        palabra_especial = "Object"

        for indice, caracter in enumerate(palabra_especial):
            mips_output.append(f'        li $t5, {ord(caracter)}')
            mips_output.append(f'        sb $t5, {indice}($t6)')

        mips_output.append("\tmove $s7, $t6\n\tjr $ra")

        # * Clase Main_type_name que siempre tiene
        mips_output.append("Main_type_name:\n\tli $a0, 10\n\tli $v0, 9\n\tsyscall\n\tmove $t6, $v0")

        palabra_especial = "Main"

        for indice, caracter in enumerate(palabra_especial):
            mips_output.append(f'        li $t5, {ord(caracter)}')
            mips_output.append(f'        sb $t5, {indice}($t6)')

        mips_output.append("\tmove $s7, $t6\n\tjr $ra")
    return mips_output


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

    for clave, valor in declaraciones.items():

        if valor[1].isdigit():
            mips_output.append(f'\n\t{valor[0]}: .word {valor[1]}\n')
        else:
            mips_output.append(f'\n\t{valor[0]}: .asciiz {valor[1]}\n')

    # print("---------------------------")
    # print(declaraciones)
    # print("---------------------------")

    # mips_output.append(declaraciones)

    mips_output.append('\n.text\n')


    # Agrega las entradas de la sección de datos de cadenas.
    mips_output.extend(data_section)

    # Comienza la sección de texto.
    # mips_output.append('\n.globl main\n')

    # Agrega el cuerpo del código MIPS.
    mips_output.extend(mips_body)

    # Genera el código MIPS completo como una única cadena de texto.
    mips_code = '\n'.join(mips_output)

    print("--- MIPS CODE ---\n")
    print(mips_code)

    # Escribe el código MIPS en el archivo de salida.
    with open('output_2.asm', 'w') as mips_file:
        mips_file.write(mips_code)

    return mips_code
