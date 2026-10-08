package pilas_colas_enlazadas.ejercicio04;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 4: COLA ENLAZADA GENÉRICA Cola<T>");
        System.out.println("==================================================\n");

        System.out.println("--- 1. Prueba con nombres (String) ---");
        Cola<String> colaNombres = new Cola<>();
        colaNombres.enqueue("Ana");
        colaNombres.enqueue("Bruno");
        colaNombres.enqueue("Carlos");
        colaNombres.imprimir();
        System.out.printf("Frente: %s | Desencolado: %s\n", colaNombres.peek(), colaNombres.dequeue());
        colaNombres.imprimir();

        System.out.println("\n--- 2. Prueba con objetos Cliente ---");
        Cola<Cliente> colaClientes = new Cola<>();
        colaClientes.enqueue(new Cliente(101, "Lucía Méndez"));
        colaClientes.enqueue(new Cliente(102, "Martín Gómez"));
        colaClientes.enqueue(new Cliente(103, "Sofía Ramos"));
        colaClientes.imprimir();
        System.out.println("Cliente al frente: " + colaClientes.peek());
        System.out.println("Atendido (dequeue): " + colaClientes.dequeue());
        colaClientes.imprimir();

        System.out.println("\n--- 3. Casos límite en cola genérica vacía ---");
        Cola<Integer> colaVacia = new Cola<>();
        try {
            colaVacia.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al hacer dequeue() en vacía: " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 4 completadas con éxito.");
    }
}

