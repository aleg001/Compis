class ThreeAddressCodeInstruction:
    def __init__(self, op, result=None, arg1=None, arg2=None):
        self.op = op
        self.result = result
        self.arg1 = arg1
        self.arg2 = arg2

    def __str__(self):
        if self.result:
            if self.arg1 and self.arg2:
                return f"{self.result} = {self.arg1} {self.op} {self.arg2}"
            elif self.arg1:
                return f"{self.result} = {self.op} {self.arg1}"
            else:
                return f"{self.result} = {self.op}"
        elif self.arg1:
            return f"{self.op} {self.arg1}"
        else:
            return f"{self.op}"


def generate_assignment_code(variable, value):
    return ThreeAddressCodeInstruction("=", variable, None, value)


def generate_binary_operation_code(op, result, arg1, arg2):
    return ThreeAddressCodeInstruction(op, result, arg1, arg2)


def generate_unary_operation_code(op, result, arg):
    return ThreeAddressCodeInstruction(op, result, arg, None)
