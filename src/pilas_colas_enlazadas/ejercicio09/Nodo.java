package pilas_colas_enlazadas.ejercicio09;

public class Nodo {
    private TrabajoImpresion trabajo;
    private Nodo siguiente;

    public Nodo(TrabajoImpresion trabajo) {
        this.trabajo = trabajo;
        this.siguiente = null;
    }

    public TrabajoImpresion getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(TrabajoImpresion trabajo) {
        this.trabajo = trabajo;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

