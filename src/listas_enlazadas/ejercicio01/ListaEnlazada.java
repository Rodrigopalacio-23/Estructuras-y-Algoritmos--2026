/*
Prompt inicial utilizado:
Quiero implementar en Java una Lista Enlazada Simple de números enteros (ListaEnlazada) desde cero, sin utilizar colecciones de Java como ArrayList o LinkedList.

### Estructura de Clases y Nodos
Se requiere una clase Nodo con atributos 'dato' (int) y 'siguiente' (referencia autorreferencial Nodo), y una clase ListaEnlazada con la referencia 'head' (primer nodo de la lista) y un contador 'size'.

### Razonamiento Conceptual: Nodo, Head y Size
- Cómo se representa un nodo: Es una estructura en memoria compuesta por dos partes: el dato primitivo que transporta y un puntero de referencia ('siguiente') que almacena la dirección de memoria del próximo nodo.
- Qué función cumple 'head': Es la puerta de entrada indispensable a la lista enlazada. A diferencia de un arreglo donde la memoria es contigua y accesible por índice, en una lista enlazada los nodos están dispersos en el heap; por ende, si se pierde la referencia 'head', se pierde el acceso a todos los nodos de la estructura. Si head == null, la lista está vacía.
- Cómo se actualiza el tamaño (size): Se mantiene un atributo entero 'size' que se incrementa en 1 en cada inserción (size++) y se decrementa en 1 en cada eliminación (size--). Esto permite que el método getSize() consulte la cantidad de elementos en tiempo constante O(1), evitando un costoso recorrido completo O(n).

### Operaciones Requeridas
- void insertarAlInicio(int dato): Crea un nuevo nodo, hace que apunte al actual head, y actualiza head hacia el nuevo nodo (O(1)).
- void insertarAlFinal(int dato): Si la lista está vacía, el nuevo nodo pasa a ser head. Si no, recorre hasta el último nodo (aquel cuyo siguiente es null) y enlaza el nuevo nodo al final (O(n)).
- void imprimir(): Recorre la lista desde head imprimiendo cada elemento con formato "10 -> 20 -> null".
- boolean estaVacia(): Retorna head == null (o size == 0).
- int getSize(): Retorna el valor actual de size.

Ajustes realizados luego de la primera respuesta de OpenCode:
Sin ajustes.
*/

package listas_enlazadas.ejercicio01;

public class ListaEnlazada {
    private Nodo head;
    private int size;

    public ListaEnlazada() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Inserta un nuevo elemento al inicio de la lista (en O(1)).
     */
    public void insertarAlInicio(int dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
        size++;
    }

    /**
     * Inserta un nuevo elemento al final de la lista (en O(n)).
     */
    public void insertarAlFinal(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (estaVacia()) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        size++;
    }

    /**
     * Imprime el contenido secuencial de la lista.
     */
    public void imprimir() {
        if (estaVacia()) {
            System.out.println("Lista vacía (null)");
            return;
        }
        Nodo actual = head;
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

