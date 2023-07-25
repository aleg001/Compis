from antlr4 import *
from yaplLexer import yaplLexer
from yaplParser import yaplParser
from yaplVisitor import yaplVisitor


class MyVisitor(yaplVisitor):
    def __init__(self, symbol_table, type_system):
        self.symbol_table = symbol_table
        self.type_system = type_system

    def visitLetStatement(self, ctx):
        var_name = ctx.ID().getText()
        var_type = self.type_system.infer_assignment(ctx.expression().getText())
        self.symbol_table.insert_symbol(var_name, var_type)
        return self.visitChildren(ctx)
