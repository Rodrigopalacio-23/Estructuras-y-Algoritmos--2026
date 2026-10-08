/*
Quiero implementar en Java una función recursiva que invierta un String (cadena de texto).

Este problema puede resolverse recursivamente porque invertir una cadena compuesta por un primer carácter 'c' seguido de un resto 'resto' equivale a invertir el 'resto' recursivamente y concatenarle al final el primer carácter 'c' (invertir(resto) + c).

El caso base es cuando la cadena es vacía ("") o tiene longitud 1 (str.length() <= 1), porque una cadena vacía o de un solo carácter ya se encuentra invertida por sí misma. En este caso se devuelve la misma cadena directamente y se detiene la recursión.

Para separar el primer carácter del resto, se utiliza str.charAt(0) para obtener el primer carácter y str.substring(1) para extraer la subcadena restante.

La cadena se reduce en cada llamada al pasar str.substring(1) como argumento a invertirString, disminuyendo la longitud de la cadena en un carácter en cada paso hasta llegar al caso base.

El resultado se reconstruye al volver de la recursión concatenando el resultado de invertirString(str.substring(1)) con el primer carácter al final (+ str.charAt(0)).

La función debe devolver un String con los caracteres en orden inverso.

Quiero que el código tenga comentarios explicando el caso base, el caso recursivo y la pila de llamadas.

También quiero probarlo con estas palabras como prueba:
- caso 1: "" (cadena vacía, resultado "")
- caso 2: "a" (un solo carácter, resultado "a")
- caso 3: "hola" (resultado "aloh")
- caso 4: "recursividad" (resultado "dadivisrucer")
- caso 5: "algoritmo" (resultado "omtirogla")
*/

package recursividad;

public class Ejercicio08InvertirString {

    /**
     * Invierte una cadena de texto de forma recursiva.
     * 
     * Pila de Llamadas (Call Stack):
     * Para invertirString("hola"):
     * 1. invertirString("hola") guarda 'h' y espera invertirString("ola") + 'h'
     * 2. invertirString("ola") guarda 'o' y espera invertirString("la") + 'o'
     * 3. invertirString("la") guarda 'l' y espera invertirString("a") + 'l'
     * 4. invertirString("a") -> CASO BASE: longitud <= 1, retorna "a".
     * Desapilado y reconstrucción:
     * 5. invertirString("la") resuelve "a" + 'l' = "al" y se desapila
     * 6. invertirString("ola") resuelve "al" + 'o' = "alo" y se desapila
     * 7. invertirString("hola") resuelve "alo" + 'h' = "aloh" y se desapila con la cadena invertida.
     *
     * @param str cadena a invertir
     * @return cadena invertida
     */
    public static String invertirString(String str) {
        if (str == null) {
            return null;
        }

        // CASO BASE:
        // Si la cadena está vacía ("") o tiene longitud 1, ya está invertida.
        // Se retorna la misma cadena sin generar más llamadas.
        if (str.length() <= 1) {
            return str;
        }

        // CASO RECURSIVO:
        // Se separa el primer carácter con str.charAt(0).
        // Se reduce la cadena pasando el resto con str.substring(1).
        // Se reconstruye el resultado concatenando el inverso del resto con el primer carácter al final.
        return invertirString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 8: INVERTIR UN STRING RECURSIVO");
        System.out.println("==================================================\n");

        String[] palabras = {"", "a", "hola", "recursividad", "algoritmo"};

        for (int i = 0; i < palabras.length; i++) {
            String original = palabras[i];
            String invertida = invertirString(original);
            System.out.printf("Caso %d: original = \"%s\" -> invertida = \"%s\"\n",
                    (i + 1), original, invertida);
        }

        System.out.println("\nPruebas de Ejercicio 8 completadas con éxito.");
    }
}

