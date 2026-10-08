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

