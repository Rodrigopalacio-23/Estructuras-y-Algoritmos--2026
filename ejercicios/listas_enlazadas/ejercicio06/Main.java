package listas_enlazadas.ejercicio06;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 6: ELIMINAR NODO POR POSICIÓN");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // 1. Caso límite: eliminar por posición en lista vacía
        System.out.println("--- 1. Eliminar por posición en lista vacía ---");
        try {
            lista.eliminarEnPosicion(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage() + "\n");
        }

        // Construcción de la lista: 10 -> 20 -> 30 -> 40 -> 50 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(50);
        System.out.print("Lista inicial (size = " + lista.getSize() + "): ");
        lista.imprimir();

        // 2. Eliminar al inicio (posición 0)
        System.out.println("\n--- 2. Eliminar posición 0 (inicio: valor 10) ---");
        lista.eliminarEnPosicion(0);
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        // 3. Eliminar en el medio (posición 1: valor 30 actual)
        System.out.println("\n--- 3. Eliminar posición 1 (medio: valor 30) ---");
        lista.eliminarEnPosicion(1);
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        // 4. Eliminar al final (posición 2: valor 50 actual)
        System.out.println("\n--- 4. Eliminar posición 2 (final: valor 50) ---");
        lista.eliminarEnPosicion(2);
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        // 5. Casos límite de error
        System.out.println("\n--- 5. Casos de error de límites ---");
        try {
            System.out.print("Eliminar posición negativa (-1): ");
            lista.eliminarEnPosicion(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        try {
            System.out.printf("Eliminar posición igual a size (%d): ", lista.getSize());
            lista.eliminarEnPosicion(lista.getSize());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 6 completadas con éxito.");
    }
}

