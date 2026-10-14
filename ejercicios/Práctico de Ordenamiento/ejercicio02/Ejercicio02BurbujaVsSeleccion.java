package practico_ordenamiento.ejercicio02;

import java.util.Arrays;

/**
 * Ejercicio 2: Comparación entre Burbuja y Selección.
 * 
 * Objetivo:
 * Razonar la diferencia fundamental entre comparar vecinos continuos (Bubble Sort)
 * frente a buscar directamente el menor de la zona desordenada e intercambiar una sola vez (Selection Sort).
 */
public class Ejercicio02BurbujaVsSeleccion {

    public record MetricasOrdenamiento(String algoritmo, int[] resultado, long comparaciones, long intercambios) {}

    /**
     * Ordenamiento Burbuja: Compara vecinos adyacentes y realiza intercambios inmediatos.
     */
    public static MetricasOrdenamiento bubbleSort(int[] array) {
        int[] arr = array.clone();
        int n = arr.length;
        long comparaciones = 0;
        long intercambios = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean huboSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambios++;
                    huboSwap = true;
                }
            }
            if (!huboSwap) break;
        }

        return new MetricasOrdenamiento("Bubble Sort", arr, comparaciones, intercambios);
    }

    /**
     * Ordenamiento por Selección: Busca el mínimo en la porción no ordenada
     * y realiza como máximo un único intercambio por pasada.
     */
    public static MetricasOrdenamiento selectionSort(int[] array) {
        int[] arr = array.clone();
        int n = arr.length;
        long comparaciones = 0;
        long intercambios = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            // Busca el índice del elemento mínimo en arr[i ... n-1]
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // A lo sumo 1 intercambio por pasada
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                intercambios++;
            }
        }

        return new MetricasOrdenamiento("Selection Sort", arr, comparaciones, intercambios);
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" EJERCICIO 2: COMPARACIÓN BUBBLE SORT VS SELECTION SORT");
        System.out.println("==========================================================\n");

        int[] numeros = {45, 12, 85, 32, 89, 39, 69, 44, 42, 1, 45};
        System.out.printf("Arreglo original: %s (n = %d)\n\n", Arrays.toString(numeros), numeros.length);

        MetricasOrdenamiento mBubble = bubbleSort(numeros);
        MetricasOrdenamiento mSelection = selectionSort(numeros);

        System.out.println("1. RESULTADOS BUBBLE SORT:");
        System.out.printf("   Ordenado:      %s\n", Arrays.toString(mBubble.resultado()));
        System.out.printf("   Comparaciones: %d\n", mBubble.comparaciones());
        System.out.printf("   Intercambios:  %d (múltiples swaps entre vecinos)\n\n", mBubble.intercambios());

        System.out.println("2. RESULTADOS SELECTION SORT:");
        System.out.printf("   Ordenado:      %s\n", Arrays.toString(mSelection.resultado()));
        System.out.printf("   Comparaciones: %d\n", mSelection.comparaciones());
        System.out.printf("   Intercambios:  %d (a lo sumo 1 swap por pasada)\n\n", mSelection.intercambios());

        System.out.println("3. VERIFICACIÓN Y ANÁLISIS COMPARATIVO:");
        System.out.printf("   ¿Bubble Sort ordenó correctamente?    %b\n", estaOrdenado(mBubble.resultado()));
        System.out.printf("   ¿Selection Sort ordenó correctamente? %b\n", estaOrdenado(mSelection.resultado()));
        System.out.printf("   ¿Arreglos idénticos?                  %b\n\n",
                Arrays.equals(mBubble.resultado(), mSelection.resultado()));

        System.out.println("   Conclusión: Selection Sort reduce drásticamente las escrituras");
        System.out.printf("   (%d intercambios vs %d de Bubble Sort), aunque ambos realizan comparaciones O(n^2).\n",
                mSelection.intercambios(), mBubble.intercambios());
    }
}

/*
Prompt inicial utilizado:
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
*/
