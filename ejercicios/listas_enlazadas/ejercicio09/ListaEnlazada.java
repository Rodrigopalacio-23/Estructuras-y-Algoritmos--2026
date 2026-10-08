/*
Prompt inicial utilizado:
A partir de la ListaEnlazada anterior, quiero implementar un método para invertir el orden de los elementos in-place:
void invertir()

### Razonamiento Conceptual: Punteros Auxiliares y Orden Estricto de Actualización
Para invertir la dirección de los enlaces de una lista enlazada simple sin memoria adicional (O(1) auxiliar y O(n) tiempo), se requieren 3 referencias auxiliares:
- 'anterior': Inicializado en null (porque el nodo head original pasará a ser el último nodo, apuntando a null).
- 'actual': Inicializado en head (el nodo que está siendo invertido en la iteración actual).
- 'siguiente': Puntero temporal para resguardar la sublista derecha pendiente.

### ¿Por qué el orden de actualización es fundamental?
El algoritmo sigue este ciclo exacto de 4 pasos por cada nodo:
1. siguiente = actual.getSiguiente();
   Es OBLIGATORIO salvar la referencia al próximo nodo ANTES de alterar los enlaces.
2. actual.setSiguiente(anterior);
   Se invierte el puntero del nodo actual hacia atrás (apunta a 'anterior').
   Si hubiéramos realizado este paso antes del paso 1, habríamos destruido el único camino existente hacia el resto de la lista, dejando huérfanos e inaccesibles a todos los nodos subsiguientes.
3. anterior = actual;
   Se avanza el puntero 'anterior' al nodo recién invertido.
4. actual = siguiente;
   Se avanza 'actual' hacia el nodo que habíamos resguardado en el paso 1.

Al salir del bucle (cuando actual == null), 'anterior' apunta al último nodo de la lista original, el cual pasa a ser la nueva cabeza:
head = anterior;

### Casos a Contemplar
- Lista vacía (head == null): no hace nada.
- Lista con un solo nodo (head.getSiguiente() == null): queda idéntica.
- Lista con múltiples nodos (ejemplo: 10 -> 20 -> 30 -> 40 -> null pasa a 40 -> 30 -> 20 -> 10 -> null).

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio09;

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

    public int contarOcurrencias(int dato) {
        int contador = 0;
        Nodo actual = head;
        while (actual != null) {
            if (actual.getDato() == dato) {
                contador++;
            }
            actual = actual.getSiguiente();
        }
        return contador;
    }

    /**
     * Invierte la dirección de todos los enlaces de la lista enlazada in-situ.
     * Complejidad: O(n) tiempo, O(1) memoria auxiliar.
     */
    public void invertir() {
        if (estaVacia() || head.getSiguiente() == null) {
            return; // Lista vacía o con un solo elemento ya está invertida
        }

        Nodo anterior = null;
        Nodo actual = head;
        Nodo siguiente = null;

        while (actual != null) {
            // 1. Salvar el nodo siguiente antes de romper el enlace
            siguiente = actual.getSiguiente();

            // 2. Invertir el puntero hacia atrás
            actual.setSiguiente(anterior);

            // 3. Avanzar 'anterior' al nodo actual
            anterior = actual;

            // 4. Avanzar 'actual' al siguiente nodo salvado
            actual = siguiente;
        }

        // Al terminar, 'anterior' apunta a la nueva cabeza de la lista
        head = anterior;
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

