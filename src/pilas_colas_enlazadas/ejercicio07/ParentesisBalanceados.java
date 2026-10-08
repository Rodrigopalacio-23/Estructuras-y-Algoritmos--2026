/*
Prompt inicial utilizado:
Quiero implementar en Java un verificador de paréntesis balanceados (ParentesisBalanceados) utilizando una Pila Enlazada propia de caracteres, sin recurrir a ninguna clase de la Java Collections Framework.

### Estructura de Clases y Nodos
- Clase Nodo: almacena un 'caracter' (char) y la referencia 'siguiente' (Nodo).
- Clase PilaCaracteres: pila enlazada que gestiona apilar ('push'), desapilar ('pop'), consultar cima ('peek'), 'estaVacia()' y 'getSize()'.
- Clase ParentesisBalanceados: clase utilitaria o con método `boolean verificar(String expresion)` que realiza el algoritmo de validación.

### Razonamiento Conceptual: Validación de Paréntesis mediante Pila (LIFO)
- Por qué una Pila resuelve el anidamiento:
  En expresiones aritméticas o de código, los delimitadores siguen una relación jerárquica de anidamiento estricto: el delimitador de apertura más reciente es el primero que debe cerrarse ("último en abrir, primero en cerrar" -> LIFO). Una estructura de cola procesaría en orden opuesto e ignoraría el anidamiento.
- Algoritmo de validación:
  1. Recorrer la expresión carácter por carácter.
  2. Cada vez que se encuentra un paréntesis de apertura `(`, se apila en la pila en O(1).
  3. Cada vez que se encuentra un paréntesis de cierre `)`:
     - Si la pila está vacía al momento de querer desapilar, la expresión es inválida (hay un cierre sin su correspondiente apertura, ej. `())`).
     - Si la pila no está vacía, se desapila el `(` superior.
  4. Al terminar de examinar la cadena completa:
     - Si la pila queda vacía, los paréntesis están perfectamente balanceados.
     - Si la pila todavía contiene elementos, la expresión es inválida (quedaron paréntesis abiertos sin cerrar, ej. `(2 + 3`).
- Casos especiales a contemplar:
  - Expresión balanceada simple: `(2 + 3) * (5 - 1)` -> true.
  - Expresión anidada válida: `((a + b) * c)` -> true.
  - Expresión con apertura sin cierre: `(2 + 3` -> false.
  - Expresión con cierre sin apertura o cierre prematuro: `()) (` -> false.
  - Expresión sin ningún paréntesis: `2 + 3` -> true (balance trivial).
  - Expresión vacía o cadena en blanco: `""` -> true.
- Complejidad: O(n) temporal (un único recorrido lineal sobre la cadena de longitud n) y O(n) espacial en el peor de los casos (si todos los caracteres son `(`).

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio07;

import java.util.NoSuchElementException;

public class ParentesisBalanceados {

    /**
     * Pila enlazada interna de caracteres auxiliar.
     */
    private static class PilaCaracteres {
        private Nodo head;
        private int size;

        public PilaCaracteres() {
            this.head = null;
            this.size = 0;
        }

        public void push(char c) {
            Nodo nuevo = new Nodo(c);
            nuevo.setSiguiente(head);
            head = nuevo;
            size++;
        }

        public char pop() {
            if (estaVacia()) {
                throw new NoSuchElementException("Pila de caracteres vacía.");
            }
            char valor = head.getCaracter();
            head = head.getSiguiente();
            size--;
            return valor;
        }

        public boolean estaVacia() {
            return head == null;
        }

        public int getSize() {
            return size;
        }
    }

    /**
     * Verifica si los paréntesis '(' y ')' en la expresión están correctamente balanceados.
     */
    public static boolean verificar(String expresion) {
        if (expresion == null || expresion.isEmpty()) {
            return true;
        }

        PilaCaracteres pila = new PilaCaracteres();

        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);

            if (actual == '(') {
                pila.push(actual);
            } else if (actual == ')') {
                if (pila.estaVacia()) {
                    // Cierre sin apertura previa correspondiente
                    return false;
                }
                pila.pop();
            }
        }

        // Si la pila quedó vacía, todas las aperturas tuvieron su correspondiente cierre
        return pila.estaVacia();
    }
}

