/*
Prompt inicial utilizado:
Quiero implementar en Java una Cola Enlazada de enteros (ColaEnlazada) desde cero, utilizando nodos enlazados simples y sin utilizar clases de la Java Collections Framework (como Queue, LinkedList, ArrayDeque, etc.).

### Estructura de Clases y Nodos
- Clase Nodo: almacena 'dato' (int) y la referencia 'siguiente' (Nodo).
- Clase ColaEnlazada: mantiene dos referencias de nodo fundamentales: 'head' (frente o inicio de la cola) y 'tail' (final o fin de la cola), además de un contador entero 'size'.

### Razonamiento Conceptual: Cola FIFO y Manejo de Head y Tail
- Comportamiento FIFO: El primer elemento en encolarse es el primero en ser desencolado (First-In, First-Out).
- Importancia del puntero 'tail' para O(1) en enqueue():
  En una lista enlazada simple con solo puntero 'head', encolar al final requeriría recorrer todos los nodos hasta el último, consumiendo tiempo O(n). Mantener una referencia directa 'tail' al último elemento permite que la inserción se realice en O(1), enlazando directamente `tail.setSiguiente(nuevo)` y reasignando `tail = nuevo`.
- Comportamiento de dequeue() en O(1):
  El elemento a retirar siempre se encuentra en 'head'. Se obtiene su valor y se avanza `head = head.getSiguiente()`, operación inmediata O(1).
- Caso crítico al desencolar el último elemento:
  Si la cola contenía un único elemento (`head == tail`), tras retirarlo `head` pasa a ser `null`. Si no se actualiza `tail`, este quedaría apuntando al nodo ya removido ("puntero colgante"). Por ello, cuando `head == null`, debe actualizarse explícitamente `tail = null` para mantener la consistencia de la cola vacía.
- Casos de error: Invocar dequeue() o peek() sobre una cola vacía debe lanzar NoSuchElementException.

### Operaciones Requeridas
- void enqueue(int elemento): encola un entero al final de la cola (O(1)).
- int dequeue(): desencola y retorna el entero del frente (O(1)); lanza NoSuchElementException si está vacía.
- int peek(): consulta el entero del frente sin retirarlo (O(1)); lanza NoSuchElementException si está vacía.
- boolean estaVacia(): retorna true si no hay elementos.
- int getSize(): retorna la cantidad de elementos en la cola (O(1)).
- void imprimir(): muestra el estado de la cola desde el frente hasta el final.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio02;

import java.util.NoSuchElementException;

public class ColaEnlazada {
    private Nodo head;
    private Nodo tail;
    private int size;

    public ColaEnlazada() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Encola un nuevo elemento al final de la cola en O(1).
     */
    public void enqueue(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.setSiguiente(nuevo);
            tail = nuevo;
        }
        size++;
    }

    /**
     * Desencola y retorna el elemento al frente de la cola en O(1).
     * Si se retira el único elemento restante, reinicia tail a null.
     */
    public int dequeue() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La cola está vacía, no se puede realizar dequeue.");
        }
        int valor = head.getDato();
        head = head.getSiguiente();
        size--;

        // Si la cola quedó vacía, tail debe volver a null
        if (head == null) {
            tail = null;
        }

        return valor;
    }

    /**
     * Retorna el elemento al frente de la cola sin retirarlo en O(1).
     */
    public int peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La cola está vacía, no se puede realizar peek.");
        }
        return head.getDato();
    }

    /**
     * Consulta si la cola no contiene elementos.
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Retorna el número de elementos en la cola en O(1).
     */
    public int getSize() {
        return size;
    }

    /**
     * Imprime los elementos de la cola desde el frente hasta el final.
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Cola vacía: [ ]");
            return;
        }
        System.out.print("Frente -> ");
        Nodo actual = head;
        while (actual != null) {
            System.out.print("[" + actual.getDato() + "]");
            if (actual.getSiguiente() != null) {
                System.out.print(" -> ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println(" -> Final");
    }
}

