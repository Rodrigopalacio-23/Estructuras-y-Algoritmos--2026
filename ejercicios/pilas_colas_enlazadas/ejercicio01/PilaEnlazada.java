/*
Prompt inicial utilizado:
Quiero implementar en Java una estructura de Pila Enlazada de números enteros (PilaEnlazada) desde cero, utilizando nodos enlazados simples y sin utilizar ninguna clase de la Java Collections Framework (como Stack, ArrayList, LinkedList, etc.).

### Estructura de Clases y Nodos
- Clase Nodo: almacena el dato (int) y la referencia al siguiente nodo ('siguiente').
- Clase PilaEnlazada: mantiene la referencia 'head' (tope de la pila) y el contador 'size' con la cantidad de elementos almacenados.

### Razonamiento Conceptual: Pila LIFO y Complejidades
- Comportamiento LIFO: El último elemento en entrar es el primero en salir.
- Eficiencia O(1) en push() y pop(): Se logra manipulando exclusivamente la cabecera ('head'). Al insertar (push), el nuevo nodo apunta al actual 'head' y pasa a ser la nueva cima. Al desapilar (pop), se obtiene el valor de 'head' y se avanza la cima hacia 'head.getSiguiente()'. Ninguna de estas dos operaciones requiere recorrer la estructura, garantizando O(1) temporal y O(1) espacial adicional.
- Búsqueda e impresión O(n): Operaciones como 'buscar(int elemento)' e 'imprimir()' requieren recorrer secuencialmente los nodos desde la cima hasta la base, requiriendo un tiempo O(n) proporcional a la cantidad de nodos.
- Manejo de casos especiales: En caso de invocar pop() o peek() sobre una pila vacía, se debe lanzar una excepción descriptiva (IllegalStateException o NoSuchElementException).

### Operaciones Requeridas
- void push(int elemento): apila un entero en la cima.
- int pop(): desapila y retorna el entero de la cima; lanza excepción si está vacía.
- int peek(): consulta y retorna el elemento en la cima sin removerlo; lanza excepción si está vacía.
- boolean estaVacia(): indica si la pila no tiene elementos.
- int getSize(): retorna el número total de elementos.
- boolean buscar(int elemento): retorna true si el elemento se encuentra en la pila, recorriéndola.
- void imprimir(): muestra los elementos de la pila desde el tope hasta la base.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio01;

import java.util.NoSuchElementException;

public class PilaEnlazada {
    private Nodo head;
    private int size;

    public PilaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Inserta un elemento en la cima de la pila en O(1).
     */
    public void push(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.setSiguiente(head);
        head = nuevo;
        size++;
    }

    /**
     * Remueve y retorna el elemento en la cima de la pila en O(1).
     * Lanza NoSuchElementException si la pila está vacía.
     */
    public int pop() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La pila está vacía, no se puede realizar pop.");
        }
        int valor = head.getDato();
        head = head.getSiguiente();
        size--;
        return valor;
    }

    /**
     * Retorna el elemento en la cima sin retirarlo en O(1).
     * Lanza NoSuchElementException si la pila está vacía.
     */
    public int peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La pila está vacía, no se puede realizar peek.");
        }
        return head.getDato();
    }

    /**
     * Indica si la pila no contiene elementos.
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Retorna la cantidad de elementos en la pila en O(1).
     */
    public int getSize() {
        return size;
    }

    /**
     * Busca un elemento en la pila secuencialmente en O(n).
     */
    public boolean buscar(int elemento) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.getDato() == elemento) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Imprime los elementos desde la cima (tope) hasta la base en O(n).
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía: [ ]");
            return;
        }
        System.out.print("Tope -> ");
        Nodo actual = head;
        while (actual != null) {
            System.out.print("[" + actual.getDato() + "]");
            if (actual.getSiguiente() != null) {
                System.out.print(" -> ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println(" -> Base");
    }
}

