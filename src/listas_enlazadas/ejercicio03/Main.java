package listas_enlazadas.ejercicio03;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 3: OBTENER ELEMENTO POR POSICIÓN");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // 1. Caso límite: obtener en lista vacía
        System.out.println("--- 1. Caso límite: Obtener en lista vacía ---");
        try {
            lista.obtener(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        // Construcción de la lista: 100 -> 200 -> 300 -> 400 -> null
        lista.insertarAlFinal(100);
        lista.insertarAlFinal(200);
        lista.insertarAlFinal(300);
        lista.insertarAlFinal(400);
        System.out.print("Lista de prueba (size = " + lista.getSize() + "): ");
        lista.imprimir();

        // 2. Casos válidos
        System.out.println("\n--- 2. Casos válidos de obtención ---");
        System.out.println("Posición 0 (inicio): " + lista.obtener(0));
        System.out.println("Posición 2 (medio):  " + lista.obtener(2));
        System.out.println("Posición 3 (final):  " + lista.obtener(3));

        // 3. Casos límites de error
        System.out.println("\n--- 3. Casos de error con índices fuera de rango ---");
        try {
            System.out.print("Intentando obtener posición negativa (-1): ");
            lista.obtener(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        try {
            System.out.print("Intentando obtener posición igual al tamaño (4): ");
            lista.obtener(4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        try {
            System.out.print("Intentando obtener posición excesiva (10): ");
            lista.obtener(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Capturada -> " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 3 completadas con éxito.");
    }
}

