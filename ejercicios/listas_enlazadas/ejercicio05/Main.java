package listas_enlazadas.ejercicio05;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 5: ELIMINAR NODO POR VALOR");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // 1. Caso límite: eliminar en lista vacía
        System.out.println("--- 1. Eliminar en lista vacía ---");
        System.out.printf("¿eliminar(10) en vacía? %b | Tamaño: %d\n\n", lista.eliminar(10), lista.getSize());

        // Llenado de la lista: 10 -> 20 -> 30 -> 40 -> 50 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(50);
        System.out.print("Lista inicial (size = " + lista.getSize() + "): ");
        lista.imprimir();

        // 2. Eliminar el primer nodo (head: 10)
        System.out.println("\n--- 2. Eliminar primer nodo (10) ---");
        System.out.printf("Resultado: %b\n", lista.eliminar(10));
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        // 3. Eliminar un nodo del medio (30)
        System.out.println("\n--- 3. Eliminar nodo del medio (30) ---");
        System.out.printf("Resultado: %b\n", lista.eliminar(30));
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        // 4. Eliminar el último nodo (50)
        System.out.println("\n--- 4. Eliminar último nodo (50) ---");
        System.out.printf("Resultado: %b\n", lista.eliminar(50));
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        // 5. Eliminar dato inexistente (99)
        System.out.println("\n--- 5. Eliminar dato inexistente (99) ---");
        System.out.printf("Resultado: %b\n", lista.eliminar(99));
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        System.out.println("\nPruebas de Ejercicio 5 completadas con éxito.");
    }
}

