/*
Quiero implementar en Java una función recursiva que sume todos los dígitos de un número entero positivo n.

Este problema puede resolverse recursivamente porque la suma de los dígitos de cualquier número n puede descomponerse en el valor de su último dígito sumado a la suma de los dígitos del número restante. El último dígito se obtiene con la operación de módulo (n % 10) y el número restante se reduce mediante la división entera (n / 10).

El caso base es cuando n es menor que 10 (n < 10), porque cuando el número consta de un solo dígito, su suma es trivialmente el mismo número (n). En este punto se retorna n directamente y se detiene la recursión.

El caso recursivo es (n % 10) + sumarDigitos(n / 10), porque en cada llamada se aísla el último dígito con n % 10 y se reduce el problema pasando n / 10 a la siguiente llamada recursiva.

Los resultados se combinan sumando el dígito extraído (n % 10) con el valor retornado por la llamada recursiva sumarDigitos(n / 10) a medida que la pila de llamadas se desapila.

La función debe devolver un número entero (int) con la suma acumulada de todos los dígitos de n.

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.

También quiero probarlo con estos casos:
- caso 1: n = 5 (un solo dígito, caso base directo, resultado 5)
- caso 2: n = 42 (4 + 2 = 6)
- caso 3: n = 345 (3 + 4 + 5 = 12)
- caso 4: n = 12345 (1 + 2 + 3 + 4 + 5 = 15)
- caso 5: n = 9999 (9 + 9 + 9 + 9 = 36)
*/

package recursividad;

public class Ejercicio07SumarDigitos {

    /**
     * Suma los dígitos de un número entero positivo de forma recursiva.
     * 
     * Pila de Llamadas (Call Stack):
     * Para sumarDigitos(345):
     * 1. sumarDigitos(345) extrae 5 (345 % 10) y espera 5 + sumarDigitos(34)
     * 2. sumarDigitos(34) extrae 4 (34 % 10) y espera 4 + sumarDigitos(3)
     * 3. sumarDigitos(3) -> CASO BASE: 3 < 10, retorna 3.
     * Desapilado:
     * 4. sumarDigitos(34) resuelve 4 + 3 = 7 y se desapila
     * 5. sumarDigitos(345) resuelve 5 + 7 = 12 y se desapila con la suma total.
     *
     * @param n número entero positivo
     * @return la suma de sus dígitos
     */
    public static int sumarDigitos(int n) {
        if (n < 0) {
            n = Math.abs(n);
        }

        // CASO BASE:
        // Si el número es menor que 10, tiene un solo dígito y su suma es él mismo.
        // Se retorna n directamente sin más llamadas.
        if (n < 10) {
            return n;
        }

        // CASO RECURSIVO:
        // Se obtiene el último dígito con el operador módulo: n % 10.
        // Se reduce el número descartando ese dígito con división entera: n / 10.
        // Se combinan sumando el dígito actual al resultado devuelto por la llamada recursiva.
        return (n % 10) + sumarDigitos(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 7: SUMAR DÍGITOS RECURSIVO");
        System.out.println("==================================================\n");

        int[] casos = {5, 42, 345, 12345, 9999};

        for (int i = 0; i < casos.length; i++) {
            int n = casos[i];
            int suma = sumarDigitos(n);
            System.out.printf("Caso %d: sumarDigitos(%d) = %d\n", (i + 1), n, suma);
        }

        System.out.println("\nPruebas de Ejercicio 7 completadas con éxito.");
    }
}

