/*
Quiero implementar en Java un programa que demuestre experimental y visualmente el problema del desperdicio de espacio de memoria (falso desbordamiento o "False Overflow") en una Cola Simple lineal basada en un arreglo de tamaño fijo.

### Estructura y Arreglo Interno
La clase DesperdicioColaSimple debe gestionar un arreglo Integer[] datos (usando null para representar celdas vacías), junto con índices 'front' y 'rear'.

### Razonamiento: El Problema del Desperdicio de Posiciones en Cola Simple
En una cola lineal simple:
1. Al encolar (enqueue), el puntero 'rear' avanza hacia la derecha (rear++).
2. Al desencolar (dequeue), el puntero 'front' avanza hacia la derecha (front++), liberando los primeros casilleros del arreglo.
3. El problema del falso desbordamiento:
   Cuando 'rear' llega al final físico del arreglo (rear == capacidad - 1), la condición de cola llena se activa. Aunque se hayan desencolado varios elementos y las posiciones iniciales (0, 1, 2...) estén completamente libres y vacías, una cola simple NO puede reutilizarlas porque 'rear' no puede retroceder.
4. Consecuencia: La cola reporta estar "llena" y rechaza nuevas inserciones a pesar de tener espacio físico disponible en memoria. Esta ineficiencia es la motivación teórica directa que justifica la creación de la Cola Circular.

### Requisitos Específicos del Enunciado
- El método main debe imprimir el estado visual detallado del arreglo interno después de cada tanda de operaciones enqueue y dequeue.
- Mostrar explícitamente las posiciones que quedan libres al inicio y cómo quedan inutilizables.
- Provocar el intento de inserción que falla por falso desbordamiento a pesar de haber celdas vacías.

### Casos de Prueba en Main
1. Tanda 1 (Llenado inicial): Crear cola de capacidad 5. Encolar [10, 20, 30, 40, 50]. Imprimir arreglo.
2. Tanda 2 (Vaciado parcial): Desencolar 3 elementos (10, 20, 30). Imprimir arreglo mostrando posiciones [0, 1, 2] libres al inicio con null.
3. Tanda 3 (Falso desbordamiento): Intentar encolar el elemento 60. Demostrar que el algoritmo reporta "Cola llena" (porque rear == 4), aunque hay 3 casilleros libres al inicio.
*/

package pilas_y_colas.ejercicio09;

import java.util.Arrays;

public class DesperdicioColaSimple {
    private final Integer[] datos;
    private int front;
    private int rear;
    private final int capacidad;
    private int elementosActuales;

    public DesperdicioColaSimple(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        this.capacidad = capacidad;
        this.datos = new Integer[capacidad];
        this.front = 0;
        this.rear = -1;
        this.elementosActuales = 0;
    }

    public void enqueue(int elemento) {
        // En una cola simple lineal, la condición de lleno es rear == capacidad - 1
        if (rear == capacidad - 1) {
            throw new IllegalStateException(String.format(
                    "¡FALSO DESBORDAMIENTO! No se puede encolar %d porque rear=%d llegó al final del arreglo, " +
                    "a pesar de que hay %d espacios libres al inicio.",
                    elemento, rear, (capacidad - elementosActuales)));
        }
        datos[++rear] = elemento;
        elementosActuales++;
        System.out.printf("enqueue(%d) -> rear en pos %d | Elementos activos: %d\n", elemento, rear, elementosActuales);
    }

    public int dequeue() {
        if (elementosActuales == 0 || front > rear) {
            throw new IllegalStateException("Error: Cola vacía. No se puede desencolar.");
        }
        int valor = datos[front];
        datos[front] = null; // Se limpia la celda para visualizar el espacio liberado
        front++;
        elementosActuales--;
        System.out.printf("dequeue() = %d -> front avanzó a pos %d | Elementos activos: %d\n", valor, front, elementosActuales);
        return valor;
    }

    public void imprimirVisualizacion(String descripcionEtapa) {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + descripcionEtapa);
        System.out.println("-------------------------------------------------------------");
        System.out.print("Celdas físicas del arreglo: [");
        for (int i = 0; i < capacidad; i++) {
            String contenido = (datos[i] == null) ? " LIBRE " : String.format(" %4d ", datos[i]);
            System.out.print(contenido + (i < capacidad - 1 ? "|" : ""));
        }
        System.out.println("]");

        System.out.print("Índices del arreglo:        [");
        for (int i = 0; i < capacidad; i++) {
            System.out.printf("   %d   %s", i, (i < capacidad - 1 ? "|" : ""));
        }
        System.out.println("]");

        System.out.printf("Punteros actuales: front = %d, rear = %d\n", front, rear);
        System.out.printf("Espacios libres al inicio (inutilizables): %d\n", front);
        System.out.printf("Elementos activos en la cola: %d / %d\n", elementosActuales, capacidad);
    }

    public static void main(String[] args) {
        System.out.println("=====================================================================");
        System.out.println(" EJERCICIO 9: PROBLEMA DE DESPERDICIO DE ESPACIO EN COLA SIMPLE");
        System.out.println("=====================================================================");

        DesperdicioColaSimple cola = new DesperdicioColaSimple(5);

        // TANDA 1: Llenado inicial completo
        System.out.println("\n>>> TANDA 1: Encolando 5 elementos hasta ocupar todo el arreglo (10, 20, 30, 40, 50)...");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);
        cola.enqueue(50);
        cola.imprimirVisualizacion("ESTADO TRAS TANDA 1 (Arreglo lleno)");

        // TANDA 2: Vaciado parcial de los primeros 3 elementos
        System.out.println("\n>>> TANDA 2: Desencolando los 3 primeros elementos...");
        cola.dequeue();
        cola.dequeue();
        cola.dequeue();
        cola.imprimirVisualizacion("ESTADO TRAS TANDA 2 (Espacios liberados al inicio)");

        // TANDA 3: Demostración del Falso Desbordamiento
        System.out.println("\n>>> TANDA 3: Intentando encolar un nuevo elemento (60)...");
        try {
            cola.enqueue(60);
        } catch (IllegalStateException e) {
            System.out.println("\n[DEMOSTRACIÓN DEL PROBLEMA]");
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\n--- Conclusión pedagógica del Ejercicio 9 ---");
        System.out.println("Las posiciones 0, 1 y 2 están vacías en memoria RAM, pero el puntero 'rear'");
        System.out.println("quedó bloqueado en el índice 4. La cola simple no puede 'dar la vuelta'.");
        System.out.println("Para resolver esta ineficiencia se requiere implementar una Cola Circular.");

        System.out.println("\nPrueba de Ejercicio 9 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

