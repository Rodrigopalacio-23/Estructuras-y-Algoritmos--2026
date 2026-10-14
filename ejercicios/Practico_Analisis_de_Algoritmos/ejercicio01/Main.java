
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

/*
Prompt inicial utilizado:
# Ejercicio 1 – Encontrar el mínimo de un vector

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que encuentre el valor mínimo de un vector de números enteros.
Antes de pedir el código, el prompt debe explicar la estrategia que considerás más adecuada para resolver el problema, justificar por qué esa estrategia es la correcta e indicar la complejidad temporal y espacial esperada.
Además, el prompt debe solicitar que el código esté comentado y que explique por qué no es necesario ordenar el vector para encontrar el valor mínimo.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java un algoritmo óptimo para encontrar el valor mínimo en un vector de números enteros (int[]).

### Estrategia Elegida y Justificación
- Estrategia: Recorrido lineal secuencial en una única pasada (Single-pass Linear Scan). Se inicializa una variable 'min' con el primer elemento del vector y se recorre desde el segundo hasta el último elemento, actualizando 'min' cada vez que se encuentre un valor menor.
- Justificación: Para determinar con certeza el valor mínimo en una colección no ordenada, es matemáticamente obligatorio examinar cada elemento al menos una vez (cota inferior de información Ω(n)). Esta estrategia realiza exactamente n-1 comparaciones, siendo óptima en tiempo y espacio.
- Por qué no es necesario ordenar: Ordenar el vector previo a tomar el primer elemento requeriría al menos O(n log n) mediante algoritmos basados en comparación (como Quicksort o Mergesort), o O(n) con memoria adicional (Counting sort). Ordenar realiza trabajo computacional redundante e innecesario, degradando el rendimiento respecto a una búsqueda directa O(n).

### Complejidad Esperada
- Complejidad Temporal: O(n) en el peor, promedio y mejor caso (donde n es la cantidad de elementos), ya que se debe comprobar cada posición para garantizar que no existe un elemento menor.
- Complejidad Espacial: O(1) memoria adicional auxiliar, ya que solo se utiliza una variable para rastrear el mínimo y el índice del bucle.

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `MinimoVector`).
- Estructura: Incluye un método estático `public static int encontrarMinimo(int[] vector)` y un método `public static void main(String[] args)` con casos de prueba ejecutables.
- Validación: Debe manejar casos borde (vector nulo o vacío) lanzando `IllegalArgumentException` con un mensaje descriptivo.
- Buenas prácticas: Nomenclatura descriptiva, código limpio y comentarios explicativos claros (especialmente detallando la toma de decisiones y por qué no se ordena el arreglo).

### Requisitos Específicos del Ejercicio
1. Explicar en los comentarios del código por qué no es necesario ordenar el vector para encontrar el valor mínimo.
2. Incluir casos de prueba en el método `main`:
   - Vector con elementos desordenados positivos y negativos.
   - Vector con un único elemento.
   - Vector donde el mínimo se encuentra al inicio.
   - Vector donde el mínimo se encuentra al final.
   - Vector con elementos duplicados.
   - Manejo de excepción para vector vacío.
3. Imprimir por consola el vector evaluado y el valor mínimo obtenido de forma legible.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Resumen conceptual de la estrategia y justificación de por qué no se debe ordenar el arreglo.
2. Análisis formal de complejidad temporal y espacial (Big-O).
3. Código Java completo, limpio y documentado con comentarios formativos.
4. Salida esperada por consola al ejecutar los casos de prueba en `main`.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Estrategia elegida explicada y justificada antes del código (recorrido lineal).
- [x] Explicación de por qué no es necesario ordenar el vector incluida en la justificación y en los requisitos del código.
- [x] Complejidad temporal O(n) y espacial O(1) especificadas formalmente.
- [x] Requisitos de código Java detallados (comentarios explicativos, clase con `main`, validaciones, nombres limpios).
- [x] Casos de prueba completos para validación en ejecución.
- [x] Formato de salida estructurado y ordenado.
*/
