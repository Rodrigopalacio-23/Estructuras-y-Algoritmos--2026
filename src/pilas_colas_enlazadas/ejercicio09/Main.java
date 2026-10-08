package pilas_colas_enlazadas.ejercicio09;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 9: COLA DE IMPRESIÓN (FIFO)");
        System.out.println("==================================================\n");

        ColaImpresion spooler = new ColaImpresion();
        System.out.printf("¿Spooler vacío? %b | Trabajos: %d\n", spooler.estaVacia(), spooler.getCantidadTrabajos());

        System.out.println("\n--- 1. Envío de trabajos de impresión ---");
        spooler.agregarTrabajo(new TrabajoImpresion("tesis_final.pdf", 85, "estudiante1"));
        spooler.agregarTrabajo(new TrabajoImpresion("balance_anual.xlsx", 12, "contabilidad"));
        spooler.agregarTrabajo(new TrabajoImpresion("contrato_firmado.pdf", 4, "legales"));
        spooler.agregarTrabajo(new TrabajoImpresion("presentacion.pptx", 25, "marketing"));

        spooler.mostrarPendientes();
        System.out.println("Próximo trabajo a imprimir: " + spooler.consultarProximo());

        System.out.println("\n--- 2. Procesamiento de impresiones (FIFO) ---");
        System.out.println("Imprimiendo: " + spooler.imprimirProximo());
        System.out.println("Nuevo próximo: " + spooler.consultarProximo());
        System.out.println("Imprimiendo: " + spooler.imprimirProximo());

        spooler.mostrarPendientes();

        System.out.println("\n--- 3. Llegada de nuevo trabajo e impresión completa ---");
        spooler.agregarTrabajo(new TrabajoImpresion("manual_usuario.pdf", 40, "soporte"));
        spooler.mostrarPendientes();

        while (!spooler.estaVacia()) {
            System.out.println("Imprimiendo: " + spooler.imprimirProximo());
        }

        spooler.mostrarPendientes();
        System.out.printf("¿Spooler vacío al finalizar? %b\n", spooler.estaVacia());

        System.out.println("\n--- 4. Casos límite (imprimir con cola vacía) ---");
        try {
            spooler.imprimirProximo();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al imprimir en cola vacía: " + e.getMessage());
        }

        try {
            spooler.consultarProximo();
        } catch (NoSuchElementException e) {
            System.out.println("Captura esperada al consultar próximo en cola vacía: " + e.getMessage());
        }

        System.out.println("\nPruebas de Ejercicio 9 completadas con éxito.");
    }
}

