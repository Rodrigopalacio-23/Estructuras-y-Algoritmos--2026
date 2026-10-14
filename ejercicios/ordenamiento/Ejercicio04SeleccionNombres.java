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

/*
Prompt inicial utilizado:
# Ejercicio 4: Ordenamiento de nombres con Selection Sort

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ordene un arreglo de nombres (String[]) en orden alfabético ascendente utilizando el algoritmo Selection Sort.

### Algoritmo y Razonamiento
El algoritmo a utilizar es Selection Sort adaptado para objetos String. En cada iteración i desde 0 hasta n - 2, se asume que nombres[i] es el mínimo de la sección no ordenada. Se recorren los índices j desde i + 1 hasta n - 1 buscando lexicográficamente el nombre menor. Al terminar la pasada, se realiza a lo sumo un intercambio entre nombres[i] y nombres[minIdx].

### Objetivo Conceptual: ¿Cómo cambia la comparación entre textos y números?
- Con números primitivos (int, double), se utilizan directamente operadores relacionales (<, >, <=, >=) a nivel de procesador ALU.
- Con cadenas de caracteres (String), no se pueden usar operadores aritméticos como < o >. Es obligatorio utilizar el método lexicográfico compareTo() o compareToIgnoreCase() de la interfaz Comparable<String>:
  * cadenaA.compareTo(cadenaB) < 0 indica que cadenaA precede alfabéticamente a cadenaB.
  * cadenaA.compareTo(cadenaB) == 0 indica igualdad de cadenas.
  * cadenaA.compareTo(cadenaB) > 0 indica que cadenaA es posterior en el abecedario.
La comparación de cadenas compara carácter a carácter según sus valores numéricos Unicode/ASCII hasta hallar la primera diferencia o agotar la longitud de la cadena más corta.

### Datos que Recibe el Programa
El arreglo del enunciado:
String[] nombres = {"Lucia", "Ana", "Pedro", "Juan"};

### Qué Debe Mostrar por Pantalla
1. El arreglo de nombres original.
2. El detalle de cada pasada de Selection Sort (indicando qué nombre mínimo fue seleccionado y con quién se intercambió).
3. El arreglo final ordenado alfabéticamente.
4. Verificación formal de que la lista resultante se encuentra ordenada.

### Comentarios Requeridos en el Código
- Explicación del uso de nombres[j].compareTo(nombres[minIdx]) < 0 en lugar de operadores primitivos.
- Justificación del orden lexicográfico ASCII/Unicode.

### Cómo Verificar que el Resultado es Correcto
Utilizar una función booleana estaOrdenadoAlfabeticamente(String[] array) que valide que array[k].compareTo(array[k + 1]) <= 0 para todo k.
```

## Ajustes al prompt
Sin ajustes.
*/
