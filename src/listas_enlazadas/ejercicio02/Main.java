package listas_enlazadas.ejercicio02;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 2: BÚSQUEDA SECUENCIAL EN LISTA");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // Caso límite: búsqueda en lista vacía
        System.out.println("--- 1. Búsqueda en lista vacía ---");
        System.out.printf("¿buscar(10) en lista vacía? %b\n\n", lista.buscar(10));

        // Construcción de la lista de prueba: 10 -> 25 -> 40 -> 55 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(25);
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(55);
        System.out.print("Lista de prueba: ");
        lista.imprimir();

        System.out.println("\n--- 2. Casos de prueba de búsqueda ---");
        // Caso A: Primer nodo (head)
        System.out.printf("Buscar primer nodo (10):    %b\n", lista.buscar(10));

        // Caso B: Nodo intermedio
        System.out.printf("Buscar nodo medio (40):      %b\n", lista.buscar(40));

        // Caso C: Último nodo
        System.out.printf("Buscar último nodo (55):     %b\n", lista.buscar(55));

        // Caso D: Elemento inexistente
        System.out.printf("Buscar inexistente (99):     %b\n", lista.buscar(99));

        System.out.println("\nPruebas de Ejercicio 2 completadas con éxito.");
    }
}

