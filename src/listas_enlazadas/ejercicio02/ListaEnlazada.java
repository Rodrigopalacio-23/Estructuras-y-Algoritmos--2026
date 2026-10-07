/*
Prompt inicial utilizado:
A partir de la implementación base de ListaEnlazada simple de enteros, quiero agregar el método de búsqueda:
boolean buscar(int dato)

### Razonamiento Conceptual: Ausencia de Acceso por Índice y Necesidad de Recorrido Secuencial
- ¿Por qué no hay acceso directo por índice?:
  En un arreglo clásico, los elementos están ubicados en celdas contiguas de memoria física. El compilador calcula la dirección de cualquier índice 'i' en tiempo constante O(1) con la fórmula matemática: direccion = base + (i * tamano_elemento).
  En una lista enlazada simple, los nodos son objetos creados independientemente y dispersos en cualquier lugar de la memoria heap. La única forma de llegar a un nodo es a través del puntero 'siguiente' del nodo previo. No existe cálculo aritmético directo posible.
- ¿Por qué la búsqueda es estrictamente secuencial?:
  Para saber si un elemento existe, estamos obligados a comenzar en 'head' y avanzar nodo a nodo (actual = actual.getSiguiente()) comparando si actual.getDato() == dato. Si se encuentra coincidencia, retorna true (corte temprano O(1) en mejor caso). Si se llega a null sin encontrarlo, se concluye que no existe (retorna false en O(n)).

### Casos a Contemplar
- Lista vacía (head == null): retorna false de inmediato.
- Elemento ubicado en el primer nodo (head).
- Elemento ubicado en un nodo intermedio.
- Elemento ubicado en el último nodo.
- Elemento inexistente en la lista.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio02;

public class ListaEnlazada {
    private Nodo head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
        size++;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    /**
     * Busca secuencialmente si un valor entero existe dentro de la lista enlazada.
     *
     * @param dato valor a buscar
     * @return true si el dato está presente en algún nodo, false de lo contrario
     */
    public boolean buscar(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.getDato() == dato) {
                return true; // Corte temprano al hallar coincidencia
            }
            actual = actual.getSiguiente(); // Avance secuencial
        }
        return false; // Se llegó a null sin coincidencias
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Lista vacía (null)");
            return;
        }
        Nodo actual = head;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}

