package pilas_colas_enlazadas.ejercicio02;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 2: COLA ENLAZADA DE ENTEROS");
        System.out.println("==================================================\n");

        ColaEnlazada cola = new ColaEnlazada();
        System.out.printf("¿Cola recién creada está vacía? %b | Tamaño: %d\n", cola.estaVacia(), cola.getSize());
        cola.imprimir();

        System.out.println("\n--- 1. Prueba de casos límite en cola vacía ---");
        try {
            cola.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al hacer dequeue() en vacía: " + e.getMessage());
        }

        try {
            cola.peek();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al hacer peek() en vacía: " + e.getMessage());
        }

        System.out.println("\n--- 2. Operaciones enqueue (100, 200, 300, 400) ---");
        cola.enqueue(100);
        cola.enqueue(200);
        cola.enqueue(300);
        cola.enqueue(400);
        cola.imprimir();
        System.out.printf("Tamaño actual: %d | ¿Está vacía? %b\n", cola.getSize(), cola.estaVacia());
        System.out.printf("Elemento al frente (peek): %d\n", cola.peek());

        System.out.println("\n--- 3. Operaciones dequeue (comportamiento FIFO) ---");
        System.out.printf("Desencolado (dequeue): %d\n", cola.dequeue());
        cola.imprimir();
        System.out.printf("Nuevo frente (peek): %d\n", cola.peek());

        System.out.printf("Desencolado (dequeue): %d\n", cola.dequeue());
        cola.imprimir();

        System.out.println("\n--- 4. Vaciar la cola y verificar caso crítico de tail ---");
        System.out.printf("Desencolado: %d (quedan %d)\n", cola.dequeue(), cola.getSize());
        System.out.printf("Desencolado último elemento: %d (quedan %d)\n", cola.dequeue(), cola.getSize());
        cola.imprimir();
        System.out.printf("¿Cola vacía? %b\n", cola.estaVacia());

        System.out.println("\n--- 5. Reinserción tras vaciado (comprobación de integridad de tail) ---");
        cola.enqueue(500);
        cola.enqueue(600);
        cola.imprimir();
        System.out.printf("Frente: %d | Tamaño: %d\n", cola.peek(), cola.getSize());

        System.out.println("\nPruebas de Ejercicio 2 completadas con éxito.");
    }
}

