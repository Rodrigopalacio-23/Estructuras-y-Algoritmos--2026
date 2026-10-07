package listas_enlazadas.ejercicio10;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 10: LISTA ENLAZADA GENÉRICA <T>");
        System.out.println("==================================================\n");

        // 1. Prueba con ListaEnlazada<Integer>
        System.out.println("--- 1. Prueba con ListaEnlazada<Integer> ---");
        ListaEnlazada<Integer> listaInt = new ListaEnlazada<>();
        listaInt.insertarAlFinal(10);
        listaInt.insertarAlFinal(20);
        listaInt.insertarAlFinal(10);
        listaInt.insertarAlFinal(30);
        listaInt.imprimir();
        System.out.printf("¿Buscar 20? %b | Ocurrencias de 10: %d\n", listaInt.buscar(20), listaInt.contarOcurrencias(10));
        System.out.println("Invertir lista de enteros:");
        listaInt.invertir();
        listaInt.imprimir();

        // 2. Prueba con ListaEnlazada<String>
        System.out.println("\n--- 2. Prueba con ListaEnlazada<String> ---");
        ListaEnlazada<String> listaStr = new ListaEnlazada<>();
        listaStr.insertarAlFinal("Estructuras");
        listaStr.insertarAlFinal("De");
        listaStr.insertarAlFinal("Datos");
        listaStr.imprimir();
        System.out.printf("Elemento en posición 1: \"%s\"\n", listaStr.obtener(1));
        listaStr.insertarEnPosicion("Avanzadas", 2);
        listaStr.imprimir();
        System.out.println("Eliminar \"De\": " + listaStr.eliminar("De"));
        listaStr.imprimir();

        // 3. Prueba con ListaEnlazada<Alumno> (Objetos de dominio complejos)
        System.out.println("\n--- 3. Prueba con ListaEnlazada<Alumno> ---");
        ListaEnlazada<Alumno> listaAlumnos = new ListaEnlazada<>();
        Alumno a1 = new Alumno(101, "Ana Garcia", 9.5);
        Alumno a2 = new Alumno(102, "Bruno Diaz", 8.0);
        Alumno a3 = new Alumno(103, "Carla Rossi", 9.0);

        listaAlumnos.insertarAlFinal(a1);
        listaAlumnos.insertarAlFinal(a2);
        listaAlumnos.insertarAlFinal(a3);
        listaAlumnos.imprimir();

        // Búsqueda por igualdad lógica (equals definido por legajo)
        Alumno alumnoBuscado = new Alumno(102, "NombreDistinto", 0.0); // Mismo legajo 102
        System.out.printf("¿Existe alumno con legajo 102? %b\n", listaAlumnos.buscar(alumnoBuscado));

        System.out.println("Eliminando alumno con legajo 102:");
        listaAlumnos.eliminar(alumnoBuscado);
        listaAlumnos.imprimir();

        System.out.println("\nInvertir lista de alumnos:");
        listaAlumnos.invertir();
        listaAlumnos.imprimir();

        System.out.println("\nPruebas de Ejercicio 10 completadas con éxito.");
    }
}

