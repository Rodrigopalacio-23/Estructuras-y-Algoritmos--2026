package analisis_algoritmos.ejercicio04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio 4: Detectar elementos duplicados en un vector.
 * 
 * Comparación entre ambas implementaciones:
 * 
 * 1. Solución con dos ciclos anidados:
 *    - Complejidad Temporal: O(n^2) en el peor caso y caso promedio (compara hasta n*(n-1)/2 pares).
 *      Mejor caso: O(1) si el duplicado está en las dos primeras posiciones.
 *    - Complejidad Espacial: O(1) memoria adicional auxiliar (algoritmo in-place).
 *    - Ventaja: No asigna memoria en el heap ni depende de colecciones adicionales.
 *    - Desventaja: Se vuelve inasumiblemente lenta para arreglos con miles de datos.
 * 
 * 2. Solución con HashSet:
 *    - Complejidad Temporal: O(n) tiempo promedio amortizado (cada inserción/búsqueda es O(1)).
 *      Mejor caso: O(1) si el duplicado se encuentra al inicio.
 *    - Complejidad Espacial: O(n) memoria auxiliar en el peor caso (almacena hasta n elementos).
 *    - Ventaja: Escalabilidad óptima para grandes volúmenes de datos.
 *    - Desventaja: Consumo adicional de memoria y costo de boxing Integer / Garbage Collection.
 */
public class Main {

    public record Resultado(boolean tieneDuplicados, long operaciones) {}

    /**
     * Detecta duplicados mediante fuerza bruta con dos ciclos for anidados.
     */
    public static Resultado contieneDuplicadosCiclos(int[] vector) {
        if (vector == null || vector.length <= 1) {
            return new Resultado(false, 0);
        }

        long comparaciones = 0;
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                comparaciones++;
                if (vector[i] == vector[j]) {
                    return new Resultado(true, comparaciones);
                }
            }
        }

        return new Resultado(false, comparaciones);
    }

    /**
     * Detecta duplicados utilizando una estructura de datos HashSet.
     */
    public static Resultado contieneDuplicadosHashSet(int[] vector) {
        if (vector == null || vector.length <= 1) {
            return new Resultado(false, 0);
        }

        Set<Integer> vistos = new HashSet<>();
        long operaciones = 0;

        for (int num : vector) {
            operaciones++;
            // set.add retorna false si el elemento ya estaba presente en la colección
            if (!vistos.add(num)) {
                return new Resultado(true, operaciones);
            }
        }

        return new Resultado(false, operaciones);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 4: DETECTAR ELEMENTOS DUPLICADOS");
        System.out.println("==================================================\n");

        int[][] casosPrueba = {
            {5, 5, 10, 20, 30},                 // Duplicado inmediato al inicio
            {1, 2, 3, 4, 5, 6, 7, 8, 1},         // Duplicado en los extremos
            {10, 20, 30, 40, 50, 60, 70, 80},   // Sin duplicados (peor caso)
            {9, 9, 9, 9},                       // Todos idénticos
            {42},                               // Un solo elemento
            {}                                  // Vector vacío
        };

        for (int i = 0; i < casosPrueba.length; i++) {
            int[] vec = casosPrueba[i];
            Resultado rCiclos = contieneDuplicadosCiclos(vec);
            Resultado rHash = contieneDuplicadosHashSet(vec);

            System.out.printf("Caso %d: Vector = %s\n", (i + 1), Arrays.toString(vec));
            System.out.printf("  [Ciclos Anidados] -> Duplicados: %-5b | Comparaciones: %d\n",
                    rCiclos.tieneDuplicados(), rCiclos.operaciones());
            System.out.printf("  [HashSet]         -> Duplicados: %-5b | Operaciones:   %d\n\n",
                    rHash.tieneDuplicados(), rHash.operaciones());
        }

        System.out.println("Verificación de Ejercicio 4 completada con éxito.");
    }
}

