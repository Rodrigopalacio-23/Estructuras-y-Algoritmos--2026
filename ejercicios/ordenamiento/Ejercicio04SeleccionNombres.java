package ordenamiento;

import java.util.Arrays;

/**
 * Ejercicio 4: Ordenamiento de nombres con Selection Sort.
 * 
 * Objetivo:
 * Razonar cómo cambia la comparación al ordenar textos (String) frente a números primitivos,
 * utilizando el método compareTo() de Comparable en lugar de operadores relacionales (<, >).
 */
public class Ejercicio04SeleccionNombres {

    /**
     * Ordena un arreglo de nombres lexicográficamente usando Selection Sort.
     *
     * @param nombres arreglo de cadenas de texto
     */
    public static void selectionSortNombres(String[] nombres) {
        if (nombres == null || nombres.length <= 1) {
            return;
        }

        int n = nombres.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < n; j++) {
                // Para cadenas de texto no se puede usar '<'.
                // compareTo retorna:
                // < 0 si nombres[j] es alfabéticamente menor que nombres[minIdx]
                // = 0 si son iguales
                // > 0 si nombres[j] es alfabéticamente mayor
                if (nombres[j].compareTo(nombres[minIdx]) < 0) {
                    minIdx = j;
                }
            }

            // Intercambio si se halló un nombre alfabéticamente anterior
            if (minIdx != i) {
                String temp = nombres[i];
                nombres[i] = nombres[minIdx];
                nombres[minIdx] = temp;
                System.out.printf("Pasada %d: Se seleccionó \"%s\" y se intercambió con \"%s\" -> %s\n",
                        (i + 1), nombres[i], temp, Arrays.toString(nombres));
            } else {
                System.out.printf("Pasada %d: \"%s\" ya estaba en la posición correcta -> %s\n",
                        (i + 1), nombres[i], Arrays.toString(nombres));
            }
        }
    }

    public static boolean estaOrdenadoAlfabeticamente(String[] nombres) {
        for (int i = 0; i < nombres.length - 1; i++) {
            if (nombres[i].compareTo(nombres[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 4: SELECTION SORT CON NOMBRES (STRING)");
        System.out.println("==================================================\n");

        String[] nombres = {"Lucia", "Ana", "Pedro", "Juan"};
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(nombres));

        selectionSortNombres(nombres);

        System.out.printf("\nArreglo ordenado: %s\n", Arrays.toString(nombres));
        boolean verificado = estaOrdenadoAlfabeticamente(nombres);
        System.out.printf("¿Verificación de orden alfabético correcto? %b\n", verificado);
    }
}

