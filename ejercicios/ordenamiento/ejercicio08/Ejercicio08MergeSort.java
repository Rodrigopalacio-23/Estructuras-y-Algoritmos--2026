package ordenamiento.ejercicio08;

import java.util.Arrays;

/**
 * Ejercicio 8: MergeSort paso a paso.
 * 
 * Objetivo:
 * Mostrar claramente la diferencia entre la fase de división geométrica hacia la condición de corte
 * y la fase de fusión (merge) donde realmente se comparan y combinan los elementos ordenados.
 */
public class Ejercicio08MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        System.out.printf("Arreglo original: %s\n\n", Arrays.toString(array));
        mergeSortRecursivo(array, 0, array.length - 1, 1);
    }

    private static void mergeSortRecursivo(int[] array, int inicio, int fin, int nivel) {
        // CONDICIÓN DE CORTE: tamaño 1 (o 0)
        if (inicio >= fin) {
            System.out.printf("[Corte Nivel %d] Rango [%d..%d] -> Elemento único: [%d] (Ya ordenado por caso base)\n",
                    nivel, inicio, fin, array[inicio]);
            return;
        }

        int medio = inicio + (fin - inicio) / 2;

        // FASE 1: DIVISIÓN
        int[] subIzq = Arrays.copyOfRange(array, inicio, medio + 1);
        int[] subDer = Arrays.copyOfRange(array, medio + 1, fin + 1);
        System.out.printf("[División Nivel %d] Rango [%d..%d] -> Izq: %s | Der: %s\n",
                nivel, inicio, fin, Arrays.toString(subIzq), Arrays.toString(subDer));

        // Llamadas recursivas
        mergeSortRecursivo(array, inicio, medio, nivel + 1);
        mergeSortRecursivo(array, medio + 1, fin, nivel + 1);

        // FASE 2: FUSIÓN (MERGE)
        fusionar(array, inicio, medio, fin, nivel);
    }

    private static void fusionar(int[] array, int inicio, int medio, int fin, int nivel) {
        int[] izq = Arrays.copyOfRange(array, inicio, medio + 1);
        int[] der = Arrays.copyOfRange(array, medio + 1, fin + 1);

        System.out.printf("   >>> [Fusión Nivel %d] Fusionando %s con %s\n",
                nivel, Arrays.toString(izq), Arrays.toString(der));

        int i = 0, j = 0, k = inicio;

        // Intercalación ordenada de elementos de ambas mitades
        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) { // '<=' garantiza estabilidad
                array[k++] = izq[i++];
            } else {
                array[k++] = der[j++];
            }
        }

        // Copiar remanentes
        while (i < izq.length) {
            array[k++] = izq[i++];
        }
        while (j < der.length) {
            array[k++] = der[j++];
        }

        int[] fusionado = Arrays.copyOfRange(array, inicio, fin + 1);
        System.out.printf("   <<< [Resultado Fusión] Rango [%d..%d] consolidado: %s\n\n",
                inicio, fin, Arrays.toString(fusionado));
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 8: MERGESORT PASO A PASO");
        System.out.println("==================================================\n");

        int[] numeros = {38, 27, 43, 3, 9, 82, 10};

        mergeSort(numeros);

        System.out.printf("Arreglo final ordenado: %s\n", Arrays.toString(numeros));
        boolean verificado = estaOrdenado(numeros);
        System.out.printf("¿Verificación de orden correcto? %b\n", verificado);
    }
}

/*
Prompt inicial utilizado:
# Ejercicio 8: MergeSort paso a paso

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ordene un arreglo de números enteros utilizando MergeSort (Ordenamiento por Mezcla), mostrando detalladamente en consola la fase de división, las condiciones de corte y la fase de fusión (merge).

### Algoritmo y Razonamiento
MergeSort es un algoritmo recursivo basado en Divide y Vencerás que garantiza complejidad O(n log n) en todos los casos:
1. Dividir: Calcula el punto medio del subarreglo actual (medio = inicio + (fin - inicio) / 2) y se divide en dos mitades: izquierda [inicio..medio] y derecha [medio + 1..fin].
2. Vencer (Condición de corte): La división continúa recursivamente hasta llegar a subarreglos de tamaño 1 (o 0), donde inicio >= fin. Un arreglo de 1 elemento está trivialmente ordenado y constituye el caso base.
3. Fusionar (Merge): Es la etapa donde realmente se produce el ordenamiento. Se toman dos subarreglos contiguos ya ordenados y se combinan secuencialmente en un arreglo temporal auxiliar, insertando siempre el menor elemento entre ambas cabezas, para luego volcar el resultado ordenado al arreglo principal.

### Objetivo Conceptual: Diferencia entre Dividir y Fusionar
- Dividir no realiza comparaciones ni ordenamiento de datos: es simplemente una partición geométrica del espacio de índices a la mitad (costo O(1) por división, altura del árbol log n).
- Fusionar (Merge) es el núcleo activo del algoritmo: consume tiempo O(n) por nivel para comparar elementos de ambas mitades ordenadas y entrelazarlos de manera ascendente, requiriendo un espacio de memoria auxiliar O(n).

### Datos que Recibe el Programa
Un arreglo de números enteros desordenados, por ejemplo:
int[] numeros = {38, 27, 43, 3, 9, 82, 10};

### Qué Debe Mostrar por Pantalla
1. El arreglo original.
2. Cada paso de división: indicando rango [inicio..fin] y subarreglos resultantes izquierdo y derecho.
3. Cuándo se alcanza la condición de corte (subarreglo de tamaño 1).
4. Cada paso de fusión (merge): mostrando los subarreglos que se van a fusionar y el resultado fusionado resultante.
5. El arreglo final completamente ordenado.
6. Verificación formal de ordenamiento.

### Comentarios Requeridos en el Código
- Comentarios explicando el caso base (inicio >= fin).
- Comentarios detallados en el método merge(array, inicio, medio, fin).
- Justificación de la estabilidad y de la memoria auxiliar O(n).

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenado(int[] array).
```

## Ajustes al prompt
Sin ajustes.
*/
