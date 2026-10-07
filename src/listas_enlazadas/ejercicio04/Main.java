package listas_enlazadas.ejercicio04;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 4: INSERTAR EN POSICIÓN ESPECÍFICA");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // 1. Inserción al inicio con posicion = 0 en lista vacía
        System.out.println("--- 1. Inserción en posición 0 (inicio en lista vacía) ---");
        lista.insertarEnPosicion(20, 0);
        lista.imprimir();
        System.out.printf("Tamaño: %d\n\n", lista.getSize());

        // 2. Inserción al inicio con elementos previos
        System.out.println("--- 2. Inserción en posición 0 (nuevo inicio) ---");
        lista.insertarEnPosicion(10, 0);
        lista.imprimir();
        System.out.printf("Tamaño: %d\n\n", lista.getSize());

        // 3. Inserción al final con posicion == size
        System.out.println("--- 3. Inserción en posición 2 (final: pos == size) ---");
        lista.insertarEnPosicion(40, lista.getSize());
        lista.imprimir();
        System.out.printf("Tamaño: %d\n\n", lista.getSize());

        // 4. Inserción en el medio
        System.out.println("--- 4. Inserción en el medio (posición 2 con valor 30) ---");
        lista.insertarEnPosicion(30, 2);
        lista.imprimir();
        System.out.printf("Tamaño: %d\n\n", lista.getSize());

        // 5. Casos de error / límites
        System.out.println("--- 5. Casos límite de error (posiciones fuera de rango) ---");
        try {
            System.out.print("Insertar en posición negativa (-1): ");
            lista.insertarEnPosicion(99, -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        try {
            System.out.printf("Insertar en posición mayor al tamaño (%d > %d): ", 10, lista.getSize());
            lista.insertarEnPosicion(99, 10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        System.out.println("\nEstado final esperado: 10 -> 20 -> 30 -> 40 -> null");
        System.out.print("Estado final obtenido: ");
        lista.imprimir();

        System.out.println("\nPruebas de Ejercicio 4 completadas con éxito.");
    }
}

