import java.util.Scanner;

public class BibliotecaTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Biblioteca ===");
        Usuario usuario1 = crearUsuario(scanner, 1);
        Usuario usuario2 = crearUsuario(scanner, 2);
        Libro libro = crearLibro(scanner);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    prestarLibro(libro, usuario1);
                    break;
                case 2:
                    prestarLibro(libro, usuario2);
                    break;
                case 3:
                    devolverLibro(libro);
                    break;
                case 4:
                    mostrarEstado(libro);
                    break;
                case 5:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static Usuario crearUsuario(Scanner scanner, int numeroUsuario) {
        while (true) {
            try {
                System.out.println("Carga del usuario " + numeroUsuario + ":");
                String nombre = leerTexto(scanner, "Nombre: ");
                int id = leerEntero(scanner, "ID: ");
                Usuario usuario = new Usuario(nombre, id);
                System.out.println("Usuario registrado: " + usuario);
                return usuario;
            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }

    private static Libro crearLibro(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Carga del libro:");
                String titulo = leerTexto(scanner, "Titulo: ");
                String autor = leerTexto(scanner, "Autor: ");
                Libro libro = new Libro(titulo, autor);
                System.out.println("Libro registrado: " + libro);
                return libro;
            } catch (IllegalArgumentException error) {
                System.out.println("Error: " + error.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println();
        System.out.println("1. Prestar libro al usuario 1");
        System.out.println("2. Prestar libro al usuario 2");
        System.out.println("3. Devolver libro");
        System.out.println("4. Mostrar estado del libro");
        System.out.println("5. Salir");
    }

    private static void prestarLibro(Libro libro, Usuario usuario) {
        System.out.println("Intentando prestar '" + libro.getTitulo() + "' a " + usuario.getNombre() + "...");
        if (libro.prestar(usuario)) {
            System.out.println("Prestamo exitoso.");
        } else {
            System.out.println("El libro no esta disponible.");
        }
        mostrarEstado(libro);
    }

    private static void devolverLibro(Libro libro) {
        System.out.println("Intentando devolver '" + libro.getTitulo() + "'...");
        if (libro.devolver()) {
            System.out.println("Devolucion exitosa.");
        } else {
            System.out.println("El libro ya estaba disponible.");
        }
        mostrarEstado(libro);
    }

    private static void mostrarEstado(Libro libro) {
        System.out.println("Estado actual: " + libro);
    }

    private static String leerTexto(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println("El campo no puede estar vacio.");
        }
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException error) {
                System.out.println("Debe ingresar un numero entero valido.");
            }
        }
    }
}
