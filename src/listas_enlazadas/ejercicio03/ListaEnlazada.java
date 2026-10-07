/*
Prompt inicial utilizado:
A partir de la ListaEnlazada con búsqueda, quiero implementar el método para consultar un elemento por su índice ordinal:
int obtener(int posicion)

### Razonamiento Conceptual: Recorrido Secuencial vs. Acceso por Índice en Arreglos
- Aunque el método reciba un parámetro entero 'posicion' similar al índice de un arreglo (0, 1, 2, ...), en una lista enlazada simple NO existe acceso directo O(1).
- Para obtener el elemento en la posición 'posicion', el algoritmo debe validar rigurosamente los límites y luego posicionar un puntero temporal 'actual = head' para realizar exactamente 'posicion' avances sucesivos (actual = actual.getSiguiente()).
- El costo computacional es O(k) donde k es la posición solicitada (hasta O(n) para el último elemento).

### Validación de Casos Límite
- Si posicion < 0 o posicion >= size (incluyendo lista vacía donde size == 0): Debe lanzar IndexOutOfBoundsException indicando el índice inválido y el tamaño actual de la lista.
- Si posicion == 0: Retorna inmediatamente head.getDato() (O(1)).
- Si posicion == size - 1: Retorna el último dato tras recorrer toda la lista (O(n)).

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio03;

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

    /**
     * Obtiene el dato ubicado en la posición indicada mediante recorrido secuencial.
     *
     * @param posicion índice 0-based a consultar
     * @return valor entero almacenado en dicha posición
     * @throws IndexOutOfBoundsException si posicion < 0 o posicion >= size
     */
    public int obtener(int posicion) {
        // Validación de límites
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Índice fuera de rango: %d. Tamaño actual de la lista: %d.", posicion, size));
        }

        // Recorrido secuencial nodo a nodo
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

