/*
Prompt inicial utilizado:
Quiero implementar en Java una Cola Enlazada Genérica (Cola<T>) desde cero, parametrizada por un tipo T, utilizando nodos enlazados simples y sin utilizar ninguna clase de la Java Collections Framework.

### Estructura de Clases y Nodos
- Clase Nodo<T>: contiene un atributo 'dato' de tipo parametrizado T y una referencia autorreferencial 'siguiente' de tipo Nodo<T>.
- Clase Cola<T>: administra la cola mediante referencias 'head' (inicio/frente), 'tail' (fin) y el contador 'size'.
- Clase Cliente: clase del dominio con campos como 'id' (int) y 'nombre' (String) para verificar el funcionamiento con objetos de negocio además de tipos básicos como String.

### Razonamiento Conceptual: Cola FIFO Genérica e Independencia de Tipo
- Principio FIFO independiente del tipo: El orden de atención o salida (primero en entrar, primero en salir) depende de los punteros 'head' y 'tail', no del contenido del nodo. La estructura almacena referencias genéricas, manteniendo inalterable el comportamiento FIFO para cualquier tipo de objeto.
- Operaciones en tiempo constante O(1):
  - enqueue(T): se enlaza el nuevo nodo al final mediante 'tail', garantizando O(1).
  - dequeue(): se extrae el nodo ubicado en 'head', garantizando O(1).
  - peek(): se inspecciona el nodo en 'head' sin modificar referencias, en O(1).
- Manejo de fin de cola: Al desencolar el último elemento, 'tail' debe asignarse a null para reflejar el estado vacío de la estructura. Si se invoca dequeue() o peek() en estado vacío, se debe lanzar NoSuchElementException.

### Operaciones Requeridas
- void enqueue(T elemento): agrega un elemento al final de la cola (O(1)).
- T dequeue(): remueve y retorna el elemento al frente (O(1)); lanza NoSuchElementException si está vacía.
- T peek(): retorna el elemento al frente sin extraerlo (O(1)); lanza NoSuchElementException si está vacía.
- boolean estaVacia(): indica si la cola no tiene nodos.
- int getSize(): retorna la cantidad de elementos.
- void imprimir(): muestra los elementos desde el frente hasta el final.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio04;

import java.util.NoSuchElementException;

public class Cola<T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public Cola() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Encola un elemento al final de la cola en O(1).
     */
    public void enqueue(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
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
     * Desencola el elemento al frente en O(1).
     * Si la cola queda vacía, actualiza tail a null.
     */
    public T dequeue() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La cola está vacía, no se puede realizar dequeue.");
        }
        T valor = head.getDato();
        head = head.getSiguiente();
        size--;

        if (head == null) {
            tail = null;
        }

        return valor;
    }

    /**
     * Consulta el elemento al frente sin retirarlo en O(1).
     */
    public T peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La cola está vacía, no se puede realizar peek.");
        }
        return head.getDato();
    }

    /**
     * Retorna true si la cola está vacía.
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Retorna la cantidad de elementos en la cola.
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
        Nodo<T> actual = head;
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

