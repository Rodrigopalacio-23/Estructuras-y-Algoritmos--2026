package ejercicio05;

import java.util.Arrays;

/**
 * Ejercicio 5: Contar ocurrencias de un determinado valor en un vector.
 * 
 * Justificación de por qué el algoritmo necesita recorrer COMPLETAMENTE el vector:
 * A diferencia de una búsqueda de existencia simple (donde basta encontrar la primera coincidencia
 * para retornar verdadero y detener la ejecución), el conteo de frecuencia acumulada es una
 * operación de agregación global.
 * Omitir tan solo una posición sin inspeccionar dejaría abierta la posibilidad de ignorar una
 * ocurrencia válida del valor buscado, invalidando la exactitud del resultado final.
 * 
 * Análisis de Complejidad:
 * - Complejidad Temporal: Theta(n) estricta en el mejor, peor y caso promedio.
 *   El algoritmo realiza exactamente n comparaciones e inspecciones posicionales en todos los escenarios.
 * - Complejidad Espacial: O(1) memoria adicional auxiliar (solo se usa un contador y el índice de iteración).
 */
public class Main {

    /**
     * Cuenta la cantidad de veces que aparece un valor en el vector.
     *
     * @param vector   arreglo de enteros
     * @param objetivo valor a contabilizar
     * @return número de apariciones del objetivo
     */
    public static int contarOcurrencias(int[] vector, int objetivo) {
        if (vector == null || vector.length == 0) {
            return 0;
        }

        int contador = 0;
        // Recorrido exhaustivo O(n): no es posible aplicar corte temprano
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == objetivo) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 5: CONTAR OCURRENCIAS EN UN VECTOR");
        System.out.println("==================================================\n");

        int[] vectorPrueba = {4, 7, 2, 4, 9, 4, 1, 4, 8, 3};
        System.out.printf("Vector de prueba: %s (n = %d)\n\n", Arrays.toString(vectorPrueba), vectorPrueba.length);

        // Caso 1: Elemento presente múltiples veces
        int objetivo1 = 4;
        int rep1 = contarOcurrencias(vectorPrueba, objetivo1);
        System.out.printf("Caso 1: Contar '%d' -> Ocurrencias: %d (Recorridas %d posiciones)\n",
                objetivo1, rep1, vectorPrueba.length);

        // Caso 2: Elemento no presente
        int objetivo2 = 99;
        int rep2 = contarOcurrencias(vectorPrueba, objetivo2);
        System.out.printf("Caso 2: Contar '%d' -> Ocurrencias: %d (Recorridas %d posiciones)\n",
                objetivo2, rep2, vectorPrueba.length);

        // Caso 3: Todos los elementos coinciden
        int[] todosIguales = {5, 5, 5, 5, 5};
        int rep3 = contarOcurrencias(todosIguales, 5);
        System.out.printf("Caso 3: Todos iguales %s, contar '5' -> Ocurrencias: %d\n",
                Arrays.toString(todosIguales), rep3);

        // Caso 4: Vector unitario
        int[] unitario = {10};
        System.out.printf("Caso 4a: Vector unitario %s, contar '10' -> Ocurrencias: %d\n",
                Arrays.toString(unitario), contarOcurrencias(unitario, 10));
        System.out.printf("Caso 4b: Vector unitario %s, contar '20' -> Ocurrencias: %d\n",
                Arrays.toString(unitario), contarOcurrencias(unitario, 20));

        // Caso 5: Vector vacío
        System.out.printf("Caso 5: Vector vacío {}, contar '7' -> Ocurrencias: %d\n\n",
                contarOcurrencias(new int[]{}, 7));

        System.out.println("Verificación de Ejercicio 5 completada con éxito.");
    }
}

