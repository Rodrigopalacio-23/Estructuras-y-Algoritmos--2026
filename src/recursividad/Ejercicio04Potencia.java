/*
Quiero implementar en Java una función recursiva que calcule la potencia de una base entera elevada a un exponente entero no negativo (base^exponente) SIN usar el método Math.pow.

Este problema puede resolverse recursivamente porque la potenciación base^exp equivale matemáticamente a multiplicar la base por sí misma tantas veces como indique el exponente (base * base * ... * base, exp veces). Por ende, potencia(base, exp) puede expresarse como base * potencia(base, exp - 1).

El caso base es exponente 0 (exp == 0), porque por convención matemática y leyes de exponentes cualquier número no nulo elevado a la potencia cero es igual a 1 (base^0 = 1). Cuando exp == 0, la función devuelve 1 inmediatamente, sirviendo como neutro del producto acumulado.

El caso recursivo es base * potencia(base, exp - 1), porque en cada llamada el exponente se reduce en una unidad (exp - 1), disminuyendo la cantidad de multiplicaciones restantes hasta alcanzar el caso base exp == 0.

La función debe devolver un número entero largo (long) con el resultado del cálculo de base^exp en cada caso (1 en el caso base exp == 0, o el producto acumulado en los casos recursivos).

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas, y que no utilice en ningún momento Math.pow.

También quiero probarlo con estos casos:
- caso 1: base = 5, exp = 0 (caso base con exp = 0, resultado 1)
- caso 2: base = 7, exp = 1 (resultado 7)
- caso 3: base = 2, exp = 5 (2^5 = 32)
- caso 4: base = 3, exp = 4 (3^4 = 81)
- caso 5: base = 10, exp = 3 (10^3 = 1000)
*/

package recursividad;

public class Ejercicio04Potencia {

    /**
     * Calcula la potencia de un número de forma recursiva SIN usar Math.pow.
     * 
     * Pila de Llamadas (Call Stack):
     * Para potencia(2, 3):
     * 1. potencia(2, 3) se apila, espera 2 * potencia(2, 2)
     * 2. potencia(2, 2) se apila, espera 2 * potencia(2, 1)
     * 3. potencia(2, 1) se apila, espera 2 * potencia(2, 0)
     * 4. potencia(2, 0) se apila -> CASO BASE: retorna 1
     * Desapilado:
     * 5. potencia(2, 1) resuelve 2 * 1 = 2 y se desapila
     * 6. potencia(2, 2) resuelve 2 * 2 = 4 y se desapila
     * 7. potencia(2, 3) resuelve 2 * 4 = 8 y se desapila con el total.
     *
     * @param base      base entera
     * @param exponente exponente entero no negativo
     * @return resultado de base elevado a exponente
     */
    public static long potencia(int base, int exponente) {
        if (exponente < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo para este ejercicio.");
        }

        // CASO BASE:
        // Cualquier número elevado a la 0 es 1 (base^0 = 1).
        // Se retorna el neutro multiplicativo 1 y se detiene la recursión.
        if (exponente == 0) {
            return 1L;
        }

        // CASO RECURSIVO:
        // Se reduce el exponente en 1 en cada llamada: base * potencia(base, exponente - 1).
        // Cada marco apilado multiplica la base por el resultado del subproblema resuelto.
        return (long) base * potencia(base, exponente - 1);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 4: POTENCIA RECURSIVA (SIN Math.pow)");
        System.out.println("==================================================\n");

        int[][] pruebas = {
            {5, 0},   // Caso base exponente 0
            {7, 1},   // Exponente 1
            {2, 5},   // 2^5 = 32
            {3, 4},   // 3^4 = 81
            {10, 3}   // 10^3 = 1000
        };

        for (int i = 0; i < pruebas.length; i++) {
            int b = pruebas[i][0];
            int e = pruebas[i][1];
            long res = potencia(b, e);
            System.out.printf("Caso %d: potencia(%d, %d) = %d\n", (i + 1), b, e, res);
        }

        System.out.println("\nPruebas de Ejercicio 4 completadas con éxito (sin Math.pow).");
    }
}

