import re


def are_lists_of_tuples_equal(list1, list2):
    if len(list1) != len(list2):
        return False

    for tuple1, tuple2 in zip(list1, list2):
        if tuple1 != tuple2:
            return False

    return True


def banner(header, row_jumps=False):
    print()
    value = 120
    banner = "{:─^120}".format(header)

    print(f'{"─"*value}')

    if row_jumps:
        print(f"\n{banner}\n")
    else:
        print(f"{banner}")
    print(f'{"─"*value}\n')


def contar_apariciones(texto, subcadena):
    """
    Esta función recibe dos strings como parámetros y devuelve la cantidad de veces
    que aparece la segunda string en la primera.

    :param texto: El string en el que se buscará la subcadena.
    :param subcadena: La subcadena que se buscará en el texto.
    :return: La cantidad de veces que aparece la subcadena en el texto (0 si no aparece).
    """
    # Usamos el método count() para contar las apariciones de la subcadena en el texto.
    contador = texto.count(subcadena)
    return contador


def infix_to_postfix(expression):
    precedence = {"<": 1, "=": 1, "+": 1, "-": 1, "*": 2, "/": 2, "^": 3}
    output = []
    stack = []

    for token in expression:
        if token not in "+-*/<=":
            output.append(token)
        elif token in "+-*/<=":
            while (
                stack
                and stack[-1] in "+-*/<="
                and precedence[token] <= precedence[stack[-1]]
            ):
                output.append(stack.pop())
            stack.append(token)
        elif token == "(":
            stack.append(token)
        elif token == ")":
            while stack and stack[-1] != "(":
                output.append(stack.pop())
            stack.pop()  # Pop '('

    while stack:
        output.append(stack.pop())

    return output


def is_operand(token):
    return token.isdigit()


def generate_temp():
    global temp_count
    temp_name = f"t{temp_count}"
    temp_count += 1
    return temp_name


def process_postfix(expression):
    stack = []
    temp_assignments = []
    temp_assignments_arrays = []
    global temp_count
    temp_count = 0

    for token in expression:
        # if is_operand(token):
        if token not in "+-*/<=":
            stack.append(token)
        else:
            operand2 = stack.pop()
            operand1 = stack.pop()
            temp = generate_temp()
            operation = f"{temp} = {operand1} {token} {operand2}"
            operation2 = [temp, operand1, token, operand2]
            stack.append(temp)
            temp_assignments.append(operation)
            temp_assignments_arrays.append(operation2)

    return temp_assignments_arrays


label_count = 0


def generate_label():
    global label_count
    label_name = f"L{label_count}"
    label_count += 1
    return label_name
