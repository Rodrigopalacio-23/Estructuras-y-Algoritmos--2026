package listas_enlazadas.ejercicio09;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 9: INVERTIR LISTA ENLAZADA SIMPLE");
        System.out.println("==================================================\n");

        ListaEnlazada lista = new ListaEnlazada();

        // 1. Caso límite: invertir lista vacía
        System.out.println("--- 1. Invertir lista vacía ---");
        lista.invertir();
        lista.imprimir();

        // 2. Caso límite: lista con un solo nodo
        System.out.println("\n--- 2. Invertir lista de un solo nodo ---");
        lista.insertarAlFinal(100);
        System.out.print("Antes:   ");
        lista.imprimir();
        lista.invertir();
        System.out.print("Después: ");
        lista.imprimir();

        // 3. Caso del enunciado: 10 -> 20 -> 30 -> 40 -> null
        System.out.println("\n--- 3. Invertir lista del enunciado (10 -> 20 -> 30 -> 40) ---");
        ListaEnlazada listaEjemplo = new ListaEnlazada();
        listaEjemplo.insertarAlFinal(10);
        listaEjemplo.insertarAlFinal(20);
        listaEjemplo.insertarAlFinal(30);
        listaEjemplo.insertarAlFinal(40);

        System.out.print("Original:  ");
        listaEjemplo.imprimir();

        listaEjemplo.invertir();

        System.out.print("Invertida: ");
        listaEjemplo.imprimir();
        System.out.println("Esperado:  40 -> 30 -> 20 -> 10 -> null");
        System.out.printf("Tamaño conservado: %d\n", listaEjemplo.getSize());

        // 4. Invertir nuevamente para volver al orden original
        System.out.println("\n--- 4. Invertir nuevamente (reversión doble) ---");
        listaEjemplo.invertir();
        System.out.print("Restaurada: ");
        listaEjemplo.imprimir();

        System.out.println("\nPruebas de Ejercicio 9 completadas con éxito.");
    }
}

