package pilas_colas_enlazadas.ejercicio05;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 5: HISTORIAL DE NAVEGACIÓN (PILA)");
        System.out.println("==================================================\n");

        HistorialNavegacion historial = new HistorialNavegacion();
        System.out.printf("¿Historial vacío? %b | Páginas: %d\n", historial.estaVacio(), historial.getCantidadPaginas());

        System.out.println("\n--- 1. Navegación por sitios web ---");
        historial.visitar("https://google.com");
        historial.visitar("https://wikipedia.org");
        historial.visitar("https://github.com");
        historial.visitar("https://stackoverflow.com");

        historial.imprimirHistorial();
        System.out.println("Página actual: " + historial.paginaActual());

        System.out.println("\n--- 2. Acción Retroceder (Volver atrás) ---");
        System.out.println("Cerrando y retrocediendo de: " + historial.retroceder());
        System.out.println("Nueva página actual: " + historial.paginaActual());

        System.out.println("Cerrando y retrocediendo de: " + historial.retroceder());
        System.out.println("Nueva página actual: " + historial.paginaActual());

        historial.imprimirHistorial();

        System.out.println("\n--- 3. Visitar una nueva página luego de retroceder ---");
        historial.visitar("https://docs.oracle.com");
        historial.imprimirHistorial();
        System.out.println("Página actual: " + historial.paginaActual());

        System.out.println("\n--- 4. Casos límite (retroceder hasta vaciar) ---");
        while (!historial.estaVacio()) {
            System.out.println("Retrocediendo de: " + historial.retroceder());
        }

        try {
            historial.retroceder();
        } catch (IllegalStateException e) {
            System.out.println("Captura esperada al retroceder sin páginas: " + e.getMessage());
        }

        try {
            historial.paginaActual();
        } catch (IllegalStateException e) {
            System.out.println("Captura esperada al consultar página actual vacía: " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 5 completadas con éxito.");
    }
}

