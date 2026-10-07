# Ejercicio 7 – Invertir un vector

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de dos versiones distintas para invertir un vector.
Una versión deberá utilizar un vector auxiliar y la otra deberá invertir el mismo vector sin utilizar memoria adicional significativa.
El prompt deberá solicitar una comparación entre ambas soluciones indicando ventajas, desventajas y complejidad temporal y espacial.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java dos algoritmos distintos para invertir el orden de los elementos de un vector de enteros (int[]):
1. Versión 1: Inversión no destructiva mediante un vector auxiliar (`out-of-place`).
2. Versión 2: Inversión destructiva in situ sin memoria adicional significativa (`in-place` con técnica de dos punteros).
Además, debes presentar una comparación exhaustiva entre ambas alternativas analizando sus ventajas, desventajas y complejidades computacionales.

### Estrategias Elegidas y Justificación
1. Versión 1 (Vector Auxiliar / Out-of-place):
   - Estrategia: Se reserva un nuevo arreglo `int[] auxiliar = new int[vector.length]`. Se recorre el vector original copiando el elemento de la posición `i` hacia la posición `n - 1 - i` del nuevo vector. Se retorna el arreglo auxiliar, dejando el vector de entrada inmutable.
   - Justificación: Es conceptualmente intuitiva y respeta el principio de inmutabilidad funcional, evitando efectos secundarios no deseados sobre la colección original.
2. Versión 2 (In-place con Dos Punteros / Swapping):
   - Estrategia: Se definen dos índices: `izq = 0` y `der = n - 1`. En un bucle mientras `izq < der`, se intercambian (`swap`) los valores en `vector[izq]` y `vector[der]` usando una variable temporal auxiliar elemental, y se avanza `izq++` y retrocede `der--`.
   - Justificación: Optimiza al máximo el uso de hardware y memoria al no requerir asignaciones en el heap de nuevos arreglos, realizando exactamente $\lfloor n/2 \rfloor$ intercambios sobre el mismo bloque de memoria.

### Complejidad Esperada y Comparación
- Versión 1 (Con Vector Auxiliar):
  - Complejidad Temporal: O(n) tiempo (recorre los $n$ elementos exactamente una vez).
  - Complejidad Espacial: O(n) memoria auxiliar (crea un nuevo arreglo de tamaño $n$ en memoria heap).
  - Ventajas: Preserva los datos originales (no muta el vector original), ideal para arquitectura funcional o concurrente.
  - Desventajas: Doble consumo de memoria; costo de recolección de basura (GC) y asignación en heap.
- Versión 2 (In-place sin Memoria Adicional):
  - Complejidad Temporal: O(n) tiempo (específicamente $n/2$ iteraciones e intercambios).
  - Complejidad Espacial: O(1) memoria auxiliar (solo variables primitivas temporales de intercambio).
  - Ventajas: Huella de memoria mínima O(1), óptimo para grandes volúmenes de datos y sistemas embebidos.
  - Desventajas: Es mutativa (modifica directamente el arreglo original), lo que puede causar efectos secundarios si otros módulos dependen de la instancia previa.

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `InversorVector`).
- Métodos obligatorios:
  1. `public static int[] invertirConAuxiliar(int[] vector)` -> Retorna nuevo arreglo invertido.
  2. `public static void invertirInSitu(int[] vector)` -> Modifica el arreglo recibido in-place.
- Funcionalidad de soporte: Método utilitario para imprimir o clonar arreglos antes de mutar.
- Manejo de casos borde: Vectores nulos, arreglos vacíos (`length == 0`), arreglos de longitud impar y par, arreglos de 1 solo elemento.
- Buenas prácticas: Nombres claros, comentarios educativos que contrasten la técnica de punteros contra la copia en memoria.

### Requisitos Específicos del Ejercicio
1. Implementar la Versión 1 usando estrictamente un vector auxiliar nuevo.
2. Implementar la Versión 2 invirtiendo el arreglo en el mismo espacio (in-place) sin memoria adicional significativa ($O(1)$).
3. Elaborar una comparación estructurada que liste explícitamente:
   - Ventajas y desventajas de cada enfoque.
   - Complejidad temporal y espacial formal.
   - Casos de uso recomendados en la industria para cada técnica.
4. Incluir un método `main` con casos de prueba ejecutables:
   - Vector con número impar de elementos (ej: `{1, 2, 3, 4, 5}`).
   - Vector con número par de elementos (ej: `{10, 20, 30, 40}`).
   - Vector con un único elemento (ej: `{42}`).
   - Vector vacío (ej: `{}`).
5. Imprimir por consola el estado antes y después de cada método para comprobar visualmente la correcta inversión y la mutación / no mutación del vector.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Explicación conceptual de ambas estrategias y justificación del patrón de dos punteros.
2. Cuadro comparativo formal detallando ventajas, desventajas, complejidad temporal y complejidad espacial.
3. Código Java completo, modular y documentado con la clase `Main` y ambos métodos.
4. Salida por consola generada por los casos de prueba ejecutados en `main`.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Versión 1 con vector auxiliar solicitada y descrita.
- [x] Versión 2 in-place sin memoria adicional significativa solicitada y explicada con técnica de dos punteros.
- [x] Comparación explícita de ventajas, desventajas, complejidad temporal y espacial requerida.
- [x] Requisitos del código Java especificados (clase `Main`, ambos métodos, manejo de bordes).
- [x] Casos de prueba con arreglos de longitud par, impar y unitaria en `main`.
- [x] Formato de salida ordenado y estructurado.

