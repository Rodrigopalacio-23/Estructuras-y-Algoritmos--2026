public class Libro {
    private final String titulo;
    private final String autor;
    private boolean disponible;
    private Usuario usuarioPrestado;

    public Libro(){
        this("Sin titulo", "Autor desconocido");
    }

    public Libro(String titulo, String autor){
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo del libro no puede estar vacio.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor del libro no puede estar vacio.");
        }

        this.titulo = titulo.trim();
        this.autor= autor.trim();
        this.disponible = true;
        this.usuarioPrestado = null;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public boolean isDisponible(){
        return disponible;
    }

    public Usuario getUsuarioPrestado(){
        return usuarioPrestado;
    }

    public boolean prestar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Se necesita un usuario valido para prestar el libro.");
        }
        if (!disponible) {
            return false;
        }

        disponible = false;
        usuarioPrestado = usuario;
        return true;
    }

    public boolean devolver() {
        if (disponible) {
            return false;
        }

        disponible = true;
        usuarioPrestado = null;
        return true;
    }

    public String getEstado() {
        return disponible ? "disponible" : "prestado";
    }

    @Override
    public String toString() {
        String prestadoA = usuarioPrestado == null ? "nadie" : usuarioPrestado.toString();
        return "Libro{titulo='" + titulo + "', autor='" + autor + "', estado='" + getEstado()
                + "', usuarioPrestado=" + prestadoA + "}";
    }
}
