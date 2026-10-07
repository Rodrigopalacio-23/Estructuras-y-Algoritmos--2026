/*
Quiero implementar en Java una función recursiva que cuente los dígitos de un número entero positivo n.

Este problema puede resolverse recursivamente porque cualquier número en base 10 puede pensarse como su último dígito más el resto de los dígitos. Al realizar la división entera n / 10, se descarta el último dígito, reduciendo el tamaño del número en un dígito en cada paso. Por ende, la cantidad de dígitos de n es igual a 1 + contarDigitos(n / 10).

El caso base es cuando el número es menor que 10 (n < 10), porque en el sistema decimal los números del 0 al 9 están compuestos por una única cifra. Por lo tanto, cuando n < 10, la función devuelve 1 inmediatamente y se detiene la recursión.

El caso recursivo es 1 + contarDigitos(n / 10), porque cada llamada remueve el dígito menos significativo mediante división entera y suma 1 al total devuelto por las llamadas anteriores.

Cada llamada debe devolver un número entero (int) que representa la cantidad acumulada de dígitos procesados hasta ese nivel de la recursión (1 en el caso base, o 1 + el resultado del subproblema en el caso recursivo).

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.

También quiero probarlo con estos casos:
- caso 1: n = 7 (un solo dígito, caso base directo, resultado 1)
- caso 2: n = 42 (dos dígitos, resultado 2)
- caso 3: n = 582 (tres dígitos, resultado 3)
- caso 4: n = 1000 (cuatro dígitos, resultado 4)
- caso 5: n = 987654 (seis dígitos, resultado 6)
*/

package recursividad;

public class Ejercicio06ContarDigitos {

    /**
     * Cuenta la cantidad de dígitos de un número entero positivo de forma recursiva.
     * 
     * Pila de Llamadas (Call Stack):
     * Para contarDigitos(582):
     * 1. contarDigitos(582) se apila, espera 1 + contarDigitos(58)
     * 2. contarDigitos(58) se apila, espera 1 + contarDigitos(5)
     * 3. contarDigitos(5) -> CASO BASE: 5 < 10, retorna 1.
     * Desapilado:
     * 4. contarDigitos(58) resuelve 1 + 1 = 2 y se desapila
     * 5. contarDigitos(582) resuelve 1 + 2 = 3 y se desapila con el total de dígitos.
     *
     * @param n número entero positivo (o cero)
     * @return cantidad de dígitos de n
     */
    public static int contarDigitos(int n) {
        if (n < 0) {
            n = Math.abs(n); // Normalizar si se reciben negativos
        }

        // CASO BASE:
        // Todo número menor que 10 (en el rango [0, 9]) consta de un único dígito.
        // Se retorna 1 inmediatamente y no se apilan más llamadas.
        if (n < 10) {
            return 1;
        }

        // CASO RECURSIVO:
        // Reducción mediante división entera n / 10, que remueve el último dígito.
        // Se suma 1 por el dígito descartado más el conteo recursivo del resto del número.
        return 1 + contarDigitos(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 6: CONTAR DÍGITOS RECURSIVO");
        System.out.println("==================================================\n");

        int[] casos = {7, 42, 582, 1000, 987654};

        for (int i = 0; i < casos.length; i++) {
            int n = casos[i];
            int cantidad = contarDigitos(n);
            System.out.printf("Caso %d: contarDigitos(%d) = %d dígitos\n", (i + 1), n, cantidad);
        }

        System.out.println("\nPruebas de Ejercicio 6 completadas con éxito.");
    }
}

