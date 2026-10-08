package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 8: MergeSort paso a paso.
 * 
 * Objetivo:
 * Mostrar claramente la diferencia entre la fase de división geométrica hacia la condición de corte
 * y la fase de fusión (merge) donde realmente se comparan y combinan los elementos ordenados.
 */
public class Ejercicio08MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(array));
        mergeSortRecursivo(array, 0, array.length - 1, 1);
    }

    private static void mergeSortRecursivo(int[] array, int inicio, int fin, int nivel) {
        // CONDICIÓN DE CORTE: tamaño 1 (o 0)
        if (inicio >= fin) {
            System.out.printf("[Corte Nivel %d] Rango [%d..%d] -> Elemento único: [%d] (Ya ordenado por caso base)\n",
                    nivel, inicio, fin, array[inicio]);
            return;
        }

        int medio = inicio + (fin - inicio) / 2;

        // FASE 1: DIVISIÓN
        int[] subIzq = Arrays.copyOfRange(array, inicio, medio + 1);
        int[] subDer = Arrays.copyOfRange(array, medio + 1, fin + 1);
        System.out.printf("[División Nivel %d] Rango [%d..%d] -> Izq: %s | Der: %s\n",
                nivel, inicio, fin, Arrays.toString(subIzq), Arrays.toString(subDer));

        // Llamadas recursivas
        mergeSortRecursivo(array, inicio, medio, nivel + 1);
        mergeSortRecursivo(array, medio + 1, fin, nivel + 1);

        // FASE 2: FUSIÓN (MERGE)
        fusionar(array, inicio, medio, fin, nivel);
    }

    private static void fusionar(int[] array, int inicio, int medio, int fin, int nivel) {
        int[] izq = Arrays.copyOfRange(array, inicio, medio + 1);
        int[] der = Arrays.copyOfRange(array, medio + 1, fin + 1);

        System.out.printf("   >>> [Fusión Nivel %d] Fusionando %s con %s\n",
                nivel, Arrays.toString(izq), Arrays.toString(der));

        int i = 0, j = 0, k = inicio;

        // Intercalación ordenada de elementos de ambas mitades
        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) { // '<=' garantiza estabilidad
                array[k++] = izq[i++];
            } else {
                array[k++] = der[j++];
            }
        }

        // Copiar remanentes
        while (i < izq.length) {
            array[k++] = izq[i++];
        }
        while (j < der.length) {
            array[k++] = der[j++];
        }

        int[] fusionado = Arrays.copyOfRange(array, inicio, fin + 1);
        System.out.printf("   <<< [Resultado Fusión] Rango [%d..%d] consolidado: %s\n\n",
                inicio, fin, Arrays.toString(fusionado));
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 8: MERGESORT PASO A PASO");
        System.out.println("==================================================\n");

        int[] numeros = {38, 27, 43, 3, 9, 82, 10};

        mergeSort(numeros);

        System.out.printf("Arreglo final ordenado: %s\n", Arrays.toString(numeros));
        boolean verificado = estaOrdenado(numeros);
        System.out.printf("¿Verificación de orden correcto? %b\n", verificado);
    }
}

