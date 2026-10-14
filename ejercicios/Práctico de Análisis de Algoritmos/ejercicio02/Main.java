package practico_analisis_algoritmos.ejercicio02;

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

/*
Prompt inicial utilizado:
# Ejercicio 2 – Buscar un elemento en un vector desordenado

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que busque un elemento dentro de un vector desordenado.
El prompt debe indicar la estrategia que utilizará el algoritmo, justificar por qué esa estrategia es la adecuada y solicitar el análisis del mejor caso, peor caso y caso promedio.
También debe pedir que el programa informe cuántas posiciones fueron recorridas hasta encontrar el elemento o determinar que no existe.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java un algoritmo de búsqueda lineal (secuencial) para localizar un elemento específico dentro de un vector desordenado de enteros (int[]), reportando el índice de coincidencia y el número exacto de posiciones examinadas durante la búsqueda.

### Estrategia Elegida y Justificación
- Estrategia: Búsqueda Lineal Secuencial con detención temprana (Short-circuit Linear Search). El algoritmo itera índice por índice desde la posición 0 hacia adelante, incrementando un contador de posiciones examinadas en cada iteración y deteniéndose inmediatamente apenas se encuentra la primera coincidencia del elemento buscado. Si se alcanza el final del arreglo sin coincidencias, se concluye que el elemento no existe.
- Justificación: Dado que los elementos se encuentran en un vector desordenado (sin ningún invariante de orden previo), no existe ninguna información probabilística ni topológica que permita descartar mitades o rangos de búsqueda. En consecuencia, la búsqueda lineal es la única estrategia determinista válida y completa que garantiza examinar los datos sin incurrir en el sobrecosto computacional previo de ordenar el vector.

### Complejidad Esperada
Solicita el análisis detallado de los tres casos:
- Mejor Caso (Best Case): O(1) tiempo. Ocurre cuando el elemento buscado se encuentra en la primera posición examinada (índice 0). Se realiza 1 sola comparación y 1 posición recorrida.
- Peor Caso (Worst Case): O(n) tiempo. Ocurre cuando el elemento está en la última posición (índice n-1) o no existe en el vector. Se recorren las n posiciones del arreglo realizando n comparaciones.
- Caso Promedio (Average Case): O(n) tiempo (específicamente (n+1)/2 comparaciones si el elemento está presente con probabilidad uniforme, o n si no está).
- Complejidad Espacial: O(1) memoria adicional auxiliar en todos los casos, ya que únicamente se emplean variables primitivas escalares para iteración y conteo.

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `BusquedaLineal`).
- Estructura y encapsulamiento: Define una clase o registro inmutable para encapsular el resultado de la búsqueda: `ResultadoBusqueda(int indice, int posicionesRecorridas, boolean encontrado)`.
- Método principal de búsqueda: `public static ResultadoBusqueda buscar(int[] vector, int objetivo)`.
- Manejo de casos borde: Validar vector nulo o de longitud 0 retornando un resultado coherente (no encontrado, 0 posiciones recorridas).
- Buenas prácticas: Nombres semánticos, métodos pequeños, comentarios explicativos sobre la lógica del algoritmo y los escenarios de ejecución.

### Requisitos Específicos del Ejercicio
1. Llevar la cuenta estricta e informar cuántas posiciones fueron recorridas hasta encontrar el elemento o determinar fehacientemente que no existe.
2. Interrumpir el ciclo de búsqueda de inmediato tan pronto como se produzca la coincidencia (detención temprana).
3. Incluir un método `main` con casos de prueba demostrativos ejecutables que evidencien claramente:
   - Caso Mejor: elemento ubicado en el índice 0 (1 posición recorrida).
   - Caso Peor (encontrado al final): elemento ubicado en la última posición (n posiciones recorridas).
   - Caso Peor (no existente): elemento no presente en el vector (n posiciones recorridas).
   - Caso Intermedio/Promedio: elemento ubicado en una posición intermedia.
4. Imprimir por consola para cada caso: el vector, el elemento buscado, si fue hallado, el índice y la cantidad de posiciones evaluadas.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Explicación de la estrategia de búsqueda lineal y justificación de por qué es la óptima para datos desordenados.
2. Análisis comparativo formal de complejidades: Mejor caso, Peor caso y Caso promedio, junto con la complejidad espacial.
3. Código Java completo, modular y comentado, con clase `Main` y casos de prueba claros.
4. Salida esperada por consola que muestre la ejecución de los casos y los contadores de posiciones.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Estrategia de búsqueda lineal indicada y justificada antes del código para datos desordenados.
- [x] Análisis explícito del mejor caso, peor caso y caso promedio requerido e incluido en el prompt.
- [x] Requisito de contabilizar e informar las posiciones recorridas implementado mediante estructura de resultado y contador.
- [x] Complejidad temporal y espacial formalmente detalladas.
- [x] Requisitos de código Java especificados (clase con `main`, validaciones, nombres claros y comentarios).
- [x] Casos de prueba exhaustivos que ilustran mejor caso, peor caso y elemento no existente.
- [x] Formato de salida ordenado y estructurado.
*/
