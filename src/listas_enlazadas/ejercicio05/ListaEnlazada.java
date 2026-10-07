/*
Prompt inicial utilizado:
A partir de la ListaEnlazada con inserción en posición, quiero implementar el método para eliminar un nodo por su valor:
boolean eliminar(int dato)

### Razonamiento Conceptual: Cómo se elimina en Java y el Garbage Collector
- En lenguajes como C/C++, la memoria dinámica se libera manualmente mediante llamadas a free() o delete.
- En Java NO se destruye manualmente el objeto Nodo. El proceso de eliminación consiste en desenlazarlo lógicamente de la cadena: hacer que el nodo previo apunte directamente al nodo siguiente (anterior.setSiguiente(actual.getSiguiente())).
- Una vez desenlazado, el nodo queda sin referencias accesibles desde la raíz 'head'. El recolector de basura de Java (Garbage Collector) detecta de forma autónoma que el objeto es inalcanzable (unreachable) y reclama su memoria en el heap.

### Casos a Contemplar
1. Lista vacía (head == null): No hay nada que eliminar, retorna false.
2. Eliminar el primer nodo (head.getDato() == dato): Se actualiza head = head.getSiguiente(), se decrementa size (size--) y retorna true.
3. Eliminar un nodo del medio: Se busca manteniendo punteros 'anterior' y 'actual'. Al coincidir, anterior.setSiguiente(actual.getSiguiente()), size--, retorna true.
4. Eliminar el último nodo: Al coincidir en el último, anterior.setSiguiente(null), size--, retorna true.
5. Dato inexistente: Se recorre toda la lista hasta actual == null sin encontrar el valor, retorna false y size no se modifica.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio05;

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

    public void insertarEnPosicion(int dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida: %d. Rango: [0, %d].", posicion, size));
        }
        if (posicion == 0) {
            insertarAlInicio(dato);
            return;
        }
        if (posicion == size) {
            insertarAlFinal(dato);
            return;
        }

        Nodo nuevo = new Nodo(dato);
        Nodo actual = head;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getSiguiente();
        }
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        size++;
    }

    /**
     * Elimina la primera aparición del dato indicado.
     *
     * @param dato valor a eliminar
     * @return true si el nodo fue encontrado y eliminado, false de lo contrario
     */
    public boolean eliminar(int dato) {
        // Caso 1: Lista vacía
        if (estaVacia()) {
            return false;
        }

        // Caso 2: El nodo a eliminar es el primero (head)
        if (head.getDato() == dato) {
            head = head.getSiguiente();
            size--;
            return true;
        }

        // Casos 3 y 4: El nodo a eliminar está en el medio o al final
        Nodo anterior = head;
        Nodo actual = head.getSiguiente();

        while (actual != null) {
            if (actual.getDato() == dato) {
                // Desenlace del nodo: 'anterior' salta sobre 'actual'
                anterior.setSiguiente(actual.getSiguiente());
                size--;
                // El objeto 'actual' queda inalcanzable y será reclamado por el Garbage Collector
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        // Caso 5: Dato no encontrado tras recorrer toda la lista
        return false;
    }

    public boolean buscar(int dato) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.getDato() == dato) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public int obtener(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Índice fuera de rango: %d. Tamaño: %d.", posicion, size));
        }
        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
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

