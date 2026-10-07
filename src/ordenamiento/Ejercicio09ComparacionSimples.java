package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 9: Comparación de algoritmos simples (Burbuja, Selección e Inserción).
 * 
 * Objetivo:
 * Comparar empíricamente las tres estrategias elementales O(n^2),
 * analizando el compromiso entre comparaciones y movimientos de datos (intercambios vs desplazamientos).
 */
public class Ejercicio09ComparacionSimples {

    public record Resultado(String nombre, int[] ordenado, long comparaciones, long movimientos, String tipoMovimiento) {}

    public static Resultado bubbleSort(int[] original) {
        int[] arr = original.clone();
        int n = arr.length;
        long comp = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean huboSwap = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comp++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                    huboSwap = true;
                }
            }
            if (!huboSwap) break;
        }

        return new Resultado("Bubble Sort", arr, comp, swaps, "intercambios");
    }

    public static Resultado selectionSort(int[] original) {
        int[] arr = original.clone();
        int n = arr.length;
        long comp = 0, swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
                swaps++;
            }
        }

        return new Resultado("Selection Sort", arr, comp, swaps, "intercambios");
    }

    public static Resultado insertionSort(int[] original) {
        int[] arr = original.clone();
        int n = arr.length;
        long comp = 0, shifts = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0) {
                comp++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    shifts++;
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }

        return new Resultado("Insertion Sort", arr, comp, shifts, "desplazamientos");
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=====================================================================");
        System.out.println(" EJERCICIO 9: COMPARACIÓN DE ALGORITMOS SIMPLES (O(n^2))");
        System.out.println("=====================================================================\n");

        int[] numeros = {42, 12, 88, 23, 71, 5, 34, 99, 15, 60};
        System.out.printf("Arreglo base: %s (n = %d)\n\n", Arrays.toString(numeros), numeros.length);

        Resultado rBubble = bubbleSort(numeros);
        Resultado rSelection = selectionSort(numeros);
        Resultado rInsertion = insertionSort(numeros);

        Resultado[] resultados = {rBubble, rSelection, rInsertion};

        System.out.printf("%-16s | %-15s | %-24s | %s\n",
                "Algoritmo", "Comparaciones", "Movimientos de datos", "¿Ordenado?");
        System.out.println("-----------------+-----------------+--------------------------+-----------");

        for (Resultado r : resultados) {
            boolean ok = estaOrdenado(r.ordenado());
            System.out.printf("%-16s | %-15d | %-4d %-19s | %b\n",
                    r.nombre(), r.comparaciones(), r.movimientos(), "(" + r.tipoMovimiento() + ")", ok);
        }

        System.out.println("\nVerificación cruzada de resultados idénticos:");
        boolean identicos = Arrays.equals(rBubble.ordenado(), rSelection.ordenado())
                && Arrays.equals(rSelection.ordenado(), rInsertion.ordenado());
        System.out.printf("¿Todos produjeron exactamente el mismo arreglo? %b\n\n", identicos);

        System.out.println("Conclusión pedagógica:");
        System.out.println("- Selection Sort minimiza los movimientos físicos (solo " + rSelection.movimientos() + " intercambios).");
        System.out.println("- Insertion Sort realiza menos comparaciones (" + rInsertion.comparaciones() + ") gracias a su corte adaptativo.");
        System.out.println("- Bubble Sort combina el peor perfil en ambos aspectos (" + rBubble.comparaciones() + " comp, " + rBubble.movimientos() + " swaps).");
    }
}

