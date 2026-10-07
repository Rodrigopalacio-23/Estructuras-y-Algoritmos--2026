package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 1: Ordenamiento Burbuja paso a paso.
 * 
 * Objetivo:
 * Explicar y mostrar cómo el elemento de mayor valor se desplaza paulatinamente
 * hacia el final del arreglo tras cada pasada.
 */
public class Ejercicio01Burbuja {

    /**
     * Ordena el arreglo utilizando Bubble Sort e imprime el estado tras cada pasada.
     *
     * @param array arreglo de enteros a ordenar
     */
    public static void bubbleSortPasoAPaso(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(array));

        // Bucle externo: controla la cantidad de pasadas (hasta n - 1 pasadas)
        for (int i = 0; i < n - 1; i++) {
            boolean huboIntercambio = false;

            // Bucle interno: compara elementos vecinos adyacentes.
            // Cota j < n - 1 - i:
            // En cada pasada i, el i-ésimo elemento más grande ya "burbujeó"
            // y se consolidó en su posición definitiva al final del arreglo.
            for (int j = 0; j < n - 1 - i; j++) {
                // Si el elemento actual es mayor que su vecino derecho, se intercambian
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    huboIntercambio = true;
                }
            }

            // Muestra del estado del arreglo al concluir la pasada actual
            System.out.printf("Pasada %d: %s  -> Elemento asegurado al final: %d\n",
                    (i + 1), Arrays.toString(array), array[n - 1 - i]);

            // Optimización: si no hubo intercambios, el arreglo ya está ordenado
            if (!huboIntercambio) {
                System.out.println("   [Aviso] No hubo intercambios en esta pasada: el arreglo ya está ordenado.");
                break;
            }
        }
    }

    /**
     * Función de verificación de orden ascendente.
     */
    public static boolean estaOrdenado(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 1: BUBBLE SORT PASO A PASO");
        System.out.println("==================================================\n");

        int[] numeros = {64, 34, 25, 12, 22, 11, 90};

        bubbleSortPasoAPaso(numeros);

        System.out.printf("\nArreglo final: %s\n", Arrays.toString(numeros));
        boolean verificado = estaOrdenado(numeros);
        System.out.printf("¿Verificación de orden correcto? %b\n", verificado);
    }
}

