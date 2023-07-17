from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener


class CustomErrorListener(ErrorListener):
    def __init__(self):
        super().__init__()
        self.errors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        if "exit" in msg:
            return
        else:
            self.errors.append(f"line {line}:{column} {msg}")
