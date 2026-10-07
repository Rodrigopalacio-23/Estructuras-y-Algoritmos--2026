/*
Quiero implementar en Java un simulador de historial de navegación web (HistorialNavegacion) utilizando una Pila basada en arreglos.

### Estructura y Arreglo Interno
La clase debe gestionar un arreglo String[] historial de tamaño fijo y un índice 'tope' que apunte a la URL de la página web actual en la cima de la pila.

### Razonamiento: ¿Por qué el Historial de Navegación funciona bajo el principio LIFO?
Durante la navegación en un navegador web, el usuario transita secuencialmente por una serie de páginas (por ejemplo: Inicio -> Noticias -> Deportes).
- Cuando el usuario hace clic en el botón "Atrás" (retroceder), la expectativa fundamental del usuario es regresar a la página que visitó más recientemente (la última en ser visitada antes de la actual).
- Esto responde estrictamente al principio LIFO (Last-In, First-Out): la última URL apilada en el historial es la primera que se desapila al solicitar volver atrás. Si utilizáramos una cola (FIFO), al presionar "Atrás" volveríamos a la primera página histórica (la más antigua), lo cual quebraría la lógica de navegación web.

### Operaciones Requeridas
- void visitar(String url): Apila la nueva URL en el historial.
- String retroceder(): Realiza pop del historial, retornando a la página anterior.
- String paginaActual(): Consulta la cima del historial sin modificarlo.
- int cantidadPaginas() y boolean puedeRetroceder().

### Casos Límite y Manejo de Errores
- Historial lleno: Si se supera la capacidad máxima del arreglo, se lanza IllegalStateException("Error: Historial lleno, no se pueden almacenar más visitas.").
- No se puede retroceder: Si solo queda 1 página (la inicial) o ninguna, intentar retroceder debe controlarse informando que no hay página anterior o lanzando IllegalStateException("Error: No hay páginas anteriores en el historial.").

### Casos de Prueba en Main
Crear un historial de capacidad 5. Visitar "google.com", "wikipedia.org", "github.com", "stackoverflow.com". Consultar página actual. Retroceder dos veces (observando el regreso en orden LIFO). Visitar una nueva página "reddit.com". Retroceder hasta llegar a la página inicial e intentar retroceder más allá del límite capturando el error.
*/

package pilas_y_colas.ejercicio04;

import java.util.Arrays;

public class HistorialNavegacion {
    private final String[] historial;
    private int tope;
    private final int capacidad;

    public HistorialNavegacion(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        this.capacidad = capacidad;
        this.historial = new String[capacidad];
        this.tope = -1;
    }

    public void visitar(String url) {
        if (tope == capacidad - 1) {
            throw new IllegalStateException("Error: El historial está lleno (capacidad " + capacidad + "). No se puede visitar: " + url);
        }
        historial[++tope] = url;
        System.out.println("-> Navegando a: " + url);
    }

    public String retroceder() {
        if (tope <= 0) {
            throw new IllegalStateException("Error: No es posible retroceder más. Estás en la primera página o el historial está vacío.");
        }
        String paginaAbandonada = historial[tope];
        historial[tope--] = null; // Limpiar referencia
        System.out.printf("<- Retrocediendo desde \"%s\" hacia \"%s\"\n", paginaAbandonada, historial[tope]);
        return historial[tope];
    }

    public String paginaActual() {
        if (tope == -1) {
            throw new IllegalStateException("El historial está completamente vacío.");
        }
        return historial[tope];
    }

    public boolean puedeRetroceder() {
        return tope > 0;
    }

    public int cantidadPaginas() {
        return tope + 1;
    }

    public void mostrarHistorial() {
        System.out.print("[Pila de Historial (inicio -> cima)]: ");
        for (int i = 0; i <= tope; i++) {
            System.out.print(historial[i] + (i < tope ? " -> " : " (ACTUAL)"));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 4: HISTORIAL DE NAVEGACIÓN (LIFO)");
        System.out.println("==================================================\n");

        HistorialNavegacion navegador = new HistorialNavegacion(5);

        System.out.println("--- 1. Navegación secuencial ---");
        navegador.visitar("https://www.google.com");
        navegador.visitar("https://es.wikipedia.org");
        navegador.visitar("https://github.com");
        navegador.visitar("https://stackoverflow.com");
        navegador.mostrarHistorial();

        System.out.println("\nPágina actual: " + navegador.paginaActual() + "\n");

        System.out.println("--- 2. Retrocediendo páginas (Principio LIFO) ---");
        navegador.retroceder(); // Vuelve a github.com
        navegador.mostrarHistorial();
        navegador.retroceder(); // Vuelve a wikipedia.org
        navegador.mostrarHistorial();

        System.out.println("\n--- 3. Visita de una nueva URL tras retroceder ---");
        navegador.visitar("https://www.reddit.com");
        navegador.mostrarHistorial();

        System.out.println("\n--- 4. Retrocediendo hasta agotar el historial ---");
        navegador.retroceder(); // Vuelve a wikipedia.org
        navegador.retroceder(); // Vuelve a google.com
        navegador.mostrarHistorial();

        System.out.println("\n--- 5. Intento de retroceder más allá de la página inicial ---");
        try {
            navegador.retroceder();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\nPrueba de Ejercicio 4 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

