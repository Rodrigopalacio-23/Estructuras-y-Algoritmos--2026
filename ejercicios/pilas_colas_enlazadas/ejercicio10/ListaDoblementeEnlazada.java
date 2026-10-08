/*
Prompt inicial utilizado:
Quiero implementar en Java una Lista Doblemente Enlazada Genérica (ListaDoblementeEnlazada<T>) desde cero, utilizando nodos doblemente enlazados y sin utilizar ninguna clase de la Java Collections Framework (como LinkedList, ArrayList, etc.).

### Estructura de Clases y Nodos
- Clase NodoDoble<T>: contiene el dato (T) y dos referencias: 'anterior' y 'siguiente', ambas de tipo NodoDoble<T>.
- Clase ListaDoblementeEnlazada<T>: mantiene dos referencias clave: 'head' (primer nodo de la lista) y 'tail' (último nodo de la lista), además de un contador entero 'size'.

### Razonamiento Conceptual: Lista Doblemente Enlazada y Manejo de Enlaces Bidireccionales
- Ventajas y particularidad de la lista doblemente enlazada:
  A diferencia de la lista simplemente enlazada donde cada nodo solo conoce a su sucesor, en una lista doblemente enlazada cada nodo mantiene punteros hacia adelante (`siguiente`) y hacia atrás (`anterior`). Esto permite navegación bidireccional eficiente (recorrer desde head hacia tail, y desde tail hacia head) y simplifica las operaciones de inserción y eliminación en cualquier extremo en tiempo O(1).
- Inserciones en O(1):
  - insertarAlInicio(T dato):
    - Si está vacía: head = tail = nuevo.
    - Si no está vacía: nuevo.siguiente = head; head.anterior = nuevo; head = nuevo.
  - insertarAlFinal(T dato):
    - Si está vacía: head = tail = nuevo.
    - Si no está vacía: tail.siguiente = nuevo; nuevo.anterior = tail; tail = nuevo.
- Eliminación por valor (eliminar(T dato)):
  Requiere buscar el nodo comparando con `.equals(dato)` (considerando posibles nulos si correspondiese). Una vez ubicado el nodo a eliminar (`actual`), se deben considerar exhaustivamente todos los casos límite de punteros:
  1. Caso lista con un único nodo (`actual == head && actual == tail`):
     head = null; tail = null.
  2. Caso eliminar el primer nodo (`actual == head`):
     head = head.siguiente; head.anterior = null.
  3. Caso eliminar el último nodo (`actual == tail`):
     tail = tail.anterior; tail.siguiente = null.
  4. Caso eliminar un nodo intermedio:
     actual.anterior.siguiente = actual.siguiente;
     actual.siguiente.anterior = actual.anterior;
  En todos los casos exitosos, se decrementa `size--` y se retorna `true`. Si el dato no se encuentra, se retorna `false`.
- Recorridos:
  - imprimirAdelante(): recorre desde 'head' usando 'siguiente'.
  - imprimirAtras(): recorre desde 'tail' usando 'anterior'. Demuestra fehacientemente la correcta vinculación bidireccional.

### Operaciones Requeridas
- void insertarAlInicio(T dato): inserta un elemento al inicio (O(1)).
- void insertarAlFinal(T dato): inserta un elemento al final (O(1)).
- boolean eliminar(T dato): busca y elimina la primera aparición del dato considerando todos los casos; retorna true si lo eliminó, false si no existe.
- void imprimirAdelante(): muestra la lista desde el inicio al final.
- void imprimirAtras(): muestra la lista desde el final al inicio.
- boolean estaVacia(): indica si no hay nodos.
- int getSize(): retorna la cantidad de nodos.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio10;

public class ListaDoblementeEnlazada<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size;

    public ListaDoblementeEnlazada() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Inserta un elemento al inicio de la lista doblemente enlazada en O(1).
     */
    public void insertarAlInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
        } else {
            nuevo.setSiguiente(head);
            head.setAnterior(nuevo);
            head = nuevo;
        }
        size++;
    }

    /**
     * Inserta un elemento al final de la lista doblemente enlazada en O(1).
     */
    public void insertarAlFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.setSiguiente(nuevo);
            nuevo.setAnterior(tail);
            tail = nuevo;
        }
        size++;
    }

    /**
     * Busca y elimina la primera ocurrencia del dato especificado.
     * Contempla exhaustivamente los casos: vacía, nodo único, primer nodo,
     * último nodo y nodo intermedio.
     * Retorna true si el elemento fue encontrado y eliminado, false en caso contrario.
     */
    public boolean eliminar(T dato) {
        if (estaVacia()) {
            return false;
        }

        NodoDoble<T> actual = head;
        while (actual != null) {
            boolean coincide = (dato == null) ? (actual.getDato() == null) : dato.equals(actual.getDato());
            if (coincide) {
                // Caso 1: Único nodo en la lista
                if (actual == head && actual == tail) {
                    head = null;
                    tail = null;
                }
                // Caso 2: Es el primer nodo (head)
                else if (actual == head) {
                    head = head.getSiguiente();
                    head.setAnterior(null);
                }
                // Caso 3: Es el último nodo (tail)
                else if (actual == tail) {
                    tail = tail.getAnterior();
                    tail.setSiguiente(null);
                }
                // Caso 4: Es un nodo intermedio
                else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }

                size--;
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false; // No encontrado
    }

    /**
     * Retorna true si la lista no contiene nodos.
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Retorna la cantidad de elementos presentes en la lista en O(1).
     */
    public int getSize() {
        return size;
    }

    /**
     * Imprime los elementos en dirección hacia adelante: head -> tail.
     */
    public void imprimirAdelante() {
        if (estaVacia()) {
            System.out.println("Lista vacía: [ ]");
            return;
        }
        System.out.print("Head <-> ");
        NodoDoble<T> actual = head;
        while (actual != null) {
            System.out.print("[" + actual.getDato() + "]");
            if (actual.getSiguiente() != null) {
                System.out.print(" <-> ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println(" <-> Tail");
    }

    /**
     * Imprime los elementos en dirección hacia atrás: tail -> head.
     */
    public void imprimirAtras() {
        if (estaVacia()) {
            System.out.println("Lista vacía: [ ]");
            return;
        }
        System.out.print("Tail <-> ");
        NodoDoble<T> actual = tail;
        while (actual != null) {
            System.out.print("[" + actual.getDato() + "]");
            if (actual.getAnterior() != null) {
                System.out.print(" <-> ");
            }
            actual = actual.getAnterior();
        }
        System.out.println(" <-> Head");
    }
}

