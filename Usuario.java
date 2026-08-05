/*En una biblioteca se desea implementar un sistema simple para gestionar el
préstamo de libros a los usuarios.
Cada libro posee un título, un autor y un estado que indica si se encuentra
disponible o prestado.
Por otro lado, los usuarios de la biblioteca tienen un nombre y un identificador único.
Cuando un usuario solicita un libro, se debe verificar si el mismo se encuentra
disponible. En caso afirmativo, el libro pasa a estado “prestado” y se registra qué
usuario realizó la operación. Si el libro no está disponible, se debe informar la
situación.
Posteriormente, el usuario podrá devolver el libro, lo que hará que el mismo vuelva a
estar disponible.
El sistema debe permitir representar esta situación mediante objetos y sus
interacciones.
 */

public class Usuario{
    private final String nombre;
    private final int id;

    public Usuario(){
        this("Sin nombre", 0);
    }

    public Usuario(String nombre,int id ){
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacio.");
        }
        if (id < 0) {
            throw new IllegalArgumentException("El identificador del usuario no puede ser negativo.");
        }

        this.nombre = nombre.trim();
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
