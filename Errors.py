from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener
from YourGeneratedLexer import YourGeneratedLexer
from YourGeneratedParser import YourGeneratedParser


class CustomErrorListener(ErrorListener):
    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        raise ValueError(f"Token recognition error at line {line}, column {column}")


def parse_input(input_string):
    lexer = YourGeneratedLexer(InputStream(input_string))
    token_stream = CommonTokenStream(lexer)
    parser = YourGeneratedParser(token_stream)

    error_listener = CustomErrorListener()
    lexer.removeErrorListeners()
    lexer.addErrorListener(error_listener)
    parser.removeErrorListeners()
    parser.addErrorListener(error_listener)

    try:
        Tree = parser.program()
    except ValueError as e:
        print(f"Error parsing input: {e}")
