import tkinter as tk
from tkinter import ttk


class Table:
    def __init__(self):
        self.table = []

    def append_row(self, tipo, nombre, inherits, campo, tamanio, scope, inside):
        fila = Row(tipo, nombre, inherits, campo, tamanio, scope, inside)
        self.table.append(fila)

    def is_in_table(self, nombre, scope):
        for fila in self.table:
            if fila.nombre == nombre and fila.scope == scope:
                return True
        return False

    def fila(self, nombre, scope):
        for fila in self.table:
            if fila.nombre == nombre and fila.scope == scope:
                return fila

        return None

    def lista_a_string_con_saltos_de_linea(self, lista):
        resultado = "\n".join(lista)
        return resultado

    def show_rows(self):
        root = tk.Tk()
        root.title("Tabla de Filas")

        # Style configurations
        style = ttk.Style()
        style.configure("Treeview", font=("Arial", 12), rowheight=25)
        style.configure("Treeview.Heading", font=("Arial", 14, "bold"))

        tree_frame = ttk.Frame(root, padding="10")
        tree_frame.pack(fill="both", expand=True)

        tree = ttk.Treeview(tree_frame)
        tree["columns"] = (
            "Tipo",
            "Nombre",
            "Inherits",
            "Campo",
            "Tamaño",
            "Scope",
            "Inside",
        )
        tree.heading("#0", text="Índice")
        tree.heading("Tipo", text="Tipo")
        tree.heading("Nombre", text="Nombre")
        tree.heading("Inherits", text="Inherits")
        tree.heading("Campo", text="Campo")
        tree.heading("Tamaño", text="Tamaño")
        tree.heading("Scope", text="Scope")
        tree.heading("Inside", text="Inside")

        for idx, fila in enumerate(self.table, start=1):
            values = (
                fila.tipo,
                fila.nombre,
                fila.inherits,
                fila.campo,
                fila.tamanio,
                fila.scope,
                fila.inside,
            )
            tree.insert("", "end", text=idx, values=values)

        tree.column("#0", width=50, stretch=tk.NO)
        tree.column("Tipo", width=100, stretch=tk.NO)
        tree.column("Nombre", width=100, stretch=tk.NO)
        tree.column("Inherits", width=100, stretch=tk.NO)
        tree.column("Campo", width=100, stretch=tk.NO)
        tree.column("Tamaño", width=100, stretch=tk.NO)
        tree.column("Scope", width=200, stretch=tk.NO)
        tree.column("Inside", width=300, stretch=tk.NO)

        h_scrollbar = ttk.Scrollbar(tree_frame, orient="horizontal", command=tree.xview)
        v_scrollbar = ttk.Scrollbar(tree_frame, orient="vertical", command=tree.yview)
        tree.configure(xscrollcommand=h_scrollbar.set, yscrollcommand=v_scrollbar.set)

        tree.grid(row=0, column=0, sticky="nsew")
        h_scrollbar.grid(row=1, column=0, sticky="ew")
        v_scrollbar.grid(row=0, column=1, sticky="ns")

        tree_frame.grid_rowconfigure(0, weight=1)
        tree_frame.grid_columnconfigure(0, weight=1)

        root.geometry("1100x600")  # Default window size


class Row:
    def __init__(self, tipo, nombre, inherits, campo, tamanio, scope, inside):
        self.tipo = tipo
        self.nombre = nombre
        self.inherits = inherits
        self.campo = campo
        self.tamanio = tamanio
        self.scope = scope
        self.inside = inside
