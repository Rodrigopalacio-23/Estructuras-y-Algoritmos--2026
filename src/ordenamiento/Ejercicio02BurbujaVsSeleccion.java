package ordenamiento;

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

