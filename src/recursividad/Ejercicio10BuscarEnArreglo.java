/*
Quiero implementar en Java una función recursiva que busque un número dentro de un arreglo de enteros SIN usar ciclos (ni for ni while).

Este problema puede resolverse recursivamente porque buscar un elemento en un arreglo consiste en verificar si el elemento en la posición actual coincide con el buscado, y de no ser así, repetir exactamente la misma búsqueda en el resto del arreglo avanzando al siguiente índice.

La búsqueda empieza desde la posición inicial (índice 0). Para ello, se puede utilizar una función principal sobrecargada que reciba el arreglo y el valor a buscar, y delegue en una función auxiliar recursiva que además reciba el índice actual de búsqueda inicializado en 0.

Para avanzar en el arreglo sin usar ciclos (ni for ni mientras/while), el avance se logra mediante la llamada recursiva pasando el siguiente índice: buscarRecursivo(arreglo, objetivo, indice + 1).

Existen dos casos base:
1. Caso base cuando llega al final del arreglo sin encontrar el elemento (indice >= arreglo.length): el elemento no existe en el arreglo, por lo que la función devuelve -1 (o false) y se detiene la recursión.
2. Caso base cuando encuentra el valor (arreglo[indice] == objetivo): se ha hallado el elemento, por lo que la función devuelve inmediatamente el índice actual donde fue encontrado (o true) y se corta la recursión sin avanzar más.

El caso recursivo es buscarRecursivo(arreglo, objetivo, indice + 1), que se ejecuta cuando el índice actual es válido pero arreglo[indice] != objetivo.

La función debe devolver un número entero (int) con el índice de la posición donde se encuentra el elemento en el arreglo, o -1 si el elemento no está presente en ninguna posición.

Quiero que el código tenga comentarios explicando ambos casos base, el caso recursivo y la pila de llamadas, y que no use for ni while en ninguna parte del código (ni siquiera en el método de búsqueda ni en métodos auxiliares).

También quiero probarlo con estos casos:
- caso 1: elemento en la primera posición (índice 0)
- caso 2: elemento en posición intermedia
- caso 3: elemento en la última posición
- caso 4: elemento inexistente en el arreglo (retorna -1)
- caso 5: arreglo vacío (retorna -1)
*/

package recursividad;

import java.util.Arrays;

public class Ejercicio10BuscarEnArreglo {

    /**
     * Función pública de búsqueda que inicia la recursión desde la posición 0.
     * SIN usar for ni while.
     *
     * @param arreglo arreglo de enteros donde buscar
     * @param objetivo valor buscado
     * @return índice del elemento o -1 si no existe
     */
    public static int buscar(int[] arreglo, int objetivo) {
        if (arreglo == null || arreglo.length == 0) {
            return -1;
        }
        return buscarRecursivo(arreglo, objetivo, 0);
    }

    /**
     * Función recursiva auxiliar que recorre el arreglo índice por índice sin usar ciclos.
     * 
     * Pila de Llamadas (Call Stack):
     * Para buscar en {10, 20, 30} el objetivo 30:
     * 1. buscar(arr, 30, 0): arr[0]=10 != 30 -> apila buscar(arr, 30, 1)
     * 2. buscar(arr, 30, 1): arr[1]=20 != 30 -> apila buscar(arr, 30, 2)
     * 3. buscar(arr, 30, 2): arr[2]=30 == 30 -> CASO BASE ÉXITO: retorna índice 2.
     * Desapilado:
     * 4. buscar(arr, 30, 1) recibe 2 y lo propaga hacia arriba.
     * 5. buscar(arr, 30, 0) recibe 2 y finaliza retornando 2.
     *
     * @param arreglo  arreglo a inspeccionar
     * @param objetivo elemento buscado
     * @param indice   posición actual examinada
     * @return índice encontrado o -1 si se supera el límite del arreglo
     */
    private static int buscarRecursivo(int[] arreglo, int objetivo, int indice) {
        // CASO BASE 1: Llegada al final del arreglo sin coincidencias
        // Si el índice actual alcanza o supera la longitud, se recorrió todo el arreglo
        // y el elemento no existe. Se retorna -1 y finaliza la recursión.
        if (indice >= arreglo.length) {
            return -1;
        }

        // CASO BASE 2: Éxito en la búsqueda
        // Si el elemento en la posición actual coincide con el objetivo,
        // se retorna de inmediato el índice actual (detención temprana).
        if (arreglo[indice] == objetivo) {
            return indice;
        }

        // CASO RECURSIVO:
        // Se avanza a la siguiente posición sin usar ciclos (for/while),
        // incrementando el parámetro de posición en 1: indice + 1.
        return buscarRecursivo(arreglo, objetivo, indice + 1);
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 10: BUSCAR EN ARREGLO RECURSIVO (SIN CICLOS)");
        System.out.println("==================================================\n");

        int[] datos = {15, 28, 42, 73, 91, 105};
        System.out.printf("Arreglo base: %s\n\n", Arrays.toString(datos));

        // Caso 1: Elemento en índice 0
        probarCaso(datos, 15, "1. Elemento al inicio (índice 0)");

        // Caso 2: Elemento intermedio
        probarCaso(datos, 42, "2. Elemento en el medio");

        // Caso 3: Elemento al final
        probarCaso(datos, 105, "3. Elemento al final");

        // Caso 4: Elemento inexistente
        probarCaso(datos, 999, "4. Elemento inexistente");

        // Caso 5: Arreglo vacío
        probarCaso(new int[]{}, 10, "5. Arreglo vacío");

        System.out.println("Pruebas de Ejercicio 10 completadas con éxito (sin for ni while).");
    }

    private static void probarCaso(int[] arr, int obj, String descripcion) {
        int idx = buscar(arr, obj);
        System.out.printf("--- %s ---\n", descripcion);
        System.out.printf("   Buscar: %d -> Índice devuelto: %d (%s)\n\n",
                obj, idx, idx != -1 ? "Encontrado" : "No encontrado");
    }
}

