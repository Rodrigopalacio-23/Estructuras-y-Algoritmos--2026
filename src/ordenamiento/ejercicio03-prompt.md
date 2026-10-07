# Ejercicio 3: Ordenamiento por Inserción con arreglo casi ordenado

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ordene un arreglo casi ordenado utilizando el algoritmo de Ordenamiento por Inserción (Insertion Sort), contabilizando la cantidad exacta de comparaciones y desplazamientos (shifts) realizados.

### Algoritmo y Razonamiento
El algoritmo es Insertion Sort. Funciona manteniendo una sublista ordenada a la izquierda e insertando cada nuevo elemento (clave o key) en su posición correcta dentro de dicha sublista, desplazando los elementos mayores un lugar hacia la derecha.

### Objetivo Conceptual: ¿Por qué Insertion Sort funciona tan bien con datos casi ordenados?
Cuando un arreglo está casi ordenado (o con muy pocas inversiones k << n), cada elemento nuevo ya se encuentra muy cerca de su posición definitiva. En el bucle interno while (j >= 0 && array[j] > key), la condición de parada se satisface de inmediato tras 1 sola comparación en la gran mayoría de los casos, sin requerir desplazamientos. La complejidad temporal en este escenario cae desde su peor caso O(n^2) hasta un comportamiento casi lineal O(n + k) o O(n). Algoritmos como Selection Sort no poseen esta propiedad adaptativa y seguirán ejecutando O(n^2) comparaciones independientemente de cuán ordenado esté el arreglo.

### Datos que Recibe el Programa
El arreglo propuesto por la consigna:
int[] numeros = {1, 2, 3, 5, 4, 6, 7};

### Qué Debe Mostrar por Pantalla
1. El arreglo original casi ordenado.
2. La traza de cada inserción, mostrando qué elemento requirió desplazamiento y cuántos desplazamientos se hicieron.
3. El arreglo final ordenado.
4. Las métricas totales: cantidad de comparaciones y cantidad de desplazamientos.
5. Verificación de que el arreglo quedó ordenado.

### Comentarios Requeridos en el Código
- Explicación de la variable clave 'key' y del bucle while descendente.
- Comentarios explicando el incremento de desplazamientos y comparaciones.
- Justificación teórica del caso adaptativo O(n).

### Cómo Verificar que el Resultado es Correcto
Utilizar una función de validación de orden ascendente estaOrdenado(int[] array).
```

## Ajustes al prompt
Sin ajustes.

