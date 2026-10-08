package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 7: Peor caso de Quicksort.
 * 
 * Objetivo:
 * Explicar por qué elegir siempre el primer elemento como pivote genera un mal rendimiento (O(n^2))
 * cuando el arreglo ya está ordenado, contabilizando el número de llamadas recursivas y particiones desbalanceadas.
 */
public class Ejercicio07QuicksortPeorCaso {

    private static int contadorLlamadas = 0;
    private static int contadorComparaciones = 0;

    public static void quicksortPeorCaso(int[] array) {
        contadorLlamadas = 0;
        contadorComparaciones = 0;
        if (array == null || array.length <= 1) {
            return;
        }

        System.out.printf("Arreglo inicial ya ordenado: %s (n = %d)\n\n",
                Arrays.toString(array), array.length);

        quicksortRecursivo(array, 0, array.length - 1);
    }

    private static void quicksortRecursivo(int[] array, int inicio, int fin) {
        contadorLlamadas++;

        // Caso base
        if (inicio >= fin) {
            return;
        }

        int tamanoActual = fin - inicio + 1;
        int pivote = array[inicio];

        // Partición con pivote = array[inicio]
        int indiceParticion = particionar(array, inicio, fin);

        int tamIzq = indiceParticion - inicio;
        int tamDer = fin - indiceParticion;

        System.out.printf("Llamada #%-2d | Rango [%d..%d] (tam=%d) -> Pivote: %d en pos %d | SubIzq tam: %d | SubDer tam: %d\n",
                contadorLlamadas, inicio, fin, tamanoActual, pivote, indiceParticion, tamIzq, tamDer);

        // Llamadas recursivas desbalanceadas (uno de los lados tiene tamaño 0)
        quicksortRecursivo(array, inicio, indiceParticion - 1);
        quicksortRecursivo(array, indiceParticion + 1, fin);
    }

    private static int particionar(int[] array, int inicio, int fin) {
        int pivote = array[inicio];
        int i = inicio + 1;

        for (int j = inicio + 1; j <= fin; j++) {
            contadorComparaciones++;
            if (array[j] < pivote) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        int pos = i - 1;
        array[inicio] = array[pos];
        array[pos] = pivote;
        return pos;
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 7: PEOR CASO DE QUICKSORT");
        System.out.println("==================================================\n");

        int[] numeros = {1, 2, 3, 4, 5, 6, 7};

        quicksortPeorCaso(numeros);

        System.out.println("\n--- MÉTRICAS Y ANÁLISIS ---");
        System.out.printf("Arreglo final:                %s\n", Arrays.toString(numeros));
        System.out.printf("Total llamadas recursivas:    %d\n", contadorLlamadas);
        System.out.printf("Total comparaciones en part.: %d\n", contadorComparaciones);
        System.out.printf("¿Verificación orden correcto? %b\n\n", estaOrdenado(numeros));

        System.out.println("Explicación del mal rendimiento:");
        System.out.println("Al estar ya ordenado, el primer elemento siempre es el menor.");
        System.out.println("El subarreglo izquierdo siempre queda vacío (tam = 0) y el derecho");
        System.out.println("contiene todos los demás (tam = n - 1). La recursión se vuelve lineal");
        System.out.println("en lugar de árbol binario balanceado, degenerando a O(n^2).");
    }
}

