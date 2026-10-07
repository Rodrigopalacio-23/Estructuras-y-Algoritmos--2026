# Ejercicio 10 – Ordenamiento burbuja

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java del algoritmo Bubble Sort.
El prompt debe explicar por qué este algoritmo resulta adecuado únicamente para fines didácticos o conjuntos pequeños de datos y solicitar que el programa contabilice comparaciones e intercambios.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java el algoritmo de ordenamiento Bubble Sort (Ordenamiento Burbuja) optimizado con bandera de intercambio, para ordenar un vector de números enteros (int[]) en orden ascendente, contabilizando con exactitud la cantidad de comparaciones e intercambios (`swaps`) realizados durante el proceso.

### Estrategia Elegida y Justificación
- Estrategia: Ordenamiento por intercambio adyacente repetido con bandera de parada temprana (`swapped`).
  * En cada pasada $i$ (desde 0 hasta $n-2$), se comparan pares de elementos adyacentes `vector[j]` y `vector[j+1]` para $j$ desde 0 hasta $n - 2 - i$. Si están fuera de orden (`vector[j] > vector[j+1]`), se intercambian.
  * Si en una pasada completa no se produce ningún intercambio, el arreglo ya se encuentra totalmente ordenado y el algoritmo finaliza de inmediato.
- Por qué es adecuado ÚNICAMENTE para fines didácticos o conjuntos pequeños de datos:
  1. Naturaleza cuadrática: Su complejidad temporal en el peor y caso promedio es de $O(n^2)$. Mientras que para $n = 50$ realiza aproximadamente 1.225 operaciones, para $n = 100.000$ requiere alrededor de $5.000.000.000$ operaciones, volviéndose ineficiente frente a algoritmos de complejidad $O(n \log n)$ como Quicksort, Mergesort o Timsort (utilizado internamente por `Arrays.sort()`).
  2. Alto costo de escritura: En arrays con orden inverso, Bubble Sort efectúa una cantidad cuadrática de intercambios en memoria, degradando el rendimiento en cachés y almacenamiento.
  3. Valor didáctico: Es conceptualmente el algoritmo de ordenamiento más intuitivo para comprender invariantes de bucle, conceptos de estabilidad, pasadas iterativas y optimizaciones con indicadores booleanos.

### Complejidad Esperada
- Complejidad Temporal:
  - Mejor Caso (con bandera de optimización): O(n) tiempo. Ocurre si el vector ya está ordenado de entrada. Se efectúa 1 pasada con $n-1$ comparaciones y 0 intercambios, detectando inmediatamente la bandera `false`.
  - Peor Caso: O(n²) tiempo. Ocurre si el vector está en orden inverso descendente. Requiere $n(n-1)/2$ comparaciones y $n(n-1)/2$ intercambios.
  - Caso Promedio: O(n²) tiempo (aproximadamente $n^2 / 2$ comparaciones e intercambios proporcionales).
- Complejidad Espacial:
  - O(1) memoria auxiliar (algoritmo in-place).

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `BubbleSort`).
- Estructura de métricas: Encapsular los resultados en una clase o registro `EstadisticasOrdenamiento(int[] vectorOrdenado, long comparaciones, long intercambios, int pasadasRealizadas)`.
- Método principal: `public static EstadisticasOrdenamiento ordenar(int[] vectorOriginal)`. Se recomienda clonar el vector de entrada antes de ordenar para no mutar inadvertidamente las pruebas o proveer versión in-place documentada.
- Buenas prácticas: Nombres claros, comentarios educativos que expliquen la lógica de la bandera de intercambio y la cota superior del bucle interno ($n - 1 - i$).

### Requisitos Específicos del Ejercicio
1. Explicar detalladamente antes del código y en los comentarios por qué Bubble Sort es apto solo con propósitos didácticos o datos reducidos, contrastándolo con $O(n \log n)$.
2. Contabilizar con precisión métrica la cantidad de comparaciones realizadas y la cantidad de intercambios (`swaps`) ejecutados.
3. Implementar la optimización mediante bandera booleana (`huboIntercambio`) para finalizar en $O(n)$ si el vector ya está ordenado.
4. Incluir un método `main` con casos de prueba ejecutables demostrativos:
   - Vector ordenado (mejor caso: $n-1$ comparaciones, 0 intercambios, 1 pasada).
   - Vector ordenado inversamente (peor caso: máximo de comparaciones e intercambios).
   - Vector con elementos aleatorios desordenados.
   - Vector con elementos duplicados (demostrando estabilidad del algoritmo).
   - Vector de un solo elemento o vacío.
5. Imprimir en consola el arreglo original, el arreglo ordenado, el total de pasadas, comparaciones e intercambios.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Justificación conceptual de la aplicabilidad restringida de Bubble Sort (didáctica vs. algoritmos eficientes en producción $O(n \log n)$).
2. Análisis formal de complejidades temporal (mejor, peor y promedio) y espacial.
3. Código Java completo, modular, con bandera de optimización, contadores y clase `Main`.
4. Salida por consola de los casos de prueba ejecutados en `main`.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Explicación de por qué Bubble Sort es adecuado únicamente para fines didácticos o conjuntos pequeños explicada antes del código.
- [x] Análisis formal de complejidad temporal (mejor O(n), peor y promedio O(n²)) y espacial O(1).
- [x] Requisito de contabilizar comparaciones e intercambios formalmente exigido.
- [x] Optimización de parada temprana por bandera requerida e implementada.
- [x] Requisitos del código Java especificados (clase con `main`, modularidad, comentarios).
- [x] Casos de prueba exhaustivos para mejor caso, peor caso y datos aleatorios.
- [x] Formato de salida ordenado y estructurado.

