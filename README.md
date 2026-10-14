# Estructuras y Algoritmos 2026

Repositorio de trabajos prácticos y ejercicios de la cátedra de **Estructuras de Datos y Algoritmos**.

---

## Estructura de Trabajos Prácticos

Todo el código de los ejercicios se encuentra organizado dentro del directorio [`ejercicios/`](ejercicios/), conteniendo cada archivo `.java` el prompt inicial utilizado como comentario al final del código:

### 1. [`ejercicios/analisis_algoritmos/`](ejercicios/analisis_algoritmos/)
Implementaciones en Java basadas en los algoritmos analizados (mínimo de vector, búsqueda lineal, búsqueda binaria, duplicados, ocurrencias, comparación, inversión, matrices, bubble sort). Cada subcarpeta (`ejercicio01` a `ejercicio10`) incluye su `Main.java` independiente con el prompt completo al final.

### 2. [`ejercicios/recursividad/`](ejercicios/recursividad/)
10 ejercicios de algoritmos recursivos en Java con prompt inicial al final, justificación matemática, caso base, caso recursivo, análisis de call stack y casos de prueba:
- Factorial, suma de los primeros $N$ números, multiplicación rusa/recursiva, potencia, conteo regresivo, conteo de dígitos, suma de dígitos, inversión de string, palíndromo y búsqueda recursiva en arreglos.

### 3. [`ejercicios/ordenamiento/`](ejercicios/ordenamiento/)
10 algoritmos de ordenamiento en Java con su prompt embebido al final del código:
- Burbuja paso a paso, Burbuja vs Selección, Inserción en arreglos casi ordenados, Selección con strings, Shell Sort, Quicksort (primer pivote), Quicksort (peor caso), Merge Sort, Comparación de algoritmos elementales y Ranking de puntajes.

### 4. [`ejercicios/pilas_y_colas/`](ejercicios/pilas_y_colas/)
10 ejercicios de Pilas y Colas implementadas con **arreglos** (`ejercicio01` al `ejercicio10`):
- Pila de enteros, Torre de platos, Paréntesis balanceados, Historial de navegación, Pila genérica `Pila<T>`, Cola de enteros, Sistema de turnos, Cola de impresión, Desperdicio en cola simple y Cola circular con aritmética modular. Cada ejercicio cuenta con su captura de salida (`ejecucion.txt`) y su prompt al final.

### 5. [`ejercicios/listas_enlazadas/`](ejercicios/listas_enlazadas/)
10 ejercicios de **Listas Enlazadas Simples** con nodos propios (`ejercicio01` al `ejercicio10`):
- Lista base (inserciones, recorrido, tamaño), búsqueda, acceso por posición, inserción en posición, eliminación por valor, eliminación por índice, modificación, conteo de ocurrencias, inversión de lista in-situ y versión genérica `ListaEnlazada<T>` probada con tipos personalizados. Incluyen `Nodo.java`, `ListaEnlazada.java`, `Main.java`, `ejecucion.txt` y prompt al final.

### 6. [`ejercicios/pilas_colas_enlazadas/`](ejercicios/pilas_colas_enlazadas/)
10 ejercicios de **Pilas y Colas implementadas con Nodos Enlazados** (`ejercicio01` al `ejercicio10`):
- Pila enlazada de enteros, Cola enlazada (gestión de `head` y `tail`), Pila genérica `Pila<T>`, Cola genérica `Cola<T>`, Historial de navegación web LIFO, Cola bancaria FIFO, Paréntesis balanceados, Inversión de palabras, Spooler de impresión FIFO y Lista doblemente enlazada genérica con enlaces bidireccionales y eliminación en todos los casos borde.

---

## Compilación y Ejecución

Los ejercicios no utilizan librerías externas ni la Java Collections Framework (`ArrayList`, `LinkedList`, `Stack`, `Queue`), implementando todas las estructuras desde cero con nodos y referencias directas.

Para compilar y ejecutar cualquier ejercicio de forma directa:

```bash
# Ejemplo: Compilar y ejecutar Ejercicio 1 de Pilas y Colas Enlazadas
javac -d bin ejercicios/pilas_colas_enlazadas/ejercicio01/*.java
java -cp bin pilas_colas_enlazadas.ejercicio01.Main

# Ejemplo: Compilar y ejecutar Ejercicio de Ordenamiento
javac -d bin ejercicios/ordenamiento/Ejercicio01Burbuja.java
java -cp bin ordenamiento.Ejercicio01Burbuja
```
