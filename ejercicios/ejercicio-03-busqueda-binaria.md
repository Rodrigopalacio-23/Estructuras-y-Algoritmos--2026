# Ejercicio 3 – Buscar un elemento en un vector ordenado

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo de búsqueda binaria.
El prompt debe explicar por qué esta estrategia resulta más eficiente que una búsqueda lineal cuando los datos están ordenados, indicar la complejidad esperada y solicitar que el código muestre paso a paso cómo evolucionan las variables de búsqueda.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java un algoritmo de Búsqueda Binaria (Binary Search) iterativo sobre un arreglo ordenado de enteros (int[]), que rastree e imprima detalladamente paso a paso la evolución de las variables de control en cada iteración del proceso.

### Estrategia Elegida y Justificación
- Estrategia: Búsqueda Binaria mediante división y conquista (Divide and Conquer). Se mantienen dos punteros de límites: `inicio` (izquierdo) y `fin` (derecho). En cada paso se calcula el índice central `medio = inicio + (fin - inicio) / 2` (para prevenir desbordamiento aritmético de enteros). Se compara el elemento en `vector[medio]` con el elemento buscado. Si coincide, se retorna; si el objetivo es menor, se descarta la mitad derecha ajustando `fin = medio - 1`; si es mayor, se descarta la mitad izquierda ajustando `inicio = medio + 1`.
- Por qué es más eficiente que la búsqueda lineal:
  1. En una búsqueda lineal, cada comparación solo permite descartar un único elemento (reducción de tamaño del espacio de búsqueda: $n \to n-1$), requiriendo hasta $n$ operaciones.
  2. Al estar el vector ordenado, cada comparación en búsqueda binaria permite descartar la mitad entera de los elementos restantes ($n \to n/2$), logrando una reducción exponencial del espacio de búsqueda. Por ejemplo, para 1.000.000 de elementos, una búsqueda lineal puede requerir 1.000.000 de comparaciones, mientras que la búsqueda binaria requiere a lo sumo $\lceil \log_2(1.000.000) \rceil = 20$ comparaciones.

### Complejidad Esperada
- Complejidad Temporal:
  - Mejor Caso: O(1) tiempo, cuando el elemento buscado coincide exactamente con el punto medio en la primera iteración.
  - Peor y Caso Promedio: O(log n) tiempo, ya que el espacio de búsqueda se reduce a la mitad en cada paso hasta quedar en tamaño 1 o vaciarse.
- Complejidad Espacial:
  - Implementación iterativa: O(1) memoria adicional auxiliar, ya que solo se almacenan variables escalares (`inicio`, `fin`, `medio`).

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `BusquedaBinaria`).
- Método de búsqueda: `public static int busquedaBinariaConTrazado(int[] vector, int objetivo, boolean trazar)`.
- Prevención de desbordamiento de enteros (overflow): Usar estrictamente `medio = inicio + (fin - inicio) / 2` en lugar de `(inicio + fin) / 2`.
- Validaciones: Verificar precondiciones (vector nulo o vacío). Asumir como precondición que el arreglo está ordenado en orden ascendente (o incluir verificación básica).
- Buenas prácticas: Código limpio, modular, comentarios claros explicando la lógica de división y la reducción logarítmica.

### Requisitos Específicos del Ejercicio
1. Mostrar paso a paso por consola cómo evolucionan las variables de búsqueda (`inicio`, `fin`, `medio`, `vector[medio]` y el valor objetivo) en cada iteración de la búsqueda.
2. Contabilizar e informar el número total de iteraciones/pasos realizados hasta encontrar el elemento o concluir que no pertenece al arreglo.
3. Incluir un método `main` con casos de prueba ejecutables que muestren el trazado paso a paso:
   - Búsqueda exitosa de un elemento en el centro inicial (mejor caso, 1 paso).
   - Búsqueda exitosa de un elemento en los extremos (primer o último elemento).
   - Búsqueda exitosa en posición intermedia arbitraria.
   - Búsqueda fallida de un elemento menor que el mínimo del vector.
   - Búsqueda fallida de un elemento mayor que el máximo del vector.
   - Búsqueda fallida de un elemento intermedio inexistente.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Explicación teórica de la búsqueda binaria y justificación cuantitativa de su superioridad frente a la búsqueda lineal sobre arreglos ordenados.
2. Análisis formal de complejidad temporal (mejor, peor y promedio) y espacial.
3. Código Java completo, con trazado detallado paso a paso y método `main`.
4. Salida por consola generada por los casos de prueba, mostrando el registro visual paso a paso de cada iteración.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Explicación y justificación de por qué la búsqueda binaria es más eficiente que la búsqueda lineal sobre datos ordenados incluida antes del código.
- [x] Complejidad esperada temporal O(log n) y espacial O(1) detalladas.
- [x] Requisito explícito de trazado paso a paso de las variables (`inicio`, `fin`, `medio`, etc.) incluido en el método y en la salida.
- [x] Requisitos de código Java definidos (fórmula anti-overflow, modularidad, comentarios).
- [x] Casos de prueba completos para éxito, extremos y fallas en `main`.
- [x] Formato de salida estructurado y ordenado.

