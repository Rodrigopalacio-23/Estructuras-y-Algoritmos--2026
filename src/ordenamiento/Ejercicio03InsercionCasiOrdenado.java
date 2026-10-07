package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 3: Ordenamiento por Inserción con arreglo casi ordenado.
 * 
 * Objetivo:
 * Demostrar por qué Insertion Sort es un algoritmo altamente eficiente (adaptativo)
 * en arreglos casi ordenados, logrando complejidad cercana a O(n) al minimizar los desplazamientos.
 */
public class Ejercicio03InsercionCasiOrdenado {

    public record MetricasInsercion(int[] resultado, long comparaciones, long desplazamientos) {}

    /**
     * Ordena un arreglo usando Insertion Sort y contabiliza comparaciones y desplazamientos.
     */
    public static MetricasInsercion insertionSort(int[] array) {
        int[] arr = array.clone();
        int n = arr.length;
        long comparaciones = 0;
        long desplazamientos = 0;

        System.out.printf("Arreglo inicial: %s\n\n", Arrays.toString(arr));

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            int desplazamientosPaso = 0;

            // Bucle while: desplaza hacia la derecha los elementos mayores que 'key'
            while (j >= 0) {
                comparaciones++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j]; // Desplazamiento
                    desplazamientos++;
                    desplazamientosPaso++;
                    j--;
                } else {
                    // Corte temprano: elemento en su posición relativa correcta
                    break;
                }
            }
            arr[j + 1] = key;

            System.out.printf("Paso i=%d: Evaluando key=%d -> Desplazamientos en este paso: %d | Arreglo: %s\n",
                    i, key, desplazamientosPaso, Arrays.toString(arr));
        }

        return new MetricasInsercion(arr, comparaciones, desplazamientos);
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println(" EJERCICIO 3: INSERTION SORT SOBRE ARREGLO CASI ORDENADO");
        System.out.println("===============================================================\n");

        int[] numeros = {1, 2, 3, 5, 4, 6, 7};

        MetricasInsercion metricas = insertionSort(numeros);

        System.out.println("\n--- RESULTADOS FINALES ---");
        System.out.printf("Arreglo ordenado:      %s\n", Arrays.toString(metricas.resultado()));
        System.out.printf("Total comparaciones:   %d\n", metricas.comparaciones());
        System.out.printf("Total desplazamientos: %d\n", metricas.desplazamientos());
        System.out.printf("¿Ordenamiento correcto? %b\n\n", estaOrdenado(metricas.resultado()));

        System.out.println("Justificación del rendimiento:");
        System.out.println("Al estar casi ordenado, casi todos los elementos ya están en su posición");
        System.out.println("definitiva (requiriendo 1 sola comparación y 0 desplazamientos por paso).");
        System.out.println("Solo el elemento '4' necesitó desplazarse 1 posición hacia atrás.");
    }
}

