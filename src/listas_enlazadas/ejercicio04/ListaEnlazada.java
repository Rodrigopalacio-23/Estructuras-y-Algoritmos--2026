/*
Prompt inicial utilizado:
A partir de la ListaEnlazada anterior, quiero implementar el método para insertar un elemento en cualquier posición válida:
void insertarEnPosicion(int dato, int posicion)

### Razonamiento Conceptual: Orden de Actualización de Referencias
Para insertar un nuevo nodo entre dos nodos existentes ('actual' y 'actual.getSiguiente()'):
1. Orden Correcto:
   nuevo.setSiguiente(actual.getSiguiente());
   actual.setSiguiente(nuevo);
   - Primero conectamos el nuevo nodo con el resto de la lista para asegurar el enlace hacia adelante.
   - Luego redirigimos el nodo anterior ('actual') hacia el nuevo nodo.
2. ¿Qué ocurre si se invierte el orden?:
   Si hiciéramos primero: actual.setSiguiente(nuevo);
   Sobrescribiríamos el puntero que apunta al resto de la lista. En ese momento, se pierde para siempre la referencia a la subcadena siguiente (los nodos posteriores quedan huérfanos e inaccesibles). Si luego hiciéramos nuevo.setSiguiente(actual.getSiguiente()), conectaríamos 'nuevo' consigo mismo (creando un ciclo o bucle infinito) y destruyendo el resto de la lista. Por esta razón, el orden es estricto y no conmutable.

### Casos a Contemplar
- Posición inválida (posicion < 0 o posicion > size): Lanzar IndexOutOfBoundsException.
- Insertar al inicio (posicion == 0): Llama a insertarAlInicio(dato) para actualizar head correctamente.
- Insertar al final (posicion == size): Llama a insertarAlFinal(dato).
- Insertar en el medio (0 < posicion < size): Se avanza hasta la posición 'posicion - 1' y se aplican las dos sentencias en el orden correcto, incrementando size en 1.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio04;

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
     * Inserta un dato en una posición determinada de la lista enlazada.
     *
     * @param dato     valor entero a insertar
     * @param posicion índice 0-based donde se ubicará el nuevo nodo (de 0 a size inclusive)
     * @throws IndexOutOfBoundsException si posicion < 0 o posicion > size
     */
    public void insertarEnPosicion(int dato, int posicion) {
        // Validación de límites: posicion == size es válida (inserción al final)
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida: %d. Rango permitido: [0, %d].", posicion, size));
        }

        // Caso 1: Inserción al inicio
        if (posicion == 0) {
            insertarAlInicio(dato);
            return;
        }

        // Caso 2: Inserción al final
        if (posicion == size) {
            insertarAlFinal(dato);
            return;
        }

        // Caso 3: Inserción en el medio
        Nodo nuevo = new Nodo(dato);
        Nodo actual = head;

        // Se avanza hasta el nodo inmediatamente anterior (posicion - 1)
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getSiguiente();
        }

        // ORDEN ESTRICTO DE ACTUALIZACIÓN:
        // 1. El nuevo nodo apunta al siguiente del nodo actual
        nuevo.setSiguiente(actual.getSiguiente());
        // 2. El nodo actual ahora apunta al nuevo nodo
        actual.setSiguiente(nuevo);

        size++;
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

