package pilas_colas_enlazadas.ejercicio03;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 3: PILA ENLAZADA GENÉRICA Pila<T>");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Prueba con tipo Integer ---");
        Pila<Integer> pilaEnteros = new Pila<>();
        pilaEnteros.push(10);
        pilaEnteros.push(20);
        pilaEnteros.push(30);
        pilaEnteros.imprimir();
        System.out.printf("Tope Integer: %d | Desapilado: %d\n", pilaEnteros.peek(), pilaEnteros.pop());
        pilaEnteros.imprimir();

        System.out.println("\n--- 2. Prueba con tipo String ---");
        Pila<String> pilaStrings = new Pila<>();
        pilaStrings.push("primero");
        pilaStrings.push("segundo");
        pilaStrings.push("tercero");
        pilaStrings.imprimir();
        System.out.printf("Tope String: %s | Desapilado: %s\n", pilaStrings.peek(), pilaStrings.pop());
        pilaStrings.imprimir();

        System.out.println("\n--- 3. Prueba con clase personalizada (Tarea) ---");
        Pila<Tarea> pilaTareas = new Pila<>();
        pilaTareas.push(new Tarea(1, "Configurar entorno", 1));
        pilaTareas.push(new Tarea(2, "Implementar algoritmo", 3));
        pilaTareas.push(new Tarea(3, "Escribir pruebas unitarias", 2));
        pilaTareas.imprimir();
        System.out.println("Tope Tarea: " + pilaTareas.peek());
        System.out.println("Desapilado: " + pilaTareas.pop());
        pilaTareas.imprimir();

        System.out.println("\n--- 4. Casos límite en pila genérica vacía ---");
        Pila<Double> pilaVacia = new Pila<>();
        try {
            pilaVacia.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al hacer pop() en vacía: " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 3 completadas con éxito.");
    }
}

