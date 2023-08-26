# class YourListener(ErrorListener):  # Debe heredar de la clase base del Visitor generado por ANTLR
#     def __init__(self):
#         super().__init__()
#         # Puedes inicializar variables o configuraciones aquí

#     # Implementa los métodos para capturar los eventos del árbol sintáctico
#     def enterVariableDeclaration(self, ctx):
#         # Ejemplo: Capturar eventos de declaraciones de variables
#         variable_name = ctx.ID().getText()
#         print(f"Variable declarada: {variable_name}")

#     def enterAssignmentStatement(self, ctx):
#         # Ejemplo: Capturar eventos de asignaciones de variables
#         variable_name = ctx.ID().getText()
#         expression = ctx.expression().getText()
#         print(f"Asignación a {variable_name}: {expression}")
import subprocess
from antlr4 import *
from antlr_files.yaplLexer import yaplLexer
from antlr_files.yaplParser import yaplParser
from antlr_files.yaplListener import yaplListener
from antlr4.error.ErrorListener import ErrorListener
from Visitor import yaplVisitor

import tkinter as tk


class CustomErrorListener(ErrorListener):
    def __init__(self):
        self.errors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.errors.append(f"line {line}:{column} {msg}")


class TerminalApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Compis - YAPL")
        self.root.configure(bg="#0D2844")
        self.root.geometry("800x600")  # default window size
        self.root.minsize(600, 400)  # minimum window size

        self.create_widgets()

    def create_widgets(self):
        # Styling
        bg_color = "#2A2E37"
        fg_color = "#C0C5CE"
        error_color = "#E95678"
        font_style = ("Arial", 12)

        # Text widgets for input and output
        self.input_text = tk.Text(
            self.root,
            bg=bg_color,
            fg=fg_color,
            insertbackground=fg_color,
            font=font_style,
            wrap=tk.WORD,
        )
        self.output_text = tk.Text(
            self.root,
            bg=bg_color,
            fg=error_color,
            insertbackground=fg_color,
            font=font_style,
            state=tk.DISABLED,
        )
        self.input_text.grid(row=0, column=0, padx=10, pady=10, sticky="nsew")
        self.output_text.grid(row=0, column=1, padx=10, pady=10, sticky="nsew")

        # Buttons
        button_frame = tk.Frame(self.root, bg="#0D2844")
        self.execute_button = tk.Button(
            button_frame,
            text="Run",
            command=self.execute_command,
            bg="#4B8B3B",
            fg=fg_color,
            font=font_style,
        )
        self.clear_button = tk.Button(
            button_frame,
            text="Clear",
            command=self.clear_output,
            bg="#A93B3B",
            fg=fg_color,
            font=font_style,
        )
        self.show_table_button = tk.Button(
            button_frame,
            text="Show Table",
            command=self.show_table,
            bg="#3B65A9",
            fg=fg_color,
            font=font_style,
        )
        self.execute_button.pack(fill=tk.BOTH, padx=10, pady=5)
        self.clear_button.pack(fill=tk.BOTH, padx=10, pady=5)
        self.show_table_button.pack(fill=tk.BOTH, padx=10, pady=5)
        button_frame.grid(row=0, column=2, padx=10, pady=10, sticky="nsew")

        # Configure weights for resizing
        self.root.grid_rowconfigure(0, weight=1)
        self.root.grid_columnconfigure(0, weight=2)
        self.root.grid_columnconfigure(1, weight=1)
        self.root.grid_columnconfigure(2, weight=0)

        self.exit_button = tk.Button(
            button_frame,
            text="Exit",
            command=self.close_window,
            bg="#E95678",
            fg="red",
            font=font_style,
        )
        self.exit_button.pack(fill=tk.BOTH, padx=10, pady=5)

    # def show table
    def show_table(self):
        input_stream = FileStream("./input.txt")
        lexer = yaplLexer(input_stream)

        tokens = CommonTokenStream(lexer)
        parser = yaplParser(tokens)

        parser.removeErrorListeners()
        lexer.removeErrorListeners()
        error_listener = CustomErrorListener()
        lexer.addErrorListener(error_listener)
        parser.addErrorListener(error_listener)

        tree = parser.program()

        visitor = yaplVisitor()
        visitor_result = visitor.visit(tree)
        visitor.tabla.show_rows()

    def execute_command(self):

        # user input
        # user_input = self.input_text.get("1.0", "end-1c")

        # # Crear un archivo "input.txt" y escribir el contenido
        # with open("input.txt", "w") as file:
        #     file.write(user_input)

        # Mostrar arbol
        process = subprocess.Popen(
            ["antlr4-parse", "./antlr_files/yapl.g4", "program", "-gui"],
            stdin=subprocess.PIPE,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
        )
        with open("input.txt", "r") as file:
            insertion_of_user = file.read()

        # input stream
        input_stream = FileStream("./input.txt")
        lexer = yaplLexer(input_stream)

        tokens = CommonTokenStream(lexer)
        parser = yaplParser(tokens)

        parser.removeErrorListeners()
        lexer.removeErrorListeners()
        error_listener = CustomErrorListener()
        lexer.addErrorListener(error_listener)
        parser.addErrorListener(error_listener)

        tree = parser.program()

        visitor = yaplVisitor()
        visitor_result = visitor.visit(tree)

        for x in error_listener.errors:
            self.output_text.insert(tk.END, x + "\n")

        for x in visitor.errores:
            self.output_text.insert(tk.END, x + "\n")

        process.communicate(input=insertion_of_user.encode("utf-8"))

    def clear_output(self):
        self.input_text.delete("1.0", tk.END)
        self.output_text.delete("1.0", tk.END)

    def close_window(self):
        self.root.destroy()


def main():
    root = tk.Tk()
    app = TerminalApp(root)
    root.mainloop()


if __name__ == "__main__":
    main()
