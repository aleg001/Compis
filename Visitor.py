# Generated from yapl.g4 by ANTLR 4.13.0
from antlr4 import *

if "." in __name__:
    from antlr_files.yaplParser import yaplParser
else:
    from antlr_files.yaplParser import yaplParser

from table import *

# This class defines a complete generic visitor for a parse tree produced by yaplParser.


class yaplVisitor(ParseTreeVisitor):
    def __init__(self):
        self.errores = []
        self.scope = []
        self.metodo_scope = []
        self.inherits = []
        self.tabla = Table()
        # print("Que onda desde el root")

    """ Agrupacion de todas las clases """

    # * Visit a parse tree produced by yaplParser#programas.

    def visitProgramas(self, ctx: yaplParser.ProgramasContext):
        return self.visitChildren(ctx)

    """ Visitando Clase """

    # * Se agrega a la tabla de simbolos
    # * En este punto se manejan nombres y registro de que clases heredan de que otras

    # Visit a parse tree produced by yaplParser#clase.
    def visitClase(self, ctx: yaplParser.ClaseContext):
        self.scope.append(ctx.TYPE(0).getText())
        self.metodo_scope.append(" ")
        inside = []
        # Clase que engloba las variables actualmente

        print("Scope ", self.scope)

        # Error si la clase ya fue declarada
        if self.tabla.is_in_table(ctx.TYPE(0).getText(), "self"):
            self.errores.append(f"{ctx.TYPE(0).getText()} ya declarada")

        features = ctx.feature()
        for x in features:
            if hasattr(x, "ID") and callable(getattr(x, "ID")):
                inside.append(x.ID().getText())
            elif (
                hasattr(x, "formal")
                and hasattr(x.formal(), "ID")
                and callable(getattr(x.formal(), "ID"))
            ):
                inside.append(x.formal().ID().getText())
                # print(x.formal().ID().getText())

        # Si la clase hereda simple
        if ctx.INHERITS():

            # Si es Main
            if ctx.TYPE(0).getText() == "Main" and ctx.TYPE(1).getText() != "IO":
                self.errores.append(f"{ctx.TYPE(0).getText()} solo hereda de IO")

            # Si hereda de una clase sin declarar
            if not ctx.TYPE(1).getText() == "IO":
                if not self.tabla.is_in_table(ctx.TYPE(1).getText(), "self"):
                    self.errores.append(
                        f"{ctx.TYPE(0).getText()} hereda de {ctx.TYPE(1).getText()} sin declarar"
                    )

            # Registro en la tabla de simbolos
            self.tabla.append_row(
                ctx.CLASS().getText(),
                ctx.TYPE(0).getText(),
                ctx.TYPE(1).getText(),
                "global",
                None,
                "self",
                inside,
            )

            self.inherits.append(ctx.TYPE(1).getText())

        else:
            self.tabla.append_row(
                ctx.CLASS().getText(),
                ctx.TYPE(0).getText(),
                None,
                "global",
                None,
                "self",
                inside,
            )
            self.inherits.append(" ")

        # self.scope.pop()

        if ctx.INHERITS() and ctx.TYPE(1).getText() in ["Int", "String", "Bool"]:
            self.errores.append(
                f"Cannot inherit from basic type: {ctx.TYPE(1).getText()}"
            )
        return self.visitChildren(ctx)

    """ Visita un metodo"""

    # * Se agrega a la tabla de simbolos

    # Visit a parse tree produced by yaplParser#metodo.
    def visitMetodo(self, ctx: yaplParser.MetodoContext):

        self.metodo_scope.append(ctx.ID().getText())
        # Variables asociadas al metodo
        inside = []

        # Parametros del metodo
        parametros = []
        formals = ctx.formal()

        # Variables usadas en el metodo
        used = []

        # Iteracion de clasificacion
        for x in formals:
            inside.append(x.ID().getText())

        # Si ya esta en la tabla en la misma clase
        if self.tabla.is_in_table(ctx.ID().getText(), self.scope[-1]):
            self.errores.append(
                f"{ctx.ID().getText()} ya definida dentro de {self.scope[-1]}"
            )

        # Si la clase en la que esta el metodo tiene herencia
        if self.inherits[-1] != " ":

            # Si la clase de la que esta haciendo herencia existe
            if self.tabla.is_in_table(self.inherits[-1], "self"):
                fila = self.tabla.fila(self.inherits[-1], "self")

                # Si el metodo es un override de los que existe dentro de la clase que hereda
                if ctx.ID().getText() in fila.inside:

                    """Comparacion de parametros entre metodos"""

                    # Parametros en metodo abstracto:
                    parametros_herdados = []

                    print("override")
                    # Comprobar los parametros
                    # print('')

                    # Comprobar el retorno

        self.tabla.append_row(
            ctx.TYPE().getText(),
            ctx.ID().getText(),
            None,
            "local",
            None,
            self.scope[-1],
            inside,
        )

        # Check if method is an override from inherited class
        current_class = self.scope[-1]
        inherited_class = self.inherits[-1]

        if inherited_class != " " and self.tabla.is_in_table(inherited_class, "self"):
            # If the inherited class has this method, validate the signature
            if self.tabla.is_in_table(ctx.ID().getText(), inherited_class):
                # TODO: Validate the method signature (parameters and return type)
                pass
        return self.visitChildren(ctx)

    """ Visita una asignacion de valores ( nombre <- expresion ) """

    # * Se le asigna el valor a una variable inicializada
    # * La inicializacion de variable puede estar ligada
    # * la asignacion debe de hacerce a una variable ya inicializada
    # * abajo de este punto son expresiones y formatos (Inicializaciones de variables)

    # Visit a parse tree produced by yaplParser#propiedad.
    def visitPropiedad(self, ctx: yaplParser.PropiedadContext):
        # self.tabla.append_row(
        #         ctx.formal().TYPE().getText(),
        #         ctx.formal().ID().getText(),
        #         None,
        #         'local',
        #         None,
        #         self.scope[-1],
        #         []
        # )
        return self.visitChildren(ctx)

    """ Visita una inicializacion de variable ( Nombre : Tipo ) """

    # * Inicializacion de una variable (Independientemente de donde)
    # * Va a la tabla
    # Visit a parse tree produced by yaplParser#asignacion.
    def visitAsignacion(self, ctx: yaplParser.AsignacionContext):
        print(f"visitando  {ctx.ID().getText()} {ctx.TYPE().getText()} ")
        print(self.scope)
        print(self.metodo_scope)

        relative_scope = []

        if self.metodo_scope[-1] == " ":
            relative_scope.append(self.scope[-1])
        else:
            relative_scope.append(self.scope[-1])
            relative_scope.append(self.metodo_scope[-1])

        self.tabla.append_row(
            ctx.TYPE().getText(),
            ctx.ID().getText(),
            None,
            "local",
            None,
            relative_scope,
            [],
        )

        # try:
        #     print("Contexto variable")
        #     print(self.scope[-1])
        #     print(self.metodo_scope[-1])
        #     self.tabla.append_row(
        #         ctx.TYPE().getText(),
        #         ctx.ID().getText(),
        #         None,
        #         'local',
        #         None,
        #         [self.scope[-1], self.metodo_scope[-1]],
        #         []
        #     )
        #     print(ctx.ID().getText())
        # except:
        #     print('EROR')
        #     print(ctx.ID().getText())

        # Validate type for assignment
        assigned_type = ctx.TYPE().getText()
        if assigned_type not in ["Int", "String", "Bool"]:
            if not self.tabla.is_in_table(assigned_type, "self"):
                self.errores.append(f"Undefined type: {assigned_type}")
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#new.
    def visitNew(self, ctx: yaplParser.NewContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#parentheses.
    def visitParentheses(self, ctx: yaplParser.ParenthesesContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#letIn.
    def visitLetIn(self, ctx: yaplParser.LetInContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#string.
    def visitString(self, ctx: yaplParser.StringContext):
        return "string"

    # Visit a parse tree produced by yaplParser#arithmetic1.
    def visitArithmetic1(self, ctx: yaplParser.Arithmetic1Context):

        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#isvoid.
    def visitIsvoid(self, ctx: yaplParser.IsvoidContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#assignment.
    def visitAssignment(self, ctx: yaplParser.AssignmentContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#arithmetic2.
    def visitArithmetic2(self, ctx: yaplParser.Arithmetic2Context):

        # left_type, valuel = self.visit(ctx.expr(0))
        # right_type, value2 = self.visit(ctx.expr(1))
        # print(left_type, valuel)
        # # print(left_type[1])

        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#while.
    def visitWhile(self, ctx: yaplParser.WhileContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#int.
    def visitInt(self, ctx: yaplParser.IntContext):
        return "int"

    # Visit a parse tree produced by yaplParser#dispatchImplicitB.
    def visitDispatchImplicitB(self, ctx: yaplParser.DispatchImplicitBContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#negative.
    def visitNegative(self, ctx: yaplParser.NegativeContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#boolNot.
    def visitBoolNot(self, ctx: yaplParser.BoolNotContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#boolean.
    def visitBoolean(self, ctx: yaplParser.BooleanContext):
        return "boolean"

    # Visit a parse tree produced by yaplParser#block.
    def visitBlock(self, ctx: yaplParser.BlockContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#comparisson.
    def visitComparisson(self, ctx: yaplParser.ComparissonContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#id.
    def visitId(self, ctx: yaplParser.IdContext):
        return "id", ctx.ID().getText()

    # Visit a parse tree produced by yaplParser#if.
    def visitIf(self, ctx: yaplParser.IfContext):
        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#dispatchExplicitA.
    def visitDispatchExplicitA(self, ctx: yaplParser.DispatchExplicitAContext):
        return self.visitChildren(ctx)

    def check_binary_operation(self, left_type, right_type, operation):
        valid_combinations = {
            "+": [("Int", "Int"), ("Bool", "Bool")],
            "-": [("Int", "Int")],
            "*": [("Int", "Int"), ("Bool", "Bool")],
            "/": [("Int", "Int")],
            "&&": [("Bool", "Bool")],
            "||": [("Bool", "Bool")],
        }

        if (left_type, right_type) in valid_combinations[operation]:

            if operation == "/" and right_type == 0:
                self.errores.append("Division by zero error.")
                return "Error"
            return left_type
        else:
            self.errores.append(
                f"Invalid operation: {operation} cannot be applied to {left_type} and {right_type}"
            )
            return "Error"

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
        return self.check_binary_operation(left_type, right_type, "/")

    def visitLogicalAND(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(left_type, right_type, "&&")

    def visitLogicalOR(self, ctx):
        left_type = self.visit(ctx.left)
        right_type = self.visit(ctx.right)
        return self.check_binary_operation(left_type, right_type, "||")

    def visitIf(self, ctx: yaplParser.IfContext):
        condition_type = self.visit(
            ctx.expr(0)
        )  # The first expr in the 'if' rule is the condition
        if condition_type != "Bool":
            self.errores.append(
                f"Expected boolean type in 'if' condition, got {condition_type} instead at line {ctx.start.line}"
            )

    def visitWhile(self, ctx: yaplParser.WhileContext):
        condition_type = self.visit(
            ctx.expr(0)
        )  # The first expr in the 'while' rule is the condition
        if condition_type != "Bool":
            self.errores.append(
                f"Expected boolean type in 'while' condition, got {condition_type} instead at line {ctx.start.line}"
            )
