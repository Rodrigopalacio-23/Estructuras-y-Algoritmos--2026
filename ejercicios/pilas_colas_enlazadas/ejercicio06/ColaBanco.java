/*
Prompt inicial utilizado:
Quiero implementar en Java un sistema de atención bancaria (ColaBanco) utilizando una Cola Enlazada propia de clientes, sin utilizar ninguna clase de la Java Collections Framework.

### Estructura de Clases y Nodos
- Clase Cliente: contiene los datos del usuario en la fila bancaria: 'nombre' (String), 'numeroTurno' (int) y 'motivoConsulta' (String).
- Clase Nodo: almacena una referencia a Cliente y la referencia 'siguiente' (Nodo).
- Clase ColaBanco: administra la fila bancaria mediante referencias 'head' (primer cliente a ser atendido), 'tail' (último cliente en llegar a la fila) y 'size' (cantidad de clientes esperando).

### Razonamiento Conceptual: Fila Bancaria y Modelo FIFO
- Por qué una Cola (FIFO) modela una fila de banco:
  En una entidad bancaria, la atención se rige por el principio de equidad y orden de llegada: el primer cliente en llegar a la sucursal y tomar un número de turno debe ser el primero en ser llamado y atendido en ventanilla (First-In, First-Out). Una estructura LIFO (pila) sería inaceptable, ya que dejaría esperando indefinidamente a los clientes más antiguos mientras atiende únicamente a los recién llegados (inanición / starvation).
- Eficiencia O(1) con punteros head y tail:
  - agregarCliente(Cliente): se encola al final usando 'tail' en tiempo constante O(1).
  - atenderProximo(): se retira el cliente de la cabecera 'head' en tiempo constante O(1). Si la fila se vacía, 'tail' se actualiza a null.
  - consultarSiguiente(): inspecciona el cliente en 'head' sin modificar la cola en O(1).
  - imprimirFila(): recorre la cola mostrando el orden de atención planificado en O(n).
- Casos límite:
  - Si no hay clientes en espera e intentamos atender o consultar, debe lanzarse NoSuchElementException o IllegalStateException.

### Operaciones Requeridas
- void agregarCliente(Cliente cliente): agrega un nuevo cliente al final de la fila (O(1)).
- Cliente atenderProximo(): llama y atiende al siguiente cliente en turno (O(1)); lanza NoSuchElementException si no hay clientes.
- Cliente consultarSiguiente(): consulta quién es el próximo cliente a ser atendido sin llamarlo (O(1)); lanza NoSuchElementException si no hay clientes.
- int getClientesEnEspera(): retorna la cantidad de clientes esperando turno.
- boolean estaVacia(): indica si no hay clientes en la fila.
- void imprimirFila(): imprime la fila de espera en orden cronológico de atención.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio06;

import java.util.NoSuchElementException;

public class ColaBanco {
    private Nodo head;
    private Nodo tail;
    private int size;

    public ColaBanco() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Encola un cliente al final de la fila en O(1).
     */
    public void agregarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        Nodo nuevo = new Nodo(cliente);
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
     * Atiende y retira al cliente al frente de la fila en O(1).
     */
    public Cliente atenderProximo() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: No hay clientes esperando en la fila.");
        }
        Cliente atendido = head.getCliente();
        head = head.getSiguiente();
        size--;

        if (head == null) {
            tail = null;
        }

        return atendido;
    }

    /**
     * Retorna el cliente al frente de la fila sin retirarlo en O(1).
     */
    public Cliente consultarSiguiente() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: No hay clientes esperando en la fila.");
        }
        return head.getCliente();
    }

    /**
     * Retorna la cantidad de clientes en espera.
     */
    public int getClientesEnEspera() {
        return size;
    }

    /**
     * Verifica si la fila está vacía.
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Imprime la lista de clientes en espera en orden de llegada.
     */
    public void imprimirFila() {
        if (estaVacia()) {
            System.out.println("Fila vacía: No hay clientes en espera.");
            return;
        }
        System.out.println("--- Fila del Banco (Próximo a atender al inicio) ---");
        Nodo actual = head;
        int posicion = 1;
        while (actual != null) {
            System.out.printf("  %d. %s\n", posicion, actual.getCliente());
            actual = actual.getSiguiente();
            posicion++;
        }
        System.out.println("----------------------------------------------------");
    }
}

