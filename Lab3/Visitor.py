# Generated from yapl.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from antlr_files.yaplParser import yaplParser
else:
    from antlr_files.yaplParser import yaplParser
import time
from table import *
from tools import *
# This class defines a complete generic visitor for a parse tree produced by yaplParser.

class yaplVisitor(ParseTreeVisitor):

    def __init__(self):
        self.errores = []
        self.scope = []
        self.metodo_scope = []
        self.inherits = []
        self.tabla = Table()

        self.tabla.append_row('class','IO',None,'global',None,'self',['out_string', 'x', 'out_int', 'x', 'in_string', 'in_int'])

        self.tabla.append_row(tipo = 'SELF_TYPE',nombre = 'out_string',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = ['x'])

        self.tabla.append_row(tipo = 'string',nombre = 'x',inherits = None,campo = 'local',tamanio = None,scope = ['IO', 'out_string'],inside = [])

        self.tabla.append_row(tipo = 'SELF_TYPE',nombre = 'out_int',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = ['x'])

        self.tabla.append_row(tipo = 'int',nombre = 'x',inherits = None,campo = 'local',tamanio = None,scope = ['IO', 'out_int'],inside = [])

        self.tabla.append_row(tipo = 'string',nombre = 'in_string',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = [])

        self.tabla.append_row(tipo = 'int',nombre = 'in_int',inherits = None,campo = 'local',tamanio = None,scope = 'IO',inside = [])
        # # # print("Que onda desde el root")


    # * Inicio de todo el programa
    def visitProgramas(self, ctx:yaplParser.ProgramasContext):
        return self.visitChildren(ctx)


    # * Visitando los nodos de clase
    def visitClase(self, ctx:yaplParser.ClaseContext):
        self.scope.append(ctx.TYPE(0).getText())
        self.metodo_scope.append(" ")

        # ! CODIGO INTERMEDIO CLASE
        print(f"\nDECLARE CLASS {ctx.TYPE(0).getText()}")

        # * Metodos y propiedades que estan dentro de la clase
        inside = []

        # * Se verifica si ya esta declarada
        if self.tabla.is_in_table(ctx.TYPE(0).getText(),'self'):
            self.errores.append(f' > {ctx.TYPE(0).getText()} ya declarada')

        # features = ctx.feature()
        # for x in features:
        #     if hasattr(x, 'ID') and callable(getattr(x, 'ID')):
        #         inside.append(x.ID().getText())
        #     elif hasattr(x, 'formal') and hasattr(x.formal(), 'ID') and callable(getattr(x.formal(), 'ID')):
        #         inside.append(x.formal().ID().getText())
        print()

        # * Si la clase hereda simple
        if (ctx.INHERITS()):

            characteristics = self.tabla.in_scope(ctx.TYPE(1).getText())

            for element in characteristics:
                print(f"    IMPORT FROM {ctx.TYPE(1).getText()}\t->\t{element.nombre}")
            print()
            if( ctx.TYPE(0).getText() == 'Main' and ctx.TYPE(1).getText() != 'IO'):
                self.errores.append(f' > {ctx.TYPE(0).getText()} solo hereda de IO')
            if( ctx.TYPE(0).getText() == 'Main' and ctx.TYPE(1).getText() == 'IO'):
                pass

            if not ctx.TYPE(1).getText() == 'IO':
                if not self.tabla.is_in_table(ctx.TYPE(1).getText(),'self'):
                    self.errores.append(f' > {ctx.TYPE(0).getText()} hereda de {ctx.TYPE(1).getText()} sin declarar')

            # ! TABLA DE SIMBOLOS
            self.tabla.append_row(ctx.CLASS().getText(),ctx.TYPE(0).getText(),ctx.TYPE(1).getText(),'global',0,'self',[])
            self.inherits.append(ctx.TYPE(1).getText())

        else:
            # ! TABLA DE SIMBOLOS
            self.tabla.append_row(ctx.CLASS().getText(),ctx.TYPE(0).getText(),None,'global',0,'self',[])
            self.inherits.append(" ")

        return self.visitChildren(ctx)



    # * Visitando los nodos de metodos
    def visitMetodo(self, ctx:yaplParser.MetodoContext):

        # ! CODIGO INTERMEDIO
        print(f"\n    FUNCTION {ctx.ID().getText()}")

        # * SCOPE
        self.metodo_scope.append(ctx.ID().getText())

        inside = []
        parametros = []
        formals = ctx.formal()

        for x in formals:
            parametros.append((x.ID().getText(), x.TYPE().getText()))
            inside.append(x.ID().getText())

        # Si ya esta en la tabla en la misma clase
        if self.tabla.is_in_table(ctx.ID().getText(), self.scope[-1]):
            self.errores.append(f' > {ctx.ID().getText()} ya definida dentro de {self.scope[-1]}')

        # Si la clase en la que esta el metodo tiene herencia
        if self.inherits[-1] != " ":

            # Si la clase de la que esta haciendo herencia existe
            if self.tabla.is_in_table(self.inherits[-1], 'self'):

                # # # print("\noverride\n")
                fila = self.tabla.fila(self.inherits[-1], 'self')
                # # # print(fila)
                # Si el metodo es un override de los que existe dentro de la clase que hereda
                if ctx.ID().getText() in fila.inside:
                    # # # print(f" Estudianddo metodo {ctx.ID().getText()}\n")
                    # # # print("\n Parametros: ", parametros, " \n")
                    # # # print("\n Parametros: ", type(parametros), " \n")
                    fila_metodo_abstracto = self.tabla.fila(ctx.ID().getText(), fila.nombre)
                    # # # print(fila_metodo_abstracto.parametros)
                    # # # print(type(fila_metodo_abstracto.parametros))
                    # # # print(are_lists_of_tuples_equal(fila_metodo_abstracto.parametros, parametros))
                    if are_lists_of_tuples_equal(fila_metodo_abstracto.parametros, parametros) == False:
                        # # print('entro')
                        self.errores.append(f' > Metodo {ctx.ID().getText()} en {self.scope[-1]} no tiene la misma firma que en la clase {fila.nombre}')
                    if ctx.TYPE().getText() != fila_metodo_abstracto.tipo:
                        self.errores.append(f' > Metodo {ctx.ID().getText()} en {self.scope[-1]} no tiene lo mismo que metodo en {fila.nombre}')


        # ! TABLA DE SIMBOLOS
        self.tabla.append_row(ctx.TYPE().getText(),ctx.ID().getText(),None,'local',0,self.scope[-1],[],parametros)
        self.tabla.fila(self.scope[-1], 'self').inside.append(ctx.ID().getText())

        """ DECLARACIONES DE METODOS """
        """ Parametros """
        if hasattr(ctx, 'formal') and callable(getattr(ctx, 'formal')):

            # print("\n        AS PARAMETERS\n")
            x =  ctx.formal()
            for declaracion in x:
                # print(declaracion.ID().getText())
                # print(declaracion.TYPE().getText())
                # banner("PARAMETRO")

                # ! CODIGO INTERMEDIO

                """ Calculo Externo de Offset """

                relative_scope = []

                if self.metodo_scope[-1] == " ":
                    relative_scope.append(self.scope[-1])
                else:
                    relative_scope.append(self.scope[-1])
                    relative_scope.append(self.metodo_scope[-1])

                """ Tamaño """

                tamanio = 0
                if declaracion.TYPE().getText() == 'Int':
                    tamanio = 4
                elif declaracion.TYPE().getText() == 'String':
                    tamanio = 8
                elif declaracion.TYPE().getText() == 'Boolean':
                    tamanio = 2
                else:
                    tamanio = 16

                """ Offset """

                partners = []
                offset = 0
                if len(relative_scope) == 1:
                    self.tabla.fila(self.scope[-1], 'self').inside.append(declaracion.ID().getText())
                    self.tabla.aumentar(self.scope[-1], 'self', tamanio)
                    partners = self.tabla.fila(self.scope[-1], 'self').inside

                    if len(partners) == 1:
                        offset = 0
                    else:
                        for x in partners[:-1]:
                            offset += self.tabla.fila(x, [self.scope[-1]]).tamanio

                if len(relative_scope) > 1:
                    self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside.append(declaracion.ID().getText())
                    self.tabla.aumentar(relative_scope[-1], relative_scope[-2], tamanio)
                    self.tabla.aumentar(self.scope[-1], 'self', tamanio)
                    partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside

                    if len(partners) == 1:
                        offset = 0
                    else:
                        for x in partners[:-1]:
                            # # print(x)
                            offset += self.tabla.fila(x, relative_scope).tamanio

                # ! TABLA DE SIMBOLOS
                self.tabla.append_row(declaracion.TYPE().getText(),declaracion.ID().getText(),None,'local',tamanio,relative_scope,[],[],offset)

                # ! CODIGO INTERMEDIO
                print("\n        AS PARAMETER:\n")
                print(f"        {declaracion.ID().getText()}\tEQUAL TO\tfp[{offset}]")

        # ! EXPRESIONS DENTRO DEL METODO

        expr_ctx = ctx.expr()

        # * Hello World!
        if isinstance(expr_ctx, yaplParser.DispatchImplicitBContext):
            # * de IO
            metodos_especiales =['out_string', 'x', 'out_int', 'x', 'in_string', 'in_int']
            if(expr_ctx.ID().getText() in metodos_especiales):
                mini_expr = expr_ctx.expr()
                for xxxx in mini_expr:
                    if isinstance(xxxx, yaplParser.StringContext):
                        print(f"        t0 = {xxxx.STRING().getText()}")
                        print(f"        PUSH t0")
                        print(f"        CALLING {expr_ctx.ID().getText()} POP LAST")
        if isinstance(expr_ctx, yaplParser.DispatchExplicitAContext):

            externo = None
            primer_nivel = self.visit(expr_ctx)
            pusheados = 0
            for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                # time.sleep(0.4)
                if indice != 0:
                    """ Calculo Externo de Offset """
                    relative_scope = []
                    if self.metodo_scope[-1] == " ":
                        relative_scope.append(self.scope[-1])
                    else:
                        relative_scope.append(self.scope[-1])
                        relative_scope.append(self.metodo_scope[-1])
                    if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                        informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                        externo = f"fp[{informacion_fila.offset}]"
                        print(f"        t0 = {externo}")
                        pusheados += 1
                        print(f"        PUSH t0")
                    elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                        informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                        externo = f"fp[{informacion_fila.offset}]"
                        print(f"        t0 = {externo}")
                        pusheados += 1
                        print(f"        PUSH t0")
                    else:
                        print(f"        t0 = {parametrito.getText()}")
                        pusheados += 1
                        print(f"        PUSH t0")
            for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                # time.sleep(0.4)
                if indice == 0:
                    """ Calculo Externo de Offset """
                    relative_scope = []
                    if self.metodo_scope[-1] == " ":
                        relative_scope.append(self.scope[-1])
                    else:
                        relative_scope.append(self.scope[-1])
                        relative_scope.append(self.metodo_scope[-1])
                    if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                        informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                        externo = f"fp[{informacion_fila.offset}]"
                        print(f"        t0 = {externo}")
                        # print(f"        PUSH t0")
                    elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                        informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                        externo = f"fp[{informacion_fila.offset}]"
                        print(f"        t0 = {externo}")
                        # print(f"        PUSH t0")
                    else:
                        print(f"        t0 = {parametrito.getText()}")
                        # print(f"        PUSH t0")
                    # print(f"        t0 = {parametrito.getText()}")
            ci = f"        t1 = t0.{primer_nivel[1]['funcion']}"
            print(ci)
            print(f"        CALLING t1 POP {pusheados}")

        # * LLAMADA METODO DIRECTO

        elif isinstance(expr_ctx, yaplParser.BooleanContext):
            print(f"        {expr_ctx.value.text}")
        elif isinstance(expr_ctx, yaplParser.IdContext):
            # print(f"        {expr_ctx.ID().getText()}")
            """ Calculo Externo de Offset """
            relative_scope = []
            if self.metodo_scope[-1] == " ":
                relative_scope.append(self.scope[-1])
            else:
                relative_scope.append(self.scope[-1])
                relative_scope.append(self.metodo_scope[-1])
            sub_externo = expr_ctx.ID().getText()
            if self.tabla.is_in_table(expr_ctx.ID().getText(), relative_scope):
                informacion_fila = self.tabla.fila(expr_ctx.ID().getText(), relative_scope)
                sub_externo = f"fp[{informacion_fila.offset}]"
            if self.tabla.is_in_table(expr_ctx.ID().getText(), [self.scope[-1]]):
                informacion_fila = self.tabla.fila(expr_ctx.ID().getText(), [self.scope[-1]])
                sub_externo = f"fp[{informacion_fila.offset}]"
            print(f"        {sub_externo}")


        # * COOL.cl

        # * Si dentro del metodo, existe un bloque
        elif isinstance(expr_ctx, yaplParser.BlockContext):
            expresiones_todas = expr_ctx.expr()

            # * Recorrer las expresiones
            for xxxx2 in expresiones_todas:


                if isinstance(xxxx2, yaplParser.DispatchExplicitAContext):
                    # * de IO
                    externo = None
                    primer_nivel = self.visit(xxxx2)
                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                        # time.sleep(0.4)
                        if indice != 0:
                            """ Calculo Externo de Offset """
                            relative_scope = []
                            if self.metodo_scope[-1] == " ":
                                relative_scope.append(self.scope[-1])
                            else:
                                relative_scope.append(self.scope[-1])
                                relative_scope.append(self.metodo_scope[-1])
                            if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                                informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                                externo = f"fp[{informacion_fila.offset}]"
                                print(f"        t0 = {externo}")
                                print(f"        PUSH t0")
                            elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                                informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                                externo = f"fp[{informacion_fila.offset}]"
                                print(f"        t0 = {externo}")
                                print(f"        PUSH t0")
                            else:
                                print(f"        t0 = {parametrito.getText()}")
                                print(f"        PUSH t0")
                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                        # time.sleep(0.4)
                        if indice == 0:
                            """ Calculo Externo de Offset """
                            relative_scope = []
                            if self.metodo_scope[-1] == " ":
                                relative_scope.append(self.scope[-1])
                            else:
                                relative_scope.append(self.scope[-1])
                                relative_scope.append(self.metodo_scope[-1])
                            if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                                informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                                externo = f"fp[{informacion_fila.offset}]"
                                print(f"        t0 = {externo}")
                                # print(f"        PUSH t0")
                            elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                                informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                                externo = f"fp[{informacion_fila.offset}]"
                                print(f"        t0 = {externo}")
                                # print(f"        PUSH t0")
                            else:
                                print(f"        t0 = {parametrito.getText()}")
                                # print(f"        PUSH t0")
                            # print(f"        t0 = {parametrito.getText()}")
                    ci = f"        t1 = t0.{primer_nivel[1]['funcion']}"
                    print(ci)
                    print(f"        CALLING t1 POP LAST")
                    pass


                if isinstance(xxxx2, yaplParser.AssignmentContext):
                    visitando = self.visit(xxxx2)
                    print(visitando[1])
                if isinstance(xxxx2, yaplParser.IntContext):
                    print(f"        {xxxx2.INT().getText()}")
                if isinstance(xxxx2, yaplParser.IdContext):
                    print(f"        {xxxx2.ID().getText()}")

                if isinstance(xxxx2, yaplParser.DispatchImplicitBContext):
                    metodos_especiales_string =['out_string',  'in_string']
                    metodos_especiales_int =['out_int', 'in_int']

                    # * Si las expresiones son llamadas a metodos especiales
                    if(xxxx2.ID().getText() in metodos_especiales_string):
                        mini_expr = xxxx2.expr()

                        # * Imprimir lo que esta dentro de la expresion (independientemente si es string o llamada a string)
                        for xxxx in mini_expr:
                            if isinstance(xxxx, yaplParser.StringContext):
                                print(f"        t0 = {xxxx.STRING().getText()}")
                                print(f"        PUSH t0")
                                print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                            if isinstance(xxxx, yaplParser.DispatchExplicitAContext):
                                # * Expresiones dentro de Dispatch Explicit
                                # print(f"        t0 = {xxxx.getText()}")
                                # print(f"        PUSH t0")
                                # print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                if  (contar_apariciones(xxxx.getText(), ").")) == 2:
                                    # print("detnro")
                                    primer_nivel = self.visit(xxxx)
                                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                        if indice != 0:
                                            print(f"        t0 = {parametrito.getText()}")
                                            print(f"        PUSH t0")
                                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                        if indice == 0:
                                            print(f"        t0 = {parametrito.getText()}")
                                    ci = f"        t1 = t0.{primer_nivel[1]['funcion']}"
                                    print(ci)
                                    print(f"        PUSH t1 POP 2")
                                    print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                    # print(f"        t0 = {xxxx.getText()}")
                                    # print(f"        PUSH t0")
                                    # print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                # print(xxxx.getText())


                                # clasificacion = xxxx.expr()
                                # for clasificando in clasificacion:
                                #     print(self.visit(clasificando))

                    elif(xxxx2.ID().getText() in metodos_especiales_int):
                        mini_expr = xxxx2.expr()

                        # * Imprimir lo que esta dentro de la expresion (independientemente si es int o llamada a int)
                        for xxxx in mini_expr:
                            if isinstance(xxxx, yaplParser.IntContext):
                                print(f"        t0 = {xxxx.INT().getText()}")
                                print(f"        PUSH t0")
                                print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                            if isinstance(xxxx, yaplParser.DispatchExplicitAContext):
                                # * Expresiones dentro de Dispatch Explicit
                                if  (contar_apariciones(xxxx.getText(), ").")) == 2:
                                    # print("detnro")
                                    primer_nivel = self.visit(xxxx)
                                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                        if indice != 0:
                                            print(f"        t0 = {parametrito.getText()}")
                                            print(f"        PUSH t0")
                                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                        if indice == 0:
                                            print(f"        t0 = {parametrito.getText()}")
                                    ci = f"        t1 = t0.{primer_nivel[1]['funcion']}"
                                    print(ci)
                                    print(f"        CALLING t1 POP 2")
                                externo = None
                                primer_nivel = self.visit(xxxx)
                                for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                    # time.sleep(0.4)
                                    if indice != 0:
                                        """ Calculo Externo de Offset """
                                        relative_scope = []
                                        if self.metodo_scope[-1] == " ":
                                            relative_scope.append(self.scope[-1])
                                        else:
                                            relative_scope.append(self.scope[-1])
                                            relative_scope.append(self.metodo_scope[-1])
                                        if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                                            informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                                            externo = f"fp[{informacion_fila.offset}]"
                                            print(f"        t0 = {externo}")
                                            print(f"        PUSH t0")
                                        elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                                            informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                                            externo = f"fp[{informacion_fila.offset}]"
                                            print(f"        t0 = {externo}")
                                            print(f"        PUSH t0")
                                        else:
                                            print(f"        t0 = {parametrito.getText()}")
                                            print(f"        PUSH t0")
                                for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                    # time.sleep(0.4)
                                    if indice == 0:
                                        """ Calculo Externo de Offset """
                                        relative_scope = []
                                        if self.metodo_scope[-1] == " ":
                                            relative_scope.append(self.scope[-1])
                                        else:
                                            relative_scope.append(self.scope[-1])
                                            relative_scope.append(self.metodo_scope[-1])
                                        if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                                            informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                                            externo = f"fp[{informacion_fila.offset}]"
                                            print(f"        t0 = {externo}")
                                            # print(f"        PUSH t0")
                                        elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                                            informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                                            externo = f"fp[{informacion_fila.offset}]"
                                            print(f"        t0 = {externo}")
                                            # print(f"        PUSH t0")
                                        else:
                                            print(f"        t0 = {parametrito.getText()}")
                                            # print(f"        PUSH t0")
                                        # print(f"        t0 = {parametrito.getText()}")
                                ci = f"        t1 = t0.{primer_nivel[1]['funcion']}"
                                print(ci)
                                print(f"        PUSH t1 POP LAST")
                                print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                # print(f"        t0 = {xxxx.getText()}")
                                # print(f"        PUSH t0")
                                # print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                # print(self.visit(xxxx))
                                # clasificacion = xxxx.expr()
                                # for clasificando in clasificacion:
                                    # print(self.visit(clasificando))
                    else:
                        mini_expr = xxxx2.expr()

                        if len(mini_expr) == 0:
                            print(f"        CALLING {xxxx2.ID().getText()}")
                        # * Imprimir lo que esta dentro de la expresion (independientemente si es string o llamada a string)
                        for xxxx in mini_expr:
                            if isinstance(xxxx, yaplParser.IntContext):
                                print(f"        t0 = {xxxx.INT().getText()}")
                                print(f"        PUSH t0")
                                print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                            if isinstance(xxxx, yaplParser.DispatchExplicitAContext):
                                # * Expresiones dentro de Dispatch Explicit
                                # print(f"        t0 = {xxxx.getText()}")
                                # print(f"        PUSH t0")
                                # print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                if  (contar_apariciones(xxxx.getText(), ").")) == 2:
                                    # print("detnro")
                                    primer_nivel = self.visit(xxxx)
                                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                        if indice != 0:
                                            print(f"        t0 = {parametrito.getText()}")
                                            print(f"        PUSH t0")
                                    for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                                        if indice == 0:
                                            print(f"        t0 = {parametrito.getText()}")
                                    ci = f"        t1 = t0.{primer_nivel[1]['funcion']}"
                                    print(ci)
                                    print(f"        PUSH t1 POP 2")
                                    print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                    # print(f"        t0 = {xxxx.getText()}")
                                    # print(f"        PUSH t0")
                                    # print(f"        CALLING {xxxx2.ID().getText()} POP LAST")
                                # print(xxxx.getText())

        # elif isinstance(expr_ctx, yaplParser.DispatchImplicitBContext):
        #     print(f"        t0 -> {expr_ctx.STRING().getText()}")
        #     print(f"        PUSH t0")
        # elif isinstance(expr_ctx, yaplParser.NewContext):
        #     print(f"        t0 ->  NEW {expr_ctx.TYPE().getText()}")
        #     print(f"        PUSH t0")

        # print(f"        CALLING {ctx.ID().getText()} POP LAST")

        return self.visitChildren(ctx)

    """ Visita una asignacion de valores ( nombre <- expresion ) """

    # * Se le asigna el valor a una variable inicializada
    # * La inicializacion de variable puede estar ligada
    # * la asignacion debe de hacerce a una variable ya inicializada
    # * abajo de este punto son expresiones y formatos (Inicializaciones de variables)

    # Visit a parse tree produced by yaplParser#propiedad.
    def visitPropiedad(self, ctx:yaplParser.PropiedadContext):

        # ! CODIGO INTERMEDIO
        # banner("ASIGNACION")

        """ Calculo Externo de Offset """

        relative_scope = []

        if self.metodo_scope[-1] == " ":
            relative_scope.append(self.scope[-1])
        else:
            relative_scope.append(self.scope[-1])
            relative_scope.append(self.metodo_scope[-1])

        """ Tamaño """

        tamanio = 0
        if ctx.formal().TYPE().getText() == 'Int':
            tamanio = 4
        elif ctx.formal().TYPE().getText() == 'String':
            tamanio = 8
        elif ctx.formal().TYPE().getText() == 'Boolean':
            tamanio = 2
        else:
            tamanio = 16

        """ Offset """

        partners = []
        offset = 0
        if len(relative_scope) == 1:
            self.tabla.fila(self.scope[-1], 'self').inside.append(ctx.formal().ID().getText())
            self.tabla.aumentar(self.scope[-1], 'self', tamanio)
            # for x in self.tabla.table:
            #     # print(x)
            #     # print('')
            partners = self.tabla.fila(self.scope[-1], 'self').inside

            if len(partners) == 1:
                offset = 0
            else:
                for x in partners[:-1]:
                    # # print(x)
                    offset += self.tabla.fila(x, [self.scope[-1]]).tamanio




        if len(relative_scope) > 1:
            self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside.append(ctx.formal().ID().getText())
            self.tabla.aumentar(relative_scope[-1], relative_scope[-2], tamanio)
            self.tabla.aumentar(self.scope[-1], 'self', tamanio)
            # partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside
            # for x in self.tabla.table:
            #     # print(x)
            #     # print('')
            partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside

            if len(partners) == 1:
                offset = 0
            else:
                for x in partners[:-1]:
                    # # print(x)
                    offset += self.tabla.fila(x, relative_scope).tamanio

        self.tabla.append_row(
            ctx.formal().TYPE().getText(),
            ctx.formal().ID().getText(),
            None,
            'local',
            tamanio,
            relative_scope,
            [],
            [],
            offset
        )

        # ! CODIGO INTERMEDIO
        print(f"    {ctx.formal().ID().getText()}\tEQUAL TO\tfp[{offset}]")


        if hasattr(ctx, 'ASSIGNMENT') and callable(getattr(ctx, 'ASSIGNMENT')):

            # * EXPR 15
            if hasattr(ctx.expr(), 'INT') and callable(getattr(ctx.expr(), 'INT')):
                print(f"    fp[{offset}] = {ctx.expr().INT().getText()}")
            # * EXPR 16
            if hasattr(ctx.expr(), 'STRING') and callable(getattr(ctx.expr(), 'STRING')):
                print(f"    fp[{offset}] = {ctx.expr().STRING().getText()}")

            # if isinstance(ctx.expr(), yaplParser.Arithmetic1Context):
            #     expresion = ctx.expr().getText()
            #     expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()]', expresion)
            #     postfix_expression = infix_to_postfix(expression)
            #     assignments = process_postfix(postfix_expression)

            #     for assignment in assignments:
            #         # if assignment[1].isdigit() == False and assignment[1][0] != 't':

            #         print(f"    {assignment}")
            #     print(f"    fp[{offset}] = {assignments[-1][:2]}")

            if isinstance(ctx.expr(), yaplParser.Arithmetic2Context) or isinstance(ctx.expr(), yaplParser.Arithmetic1Context):
                # print("Detnro")
                # print(ctx.expr().getText())
                # print(type(ctx.expr().getText()))
                expresion = ctx.expr().getText()
                expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()]', expresion)
                postfix_expression = infix_to_postfix(expression)
                assignments = process_postfix(postfix_expression)

                for assignment in assignments:
                    if assignment[1].isdigit() == False and assignment[1][0] != 't':
                        if self.tabla.is_in_table(assignment[1], relative_scope):
                            informacion_fila = self.tabla.fila(assignment[1], relative_scope)
                            assignment[1] = f"fp[{informacion_fila.offset}]"
                    if assignment[3].isdigit() == False and assignment[2][0] != 't':
                        if self.tabla.is_in_table(assignment[3], relative_scope):
                            informacion_fila = self.tabla.fila(assignment[3], relative_scope)
                            assignment[3] = f"fp[{informacion_fila.offset}]"
                    print(f"    {assignment[0]} = {assignment[1]} {assignment[2]} {assignment[3]}")
                print(f"    fp[{offset}] = {assignments[-1][0]}\n")
        # print(f"OFFSET OBTENIDO {offset}")

        # banner(" " )
        # for x in self.tabla.table:
        #     print(x)
        # banner(" " )
        # if hasattr(ctx, 'ASSIGNMENT') and callable(getattr(ctx, 'ASSIGNMENT')):
            # if hasattr(ctx.expr(), 'INT') or hasattr(ctx.expr(), 'STRING'):
            #     print(self.Calculo(ctx.formal(), "aldgo"))
            #     print()

        # print( "Asignacion")
        # print(f"    FACTOR {ctx.formal().ID().getText()} HAS SPACE {}")

        # # banner(' formal ', False)

        # Tipo formal
        # print(ctx.formal().TYPE().getText())
        # Valor literal formal
        # print(ctx.formal().ID().getText())
        # Tipo expr
        tipo_expr_14_15_16 = ''

        # TODO: Visitando expr:15 INT

        if hasattr(ctx.expr(), 'INT'):
            # # banner(' expr INT ', False)

            # # Tipo expr
            # # print(self.visit(ctx.expr()))

            # # Valor literal expr
            # # print(ctx.expr().INT())

            tipo_expr_14_15_16 = self.visit(ctx.expr())

            if ctx.formal().TYPE().getText() != tipo_expr_14_15_16:
                self.errores.append(f'>> Intento de asignación incorrecto: {self.visit(ctx.expr())} a {ctx.formal().TYPE().getText()}')

        # TODO: Visitando expr:16 STRING

        if hasattr(ctx.expr(), 'STRING'):
            # # banner(' expr STRING ', False)

            # # Tipo expr
            # # print(self.visit(ctx.expr()))

            # # Valor literal expr
            # # print(ctx.expr().STRING())

            tipo_expr_14_15_16 = self.visit(ctx.expr())

            if ctx.formal().TYPE().getText() != tipo_expr_14_15_16:
                self.errores.append(f'>> Intento de asignación incorrecto: {self.visit(ctx.expr())} a {ctx.formal().TYPE().getText()}')

        # TODO: Visitando expr:17 BOOlEAN

        # if hasattr(ctx.expr(), 'BOOL'):
        #     # # banner(' expr STRING ', False)

        #     # # Tipo expr
        #     # # print(self.visit(ctx.expr()))

        #     # # Valor literal expr
        #     # # print(ctx.expr().STRING())

        #     tipo_expr_14_15_16 = self.visit(ctx.expr())

        #     if ctx.formal().TYPE().getText() != tipo_expr_14_15_16:
        #         self.errores.append(f'>> Intento de asignación incorrecto: {self.visit(ctx.expr())} a {ctx.formal().TYPE().getText()}')


        # try:
        #     tipo_expr_14_15_16 = ''
        #     if (ctx.expr().INT()):
        #         # banner(' expr INT ', False)

        #         # Tipo expr
        #         # print(self.visit(ctx.expr()))

        #         # Valor literal expr
        #         # print(ctx.expr().INT())

        #         tipo_expr_14_15_16 = self.visit(ctx.expr())

        #     if ctx.formal().TYPE().getText() != tipo_expr_14_15_16:
        #         self.errores.append(f'>> Intento de asignacion incorrecto: {self.visit(ctx.expr())} a {ctx.formal().TYPE().getText()}')

        # except:
        #     pass

        # try:
        #     tipo_expr_14_15_16 = ''
        #     if (ctx.expr().STRING()):
        #         # banner(' expr STRING ', False)

        #         # Tipo expr
        #         # print(self.visit(ctx.expr()))

        #         # Valor literal expr
        #         # print(ctx.expr().STRING())

        #         tipo_expr_14_15_16 = self.visit(ctx.expr())

        #     if ctx.formal().TYPE().getText() != tipo_expr_14_15_16:
        #         self.errores.append(f'>> Intento de asignacion incorrecto: {self.visit(ctx.expr())} a {ctx.formal().TYPE().getText()}')

        # except:
        #     pass
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
    def visitAsignacion(self, ctx:yaplParser.AsignacionContext):

        # # print( "Formal")
        # # print(f"visitando  {ctx.ID().getText()} : {ctx.TYPE().getText()} ")
        # # # # print(self.scope)
        # # # # print(self.metodo_scope)

        # # banner(f' {ctx.ID().getText()} : {ctx.TYPE().getText()} ')
        # # banner("FORMAL")

        # relative_scope = []

        # if self.metodo_scope[-1] == " ":
        #     relative_scope.append(self.scope[-1])
        # else:
        #     relative_scope.append(self.scope[-1])
        #     relative_scope.append(self.metodo_scope[-1])

        # """ Tamaño """

        # tamanio = 0
        # if ctx.TYPE().getText() == 'Int':
        #     tamanio = 4
        # elif ctx.TYPE().getText() == 'String':
        #     tamanio = 8
        # elif ctx.TYPE().getText() == 'Boolean':
        #     tamanio = 2
        # else:
        #     tamanio = 16

        # """ Offset """

        # partners = []
        # offset = 0
        # if len(relative_scope) == 1:
        #     self.tabla.fila(self.scope[-1], 'self').inside.append(ctx.ID().getText())
        #     self.tabla.aumentar(self.scope[-1], 'self', tamanio)
        #     # for x in self.tabla.table:
        #     #     # print(x)
        #     #     # print('')
        #     partners = self.tabla.fila(self.scope[-1], 'self').inside

        #     if len(partners) == 1:
        #         offset = 0
        #     else:
        #         for x in partners[:-1]:
        #             # # print(x)
        #             offset += self.tabla.fila(x, [self.scope[-1]]).tamanio




        # if len(relative_scope) > 1:
        #     self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside.append(ctx.ID().getText())
        #     self.tabla.aumentar(relative_scope[-1], relative_scope[-2], tamanio)
        #     self.tabla.aumentar(self.scope[-1], 'self', tamanio)
        #     partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside
        #     # for x in self.tabla.table:
        #     #     # print(x)
        #     #     # print('')
        #     partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside

        #     if len(partners) == 1:
        #         offset = 0
        #     else:
        #         for x in partners[:-1]:
        #             # # print(x)
        #             offset += self.tabla.fila(x, relative_scope).tamanio

        # self.tabla.append_row(
        #     ctx.TYPE().getText(),
        #     ctx.ID().getText(),
        #     None,
        #     'local',
        #     tamanio,
        #     relative_scope,
        #     [],
        #     [],
        #     offset
        # )



        # # try:
        # #     # # print("Contexto variable")
        # #     # # print(self.scope[-1])
        # #     # # print(self.metodo_scope[-1])
        # #     self.tabla.append_row(
        # #         ctx.TYPE().getText(),
        # #         ctx.ID().getText(),
        # #         None,
        # #         'local',
        # #         None,
        # #         [self.scope[-1], self.metodo_scope[-1]],
        # #         []
        # #     )
        # #     # # print(ctx.ID().getText())
        # # except:
        # #     # # print('EROR')
        # #     # # print(ctx.ID().getText())
        # # ! CODIGO INTERMEDIO
        # # * Variables dentro de clase pero fuera de metodos
        # if len(relative_scope) == 1:
        #     print(f"    {ctx.ID().getText()}\tEQUAL TO \tfp[{offset}]")
        # else:
        #     print(f"        {ctx.ID().getText()}\tEQUAL TO \tfp[{offset}]")

        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#new.
    def visitNew(self, ctx:yaplParser.NewContext):
        return self.visitChildren(ctx), ctx.TYPE().getText()


    # Visit a parse tree produced by yaplParser#parentheses.
    def visitParentheses(self, ctx:yaplParser.ParenthesesContext):

        tipo = 0

        if isinstance(ctx.expr(), yaplParser.DispatchExplicitAContext):
            tipo = 1
        elif isinstance(ctx.expr(), yaplParser.DispatchImplicitBContext):
            tipo = 2
        elif isinstance(ctx.expr(), yaplParser.IfContext):
            tipo = 3
        elif isinstance(ctx.expr(), yaplParser.WhileContext):
            tipo = 4
        elif isinstance(ctx.expr(), yaplParser.BlockContext):
            tipo = 5
        elif isinstance(ctx.expr(), yaplParser.NewContext):
            tipo = 6

        elif isinstance(ctx.expr(), yaplParser.NegativeContext):
            tipo = 7
        elif isinstance(ctx.expr(), yaplParser.IsvoidContext):
            tipo = 8
        elif isinstance(ctx.expr(), yaplParser.Arithmetic1Context):
            tipo = 9
        elif isinstance(ctx.expr(), yaplParser.Arithmetic2Context):
            tipo = 10
        elif isinstance(ctx.expr(), yaplParser.ComparissonContext):
            tipo = 11
        elif isinstance(ctx.expr(), yaplParser.BoolNotContext):
            tipo = 12
        elif isinstance(ctx.expr(), yaplParser.ParenthesesContext):
            tipo = 13
        elif isinstance(ctx.expr(), yaplParser.IdContext):
            tipo = 14
        elif isinstance(ctx.expr(), yaplParser.IntContext):
            tipo = 15
        elif isinstance(ctx.expr(), yaplParser.StringContext):
            tipo = 16
        elif isinstance(ctx.expr(), yaplParser.BooleanContext):
            tipo = 17
        elif isinstance(ctx.expr(), yaplParser.AssignmentContext):
            tipo = 18
        elif isinstance(ctx.expr(), yaplParser.LetInContext):
            tipo = 19

        return self.visitChildren(ctx), tipo, ctx.expr()


    # Visit a parse tree produced by yaplParser#letIn.
    def visitLetIn(self, ctx:yaplParser.LetInContext):

        formalitos = ctx.formal()

        for mini_formal in formalitos:
            # ! CODIGO INTERMEDIO
            # banner("ASIGNACION")

            """ Calculo Externo de Offset """

            relative_scope = []

            if self.metodo_scope[-1] == " ":
                relative_scope.append(self.scope[-1])
            else:
                relative_scope.append(self.scope[-1])
                relative_scope.append(self.metodo_scope[-1])

            """ Tamaño """

            tamanio = 0
            if mini_formal.TYPE().getText() == 'Int':
                tamanio = 4
            elif mini_formal.TYPE().getText() == 'String':
                tamanio = 8
            elif mini_formal.TYPE().getText() == 'Boolean':
                tamanio = 2
            else:
                tamanio = 16

            """ Offset """

            partners = []
            offset = 0
            if len(relative_scope) == 1:
                self.tabla.fila(self.scope[-1], 'self').inside.append(mini_formal.ID().getText())
                self.tabla.aumentar(self.scope[-1], 'self', tamanio)
                # for x in self.tabla.table:
                #     # print(x)
                #     # print('')
                partners = self.tabla.fila(self.scope[-1], 'self').inside

                if len(partners) == 1:
                    offset = 0
                else:
                    for x in partners[:-1]:
                        # # print(x)
                        offset += self.tabla.fila(x, [self.scope[-1]]).tamanio




            if len(relative_scope) > 1:
                self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside.append(mini_formal.ID().getText())
                self.tabla.aumentar(relative_scope[-1], relative_scope[-2], tamanio)
                self.tabla.aumentar(self.scope[-1], 'self', tamanio)
                # partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside
                # for x in self.tabla.table:
                #     # print(x)
                #     # print('')
                partners = self.tabla.fila(relative_scope[-1], relative_scope[-2]).inside

                if len(partners) == 1:
                    offset = 0
                else:
                    for x in partners[:-1]:
                        # # print(x)
                        offset += self.tabla.fila(x, relative_scope).tamanio

            self.tabla.append_row(
                mini_formal.TYPE().getText(),
                mini_formal.ID().getText(),
                None,
                'local',
                tamanio,
                relative_scope,
                [],
                [],
                offset
            )

            # ! CODIGO INTERMEDIO
            print(f"\n        LET\n")
            print(f"        {mini_formal.ID().getText()}\tEQUAL TO\tfp[{offset}]")
            print(f"\n        IN\n")

        expresioncitas = ctx.expr()

        for expresion in expresioncitas:
            if isinstance(expresion, yaplParser.BlockContext):
                mini_expresiones = expresion.expr()

                for minimal in mini_expresiones:

                    if isinstance(minimal, yaplParser.AssignmentContext):
                        visitando = self.visit(minimal)
                        print(visitando[1])

                    if isinstance(minimal, yaplParser.DispatchExplicitAContext):
                        externo = None
                        primer_nivel = self.visit(minimal)
                        pusheados = 0
                        for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                            # time.sleep(0.4)
                            if indice != 0:
                                """ Calculo Externo de Offset """
                                relative_scope = []
                                if self.metodo_scope[-1] == " ":
                                    relative_scope.append(self.scope[-1])
                                else:
                                    relative_scope.append(self.scope[-1])
                                    relative_scope.append(self.metodo_scope[-1])
                                if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                                    informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                                    externo = f"fp[{informacion_fila.offset}]"
                                    print(f"        t0 = {externo}")
                                    pusheados += 1
                                    print(f"        PUSH t0")
                                elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                                    informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                                    externo = f"fp[{informacion_fila.offset}]"
                                    print(f"        t0 = {externo}")
                                    pusheados += 1
                                    print(f"        PUSH t0")
                                else:
                                    print(f"        t0 = {parametrito.getText()}")
                                    pusheados += 1
                                    print(f"        PUSH t0")
                        for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                            # time.sleep(0.4)
                            if indice == 0:
                                """ Calculo Externo de Offset """
                                relative_scope = []
                                if self.metodo_scope[-1] == " ":
                                    relative_scope.append(self.scope[-1])
                                else:
                                    relative_scope.append(self.scope[-1])
                                    relative_scope.append(self.metodo_scope[-1])
                                if self.tabla.is_in_table(parametrito.getText(), relative_scope):
                                    informacion_fila = self.tabla.fila(parametrito.getText(), relative_scope)
                                    externo = f"fp[{informacion_fila.offset}]"
                                    print(f"        t0 = {externo}")
                                    # print(f"        PUSH t0")
                                elif self.tabla.is_in_table(parametrito.getText(), [self.scope[-1]]):
                                    informacion_fila = self.tabla.fila(parametrito.getText(), [self.scope[-1]])
                                    externo = f"fp[{informacion_fila.offset}]"
                                    print(f"        t0 = {externo}")
                                    # print(f"        PUSH t0")
                                else:
                                    print(f"        t0 = {parametrito.getText()}")
                                    # print(f"        PUSH t0")
                                # print(f"        t0 = {parametrito.getText()}")
                        ci = f"        t1 = t0.{primer_nivel[1]['funcion']}"
                        print(ci)
                        print(f"        CALLING t1 POP {pusheados}")

        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#string.
    def visitString(self, ctx:yaplParser.StringContext):
        return 'String'


    # Visit a parse tree produced by yaplParser#arithmetic1.
    def visitArithmetic1(self, ctx:yaplParser.Arithmetic1Context):

        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#isvoid.
    def visitIsvoid(self, ctx:yaplParser.IsvoidContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#assignment.
    def visitAssignment(self, ctx:yaplParser.AssignmentContext):

        regresando = ""
        """ Calculo Externo de Offset """

        relative_scope = []

        if self.metodo_scope[-1] == " ":
            relative_scope.append(self.scope[-1])
        else:
            relative_scope.append(self.scope[-1])
            relative_scope.append(self.metodo_scope[-1])

        externo = None

        if ctx.ID().getText().isdigit() == False:
            # print('im in')
            if self.tabla.is_in_table(ctx.ID().getText(), relative_scope):
                informacion_fila = self.tabla.fila(ctx.ID().getText(), relative_scope)
                externo = f"fp[{informacion_fila.offset}]"
            if self.tabla.is_in_table(ctx.ID().getText(), [self.scope[-1]]):
                informacion_fila = self.tabla.fila(ctx.ID().getText(), [self.scope[-1]])
                externo = f"fp[{informacion_fila.offset}]"

        if hasattr(ctx.expr(), 'INT') and callable(getattr(ctx.expr(), 'INT')):
            regresando = f"        {externo} = {ctx.expr().INT().getText()}"
            # print(f"        {externo} = {ctx.expr().INT().getText()}")
        # * EXPR 16
        if hasattr(ctx.expr(), 'STRING') and callable(getattr(ctx.expr(), 'STRING')):
            regresando = f"        {externo} = {ctx.expr().STRING().getText()}"
        if hasattr(ctx.expr(), 'ID') and callable(getattr(ctx.expr(), 'ID')):
            sub_externo = None
            if self.tabla.is_in_table(ctx.expr().ID().getText(), relative_scope):
                informacion_fila = self.tabla.fila(ctx.expr().ID().getText(), relative_scope)
                sub_externo = f"fp[{informacion_fila.offset}]"
            if self.tabla.is_in_table(ctx.expr().ID().getText(), [self.scope[-1]]):
                informacion_fila = self.tabla.fila(ctx.expr().ID().getText(), [self.scope[-1]])
                sub_externo = f"fp[{informacion_fila.offset}]"
            regresando = f"        {externo} = {sub_externo}"
            # print(f"        {externo} = {ctx.expr().STRING().getText()}")

        if isinstance(ctx.expr(), yaplParser.NewContext):
            regresando = f"        {externo} = {ctx.expr().getText()}"

        if isinstance(ctx.expr(), yaplParser.Arithmetic2Context) or isinstance(ctx.expr(), yaplParser.Arithmetic1Context):
            if isinstance(ctx.expr().expr(1), yaplParser.DispatchImplicitBContext) and isinstance(ctx.expr().expr(0), yaplParser.IdContext):

                externo_extra = ""
                # banner(" Operacion con Funcion Derecha ")


                """ Operando izquierdo ID """
                # print(ctx.expr().expr(0).getText())

                if ctx.expr().expr(0).getText().isdigit() == False and ctx.expr().expr(0).getText()[0] != 't':
                    # print("IM IN")
                    if self.tabla.is_in_table(ctx.expr().expr(0).getText(), relative_scope):
                        informacion_fila = self.tabla.fila(ctx.expr().expr(0).getText(), relative_scope)
                        externo_extra += f"fp[{informacion_fila.offset}]"
                    if self.tabla.is_in_table(ctx.expr().expr(0).getText(), [self.scope[-1]]):
                        informacion_fila = self.tabla.fila(ctx.expr().expr(0).getText(), [self.scope[-1]])
                        externo_extra += f"fp[{informacion_fila.offset}]"
                # regresando += f"\n        t0 = {externo_extra}"
                # regresando += f"\n        PUSH T0"

                """ Operando derecho funcion """
                # regresando += f"\n        t0 = {externo_extra}\n"
                parametritos = ctx.expr().expr(1).expr()

                for parametritito in parametritos:
                    # print(parametritito.getText())

                    if isinstance(parametritito, yaplParser.Arithmetic2Context) or isinstance(parametritito, yaplParser.Arithmetic1Context):
                        expresion = parametritito.getText()
                        expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()]', expresion)
                        postfix_expression = infix_to_postfix(expression)
                        assignments = process_postfix(postfix_expression)

                        for assignment in assignments:
                            if assignment[1].isdigit() == False and assignment[1][0] != 't':
                                if self.tabla.is_in_table(assignment[1], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[1], relative_scope)
                                    assignment[1] = f"fp[{informacion_fila.offset}]"
                            if assignment[3].isdigit() == False and assignment[2][0] != 't':
                                if self.tabla.is_in_table(assignment[3], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[3], relative_scope)
                                    assignment[3] = f"fp[{informacion_fila.offset}]"
                            # print("inside")
                            regresando +=f"\n        {assignment[0]} = {assignment[1]} {assignment[2]} {assignment[3]}"
                        # print("inside")
                        regresando +=f"\n        PUSHing {assignments[-1][0]}\n"


                regresando += f"        {externo} = {externo_extra} {ctx.expr().op.text} CALLING {ctx.expr().expr(1).ID().getText()} POP LAST"
            # print(ctx.expr().expr(1).getText())
                # regresando += f"\n        t0 = {externo_extra} {}\n"
            if isinstance(ctx.expr().expr(0), yaplParser.DispatchImplicitBContext) and isinstance(ctx.expr().expr(1), yaplParser.IdContext):
                banner(" Operacion con Funcion Izquierda ")


                externo_extra = ""
                # banner(" Operacion con Funcion Derecha ")


                """ Operando izquierdo ID """
                # print(ctx.expr().expr(0).getText())

                if ctx.expr().expr(1).getText().isdigit() == False and ctx.expr().expr(1).getText()[0] != 't':
                    # print("IM IN")
                    if self.tabla.is_in_table(ctx.expr().expr(0).getText(), relative_scope):
                        informacion_fila = self.tabla.fila(ctx.expr().expr(0).getText(), relative_scope)
                        externo_extra += f"fp[{informacion_fila.offset}]"
                    if self.tabla.is_in_table(ctx.expr().expr(0).getText(), [self.scope[-1]]):
                        informacion_fila = self.tabla.fila(ctx.expr().expr(0).getText(), [self.scope[-1]])
                        externo_extra += f"fp[{informacion_fila.offset}]"
                # regresando += f"\n        t0 = {externo_extra}"
                # regresando += f"\n        PUSH T0"

                """ Operando derecho funcion """
                # regresando += f"\n        t0 = {externo_extra}\n"
                parametritos = ctx.expr().expr(0).expr()

                for parametritito in parametritos:
                    # print(parametritito.getText())

                    if isinstance(parametritito, yaplParser.Arithmetic2Context) or isinstance(parametritito, yaplParser.Arithmetic1Context):
                        expresion = parametritito.getText()
                        expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()]', expresion)
                        postfix_expression = infix_to_postfix(expression)
                        assignments = process_postfix(postfix_expression)

                        for assignment in assignments:
                            if assignment[1].isdigit() == False and assignment[1][0] != 't':
                                if self.tabla.is_in_table(assignment[1], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[1], relative_scope)
                                    assignment[1] = f"fp[{informacion_fila.offset}]"
                            if assignment[3].isdigit() == False and assignment[2][0] != 't':
                                if self.tabla.is_in_table(assignment[3], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[3], relative_scope)
                                    assignment[3] = f"fp[{informacion_fila.offset}]"
                            # print("inside")
                            regresando +=f"\n        {assignment[0]} = {assignment[1]} {assignment[2]} {assignment[3]}"
                        # print("inside")
                        regresando +=f"\n        PUSH {assignments[-1][0]}\n"


                regresando += f"        {externo} = {externo_extra} {ctx.expr().op.text} CALLING {ctx.expr().expr(1).ID().getText()} POP LAST"

            if isinstance(ctx.expr().expr(0), yaplParser.DispatchImplicitBContext) and isinstance(ctx.expr().expr(1), yaplParser.DispatchImplicitBContext):
                # banner(" Operacion funciones ambos lados ")


                externo_extra = ""
                # banner(" Operacion con Funcion Derecha ")


                """ Operando izquierdo ID """
                # print(ctx.expr().expr(0).getText())

                parametritos = ctx.expr().expr(0).expr()

                for parametritito in parametritos:
                    # print(parametritito.getText())

                    if isinstance(parametritito, yaplParser.Arithmetic2Context) or isinstance(parametritito, yaplParser.Arithmetic1Context):
                        expresion = parametritito.getText()
                        expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()]', expresion)
                        postfix_expression = infix_to_postfix(expression)
                        assignments = process_postfix(postfix_expression)

                        for assignment in assignments:
                            if assignment[1].isdigit() == False and assignment[1][0] != 't':
                                if self.tabla.is_in_table(assignment[1], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[1], relative_scope)
                                    assignment[1] = f"fp[{informacion_fila.offset}]"
                            if assignment[3].isdigit() == False and assignment[2][0] != 't':
                                if self.tabla.is_in_table(assignment[3], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[3], relative_scope)
                                    assignment[3] = f"fp[{informacion_fila.offset}]"
                            # print("inside")
                            regresando +=f"\n        {assignment[0]} = {assignment[1]} {assignment[2]} {assignment[3]}"
                        # print("inside")
                        regresando +=f"\n        PUSH {assignments[-1][0]}\n"
                # regresando += f"\n        t0 = {externo_extra}"
                # regresando += f"\n        PUSH T0"

                """ Operando derecho funcion """
                # regresando += f"\n        t0 = {externo_extra}\n"
                parametritos = ctx.expr().expr(1).expr()

                for parametritito in parametritos:
                    # print(parametritito.getText())

                    if isinstance(parametritito, yaplParser.Arithmetic2Context) or isinstance(parametritito, yaplParser.Arithmetic1Context):
                        expresion = parametritito.getText()
                        expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()]', expresion)
                        postfix_expression = infix_to_postfix(expression)
                        assignments = process_postfix(postfix_expression)

                        for assignment in assignments:
                            if assignment[1].isdigit() == False and assignment[1][0] != 't':
                                if self.tabla.is_in_table(assignment[1], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[1], relative_scope)
                                    assignment[1] = f"fp[{informacion_fila.offset}]"
                            if assignment[3].isdigit() == False and assignment[2][0] != 't':
                                if self.tabla.is_in_table(assignment[3], relative_scope):
                                    informacion_fila = self.tabla.fila(assignment[3], relative_scope)
                                    assignment[3] = f"fp[{informacion_fila.offset}]"
                            # print("inside")
                            regresando +=f"\n        {assignment[0]} = {assignment[1]} {assignment[2]} {assignment[3]}"
                        # print("inside")
                        regresando +=f"\n        PUSH {assignments[-1][0]}\n"


                regresando += f"        {externo} = CALLING {ctx.expr().expr(0).ID().getText()} POP LAST {ctx.expr().op.text} CALLING {ctx.expr().expr(1).ID().getText()} POP LAST"

            if isinstance(ctx.expr().expr(0), yaplParser.DispatchImplicitBContext) == False and isinstance(ctx.expr().expr(1), yaplParser.DispatchImplicitBContext) == False:
                # banner(" Operacion sin funciones ")
                expresion = ctx.expr().getText()
                expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()]', expresion)
                # print(expression)
                postfix_expression = infix_to_postfix(expression)
                # print(postfix_expression)
                assignments = process_postfix(postfix_expression)

                for assignment in assignments:
                    if assignment[1].isdigit() == False and assignment[1][0] != 't':
                        if self.tabla.is_in_table(assignment[1], relative_scope):
                            informacion_fila = self.tabla.fila(assignment[1], relative_scope)
                            assignment[1] = f"fp[{informacion_fila.offset}]"
                        if self.tabla.is_in_table(assignment[1], [self.scope[-1]]):
                            informacion_fila = self.tabla.fila(assignment[1], [self.scope[-1]])
                            assignment[1] = f"fp[{informacion_fila.offset}]"
                    if assignment[3].isdigit() == False and assignment[2][0] != 't':
                        if self.tabla.is_in_table(assignment[3], relative_scope):
                            informacion_fila = self.tabla.fila(assignment[3], relative_scope)
                            assignment[3] = f"fp[{informacion_fila.offset}]"
                        if self.tabla.is_in_table(assignment[3], [self.scope[-1]]):
                            informacion_fila = self.tabla.fila(assignment[3], [self.scope[-1]])
                            assignment[3] = f"fp[{informacion_fila.offset}]"
                    regresando += f"\n        {assignment[0]} = {assignment[1]} {assignment[2]} {assignment[3]}\n"
                    # print(f"        {assignment[0]} = {assignment[1]} {assignment[2]} {assignment[3]}")
                regresando += f"        {externo} = {assignments[-1][0]}\n"
                # print(f"        t0 = {}")``
                #     primer_nivel = self.visit(ssxpr)
                #     for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                #         if indice != 0:
                #             print(f"        t0 = {parametrito.getText()}")
                #             print(f"        PUSH t0")
                #     for indice, parametrito in enumerate(primer_nivel[1]["parametros"]):
                #         if indice == 0:
                #             print(f"        t0 = {parametrito.getText()}")


            # print("Detnro")
            # print(ctx.expr().getText())
            # print(type(ctx.expr().getText()))
            # if isinstance(ctx.expr().expr(0), )
            # pass
            # print(f"        {externo} = {ctx.expr().getText()}")
        # print(f"    {externo} = {assignment[1]} {assignment[2]} {assignment[3]}")

        return self.visitChildren(ctx), regresando


    # Visit a parse tree produced by yaplParser#arithmetic2.
    def visitArithmetic2(self, ctx:yaplParser.Arithmetic2Context):

        # left_type, valuel = self.visit(ctx.expr(0))
        # right_type, value2 = self.visit(ctx.expr(1))
        # # # print(left_type, valuel)
        # # # # print(left_type[1])

        return self.visitChildren(ctx)

    # Visit a parse tree produced by yaplParser#while.
    def visitWhile(self, ctx:yaplParser.WhileContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#int.
    def visitInt(self, ctx:yaplParser.IntContext):
        return 'Int'


    # Visit a parse tree produced by yaplParser#dispatchImplicitB.
    def visitDispatchImplicitB(self, ctx:yaplParser.DispatchImplicitBContext):
        propiedades = {
            "funcion": None,
            "parametros": None
        }

        propiedades["funcion"] = ctx.ID().getText()
        propiedades["parametros"] = ctx.expr()


        return self.visitChildren(ctx), propiedades


    # Visit a parse tree produced by yaplParser#negative.
    def visitNegative(self, ctx:yaplParser.NegativeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#boolNot.
    def visitBoolNot(self, ctx:yaplParser.BoolNotContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#boolean.
    def visitBoolean(self, ctx:yaplParser.BooleanContext):
        return 'Boolean'


    # Visit a parse tree produced by yaplParser#block.
    def visitBlock(self, ctx:yaplParser.BlockContext):

        # expresiones =


        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#comparisson.
    def visitComparisson(self, ctx:yaplParser.ComparissonContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#id.
    def visitId(self, ctx:yaplParser.IdContext):
        return 'Id', ctx.ID().getText()



    # Visit a parse tree produced by yaplParser#if.
    def visitIf(self, ctx:yaplParser.IfContext):

        """ Calculo Externo de Offset """

        relative_scope = []

        if self.metodo_scope[-1] == " ":
            relative_scope.append(self.scope[-1])
        else:
            relative_scope.append(self.scope[-1])
            relative_scope.append(self.metodo_scope[-1])

        if isinstance(ctx.expr(0), yaplParser.ComparissonContext):
            # print("  Dentro ")
            expresion = ctx.expr(0).getText()
            expression = re.findall(r'\d+|[a-zA-Z]+|[-+*/()=<]', expresion)
            postfix_expression = infix_to_postfix(expression)
            # print(postfix_expression)
            assignments = process_postfix(postfix_expression)
            for assignment in assignments:
                if assignment[1].isdigit() == False and assignment[1][0] != 't':
                    if self.tabla.is_in_table(assignment[1], relative_scope):
                        informacion_fila = self.tabla.fila(assignment[1], relative_scope)
                        assignment[1] = f"fp[{informacion_fila.offset}]"
                if assignment[3].isdigit() == False and assignment[2][0] != 't':
                    if self.tabla.is_in_table(assignment[3], relative_scope):
                        informacion_fila = self.tabla.fila(assignment[3], relative_scope)
                        assignment[3] = f"fp[{informacion_fila.offset}]"
                print(f"\n        {assignment[0]} VALIDATION {assignment[1]} {assignment[2]} {assignment[3]}\n")
            # print(f"        t0 VALIDATION {ctx.expr(0).getText()}")
            print(f"\n        IF t0 GO TO THEN\n")
            print(f"\n        THEN:\n")

            if isinstance(ctx.expr(1), yaplParser.AssignmentContext):
                    visitando = self.visit(ctx.expr(1))
                    print(visitando[1])

            print(f"\n        ELSE:\n")

            if isinstance(ctx.expr(2), yaplParser.IfContext):
                print(f"\n        NESTED IF\n")
            else:
                visitando = self.visit(ctx.expr(2))
                print(visitando[1])

                print(f"\n        FI\n")


        return self.visitChildren(ctx)



    # Visit a parse tree produced by yaplParser#dispatchExplicitA.
    def visitDispatchExplicitA(self, ctx:yaplParser.DispatchExplicitAContext):

        propiedades = {
            "objeto" : None,
            "funcion": None,
            "parametros": None
        }

        propiedades["objeto"] = ctx.expr()[0]
        propiedades["funcion"] = ctx.ID().getText()
        propiedades["parametros"] = ctx.expr()


        return self.visitChildren(ctx), propiedades

    # """ Parte que permite la comparacion de tipos """
    # def check_binary_operation(self, left_type, right_type, operation):
    #     valid_combinations = {
    #         "+": [("Int", "Int"), ("Bool", "Bool")],
    #         "-": [("Int", "Int")],
    #         "*": [("Int", "Int"), ("Bool", "Bool")],
    #         "/": [("Int", "Int")],
    #         "&&": [("Bool", "Bool")],
    #         "||": [("Bool", "Bool")],
    #     }

    #     if (left_type, right_type) in valid_combinations[operation]:

    #         if operation == "/" and right_type == 0:
    #             self.errores.append("Division by zero error.")
    #             return "Error"
    #         return left_type
    #     else:
    #         self.errores.append(
    #             f"Invalid operation: {operation} cannot be applied to {left_type} and {right_type}"
    #         )
    #         return "Error"

    # def visitAddition(self, ctx):
    #     left_type = self.visit(ctx.left)
    #     right_type = self.visit(ctx.right)
    #     return self.check_binary_operation(left_type, right_type, "+")

    # def visitSubtraction(self, ctx):
    #     left_type = self.visit(ctx.left)
    #     right_type = self.visit(ctx.right)
    #     return self.check_binary_operation(left_type, right_type, "-")

    # def visitMultiplication(self, ctx):
    #     left_type = self.visit(ctx.left)
    #     right_type = self.visit(ctx.right)
    #     return self.check_binary_operation(left_type, right_type, "*")

    # def visitDivision(self, ctx):
    #     left_type = self.visit(ctx.left)
    #     right_type = self.visit(ctx.right)
    #     return self.check_binary_operation(left_type, right_type, "/")

    # def visitLogicalAND(self, ctx):
    #     left_type = self.visit(ctx.left)
    #     right_type = self.visit(ctx.right)
    #     return self.check_binary_operation(left_type, right_type, "&&")

    # def visitLogicalOR(self, ctx):
    #     left_type = self.visit(ctx.left)
    #     right_type = self.visit(ctx.right)
    #     return self.check_binary_operation(left_type, right_type, "||")

    # def visitIf(self, ctx: yaplParser.IfContext):
    #     condition_type = self.visit(
    #         ctx.expr(0)
    #     )  # The first expr in the 'if' rule is the condition
    #     if condition_type != "Bool":
    #         self.errores.append(
    #             f"Expected boolean type in 'if' condition, got {condition_type} instead at line {ctx.start.line}"
    #         )

    # def visitWhile(self, ctx: yaplParser.WhileContext):
    #     condition_type = self.visit(
    #         ctx.expr(0)
    #     )  # The first expr in the 'while' rule is the condition
    #     if condition_type != "Bool":
    #         self.errores.append(
    #             f"Expected boolean type in 'while' condition, got {condition_type} instead at line {ctx.start.line}"
    #         )
