/*
Prompt inicial utilizado:
Quiero implementar en Java un algoritmo para invertir una palabra o texto (InvertirPalabra) utilizando una Pila Enlazada propia de caracteres, sin utilizar ninguna clase de la Java Collections Framework (como Stack, StringBuilder.reverse(), etc.).

### Estructura de Clases y Nodos
- Clase Nodo: almacena un 'caracter' (char) y la referencia 'siguiente' (Nodo).
- Clase PilaCaracteres: pila enlazada que proporciona los métodos 'push', 'pop', 'peek', 'estaVacia' y 'getSize'.
- Clase InvertirPalabra: implementa el método público estático `String invertir(String palabra)`.

### Razonamiento Conceptual: Inversión de Palabras mediante Pila (LIFO)
- Por qué una Pila invierte una secuencia de manera natural:
  La propiedad cardinal de una pila es LIFO (Last-In, First-Out): el último elemento ingresado es indefectiblemente el primero en ser retirado.
  Al recorrer una palabra de izquierda a derecha (ej. `a`, `l`, `g`, `o`, `r`, `i`, `t`, `m`, `o`):
  1. El primer carácter `'a'` queda en el fondo de la pila.
  2. El último carácter `'o'` queda en la cima (tope) de la pila.
  Al desapilar consecutivamente todos los elementos:
  1. El primer carácter que emerge es `'o'` (el que ingresó último).
  2. El siguiente es `'m'`, luego `'t'`, y así sucesivamente hasta el `'a'` inicial.
  Por lo tanto, la secuencia extraída invierte exactamente el orden original: `"algoritmo"` se transforma en `"omtirogla"`.
- Análisis de Complejidad:
  - Fase 1 (Apilado): Recorrer la cadena de longitud n y hacer push de cada carácter -> n operaciones O(1) = O(n).
  - Fase 2 (Desapilado y Reconstrucción): Hacer pop de cada carácter y concatenar -> n operaciones O(1) = O(n).
  - Complejidad Temporal total: O(n).
  - Complejidad Espacial total: O(n) para los n nodos de la pila enlazada y el arreglo o buffer de caracteres resultante.

### Casos de Prueba Requeridos
- Caso principal requerido por la consigna: `"algoritmo"` -> `"omtirogla"`.
- Casos adicionales:
  - Palíndromo: `"radar"` -> `"radar"`.
  - Palabra corta / única letra: `"A"` -> `"A"`.
  - Cadena vacía: `""` -> `""`.
  - Frase con espacios: `"estructuras de datos"` -> `"sotad ed sarutcurtse"`.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio08;

import java.util.NoSuchElementException;

public class InvertirPalabra {

    /**
     * Estructura interna de Pila Enlazada de caracteres.
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
     * Invierte una palabra o cadena utilizando una pila enlazada.
     */
    public static String invertir(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return palabra;
        }

        PilaCaracteres pila = new PilaCaracteres();

        // 1. Apilar cada carácter de izquierda a derecha en O(n)
        for (int i = 0; i < palabra.length(); i++) {
            pila.push(palabra.charAt(i));
        }

        // 2. Desapilar los caracteres; el comportamiento LIFO invierte el orden
        char[] invertido = new char[palabra.length()];
        int idx = 0;
        while (!pila.estaVacia()) {
            invertido[idx++] = pila.pop();
        }

        return new String(invertido);
    }
}

