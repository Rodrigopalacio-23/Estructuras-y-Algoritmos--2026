/*
Quiero implementar en Java una función recursiva que calcule el factorial de un número entero no negativo n (n!).

Este problema puede resolverse recursivamente porque matemáticamente el factorial de un número n se define en términos del factorial del número anterior: n! = n * (n - 1)!. Por lo tanto, el cálculo de un problema mayor depende directamente de resolver el mismo subproblema para un tamaño menor.

El caso base es cuando n es 0 o 1 (n <= 1), porque por definición matemática factorial(0) = 1 y factorial(1) = 1. En estos casos el resultado se conoce de forma inmediata sin necesidad de realizar más llamadas recursivas.

El caso recursivo es n * factorial(n - 1), porque en cada llamada el valor de n se reduce en una unidad (n - 1), disminuyendo el espacio del problema y acercándose estrictamente al caso base n <= 1 para evitar recursión infinita.

La función debe devolver un número entero largo (long) con el resultado del factorial de n.

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas (call stack), detallando cómo se apilan los marcos hasta el caso base y cómo se desapilan multiplicando los retornos.

También quiero probarlo con estos casos:
- caso 1: n = 0 (caso base inmediato, resultado 1)
- caso 2: n = 1 (caso base inmediato, resultado 1)
- caso 3: n = 5 (5! = 120, caso estándar)
- caso 4: n = 7 (7! = 5040)
- caso 5: n = 12 (12! = 479001600, valor grande)
*/

package recursividad;

public class Ejercicio01Factorial {

    /**
     * Calcula el factorial de un número n de forma recursiva.
     * 
     * Funcionamiento de la Pila de Llamadas (Call Stack):
     * Por ejemplo para factorial(3):
     * 1. factorial(3) se apila, espera a 3 * factorial(2)
     * 2. factorial(2) se apila, espera a 2 * factorial(1)
     * 3. factorial(1) se apila -> CASO BASE: retorna 1 inmediatamente.
     * Desapilado:
     * 4. factorial(2) recibe 1 y retorna 2 * 1 = 2 (se desapila).
     * 5. factorial(3) recibe 2 y retorna 3 * 2 = 6 (se desapila y finaliza).
     *
     * @param n número entero no negativo
     * @return factorial de n
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo.");
        }

        // CASO BASE:
        // Si n vale 0 o 1, por definición matemática el factorial es 1.
        // Se detiene la recursión y no se realizan más llamadas.
        if (n <= 1) {
            return 1L;
        }

        // CASO RECURSIVO:
        // Se reduce el problema llamando a factorial(n - 1).
        // Cada llamada reduce n en 1 hasta alcanzar el caso base.
        // Al regresar, se multiplica n por el resultado de factorial(n - 1).
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 1: FACTORIAL RECURSIVO");
        System.out.println("==================================================\n");

        int[] casos = {0, 1, 5, 7, 12};

        for (int i = 0; i < casos.length; i++) {
            int n = casos[i];
            long resultado = factorial(n);
            System.out.printf("Caso %d: factorial(%d) = %d\n", (i + 1), n, resultado);
        }

        System.out.println("\nPruebas de Ejercicio 1 completadas con éxito.");
    }
}

