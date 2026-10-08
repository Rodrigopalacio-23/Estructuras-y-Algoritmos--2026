/*
Prompt inicial utilizado:
Quiero implementar en Java un spooler de impresión o cola de trabajos de impresión (ColaImpresion) utilizando una Cola Enlazada propia de objetos TrabajoImpresion, sin utilizar ninguna clase de la Java Collections Framework.

### Estructura de Clases y Nodos
- Clase TrabajoImpresion: modelo con campos 'archivo' (String), 'paginas' (int) y 'usuario' (String).
- Clase Nodo: almacena un TrabajoImpresion y el puntero autorreferencial 'siguiente' (Nodo).
- Clase ColaImpresion: administra la cola de impresión mediante punteros 'head' (frente: próximo trabajo a imprimir), 'tail' (final: último trabajo enviado a imprimir) y un contador 'size'.

### Razonamiento Conceptual: Spooler de Impresora y Modelo FIFO
- Por qué una Cola (FIFO) modela adecuadamente un spooler de impresión:
  Un dispositivo físico como una impresora procesa un solo documento a la vez a partir de un búfer de trabajos (spooling). Para respetar el orden cronológico en que los usuarios o procesos enviaron sus documentos a imprimir, el primer trabajo recibido debe ser el primero en enviarse al cabezal de impresión (First-In, First-Out). Un esquema LIFO (pila) provocaría que un usuario que envió un documento hace horas quede postergado si otro usuario continúa enviando documentos nuevos.
- Complejidad O(1) con punteros head y tail:
  - agregarTrabajo(TrabajoImpresion): encola al final mediante 'tail' en tiempo constante O(1).
  - imprimirProximo(): extrae y remueve el trabajo del frente mediante 'head' en tiempo constante O(1). Si la cola se vacía, 'tail' se actualiza a null.
  - consultarProximo(): devuelve el trabajo al frente sin removerlo en O(1).
  - mostrarPendientes(): recorre la cola mostrando todos los trabajos pendientes y calculando métricas como el total de páginas acumuladas en O(n).
- Casos límite y excepciones:
  - Si la cola está vacía e intentamos imprimir o consultar el próximo trabajo, debe lanzarse NoSuchElementException.

### Operaciones Requeridas
- void agregarTrabajo(TrabajoImpresion trabajo): envía un nuevo trabajo a la cola de impresión (O(1)).
- TrabajoImpresion imprimirProximo(): retira y procesa el siguiente trabajo al frente (O(1)); lanza NoSuchElementException si no hay trabajos.
- TrabajoImpresion consultarProximo(): consulta el próximo trabajo a imprimir sin retirarlo (O(1)); lanza NoSuchElementException si no hay trabajos.
- int getCantidadTrabajos(): retorna la cantidad de trabajos en cola.
- boolean estaVacia(): indica si no hay trabajos pendientes.
- void mostrarPendientes(): muestra los trabajos encolados y el total de páginas por imprimir.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio09;

import java.util.NoSuchElementException;

public class ColaImpresion {
    private Nodo head;
    private Nodo tail;
    private int size;

    public ColaImpresion() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Encola un nuevo trabajo al final de la cola de impresión en O(1).
     */
    public void agregarTrabajo(TrabajoImpresion trabajo) {
        if (trabajo == null) {
            throw new IllegalArgumentException("El trabajo de impresión no puede ser nulo.");
        }
        Nodo nuevo = new Nodo(trabajo);
        if (estaVacia()) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.setSiguiente(nuevo);
            tail = nuevo;
        }
        size++;
    }

    /**
     * Imprime y remueve el trabajo al frente de la cola en O(1).
     */
    public TrabajoImpresion imprimirProximo() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: No hay trabajos pendientes en la cola de impresión.");
        }
        TrabajoImpresion proximo = head.getTrabajo();
        head = head.getSiguiente();
        size--;

        if (head == null) {
            tail = null;
        }

        return proximo;
    }

    /**
     * Consulta el trabajo al frente sin removerlo en O(1).
     */
    public TrabajoImpresion consultarProximo() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: No hay trabajos pendientes en la cola de impresión.");
        }
        return head.getTrabajo();
    }

    /**
     * Retorna la cantidad de trabajos encolados.
     */
    public int getCantidadTrabajos() {
        return size;
    }

    /**
     * Indica si la cola de impresión está vacía.
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Muestra todos los trabajos en cola de impresión en orden FIFO y calcula el total de páginas.
     */
    public void mostrarPendientes() {
        if (estaVacia()) {
            System.out.println("Cola de impresión vacía. No hay trabajos pendientes.");
            return;
        }
        System.out.println("--- Cola de Impresión Spooler (Próximo al inicio) ---");
        Nodo actual = head;
        int pos = 1;
        int totalPaginas = 0;
        while (actual != null) {
            System.out.printf("  %d. %s\n", pos, actual.getTrabajo());
            totalPaginas += actual.getTrabajo().getPaginas();
            actual = actual.getSiguiente();
            pos++;
        }
        System.out.printf("Total trabajos: %d | Total páginas acumuladas: %d\n", size, totalPaginas);
        System.out.println("-----------------------------------------------------");
    }
}

