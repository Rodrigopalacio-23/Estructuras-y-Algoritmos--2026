package ejercicio09;

import java.util.Arrays;

/**
 * Ejercicio 9: Encontrar el mayor elemento de una matriz.
 * 
 * Justificación de por qué es NECESARIO recorrer todos los elementos:
 * En una matriz arbitraria desordenada, no existe ninguna relación de monotonía o estructura
 * que permita predecir la magnitud de un elemento sin leer su valor directamente.
 * Omitir una sola celda abre la posibilidad ineludible de que en ella se encuentre un valor
 * estrictamente mayor que el máximo temporalmente encontrado.
 * Por lo tanto, para asegurar la exactitud matemática del resultado, se deben examinar
 * exhaustivamente todas las celdas N * M (cota inferior de información Omega(N * M)).
 * 
 * Análisis de Complejidad:
 * - Complejidad Temporal: Theta(N * M) en el mejor, peor y caso promedio.
 * - Complejidad Espacial: O(1) memoria adicional auxiliar.
 */
public class Main {

    public record ResultadoMayor(int valorMaximo, int fila, int columna, int elementosExaminados) {}

    /**
     * Encuentra el mayor elemento de una matriz y sus coordenadas de fila y columna.
     *
     * @param matriz matriz bidimensional de enteros
     * @return resultado con el valor máximo, posición y total de celdas evaluadas
     * @throws IllegalArgumentException si la matriz es nula, vacía o no tiene celdas válidas
     */
    public static ResultadoMayor encontrarMayor(int[][] matriz) {
        if (matriz == null || matriz.length == 0) {
            throw new IllegalArgumentException("La matriz no puede ser nula ni vacía.");
        }

        // Buscar la primera celda válida para inicializar el máximo
        boolean inicializado = false;
        int maximo = Integer.MIN_VALUE;
        int filaMax = -1;
        int colMax = -1;
        int examinados = 0;

        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i] != null) {
                for (int j = 0; j < matriz[i].length; j++) {
                    examinados++;
                    if (!inicializado) {
                        maximo = matriz[i][j];
                        filaMax = i;
                        colMax = j;
                        inicializado = true;
                    } else if (matriz[i][j] > maximo) {
                        maximo = matriz[i][j];
                        filaMax = i;
                        colMax = j;
                    }
                }
            }
        }

        if (!inicializado) {
            throw new IllegalArgumentException("La matriz no contiene ninguna celda válida.");
        }

        return new ResultadoMayor(maximo, filaMax, colMax, examinados);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 9: ENCONTRAR EL MAYOR ELEMENTO DE UNA MATRIZ");
        System.out.println("==================================================\n");

        // 1. Matriz con números exclusivamente negativos (demuestra inicialización correcta)
        int[][] soloNegativos = {
            {-45, -12, -80},
            {-6,  -99, -15},
            {-23, -31, -7}
        };

        // 2. Mayor en la primera posición (0, 0)
        int[][] mayorInicio = {
            {500, 20, 10},
            {15,  40, 99}
        };

        // 3. Mayor en la última posición
        int[][] mayorFin = {
            {10, 20, 30},
            {40, 50, 999}
        };

        // 4. Matriz irregular (Jagged Array)
        int[][] irregular = {
            {5, 12},
            {8, 88, 14, 2},
            {19}
        };

        probar("1. Matriz con exclusivamente números negativos", soloNegativos);
        probar("2. Mayor ubicado en la primera celda (0, 0)", mayorInicio);
        probar("3. Mayor ubicado en la última celda", mayorFin);
        probar("4. Matriz irregular", irregular);

        System.out.println("Verificación de Ejercicio 9 completada con éxito.");
    }

    private static void probar(String titulo, int[][] matriz) {
        System.out.println("--- " + titulo + " ---");
        for (int[] fila : matriz) {
            System.out.println("   " + Arrays.toString(fila));
        }
        ResultadoMayor res = encontrarMayor(matriz);
        System.out.printf("   -> Mayor Valor: %d en posición [%d][%d] | Celdas evaluadas: %d\n\n",
                res.valorMaximo(), res.fila(), res.columna(), res.elementosExaminados());
    }
}

