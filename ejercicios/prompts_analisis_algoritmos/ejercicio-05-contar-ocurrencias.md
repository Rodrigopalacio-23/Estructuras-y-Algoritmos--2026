# Ejercicio 5 – Contar ocurrencias

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que cuente cuántas veces aparece un determinado valor dentro de un vector.
El prompt debe justificar por qué el algoritmo necesita recorrer completamente el vector y solicitar el análisis de su complejidad.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java un algoritmo que cuente de manera precisa cuántas veces (frecuencia de ocurrencia) aparece un valor objetivo específico dentro de un vector de enteros (int[]).

### Estrategia Elegida y Justificación
- Estrategia: Recorrido Lineal Exhaustivo (Full Linear Scan / Reduction). Se inicializa un contador acumulador en 0 y se itera secuencialmente a lo largo de cada una de las posiciones del arreglo desde el índice 0 hasta $n-1$. Cada vez que el valor en la posición actual coincide con el elemento buscado (`vector[i] == objetivo`), se incrementa el contador en 1.
- Justificación de por qué el algoritmo necesita recorrer completamente el vector:
  * A diferencia de una búsqueda de existencia simple (donde es posible aplicar una detención temprana o "short-circuit" en la primera coincidencia encontrada), un conteo de frecuencia acumulada es una operación de agregación global.
  * Mientras exista al menos un elemento no inspeccionado en el arreglo, existe la posibilidad de que dicho elemento sea una ocurrencia adicional del valor buscado.
  * Por lo tanto, no se puede descartar ninguna posición sin examinarla: omitir un solo elemento invalidaría la exactitud del resultado final. La completitud del recorrido es una necesidad matemática y lógica ineludible.

### Complejidad Esperada
- Complejidad Temporal:
  - Mejor Caso, Peor Caso y Caso Promedio: O(n) tiempo estricto (invariante $\Theta(n)$). El número de iteraciones y comparaciones es exactamente igual al tamaño del arreglo $n$, independientemente de si el valor aparece 0 veces, 1 vez o $n$ veces.
- Complejidad Espacial:
  - O(1) memoria adicional auxiliar, ya que solo se almacena una variable entera para el contador acumulador y el índice de iteración.

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `ContadorOcurrencias`).
- Método principal: `public static int contarOcurrencias(int[] vector, int objetivo)`.
- Manejo de casos borde: Validar vector nulo (retornando 0 o lanzando excepción controlada) y vector de longitud cero (retorna 0).
- Buenas prácticas: Nombres claros y autoexplicativos, código idiomático y comentarios pedagógicos que resalten por qué es indispensable el recorrido exhaustivo.

### Requisitos Específicos del Ejercicio
1. Explicar y justificar formalmente en la introducción y en los comentarios del código por qué es obligatoria la inspección completa (sin corte temprano) de todas las posiciones del vector.
2. Realizar el análisis formal de complejidad temporal y espacial en todos los escenarios (mejor, peor y promedio).
3. Incluir un método `main` con casos de prueba ejecutables variados:
   - Valor que aparece múltiples veces distribuidas por el vector.
   - Valor que no aparece ninguna vez (frecuencia 0).
   - Arreglo donde todos los elementos coinciden con el valor buscado (frecuencia = $n$).
   - Arreglo con un único elemento (coincidente y no coincidente).
   - Arreglo vacío.
4. Imprimir por consola el arreglo analizado, el valor buscado, la cantidad de ocurrencias halladas y el total de posiciones inspeccionadas.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Justificación conceptual de la necesidad de recorrer íntegramente el vector frente a búsquedas con interrupción prematura.
2. Análisis formal de complejidad temporal ($\Theta(n)$) y espacial ($O(1)$).
3. Código Java modular, limpio y comentado con clase `Main` y casos de prueba.
4. Salida por consola de la ejecución de las pruebas.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Justificación de por qué es indispensable recorrer completamente el vector explicada antes del código y requerida en comentarios.
- [x] Análisis de complejidad temporal $\Theta(n)$ y espacial $O(1)$ solicitado explícitamente.
- [x] Requisitos del código Java especificados (clase con `main`, modularidad, comentarios y validaciones).
- [x] Casos de prueba exhaustivos con ocurrencias nulas, múltiples, completas y vectores vacíos.
- [x] Formato de salida estructurado y ordenado.

