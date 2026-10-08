/*
Prompt inicial utilizado:
Quiero implementar en Java un Historial de Navegación web (HistorialNavegacion) utilizando una Pila Enlazada propia de URLs (cadenas de texto), sin utilizar ninguna clase de la Java Collections Framework.

### Estructura de Clases y Nodos
- Clase Nodo: almacena 'url' (String) y la referencia 'siguiente' (Nodo).
- Clase HistorialNavegacion: estructura que implementa el comportamiento de navegación con una pila enlazada (puntero 'head' al tope del historial) y un contador 'size'.

### Razonamiento Conceptual: Navegación Web y Modelo LIFO
- Por qué una Pila (LIFO) modela la navegación web:
  En un navegador, la última página visitada es la página en la que nos encontramos actualmente. Cuando el usuario presiona el botón "Atrás" o retroceder, el sistema descarta la página actual y regresa a la inmediatamente anterior. El orden temporal de acceso e inversión ("la última visitada es la primera en salir al retroceder") coincide estrictamente con la semántica LIFO (Last-In, First-Out) de una pila.
- Comportamiento y complejidades O(1):
  - visitar(url): equivale a un 'push' en la cima; la nueva URL pasa a ser la página actual en tiempo O(1).
  - retroceder(): equivale a un 'pop'; remueve la página actual y regresa a la anterior en tiempo O(1). Si el historial solo tiene 1 página o está vacío, no se puede retroceder más (o se informa/lanza excepción).
  - paginaActual(): equivale a un 'peek'; consulta la página en la cima sin modificar el historial en tiempo O(1).
  - imprimirHistorial(): muestra la secuencia de páginas desde la actual hacia las más antiguas en O(n).

### Operaciones Requeridas
- void visitar(String url): navega a una nueva página agregándola al tope del historial.
- String retroceder(): desapila la página actual y retorna la página a la que se retrocedió (o la que se abandonó). Lanza IllegalStateException si no hay páginas para retroceder.
- String paginaActual(): retorna la URL de la página actualmente abierta en el navegador. Lanza IllegalStateException si el historial está vacío.
- int getCantidadPaginas(): retorna cuántas páginas hay en el historial.
- boolean estaVacio(): indica si el historial no contiene páginas.
- void imprimirHistorial(): imprime el historial completo desde la página actual hasta la inicial.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio05;

import java.util.NoSuchElementException;

public class HistorialNavegacion {
    private Nodo head;
    private int size;

    public HistorialNavegacion() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Visita una nueva URL apilándola en el tope del historial en O(1).
     */
    public void visitar(String url) {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalArgumentException("La URL no puede ser nula ni vacía.");
        }
        Nodo nuevo = new Nodo(url);
        nuevo.setSiguiente(head);
        head = nuevo;
        size++;
    }

    /**
     * Retrocede una página en el navegador retirando la página actual en O(1).
     * Retorna la página abandonada.
     * Lanza IllegalStateException si no hay páginas a las que retroceder.
     */
    public String retroceder() {
        if (estaVacio()) {
            throw new IllegalStateException("Error: No hay historial de navegación para retroceder.");
        }
        String abandonada = head.getUrl();
        head = head.getSiguiente();
        size--;
        return abandonada;
    }

    /**
     * Retorna la URL de la página activa (tope) sin removerla en O(1).
     */
    public String paginaActual() {
        if (estaVacio()) {
            throw new IllegalStateException("Error: No hay ninguna página abierta actualmente.");
        }
        return head.getUrl();
    }

    /**
     * Indica si el historial está vacío.
     */
    public boolean estaVacio() {
        return head == null;
    }

    /**
     * Retorna la cantidad de páginas en el historial.
     */
    public int getCantidadPaginas() {
        return size;
    }

    /**
     * Imprime el historial desde la página actual hasta la inicial.
     */
    public void imprimirHistorial() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }
        System.out.println("--- Historial de Navegación (Página actual arriba) ---");
        Nodo actual = head;
        int orden = 1;
        while (actual != null) {
            String etiqueta = (orden == 1) ? "[ACTUAL]" : "[" + orden + "]";
            System.out.println("  " + etiqueta + " " + actual.getUrl());
            actual = actual.getSiguiente();
            orden++;
        }
        System.out.println("-----------------------------------------------------");
    }
}

