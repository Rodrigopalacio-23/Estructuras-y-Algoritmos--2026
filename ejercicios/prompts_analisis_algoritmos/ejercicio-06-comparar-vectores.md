# Ejercicio 6 – Comparar dos vectores

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que determine si dos vectores son iguales.
El prompt debe indicar que el algoritmo finalice apenas detecte una diferencia y solicitar el análisis del mejor caso, peor caso y caso promedio.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java un algoritmo eficiente para determinar si dos vectores de enteros (`int[] a`, `int[] b`) son idénticos (mismo tamaño y mismos elementos en el mismo orden posicional), aplicando una estrategia de evaluación con cortocircuito (detención temprana o "fail-fast") tan pronto como se detecte la primera discrepancia.

### Estrategia Elegida y Justificación
- Estrategia: Comparación posicional con cortocircuito (Short-circuit Positional Equality).
  1. Comprobación de referencias e identidades: Si `a == b`, son el mismo objeto en memoria y son iguales de inmediato.
  2. Comprobación de nulidad: Si uno de los dos arreglos es nulo y el otro no, no son iguales.
  3. Comprobación de longitud: Si `a.length != b.length`, finaliza retornando `false` en tiempo O(1) sin inspeccionar ningún contenido.
  4. Recorrido secuencial sincronizado: Se recorren ambos arreglos paralelamente con un solo índice `i` desde 0 hasta $n-1$. En el instante exacto en que `a[i] != b[i]`, el algoritmo corta la ejecución inmediatamente y retorna `false`. Si el bucle concluye sin discrepancias, retorna `true`.
- Justificación: Esta estrategia minimiza las operaciones innecesarias, aprovechando la propiedad de la igualdad lógica donde una sola diferencia contradice la condición global de igualdad.

### Complejidad Esperada
Solicita el análisis detallado de los tres casos:
- Mejor Caso (Best Case): O(1) tiempo.
  * Ocurre si las longitudes difieren (`a.length != b.length`) o si los primeros elementos difieren (`a[0] != b[0]`). Se realiza 1 sola comparación elemental y el algoritmo finaliza de inmediato.
- Peor Caso (Worst Case): O(n) tiempo (donde $n = a.length = b.length$).
  * Ocurre cuando ambos vectores son exactamente idénticos (se deben comparar los $n$ pares de elementos) o cuando la única discrepancia se encuentra en la última posición ($n-1$).
- Caso Promedio (Average Case): O(k) tiempo, donde $k \le n$ es la posición esperada de la primera discrepancia. En arreglos aleatorios independientes suele terminar rápidamente en tiempo O(1), pero formalmente se modela acotado por O(n).
- Complejidad Espacial: O(1) memoria adicional auxiliar, ya que solo se emplean punteros de iteración y comparaciones directas en memoria sin estructuras auxiliares.

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `ComparadorVectores`).
- Estructura de resultado: Opcionalmente retornar un objeto/registro `ResultadoComparacion(boolean sonIguales, int comparacionesRealizadas, String motivo)` para fines didácticos, además de un método booleano directo `public static boolean sonIguales(int[] a, int[] b)`.
- Manejo de casos borde: Vectores con la misma referencia (`a == b`), vectores nulos, vectores vacíos, vectores de longitudes desiguales.
- Buenas prácticas: Nombres claros, comentarios educativos que destaquen la optimización por cortocircuito.

### Requisitos Específicos del Ejercicio
1. El algoritmo debe finalizar obligatoriamente apenas detecte una diferencia (por longitud o por discrepancia de elemento), sin continuar evaluando las posiciones restantes.
2. Solicitar el análisis explícito y fundamentado de Mejor Caso, Peor Caso y Caso Promedio.
3. Informar la cantidad de comparaciones realizadas en cada prueba para evidenciar el efecto del cortocircuito.
4. Incluir un método `main` con casos de prueba ejecutables:
   - Vectores de distinta longitud (falla inmediata O(1)).
   - Vectores con diferencia en el primer elemento (índice 0, 1 comparación).
   - Vectores con diferencia en un elemento intermedio.
   - Vectores con diferencia únicamente en el último elemento (peor caso con discrepancia).
   - Vectores idénticos (peor caso completo, $n$ comparaciones).
   - Vectores vacíos de tamaño 0.
5. Imprimir en consola los vectores comparados, si son iguales, el número de comparaciones ejecutadas y el motivo del resultado.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Explicación de la estrategia de cortocircuito y justificación de optimización.
2. Análisis formal de complejidades: Mejor caso, Peor caso y Caso promedio, junto con la complejidad espacial.
3. Código Java completo, modular y documentado con la clase `Main` y casos de prueba.
4. Salida por consola generada por los casos de prueba, mostrando el corte temprano y las comparaciones realizadas.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Condición de finalización inmediata apenas detecte una diferencia (cortocircuito) exigida y explicada.
- [x] Análisis explícito del mejor caso, peor caso y caso promedio solicitado y detallado en la complejidad.
- [x] Complejidad temporal y espacial formalmente especificadas.
- [x] Requisitos de código Java detallados (clase con `main`, validaciones de nulos/longitudes, comentarios).
- [x] Casos de prueba que demuestran corte inmediato al inicio, corte intermedio y peor caso idéntico.
- [x] Formato de salida ordenado y estructurado.

