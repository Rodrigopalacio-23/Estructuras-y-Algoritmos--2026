/*
Prompt inicial utilizado:
A partir de la ListaEnlazada con eliminación por posición, quiero implementar el método para actualizar el valor de un nodo:
void modificar(int posicion, int nuevoDato)

### Razonamiento Conceptual: Modificar el Dato vs. Modificar la Referencia
- Modificar el dato (actual.setDato(nuevoDato)):
  Consiste simplemente en sobrescribir el valor almacenado dentro del campo 'dato' del objeto Nodo ya existente. No se crea ningún nodo nuevo, no se eliminan nodos y no se altera en absoluto la topología de la lista. Las conexiones hacia el nodo anterior y hacia el nodo siguiente permanecen 100% intactas.
- Modificar la referencia (actual.setSiguiente(...)):
  Altera la estructura y conectividad de la lista. Conecta o desconecta nodos, pudiendo insertar, desviar o romper la cadena.
  Por ende, modificar un dato es una operación inocua para la integridad estructural de la lista, a diferencia de la reasignación de punteros.

### Casos Límite y Validaciones
- Validación previa: Si posicion < 0 o posicion >= size, lanzar IndexOutOfBoundsException ANTES de recorrer la lista.
- Modificar la posición 0 (head).
- Modificar una posición intermedia o la última posición (size - 1).

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio07;

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

    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida para eliminar: %d. Tamaño: %d.", posicion, size));
        }
        if (posicion == 0) {
            head = head.getSiguiente();
            size--;
            return;
        }
        Nodo anterior = head;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.getSiguiente();
        }
        Nodo aEliminar = anterior.getSiguiente();
        anterior.setSiguiente(aEliminar.getSiguiente());
        size--;
    }

    /**
     * Modifica el valor almacenado en un nodo en la posición indicada.
     *
     * @param posicion  índice 0-based a modificar
     * @param nuevoDato nuevo valor a asignar
     * @throws IndexOutOfBoundsException si posicion < 0 o posicion >= size
     */
    public void modificar(int posicion, int nuevoDato) {
        // Validación de límites antes de recorrer
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida para modificar: %d. Tamaño actual: %d.", posicion, size));
        }

        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }

        // Modificación del dato (sin alterar enlaces de la estructura)
        actual.setDato(nuevoDato);
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

