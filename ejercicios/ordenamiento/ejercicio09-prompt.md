# Ejercicio 9: Comparación de algoritmos simples

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que compare empírica y conceptualmente los tres algoritmos clásicos elementales de complejidad O(n^2): Bubble Sort, Selection Sort e Insertion Sort, ordenando copias idénticas del mismo arreglo desordenado.

### Algoritmos a Implementar y Métricas
1. Bubble Sort: contabiliza comparaciones e intercambios (swaps).
2. Selection Sort: contabiliza comparaciones e intercambios (swaps).
3. Insertion Sort: contabiliza comparaciones y desplazamientos (shifts).

### Objetivo Conceptual: Comparar Estrategias y no solo el Resultado Final
El objetivo es analizar el trade-off operativo intrínseco de cada estrategia:
- Bubble Sort (estrategia reactiva local): compara vecinos e intercambia ante cualquier desorden. Realiza tanto comparaciones elevadas O(n^2) como escrituras elevadas O(n^2).
- Selection Sort (estrategia selectiva global): busca el mínimo en toda la lista no ordenada. Hace comparaciones sistemáticas O(n^2), pero minimiza las escrituras al extremo: como máximo n - 1 intercambios en total (O(n)).
- Insertion Sort (estrategia incremental adaptativa): inserta en una lista ordenada contigua. En el peor caso (inverso) es O(n^2), pero en arreglos con orden parcial o uniforme realiza muchos menos desplazamientos y comparaciones que los otros dos, deteniéndose tempranamente por cada elemento.

### Datos que Recibe el Programa
Un arreglo desordenado de enteros de tamaño moderado:
int[] numeros = {42, 12, 88, 23, 71, 5, 34, 99, 15, 60};

### Qué Debe Mostrar por Pantalla
1. El arreglo original.
2. Resultados individuales de cada algoritmo: arreglo ordenado, cantidad de comparaciones y cantidad de intercambios/desplazamientos.
3. Tabla comparativa consolidada.
4. Verificación formal de que los tres algoritmos produjeron exactamente el mismo arreglo ordenado.

### Comentarios Requeridos en el Código
- Explicación de la diferencia entre 'intercambio' (swap de 2 elementos) y 'desplazamiento' (shift de 1 celda).
- Justificación teórica del perfil de rendimiento de cada algoritmo.

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenado(int[] array) y comparación cruzada Arrays.equals() entre los tres resultados.
```

## Ajustes al prompt
Sin ajustes.

