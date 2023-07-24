class SymbolTable:
    def __init__(self):
        self.table = {}

    def insert_symbol(self, symbol, type):
        if symbol in self.table:
            raise ValueError(f"El simbolo: {symbol} ya existe chavo.")
        self.table[symbol] = type

    def lookup_symbol(self, symbol):
        return self.table.get(symbol, None)
