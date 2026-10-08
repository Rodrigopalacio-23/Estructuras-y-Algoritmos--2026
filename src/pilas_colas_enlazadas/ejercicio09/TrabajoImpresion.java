package pilas_colas_enlazadas.ejercicio09;

public class TrabajoImpresion {
    private String archivo;
    private int paginas;
    private String usuario;

    public TrabajoImpresion(String archivo, int paginas, String usuario) {
        this.archivo = archivo;
        this.paginas = paginas;
        this.usuario = usuario;
    }

    public String getArchivo() {
        return archivo;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Trabajo['" + archivo + "', " + paginas + " págs., usuario: " + usuario + "]";
    }
}

