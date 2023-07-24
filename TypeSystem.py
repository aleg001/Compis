class TypeSystem:
    def __init__(self):
        self.types = {"int": int, "bool": bool}

    def inferir(self, value):
        if type(value) is int:
            return "int"
        elif type(value) is bool:
            return "bool"
        else:
            raise TypeError(f"Desconocido: {type(value)}")

    def add_type(self, type_name, type):
        self.types[type_name] = type

    def get_type(self, type_name):
        return self.types.get(type_name, None)

    def add(self, operand1, operand2):
        if type(operand1) is int and type(operand2) is int:
            return operand1 + operand2
        else:
            raise TypeError("Los operandos deben ser enteros para la operación de suma")

    def subtract(self, operand1, operand2):
        if type(operand1) is int and type(operand2) is int:
            return operand1 - operand2
        else:
            raise TypeError(
                "Los operandos deben ser enteros para la operación de resta"
            )

    def and_op(self, operand1, operand2):
        if type(operand1) is bool and type(operand2) is bool:
            return operand1 and operand2
        else:
            raise TypeError("Los operandos deben ser booleanos para la operación 'and'")

    def or_op(self, operand1, operand2):
        if type(operand1) is bool and type(operand2) is bool:
            return operand1 or operand2
        else:
            raise TypeError("Los operandos deben ser booleanos para la operación 'or'")
