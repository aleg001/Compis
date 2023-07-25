import tkinter
from tkinter import Tk, ttk


class SymbolTable:
    def __init__(self):
        self.table = {}

    def insert_symbol(self, symbol, type):
        if symbol in self.table:
            raise ValueError(f"El simbolo: {symbol} ya existe chavo.")
        self.table[symbol] = type

    def lookup_symbol(self, symbol):
        return self.table.get(symbol, None)

    def clear(self):
        self.table.clear()

    def show(self):
        window = tkinter.Tk()
        window.title("Symbol Table")

        tree = ttk.Treeview(window)
        tree["columns"] = ("one", "two")

        tree.column("#0", width=270, minwidth=270)
        tree.column("one", width=150, minwidth=150)
        tree.column("two", width=400, minwidth=200)

        tree.heading("#0", text="Variable", anchor="w")
        tree.heading("one", text="Type", anchor="w")

        for symbol, type in self.table.items():
            tree.insert("", 0, text=symbol, values=(str(type)))

        tree.pack()

        window.mainloop()
