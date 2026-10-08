package analisis_algoritmos.ejercicio07;

import java.util.Arrays;

/**
 * Ejercicio 7: Invertir un vector mediante dos versiones distintas.
 * 
 * Comparación entre ambas implementaciones:
 * 
 * 1. Versión con Vector Auxiliar (Out-of-place):
 *    - Complejidad Temporal: O(n) tiempo (recorre los n elementos una vez).
 *    - Complejidad Espacial: O(n) memoria auxiliar (crea un nuevo array en el heap).
 *    - Ventajas: Es inmutable y no destructiva; preserva intactos los datos originales.
 *    - Desventajas: Duplica el uso de memoria RAM y genera sobrecarga para el Garbage Collector.
 * 
 * 2. Versión In-situ con Dos Punteros (In-place):
 *    - Complejidad Temporal: O(n) tiempo (realiza exactamente n / 2 intercambios).
 *    - Complejidad Espacial: O(1) memoria auxiliar (solo variables primitivas temporales).
 *    - Ventajas: Eficiencia máxima de recursos; consumo de memoria constante.
 *    - Desventajas: Mutación destructiva del arreglo original; requiere clonar previamente
 *      si otros hilos o métodos necesitan la instancia original.
 */
public class Main {

    /**
     * Versión 1: Invierte el vector retornando una nueva instancia con un vector auxiliar.
     */
    public static int[] invertirConAuxiliar(int[] vector) {
        if (vector == null) {
            return null;
        }

        int n = vector.length;
        int[] auxiliar = new int[n];

        for (int i = 0; i < n; i++) {
            auxiliar[n - 1 - i] = vector[i];
        }

        return auxiliar;
    }

    /**
     * Versión 2: Invierte el vector directamente sobre el arreglo original (in-place)
     * empleando la técnica de dos punteros contrapuestos.
     */
    public static void invertirInSitu(int[] vector) {
        if (vector == null || vector.length <= 1) {
            return;
        }

        int izq = 0;
        int der = vector.length - 1;

        while (izq < der) {
            // Intercambio elemental (swap)
            int temp = vector[izq];
            vector[izq] = vector[der];
            vector[der] = temp;

            izq++;
            der--;
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 7: INVERTIR UN VECTOR (2 VERSIONES)");
        System.out.println("==================================================\n");

        int[][] bancosPrueba = {
            {1, 2, 3, 4, 5},     // Longitud impar
            {10, 20, 30, 40},    // Longitud par
            {99},                // Un solo elemento
            {}                   // Vector vacío
        };

        for (int i = 0; i < bancosPrueba.length; i++) {
            int[] original = bancosPrueba[i];
            System.out.printf("--- CASO %d: Entrada original = %s ---\n", (i + 1), Arrays.toString(original));

            // Prueba Versión 1 (Vector Auxiliar)
            int[] invertidoAux = invertirConAuxiliar(original);
            System.out.printf("  [Versión Auxiliar] -> Resultado:  %s\n", Arrays.toString(invertidoAux));
            System.out.printf("                        Original:   %s (Preservado intacto)\n", Arrays.toString(original));

            // Prueba Versión 2 (In-situ)
            int[] copiaParaInSitu = original.clone();
            invertirInSitu(copiaParaInSitu);
            System.out.printf("  [Versión In-situ]  -> Modificado: %s (Mutado in-place sin memoria O(1))\n\n",
                    Arrays.toString(copiaParaInSitu));
        }

        System.out.println("Verificación de Ejercicio 7 completada con éxito.");
    }
}

