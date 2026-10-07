package analisis_algoritmos.ejercicio02;

import java.util.Arrays;

/**
 * Ejercicio 2: Búsqueda lineal en un vector desordenado.
 * 
 * Análisis de Complejidad:
 * - Mejor Caso: O(1) tiempo. El elemento está en la primera posición examinada (índice 0).
 * - Peor Caso: O(n) tiempo. El elemento está en la última posición (índice n-1) o no existe.
 * - Caso Promedio: O(n) tiempo. Se recorren en promedio (n + 1) / 2 posiciones si el elemento está presente.
 * - Complejidad Espacial: O(1) memoria adicional auxiliar.
 */
public class Main {

    /**
     * Registro inmutable que almacena el resultado de la búsqueda lineal.
     */
    public record ResultadoBusqueda(int indice, int posicionesRecorridas, boolean encontrado) {}

    /**
     * Busca un elemento en un vector desordenado utilizando búsqueda lineal con detención temprana.
     *
     * @param vector   arreglo de enteros donde se realizará la búsqueda
     * @param objetivo valor que se desea encontrar
     * @return objeto con el índice, cantidad de posiciones recorridas y si fue encontrado
     */
    public static ResultadoBusqueda buscar(int[] vector, int objetivo) {
        if (vector == null || vector.length == 0) {
            return new ResultadoBusqueda(-1, 0, false);
        }

        int posiciones = 0;
        for (int i = 0; i < vector.length; i++) {
            posiciones++;
            if (vector[i] == objetivo) {
                // Detención temprana en la primera coincidencia
                return new ResultadoBusqueda(i, posiciones, true);
            }
        }

        // Si se recorrió todo el vector sin encontrarlo
        return new ResultadoBusqueda(-1, posiciones, false);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 2: BÚSQUEDA LINEAL EN VECTOR DESORDENADO");
        System.out.println("==================================================\n");

        int[] vector = {18, 42, 9, 73, 5, 27, 91, 14};
        System.out.printf("Vector de prueba (tamaño %d): %s\n\n", vector.length, Arrays.toString(vector));

        // 1. Mejor Caso: elemento en la primera posición
        int objetivoMejor = 18;
        ResultadoBusqueda resMejor = buscar(vector, objetivoMejor);
        System.out.println("--- 1. MEJOR CASO (Elemento en índice 0) ---");
        System.out.printf("Objetivo: %d -> Encontrado: %b, Índice: %d, Posiciones recorridas: %d\n\n",
                objetivoMejor, resMejor.encontrado(), resMejor.indice(), resMejor.posicionesRecorridas());

        // 2. Caso Promedio: elemento en posición intermedia
        int objetivoPromedio = 73;
        ResultadoBusqueda resPromedio = buscar(vector, objetivoPromedio);
        System.out.println("--- 2. CASO PROMEDIO (Elemento intermedio) ---");
        System.out.printf("Objetivo: %d -> Encontrado: %b, Índice: %d, Posiciones recorridas: %d\n\n",
                objetivoPromedio, resPromedio.encontrado(), resPromedio.indice(), resPromedio.posicionesRecorridas());

        // 3. Peor Caso (Encontrado al final): elemento en la última posición
        int objetivoFinal = 14;
        ResultadoBusqueda resFinal = buscar(vector, objetivoFinal);
        System.out.println("--- 3. PEOR CASO (Elemento al final del arreglo) ---");
        System.out.printf("Objetivo: %d -> Encontrado: %b, Índice: %d, Posiciones recorridas: %d\n\n",
                objetivoFinal, resFinal.encontrado(), resFinal.indice(), resFinal.posicionesRecorridas());

        // 4. Peor Caso (No existe): elemento ausente en el vector
        int objetivoInexistente = 999;
        ResultadoBusqueda resInexistente = buscar(vector, objetivoInexistente);
        System.out.println("--- 4. PEOR CASO (Elemento inexistente) ---");
        System.out.printf("Objetivo: %d -> Encontrado: %b, Índice: %d, Posiciones recorridas: %d\n\n",
                objetivoInexistente, resInexistente.encontrado(), resInexistente.indice(), resInexistente.posicionesRecorridas());

        System.out.println("Verificación de Ejercicio 2 completada con éxito.");
    }
}

