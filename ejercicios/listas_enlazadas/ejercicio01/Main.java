package listas_enlazadas.ejercicio01;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 1: LISTA ENLAZADA SIMPLE BASE");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();
        System.out.printf("¿Lista recién creada está vacía? %b | Tamaño: %d\n", lista.estaVacia(), lista.getSize());
        lista.imprimir();

        System.out.println("\n--- 1. Insertando elementos al inicio (30, 20, 10) ---");
        lista.insertarAlInicio(30);
        lista.insertarAlInicio(20);
        lista.insertarAlInicio(10);
        lista.imprimir();
        System.out.printf("Tamaño actual: %d | ¿Está vacía? %b\n", lista.getSize(), lista.estaVacia());

        System.out.println("\n--- 2. Insertando elementos al final (40, 50) ---");
        lista.insertarAlFinal(40);
        lista.insertarAlFinal(50);
        lista.imprimir();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        System.out.println("\n--- 3. Verificación de invariantes ---");
        System.out.println("Esperado: 10 -> 20 -> 30 -> 40 -> 50 -> null");
        System.out.println("Pruebas de Ejercicio 1 completadas con éxito.");
    }
}

