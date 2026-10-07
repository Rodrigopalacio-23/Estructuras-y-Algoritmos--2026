package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 10: Sistema de ranking de puntajes.
 * 
 * Elección de Algoritmo y Justificación:
 * Se elige MergeSort (adaptado a orden descendente).
 * 1. Estabilidad (Stable Sort): Ante empates de puntaje, es vital respetar el orden de mérito
 *    o llegada previo. MergeSort garantiza estabilidad natural (a diferencia de Quicksort o Selection Sort).
 * 2. Rendimiento predecible: Ofrece O(n log n) garantizado en todo escenario, adaptándose
 *    tanto a rankings pequeños como a millones de jugadores.
 */
public class Ejercicio10RankingPuntajes {

    /**
     * Representación inmutable de un Jugador.
     */
    public record Jugador(String nombre, int puntaje) {
        @Override
        public String toString() {
            return String.format("%-10s (%d pts)", nombre, puntaje);
        }
    }

    /**
     * Ordena el ranking de mayor a menor puntaje de forma ESTABLE usando MergeSort.
     *
     * @param jugadores arreglo de jugadores
     */
    public static void ordenarRanking(Jugador[] jugadores) {
        if (jugadores == null || jugadores.length <= 1) {
            return;
        }
        mergeSortDescendente(jugadores, 0, jugadores.length - 1);
    }

    private static void mergeSortDescendente(Jugador[] array, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }

        int medio = inicio + (fin - inicio) / 2;
        mergeSortDescendente(array, inicio, medio);
        mergeSortDescendente(array, medio + 1, fin);

        fusionarDescendente(array, inicio, medio, fin);
    }

    private static void fusionarDescendente(Jugador[] array, int inicio, int medio, int fin) {
        Jugador[] izq = Arrays.copyOfRange(array, inicio, medio + 1);
        Jugador[] der = Arrays.copyOfRange(array, medio + 1, fin + 1);

        int i = 0, j = 0, k = inicio;

        // IMPORTANTE PARA ESTABILIDAD:
        // Usar '>=' en lugar de '>' asegura que si dos jugadores empatan en puntaje,
        // el jugador de la sublista izquierda (registrado antes) mantiene la precedencia.
        while (i < izq.length && j < der.length) {
            if (izq[i].puntaje() >= der[j].puntaje()) {
                array[k++] = izq[i++];
            } else {
                array[k++] = der[j++];
            }
        }

        while (i < izq.length) {
            array[k++] = izq[i++];
        }
        while (j < der.length) {
            array[k++] = der[j++];
        }
    }

    public static boolean estaOrdenadoDescendente(Jugador[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].puntaje() < array[i + 1].puntaje()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" EJERCICIO 10: SISTEMA DE RANKING DE PUNTAJES (MERGESORT)");
        System.out.println("==========================================================\n");

        Jugador[] jugadores = {
            new Jugador("Pedro", 900),
            new Jugador("Ana", 1200),     // Empate 1200 (primero en registrarse)
            new Jugador("Carlos", 1200),  // Empate 1200 (segundo en registrarse)
            new Jugador("Lucia", 1500),   // Empate 1500 (primero en registrarse)
            new Jugador("Martin", 800),
            new Jugador("Sofia", 1500)    // Empate 1500 (segundo en registrarse)
        };

        System.out.println("Orden original de registro de jugadores:");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.printf("   %d. %s\n", (i + 1), jugadores[i]);
        }

        ordenarRanking(jugadores);

        System.out.println("\n--- TABLA DE RANKING FINAL (DE MAYOR A MENOR) ---");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.printf("   Puesto %d: %s\n", (i + 1), jugadores[i]);
        }

        System.out.println("\n--- VERIFICACIÓN DE ESTABILIDAD Y ORDEN ---");
        boolean ordenOk = estaOrdenadoDescendente(jugadores);
        System.out.printf("¿Orden descendente correcto? %b\n", ordenOk);

        // Verificación de estabilidad ante empates
        boolean empate1500Ok = jugadores[0].nombre().equals("Lucia") && jugadores[1].nombre().equals("Sofia");
        boolean empate1200Ok = jugadores[2].nombre().equals("Ana") && jugadores[3].nombre().equals("Carlos");
        System.out.printf("¿Estabilidad preservada en empate de 1500 pts (Lucia antes que Sofia)? %b\n", empate1500Ok);
        System.out.printf("¿Estabilidad preservada en empate de 1200 pts (Ana antes que Carlos)?  %b\n\n", empate1200Ok);

        System.out.println("Conclusión sobre la elección:");
        System.out.println("MergeSort fue la elección óptima porque además de su tiempo O(n log n),");
        System.out.println("garantizó la ESTABILIDAD que Quicksort o Selection Sort habrían roto.");
    }
}
