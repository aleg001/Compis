# Generated from yapl.g4 by ANTLR 4.13.0
from antlr4 import *

# Importing necessary modules and classes
if "." in __name__:
    from antlr_files.yaplParser import yaplParser
else:
    from antlr_files.yaplParser import yaplParser

from table import *

# This class defines a complete generic visitor for a parse tree produced by yaplParser.
class yaplVisitor(ParseTreeVisitor):
    def __init__(self):
        # Initialization of error list, scope, method scope, inheritance list, and symbol table
        self.errores = []
        self.scope = []
        self.metodo_scope = []
        self.inherits = []
        self.tabla = Table()

    # Grouping of all the classes

    # Visit a parse tree produced by yaplParser#programas.
    def visitProgramas(self, ctx: yaplParser.ProgramasContext):
        return self.visitChildren(ctx)

    # Visiting Class

    # Additional methods to check binary operations
    def check_binary_operation(
        self, left_type, right_type, operation, left_value=None, right_value=None
    ):
        valid_combinations = {
            "+": [("Int", "Int"), ("Bool", "Bool")],
            "-": [("Int", "Int")],
            "*": [("Int", "Int"), ("Bool", "Bool")],
            "/": [("Int", "Int")],
            "&&": [("Bool", "Bool")],
            "||": [("Bool", "Bool")],
        }

        if (left_type, right_type) in valid_combinations[operation]:
            # Additional check for division by zero
            if operation == "/" and right_value == 0:
                self.errores.append("Division by zero error.")
                return "Error"
            return left_type
        else:
            self.errores.append(
                f"Invalid operation: {operation} cannot be applied to {left_type} and {right_type}"
            )
            return "Error"

    # Visit methods for various arithmetic and logical operations

    def visitAddition(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(left_type, right_type, "+")

    def visitSubtraction(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(left_type, right_type, "-")

    def visitMultiplication(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(left_type, right_type, "*")

    def visitDivision(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(
            left_type,
            right_type,
            "/",
            left_value=ctx.left.value,
            right_value=ctx.right.value,
        )

    def visitLogicalAND(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(left_type, right_type, "&&")

    def visitLogicalOR(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(left_type, right_type, "||")
