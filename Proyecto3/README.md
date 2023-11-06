# Investigación y propuesta de Código Intermedio para Proyecto de Compiladores 🚀

En un proyecto de compiladores, el código intermedio es una representación intermedia del programa fuente que facilita la optimización y la generación de código final. En este contexto, usaremos el **Three Address Code (TAC)** como estructura base para representar Turbo Assembler como código intermedio.

## Three Address Code (TAC) 🌟

El TAC es una notación intermedia que utiliza operaciones de tres direcciones para representar instrucciones de manera simple y uniforme. Cada instrucción TAC consta de tres partes:

1. **Operador**: Representa la operación a realizar (por ejemplo, suma, resta, asignación, salto condicional, etc.).
2. **Operando 1**: El primer operando de la operación.
3. **Operando 2**: El segundo operando de la operación.

El TAC es especialmente útil para simplificar la generación de código y las optimizaciones. Aquí tienes un ejemplo de cómo funciona:

```plaintext
TAC:              Ejemplo:

1.   =            temp1 = a + b
2.   +            temp2 = temp1 * c
3.   *            result = temp2
```

En este ejemplo, las tres instrucciones TAC representan la evaluación de la expresión result = (a + b) * c. Cada instrucción se divide en tres partes, lo que facilita la traducción a código ensamblador o código de máquina.

## Implementación del TAC en un Compilador 🛠️

Para implementar el TAC en un compilador, puedes utilizar una estructura de datos de lista (por ejemplo, una lista enlazada o un arreglo) para almacenar cada instrucción TAC. Cada nodo o elemento de la lista contendrá el operador y sus operandos correspondientes.

## Ejemplos de TAC para Instrucciones Gramaticales 📝

### Asignación:

TAC:              Ejemplo:

1.   =            x = 5

### Suma:

TAC:              Ejemplo:

1.   + temp1 = a + b
  
### If-Else:

TAC:              Ejemplo:

1.   if           if a > b goto L1
2.   =            x = 10
3.   goto         goto L2
4.   label        L1:
5.   =            x = 20
6.   label        L2:


### While:

TAC:              Ejemplo:

1.   label        L1:
2.   if           if x > 0 goto L2
3.   goto         goto L3
4.   label        L2:
5.   -   x = x - 1
6.   goto         goto L1
7.   label        L3:


### Referencias Bibliográficas 📚

Cooper, K. D., & Torczon, L. (2011). "Engineering a Compiler." Morgan Kaufmann.
Aho, A. V., & Ullman, J. D. (1986). "Compilers: Principles, Techniques, and Tools." Addison-Wesley.
