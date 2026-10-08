package pilas_colas_enlazadas.ejercicio07;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 7: PARÉNTESIS BALANCEADOS (PILA)");
        System.out.println("==================================================\n");

        String[] expresionesPrueba = {
            "(2 + 3) * (5 - 1)",        // Balanceado normal -> esperado: true
            "((a + b) * c)",            // Balanceado anidado -> esperado: true
            "(2 + 3",                   // Falta cierre -> esperado: false
            "())(",                     // Cierre prematuro -> esperado: false
            "a + b * c",                // Sin paréntesis -> esperado: true
            "",                         // Cadena vacía -> esperado: true
            "(((1 + 2)))",              // Múltiple anidamiento -> esperado: true
            ")("                        // Cierre antes de apertura -> esperado: false
        };

        boolean[] esperados = {
            true,
            true,
            false,
            false,
            true,
            true,
            true,
            false
        };

        boolean todasExitosas = true;

        for (int i = 0; i < expresionesPrueba.length; i++) {
            String expr = expresionesPrueba[i];
            boolean resultado = ParentesisBalanceados.verificar(expr);
            boolean coincide = (resultado == esperados[i]);
            if (!coincide) todasExitosas = false;

            System.out.printf("Test #%d: \"%s\"\n", (i + 1), expr);
            System.out.printf("  Resultado: %b | Esperado: %b | ¿Correcto?: %b\n\n",
                    resultado, esperados[i], coincide);
        }

        if (todasExitosas) {
            System.out.println("Todas las pruebas de validación de paréntesis pasaron exitosamente.");
        } else {
            System.out.println("Hubo fallos en las pruebas de validación.");
        }
    }
}

