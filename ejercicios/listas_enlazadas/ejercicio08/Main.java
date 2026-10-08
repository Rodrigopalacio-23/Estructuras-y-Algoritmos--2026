package listas_enlazadas.ejercicio08;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 8: CONTAR OCURRENCIAS DE UN VALOR");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // 1. Caso límite: lista vacía
        System.out.println("--- 1. Contar en lista vacía ---");
        System.out.printf("Ocurrencias de 10 en lista vacía: %d\n\n", lista.contarOcurrencias(10));

        // Construcción del ejemplo exacto de la consigna:
        // 10 -> 20 -> 10 -> 30 -> 10 -> null
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(20);
        lista.insertarAlFinal(10);
        lista.insertarAlFinal(30);
        lista.insertarAlFinal(10);
        System.out.print("Lista del enunciado: ");
        lista.imprimir();

        // 2. Probar el valor 10 (debe dar 3)
        System.out.println("\n--- 2. Caso de la consigna: Contar valor 10 ---");
        int oc10 = lista.contarOcurrencias(10);
        System.out.printf("Ocurrencias de 10: %d (Esperado: 3)\n", oc10);

        // 3. Probar valor con 1 ocurrencia (20)
        System.out.println("\n--- 3. Contar valor con 1 aparición (20) ---");
        System.out.printf("Ocurrencias de 20: %d (Esperado: 1)\n", lista.contarOcurrencias(20));

        // 4. Probar valor con 0 ocurrencias (99)
        System.out.println("\n--- 4. Contar valor inexistente (99) ---");
        System.out.printf("Ocurrencias de 99: %d (Esperado: 0)\n", lista.contarOcurrencias(99));

        // 5. Lista con todos los elementos idénticos
        System.out.println("\n--- 5. Lista con todos elementos idénticos ---");
        ListaEnlazada listaIguales = new ListaEnlazada();
        listaIguales.insertarAlFinal(7);
        listaIguales.insertarAlFinal(7);
        listaIguales.insertarAlFinal(7);
        listaIguales.insertarAlFinal(7);
        listaIguales.imprimir();
        System.out.printf("Ocurrencias de 7: %d (Esperado: 4)\n", listaIguales.contarOcurrencias(7));

        System.out.println("\nPruebas de Ejercicio 8 completadas con éxito.");
    }
}

