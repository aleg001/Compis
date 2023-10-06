import tkinter as tk
from tkinter import ttk


class Table:
    def __init__(self):
        self.table = []

    def append_row(
        self,
        tipo,
        nombre,
        inherits,
        campo,
        tamanio,
        scope,
        inside,
        parametros=[],
        offset=None,
    ):
        fila = Row(
            tipo, nombre, inherits, campo, tamanio, scope, inside, parametros, offset
        )
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

    def aumentar(self, nombre, scope, aumento):
        for fila in self.table:
            if fila.nombre == nombre and fila.scope == scope:
                # return fila
                fila.tamanio += aumento
        # return None

    def in_scope(self, particulare_scope):
        filas = []
        for fila in self.table:
            if fila.scope == particulare_scope:
                filas.append(fila)

        return filas

    def lista_a_string_con_saltos_de_linea(self, lista):
        resultado = " ".join(lista)
        return resultado

    def show_rows(self):
        root = tk.Tk()
        root.title("Tabla de Filas")

        tree = ttk.Treeview(root)
        tree["columns"] = (
            "Tipo",
            "Nombre",
            "Inherits",
            "Campo",
            "Tamaño",
            "Scope",
            "Inside",
            "Offset",
        )
        tree.heading("#0", text="Índice")
        tree.heading("Tipo", text="Tipo")
        tree.heading("Nombre", text="Nombre")
        tree.heading("Inherits", text="Inherits")
        tree.heading("Campo", text="Campo")
        tree.heading("Tamaño", text="Tamaño")
        tree.heading("Scope", text="Scope")
        tree.heading("Inside", text="Inside")
        # tree.heading("Parametros", text="Parametros")
        tree.heading("Offset", text="Offset")

        for idx, fila in enumerate(self.table, start=1):
            values = (
                fila.tipo,
                fila.nombre,
                fila.inherits,
                fila.campo,
                fila.tamanio,
                fila.scope,
                fila.inside,
                fila.offset
                # fila.parametros
            )
            tree.insert("", "end", text=idx, values=values)
        # tree.configure(height=5*(max(len(x.inside) for x in self.table.inside)))

        tree.column("#0", width=50)  # Ancho de la columna de índice
        tree.column("Tipo", width=100)
        tree.column("Nombre", width=100)
        tree.column("Inherits", width=100)
        tree.column("Campo", width=100)
        tree.column("Tamaño", width=100)
        tree.column("Scope", width=200)
        tree.column("Inside", width=300)
        # tree.column("Parametros", width=300)
        tree.column("Offset", width=200)
        tree.configure(height=40)
        tree.pack(fill="both", expand=True)

        root.mainloop()


class Row:
    def __init__(
        self,
        tipo,
        nombre,
        inherits,
        campo,
        tamanio,
        scope,
        inside,
        parametros=[],
        offset=None,
    ):
        self.tipo = tipo
        self.nombre = nombre
        self.inherits = inherits
        self.campo = campo
        self.tamanio = tamanio
        self.scope = scope
        self.inside = inside
        self.parametros = parametros
        self.offset = offset

    def __str__(self):
        return (
            f"Tipo: {self.tipo} "
            f"Nombre: {self.nombre} "
            f"Inherits: {self.inherits} "
            f"Campo: {self.campo} "
            f"Tamaño: {self.tamanio} "
            f"Scope: {self.scope} "
            f"Inside: {self.inside} "
            f"Parámetros: {self.parametros}"
        )
