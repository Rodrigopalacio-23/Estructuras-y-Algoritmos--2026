package pilas_colas_enlazadas.ejercicio06;

public class Cliente {
    private String nombre;
    private int numeroTurno;
    private String motivoConsulta;

    public Cliente(String nombre, int numeroTurno, String motivoConsulta) {
        this.nombre = nombre;
        this.numeroTurno = numeroTurno;
        this.motivoConsulta = motivoConsulta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    @Override
    public String toString() {
        return "Turno #" + numeroTurno + " - " + nombre + " (" + motivoConsulta + ")";
    }
}

