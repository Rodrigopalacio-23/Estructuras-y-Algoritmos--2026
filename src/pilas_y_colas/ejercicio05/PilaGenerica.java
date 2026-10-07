/*
Quiero implementar en Java una estructura de Pila genérica Pila<T> utilizando exclusivamente un arreglo interno (sin colecciones de Java como ArrayList o Stack).

### Estructura y Arreglo Interno
La clase Pila<T> debe contener un arreglo T[] elementos y un índice 'top'.
Debido al mecanismo de supresión de tipos (Type Erasure) de Java, no es posible instanciar directamente 'new T[capacidad]'. Por ende, el arreglo interno se inicializa como (T[]) new Object[capacidad], aplicando @SuppressWarnings("unchecked") de forma controlada y segura.

### Razonamiento: ¿Qué problema resuelven los genéricos y cómo se diferencian de una pila solo de int?
1. Reusabilidad de Código: Una pila hecha puramente con 'int' solo sirve para números enteros. Si el sistema necesitara almacenar Strings, Doubles o entidades de dominio (por ejemplo Cliente o Tarea), nos veríamos obligados a duplicar el código creando PilaString, PilaDouble, etc.
2. Type Safety (Seguridad de Tipos en Tiempo de Compilación):
   - Si en lugar de genéricos utilizáramos Object[], se podrían mezclar tipos erróneos por accidente y se requeriría casting explícito (ej: (String) pila.pop()), lo que genera vulnerabilidad a errores de tiempo de ejecución (ClassCastException).
   - Los genéricos <T> proporcionan verificación estática en tiempo de compilación: Pila<String> solo admite cadenas y Pila<Integer> solo admite números, garantizando código robusto sin necesidad de castings manuales en el código cliente.

### Operaciones Requeridas
- void push(T elemento): Agrega un elemento a la cima.
- T pop(): Retira y devuelve el elemento de la cima, limpiando la referencia en memoria (Garbage Collection).
- T peek(): Consulta la cima sin retirarla.
- boolean isEmpty(), boolean isFull(), int size().

### Casos Límite y Manejo de Errores
- Pila llena: push() lanza IllegalStateException("Error: Pila llena (desbordamiento).").
- Pila vacía: pop() y peek() lanzan IllegalStateException("Error: Pila vacía (subdesbordamiento).").

### Casos de Prueba en Main
Demostrar el uso de Pila<T> instanciándola con al menos 3 tipos de datos distintos:
1. Pila<Integer> con números enteros.
2. Pila<String> con palabras.
3. Pila<Tarea> con una clase de dominio simple Tarea(String nombre, int prioridad).
Probar en cada una operaciones de apilado, cima, desapilado y capturar excepciones de borde.
*/

package pilas_y_colas.ejercicio05;

public class PilaGenerica {

    /**
     * Clase de dominio simple para probar objetos en la pila genérica.
     */
    public record Tarea(String descripcion, int prioridad) {
        @Override
        public String toString() {
            return String.format("[%s (Prioridad %d)]", descripcion, prioridad);
        }
    }

    /**
     * Implementación de Pila genérica basada en arreglos.
     *
     * @param <T> tipo genérico de los elementos almacenados
     */
    public static class Pila<T> {
        private final T[] datos;
        private int top;
        private final int capacidad;

        @SuppressWarnings("unchecked")
        public Pila(int capacidad) {
            if (capacidad <= 0) {
                throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
            }
            this.capacidad = capacidad;
            // Instanciación del arreglo genérico mediante casteo de Object[]
            this.datos = (T[]) new Object[capacidad];
            this.top = -1;
        }

        public void push(T elemento) {
            if (isFull()) {
                throw new IllegalStateException("Error: Pila llena (desbordamiento). No se puede insertar: " + elemento);
            }
            datos[++top] = elemento;
        }

        public T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Error: Pila vacía (subdesbordamiento). No se puede hacer pop.");
            }
            T item = datos[top];
            datos[top--] = null; // Limpieza de referencia para el recolector de basura (GC)
            return item;
        }

        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Error: Pila vacía. No hay elemento en la cima.");
            }
            return datos[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacidad - 1;
        }

        public int size() {
            return top + 1;
        }

        public void imprimirPila() {
            System.out.print("[Base -> Cima]: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(datos[i] + (i < top ? ", " : ""));
            }
            System.out.println(" (size = " + size() + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 5: PILA GENÉRICA <T> CON ARREGLOS");
        System.out.println("==================================================\n");

        // 1. Pila de Integers
        System.out.println("--- 1. Pila<Integer> ---");
        Pila<Integer> pilaInt = new Pila<>(3);
        pilaInt.push(100);
        pilaInt.push(200);
        pilaInt.push(300);
        pilaInt.imprimirPila();
        System.out.println("Cima actual: " + pilaInt.peek());
        System.out.println("Desapilado: " + pilaInt.pop());
        pilaInt.imprimirPila();

        // 2. Pila de Strings
        System.out.println("\n--- 2. Pila<String> ---");
        Pila<String> pilaStr = new Pila<>(3);
        pilaStr.push("Java");
        pilaStr.push("Genéricos");
        pilaStr.push("Estructuras");
        pilaStr.imprimirPila();
        System.out.println("Cima actual: " + pilaStr.peek());
        System.out.println("Desapilado: " + pilaStr.pop());
        pilaStr.imprimirPila();

        // 3. Pila de Objetos de dominio (Tarea)
        System.out.println("\n--- 3. Pila<Tarea> (Objetos simples) ---");
        Pila<Tarea> pilaTareas = new Pila<>(3);
        pilaTareas.push(new Tarea("Diseñar modelo", 1));
        pilaTareas.push(new Tarea("Implementar pruebas", 2));
        pilaTareas.push(new Tarea("Documentar código", 3));
        pilaTareas.imprimirPila();
        System.out.println("Tarea en cima: " + pilaTareas.peek());

        // Comprobación de caso límite: desbordamiento
        System.out.println("\n--- 4. Caso límite en Pila<Tarea>: Push en pila llena ---");
        try {
            pilaTareas.push(new Tarea("Deploy", 4));
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\nDesapilando todas las tareas:");
        while (!pilaTareas.isEmpty()) {
            System.out.println("Procesada: " + pilaTareas.pop());
        }

        System.out.println("\n--- 5. Caso límite: Pop en pila vacía ---");
        try {
            pilaTareas.pop();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        System.out.println("\nPrueba de Ejercicio 5 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

