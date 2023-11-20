# Generated from yapl.g4 by ANTLR 4.13.0
import time
from table import *
from tools import *
from antlr4 import *
import string



if "." in __name__:
    from antlr_files.yaplParser import yaplParser
else:
    from antlr_files.yaplParser import yaplParser

# This class defines a complete generic visitor for a parse tree produced by yaplParser.

class yaplVisitor(ParseTreeVisitor):

    def __init__(self, segundo = None):

        self.tabla_generada = segundo
        # * Primera pasada
        if self.tabla_generada == None:
            banner(" Generando tabla y verificando errores semanticos ")
            # * Sprint 1
            self.errores = []
            self.tabla = Table()

            # * Sprint 2
            self.scope = []
            self.inherits = []
            self.metodo_scope = []

            # * Clase IO
            self.tabla.append_row('class','IO',None,'global',None,'self',['out_string', 'x', 'out_int', 'x', 'in_string', 'in_int'])
            self.tabla.append_row(tipo = 'SELF_TYPE',nombre = 'out_string',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = ['x'])
            self.tabla.append_row(tipo = 'string',nombre = 'x',inherits = None,campo = 'local',tamanio = None,scope = ['IO', 'out_string'],inside = [])
            self.tabla.append_row(tipo = 'SELF_TYPE',nombre = 'out_int',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = ['x'])
            self.tabla.append_row(tipo = 'int',nombre = 'x',inherits = None,campo = 'local',tamanio = None,scope = ['IO', 'out_int'],inside = [])
            self.tabla.append_row(tipo = 'string',nombre = 'in_string',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = [])
            self.tabla.append_row(tipo = 'int',nombre = 'in_int',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = [])
        # * Segunda pasada
        else:

            # * TAGS
            self.while_tags = list(string.ascii_uppercase)
            self.if_tags = list(string.ascii_uppercase)
            self.block_tags = list(string.ascii_uppercase)

            # * Sprint 2
            self.scope = []
            self.inherits = []
            self.metodo_scope = []

            # * Temporales

            self.temporales      = []

            banner(" Tabla de simbolos ")
            self.tabla_generada.imprimiendo_tabla()
            banner(" Programacion Codigo Intermedio ")
            self.desarrollo = ''

    def agregar_tempporal(self):
        self.temporales.append('*')
        return f"t{len(self.temporales)-1}"

    def usar_tempporal(self):
        self.temporales = []
        return f"t{len(self.temporales)-1}"

    def agregar_a_desarrollo(self, texto):
        self.desarrollo += texto
    # Visit a parse tree produced by yaplParser#programas.
    def visitProgramas(self, ctx:yaplParser.ProgramasContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#clase.
    def visitClase(self, ctx:yaplParser.ClaseContext):

        if self.tabla_generada == None:

            # * Cambia el scope
            self.scope.append(ctx.TYPE(0).getText())
            self.metodo_scope.append(" ")

            # * Agregar a la tabla de simbolos
            herencia = None

            if (ctx.INHERITS()):
                herencia = ctx.TYPE(1).getText()

            self.tabla.append_row(
                tipo        = ctx.CLASS().getText(),
                nombre      = ctx.TYPE(0).getText(),
                inherits    = herencia,
                campo       = 'global',
                tamanio     = 0,
                scope       = 'self',
                inside      = []
            )
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            # * Cambia el scope
            self.scope.append(ctx.TYPE(0).getText())
            self.metodo_scope.append(" ")

            self.agregar_a_desarrollo(f"\n\nDECLARE CLASS {ctx.TYPE(0).getText()}")

            [self.visit(characteristic) for characteristic in ctx.feature()]

            self.agregar_a_desarrollo(f"\n\nFINISHING CLASS {ctx.TYPE(0).getText()}")






    # Visit a parse tree produced by yaplParser#propiedad.
    def visitPropiedad(self, ctx:yaplParser.PropiedadContext):

        if self.tabla_generada == None:

            # * SCOPE

            relative_scope = []

            if self.metodo_scope[-1] == " ":
                relative_scope.append(self.scope[-1])
            else:
                relative_scope.append(self.scope[-1])
                relative_scope.append(self.metodo_scope[-1])

            # * Visitando asignacion (formal)

            visitando_asignacion = self.visit(ctx.formal())

            # * Agregando a tabla y aumentando tamaño de los ambitos

            partners = []
            offset = 0
            if len(relative_scope) == 1:

                # * Agregando a clase
                self.tabla.fila(
                    nombre  = self.scope[-1],
                    scope   = 'self'
                ).inside.append(visitando_asignacion[0])

                # * Aumentando clase
                self.tabla.aumentar(
                    nombre  = self.scope[-1],
                    scope   = 'self',
                    aumento = visitando_asignacion[2]
                )

                # * Compañeros definidos
                partners = self.tabla.fila(
                    nombre  = self.scope[-1],
                    scope   = 'self'
                ).inside

                # * Offset
                if len(partners) == 1:
                    offset = 0
                else:
                    for x in partners[:-1]:
                        offset += self.tabla.fila(x, [self.scope[-1]]).tamanio

            else:

                # * Agregando a metodo
                self.tabla.fila(
                    nombre  = relative_scope[-1],
                    scope   = relative_scope[-2]
                ).inside.append(visitando_asignacion[0])

                # * Aumento clase y metodo
                self.tabla.aumentar(
                    nombre  = relative_scope[-1],
                    scope   = relative_scope[-2],
                    aumento = visitando_asignacion[2]
                )

                self.tabla.aumentar(
                    nombre  = self.scope[-1],
                    scope   = 'self',
                    aumento = visitando_asignacion[2]
                )

                # * Compañeros definidos
                partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside

                # * Offset
                if len(partners) == 1:
                    offset = 0
                else:
                    for x in partners[:-1]:

                        offset += self.tabla.fila(x, relative_scope).tamanio

            # * Agregando a tabla
            self.tabla.append_row(
                tipo        = visitando_asignacion[1],
                nombre      = visitando_asignacion[0],
                inherits    = None,
                campo       = 'local',
                tamanio     = visitando_asignacion[2],
                scope       = relative_scope,
                inside      = [],
                parametros  = [],
                offset      = offset
            )

            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            # * SCOPE

            relative_scope = []

            if self.metodo_scope[-1] == " ":
                relative_scope.append(self.scope[-1])
            else:
                relative_scope.append(self.scope[-1])
                relative_scope.append(self.metodo_scope[-1])

            # * DESPLAZAMIENTO

            if self.tabla_generada.is_in_table(ctx.formal().ID().getText(), relative_scope):

                desplazamiento = self.tabla_generada.fila(
                    nombre          =   ctx.formal().ID().getText(),
                    scope           =   relative_scope
                ).offset

                self.agregar_a_desarrollo(f"\n    {ctx.formal().TYPE().getText()} {ctx.formal().ID().getText()}\t\tEQUAL TO\tfp[{desplazamiento}]")


                visiting_assignment = None

                if ctx.expr() is not None:
                    visiting_assignment = self.visit(ctx.expr())

                if(visiting_assignment):
                    self.agregar_a_desarrollo(f"\n    fp[{desplazamiento}]\t=\t\t{visiting_assignment}")
                    self.usar_tempporal()

    # Visit a parse tree produced by yaplParser#metodo.
    def visitMetodo(self, ctx:yaplParser.MetodoContext):


        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:

            # * Cambia el scope
            self.metodo_scope.append(ctx.ID().getText())

            # * Cantidad de parametros que poseee
            parametros = []
            formals = ctx.formal()

            for x in formals:
                parametros.append((x.ID().getText(), x.TYPE().getText()))

            # * Agregar metodo a la tabla de simbolos
            self.tabla.append_row(
                tipo        = ctx.TYPE().getText(),
                nombre      = ctx.ID().getText(),
                inherits    = None,
                campo       = 'local',
                tamanio     = 0,
                scope       = self.scope[-1],
                inside      = [],
                parametros=parametros
            )

            # * Agregar el inside a donde pertenece
            class_im_in = self.tabla.fila(
                nombre  = self.scope[-1],
                scope   = 'self'
            )

            class_im_in.inside.append(ctx.ID().getText())

            # * Agregando parametros a la tabla de simbolos:

            if hasattr(ctx, 'formal') and callable(getattr(ctx, 'formal')):
                parameter_declaration = ctx.formal()

                for parameter in parameter_declaration:

                    # * SCOPE Parametro

                    relative_scope = []

                    if self.metodo_scope[-1] == " ":
                        relative_scope.append(self.scope[-1])
                    else:
                        relative_scope.append(self.scope[-1])
                        relative_scope.append(self.metodo_scope[-1])

                    # * Visitando asignacion (formal)

                    visitando_asignacion = self.visit(parameter)

                    # * Agregando a tabla y aumentando tamaño de los ambitos

                    partners = []
                    offset = 0
                    if len(relative_scope) == 1:

                        # * Agregando a clase
                        self.tabla.fila(
                            nombre  = self.scope[-1],
                            scope   = 'self'
                        ).inside.append(visitando_asignacion[0])

                        # * Aumentando clase
                        self.tabla.aumentar(
                            nombre  = self.scope[-1],
                            scope   = 'self',
                            aumento = visitando_asignacion[2]
                        )

                        # * Compañeros definidos
                        partners = self.tabla.fila(
                            nombre  = self.scope[-1],
                            scope   = 'self'
                        ).inside

                        # * Offset
                        if len(partners) == 1:
                            offset = 0
                        else:
                            for x in partners[:-1]:
                                offset += self.tabla.fila(x, [self.scope[-1]]).tamanio

                    else:

                        # * Agregando a metodo
                        self.tabla.fila(
                            nombre  = relative_scope[-1],
                            scope   = relative_scope[-2]
                        ).inside.append(visitando_asignacion[0])

                        # * Aumento clase y metodo
                        self.tabla.aumentar(
                            nombre  = relative_scope[-1],
                            scope   = relative_scope[-2],
                            aumento = visitando_asignacion[2]
                        )

                        self.tabla.aumentar(
                            nombre  = self.scope[-1],
                            scope   = 'self',
                            aumento = visitando_asignacion[2]
                        )

                        # * Compañeros definidos
                        partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside

                        # * Offset
                        if len(partners) == 1:
                            offset = 0
                        else:
                            for x in partners[:-1]:

                                offset += self.tabla.fila(x, relative_scope).tamanio

                    # * Agregando a tabla
                    self.tabla.append_row(
                        tipo        = visitando_asignacion[1],
                        nombre      = visitando_asignacion[0],
                        inherits    = None,
                        campo       = 'local',
                        tamanio     = visitando_asignacion[2],
                        scope       = relative_scope,
                        inside      = [],
                        parametros  = [],
                        offset      = offset
                    )
            return self.visitChildren(ctx)

        # ! CODIGO INTERMEDIO
        else:
            # * Cambia el scope
            self.metodo_scope.append(ctx.ID().getText())
            self.agregar_a_desarrollo(f"\n\n    FUNCTION {ctx.ID().getText()}\n")

            parameter_methods = ctx.formal()

            for parameter in parameter_methods:
                # * SCOPE
                relative_scope = [self.scope[-1]]
                if self.metodo_scope[-1] != " ":
                    relative_scope.append(self.metodo_scope[-1])

                # * DESPLAZAMIENTO

                if self.tabla_generada.is_in_table(parameter.ID().getText(), relative_scope):

                    desplazamiento = self.tabla_generada.fila(
                        nombre          =   parameter.ID().getText(),
                        scope           =   relative_scope
                    ).offset

                    self.agregar_a_desarrollo(f"\n    AS PARAMETER")
                    self.agregar_a_desarrollo(f"\n    {parameter.TYPE().getText()} {parameter.ID().getText()}\t\tEQUAL TO\tfp[{desplazamiento}]")
            self.agregar_a_desarrollo(f"\n")
            from antlr_files.yaplParser import yaplParser as MiAlias
            if isinstance(ctx.expr(), MiAlias.IdContext) or isinstance(ctx.expr(), MiAlias.IntContext) or isinstance(ctx.expr(), MiAlias.StringContext):
                self.agregar_a_desarrollo(f"\n        {self.visit(ctx.expr())}")

            self.visit(ctx.expr())


            self.agregar_a_desarrollo(f"\n\n    FINISHING FUNCTION {ctx.ID().getText()}")



    # Visit a parse tree produced by yaplParser#asignacion.
    def visitAsignacion(self, ctx:yaplParser.AsignacionContext):

        id      = ctx.ID().getText()
        tipo    = ctx.TYPE().getText()
        tamanio = 0

        if tipo == 'Int':
            tamanio = 4
        elif tipo == 'String':
            tamanio = 8
        elif tipo == 'Bool':
            tamanio = 2
        else:
            tamanio = 16


        return id, tipo, tamanio


    # Visit a parse tree produced by yaplParser#new.
    def visitNew(self, ctx:yaplParser.NewContext):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:

            temporal_new = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n        {temporal_new} = NEW {ctx.TYPE().getText()}")
            return temporal_new



    # Visit a parse tree produced by yaplParser#parentheses.
    def visitParentheses(self, ctx:yaplParser.ParenthesesContext):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            return self.visit(ctx.expr())


    # Visit a parse tree produced by yaplParser#letIn.
    def visitLetIn(self, ctx:yaplParser.LetInContext):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:

            # * Agregan declaraciones en la tabla de simbolos:
            let_in_statements = ctx.formal()

            for statement in let_in_statements:

                    # * SCOPE Parametro

                    relative_scope = []

                    if self.metodo_scope[-1] == " ":
                        relative_scope.append(self.scope[-1])
                    else:
                        relative_scope.append(self.scope[-1])
                        relative_scope.append(self.metodo_scope[-1])

                    # * Visitando asignacion (formal)

                    visitando_asignacion = self.visit(statement)

                    # * Agregando a tabla y aumentando tamaño de los ambitos

                    partners = []
                    offset = 0
                    if len(relative_scope) == 1:

                        # * Agregando a clase
                        self.tabla.fila(
                            nombre  = self.scope[-1],
                            scope   = 'self'
                        ).inside.append(visitando_asignacion[0])

                        # * Aumentando clase
                        self.tabla.aumentar(
                            nombre  = self.scope[-1],
                            scope   = 'self',
                            aumento = visitando_asignacion[2]
                        )

                        # * Compañeros definidos
                        partners = self.tabla.fila(
                            nombre  = self.scope[-1],
                            scope   = 'self'
                        ).inside

                        # * Offset
                        if len(partners) == 1:
                            offset = 0
                        else:
                            for x in partners[:-1]:
                                offset += self.tabla.fila(x, [self.scope[-1]]).tamanio

                    else:

                        # * Agregando a metodo
                        self.tabla.fila(
                            nombre  = relative_scope[-1],
                            scope   = relative_scope[-2]
                        ).inside.append(visitando_asignacion[0])

                        # * Aumento clase y metodo
                        self.tabla.aumentar(
                            nombre  = relative_scope[-1],
                            scope   = relative_scope[-2],
                            aumento = visitando_asignacion[2]
                        )

                        self.tabla.aumentar(
                            nombre  = self.scope[-1],
                            scope   = 'self',
                            aumento = visitando_asignacion[2]
                        )

                        # * Compañeros definidos
                        partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside

                        # * Offset
                        if len(partners) == 1:
                            offset = 0
                        else:
                            for x in partners[:-1]:

                                offset += self.tabla.fila(x, relative_scope).tamanio

                    # * Agregando a tabla
                    self.tabla.append_row(
                        tipo        = visitando_asignacion[1],
                        nombre      = visitando_asignacion[0],
                        inherits    = None,
                        campo       = 'local',
                        tamanio     = visitando_asignacion[2],
                        scope       = relative_scope,
                        inside      = [],
                        parametros  = [],
                        offset      = offset
                    )

            return self.visitChildren(ctx)

        # ! CODIGO INTERMEDIO
        else:
            self.agregar_a_desarrollo(f"\n        LET")

            # * SCOPE
            relative_scope = [self.scope[-1]]
            if self.metodo_scope[-1] != " ":
                relative_scope.append(self.metodo_scope[-1])

            # * VISITANDO Propiedades

            # let_in_formals = ctx.formal()
            # let_in_expr = ctx.expr()[:-1]

            # for ind_formal, ind_expr in zip(let_in_formals, let_in_expr):

            #     if self.tabla_generada.is_in_table(ind_formal.ID().getText(), relative_scope):

            #         desplazamiento = self.tabla_generada.fila(
            #             nombre          =   ind_formal.ID().getText(),
            #             scope           =   relative_scope
            #         ).offset

            #         self.agregar_a_desarrollo(f"\n        {ind_formal.ID().getText()}\t\tEQUAL TO\tfp[{desplazamiento}]")
            #         self.agregar_a_desarrollo(f"\n        fp[{desplazamiento}] = {self.visit(ind_expr)}")

            let_in_formals = ctx.formal()
            # let_in_expr = ctx.expr()[:-1]

            for ind_formal in let_in_formals:

                if self.tabla_generada.is_in_table(ind_formal.ID().getText(), relative_scope):

                    desplazamiento = self.tabla_generada.fila(
                        nombre          =   ind_formal.ID().getText(),
                        scope           =   relative_scope
                    ).offset

                    self.agregar_a_desarrollo(f"\n      {ind_formal.TYPE().getText()}  {ind_formal.ID().getText()}\t\tEQUAL TO\tfp[{desplazamiento}]")
                    # self.agregar_a_desarrollo(f"\n        fp[{desplazamiento}] = {self.visit(ind_expr)}")

            # * Visitando expr dentro de IN
            self.agregar_a_desarrollo(f"\n        IN\n")
            let_in_expresions = ctx.expr()

            self.visit(let_in_expresions[-1])



    # Visit a parse tree produced by yaplParser#string.
    def visitString(self, ctx:yaplParser.StringContext):

        cadena = ctx.STRING().getText()

        return cadena


    # Visit a parse tree produced by yaplParser#arithmetic1.
    def visitArithmetic1(self, ctx:yaplParser.Arithmetic1Context):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            pass
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            # print(ctx.getText())
            valor_left    = self.visit(ctx.expr(0))
            valor_right   = self.visit(ctx.expr(1))

            # # * Si hijos no son temporales
            # if valor_left[0] != 't' and valor_right[0] != 't':
            #     using_t = self.agregar_tempporal()
            #     self.agregar_a_desarrollo(f"\n    {using_t}\t\t=\t\t{valor_left} {ctx.op.text} {valor_right}")
            #     return using_t
            # # * Si hijo izquierdo temporal
            # if valor_left.startswith("t"):
            #     using_t = self.agregar_tempporal()
            #     self.agregar_a_desarrollo(f"\n    {using_t}\t\t=\t\t{valor_left} {ctx.op.text} {valor_right}")
            #     return using_t
            using_t = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n    {using_t}\t\t=\t\t{valor_left} {ctx.op.text} {valor_right}")
            return using_t
    # Visit a parse tree produced by yaplParser#arithmetic2.
    def visitArithmetic2(self, ctx:yaplParser.Arithmetic2Context):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            pass
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            # print(ctx.getText())
            valor_left    = self.visit(ctx.expr(0))
            valor_right   = self.visit(ctx.expr(1))


            # # * Si hijos no son temporales
            # if valor_left[0] != 't' and valor_right[0] != 't':
            #     using_t = self.agregar_tempporal()
            #     self.agregar_a_desarrollo(f"\n    {using_t}\t\t=\t\t{valor_left} {ctx.op.text} {valor_right}")
            #     return using_t
            # # * Si hijo izquierdo temporal
            # if valor_left.startswith("t"):
            #     using_t = self.agregar_tempporal()
            #     self.agregar_a_desarrollo(f"\n    {using_t}\t\t=\t\t{valor_left} {ctx.op.text} {valor_right}")
            #     return using_t
            using_t = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n    {using_t}\t\t=\t\t{valor_left} {ctx.op.text} {valor_right}")
            return using_t


    # Visit a parse tree produced by yaplParser#isvoid.
    def visitIsvoid(self, ctx:yaplParser.IsvoidContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#assignment.
    def visitAssignment(self, ctx:yaplParser.AssignmentContext):

        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        else:
            # * SCOPE

            relative_scope = []

            if self.metodo_scope[-1] == " ":
                relative_scope.append(self.scope[-1])
            else:
                relative_scope.append(self.scope[-1])
                relative_scope.append(self.metodo_scope[-1])

            # * DESPLAZAMIENTO
            name_displacement = ""
            if self.tabla_generada.is_in_table(ctx.ID().getText(), relative_scope):

                desplazamiento = self.tabla_generada.fila(
                    nombre          =   ctx.ID().getText(),
                    scope           =   relative_scope
                ).offset

                name_displacement = f"fp[{desplazamiento}]"

            elif self.tabla_generada.is_in_table(ctx.ID().getText(), [self.scope[-1]]):
                desplazamiento = self.tabla_generada.fila(
                    nombre          =   ctx.ID().getText(),
                    scope           =   [self.scope[-1]]
                ).offset

                name_displacement = f"fp[{desplazamiento}]"

            self.agregar_a_desarrollo(f"\n        {name_displacement} = {self.visit(ctx.expr())}")
            return (" ")






    # Visit a parse tree produced by yaplParser#int.
    def visitInt(self, ctx:yaplParser.IntContext):

        # numero = ctx.INT().getText()

        return ctx.INT().getText()




    # Visit a parse tree produced by yaplParser#negative.
    def visitNegative(self, ctx:yaplParser.NegativeContext):

        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:

            temporal_negativ = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n              {temporal_negativ} = ~ {self.visit(ctx.expr())}")
            return temporal_negativ



    # Visit a parse tree produced by yaplParser#boolNot.
    def visitBoolNot(self, ctx:yaplParser.BoolNotContext):

        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:

            temporal_negativ = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n              {temporal_negativ} = ! {self.visit(ctx.expr())}")
            return temporal_negativ


    # Visit a parse tree produced by yaplParser#boolean.
    def visitBoolean(self, ctx:yaplParser.BooleanContext):

        booleano = None

        if (ctx.getText()[0] == 't'):
            booleano = 1
        else:
            booleano = 0

        return booleano


    # Visit a parse tree produced by yaplParser#block.
    def visitBlock(self, ctx:yaplParser.BlockContext):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            tag_block = self.block_tags.pop(0)
            self.agregar_a_desarrollo(f"\n        INIT BLOCK_{tag_block}")
            [self.visit(expr) for expr in ctx.expr()]
            self.agregar_a_desarrollo(f"\n        FINISHING BLOCK_{tag_block}")
            return f"BLOCK_{tag_block}"


    # Visit a parse tree produced by yaplParser#comparisson.
    def visitComparisson(self, ctx:yaplParser.ComparissonContext):

        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            pass
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            # print(ctx.getText())
            valor_left    = self.visit(ctx.expr(0))
            valor_right   = self.visit(ctx.expr(1))


            # # * Si hijos no son temporales
            # if valor_left[0] != 't' and valor_right[0] != 't':
            #     using_t = self.agregar_tempporal()
            #     self.agregar_a_desarrollo(f"\n        {using_t}\t\t Comparisson \t\t{valor_left} {ctx.op.text} {valor_right}")
            #     return using_t
            # # * Si hijo izquierdo temporal
            # if valor_left.startswith("t"):
            using_t = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n        {using_t}\t\t Comparisson \t\t{valor_left} {ctx.op.text} {valor_right}")
            return using_t



    # Visit a parse tree produced by yaplParser#id.
    def visitId(self, ctx:yaplParser.IdContext):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:
            # * SCOPE

            relative_scope = []

            if self.metodo_scope[-1] == " ":
                relative_scope.append(self.scope[-1])
            else:
                relative_scope.append(self.scope[-1])
                relative_scope.append(self.metodo_scope[-1])

            # * DESPLAZAMIENTO

            if self.tabla_generada.is_in_table(ctx.ID().getText(), relative_scope):

                desplazamiento = self.tabla_generada.fila(
                    nombre          =   ctx.ID().getText(),
                    scope           =   relative_scope
                ).offset

                name_displacement = f"fp[{desplazamiento}]"
                return name_displacement

            elif self.tabla_generada.is_in_table(ctx.ID().getText(), [self.scope[-1]]):
                desplazamiento = self.tabla_generada.fila(
                    nombre          =   ctx.ID().getText(),
                    scope           =   [self.scope[-1]]
                ).offset

                name_displacement = f"fp[{desplazamiento}]"
                return name_displacement

            elif ctx.ID().getText() == 'self':
                return 'self'

            return "NO ENCONTRADO ID"



    # Visit a parse tree produced by yaplParser#if.
    def visitIf(self, ctx:yaplParser.IfContext):
        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        # ! CODIGO INTERMEDIO
        else:

            TAG = self.if_tags.pop(0)
            # * Visitando primer expr
            self.agregar_a_desarrollo(f"\n        ")
            expr_1 = self.visit(ctx.expr(0))
            self.agregar_a_desarrollo(f"\n        IF_{TAG} {expr_1} GO TO THEN_{TAG}")
            self.agregar_a_desarrollo(f"\n        ")

            self.usar_tempporal()

            # * Visitando segundo expr
            self.agregar_a_desarrollo(f"\n        THEN_{TAG}:")
            self.agregar_a_desarrollo(f"\n        {self.visit(ctx.expr(1))}")
            self.agregar_a_desarrollo(f"\n        ")
            self.usar_tempporal()

            # * Visitando tercer expr
            self.agregar_a_desarrollo(f"\n        ELSE_{TAG}:")
            self.agregar_a_desarrollo(f"\n        {self.visit(ctx.expr(2))}")
            self.agregar_a_desarrollo(f"\n        FI (ENDING IF)")

            self.usar_tempporal()

            return f"IF_{TAG}"


    # Visit a parse tree produced by yaplParser#while.
    def visitWhile(self, ctx:yaplParser.WhileContext):
        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        else:

            TAG = self.while_tags.pop(0)
            # * Visitando primer expr
            self.agregar_a_desarrollo(f"\n        ")
            # expr_1 =
            self.agregar_a_desarrollo(f"\n        WHILE_{TAG} {self.visit(ctx.expr(0))} GO TO LOOP_{TAG}")
            self.agregar_a_desarrollo(f"\n        ")

            self.usar_tempporal()

            # * Visitando segundo expr
            self.agregar_a_desarrollo(f"\n        LOOP_{TAG}:")
            self.agregar_a_desarrollo(f"\n        {self.visit(ctx.expr(1))}")
            self.agregar_a_desarrollo(f"\n        JUMP WHILE_{TAG}:")
            self.agregar_a_desarrollo(f"\n        ")

            self.usar_tempporal()

            # * Visitando tercer expr
            self.agregar_a_desarrollo(f"\n        FINISH WHILE_{TAG}:")
            self.usar_tempporal()

            return f"WHILE_{TAG}"



    # Visit a parse tree produced by yaplParser#dispatchExplicitA.
    def visitDispatchExplicitA(self, ctx:yaplParser.DispatchExplicitAContext):

        # * Errores semanticos y generacion de tabla
        if self.tabla_generada == None:
            return self.visitChildren(ctx)

        # ! CODIGO INTERMEDIO
        else:
            # * Parametros
            instance_call_method_parameters = ctx.expr()[1:]
            for parameter in instance_call_method_parameters:
                temporal = self.visit(parameter)
                self.agregar_a_desarrollo(f"\n        PUSHING {temporal}")
                self.usar_tempporal()
            instance_call_method_temporal = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n        CALLING {self.visit(ctx.expr(0))}.{ctx.ID().getText()} POP {len(instance_call_method_parameters)} AS {instance_call_method_temporal}")
            self.usar_tempporal()
            return instance_call_method_temporal



    # Visit a parse tree produced by yaplParser#dispatchImplicitB.
    def visitDispatchImplicitB(self, ctx:yaplParser.DispatchImplicitBContext):

        if self.tabla_generada == None:
            return self.visitChildren(ctx)
        else:
            method_call_parameters = ctx.expr()

            for parameter in method_call_parameters:
                temporal = self.visit(parameter)
                self.agregar_a_desarrollo(f"\n        PUSHING {temporal}")
            method_call_temporal = self.agregar_tempporal()
            self.agregar_a_desarrollo(f"\n        CALLING {ctx.ID().getText()} POP {len(method_call_parameters)} AS {method_call_temporal}")
            return method_call_temporal



del yaplParser