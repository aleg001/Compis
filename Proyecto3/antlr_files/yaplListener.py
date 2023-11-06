# Generated from yapl.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .yaplParser import yaplParser
else:
    from yaplParser import yaplParser

# This class defines a complete listener for a parse tree produced by yaplParser.
class yaplListener(ParseTreeListener):

    # Enter a parse tree produced by yaplParser#programas.
    def enterProgramas(self, ctx:yaplParser.ProgramasContext):
        pass

    # Exit a parse tree produced by yaplParser#programas.
    def exitProgramas(self, ctx:yaplParser.ProgramasContext):
        pass


    # Enter a parse tree produced by yaplParser#clase.
    def enterClase(self, ctx:yaplParser.ClaseContext):
        pass

    # Exit a parse tree produced by yaplParser#clase.
    def exitClase(self, ctx:yaplParser.ClaseContext):
        pass


    # Enter a parse tree produced by yaplParser#metodo.
    def enterMetodo(self, ctx:yaplParser.MetodoContext):
        pass

    # Exit a parse tree produced by yaplParser#metodo.
    def exitMetodo(self, ctx:yaplParser.MetodoContext):
        pass


    # Enter a parse tree produced by yaplParser#propiedad.
    def enterPropiedad(self, ctx:yaplParser.PropiedadContext):
        pass

    # Exit a parse tree produced by yaplParser#propiedad.
    def exitPropiedad(self, ctx:yaplParser.PropiedadContext):
        pass


    # Enter a parse tree produced by yaplParser#asignacion.
    def enterAsignacion(self, ctx:yaplParser.AsignacionContext):
        pass

    # Exit a parse tree produced by yaplParser#asignacion.
    def exitAsignacion(self, ctx:yaplParser.AsignacionContext):
        pass


    # Enter a parse tree produced by yaplParser#new.
    def enterNew(self, ctx:yaplParser.NewContext):
        pass

    # Exit a parse tree produced by yaplParser#new.
    def exitNew(self, ctx:yaplParser.NewContext):
        pass


    # Enter a parse tree produced by yaplParser#parentheses.
    def enterParentheses(self, ctx:yaplParser.ParenthesesContext):
        pass

    # Exit a parse tree produced by yaplParser#parentheses.
    def exitParentheses(self, ctx:yaplParser.ParenthesesContext):
        pass


    # Enter a parse tree produced by yaplParser#letIn.
    def enterLetIn(self, ctx:yaplParser.LetInContext):
        pass

    # Exit a parse tree produced by yaplParser#letIn.
    def exitLetIn(self, ctx:yaplParser.LetInContext):
        pass


    # Enter a parse tree produced by yaplParser#string.
    def enterString(self, ctx:yaplParser.StringContext):
        pass

    # Exit a parse tree produced by yaplParser#string.
    def exitString(self, ctx:yaplParser.StringContext):
        pass


    # Enter a parse tree produced by yaplParser#arithmetic1.
    def enterArithmetic1(self, ctx:yaplParser.Arithmetic1Context):
        pass

    # Exit a parse tree produced by yaplParser#arithmetic1.
    def exitArithmetic1(self, ctx:yaplParser.Arithmetic1Context):
        pass


    # Enter a parse tree produced by yaplParser#isvoid.
    def enterIsvoid(self, ctx:yaplParser.IsvoidContext):
        pass

    # Exit a parse tree produced by yaplParser#isvoid.
    def exitIsvoid(self, ctx:yaplParser.IsvoidContext):
        pass


    # Enter a parse tree produced by yaplParser#assignment.
    def enterAssignment(self, ctx:yaplParser.AssignmentContext):
        pass

    # Exit a parse tree produced by yaplParser#assignment.
    def exitAssignment(self, ctx:yaplParser.AssignmentContext):
        pass


    # Enter a parse tree produced by yaplParser#arithmetic2.
    def enterArithmetic2(self, ctx:yaplParser.Arithmetic2Context):
        pass

    # Exit a parse tree produced by yaplParser#arithmetic2.
    def exitArithmetic2(self, ctx:yaplParser.Arithmetic2Context):
        pass


    # Enter a parse tree produced by yaplParser#while.
    def enterWhile(self, ctx:yaplParser.WhileContext):
        pass

    # Exit a parse tree produced by yaplParser#while.
    def exitWhile(self, ctx:yaplParser.WhileContext):
        pass


    # Enter a parse tree produced by yaplParser#int.
    def enterInt(self, ctx:yaplParser.IntContext):
        pass

    # Exit a parse tree produced by yaplParser#int.
    def exitInt(self, ctx:yaplParser.IntContext):
        pass


    # Enter a parse tree produced by yaplParser#dispatchImplicitB.
    def enterDispatchImplicitB(self, ctx:yaplParser.DispatchImplicitBContext):
        pass

    # Exit a parse tree produced by yaplParser#dispatchImplicitB.
    def exitDispatchImplicitB(self, ctx:yaplParser.DispatchImplicitBContext):
        pass


    # Enter a parse tree produced by yaplParser#negative.
    def enterNegative(self, ctx:yaplParser.NegativeContext):
        pass

    # Exit a parse tree produced by yaplParser#negative.
    def exitNegative(self, ctx:yaplParser.NegativeContext):
        pass


    # Enter a parse tree produced by yaplParser#boolNot.
    def enterBoolNot(self, ctx:yaplParser.BoolNotContext):
        pass

    # Exit a parse tree produced by yaplParser#boolNot.
    def exitBoolNot(self, ctx:yaplParser.BoolNotContext):
        pass


    # Enter a parse tree produced by yaplParser#boolean.
    def enterBoolean(self, ctx:yaplParser.BooleanContext):
        pass

    # Exit a parse tree produced by yaplParser#boolean.
    def exitBoolean(self, ctx:yaplParser.BooleanContext):
        pass


    # Enter a parse tree produced by yaplParser#block.
    def enterBlock(self, ctx:yaplParser.BlockContext):
        pass

    # Exit a parse tree produced by yaplParser#block.
    def exitBlock(self, ctx:yaplParser.BlockContext):
        pass


    # Enter a parse tree produced by yaplParser#comparisson.
    def enterComparisson(self, ctx:yaplParser.ComparissonContext):
        pass

    # Exit a parse tree produced by yaplParser#comparisson.
    def exitComparisson(self, ctx:yaplParser.ComparissonContext):
        pass


    # Enter a parse tree produced by yaplParser#id.
    def enterId(self, ctx:yaplParser.IdContext):
        pass

    # Exit a parse tree produced by yaplParser#id.
    def exitId(self, ctx:yaplParser.IdContext):
        pass


    # Enter a parse tree produced by yaplParser#if.
    def enterIf(self, ctx:yaplParser.IfContext):
        pass

    # Exit a parse tree produced by yaplParser#if.
    def exitIf(self, ctx:yaplParser.IfContext):
        pass


    # Enter a parse tree produced by yaplParser#dispatchExplicitA.
    def enterDispatchExplicitA(self, ctx:yaplParser.DispatchExplicitAContext):
        pass

    # Exit a parse tree produced by yaplParser#dispatchExplicitA.
    def exitDispatchExplicitA(self, ctx:yaplParser.DispatchExplicitAContext):
        pass



del yaplParser