package practico_ordenamiento.ejercicio01;

import java.util.Arrays;

/**
 * Ejercicio 1: Ordenamiento Burbuja paso a paso.
 * 
 * Objetivo:
 * Explicar y mostrar cómo el elemento de mayor valor se desplaza paulatinamente
 * hacia el final del arreglo tras cada pasada.
 */
public class Ejercicio01Burbuja {

    /**
     * Ordena el arreglo utilizando Bubble Sort e imprime el estado tras cada pasada.
     *
     * @param array arreglo de enteros a ordenar
     */
    public static void bubbleSortPasoAPaso(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int n = array.length;
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(array));

        // Bucle externo: controla la cantidad de pasadas (hasta n - 1 pasadas)
        for (int i = 0; i < n - 1; i++) {
            boolean huboIntercambio = false;

            // Bucle interno: compara elementos vecinos adyacentes.
            // Cota j < n - 1 - i:
            // En cada pasada i, el i-ésimo elemento más grande ya "burbujeó"
            // y se consolidó en su posición definitiva al final del arreglo.
            for (int j = 0; j < n - 1 - i; j++) {
                // Si el elemento actual es mayor que su vecino derecho, se intercambian
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    huboIntercambio = true;
                }
            }

            // Muestra del estado del arreglo al concluir la pasada actual
            System.out.printf("Pasada %d: %s  -> Elemento asegurado al final: %d\n",
                    (i + 1), Arrays.toString(array), array[n - 1 - i]);

            // Optimización: si no hubo intercambios, el arreglo ya está ordenado
            if (!huboIntercambio) {
                System.out.println("   [Aviso] No hubo intercambios en esta pasada: el arreglo ya está ordenado.");
                break;
            }
        }
    }

    /**
     * Función de verificación de orden ascendente.
     */
    public static boolean estaOrdenado(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 1: BUBBLE SORT PASO A PASO");
        System.out.println("==================================================\n");

        int[] numeros = {64, 34, 25, 12, 22, 11, 90};

        bubbleSortPasoAPaso(numeros);

        System.out.printf("\nArreglo final: %s\n", Arrays.toString(numeros));
        boolean verificado = estaOrdenado(numeros);
        System.out.printf("¿Verificación de orden correcto? %b\n", verificado);
    }
}

/*
Prompt inicial utilizado:
# Ejercicio 1: Ordenamiento Burbuja paso a paso

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ordene un arreglo de números enteros en orden ascendente utilizando el algoritmo de Ordenamiento Burbuja (Bubble Sort).

### Algoritmo y Razonamiento
El algoritmo a utilizar es Bubble Sort. Su principio de funcionamiento consiste en recorrer repetidamente el arreglo comparando pares de elementos adyacentes (vecinos: arreglo[j] y arreglo[j + 1]). Si el elemento de la izquierda es estrictamente mayor que el de la derecha, se intercambian sus posiciones (swap). Este proceso se repite en sucesivas pasadas.

### Objetivo Conceptual: ¿Por qué el mayor se desplaza hacia el final?
En cada pasada, cada vez que nos encontramos con el elemento más grande del subarreglo no ordenado, ese elemento "gana" todas las comparaciones contra sus vecinos sucesivos. Por lo tanto, es intercambiado continuamente hacia la derecha hasta llegar al final de la zona no ordenada, análogo a una "burbuja" de aire que asciende a la superficie en un líquido. Tras la pasada 1, el mayor elemento absoluto del arreglo queda garantizado en la última posición (índice n - 1). En la pasada 2, el segundo mayor queda en n - 2, y así sucesivamente. Por esta razón, el bucle interno puede acotarse a j < n - 1 - i, ya que los últimos i elementos ya están en su posición definitiva.

### Datos que Recibe el Programa
El programa recibe un arreglo de números enteros desordenados, por ejemplo:
int[] numeros = {64, 34, 25, 12, 22, 11, 90};

### Qué Debe Mostrar por Pantalla
1. El arreglo original antes de comenzar.
2. El estado del arreglo inmediatamente después de finalizar cada pasada (indicando el número de pasada y qué elemento quedó asegurado al final).
3. El arreglo final completamente ordenado.
4. Total de pasadas realizadas y verificación de ordenamiento.

### Comentarios Requeridos en el Código
- Explicación de los bucles anidados (externo para las pasadas, interno para las comparaciones de adyacentes).
- Justificación en comentarios del porqué el mayor "burbujea" al extremo derecho.
- Explicación del límite optimizado j < n - 1 - i.

### Cómo Verificar que el Resultado es Correcto
Se debe incluir una función auxiliar booleana estaOrdenado(int[] array) que recorra el arreglo verificando que para todo índice k se cumpla array[k] <= array[k + 1]. Si se cumple, imprimir confirmación en consola.
```

## Ajustes al prompt
Sin ajustes.
*/
