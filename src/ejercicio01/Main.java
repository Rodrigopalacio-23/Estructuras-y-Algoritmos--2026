package ejercicio01;

import java.util.Arrays;

/**
 * Ejercicio 1: Encontrar el valor mínimo de un vector de enteros.
 * 
 * Justificación algorítmica:
 * Para encontrar el valor mínimo en una colección no ordenada, es indispensable examinar
 * cada elemento al menos una vez (cota inferior Omega(n)).
 * 
 * ¿Por qué NO es necesario ordenar el vector?
 * Ordenar el arreglo previamente implicaría un costo temporal mínimo de O(n log n)
 * con algoritmos basados en comparaciones (Quicksort, Mergesort) o O(n) con memoria adicional.
 * Dicho trabajo es redundante e ineficiente, ya que una búsqueda lineal directa resuelve
 * el problema en tiempo lineal O(n) y memoria constante O(1), realizando exactamente n-1 comparaciones.
 */
public class Main {

    /**
     * Encuentra el valor mínimo en un arreglo de enteros mediante un recorrido lineal en una sola pasada.
     *
     * @param vector arreglo de enteros a evaluar
     * @return el valor mínimo presente en el arreglo
     * @throws IllegalArgumentException si el arreglo es nulo o está vacío
     */
    public static int encontrarMinimo(int[] vector) {
        if (vector == null || vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede ser nulo ni estar vacío.");
        }

        // Inicializamos con el primer elemento como candidato a mínimo
        int minimo = vector[0];

        // Recorrido lineal desde la segunda posición: O(n) tiempo, O(1) memoria auxiliar
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < minimo) {
                minimo = vector[i];
            }
        }

        return minimo;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 1: ENCONTRAR EL MÍNIMO DE UN VECTOR");
        System.out.println("==================================================\n");

        int[][] casosPrueba = {
            {34, -5, 12, 89, -23, 0, 45}, // Mixto con negativos y positivos
            {42},                         // Un solo elemento
            {-100, 5, 20, 80},            // Mínimo al inicio
            {50, 40, 30, 20, 10},         // Mínimo al final (orden inverso)
            {7, 7, 7, 7, 7},              // Elementos idénticos
            {15, 3, 9, 3, 15, 3}          // Duplicados del mínimo
        };

        for (int i = 0; i < casosPrueba.length; i++) {
            int[] vector = casosPrueba[i];
            int min = encontrarMinimo(vector);
            System.out.printf("Caso %d: Vector = %s\n", (i + 1), Arrays.toString(vector));
            System.out.printf("        Mínimo encontrado = %d\n\n", min);
        }

        // Caso borde: Vector vacío
        System.out.println("Caso 7 (Borde): Vector vacío {}");
        try {
            encontrarMinimo(new int[]{});
        } catch (IllegalArgumentException e) {
            System.out.printf("        Excepción capturada correctamente: %s\n\n", e.getMessage());
        }

        System.out.println("Verificación de Ejercicio 1 completada con éxito.");
    }
}

