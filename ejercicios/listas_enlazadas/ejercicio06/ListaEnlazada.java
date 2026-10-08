/*
Prompt inicial utilizado:
A partir de la ListaEnlazada con eliminación por valor, quiero implementar la eliminación de un nodo por su índice posicional:
void eliminarEnPosicion(int posicion)

### Razonamiento Conceptual: Cómo Encontrar el Nodo Anterior y Redirigir Enlaces
- Para eliminar un nodo en la posición 'posicion', no podemos pararnos directamente sobre él, porque en una lista enlazada simple los enlaces son unidireccionales (hacia adelante). Necesitamos modificar el puntero del nodo inmediatamente previo (índice posicion - 1).
- Búsqueda del nodo anterior: Se itera con un bucle desde i = 0 hasta posicion - 2 (dando posicion - 1 saltos desde head). El puntero 'anterior' queda ubicado exactamente en el nodo que precede al que será eliminado.
- Redirección del enlace: El nodo a eliminar es 'actual = anterior.getSiguiente()'. Para extirparlo de la lista, hacemos que 'anterior' se enlace directamente con el sucesor de 'actual':
  anterior.setSiguiente(actual.getSiguiente());
- El nodo eliminado queda sin referencias vivas y el Garbage Collector lo reclama.

### Casos Límite y Manejo de Errores
- Validación de rango: Si posicion < 0 o posicion >= size (incluyendo lista vacía), se lanza IndexOutOfBoundsException("Posición fuera de rango").
- Eliminar la posición 0 (inicio): Caso especial donde no hay nodo anterior. Se actualiza head = head.getSiguiente(), size--.
- Eliminar una posición intermedia o final (0 < posicion < size): Se busca el nodo anterior, se redirige el puntero y se decrementa size (size--).

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio06;

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

    public boolean eliminar(int dato) {
        if (estaVacia()) {
            return false;
        }
        if (head.getDato() == dato) {
            head = head.getSiguiente();
            size--;
            return true;
        }

        Nodo anterior = head;
        Nodo actual = head.getSiguiente();
        while (actual != null) {
            if (actual.getDato() == dato) {
                anterior.setSiguiente(actual.getSiguiente());
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Elimina el nodo ubicado en una posición específica.
     *
     * @param posicion índice 0-based del nodo a remover
     * @throws IndexOutOfBoundsException si posicion < 0 o posicion >= size
     */
    public void eliminarEnPosicion(int posicion) {
        // Validación rigurosa de límites
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida para eliminar: %d. Tamaño actual: %d.", posicion, size));
        }

        // Caso 1: Eliminar el primer elemento (índice 0)
        if (posicion == 0) {
            head = head.getSiguiente();
            size--;
            return;
        }

        // Caso 2: Eliminar elemento intermedio o final
        Nodo anterior = head;
        // Avanzamos hasta la posición inmediatamente anterior (posicion - 1)
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.getSiguiente();
        }

        // Nodo que será extirpado
        Nodo aEliminar = anterior.getSiguiente();
        // Redirigir el enlace saltando el nodo a eliminar
        anterior.setSiguiente(aEliminar.getSiguiente());
        size--;
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

