package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 6: Quicksort con primer elemento como pivote.
 * 
 * Objetivo:
 * Relacionar el algoritmo Quicksort con la técnica de Divide y Vencerás y recursividad,
 * mostrando el pivote seleccionado y los subarreglos izquierdo y derecho tras cada partición.
 */
public class Ejercicio06QuicksortPrimerPivote {

    /**
     * Método público principal de ordenamiento Quicksort.
     */
    public static void quicksort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(array));
        quicksortRecursivo(array, 0, array.length - 1, 1);
    }

    /**
     * Función recursiva de Divide y Vencerás.
     */
    private static void quicksortRecursivo(int[] array, int inicio, int fin, int nivel) {
        // CASO BASE: Subarreglos de 0 o 1 elemento ya están ordenados
        if (inicio >= fin) {
            return;
        }

        // Selección del pivote: primer elemento del rango actual
        int valorPivote = array[inicio];

        // Partición Lomuto adaptada al primer elemento como pivote:
        // Colocamos temporalmente el pivote al final para usar Lomuto canónico,
        // o particionamos directamente intercambiando al inicio.
        int indiceParticion = particionarPrimerPivote(array, inicio, fin);

        // Extracción visual de subarreglos izquierdo y derecho
        int[] subIzq = Arrays.copyOfRange(array, inicio, indiceParticion);
        int[] subDer = Arrays.copyOfRange(array, indiceParticion + 1, fin + 1);

        System.out.printf("[Nivel %d | Rango %d..%d]\n", nivel, inicio, fin);
        System.out.printf("   Pivote elegido:       %d (quedó en índice %d)\n", valorPivote, indiceParticion);
        System.out.printf("   Subarreglo izquierdo: %s\n", Arrays.toString(subIzq));
        System.out.printf("   Subarreglo derecho:   %s\n", Arrays.toString(subDer));
        System.out.printf("   Arreglo actual:       %s\n\n", Arrays.toString(array));

        // Llamadas recursivas (Vencer)
        quicksortRecursivo(array, inicio, indiceParticion - 1, nivel + 1);
        quicksortRecursivo(array, indiceParticion + 1, fin, nivel + 1);
    }

    /**
     * Particiona el rango [inicio, fin] tomando array[inicio] como pivote.
     * Retorna la posición definitiva del pivote.
     */
    private static int particionarPrimerPivote(int[] array, int inicio, int fin) {
        int pivote = array[inicio];
        int i = inicio + 1;

        for (int j = inicio + 1; j <= fin; j++) {
            if (array[j] < pivote) {
                // Intercambiar array[i] y array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        // Ubicar el pivote en su posición definitiva (i - 1)
        int posDefinitiva = i - 1;
        array[inicio] = array[posDefinitiva];
        array[posDefinitiva] = pivote;

        return posDefinitiva;
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println(" EJERCICIO 6: QUICKSORT CON PRIMER ELEMENTO COMO PIVOTE");
        System.out.println("===============================================================\n");

        int[] numeros = {54, 26, 93, 17, 77, 31, 44, 55, 20};

        quicksort(numeros);

        System.out.printf("Arreglo final ordenado: %s\n", Arrays.toString(numeros));
        boolean verificado = estaOrdenado(numeros);
        System.out.printf("¿Verificación de orden correcto? %b\n", verificado);
    }
}

