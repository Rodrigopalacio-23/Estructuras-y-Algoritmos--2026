/*
Quiero implementar en Java una estructura de datos de Cola simple de enteros (ColaEnteros) utilizando un arreglo estático de tamaño fijo.

### Estructura y Arreglo Interno
La clase debe gestionar un arreglo primitivo int[] datos, variables para los índices 'front' (frente) y 'rear' (final/cola), un contador 'tamano' y la capacidad máxima.

### Razonamiento: Índices 'front' y 'rear' y su evolución
- Finalidad de front: Apunta al elemento más antiguo de la cola, es decir, el que está en la cabecera listo para ser atendido/retirado.
- Finalidad de rear: Apunta a la última posición ocupada al final de la cola, por donde ingresan los nuevos elementos.
- Cómo cambian al agregar (enqueue): Se incrementa rear en 1 (++rear), se asigna el valor en datos[rear], y se incrementa el contador de tamaño.
- Cómo cambian al retirar (dequeue): Se obtiene el valor en datos[front], se incrementa front en 1 (front++), y se decrementa el contador de tamaño.
- Consulta del frente (front): Retorna datos[front] sin modificar los índices.

### Operaciones Requeridas
- void enqueue(int elemento): Inserta al final de la cola.
- int dequeue(): Retira y devuelve el elemento del frente de la cola.
- int front(): Consulta el elemento del frente sin retirarlo.
- boolean isEmpty(): Retorna true si tamano == 0.
- boolean isFull(): Retorna true si rear == capacidad - 1 (o tamano == capacidad).
- int size(): Retorna tamano.

### Casos Límite y Manejo de Errores
- Cola llena: enqueue() lanza IllegalStateException("Error: La cola está llena (desbordamiento).").
- Cola vacía: dequeue() y front() lanzan IllegalStateException("Error: La cola está vacía (subdesbordamiento).").

### Casos de Prueba en Main
Crear una cola de capacidad 3. Verificar isEmpty(), encolar 3 números (10, 20, 30), verificar isFull(), consultar front(), intentar encolar en cola llena capturando la excepción, desencolar elementos observando el orden FIFO, e intentar desencolar en cola vacía.
*/

package pilas_y_colas.ejercicio06;

import java.util.Arrays;

public class ColaEnteros {
    private final int[] datos;
    private int front;
    private int rear;
    private int tamano;
    private final int capacidad;

    public ColaEnteros(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.front = 0;
        this.rear = -1;
        this.tamano = 0;
    }

    public void enqueue(int elemento) {
        if (isFull()) {
            throw new IllegalStateException("Error: La cola está llena (desbordamiento). No se puede encolar: " + elemento);
        }
        // Se incrementa rear y se coloca el elemento al final
        datos[++rear] = elemento;
        tamano++;
        System.out.printf("enqueue(%d) -> rear avanzó a %d | size = %d\n", elemento, rear, tamano);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La cola está vacía (subdesbordamiento). No se puede desencolar.");
        }
        // Se extrae del frente y front avanza hacia la derecha
        int elemento = datos[front++];
        tamano--;
        System.out.printf("dequeue() = %d -> front avanzó a %d | size = %d\n", elemento, front, tamano);
        return elemento;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: La cola está vacía. No hay elemento al frente.");
        }
        return datos[front];
    }

    public boolean isEmpty() {
        return tamano == 0;
    }

    public boolean isFull() {
        return rear == capacidad - 1;
    }

    public int size() {
        return tamano;
    }

    public void mostrarEstado() {
        System.out.printf("[Estado] Arreglo interno: %s | front = %d, rear = %d, size = %d/%d\n",
                Arrays.toString(datos), front, rear, tamano, capacidad);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 6: COLA SIMPLE DE ENTEROS (FIFO)");
        System.out.println("==================================================\n");

        ColaEnteros cola = new ColaEnteros(3);
        cola.mostrarEstado();
        System.out.printf("¿Está vacía? %b | ¿Está llena? %b\n\n", cola.isEmpty(), cola.isFull());

        System.out.println("--- 1. Encolando elementos (10, 20, 30) ---");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.mostrarEstado();
        System.out.printf("Elemento al frente (front): %d | ¿Está llena? %b\n\n", cola.front(), cola.isFull());

        System.out.println("--- 2. Caso límite: Enqueue en cola llena ---");
        try {
            cola.enqueue(40);
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("--- 3. Desencolando elementos (Orden FIFO) ---");
        cola.dequeue();
        cola.dequeue();
        cola.dequeue();
        cola.mostrarEstado();

        System.out.println("\n--- 4. Caso límite: Dequeue en cola vacía ---");
        try {
            cola.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("Prueba de Ejercicio 6 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

