package analisis_algoritmos.ejercicio08;

import java.util.Arrays;

/**
 * Ejercicio 8: Sumar todos los elementos de una matriz contabilizando operaciones.
 * 
 * Modo de Recorrido:
 * Recorrido por orden mayor de filas (Row-Major Order Traversal).
 * Se recorre fila por fila (índice i) y dentro de cada fila se recorren sus columnas (índice j).
 * Este orden aprovecha la disposición de memoria en la JVM y la localidad espacial de la memoria caché.
 * 
 * Análisis de Complejidad:
 * - Complejidad Temporal: Theta(N * M) en todos los casos, donde N es el número de filas
 *   y M la cantidad de columnas promedio. Cada celda es visitada y acumulada exactamente una vez.
 * - Complejidad Espacial: O(1) memoria auxiliar (variables escalares para el acumulador y contadores).
 */
public class Main {

    public record ResultadoSuma(long sumaTotal, long operacionesRealizadas, int celdasVisitadas) {}

    /**
     * Calcula la suma total de los elementos de una matriz bidimensional (incluso si es irregular),
     * contabilizando la cantidad exacta de operaciones de acceso y acumulación efectuadas.
     */
    public static ResultadoSuma sumarMatriz(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            return new ResultadoSuma(0, 0, 0);
        }

        long suma = 0;
        long operaciones = 0; // Contabiliza accesos y sumas a celdas
        int celdas = 0;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] != null) {
                for (int j = 0; j < matriz[i].length; j++) {
                    operaciones++; // Acceso y adición
                    celdas++;
                    suma += matriz[i][j];
                }
            }
        }

        return new ResultadoSuma(suma, operaciones, celdas);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 8: SUMAR ELEMENTOS DE UNA MATRIZ");
        System.out.println("==================================================\n");

        // 1. Matriz Cuadrada 3x3
        int[][] cuadrada = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 2. Matriz Rectangular 2x4
        int[][] rectangular = {
            {10, 20, 30, 40},
            {50, 60, 70, 80}
        };

        // 3. Matriz con valores negativos y ceros
        int[][] mixta = {
            {-15, 0, 25},
            {10, -5, -30}
        };

        // 4. Matriz irregular (Jagged Array)
        int[][] irregular = {
            {1, 2},
            {3, 4, 5, 6},
            {7}
        };

        // 5. Matriz vacía
        int[][] vacia = {};

        probarMatriz("1. Matriz Cuadrada 3x3", cuadrada);
        probarMatriz("2. Matriz Rectangular 2x4", rectangular);
        probarMatriz("3. Matriz con Negativos", mixta);
        probarMatriz("4. Matriz Irregular (Jagged Array)", irregular);
        probarMatriz("5. Matriz Vacía", vacia);

        System.out.println("Verificación de Ejercicio 8 completada con éxito.");
    }

    private static void probarMatriz(String titulo, int[][] matriz) {
        System.out.println("--- " + titulo + " ---");
        for (int[] fila : matriz) {
            System.out.println("   " + Arrays.toString(fila));
        }
        ResultadoSuma res = sumarMatriz(matriz);
        System.out.printf("   -> Suma Total: %d | Operaciones realizadas: %d | Celdas evaluadas: %d\n\n",
                res.sumaTotal(), res.operacionesRealizadas(), res.celdasVisitadas());
    }
}

