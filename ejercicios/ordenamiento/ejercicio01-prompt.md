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

