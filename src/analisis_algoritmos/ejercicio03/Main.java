package analisis_algoritmos.ejercicio03;

import java.util.Arrays;

/**
 * Ejercicio 3: Búsqueda binaria en un vector ordenado con trazado paso a paso.
 * 
 * ¿Por qué es más eficiente que la búsqueda lineal?
 * - Búsqueda lineal: Cada comparación descarta solo 1 elemento (espacio n -> n - 1), requiriendo hasta n pasos.
 * - Búsqueda binaria: Cada comparación descarta la mitad de los elementos restantes (espacio n -> n / 2).
 *   Esto reduce el espacio de búsqueda exponencialmente, logrando una complejidad O(log n).
 * 
 * Complejidad:
 * - Mejor Caso: O(1) tiempo (elemento ubicado en el punto medio de la primera iteración).
 * - Peor y Caso Promedio: O(log n) tiempo.
 * - Complejidad Espacial: O(1) memoria auxiliar (implementación iterativa).
 */
public class Main {

    /**
     * Realiza la búsqueda binaria de un elemento en un arreglo ordenado, mostrando
     * el paso a paso de las variables de control en cada iteración.
     *
     * @param vector   arreglo ordenado ascendentemente
     * @param objetivo valor entero a buscar
     * @param trazar   indica si se deben imprimir los pasos intermedios por consola
     * @return índice del elemento si existe, o -1 si no fue encontrado
     */
    public static int busquedaBinariaConTrazado(int[] vector, int objetivo, boolean trazar) {
        if (vector == null || vector.length == 0) {
            if (trazar) System.out.println("   [Aviso] Vector nulo o vacío.");
            return -1;
        }

        int inicio = 0;
        int fin = vector.length - 1;
        int paso = 1;

        if (trazar) {
            System.out.printf("   Iniciando búsqueda binaria de objetivo: %d en vector de %d elementos\n", objetivo, vector.length);
            System.out.println("   +------+--------+-----+-------+---------------+--------------------+");
            System.out.println("   | Paso | Inicio | Fin | Medio | vector[Medio] | Acción             |");
            System.out.println("   +------+--------+-----+-------+---------------+--------------------+");
        }

        while (inicio <= fin) {
            // Prevención de desbordamiento aritmético de enteros (overflow safe)
            int medio = inicio + (fin - inicio) / 2;
            int valorMedio = vector[medio];

            if (valorMedio == objetivo) {
                if (trazar) {
                    System.out.printf("   | %-4d | %-6d | %-3d | %-5d | %-13d | ¡ENCONTRADO!       |\n",
                            paso, inicio, fin, medio, valorMedio);
                    System.out.println("   +------+--------+-----+-------+---------------+--------------------+");
                }
                return medio;
            } else if (valorMedio < objetivo) {
                if (trazar) {
                    System.out.printf("   | %-4d | %-6d | %-3d | %-5d | %-13d | Descartar izq (->) |\n",
                            paso, inicio, fin, medio, valorMedio);
                }
                inicio = medio + 1;
            } else {
                if (trazar) {
                    System.out.printf("   | %-4d | %-6d | %-3d | %-5d | %-13d | Descartar der (<-) |\n",
                            paso, inicio, fin, medio, valorMedio);
                }
                fin = medio - 1;
            }
            paso++;
        }

        if (trazar) {
            System.out.printf("   | %-4d | %-6d | %-3d |   -   |       -       | Fin (No existe)    |\n",
                    paso, inicio, fin);
            System.out.println("   +------+--------+-----+-------+---------------+--------------------+");
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 3: BÚSQUEDA BINARIA CON TRAZADO");
        System.out.println("==================================================\n");

        int[] ordenado = {3, 7, 12, 19, 25, 31, 44, 58, 62, 77, 85, 93, 100};
        System.out.printf("Vector ordenado base: %s (n = %d)\n\n", Arrays.toString(ordenado), ordenado.length);

        // Caso 1: Mejor Caso (Elemento exactamente en el centro inicial)
        int objetivoCentro = ordenado[ordenado.length / 2]; // 44
        System.out.printf("1. MEJOR CASO (Elemento central: %d):\n", objetivoCentro);
        int idx1 = busquedaBinariaConTrazado(ordenado, objetivoCentro, true);
        System.out.printf("   Resultado: Índice %d\n\n", idx1);

        // Caso 2: Extremo inicial
        int objetivoInicio = 3;
        System.out.printf("2. ELEMENTO AL INICIO (%d):\n", objetivoInicio);
        int idx2 = busquedaBinariaConTrazado(ordenado, objetivoInicio, true);
        System.out.printf("   Resultado: Índice %d\n\n", idx2);

        // Caso 3: Extremo final
        int objetivoFin = 100;
        System.out.printf("3. ELEMENTO AL FINAL (%d):\n", objetivoFin);
        int idx3 = busquedaBinariaConTrazado(ordenado, objetivoFin, true);
        System.out.printf("   Resultado: Índice %d\n\n", idx3);

        // Caso 4: Inexistente menor que el mínimo
        int objetivoMenor = 1;
        System.out.printf("4. INEXISTENTE MENOR QUE EL MÍNIMO (%d):\n", objetivoMenor);
        int idx4 = busquedaBinariaConTrazado(ordenado, objetivoMenor, true);
        System.out.printf("   Resultado: %s\n\n", idx4 == -1 ? "No encontrado (-1)" : "Índice " + idx4);

        // Caso 5: Inexistente intermedio
        int objetivoIntermedio = 50;
        System.out.printf("5. INEXISTENTE INTERMEDIO (%d):\n", objetivoIntermedio);
        int idx5 = busquedaBinariaConTrazado(ordenado, objetivoIntermedio, true);
        System.out.printf("   Resultado: %s\n\n", idx5 == -1 ? "No encontrado (-1)" : "Índice " + idx5);

        System.out.println("Verificación de Ejercicio 3 completada con éxito.");
    }
}

