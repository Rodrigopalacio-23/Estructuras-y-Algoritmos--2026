package pilas_colas_enlazadas.ejercicio01;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 1: PILA ENLAZADA DE ENTEROS");
        System.out.println("==================================================\n");

        PilaEnlazada pila = new PilaEnlazada();
        System.out.printf("¿Pila recién creada está vacía? %b | Tamaño: %d\n", pila.estaVacia(), pila.getSize());
        pila.imprimir();

        System.out.println("\n--- 1. Prueba de casos límite en pila vacía ---");
        try {
            pila.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al hacer pop() en vacía: " + e.getMessage());
        }

        try {
            pila.peek();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al hacer peek() en vacía: " + e.getMessage());
        }

        System.out.println("\n--- 2. Operaciones push (10, 20, 30, 40) ---");
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.push(40);
        pila.imprimir();
        System.out.printf("Tamaño actual: %d | ¿Está vacía? %b\n", pila.getSize(), pila.estaVacia());
        System.out.printf("Elemento en el tope (peek): %d\n", pila.peek());

        System.out.println("\n--- 3. Búsqueda de elementos (buscar) ---");
        System.out.printf("¿Existe el 30 en la pila? %b\n", pila.buscar(30));
        System.out.printf("¿Existe el 99 en la pila? %b\n", pila.buscar(99));

        System.out.println("\n--- 4. Operaciones pop (comportamiento LIFO) ---");
        System.out.printf("Desapilado (pop): %d\n", pila.pop());
        pila.imprimir();
        System.out.printf("Nuevo tope (peek): %d\n", pila.peek());

        System.out.printf("Desapilado (pop): %d\n", pila.pop());
        pila.imprimir();

        System.out.println("\n--- 5. Vaciar completamente la pila ---");
        while (!pila.estaVacia()) {
            System.out.printf("Desapilando: %d (tamaño restante: %d)\n", pila.pop(), pila.getSize());
        }
        pila.imprimir();
        System.out.printf("¿Está vacía al final? %b | Tamaño final: %d\n", pila.estaVacia(), pila.getSize());

        System.out.println("\nPruebas de Ejercicio 1 completadas con éxito.");
    }
}

