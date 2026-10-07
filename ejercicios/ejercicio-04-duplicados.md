# Ejercicio 4 – Detectar elementos duplicados

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de dos soluciones diferentes para detectar elementos duplicados dentro de un vector.
El prompt debe indicar que una solución utilice dos ciclos anidados y que la otra utilice una estructura HashSet, solicitando además una comparación entre ambas implementaciones desde el punto de vista de la complejidad temporal y espacial.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java dos soluciones algorítmicas diferentes para verificar si un vector de números enteros (int[]) contiene al menos un elemento duplicado (o identificar los elementos repetidos), y presentar una rigurosa comparación técnica entre ambas soluciones basada en eficiencia temporal y espacial.

### Estrategias Elegidas y Justificación
Se deben implementar y contrastar dos enfoques fundamentales:
1. Solución por Fuerza Bruta (Ciclos Anidados):
   - Estrategia: Utiliza dos bucles `for` anidados. El bucle externo recorre cada elemento en el índice `i` desde 0 hasta $n-2$, y el bucle interno recorre desde $j = i+1$ hasta $n-1$, comparando si `vector[i] == vector[j]`. En la primera coincidencia, retorna `true`.
   - Justificación: No requiere memoria adicional auxiliar y es conceptualmente elemental, pero resulta prohibitiva para arreglos grandes debido a su naturaleza cuadrática.
2. Solución con Estructura de Datos Hashing (HashSet):
   - Estrategia: Utiliza una tabla hash mediante `java.util.HashSet<Integer>`. Se recorre el vector secuencialmente y para cada elemento se invoca `conjunto.add(elemento)`. Si el método retorna `false` (o `conjunto.contains(elemento)` es `true`), se ha detectado inmediatamente un duplicado y se retorna `true`.
   - Justificación: Sacrifica memoria adicional a cambio de acceso y verificación en tiempo amortizado constante $O(1)$, logrando una aceleración computacional drástica de $O(n^2)$ a $O(n)$.

### Complejidad Esperada y Comparación
- Solución 1 (Ciclos Anidados):
  - Complejidad Temporal:
    * Mejor caso: O(1) tiempo (si los dos primeros elementos son idénticos).
    * Peor caso y caso promedio: O(n²) tiempo (requiere comparar hasta $n(n-1)/2$ pares si no hay duplicados o si están al final).
  - Complejidad Espacial: O(1) memoria adicional auxiliar (in-place).
- Solución 2 (HashSet):
  - Complejidad Temporal:
    * Mejor caso: O(1) tiempo (duplicado al inicio).
    * Peor caso y caso promedio: O(n) tiempo amortizado (un solo recorrido lineal con operaciones de tabla hash $O(1)$ en promedio).
  - Complejidad Espacial: O(n) memoria auxiliar en el peor caso para almacenar hasta $n$ elementos únicos en la tabla hash.
- Cuadro Comparativo: Explicar el clásico trade-off "Tiempo vs. Memoria" (Time-Memory Trade-off).

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `DetectorDuplicados`).
- Métodos obligatorios:
  1. `public static boolean contieneDuplicadosCiclos(int[] vector)`
  2. `public static boolean contieneDuplicadosHashSet(int[] vector)`
- Medición/Contador de operaciones: Para la solución con ciclos, contabilizar el número de comparaciones realizadas; para la solución con HashSet, contabilizar inserciones/búsquedas.
- Buenas prácticas: Manejo de casos nulos o de tamaño 0/1 (que nunca tienen duplicados), código limpio, modular y adecuadamente comentado.

### Requisitos Específicos del Ejercicio
1. Implementar la solución 1 estrictamente con dos ciclos anidados.
2. Implementar la solución 2 estrictamente utilizando la estructura `java.util.HashSet`.
3. Desarrollar una comparación detallada entre ambas alternativas considerando complejidad temporal, complejidad espacial, legibilidad y escenarios donde una es preferible sobre la otra (por ejemplo, sistemas embebidos con memoria restringida vs. procesamiento masivo de datos).
4. Incluir un método `main` con casos de prueba demostrativos ejecutables:
   - Arreglo con duplicados adyacentes al inicio.
   - Arreglo con duplicados en los extremos (primer y último elemento).
   - Arreglo sin ningún duplicado (peor caso para ambos algoritmos).
   - Arreglo con todos los elementos idénticos.
   - Arreglo vacío o de un solo elemento.
5. Imprimir los resultados de ambos métodos para cada caso, asegurando que ambos arrojen resultados idénticos y contrastando las operaciones ejecutadas.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Explicación conceptual de ambas estrategias y trade-off tiempo vs. espacio.
2. Tabla comparativa formal de complejidades temporal (mejor, peor, promedio) y espacial.
3. Código Java completo, limpio y documentado con la clase `Main` y ambos métodos.
4. Salida por consola de la ejecución de los casos de prueba.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Solución con dos ciclos anidados requerida y explicada.
- [x] Solución con HashSet requerida y explicada.
- [x] Comparación formal de complejidad temporal y espacial entre ambas implementaciones solicitada explícitamente.
- [x] Análisis del compromiso tiempo vs. memoria (Time-Memory Trade-off) incluido.
- [x] Requisitos de código Java especificados (ambos métodos en la clase `Main`, tipado, validaciones, comentarios).
- [x] Casos de prueba exhaustivos con y sin duplicados.
- [x] Formato de salida ordenado y estructurado.

