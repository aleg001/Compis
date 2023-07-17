from antlr4 import *
from yaplLexer import yaplLexer
from yaplParser import yaplParser
from antlr4.tree.Trees import Trees

# Obtener el código ingresado por el usuario
user_input = ""
while True:
    line = input(">>> ")
    if line:
        user_input += line + "\n"
    else:
        break

# Crear un InputStream a partir del código ingresado
input_stream = InputStream(user_input)

# Crear un lexer a partir del InputStream
lexer = yaplLexer(input_stream)
token_stream = CommonTokenStream(lexer)

# Crear un parser a partir del token stream
parser = yaplParser(token_stream)

# Obtener el árbol de análisis sintáctico
tree = parser.expr()  # "startRule" es el nombre de la regla inicial en tu gramática

print(Trees.toStringTree(tree, None, parser))

# Verificar si hay errores
if parser.getNumberOfSyntaxErrors() == 0:
    # No hay errores, procesar el árbol de análisis sintáctico
    # ...
    print("Análisis sintáctico exitoso. Puedes continuar con el procesamiento.")
else:
    # Hay errores en la entrada del usuario
    print("La entrada contiene errores de sintaxis.")

