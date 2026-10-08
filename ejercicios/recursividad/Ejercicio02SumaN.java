/*
Quiero implementar en Java una función recursiva que sume los números enteros desde n hasta 1 (o sea, 1 + 2 + ... + n).

Este problema puede resolverse recursivamente porque la suma de los primeros n números naturales equivale a tomar el número n y sumarle el resultado de la suma de los primeros n - 1 números, es decir, suma(n) = n + suma(n - 1).

El caso más simple (caso base) es cuando n es 0 (n == 0), porque la suma de cero elementos es 0 (elemento neutro de la adición). Si n es 0, la función debe devolver 0 inmediatamente y detener la recursión. Si n es 1, n + suma(0) devolverá 1 + 0 = 1, resultando consistente.

El caso recursivo es n + suma(n - 1), porque en cada llamada el valor de n disminuye en 1, reduciendo el problema hasta llegar a n == 0.

La función debe devolver un número entero (int o long) con el total acumulado de la suma desde n hasta 1.

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas, mostrando cómo se van acumulando las sumas pendientes al desapilar.

Para validar que la función funciona correctamente, quiero comparar su resultado contra la fórmula matemática cerrada de Gauss: n * (n + 1) / 2 en todos los casos de prueba:
- caso 1: n = 0 (caso base, resultado 0)
- caso 2: n = 1 (resultado 1)
- caso 3: n = 5 (5 + 4 + 3 + 2 + 1 = 15, validado con 5*6/2 = 15)
- caso 4: n = 10 (10 + ... + 1 = 55, validado con 10*11/2 = 55)
- caso 5: n = 100 (resultado 5050, validado con 100*101/2 = 5050)
*/

package recursividad;

public class Ejercicio02SumaN {

    /**
     * Suma los números enteros desde n hasta 1 de forma recursiva.
     * 
     * Pila de Llamadas (Call Stack):
     * Para suma(3):
     * 1. suma(3) se apila, espera 3 + suma(2)
     * 2. suma(2) se apila, espera 2 + suma(1)
     * 3. suma(1) se apila, espera 1 + suma(0)
     * 4. suma(0) se apila -> CASO BASE: retorna 0
     * Desapilado:
     * 5. suma(1) resuelve 1 + 0 = 1 y se desapila
     * 6. suma(2) resuelve 2 + 1 = 3 y se desapila
     * 7. suma(3) resuelve 3 + 3 = 6 y se desapila con el resultado final.
     *
     * @param n número entero no negativo
     * @return la sumatoria de n hasta 1
     */
    public static long suma(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número no puede ser negativo.");
        }

        // CASO BASE:
        // Si n es 0, no hay elementos que sumar.
        // El neutro aditivo es 0, por lo que retornamos 0 y se corta la recursión.
        if (n == 0) {
            return 0L;
        }

        // CASO RECURSIVO:
        // Se reduce el problema en una unidad: n + suma(n - 1).
        // Al regresar por la pila de llamadas, se efectúan las sumas pendientes.
        return n + suma(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 2: SUMA DE LOS PRIMEROS N NÚMEROS");
        System.out.println("==================================================\n");

        int[] casos = {0, 1, 5, 10, 100};

        for (int i = 0; i < casos.length; i++) {
            int n = casos[i];
            long resRecursivo = suma(n);
            long resGauss = ((long) n * (n + 1)) / 2; // Validación formal: n * (n + 1) / 2
            boolean coincide = (resRecursivo == resGauss);

            System.out.printf("Caso %d: n = %d\n", (i + 1), n);
            System.out.printf("        Resultado Recursivo = %d\n", resRecursivo);
            System.out.printf("        Fórmula de Gauss    = %d\n", resGauss);
            System.out.printf("        ¿Validación OK?     = %b\n\n", coincide);
        }

        System.out.println("Pruebas de Ejercicio 2 completadas con éxito.");
    }
}

