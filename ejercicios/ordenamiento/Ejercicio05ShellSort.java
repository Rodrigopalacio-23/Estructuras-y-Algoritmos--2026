package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 5: ShellSort explicando los gaps.
 * 
 * Objetivo:
 * Explicar y mostrar cómo ShellSort mejora a Insertion Sort permitiendo saltos largos
 * entre elementos separados por un intervalo (gap), eliminando inversiones a distancia.
 */
public class Ejercicio05ShellSort {

    /**
     * Ordena el arreglo usando ShellSort, imprimiendo el gap y el estado en cada etapa.
     *
     * @param array arreglo a ordenar
     */
    public static void shellSortConGaps(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(array));

        int etapa = 1;

        // Bucle exterior de reducción de gaps: comienza en n / 2 y se divide por 2 hasta gap == 1
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.printf("--- Etapa %d: gap = %d ---\n", etapa++, gap);

            // Se realiza un ordenamiento por inserción con espaciado 'gap'
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                // Desplaza elementos de la sublista espaciada hasta encontrar la posición de 'temp'
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }

            System.out.printf("   Estado del arreglo tras procesar gap = %d:\n   %s\n\n",
                    gap, Arrays.toString(array));
        }
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 5: SHELLSORT EXPLICANDO LOS GAPS");
        System.out.println("==================================================\n");

        int[] numeros = {35, 14, 9, 87, 45, 62, 18, 53, 29, 6};

        shellSortConGaps(numeros);

        System.out.printf("Arreglo final ordenado: %s\n", Arrays.toString(numeros));
        boolean verificado = estaOrdenado(numeros);
        System.out.printf("¿Verificación de orden correcto? %b\n\n", verificado);

        System.out.println("Explicación del beneficio de los gaps:");
        System.out.println("Al usar gaps grandes (5, 2), elementos pequeños como '6' se desplazaron");
        System.out.println("rápidamente hacia la izquierda en pocos saltos, dejando el arreglo");
        System.out.println("casi ordenado para la fase final con gap = 1.");
    }
}

