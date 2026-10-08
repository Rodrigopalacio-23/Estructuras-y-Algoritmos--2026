# Ejercicio 2: Comparación entre Burbuja y Selección

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que compare cuantitativa y conceptualmente los algoritmos Bubble Sort (Burbuja) y Selection Sort (Selección) ordenando el mismo conjunto de datos enteros.

### Algoritmos a Utilizar y sus Métodos
Se deben implementar dos métodos estáticos:
1. bubbleSort(int[] array)
2. selectionSort(int[] array)
Ambos métodos deben ordenar copias idénticas del mismo arreglo original y retornar o reportar el número total de comparaciones e intercambios realizados.

### Razonamiento de Cada Algoritmo
1. Bubble Sort: Recorre el arreglo comparando pares adyacentes de elementos contiguos. Si están en orden incorrecto, realiza un intercambio inmediato en memoria. El mayor elemento se desplaza sucesivamente hacia la derecha.
2. Selection Sort: Divide el arreglo en una zona ordenada y una desordenada. En cada pasada, busca exhaustivamente el elemento mínimo absoluto dentro de la zona desordenada y, al final de la pasada, realiza a lo sumo un único intercambio para ubicarlo al inicio de dicha zona.

### Objetivo Conceptual: Comparar Vecinos vs. Buscar Directamente el Menor
El objetivo es razonar la diferencia estructural entre ambas filosofías:
- Comparar vecinos (Bubble Sort) puede provocar múltiples intercambios por pasada (hasta n - 1 intercambios en una sola pasada). Esto genera alta sobrecarga de escrituras en memoria RAM.
- Buscar directamente el menor (Selection Sort) pospone el movimiento físico de datos: realiza muchas comparaciones para encontrar el índice del mínimo, pero realiza como máximo 1 intercambio por pasada (exactamente a lo sumo n - 1 intercambios en todo el algoritmo). Selection Sort minimiza drásticamente las operaciones de escritura/intercambio en comparación con Bubble Sort.

### Datos que Recibe el Programa
Un arreglo de prueba desordenado, por ejemplo:
int[] numeros = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 45};

### Qué Debe Mostrar por Pantalla
1. El arreglo original.
2. Para Bubble Sort: arreglo ordenado, cantidad de comparaciones y cantidad de intercambios.
3. Para Selection Sort: arreglo ordenado, cantidad de comparaciones y cantidad de intercambios.
4. Una tabla comparativa que contraste las métricas y destaque cuál hizo menos escrituras.

### Comentarios Requeridos en el Código
- Comentarios explicando el conteo de comparaciones e intercambios en ambos bucles.
- Comentarios explicando la lógica del índice mínimo (minIdx) en Selection Sort.

### Cómo Verificar que el Resultado es Correcto
- Verificar que ambos arreglos resultantes estén ordenados ascendentemente mediante una función de validación booleana.
- Verificar que ambos resultados sean idénticos elemento a elemento.
```

## Ajustes al prompt
Sin ajustes.

