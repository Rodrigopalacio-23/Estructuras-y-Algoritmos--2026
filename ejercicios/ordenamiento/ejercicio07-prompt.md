# Ejercicio 7: Peor caso de Quicksort

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ejecute Quicksort (con el primer elemento como pivote) sobre un arreglo que ya se encuentra ordenado, contabilizando exactamente la cantidad de llamadas recursivas y de comparaciones realizadas.

### Algoritmo y Razonamiento
Se utiliza la implementación de Quicksort con el primer elemento como pivote sobre un arreglo de entrada ya ordenado en orden ascendente.

### Objetivo Conceptual: ¿Por qué elegir siempre el primer elemento como pivote genera el peor caso en datos ordenados?
1. Desbalance extremo en la partición: En un caso óptimo o promedio, el pivote divide el arreglo aproximadamente a la mitad (subarreglos de tamaño n/2 y n/2), generando un árbol de recursión de altura balanceada O(log n) y tiempo O(n log n).
2. Sin embargo, si el arreglo ya está ordenado y se elige el primer elemento como pivote, dicho pivote es el menor elemento absoluto de todo el rango.
   - En consecuencia, el subarreglo izquierdo queda completamente vacío (tamaño 0).
   - El subarreglo derecho contiene todos los restantes elementos (tamaño n - 1).
3. Degradación cuadrática: La reducción del problema no es exponencial sino lineal (de n a n - 1 en cada nivel). La profundidad del árbol de recursión alcanza n niveles, requiriendo n llamadas recursivas y sumando n + (n - 1) + ... + 1 = n(n + 1)/2 comparaciones.
4. Por ende, la complejidad temporal se degrada a su peor caso O(n^2), y además existe riesgo de desbordamiento de pila (StackOverflowError) en arreglos grandes.

### Datos que Recibe el Programa
El arreglo del enunciado:
int[] numeros = {1, 2, 3, 4, 5, 6, 7};

### Qué Debe Mostrar por Pantalla
1. El arreglo inicial (ya ordenado).
2. El registro de cada partición (mostrando el desbalance: subarreglo izquierdo vacío de tamaño 0 y subarreglo derecho de tamaño n - 1).
3. Total de llamadas recursivas realizadas.
4. Total de comparaciones ejecutadas.
5. Explicación del contraste entre el caso promedio O(n log n) y la degradación O(n^2).
6. Verificación de que el arreglo sigue ordenado.

### Comentarios Requeridos en el Código
- Comentarios explicando el contador de llamadas recursivas.
- Comentarios resaltando el desbalance de las particiones (0 vs k - 1).

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenado(int[] array).
```

## Ajustes al prompt
Sin ajustes.

