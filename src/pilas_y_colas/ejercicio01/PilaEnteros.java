/*
Quiero implementar en Java una estructura de datos de Pila de enteros (PilaEnteros) utilizando exclusivamente un arreglo estático de tamaño fijo.

### Estructura y Arreglo Interno
La clase debe encapsular un arreglo primitivo int[] datos y una variable entera 'top' que actúa como puntero al elemento en la cima de la pila, además de almacenar la capacidad máxima.

### Razonamiento del Índice 'top'
- Valor inicial: top debe inicializarse en -1. Esto indica explícitamente que la pila está vacía, ya que los índices válidos de un arreglo en Java comienzan en 0.
- Inserción (push): Primero se incrementa top en 1 (++top) y luego se almacena el elemento en datos[top].
- Extracción (pop): Se guarda el elemento en datos[top], se decrementa top en 1 (top--) y se retorna el elemento guardado.
- Cima (peek): Retorna datos[top] sin modificar top.

### Operaciones Requeridas
- void push(int elemento): Agrega un elemento a la cima.
- int pop(): Retira y devuelve el elemento de la cima.
- int peek(): Devuelve el elemento de la cima sin retirarlo.
- boolean isEmpty(): Retorna true si top == -1.
- boolean isFull(): Retorna true si top == capacidad - 1.
- int size(): Retorna top + 1.

### Casos Límite y Manejo de Errores
- Pila llena (Stack Overflow): Si se intenta hacer push() cuando isFull() es true, debe lanzar IllegalStateException("Error: La pila está llena (desbordamiento).").
- Pila vacía (Stack Underflow): Si se intenta hacer pop() o peek() cuando isEmpty() es true, debe lanzar IllegalStateException("Error: La pila está vacía (subdesbordamiento).").

### Casos de Prueba en Main
Crear una pila de capacidad 3, verificar isEmpty(), agregar 3 elementos hasta llenarla, verificar isFull(), consultar peek(), desapilar mostrando elementos, intentar push en pila llena capturando la excepción, e intentar pop en pila vacía capturando la excepción.
*/

package pilas_y_colas.ejercicio01;

import java.util.Arrays;

public class PilaEnteros {
    private final int[] datos;
    private int top;
    private final int capacidad;

    public PilaEnteros(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
        this.datos = new int[capacidad];
        this.top = -1; // -1 indica pila vacía (sin elementos)
    }

    public void push(int elemento) {
        // Caso límite: Desbordamiento de pila
        if (isFull()) {
            throw new IllegalStateException("Error: La pila está llena (desbordamiento). No se puede insertar " + elemento);
        }
        // Incrementa top y coloca el elemento en la nueva cima
        datos[++top] = elemento;
    }

    public int pop() {
        // Caso límite: Subdesbordamiento de pila
        if (isEmpty()) {
            throw new IllegalStateException("Error: La pila está vacía (subdesbordamiento). No se puede hacer pop.");
        }
        // Retorna el elemento en la cima y decrementa top
        return datos[top--];
    }

    public int peek() {
        // Caso límite: Consulta sobre pila vacía
        if (isEmpty()) {
            throw new IllegalStateException("Error: La pila está vacía. No se puede consultar la cima.");
        }
        return datos[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacidad - 1;
    }

    public int size() {
        return top + 1;
    }

    public void imprimirEstado() {
        System.out.print("Estado de la pila (base -> cima): [");
        for (int i = 0; i <= top; i++) {
            System.out.print(datos[i] + (i < top ? ", " : ""));
        }
        System.out.printf("] | top = %d | size = %d | capacidad = %d\n", top, size(), capacidad);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 1: PILA DE ENTEROS CON ARREGLO");
        System.out.println("==================================================\n");

        PilaEnteros pila = new PilaEnteros(3);
        pila.imprimirEstado();
        System.out.printf("¿Está vacía? %b | ¿Está llena? %b\n\n", pila.isEmpty(), pila.isFull());

        System.out.println("--- 1. Apilando elementos (10, 20, 30) ---");
        pila.push(10);
        pila.imprimirEstado();
        pila.push(20);
        pila.imprimirEstado();
        pila.push(30);
        pila.imprimirEstado();

        System.out.printf("¿Está llena? %b | Elemento en cima (peek): %d\n\n", pila.isFull(), pila.peek());

        System.out.println("--- 2. Caso límite: Push en pila llena ---");
        try {
            pila.push(40);
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("--- 3. Desapilando elementos ---");
        System.out.printf("pop() -> %d\n", pila.pop());
        pila.imprimirEstado();
        System.out.printf("pop() -> %d\n", pila.pop());
        pila.imprimirEstado();
        System.out.printf("pop() -> %d\n", pila.pop());
        pila.imprimirEstado();

        System.out.println("\n--- 4. Caso límite: Pop en pila vacía ---");
        try {
            pila.pop();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("Prueba de Ejercicio 1 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

