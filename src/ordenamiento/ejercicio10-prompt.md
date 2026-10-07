# Ejercicio 10: Sistema de ranking de puntajes

## Prompt Inicial para OpenCode

```text
Quiero implementar en Java un programa para un sistema de ranking de videojuegos/deportes que reciba un arreglo de objetos de la clase Jugador (con atributos 'nombre' de tipo String y 'puntaje' de tipo int), y los ordene en orden descendente (de mayor a menor puntaje).

### Algoritmo Elegido y Justificación de la Elección
El algoritmo elegido es MergeSort (adaptado para orden descendente).
Justificación de por qué es la estrategia más conveniente para un sistema de ranking:
1. Requisito de Estabilidad (Stable Sort):
   En cualquier sistema de clasificación competitivo, es fundamental la estabilidad ante empates de puntaje. Si dos jugadores obtienen exactamente el mismo puntaje (por ejemplo, Ana con 1200 y Carlos con 1200), el ranking debe preservar su orden relativo original (quien alcanzó el puntaje primero o se registró antes conserva la ventaja de desempate).
   - Algoritmos como Quicksort y Selection Sort son INESTABLES: sus intercambios a larga distancia pueden invertir arbitrariamente el orden relativo de jugadores con puntajes idénticos.
   - MergeSort es ESTRICTAMENTE ESTABLE: durante la fase de combinación (merge), si izq[i].puntaje >= der[j].puntaje, se prioriza el elemento de la izquierda, preservando intacto el orden original.
2. Escalabilidad Asintótica y Tamaño de los Datos:
   En sistemas de producción los rankings pueden contener desde decenas hasta millones de usuarios. MergeSort garantiza una cota de tiempo O(n log n) en el peor, promedio y mejor caso, evitando las degradaciones cuadráticas O(n^2) de Insertion Sort, Bubble Sort o del peor caso de Quicksort.

### Datos que Recibe el Programa
Un arreglo de objetos Jugador con nombres y puntajes, conteniendo casos de desorden y casos de empate explícitos para comprobar la estabilidad:
- Jugador("Pedro", 900)
- Jugador("Ana", 1200)
- Jugador("Carlos", 1200)  <-- Empate con Ana
- Jugador("Lucia", 1500)
- Jugador("Martin", 800)
- Jugador("Sofia", 1500)   <-- Empate con Lucia

### Qué Debe Mostrar por Pantalla
1. La lista original de jugadores con su orden de registro inicial.
2. La justificación técnica de por qué se eligió MergeSort frente a alternativas inestables.
3. La tabla final del ranking ordenado de 1° puesto al último (de mayor a menor puntaje).
4. La comprobación explícita de estabilidad: verificar que en los empates (1500 y 1200), los jugadores mantuvieron su orden relativo de llegada.
5. Verificación formal de que los puntajes están en orden decreciente.

### Comentarios Requeridos en el Código
- Justificación en comentarios del operador '>=' en la fase de mezcla para preservar la estabilidad.
- Clase inmutable Jugador(String nombre, int puntaje).

### Cómo Verificar que el Resultado es Correcto
Función booleana estaOrdenadoRankingDescendente(Jugador[] array) y verificación de orden relativo en empates.
```

## Ajustes al prompt
Sin ajustes.

