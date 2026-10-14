
import java.util.Arrays;

/**
 * Ejercicio 5: ShellSort explicando los gaps.
 * 
 * Objetivo:
 * Explicar y mostrar cómo ShellSort mejora a Insertion Sort permitiendo saltos largos
 * entre elementos separados por un intervalo (gap), eliminando inversiones a distancia.
 */
public class Ejercicio05ShellSort {

    /**
     * Ordena el arreglo usando ShellSort, imprimiendo el gap y el estado en cada etapa.
     *
     * @param array arreglo a ordenar
     */
    public static void shellSortConGaps(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(array));

        int etapa = 1;

        // Bucle exterior de reducción de gaps: comienza en n / 2 y se divide por 2 hasta gap == 1
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.printf("--- Etapa %d: gap = %d ---\n", etapa++, gap);

            // Se realiza un ordenamiento por inserción con espaciado 'gap'
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;

                // Desplaza elementos de la sublista espaciada hasta encontrar la posición de 'temp'
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }

            System.out.printf("   Estado del arreglo tras procesar gap = %d:\n   %s\n\n",
                    gap, Arrays.toString(array));
        }
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 5: SHELLSORT EXPLICANDO LOS GAPS");
        System.out.println("==================================================\n");

        int[] numeros = {35, 14, 9, 87, 45, 62, 18, 53, 29, 6};

        shellSortConGaps(numeros);

        System.out.printf("Arreglo final ordenado: %s\n", Arrays.toString(numeros));
        boolean verificado = estaOrdenado(numeros);
        System.out.printf("¿Verificación de orden correcto? %b\n\n", verificado);

        System.out.println("Explicación del beneficio de los gaps:");
        System.out.println("Al usar gaps grandes (5, 2), elementos pequeños como '6' se desplazaron");
        System.out.println("rápidamente hacia la izquierda en pocos saltos, dejando el arreglo");
        System.out.println("casi ordenado para la fase final con gap = 1.");
    }
}

/*
Prompt inicial utilizado:
# Ejercicio 5: ShellSort explicando los gaps

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ordene un arreglo de enteros utilizando el algoritmo ShellSort, mostrando detalladamente el valor del salto o intervalo (gap) en cada etapa y el estado del arreglo después de cada pasada.

### Algoritmo y Razonamiento
ShellSort es una generalización de Insertion Sort. En lugar de comparar e intercambiar únicamente elementos vecinos inmediatos (distancia = 1), ShellSort compara e intercambia elementos que se encuentran separados por una distancia h (gap). Comienza con un gap grande (comúnmente n / 2) y en cada iteración reduce el intervalo (secuencia de Shell: gap = gap / 2) hasta que gap == 1, momento en el cual realiza un Insertion Sort estándar sobre un arreglo ya "casi ordenado".

### Objetivo Conceptual: ¿Por qué ShellSort mejora a Insertion Sort mediante saltos?
El principal cuello de botella de Insertion Sort simple es que los elementos desfasados solo pueden desplazarse una posición por paso. Si el menor elemento se encuentra al final del arreglo, requiere n - 1 desplazamientos individuales.
ShellSort rompe esta limitación permitiendo que los elementos realicen "saltos largos" a través de grandes distancias en las primeras fases (cuando el gap es grande). Esto elimina rápidamente una cantidad masiva de inversiones en tiempo subcuadrático. Cuando finalmente el gap se reduce a 1, el arreglo ya está sumamente pre-ordenado, por lo que la fase final de Insertion Sort requiere poquísimos desplazamientos (complejidad cercana a O(n)). Como resultado, ShellSort reduce la complejidad temporal de O(n^2) a entre O(n^(3/2)) y O(n log^2 n).

### Datos que Recibe el Programa
Un arreglo de números enteros desordenados:
int[] numeros = {35, 14, 9, 87, 45, 62, 18, 53, 29, 6};

### Qué Debe Mostrar por Pantalla
1. El arreglo original.
2. Para cada etapa: el valor del gap actual.
3. El estado del arreglo inmediatamente después de procesar cada pasada con dicho gap.
4. El arreglo final completamente ordenado.
5. Verificación de que el arreglo quedó ordenado.

### Comentarios Requeridos en el Código
- Explicación del bucle exterior de reducción del gap (gap = gap / 2).
- Explicación del ordenamiento por inserción modificado con espaciado 'gap'.
- Justificación pedagógica del concepto de "arreglo h-ordenado".

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenado(int[] array).
```

## Ajustes al prompt
Sin ajustes.
*/
