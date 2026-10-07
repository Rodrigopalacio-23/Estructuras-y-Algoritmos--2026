/*
Quiero implementar en Java una función recursiva que calcule la multiplicación de dos números enteros (a y b) utilizando únicamente sumas sucesivas y SIN usar el operador de multiplicación (*).

Este problema puede resolverse recursivamente porque la multiplicación matemática a * b representa sumar el número a tantas veces como indique b (es decir, a + a + ... + a, b veces). Esto permite expresar multiplicar(a, b) = a + multiplicar(a, b - 1).

El parámetro que se reduce es b (el segundo factor, que actúa como contador de repeticiones), disminuyendo en 1 en cada llamada hasta llegar a 0. (Nota: Para optimizar o manejar signos negativos, también se debe contemplar la regla de signos sin usar *).

El caso base es cuando uno de los factores vale 0 (específicamente cuando b == 0 o a == 0), porque cualquier número multiplicado por 0 da como resultado 0 (propiedad absorbente del cero). Cuando b == 0, no quedan sumas pendientes y la función devuelve 0 inmediatamente.

La función debe devolver un número entero (int o long) con el producto resultante de sumar a, b veces.

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas, y que respete estrictamente la restricción de NO usar el operador * en ninguna parte del algoritmo ni en la resolución de signos.

También quiero probarlo con estos casos:
- caso 1: a = 5, b = 0 (caso base con b = 0, resultado 0)
- caso 2: a = 0, b = 7 (caso base con a = 0, resultado 0)
- caso 3: a = 4, b = 1 (multiplicación por neutro, resultado 4)
- caso 4: a = 6, b = 7 (caso estándar positivo, resultado 42)
- caso 5: a = 8, b = 3 (resultado 24)
- caso 6: a = -4, b = 5 y a = 4, b = -5 (casos con negativos resueltos sin usar *)
*/

package recursividad;

public class Ejercicio03Multiplicacion {

    /**
     * Multiplica dos enteros mediante sumas sucesivas recursivas SIN utilizar el operador '*'.
     * 
     * Pila de Llamadas (Call Stack):
     * Para multiplicar(4, 3):
     * 1. multiplicar(4, 3) se apila, espera 4 + multiplicar(4, 2)
     * 2. multiplicar(4, 2) se apila, espera 4 + multiplicar(4, 1)
     * 3. multiplicar(4, 1) se apila, espera 4 + multiplicar(4, 0)
     * 4. multiplicar(4, 0) se apila -> CASO BASE: retorna 0
     * Desapilado:
     * 5. multiplicar(4, 1) resuelve 4 + 0 = 4 y se desapila
     * 6. multiplicar(4, 2) resuelve 4 + 4 = 8 y se desapila
     * 7. multiplicar(4, 3) resuelve 4 + 8 = 12 y se desapila con el total.
     *
     * @param a primer factor (número que se suma)
     * @param b segundo factor (contador de sumas a realizar)
     * @return producto de a y b
     */
    public static int multiplicar(int a, int b) {
        // CASO BASE:
        // Si cualquiera de los dos factores es 0, el producto es 0.
        // Detiene la recursión retornando el neutro de la suma (0).
        if (a == 0 || b == 0) {
            return 0;
        }

        // Manejo de signos sin usar el operador '*'
        if (b < 0) {
            // a * (-b) = -(a * b)
            return -multiplicar(a, -b);
        }

        // CASO RECURSIVO:
        // Se reduce el segundo factor b en 1: a + multiplicar(a, b - 1).
        // Se suma 'a' a la llamada recursiva que resolverá las restantes b - 1 sumas.
        return a + multiplicar(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 3: MULTIPLICACIÓN MEDIANTE SUMAS");
        System.out.println("==================================================\n");

        int[][] pruebas = {
            {5, 0},   // Caso base con b = 0
            {0, 7},   // Caso base con a = 0
            {4, 1},   // Multiplicación por 1
            {6, 7},   // Estándar: 6 * 7 = 42
            {8, 3},   // Estándar: 8 * 3 = 24
            {-4, 5},  // Negativo en primer factor: -20
            {4, -5},  // Negativo en segundo factor: -20
            {-3, -6}  // Ambos negativos: 18
        };

        for (int i = 0; i < pruebas.length; i++) {
            int a = pruebas[i][0];
            int b = pruebas[i][1];
            int res = multiplicar(a, b);
            System.out.printf("Caso %d: multiplicar(%d, %d) = %d\n", (i + 1), a, b, res);
        }

        System.out.println("\nPruebas de Ejercicio 3 completadas con éxito (sin operador *).");
    }
}

