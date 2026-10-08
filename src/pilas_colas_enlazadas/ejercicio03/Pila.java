/*
Prompt inicial utilizado:
Quiero implementar en Java una Pila Enlazada Genérica (Pila<T>) desde cero, parametrizada por un tipo T, utilizando nodos enlazados simples y sin utilizar ninguna clase de la Java Collections Framework.

### Estructura de Clases y Nodos
- Clase Nodo<T>: contiene un atributo 'dato' de tipo parametrizado T y una referencia autorreferencial 'siguiente' de tipo Nodo<T>.
- Clase Pila<T>: estructura genérica que administra la pila mediante la referencia 'head' (Nodo<T>) y un contador 'size'.
- Clase de prueba propia (ej. Tarea o Producto): para verificar que la pila funciona correctamente con tipos de datos personalizados definidos por el usuario, además de tipos envoltorios estándar como Integer y String.

### Razonamiento Conceptual: Genéricos en Java e Independencia de Tipo
- Rol de los tipos genéricos: Los genéricos de Java permiten la parametrización de tipos en tiempo de compilación. Esto provee type-safety (seguridad de tipos) sin necesidad de realizar casts inseguros ni recurrir a la clase Object.
- Independencia lógica de la estructura de datos: La lógica de apilar (push), desapilar (pop) y consultar la cima (peek) es totalmente agnóstica del dato que almacena; solo manipula referencias a nodos. Ya sea un Integer primitivo boxeado, una cadena String o una entidad compleja como Tarea, el orden LIFO y el tiempo O(1) permanecen idénticos.
- Manejo de excepciones: Si se intenta pop() o peek() sobre una pila vacía, debe lanzarse NoSuchElementException.

### Operaciones Requeridas
- void push(T elemento): inserta un nuevo elemento de tipo T en la cima (O(1)).
- T pop(): extrae y retorna el elemento en la cima (O(1)); lanza NoSuchElementException si está vacía.
- T peek(): retorna el elemento de la cima sin extraerlo (O(1)); lanza NoSuchElementException si está vacía.
- boolean estaVacia(): indica si no hay nodos en la pila.
- int getSize(): retorna el número de elementos.
- void imprimir(): muestra los elementos desde el tope hasta la base.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package pilas_colas_enlazadas.ejercicio03;

import java.util.NoSuchElementException;

public class Pila<T> {
    private Nodo<T> head;
    private int size;

    public Pila() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Apila un nuevo elemento en la cima en O(1).
     */
    public void push(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        nuevo.setSiguiente(head);
        head = nuevo;
        size++;
    }

    /**
     * Desapila y retorna el elemento en la cima en O(1).
     */
    public T pop() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La pila está vacía, no se puede realizar pop.");
        }
        T valor = head.getDato();
        head = head.getSiguiente();
        size--;
        return valor;
    }

    /**
     * Retorna el elemento en la cima sin retirarlo en O(1).
     */
    public T peek() {
        if (estaVacia()) {
            throw new NoSuchElementException("Error: La pila está vacía, no se puede realizar peek.");
        }
        return head.getDato();
    }

    /**
     * Verifica si la pila está vacía.
     */
    public boolean estaVacia() {
        return head == null;
    }

    /**
     * Retorna la cantidad de elementos en la pila.
     */
    public int getSize() {
        return size;
    }

    /**
     * Imprime los elementos de la pila desde el tope hacia la base.
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Pila vacía: [ ]");
            return;
        }
        System.out.print("Tope -> ");
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print("[" + actual.getDato() + "]");
            if (actual.getSiguiente() != null) {
                System.out.print(" -> ");
            }
            actual = actual.getSiguiente();
        }
        System.out.println(" -> Base");
    }
}

