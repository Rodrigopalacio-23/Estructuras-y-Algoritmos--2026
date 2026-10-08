package pilas_colas_enlazadas.ejercicio05;

public class Nodo {
    private String url;
    private Nodo siguiente;

    public Nodo(String url) {
        this.url = url;
        this.siguiente = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}

