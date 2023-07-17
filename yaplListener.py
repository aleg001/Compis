# Generated from yapl.g4 by ANTLR 4.13.0
from antlr4 import *
if "." in __name__:
    from .yaplParser import yaplParser
else:
    from yaplParser import yaplParser

# This class defines a complete listener for a parse tree produced by yaplParser.
class yaplListener(ParseTreeListener):

    # Enter a parse tree produced by yaplParser#program.
    def enterProgram(self, ctx:yaplParser.ProgramContext):
        pass

    # Exit a parse tree produced by yaplParser#program.
    def exitProgram(self, ctx:yaplParser.ProgramContext):
        pass


    # Enter a parse tree produced by yaplParser#class_list.
    def enterClass_list(self, ctx:yaplParser.Class_listContext):
        pass

    # Exit a parse tree produced by yaplParser#class_list.
    def exitClass_list(self, ctx:yaplParser.Class_listContext):
        pass


    # Enter a parse tree produced by yaplParser#class_def.
    def enterClass_def(self, ctx:yaplParser.Class_defContext):
        pass

    # Exit a parse tree produced by yaplParser#class_def.
    def exitClass_def(self, ctx:yaplParser.Class_defContext):
        pass


    # Enter a parse tree produced by yaplParser#feature_body.
    def enterFeature_body(self, ctx:yaplParser.Feature_bodyContext):
        pass

    # Exit a parse tree produced by yaplParser#feature_body.
    def exitFeature_body(self, ctx:yaplParser.Feature_bodyContext):
        pass


    # Enter a parse tree produced by yaplParser#feature_def.
    def enterFeature_def(self, ctx:yaplParser.Feature_defContext):
        pass

    # Exit a parse tree produced by yaplParser#feature_def.
    def exitFeature_def(self, ctx:yaplParser.Feature_defContext):
        pass


    # Enter a parse tree produced by yaplParser#feature_list.
    def enterFeature_list(self, ctx:yaplParser.Feature_listContext):
        pass

    # Exit a parse tree produced by yaplParser#feature_list.
    def exitFeature_list(self, ctx:yaplParser.Feature_listContext):
        pass


    # Enter a parse tree produced by yaplParser#formal_list.
    def enterFormal_list(self, ctx:yaplParser.Formal_listContext):
        pass

    # Exit a parse tree produced by yaplParser#formal_list.
    def exitFormal_list(self, ctx:yaplParser.Formal_listContext):
        pass


    # Enter a parse tree produced by yaplParser#formal_param.
    def enterFormal_param(self, ctx:yaplParser.Formal_paramContext):
        pass

    # Exit a parse tree produced by yaplParser#formal_param.
    def exitFormal_param(self, ctx:yaplParser.Formal_paramContext):
        pass


    # Enter a parse tree produced by yaplParser#expr_list.
    def enterExpr_list(self, ctx:yaplParser.Expr_listContext):
        pass

    # Exit a parse tree produced by yaplParser#expr_list.
    def exitExpr_list(self, ctx:yaplParser.Expr_listContext):
        pass


    # Enter a parse tree produced by yaplParser#expr.
    def enterExpr(self, ctx:yaplParser.ExprContext):
        pass

    # Exit a parse tree produced by yaplParser#expr.
    def exitExpr(self, ctx:yaplParser.ExprContext):
        pass


    # Enter a parse tree produced by yaplParser#case_list.
    def enterCase_list(self, ctx:yaplParser.Case_listContext):
        pass

    # Exit a parse tree produced by yaplParser#case_list.
    def exitCase_list(self, ctx:yaplParser.Case_listContext):
        pass


    # Enter a parse tree produced by yaplParser#case_def.
    def enterCase_def(self, ctx:yaplParser.Case_defContext):
        pass

    # Exit a parse tree produced by yaplParser#case_def.
    def exitCase_def(self, ctx:yaplParser.Case_defContext):
        pass



del yaplParser