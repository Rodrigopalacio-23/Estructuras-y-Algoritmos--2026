
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

/*
Prompt inicial utilizado:
# Ejercicio 10: Sistema de ranking de puntajes

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa para un sistema de ranking de videojuegos/deportes que reciba un arreglo de objetos de la clase Jugador (con atributos 'nombre' de tipo String y 'puntaje' de tipo int), y los ordene en orden descendente (de mayor a menor puntaje).

### Algoritmo Elegido y Justificación de la Elección
El algoritmo elegido es MergeSort (adaptado para orden descendente).
Justificación de por qué es la estrategia más conveniente para un sistema de ranking:
1. Requisito de Estabilidad (Stable Sort):
   En cualquier sistema de clasificación competitivo, es fundamental la estabilidad ante empates de puntaje. Si dos jugadores obtienen exactamente el mismo puntaje (por ejemplo, Ana con 1200 y Carlos con 1200), el ranking debe preservar su orden relativo original (quien alcanzó el puntaje primero o se registró antes conserva la ventaja de desempate).
   - Algoritmos como Quicksort y Selection Sort son INESTABLES: sus intercambios a larga distancia pueden invertir arbitrariamente el orden relativo de jugadores con puntajes idénticos.
   - MergeSort es ESTRICTAMENTE ESTABLE: durante la fase de combinación (merge), si izq[i].puntaje >= der[j].puntaje, se prioriza el elemento de la izquierda, preservando intacto el orden original.
2. Escalabilidad Asintótica y Tamaño de los Datos:
   En sistemas de producción los rankings pueden contener desde decenas hasta millones de usuarios. MergeSort garantiza una cota de tiempo O(n log n) en el peor, promedio y mejor caso, evitando las degradaciones cuadráticas O(n^2) de Insertion Sort, Bubble Sort o del peor caso de Quicksort.

### Datos que Recibe el Programa
Un arreglo de objetos Jugador con nombres y puntajes, conteniendo casos de desorden y casos de empate explícitos para comprobar la estabilidad:
- Jugador("Pedro", 900)
- Jugador("Ana", 1200)
- Jugador("Carlos", 1200)  <-- Empate con Ana
- Jugador("Lucia", 1500)
- Jugador("Martin", 800)
- Jugador("Sofia", 1500)   <-- Empate con Lucia

### Qué Debe Mostrar por Pantalla
1. La lista original de jugadores con su orden de registro inicial.
2. La justificación técnica de por qué se eligió MergeSort frente a alternativas inestables.
3. La tabla final del ranking ordenado de 1° puesto al último (de mayor a menor puntaje).
4. La comprobación explícita de estabilidad: verificar que en los empates (1500 y 1200), los jugadores mantuvieron su orden relativo de llegada.
5. Verificación formal de que los puntajes están en orden decreciente.

### Comentarios Requeridos en el Código
- Justificación en comentarios del operador '>=' en la fase de mezcla para preservar la estabilidad.
- Clase inmutable Jugador(String nombre, int puntaje).

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenadoRankingDescendente(Jugador[] array) y verificación de orden relativo en empates.
```

## Ajustes al prompt
Sin ajustes.
*/
