# 🚀 Laboratorio #3: Generación de Código Ensamblador para YAPL 🛠️

## 📌 Introducción:
En este laboratorio, hemos llevado a cabo la fase crucial de transformar el código intermedio (CI) en instrucciones de ensamblador MIPS, centrando nuestra atención en las expresiones aritméticas. Este README sirve como una guía para comprender el proceso, el código presentado y su correlación con las tareas dadas.
La sección A del laboratorio se encuentra completamente en el PDF y los ejemplos de traducciones de la parte B también se encuentran dentro del archivo PDF.

---

## 📚 Índice:

1. [Análisis del Código en YAPL](#analisis)
2. [Proceso de Traducción](#traduccion)
3. [Resultados y Output](#resultados)
4. [Conclusiones](#conclusiones)

---

## 🧩 <a name="analisis"></a>Análisis del Código en YAPL:

🔎 **Input YAPL de ejemplo**:
El código proporcionado en YAPL consiste en una clase que hereda de IO. Esta clase, `Main`, contiene tres métodos:
- `main()`: Invoca las funciones `add` y `divide`, pasando los números y mostrando los resultados.
- `add(x, y)`: Suma los dos valores pasados.
- `divide(a, b)`: Divide el valor `a` entre el valor `b`.

---

## 🔄 <a name="traduccion"></a>Proceso de Traducción:

📜 **Código Intermedio (CI)**:
Basándonos en el código en YAPL, generamos un código intermedio (CI) que actúa como una representación más baja del código original, facilitando la transición hacia el código ensamblador.

🔗 **Conexión con MIPS**:
El CI se traduce directamente a instrucciones MIPS. Las operaciones aritméticas, en particular la suma y la división, son esenciales en este proceso. La traducción considera la gestión de la pila, el paso de parámetros y la invocación de funciones.

---

## 🖨️ <a name="resultados"></a>Resultados y Output:

🖥️ **Código Ensamblador MIPS**:
El output generado en MIPS refleja las operaciones aritméticas, las invocaciones de función y las operaciones de stack apropiadas. Es importante notar que, aunque el código MIPS generado cumple con los requerimientos, no está optimizado para ejecución real.

📊 **Ejemplos y Pruebas**:
Para verificar la validez del código MIPS, es vital realizar pruebas con diferentes entradas. Aunque este README no proporciona estas pruebas, se recomienda revisar el código y realizar simulaciones para garantizar su correcta traducción.

---

## 🎯 <a name="conclusiones"></a>Conclusiones:

Este laboratorio resalta la importancia de cada fase en el proceso de compilación. La transición del código YAPL al código intermedio y, finalmente, al ensamblador MIPS, demuestra la complejidad y la precisión necesarias en la construcción de un compilador.

Es esencial entender cada paso, desde la sintaxis y semántica del lenguaje fuente hasta las peculiaridades del ensamblador objetivo, para generar un código preciso y eficiente.

---

**¡Gracias por revisar este laboratorio! ¡Hasta la próxima entrega!** 🚀

Atentamente:
- Alejandro Gómez
- Gabriel Vicente
