package pilas_colas_enlazadas.ejercicio06;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 6: COLA DE BANCO (ATENCIÓN FIFO)");
        System.out.println("==================================================\n");

        ColaBanco banco = new ColaBanco();
        System.out.printf("¿Fila vacía? %b | En espera: %d\n", banco.estaVacia(), banco.getClientesEnEspera());

        System.out.println("\n--- 1. Llegada de clientes a la fila ---");
        banco.agregarCliente(new Cliente("Roberto Flores", 101, "Apertura de cuenta"));
        banco.agregarCliente(new Cliente("María González", 102, "Cobro de jubilación"));
        banco.agregarCliente(new Cliente("Esteban Quispe", 103, "Solicitud de crédito"));
        banco.agregarCliente(new Cliente("Valeria Morales", 104, "Consulta de inversiones"));

        banco.imprimirFila();
        System.out.println("Próximo en ser llamado: " + banco.consultarSiguiente());

        System.out.println("\n--- 2. Atención en ventanilla (FIFO) ---");
        System.out.println("Atendiendo a: " + banco.atenderProximo());
        System.out.println("Nuevo siguiente: " + banco.consultarSiguiente());
        System.out.println("Atendiendo a: " + banco.atenderProximo());

        banco.imprimirFila();
        System.out.printf("Clientes restantes en espera: %d\n", banco.getClientesEnEspera());

        System.out.println("\n--- 3. Llegada de un nuevo cliente y atención total ---");
        banco.agregarCliente(new Cliente("Carlos Tevez", 105, "Depósito judicial"));
        banco.imprimirFila();

        while (!banco.estaVacia()) {
            System.out.println("Atendiendo a: " + banco.atenderProximo());
        }

        banco.imprimirFila();
        System.out.printf("¿Fila vacía tras el día? %b\n", banco.estaVacia());

        System.out.println("\n--- 4. Casos límite (atender con fila vacía) ---");
        try {
            banco.atenderProximo();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al atender en fila vacía: " + e.getMessage());
        }

        try {
            banco.consultarSiguiente();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al consultar siguiente en fila vacía: " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 6 completadas con éxito.");
    }
}

