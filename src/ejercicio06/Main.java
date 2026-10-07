package ejercicio06;

import java.util.Arrays;

/**
 * Ejercicio 6: Comparar dos vectores con corte temprano (cortocircuito).
 * 
 * Análisis de Complejidad:
 * - Mejor Caso: O(1) tiempo. Ocurre si las longitudes difieren (a.length != b.length)
 *   o si los primeros elementos son distintos (a[0] != b[0]). El algoritmo finaliza de inmediato.
 * - Peor Caso: O(n) tiempo. Ocurre cuando ambos vectores son idénticos o la única discrepancia
 *   está en el último elemento (índice n - 1), obligando a comparar todos los pares.
 * - Caso Promedio: O(k) tiempo, con k <= n, dependiendo del índice donde aparezca la primera discrepancia.
 * - Complejidad Espacial: O(1) memoria adicional auxiliar.
 */
public class Main {

    public record ResultadoComparacion(boolean sonIguales, int comparaciones, String motivo) {}

    /**
     * Compara dos vectores finalizando inmediatamente ante la primera diferencia detectada.
     */
    public static ResultadoComparacion compararVectores(int[] a, int[] b) {
        // Caso de identidad en memoria (misma referencia)
        if (a == b) {
            return new ResultadoComparacion(true, 0, "Misma referencia en memoria");
        }

        // Caso de nulidad dispar
        if (a == null || b == null) {
            return new ResultadoComparacion(false, 0, "Uno de los vectores es nulo");
        }

        // Cortocircuito por tamaño: O(1)
        if (a.length != b.length) {
            return new ResultadoComparacion(false, 0,
                    String.format("Longitudes distintas (a: %d, b: %d)", a.length, b.length));
        }

        int comparaciones = 0;
        for (int i = 0; i < a.length; i++) {
            comparaciones++;
            // Cortocircuito ante el primer elemento no coincidente
            if (a[i] != b[i]) {
                return new ResultadoComparacion(false, comparaciones,
                        String.format("Diferencia encontrada en índice %d (%d != %d)", i, a[i], b[i]));
            }
        }

        return new ResultadoComparacion(true, comparaciones, "Todos los elementos son idénticos");
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 6: COMPARAR DOS VECTORES");
        System.out.println("==================================================\n");

        int[] base = {10, 20, 30, 40, 50};

        // 1. Mejor Caso A: Longitudes distintas (0 comparaciones de contenido)
        int[] distintoTamano = {10, 20, 30};
        System.out.println("1. MEJOR CASO A (Longitud distinta):");
        imprimirPrueba(base, distintoTamano, compararVectores(base, distintoTamano));

        // 2. Mejor Caso B: Diferencia en la primera posición (1 comparación)
        int[] difInicio = {99, 20, 30, 40, 50};
        System.out.println("2. MEJOR CASO B (Diferencia en índice 0):");
        imprimirPrueba(base, difInicio, compararVectores(base, difInicio));

        // 3. Caso Promedio: Diferencia en posición intermedia
        int[] difMedio = {10, 20, 999, 40, 50};
        System.out.println("3. CASO PROMEDIO (Diferencia en índice intermedio):");
        imprimirPrueba(base, difMedio, compararVectores(base, difMedio));

        // 4. Peor Caso con diferencia: Diferencia en la última posición
        int[] difFin = {10, 20, 30, 40, 99};
        System.out.println("4. PEOR CASO CON FALLO (Diferencia en el último elemento):");
        imprimirPrueba(base, difFin, compararVectores(base, difFin));

        // 5. Peor Caso sin diferencia: Vectores idénticos (recorre todo)
        int[] identico = {10, 20, 30, 40, 50};
        System.out.println("5. PEOR CASO IDÉNTICO (Vectores completamente iguales):");
        imprimirPrueba(base, identico, compararVectores(base, identico));

        System.out.println("Verificación de Ejercicio 6 completada con éxito.");
    }

    private static void imprimirPrueba(int[] a, int[] b, ResultadoComparacion res) {
        System.out.printf("   a = %s\n", Arrays.toString(a));
        System.out.printf("   b = %s\n", Arrays.toString(b));
        System.out.printf("   -> Iguales: %b | Comparaciones: %d | Motivo: %s\n\n",
                res.sonIguales(), res.comparaciones(), res.motivo());
    }
}

