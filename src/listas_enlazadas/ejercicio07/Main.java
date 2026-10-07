package listas_enlazadas.ejercicio07;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 7: MODIFICAR ELEMENTO POR POSICIÓN");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // 1. Caso límite: modificar en lista vacía
        System.out.println("--- 1. Modificar en lista vacía ---");
        try {
            lista.modificar(0, 999);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage() + "\n");
        }

        // Construcción de la lista: 10 -> 20 -> 30 -> 40 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        System.out.print("Lista original: ");
        lista.imprimir();

        // 2. Modificar la cabeza (posición 0)
        System.out.println("\n--- 2. Modificar posición 0 (cambiar 10 por 15) ---");
        lista.modificar(0, 15);
        lista.imprimir();

        // 3. Modificar una posición intermedia (posición 2: cambiar 30 por 35)
        System.out.println("\n--- 3. Modificar posición 2 (cambiar 30 por 35) ---");
        lista.modificar(2, 35);
        lista.imprimir();

        // 4. Modificar el último elemento (posición 3: cambiar 40 por 45)
        System.out.println("\n--- 4. Modificar posición 3 (cambiar 40 por 45) ---");
        lista.modificar(3, 45);
        lista.imprimir();

        // 5. Casos de error fuera de rango
        System.out.println("\n--- 5. Casos límite de error ---");
        try {
            System.out.print("Modificar posición negativa (-1): ");
            lista.modificar(-1, 100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        try {
            System.out.printf("Modificar posición igual a size (%d): ", lista.getSize());
            lista.modificar(lista.getSize(), 100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 7 completadas con éxito.");
    }
}

