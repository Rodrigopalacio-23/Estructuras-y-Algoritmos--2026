package practico_analisis_algoritmos.ejercicio08;

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

/*
Prompt inicial utilizado:
# Ejercicio 8 – Sumar todos los elementos de una matriz

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que calcule la suma de todos los elementos de una matriz.
El prompt debe indicar cómo se recorrerá la matriz, solicitar el análisis de la complejidad y pedir que el programa contabilice la cantidad de operaciones realizadas.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java un algoritmo que calcule la suma total de todos los elementos de una matriz bidimensional de enteros (`int[][]`), recorriéndola de forma canónica por filas y columnas, contabilizando de manera explícita la cantidad de operaciones elementales (accesos e iteraciones) realizadas durante el cálculo.

### Estrategia Elegida y Justificación
- Estrategia: Recorrido matricial por filas (Row-Major Order Traversal) mediante dos bucles anidados.
  * Bucle externo: Itera sobre el índice de las filas `i` desde 0 hasta `matriz.length - 1`.
  * Bucle interno: Itera sobre el índice de las columnas `j` desde 0 hasta `matriz[i].length - 1` (permitiendo matrices cuadradas, rectangulares e irregulares/jagged).
  * Acumulación: En cada celda `(i, j)`, se suma `matriz[i][j]` a un acumulador `long sumaTotal` para prevenir desbordamientos aritméticos con grandes valores.
- Justificación: En la arquitectura de memoria de la JVM (donde una matriz `int[][]` es en realidad un arreglo de arreglos o referencias a filas), recorrer por orden mayor de filas aprovecha el principio de localidad espacial y temporal del procesador (acceso secuencial a cada sub-arreglo en la caché L1/L2), evitando fallos de caché innecesarios.

### Complejidad Esperada
- Complejidad Temporal:
  - Para una matriz de dimensiones $N \times M$ (donde $N$ es el número de filas y $M$ el de columnas): O(N × M) o O(Total de celdas).
  - Cada celda se visita y se suma exactamente una vez; no hay mejor ni peor caso diferenciado: es invariante $\Theta(N \times M)$.
- Complejidad Espacial:
  - O(1) memoria auxiliar, ya que solo se emplean variables primitivas escalares para el acumulador, los índices de iteración y el contador de operaciones.

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `SumaMatriz`).
- Estructura de resultado: Encapsular la respuesta en una clase/registro inmutable: `ResultadoSuma(long sumaTotal, long operacionesRealizadas, int totalFilas, int totalColumnas)`.
- Método de cálculo: `public static ResultadoSuma sumarMatriz(int[][] matriz)`.
- Manejo de casos borde: Matriz nula, matriz vacía (0 filas), filas vacías (longitud 0), matrices irregulares (jagged arrays donde las filas tienen distinta longitud).
- Tipos de datos: Utilizar `long` para la variable acumuladora para prevenir desbordamiento aritmético si la matriz contiene números grandes.
- Buenas prácticas: Nombres claros, comentarios educativos que expliquen el orden de recorrido en memoria y el conteo de operaciones.

### Requisitos Específicos del Ejercicio
1. Indicar explícitamente cómo se recorrerá la matriz (recorrido por filas y columnas o Row-Major Order con soporte para matrices irregulares).
2. Solicitar el análisis formal de complejidad temporal y espacial ($O(N \times M)$ y $O(1)$).
3. Pedir que el programa contabilice e informe la cantidad de operaciones realizadas (número de accesos a celdas y operaciones de suma efectuadas).
4. Incluir un método `main` con casos de prueba ejecutables:
   - Matriz cuadrada estándar (ej: $3 \times 3$).
   - Matriz rectangular con más columnas que filas (ej: $2 \times 4$).
   - Matriz con números positivos, negativos y ceros.
   - Matriz irregular (ragged/jagged array con filas de diferentes longitudes).
   - Matriz vacía o nula.
5. Imprimir la matriz en formato visual de tabla, la suma calculada y la cantidad de operaciones contabilizadas.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Explicación de la estrategia de recorrido (Row-Major Order) y su justificación en la arquitectura de memoria.
2. Análisis formal de complejidad temporal y espacial.
3. Código Java completo, modular y documentado con clase `Main` y casos de prueba.
4. Salida por consola de la ejecución de las pruebas con sus matrices y contadores de operaciones.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Indicación y justificación del modo de recorrido de la matriz (Row-Major Order) explicadas antes del código.
- [x] Análisis formal de complejidad temporal y espacial solicitado.
- [x] Requisito de contabilizar e informar la cantidad de operaciones realizadas implementado mediante estructura de resultado.
- [x] Soporte para matrices cuadradas, rectangulares e irregulares (jagged arrays).
- [x] Requisitos del código Java especificados (acumulador `long`, validaciones, clase `Main`, comentarios).
- [x] Casos de prueba exhaustivos en `main`.
- [x] Formato de salida ordenado y estructurado.
*/
