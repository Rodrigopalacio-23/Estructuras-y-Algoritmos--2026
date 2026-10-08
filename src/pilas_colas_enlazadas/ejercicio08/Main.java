package pilas_colas_enlazadas.ejercicio08;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 8: INVERTIR PALABRA (PILA)");
        System.out.println("==================================================\n");

        String[][] pruebas = {
            {"algoritmo", "omtirogla"},
            {"radar", "radar"},
            {"Java", "avaJ"},
            {"A", "A"},
            {"", ""},
            {"estructuras de datos", "sotad ed sarutcurtse"}
        };

        boolean todasExitosas = true;

        for (int i = 0; i < pruebas.length; i++) {
            String original = pruebas[i][0];
            String esperado = pruebas[i][1];
            String resultado = InvertirPalabra.invertir(original);
            boolean correcta = resultado.equals(esperado);
            if (!correcta) todasExitosas = false;

            System.out.printf("Test #%d:\n", (i + 1));
            System.out.printf("  Original : \"%s\"\n", original);
            System.out.printf("  Invertido: \"%s\"\n", resultado);
            System.out.printf("  Esperado : \"%s\" | ¿Correcto?: %b\n\n", esperado, correcta);
        }

        if (todasExitosas) {
            System.out.println("Todas las pruebas de inversión de palabras pasaron exitosamente.");
        } else {
            System.out.println("Hubo discrepancias en las pruebas de inversión.");
        }
    }
}

