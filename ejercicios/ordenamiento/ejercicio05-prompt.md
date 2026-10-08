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

