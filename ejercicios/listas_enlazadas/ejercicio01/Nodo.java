package listas_enlazadas.ejercicio01;

/**
 * Representa un nodo individual de una lista enlazada simple de enteros.
 * Contiene el valor entero almacenado y un puntero/enlace al siguiente nodo.
 */
public class Nodo {
    private int dato;
    private Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

