# Ejercicio 9 – Encontrar el mayor elemento de una matriz

## Enunciado
Construí un prompt para OpenCode que solicite la implementación en Java de un algoritmo que encuentre el mayor elemento de una matriz.
El prompt debe justificar por qué resulta necesario recorrer todos los elementos y solicitar el análisis de la complejidad temporal y espacial.

## Prompt para OpenCode

```text
Actúa como un Ingeniero de Software experto en Algoritmos y Estructuras de Datos en Java y docente universitario.

### Rol y Objetivo
Tu objetivo es diseñar e implementar en Java un algoritmo óptimo para encontrar el valor máximo (mayor elemento) de una matriz bidimensional de enteros (`int[][]`), reportando además la posición (fila y columna) donde se encuentra dicho elemento.

### Estrategia Elegida y Justificación
- Estrategia: Recorrido matricial completo por filas (Full Matrix Scan). Se inicializa el valor máximo con el primer elemento válido encontrado en la matriz (`matriz[0][0]`) y sus coordenadas correspondientes (`filaMax = 0, colMax = 0`). Luego se recorre cada fila $i$ y cada columna $j$, actualizando el máximo y sus coordenadas cada vez que `matriz[i][j] > maximo`.
- Justificación de por qué es estrictamente necesario recorrer todos los elementos:
  * En una matriz arbitraria (no ordenada bajo propiedades especiales como matriz de Young o filas/columnas estrictamente monótonas), no existe ninguna restricción estructural ni relación de orden previa entre celdas contiguas.
  * Por el teorema de cota inferior basada en información en colecciones no ordenadas, omitir tan solo una celda sin inspeccionar abre la posibilidad cierta de que dicha celda omitida contenga el verdadero valor máximo.
  * En consecuencia, para garantizar la corrección matemática de la solución, es imperativo que el espacio de búsqueda completo de $N \times M$ elementos sea examinado de principio a fin.

### Complejidad Esperada
- Complejidad Temporal:
  - Invariante $\Theta(N \times M)$ en el mejor, peor y caso promedio (donde $N$ es la cantidad de filas y $M$ la cantidad de columnas promedio). Cada elemento de la matriz debe ser leído y comparado exactamente una vez.
- Complejidad Espacial:
  - O(1) memoria adicional auxiliar, ya que únicamente se requiere almacenar variables escalares primitivas para el valor máximo, las coordenadas de fila/columna y los índices de los bucles.

### Requisitos del Código Java
- Lenguaje: Java 17 o superior.
- Nombre de la clase: `Main` (o `MayorMatriz`).
- Encapsulamiento del resultado: Definir un registro o clase `ResultadoMayor(int valorMaximo, int fila, int columna, int elementosExaminados)`.
- Método principal: `public static ResultadoMayor encontrarMayor(int[][] matriz)`.
- Manejo de casos borde: Matriz nula, matriz vacía (`length == 0`), filas de longitud cero, matrices con valores negativos grandes (demostrando por qué no inicializar con 0 sino con el primer elemento o `Integer.MIN_VALUE`).
- Compatibilidad: Debe funcionar con matrices cuadradas, rectangulares e irregulares (jagged arrays).
- Buenas prácticas: Nombres claros, código limpio y comentarios pedagógicos sobre la necesidad de inspección total y la selección de la condición inicial.

### Requisitos Específicos del Ejercicio
1. Justificar detalladamente en la introducción y en los comentarios del código por qué es obligatoria la inspección completa de todas las celdas de la matriz.
2. Solicitar el análisis formal de complejidad temporal ($\Theta(N \times M)$) y espacial ($O(1)$).
3. Informar tanto el valor mayor como sus coordenadas posicionales y el número total de celdas evaluadas.
4. Incluir un método `main` con casos de prueba ejecutables:
   - Matriz con números exclusivamente negativos (verificando que no falle por inicializar en 0).
   - Matriz donde el máximo está en la primera celda `(0, 0)`.
   - Matriz donde el máximo está en la última celda.
   - Matriz donde el máximo se encuentra en una celda intermedia.
   - Matriz irregular con filas de longitudes desiguales.
   - Matriz con valores máximos repetidos (reportando la primera ocurrencia encontrada).
5. Imprimir la matriz en formato bidimensional y el resultado detallado.

### Formato de Salida Esperado
Responde en el siguiente orden estricto:
1. Justificación conceptual de la necesidad de examinar exhaustivamente toda la matriz y criterio de inicialización.
2. Análisis formal de complejidad temporal y espacial.
3. Código Java completo, modular y documentado con clase `Main` y casos de prueba.
4. Salida por consola generada por los casos de prueba ejecutados en `main`.
```

## Checklist
- [x] Enunciado original incluido sin modificaciones.
- [x] Rol y objetivo definidos para OpenCode.
- [x] Justificación de por qué es indispensable recorrer todos los elementos explicada antes del código.
- [x] Análisis formal de complejidad temporal $\Theta(N \times M)$ y espacial $O(1)$ solicitado.
- [x] Retorno de valor mayor y coordenadas de posición implementado.
- [x] Requisitos del código Java especificados (inicialización segura para negativos, matrices irregulares, comentarios formativos).
- [x] Casos de prueba exhaustivos con matrices negativas, esquinas y matrices irregulares.
- [x] Formato de salida ordenado y estructurado.

