/*
Quiero implementar en Java una función recursiva que imprima en consola un conteo regresivo desde n hasta 0.

Este problema puede resolverse recursivamente porque imprimir los números desde n hasta 0 consiste en imprimir el número actual n y luego resolver la misma tarea para los números desde n - 1 hasta 0.

Que la función no devuelva un valor (tipo de retorno void) significa que su propósito es generar un efecto colateral (side-effect), en este caso la impresión secuencial por pantalla, en lugar de calcular y propagar un resultado aritmético a través de la pila de retornos.

El caso base es cuando n llega a 0 (o n < 0), imprimiendo 0 y retornando (return) sin hacer llamadas recursivas posteriores, cortando el flujo de ejecución.

El algoritmo se acerca al caso base pasando n - 1 como argumento en cada llamada recursiva (conteoRegresivo(n - 1)).

Si en lugar de n - 1 se usara n + 1, el valor de n se incrementaría indefinidamente (alejándose de 0), la condición de corte n == 0 nunca se cumpliría y el programa caería en una recursión infinita, agotando la memoria reservada para la pila de ejecución y lanzando un error java.lang.StackOverflowError.

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas, y un método main que pruebe la ejecución con diferentes valores iniciales:
- caso 1: n = 0 (caso base inmediato: imprime solo 0)
- caso 2: n = 3 (imprime: 3 2 1 0)
- caso 3: n = 5 (imprime: 5 4 3 2 1 0)
*/

package recursividad;

public class Ejercicio05ConteoRegresivo {

    /**
     * Imprime un conteo regresivo desde n hasta 0 de forma recursiva.
     * 
     * Pila de Llamadas (Call Stack):
     * Para conteoRegresivo(3):
     * 1. conteoRegresivo(3) imprime "3 " y se apila llamando a conteoRegresivo(2)
     * 2. conteoRegresivo(2) imprime "2 " y se apila llamando a conteoRegresivo(1)
     * 3. conteoRegresivo(1) imprime "1 " y se apila llamando a conteoRegresivo(0)
     * 4. conteoRegresivo(0) -> CASO BASE: imprime "0", retorna sin más llamadas.
     * Desapilado:
     * 5. conteoRegresivo(1) finaliza y se desapila
     * 6. conteoRegresivo(2) finaliza y se desapila
     * 7. conteoRegresivo(3) finaliza y se desapila.
     *
     * @param n valor inicial del conteo
     */
    public static void conteoRegresivo(int n) {
        if (n < 0) {
            return;
        }

        // Imprime el valor actual de la cuenta
        System.out.print(n + " ");

        // CASO BASE:
        // Cuando llegamos a 0, se imprime el 0 y se corta la recursión retornando void.
        if (n == 0) {
            return;
        }

        // CASO RECURSIVO:
        // Se reduce el problema llamando con n - 1, acercándose estrictamente hacia 0.
        // NOTA: Si usáramos n + 1 en lugar de n - 1, n crecería indefinidamente sin alcanzar nunca 0,
        // produciendo recursión infinita y desbordamiento de pila (StackOverflowError).
        conteoRegresivo(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 5: CONTEO REGRESIVO RECURSIVO");
        System.out.println("==================================================\n");

        int[] casos = {0, 3, 5, 10};

        for (int i = 0; i < casos.length; i++) {
            int n = casos[i];
            System.out.printf("Caso %d: conteoRegresivo(%d) -> ", (i + 1), n);
            conteoRegresivo(n);
            System.out.println();
        }

        System.out.println("\nPruebas de Ejercicio 5 completadas con éxito.");
    }
}

