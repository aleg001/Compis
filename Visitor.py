from yaplVisitor import yaplVisitor


class MyVisitor(yaplVisitor):
    def __init__(self, symbol_table, type_system):
        self.symbol_table = symbol_table
        self.type_system = type_system

    def visitFeature(self, ctx):
        if ctx.ID() and ctx.TYPE():
            var_name = ctx.ID().getText()
            var_type = ctx.TYPE().getText()
            self.symbol_table.insert_symbol(var_name, var_type)

        return self.visitChildren(ctx)

    def visitLetDecl(self, ctx):
        var_name = ctx.ID().getText()
        var_type = ctx.TYPE().getText()
        self.symbol_table.insert_symbol(var_name, var_type)
