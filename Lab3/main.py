import subprocess
from antlr4 import *
from antlr_files.yaplLexer import yaplLexer
from antlr_files.yaplParser import yaplParser
from antlr_files.yaplListener import yaplListener
from antlr4.error.ErrorListener import ErrorListener
from Visitor_v2 import yaplVisitor
from MIPS import *
import tkinter as tk


class CustomErrorListener(ErrorListener):
    def __init__(self):
        self.errors = []

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.errors.append(f"line {line}:{column} {msg}")


class TerminalApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Mini Sublime Text")
        self.root.configure(bg="#0D2844")

        self.create_widgets()

    def create_widgets(self):
        self.input_text = tk.Text(
            self.root,
            height=30,
            width=50,
            bg="black",
            fg="white",
            insertbackground="white",
        )
        self.output_text = tk.Text(
            self.root,
            height=30,
            width=30,
            bg="gray",
            fg="red",
            insertbackground="white",
        )

        self.input_text.grid(row=0, column=0, padx=10, pady=10, rowspan=2)
        self.output_text.grid(row=0, column=1, padx=10, pady=10, rowspan=2)

        button_frame = tk.Frame(self.root, bg="#0D2844")
        self.execute_button = tk.Button(
            button_frame,
            text="Ejecutar",
            command=self.execute_command,
            bg="black",
            fg="white",
        )
        self.clear_button = tk.Button(
            button_frame,
            text="Limpiar",
            command=self.clear_output,
            bg="black",
            fg="white",
        )
        self.show_table_button = tk.Button(
            button_frame,
            text="Mostrar Tabla",
            command=self.show_table,
            bg="black",
            fg="white",
        )

        self.execute_button.pack(side="top", padx=10, pady=5)
        self.clear_button.pack(side="top", padx=10, pady=5)
        self.show_table_button.pack(side="top", padx=10, pady=5)

        button_frame.grid(row=0, column=2, padx=10, pady=10, rowspan=2)

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

        # with open("input.txt", "w") as file:
        #     file.write(user_input)
        """
        process = subprocess.Popen(
            ["antlr4-parse", "./antlr_files/yapl.g4", "program", "-gui"],
            stdin=subprocess.PIPE,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
        )"""

        user_input = self.input_text.get("1.0", "end-1c")

        with open("input.txt", "w") as file:
            file.write(user_input)
        process = subprocess.Popen(
            [
                "java",
                "-Xmx500M",
                "-cp",
                "/usr/local/lib/antlr-4.13.1-complete.jar:$CLASSPATH",
                "org.antlr.v4.Tool",
                "./antlr_files/yapl.g4",
                "program",
                "-gui",
            ],
            stdin=subprocess.PIPE,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
        )

        with open("input.txt", "r") as file:
            insertion_of_user = file.read()

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

        visitor_1 = yaplVisitor()
        visitor_result = visitor_1.visit(tree)

        visitor_2 = yaplVisitor(visitor_1.tabla)
        codigo_intermedio = visitor_2.visit(tree)

        print(visitor_2.desarrollo)

        for x in error_listener.errors:
            self.output_text.insert(tk.END, x + "\n\n")

        for x in visitor_1.errores:
            self.output_text.insert(tk.END, x + "\n\n")

        MIPSCodigo = parse_icr(visitor_2.desarrollo)

        print("---------------------")
        print("Traducción a MIPS")

        for line in MIPSCodigo:
            if isinstance(line, list):
                for subline in line:
                    print(subline)
                print()
            else:
                print(line)

        process.communicate(input=insertion_of_user.encode("utf-8"))

    def clear_output(self):
        self.input_text.delete("1.0", tk.END)
        self.output_text.delete("1.0", tk.END)


def main():
    root = tk.Tk()
    app = TerminalApp(root)
    root.mainloop()


if __name__ == "__main__":
    main()
