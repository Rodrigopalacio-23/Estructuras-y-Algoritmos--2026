package analisis_algoritmos.ejercicio10;

import java.util.Arrays;

/**
 * Ejercicio 10: Bubble Sort (Ordenamiento Burbuja) con contadores.
 * 
 * ¿Por qué Bubble Sort es adecuado ÚNICAMENTE para fines didácticos o conjuntos pequeños?
 * 1. Complejidad Cuadrática: Su tiempo de ejecución crece a O(n^2). Para 100 elementos realiza
 *    alrededor de 5.000 operaciones; pero para 100.000 elementos requeriría 5.000.000.000 de operaciones,
 *    volviéndose prohibitivo en comparación con algoritmos O(n log n) como Quicksort, Mergesort o Timsort.
 * 2. Sobrecarga de escritura: Realiza una cantidad excesiva de escrituras e intercambios en memoria,
 *    afectando las jerarquías de caché de procesadores modernos.
 * 3. Valor didáctico: Es el algoritmo ideal para enseñar invariantes de ciclos, el concepto de pasadas,
 *    estabilidad de ordenamiento y optimizaciones mediante banderas booleanas.
 * 
 * Complejidad:
 * - Mejor Caso: O(n) tiempo (cuando ya está ordenado, 1 sola pasada con bandera activa).
 * - Peor Caso: O(n^2) tiempo (cuando está en orden estrictamente inverso).
 * - Caso Promedio: O(n^2) tiempo.
 * - Complejidad Espacial: O(1) memoria auxiliar (in-place).
 */
public class Main {

    public record EstadisticasOrdenamiento(int[] vectorOrdenado, long comparaciones, long intercambios, int pasadas) {}

    /**
     * Ordena una copia del vector recibido usando Bubble Sort optimizado con bandera booleana,
     * registrando con precisión las comparaciones e intercambios realizados.
     */
    public static EstadisticasOrdenamiento ordenar(int[] vectorOriginal) {
        if (vectorOriginal == null) {
            return new EstadisticasOrdenamiento(new int[]{}, 0, 0, 0);
        }

        int[] arr = vectorOriginal.clone();
        int n = arr.length;
        long comparaciones = 0;
        long intercambios = 0;
        int pasadas = 0;

        for (int i = 0; i < n - 1; i++) {
            pasadas++;
            boolean huboIntercambio = false;

            // Bucle interno: los últimos i elementos ya están en su posición definitiva
            for (int j = 0; j < n - 1 - i; j++) {
                comparaciones++;
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    intercambios++;
                    huboIntercambio = true;
                }
            }

            // Optimización: si no hubo ningún swap en toda la pasada, el vector ya está ordenado
            if (!huboIntercambio) {
                break;
            }
        }

        return new EstadisticasOrdenamiento(arr, comparaciones, intercambios, pasadas);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 10: ORDENAMIENTO BURBUJA (BUBBLE SORT)");
        System.out.println("==================================================\n");

        // 1. Mejor Caso: Vector ya ordenado
        int[] yaOrdenado = {1, 2, 3, 4, 5, 6, 7};
        probar("1. MEJOR CASO (Vector previamente ordenado)", yaOrdenado);

        // 2. Peor Caso: Vector ordenado en sentido inverso
        int[] inverso = {7, 6, 5, 4, 3, 2, 1};
        probar("2. PEOR CASO (Vector en orden inverso)", inverso);

        // 3. Caso Promedio: Elementos desordenados
        int[] desordenado = {64, 34, 25, 12, 22, 11, 90};
        probar("3. CASO PROMEDIO (Desorden arbitrario)", desordenado);

        // 4. Elementos duplicados (demostrando estabilidad)
        int[] conDuplicados = {5, 2, 8, 5, 1, 9, 2};
        probar("4. ELEMENTOS CON DUPLICADOS", conDuplicados);

        System.out.println("Verificación de Ejercicio 10 completada con éxito.");
    }

    private static void probar(String titulo, int[] original) {
        System.out.println("--- " + titulo + " ---");
        System.out.printf("   Original:     %s (n = %d)\n", Arrays.toString(original), original.length);
        EstadisticasOrdenamiento res = ordenar(original);
        System.out.printf("   Ordenado:     %s\n", Arrays.toString(res.vectorOrdenado()));
        System.out.printf("   Estadísticas: Pasadas: %d | Comparaciones: %d | Intercambios (swaps): %d\n\n",
                res.pasadas(), res.comparaciones(), res.intercambios());
    }
}

