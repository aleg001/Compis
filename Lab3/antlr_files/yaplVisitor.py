# Generated from yapl.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .yaplParser import yaplParser
else:
    from yaplParser import yaplParser

# This class defines a complete generic visitor for a parse tree produced by yaplParser.

class yaplVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by yaplParser#programas.
    def visitProgramas(self, ctx:yaplParser.ProgramasContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#clase.
    def visitClase(self, ctx:yaplParser.ClaseContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#metodo.
    def visitMetodo(self, ctx:yaplParser.MetodoContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#propiedad.
    def visitPropiedad(self, ctx:yaplParser.PropiedadContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#asignacion.
    def visitAsignacion(self, ctx:yaplParser.AsignacionContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#new.
    def visitNew(self, ctx:yaplParser.NewContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#parentheses.
    def visitParentheses(self, ctx:yaplParser.ParenthesesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#letIn.
    def visitLetIn(self, ctx:yaplParser.LetInContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#string.
    def visitString(self, ctx:yaplParser.StringContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#arithmetic1.
    def visitArithmetic1(self, ctx:yaplParser.Arithmetic1Context):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#isvoid.
    def visitIsvoid(self, ctx:yaplParser.IsvoidContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#assignment.
    def visitAssignment(self, ctx:yaplParser.AssignmentContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#arithmetic2.
    def visitArithmetic2(self, ctx:yaplParser.Arithmetic2Context):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#while.
    def visitWhile(self, ctx:yaplParser.WhileContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#int.
    def visitInt(self, ctx:yaplParser.IntContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#dispatchImplicitB.
    def visitDispatchImplicitB(self, ctx:yaplParser.DispatchImplicitBContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#negative.
    def visitNegative(self, ctx:yaplParser.NegativeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#boolNot.
    def visitBoolNot(self, ctx:yaplParser.BoolNotContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#boolean.
    def visitBoolean(self, ctx:yaplParser.BooleanContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#block.
    def visitBlock(self, ctx:yaplParser.BlockContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#comparisson.
    def visitComparisson(self, ctx:yaplParser.ComparissonContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#id.
    def visitId(self, ctx:yaplParser.IdContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#if.
    def visitIf(self, ctx:yaplParser.IfContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by yaplParser#dispatchExplicitA.
    def visitDispatchExplicitA(self, ctx:yaplParser.DispatchExplicitAContext):
        return self.visitChildren(ctx)



del yaplParser