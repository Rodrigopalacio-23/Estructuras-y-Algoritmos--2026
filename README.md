# Estructuras y Algoritmos 2026

Repositorio de trabajos prácticos y ejercicios de la cátedra de **Estructuras de Datos y Algoritmos**.

---

## Estructura de Trabajos Prácticos

Todo el código de los ejercicios se encuentra organizado dentro del directorio [`ejercicios/`](ejercicios/). Cada carpeta de ejercicio es **totalmente autónoma y autocontenida** (puedes entrar directamente a cualquier carpeta y compilar/ejecutar con `javac *.java && java Main` sin dependencias de paquetes):

### 1. [`ejercicios/Practico_Analisis_de_Algoritmos/`](ejercicios/Practico_Analisis_de_Algoritmos/)
Implementaciones en Java basadas en los algoritmos analizados (mínimo de vector, búsqueda lineal, búsqueda binaria, duplicados, ocurrencias, comparación, inversión, matrices, bubble sort). Cada subcarpeta (`ejercicio01` a `ejercicio10`) incluye su `Main.java` independiente con el prompt completo al final del código.

### 2. [`ejercicios/Practico_Recursividad/`](ejercicios/Practico_Recursividad/)
10 ejercicios de algoritmos recursivos en Java con prompt inicial al final, justificación matemática, caso base, caso recursivo, análisis de call stack y casos de prueba (`ejercicio01` a `ejercicio10`):
- Factorial, suma de los primeros $N$ números, multiplicación rusa/recursiva, potencia, conteo regresivo, conteo de dígitos, suma de dígitos, inversión de string, palíndromo y búsqueda recursiva en arreglos.

### 3. [`ejercicios/Practico_Ordenamiento/`](ejercicios/Practico_Ordenamiento/)
10 algoritmos de ordenamiento en Java organizados en subcarpetas (`ejercicio01` a `ejercicio10`) con su prompt embebido al final del código:
- Burbuja paso a paso, Burbuja vs Selección, Inserción en arreglos casi ordenados, Selección con strings, Shell Sort, Quicksort (primer pivote), Quicksort (peor caso), Merge Sort, Comparación de algoritmos elementales y Ranking de puntajes.

### 4. [`ejercicios/Practico_Pilas_y_Colas_con_Arreglo/`](ejercicios/Practico_Pilas_y_Colas_con_Arreglo/)
10 ejercicios de Pilas y Colas implementadas con **arreglos** (`ejercicio01` al `ejercicio10`):
- Pila de enteros, Torre de platos, Paréntesis balanceados, Historial de navegación, Pila genérica `Pila<T>`, Cola de enteros, Sistema de turnos, Cola de impresión, Desperdicio en cola simple y Cola circular con aritmética modular. Incluye su salida de ejecución (`ejecucion.txt`) y prompt al final.

### 5. [`ejercicios/Practico_Listas_Enlazadas_Simples/`](ejercicios/Practico_Listas_Enlazadas_Simples/)
10 ejercicios de **Listas Enlazadas Simples** con nodos propios (`ejercicio01` al `ejercicio10`):
- Lista base (inserciones, recorrido, tamaño), búsqueda, acceso por posición, inserción en posición, eliminación por valor, eliminación por índice, modificación, conteo de ocurrencias, inversión de lista in-situ y versión genérica `ListaEnlazada<T>` probada con tipos personalizados. Cada ejercicio incluye `Nodo.java`, `ListaEnlazada.java`, `Main.java`, `ejecucion.txt` y prompt al final.

### 6. [`ejercicios/Practico_Pilas_y_Colas_con_Listas_Enlazadas/`](ejercicios/Practico_Pilas_y_Colas_con_Listas_Enlazadas/)
10 ejercicios de **Pilas y Colas implementadas con Nodos Enlazados** (`ejercicio01` al `ejercicio10`):
- Pila enlazada de enteros, Cola enlazada (gestión de `head` y `tail`), Pila genérica `Pila<T>`, Cola genérica `Cola<T>`, Historial de navegación web LIFO, Cola bancaria FIFO, Paréntesis balanceados, Inversión de palabras, Spooler de impresión FIFO y Lista doblemente enlazada genérica con enlaces bidireccionales y eliminación en todos los casos borde. Incluye `ejecucion.txt` y prompt al final.

---

## Compilación y Ejecución Simple

Cada subcarpeta de ejercicio se puede compilar y ejecutar de forma directa e independiente, sin necesidad de classpath complejo ni configuración previa.

### Forma directa (dentro de la carpeta del ejercicio):

```bash
# Ejemplo: Entrar al Ejercicio 1 de Pilas y Colas con Listas Enlazadas y ejecutar
cd "ejercicios/Practico_Pilas_y_Colas_con_Listas_Enlazadas/ejercicio01"
javac *.java
java Main

# Ejemplo: Entrar al Ejercicio 1 de Ordenamiento y ejecutar
cd "ejercicios/Practico_Ordenamiento/ejercicio01"
javac *.java
java Ejercicio01Burbuja
```
