/*
Prompt inicial utilizado:
A partir de la ListaEnlazada con modificación de elementos, quiero implementar un método para contar cuántas veces se repite un valor:
int contarOcurrencias(int dato)

### Razonamiento Conceptual: Recorrido Exhaustivo vs. Corte Temprano
- En el método 'buscar(dato)', el objetivo es verificar si el dato existe al menos una vez. Apenas se detecta la primera coincidencia, es óptimo cortar el bucle inmediatamente retornando true (detención temprana O(1) en mejor caso).
- En 'contarOcurrencias(dato)', el objetivo es calcular la frecuencia exacta total. Dado que la lista no está ordenada y los nodos repetidos pueden estar distribuidos arbitrariamente a lo largo de toda la cadena, cualquier nodo no visitado podría albergar una nueva ocurrencia del elemento buscado.
- Por ende, cortar el recorrido al hallar la primera coincidencia daría como resultado un conteo incompleto e incorrecto. Es un requisito lógico ineludible recorrer la lista de principio a fin hasta actual == null (complejidad Theta(n)).

### Casos a Contemplar
- Lista vacía: retorna 0 ocurrencias.
- El dato no aparece ninguna vez (0 ocurrencias).
- El dato aparece exactamente una vez (1 ocurrencia).
- El dato aparece múltiples veces (por ejemplo 10 -> 20 -> 10 -> 30 -> 10 -> null retorna 3).
- Todos los nodos de la lista contienen dicho dato (ocurrencias == size).

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio08;

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

    public void modificar(int posicion, int nuevoDato) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida para modificar: %d. Tamaño actual: %d.", posicion, size));
        }
        Nodo actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        actual.setDato(nuevoDato);
    }

    /**
     * Cuenta cuántas veces aparece un valor dentro de la lista enlazada mediante un recorrido exhaustivo.
     *
     * @param dato valor a buscar y contabilizar
     * @return cantidad de ocurrencias halladas
     */
    public int contarOcurrencias(int dato) {
        int contador = 0;
        Nodo actual = head;

        // Recorrido exhaustivo sin corte temprano
        while (actual != null) {
            if (actual.getDato() == dato) {
                contador++;
            }
            actual = actual.getSiguiente();
        }

        return contador;
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

