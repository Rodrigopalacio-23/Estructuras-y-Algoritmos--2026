package pilas_colas_enlazadas.ejercicio03;

public class Tarea {
    private int id;
    private String descripcion;
    private int prioridad;

    public Tarea(int id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Tarea#" + id + "('" + descripcion + "', prio=" + prioridad + ")";
    }
}

