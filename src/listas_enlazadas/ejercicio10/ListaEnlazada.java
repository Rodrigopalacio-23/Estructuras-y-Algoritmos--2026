/*
Prompt inicial utilizado:
Quiero convertir la implementación de ListaEnlazada simple de enteros en una versión completamente genérica:
ListaEnlazada<T> y Nodo<T>
La lista debe funcionar con distintos tipos de datos:
- ListaEnlazada<Integer>
- ListaEnlazada<String>
- ListaEnlazada<Alumno> (con una clase de dominio Alumno con legajo, nombre y promedio)

### Razonamiento Conceptual: Qué cambia y qué se mantiene igual
1. ¿Qué partes del código cambian?:
   - Parámetros de tipo y firmas: El tipo primitivo 'int' es reemplazado por la variable de tipo genérico 'T' tanto en los nodos (Nodo<T>), como en los atributos y firmas de métodos (insertarAlInicio(T dato), T obtener(int posicion), etc.).
   - Comparaciones de igualdad: Para comparar objetos genéricos en 'buscar(T dato)', 'eliminar(T dato)' o 'contarOcurrencias(T dato)', NO se puede usar el operador '==' (que compararía igualdad de referencias en memoria). Es obligatorio emplear 'java.util.Objects.equals(actual.getDato(), dato)' o 'actual.getDato().equals(dato)', garantizando comparación semántica y soporte seguro ante nulos.
2. ¿Qué se mantiene estrictamente igual?:
   - Absolutamente toda la lógica estructural y algorítmica:
     * La inicialización de head y el enlace autorreferencial Nodo<T> siguiente.
     * El orden de inserción: nuevo.setSiguiente(actual.getSiguiente()); actual.setSiguiente(nuevo).
     * El orden de eliminación: anterior.setSiguiente(actual.getSiguiente()).
     * El algoritmo de inversión in-situ con tres punteros (anterior, actual, siguiente).
   - Esto demuestra la separación entre la estructura de datos (el contenedor enlazado) y el tipo de dato que contiene (el contenido o payload). La topología enlazada es agnóstica respecto al tipo de información que transporta.

### Métodos a Incluir
- insertarAlInicio(T dato), insertarAlFinal(T dato), insertarEnPosicion(T dato, int posicion)
- boolean eliminar(T dato), void eliminarEnPosicion(int posicion)
- void modificar(int posicion, T nuevoDato)
- T obtener(int posicion), boolean buscar(T dato), int contarOcurrencias(T dato)
- void invertir(), void imprimir(), boolean estaVacia(), int getSize()

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio10;

import java.util.Objects;

public class ListaEnlazada<T> {
    private Nodo<T> head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    public void insertarAlInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
        size++;
    }

    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            head = nuevo;
        } else {
            Nodo<T> actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    public void insertarEnPosicion(T dato, int posicion) {
        if (posicion < 0 || posicion > size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida: %d. Rango: [0, %d].", posicion, size));
        }
        if (posicion == 0) {
            insertarAlInicio(dato);
            return;
        }
        if (posicion == size) {
            insertarAlFinal(dato);
            return;
        }

        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> actual = head;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.getSiguiente();
        }
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        size++;
    }

    public boolean eliminar(T dato) {
        if (estaVacia()) {
            return false;
        }
        // Uso de Objects.equals() para comparación segura de objetos genéricos
        if (Objects.equals(head.getDato(), dato)) {
            head = head.getSiguiente();
            size--;
            return true;
        }

        Nodo<T> anterior = head;
        Nodo<T> actual = head.getSiguiente();
        while (actual != null) {
            if (Objects.equals(actual.getDato(), dato)) {
                anterior.setSiguiente(actual.getSiguiente());
                size--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void eliminarEnPosicion(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida para eliminar: %d. Tamaño: %d.", posicion, size));
        }
        if (posicion == 0) {
            head = head.getSiguiente();
            size--;
            return;
        }
        Nodo<T> anterior = head;
        for (int i = 0; i < posicion - 1; i++) {
            anterior = anterior.getSiguiente();
        }
        Nodo<T> aEliminar = anterior.getSiguiente();
        anterior.setSiguiente(aEliminar.getSiguiente());
        size--;
    }

    public void modificar(int posicion, T nuevoDato) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Posición inválida para modificar: %d. Tamaño actual: %d.", posicion, size));
        }
        Nodo<T> actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        actual.setDato(nuevoDato);
    }

    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Índice fuera de rango: %d. Tamaño: %d.", posicion, size));
        }
        Nodo<T> actual = head;
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    public boolean buscar(T dato) {
        Nodo<T> actual = head;
        while (actual != null) {
            if (Objects.equals(actual.getDato(), dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public int contarOcurrencias(T dato) {
        int contador = 0;
        Nodo<T> actual = head;
        while (actual != null) {
            if (Objects.equals(actual.getDato(), dato)) {
                contador++;
            }
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public void invertir() {
        if (estaVacia() || head.getSiguiente() == null) {
            return;
        }
        Nodo<T> anterior = null;
        Nodo<T> actual = head;
        Nodo<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.getSiguiente();
            actual.setSiguiente(anterior);
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Lista vacía (null)");
            return;
        }
        Nodo<T> actual = head;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int getSize() {
        return size;
    }
}

