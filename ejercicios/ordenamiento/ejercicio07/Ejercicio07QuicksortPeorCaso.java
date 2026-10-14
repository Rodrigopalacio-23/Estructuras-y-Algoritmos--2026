package ordenamiento.ejercicio07;

import java.util.Arrays;

/**
 * Ejercicio 7: Peor caso de Quicksort.
 * 
 * Objetivo:
 * Explicar por qué elegir siempre el primer elemento como pivote genera un mal rendimiento (O(n^2))
 * cuando el arreglo ya está ordenado, contabilizando el número de llamadas recursivas y particiones desbalanceadas.
 */
public class Ejercicio07QuicksortPeorCaso {

    private static int contadorLlamadas = 0;
    private static int contadorComparaciones = 0;

    public static void quicksortPeorCaso(int[] array) {
        contadorLlamadas = 0;
        contadorComparaciones = 0;
        if (array == null || array.length <= 1) {
            return;
        }

        System.out.printf("Arreglo inicial ya ordenado: %s (n = %d)\n\n",
                Arrays.toString(array), array.length);

        quicksortRecursivo(array, 0, array.length - 1);
    }

    private static void quicksortRecursivo(int[] array, int inicio, int fin) {
        contadorLlamadas++;

        // Caso base
        if (inicio >= fin) {
            return;
        }

        int tamanoActual = fin - inicio + 1;
        int pivote = array[inicio];

        // Partición con pivote = array[inicio]
        int indiceParticion = particionar(array, inicio, fin);

        int tamIzq = indiceParticion - inicio;
        int tamDer = fin - indiceParticion;

        System.out.printf("Llamada #%-2d | Rango [%d..%d] (tam=%d) -> Pivote: %d en pos %d | SubIzq tam: %d | SubDer tam: %d\n",
                contadorLlamadas, inicio, fin, tamanoActual, pivote, indiceParticion, tamIzq, tamDer);

        // Llamadas recursivas desbalanceadas (uno de los lados tiene tamaño 0)
        quicksortRecursivo(array, inicio, indiceParticion - 1);
        quicksortRecursivo(array, indiceParticion + 1, fin);
    }

    private static int particionar(int[] array, int inicio, int fin) {
        int pivote = array[inicio];
        int i = inicio + 1;

        for (int j = inicio + 1; j <= fin; j++) {
            contadorComparaciones++;
            if (array[j] < pivote) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        int pos = i - 1;
        array[inicio] = array[pos];
        array[pos] = pivote;
        return pos;
    }

    public static boolean estaOrdenado(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 7: PEOR CASO DE QUICKSORT");
        System.out.println("==================================================\n");

        int[] numeros = {1, 2, 3, 4, 5, 6, 7};

        quicksortPeorCaso(numeros);

        System.out.println("\n--- MÉTRICAS Y ANÁLISIS ---");
        System.out.printf("Arreglo final:                %s\n", Arrays.toString(numeros));
        System.out.printf("Total llamadas recursivas:    %d\n", contadorLlamadas);
        System.out.printf("Total comparaciones en part.: %d\n", contadorComparaciones);
        System.out.printf("¿Verificación orden correcto? %b\n\n", estaOrdenado(numeros));

        System.out.println("Explicación del mal rendimiento:");
        System.out.println("Al estar ya ordenado, el primer elemento siempre es el menor.");
        System.out.println("El subarreglo izquierdo siempre queda vacío (tam = 0) y el derecho");
        System.out.println("contiene todos los demás (tam = n - 1). La recursión se vuelve lineal");
        System.out.println("en lugar de árbol binario balanceado, degenerando a O(n^2).");
    }
}

/*
Prompt inicial utilizado:
# Ejercicio 7: Peor caso de Quicksort

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ejecute Quicksort (con el primer elemento como pivote) sobre un arreglo que ya se encuentra ordenado, contabilizando exactamente la cantidad de llamadas recursivas y de comparaciones realizadas.

### Algoritmo y Razonamiento
Se utiliza la implementación de Quicksort con el primer elemento como pivote sobre un arreglo de entrada ya ordenado en orden ascendente.

### Objetivo Conceptual: ¿Por qué elegir siempre el primer elemento como pivote genera el peor caso en datos ordenados?
1. Desbalance extremo en la partición: En un caso óptimo o promedio, el pivote divide el arreglo aproximadamente a la mitad (subarreglos de tamaño n/2 y n/2), generando un árbol de recursión de altura balanceada O(log n) y tiempo O(n log n).
2. Sin embargo, si el arreglo ya está ordenado y se elige el primer elemento como pivote, dicho pivote es el menor elemento absoluto de todo el rango.
   - En consecuencia, el subarreglo izquierdo queda completamente vacío (tamaño 0).
   - El subarreglo derecho contiene todos los restantes elementos (tamaño n - 1).
3. Degradación cuadrática: La reducción del problema no es exponencial sino lineal (de n a n - 1 en cada nivel). La profundidad del árbol de recursión alcanza n niveles, requiriendo n llamadas recursivas y sumando n + (n - 1) + ... + 1 = n(n + 1)/2 comparaciones.
4. Por ende, la complejidad temporal se degrada a su peor caso O(n^2), y además existe riesgo de desbordamiento de pila (StackOverflowError) en arreglos grandes.

### Datos que Recibe el Programa
El arreglo del enunciado:
int[] numeros = {1, 2, 3, 4, 5, 6, 7};

### Qué Debe Mostrar por Pantalla
1. El arreglo inicial (ya ordenado).
2. El registro de cada partición (mostrando el desbalance: subarreglo izquierdo vacío de tamaño 0 y subarreglo derecho de tamaño n - 1).
3. Total de llamadas recursivas realizadas.
4. Total de comparaciones ejecutadas.
5. Explicación del contraste entre el caso promedio O(n log n) y la degradación O(n^2).
6. Verificación de que el arreglo sigue ordenado.

### Comentarios Requeridos en el Código
- Comentarios explicando el contador de llamadas recursivas.
- Comentarios resaltando el desbalance de las particiones (0 vs k - 1).

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenado(int[] array).
```

## Ajustes al prompt
Sin ajustes.
*/
