package pilas_colas_enlazadas.ejercicio07;

public class Nodo {
    private char caracter;
    private Nodo siguiente;

    public Nodo(char caracter) {
        this.caracter = caracter;
        this.siguiente = null;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

