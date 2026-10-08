package pilas_colas_enlazadas.ejercicio10;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 10: LISTA DOBLEMENTE ENLAZADA GENÉRICA");
        System.out.println("==================================================\n");

        ListaDoblementeEnlazada<String> lista = new ListaDoblementeEnlazada<>();
        System.out.printf("¿Lista vacía? %b | Tamaño: %d\n", lista.estaVacia(), lista.getSize());

        System.out.println("\n--- 1. Inserciones al Inicio y al Final ---");
        lista.insertarAlFinal("B");
        lista.insertarAlFinal("C");
        lista.insertarAlInicio("A");
        lista.insertarAlFinal("D");
        lista.insertarAlFinal("E");

        System.out.println("Recorrido hacia adelante (head -> tail):");
        lista.imprimirAdelante();
        System.out.println("Recorrido hacia atrás (tail -> head):");
        lista.imprimirAtras();
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        System.out.println("\n--- 2. Eliminación de un nodo intermedio ('C') ---");
        boolean elimC = lista.eliminar("C");
        System.out.printf("¿Eliminado 'C'?: %b\n", elimC);
        lista.imprimirAdelante();
        lista.imprimirAtras();

        System.out.println("\n--- 3. Eliminación del primer nodo ('A' = head) ---");
        boolean elimA = lista.eliminar("A");
        System.out.printf("¿Eliminado 'A'?: %b\n", elimA);
        lista.imprimirAdelante();
        lista.imprimirAtras();

        System.out.println("\n--- 4. Eliminación del último nodo ('E' = tail) ---");
        boolean elimE = lista.eliminar("E");
        System.out.printf("¿Eliminado 'E'?: %b\n", elimE);
        lista.imprimirAdelante();
        lista.imprimirAtras();

        System.out.println("\n--- 5. Intento de eliminar elemento inexistente ('Z') ---");
        boolean elimZ = lista.eliminar("Z");
        System.out.printf("¿Eliminado 'Z'?: %b (esperado: false)\n", elimZ);
        System.out.printf("Tamaño actual: %d\n", lista.getSize());

        System.out.println("\n--- 6. Eliminación hasta lista vacía (caso nodo único) ---");
        System.out.printf("¿Eliminado 'B'?: %b\n", lista.eliminar("B"));
        lista.imprimirAdelante();
        System.out.printf("¿Eliminado 'D' (último que quedaba)?: %b\n", lista.eliminar("D"));
        lista.imprimirAdelante();
        lista.imprimirAtras();
        System.out.printf("¿Lista vacía?: %b | Tamaño: %d\n", lista.estaVacia(), lista.getSize());

        System.out.println("\n--- 7. Eliminación en lista ya vacía ---");
        System.out.printf("¿Eliminado en lista vacía?: %b\n", lista.eliminar("Cualquiera"));

        System.out.println("\n--- 8. Re-inserción posterior tras vaciado completo ---");
        lista.insertarAlFinal("Primero");
        lista.insertarAlFinal("Segundo");
        lista.imprimirAdelante();
        lista.imprimirAtras();

        System.out.println("\nPruebas de Ejercicio 10 completadas con éxito.");
    }
}

