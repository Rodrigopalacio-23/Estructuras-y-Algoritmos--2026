/*
Quiero implementar en Java una función recursiva que determine si una palabra o cadena de texto es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).

Este problema puede resolverse recursivamente porque para que una palabra sea un palíndromo es condición necesaria que su primer carácter y su último carácter sean idénticos, y que la subcadena interna resultante de quitar ambos extremos sea también un palíndromo.

Hay que comparar el primer y último carácter porque un palíndromo es simétrico respecto a su centro. Si el primer y último carácter son distintos, la condición de simetría se rompe inmediatamente y la función debe devolver false sin necesidad de seguir analizando el resto de la palabra (detención temprana).

El problema se reduce eliminando ambos extremos mediante str.substring(1, str.length() - 1), disminuyendo la longitud de la cadena en dos caracteres en cada llamada recursiva (esPalindromo(str.substring(1, str.length() - 1))).

El caso base es cuando la cadena queda vacía ("") o tiene exactamente un solo carácter (str.length() <= 1), porque cualquier cadena de 0 o 1 carácter es simétrica por definición y se considera un palíndromo válido. En este caso, la función devuelve true.

La función debe devolver un valor booleano (boolean: true si es palíndromo, false si no lo es).

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.

También quiero probarlo con estos casos:
- caso 1: "" (cadena vacía, caso base true)
- caso 2: "a" (un carácter, caso base true)
- caso 3: "radar" (palíndromo impar, true)
- caso 4: "somos" (palíndromo impar, true)
- caso 5: "reconocer" (palíndromo impar largo, true)
- caso 6: "anna" (palíndromo par, true)
- caso 7: "java" (no es palíndromo, extremos 'j' != 'a', false)
- caso 8: "algoritmo" (no es palíndromo, false)
*/

package recursividad;

public class Ejercicio09Palindromo {

    /**
     * Determina si una cadena es palíndromo de forma recursiva.
     * 
     * Pila de Llamadas (Call Stack):
     * Para esPalindromo("radar"):
     * 1. esPalindromo("radar"): compara extremos 'r' == 'r', espera esPalindromo("ada")
     * 2. esPalindromo("ada"): compara extremos 'a' == 'a', espera esPalindromo("d")
     * 3. esPalindromo("d") -> CASO BASE: longitud <= 1, retorna true.
     * Desapilado:
     * 4. esPalindromo("ada") recibe true y se desapila retornando true.
     * 5. esPalindromo("radar") recibe true y se desapila retornando true.
     *
     * @param str palabra a evaluar
     * @return true si es palíndromo, false de lo contrario
     */
    public static boolean esPalindromo(String str) {
        if (str == null) {
            return false;
        }

        // CASO BASE 1:
        // Cadenas de 0 o 1 carácter son simétricas por definición y por ende palíndromos.
        if (str.length() <= 1) {
            return true;
        }

        // Verificación de extremos
        char primer = str.charAt(0);
        char ultimo = str.charAt(str.length() - 1);

        // Si el primer y último carácter son distintos, la simetría se rompe de inmediato.
        // Se retorna false y se detiene la recursión (cortocircuito).
        if (primer != ultimo) {
            return false;
        }

        // CASO RECURSIVO:
        // Si los extremos coinciden, se reduce el problema quitando ambos caracteres
        // con substring(1, str.length() - 1) y evaluando la subcadena interna.
        return esPalindromo(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 9: PALÍNDROMO RECURSIVO");
        System.out.println("==================================================\n");

        String[] palabras = {"", "a", "radar", "somos", "reconocer", "anna", "java", "algoritmo"};

        for (int i = 0; i < palabras.length; i++) {
            String p = palabras[i];
            boolean res = esPalindromo(p);
            System.out.printf("Caso %d: \"%s\" -> ¿Es palíndromo? %b\n", (i + 1), p, res);
        }

        System.out.println("\nPruebas de Ejercicio 9 completadas con éxito.");
    }
}

