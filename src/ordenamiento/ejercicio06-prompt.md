# Ejercicio 6: Quicksort con primer elemento como pivote

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa que ordene un arreglo de números enteros utilizando el algoritmo Quicksort, seleccionando estrictamente siempre el primer elemento del rango actual como pivote, e imprimiendo el detalle del proceso de partición en cada llamada recursiva.

### Algoritmo y Razonamiento
Quicksort es el paradigma canónico de Divide y Vencerás (Divide and Conquer):
1. Dividir: Se selecciona un elemento pivote (el primer elemento del subarreglo: array[inicio]). Se particiona el arreglo reorganizando los elementos de tal manera que todos los valores menores o iguales al pivote queden a su izquierda, y todos los mayores queden a su derecha. Al concluir la partición, el pivote queda ubicado en su posición final definitiva k.
2. Vencer: Se resuelven recursivamente los dos subarreglos generados: el subarreglo izquierdo (desde inicio hasta k - 1) y el subarreglo derecho (desde k + 1 hasta fin).
3. Combinar: No se requiere una etapa explícita de combinación, ya que las particiones e intercambios se realizan in-situ sobre el mismo arreglo original.

### Objetivo Conceptual: Relación con Recursividad y Divide y Vencerás
El objetivo es evidenciar cómo un problema global de ordenamiento de tamaño n se reduce a ordenar dos subproblemas independientes más pequeños tras fijar la posición absoluta de un elemento (el pivote). La condición de corte recursiva ocurre cuando un subarreglo tiene 0 o 1 elemento (inicio >= fin), caso en el cual ya está trivialmente ordenado.

### Datos que Recibe el Programa
Un arreglo de números enteros desordenados, por ejemplo:
int[] numeros = {54, 26, 93, 17, 77, 31, 44, 55, 20};

### Qué Debe Mostrar por Pantalla
En cada partición recursiva válida:
1. El pivote elegido (primer elemento del rango).
2. El subarreglo izquierdo resultante tras la partición (elementos menores o iguales al pivote).
3. El subarreglo derecho resultante tras la partición (elementos mayores al pivote).
4. El estado actual del arreglo en ese nivel de recursión.
Al finalizar:
5. El arreglo final completamente ordenado.
6. Verificación de que el arreglo quedó ordenado.

### Comentarios Requeridos en el Código
- Explicación del caso base recursivo (inicio >= fin).
- Detalle del algoritmo de partición (ej. esquema de Hoare o Lomuto ajustado al primer elemento).
- Comentarios de los pasos Divide y Vencerás.

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenado(int[] array).
```

## Ajustes al prompt
Sin ajustes.

