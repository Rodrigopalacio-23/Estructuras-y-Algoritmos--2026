/*
Quiero implementar en Java una estructura de Cola Circular (ColaCircular) utilizando exclusivamente un arreglo de tamaño fijo.

### Estructura y Arreglo Interno
La clase debe gestionar un arreglo Integer[] datos (para visualizar celdas ocupadas o libres con null), punteros 'front' y 'rear', un contador explícito 'cantidadElementos' y la capacidad total.

### Razonamiento: Operador Módulo (%) y Detección de Llena / Vacía
1. Uso del operador módulo (%):
   Para evitar el problema de falso desbordamiento visto en la cola simple, cuando un índice alcanza el final físico del arreglo (capacidad - 1), debe "dar la vuelta" y retornar al índice 0. La aritmética modular resuelve esto de forma compacta y elegante:
   - Al encolar: rear = (rear + 1) % capacidad.
   - Al desencolar: front = (front + 1) % capacidad.
   Esto convierte conceptualmente el arreglo lineal en un anillo cerrado (anillo de memoria o ring buffer).
2. Detección de Cola Llena y Vacía mediante Contador de Elementos:
   En una cola circular pura donde front y rear son punteros, la condición front == rear es ambigua (puede significar que la cola está completamente vacía o completamente llena).
   Para eliminar cualquier ambigüedad de manera limpia:
   - Se mantiene una variable 'cantidadElementos' que se incrementa en enqueue (++cantidadElementos) y se decrementa en dequeue (--cantidadElementos).
   - Cola Vacía: cantidadElementos == 0.
   - Cola Llena: cantidadElementos == capacidad.

### Operaciones Requeridas
- void enqueue(int elemento): Inserta reutilizando posiciones liberadas con (rear + 1) % capacidad.
- int dequeue(): Retira el elemento en front y avanza (front + 1) % capacidad.
- int front(): Consulta el elemento del frente sin modificar punteros.
- boolean isEmpty(), boolean isFull(), int size().

### Demostración en el Método Main
Crear una cola circular de capacidad 5.
1. Llenar con 5 elementos [10, 20, 30, 40, 50]. Mostrar arreglo.
2. Desencolar 2 elementos (10, 20), liberando los índices 0 y 1. Mostrar front = 2.
3. Encolar 2 nuevos elementos (60 y 70). Demostrar que rear pasa de 4 a 0 y luego a 1 gracias a (rear + 1) % 5, ocupando exitosamente los casilleros liberados al inicio.
4. Forzar desbordamiento intentando encolar un elemento más con la cola llena (capturando la excepción).
5. Desencolar todos los elementos verificando el orden FIFO en todo momento.

*/

package pilas_y_colas.ejercicio10;

import java.util.Arrays;

public class ColaCircular {
    private final Integer[] datos;
    private int front;
    private int rear;
    private int cantidadElementos;
    private final int capacidad;

    public ColaCircular(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
        }
        this.capacidad = capacidad;
        this.datos = new Integer[capacidad];
        this.front = 0;
        this.rear = -1;
        this.cantidadElementos = 0;
    }

    public void enqueue(int elemento) {
        if (isFull()) {
            throw new IllegalStateException("Error: Cola circular llena. No se puede encolar: " + elemento);
        }
        // Avance circular con operador módulo
        rear = (rear + 1) % capacidad;
        datos[rear] = elemento;
        cantidadElementos++;
        System.out.printf("enqueue(%d) -> rear avanzó circularmente a pos %d | elementos: %d/%d\n",
                elemento, rear, cantidadElementos, capacidad);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: Cola circular vacía. No se puede desencolar.");
        }
        int valor = datos[front];
        datos[front] = null; // Limpiar para visualización
        // Avance circular con operador módulo
        front = (front + 1) % capacidad;
        cantidadElementos--;
        System.out.printf("dequeue() = %d -> front avanzó circularmente a pos %d | elementos: %d/%d\n",
                valor, front, cantidadElementos, capacidad);
        return valor;
    }

    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Error: Cola circular vacía.");
        }
        return datos[front];
    }

    public boolean isEmpty() {
        return cantidadElementos == 0;
    }

    public boolean isFull() {
        return cantidadElementos == capacidad;
    }

    public int size() {
        return cantidadElementos;
    }

    public void imprimirEstado(String titulo) {
        System.out.println("\n-------------------------------------------------------------");
        System.out.println(" " + titulo);
        System.out.println("-------------------------------------------------------------");
        System.out.print("Arreglo físico en memoria: [");
        for (int i = 0; i < capacidad; i++) {
            String contenido = (datos[i] == null) ? " LIBRE " : String.format(" %4d ", datos[i]);
            System.out.print(contenido + (i < capacidad - 1 ? "|" : ""));
        }
        System.out.println("]");

        System.out.printf("Punteros: front = %d, rear = %d | Cantidad de elementos: %d/%d\n",
                front, rear, cantidadElementos, capacidad);
        System.out.printf("¿Está vacía? %b | ¿Está llena? %b\n", isEmpty(), isFull());
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 10: COLA CIRCULAR (RING BUFFER)");
        System.out.println("==================================================\n");

        ColaCircular cola = new ColaCircular(5);
        cola.imprimirEstado("ESTADO INICIAL (Vacía)");

        // 1. Llenar la cola inicialmente
        System.out.println("\n--- 1. Llenando la cola con 5 elementos (10, 20, 30, 40, 50) ---");
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);
        cola.enqueue(50);
        cola.imprimirEstado("ESTADO TRAS LLENADO INICIAL");

        // 2. Desencolar 2 elementos, dejando libres los índices 0 y 1
        System.out.println("\n--- 2. Desencolando 2 elementos (libera índices 0 y 1) ---");
        cola.dequeue();
        cola.dequeue();
        cola.imprimirEstado("ESTADO TRAS DESENCOLAR (Índices 0 y 1 ahora están libres)");

        // 3. Encolar 2 nuevos elementos demostrando la REUTILIZACIÓN con módulo (%)
        System.out.println("\n--- 3. Encolando 60 y 70 (Demostración de reutilización circular) ---");
        cola.enqueue(60); // Debe ingresar en el índice (4 + 1) % 5 = 0
        cola.enqueue(70); // Debe ingresar en el índice (0 + 1) % 5 = 1
        cola.imprimirEstado("ESTADO TRAS REUTILIZACIÓN CIRCULAR (rear volvió al inicio)");

        // 4. Caso límite: Enqueue en cola llena
        System.out.println("\n--- 4. Intento de encolar en cola circular llena ---");
        try {
            cola.enqueue(80);
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        // 5. Desencolar todos los elementos en orden FIFO
        System.out.println("\n--- 5. Desencolando todos los elementos restantes (Orden FIFO) ---");
        while (!cola.isEmpty()) {
            cola.dequeue();
        }
        cola.imprimirEstado("ESTADO FINAL (Completamente vacía tras vaciado circular)");

        // 6. Caso límite: Dequeue en cola vacía
        System.out.println("\n--- 6. Intento de desencolar en cola vacía ---");
        try {
            cola.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\nPrueba de Ejercicio 10 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

