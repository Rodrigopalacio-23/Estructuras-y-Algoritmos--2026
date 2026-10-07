/*
Quiero implementar en Java un simulador de una Torre de Platos (TorreDePlatos) utilizando una estructura de Pila basada en arreglos.

### Estructura y Arreglo Interno
La clase debe gestionar un arreglo de cadenas String[] platos (o identificadores de platos) y un índice 'tope' que señale el plato superior de la torre.

### Razonamiento: ¿Por qué se resuelve con una Pila (LIFO) y no con una Cola (FIFO)?
En el mundo real, al apilar platos, cada nuevo plato se coloca en la cima de la torre. El único plato accesible para ser retirado de manera segura y sin derrumbar la torre es el que está en la parte superior, es decir, el ÚLTIMO que fue colocado.
- Una Pila modela exactamente el principio LIFO (Last-In, First-Out): el último plato apilado es el primero en retirarse.
- Una Cola (FIFO - First-In, First-Out) pretendería retirar primero el plato ubicado en la base de la torre, lo cual físicamente requeriría levantar o romper todos los platos que están encima. Por ello, la estructura adecuada es intrínsecamente una Pila.

### Operaciones Requeridas
- void apilarPlato(String plato): Agrega un plato en la cima de la torre.
- String retirarPlato(): Retira y devuelve el plato superior.
- String verPlatoSuperior(): Consulta cuál es el plato que está en la cima sin retirarlo.
- boolean estaVacia() y boolean estaLlena().

### Casos Límite y Manejo de Errores
- Torre llena: Si la torre alcanza su capacidad máxima y se intenta agregar otro plato, se lanza IllegalStateException("Error: La torre de platos está llena, riesgo de caída.").
- Torre vacía: Si no hay platos e intentamos retirar o consultar el plato superior, se lanza IllegalStateException("Error: La torre de platos está vacía.").

### Casos de Prueba en Main
Crear una torre de capacidad 4. Apilar 3 platos ("Plato Rojo", "Plato Azul", "Plato Blanco"). Consultar el plato superior. Apilar un cuarto plato ("Plato Dorado") para llenarla. Intentar apilar en torre llena capturando el error. Retirar platos uno por uno mostrando el orden LIFO. Intentar retirar de una torre vacía.
*/

package pilas_y_colas.ejercicio02;

import java.util.Arrays;

public class TorreDePlatos {
    private final String[] platos;
    private int tope;
    private final int capacidad;

    public TorreDePlatos(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidad = capacidad;
        this.platos = new String[capacidad];
        this.tope = -1; // Torre vacía
    }

    public void apilarPlato(String plato) {
        if (estaLlena()) {
            throw new IllegalStateException("Error: La torre de platos está llena (capacidad " + capacidad + "). No se puede agregar: " + plato);
        }
        platos[++tope] = plato;
        System.out.println("-> Se apiló: " + plato + " en la cima.");
    }

    public String retirarPlato() {
        if (estaVacia()) {
            throw new IllegalStateException("Error: La torre de platos está vacía. No hay platos para retirar.");
        }
        String platoRetirado = platos[tope];
        platos[tope--] = null; // Limpiar referencia
        return platoRetirado;
    }

    public String verPlatoSuperior() {
        if (estaVacia()) {
            throw new IllegalStateException("Error: La torre está vacía. No hay plato superior.");
        }
        return platos[tope];
    }

    public boolean estaVacia() {
        return tope == -1;
    }

    public boolean estaLlena() {
        return tope == capacidad - 1;
    }

    public int cantidadPlatos() {
        return tope + 1;
    }

    public void mostrarTorre() {
        System.out.println("\n[Vista de la Torre (de arriba hacia abajo)]");
        if (estaVacia()) {
            System.out.println("   (Torre vacía)");
        } else {
            for (int i = tope; i >= 0; i--) {
                System.out.printf("   | %-16s | %s\n", platos[i], (i == tope ? "<-- SUPERIOR (CIMA)" : ""));
            }
            System.out.println("   +------------------+");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" EJERCICIO 2: SIMULADOR DE TORRE DE PLATOS (LIFO)");
        System.out.println("==================================================\n");

        TorreDePlatos torre = new TorreDePlatos(4);

        System.out.println("--- 1. Apilando platos iniciales ---");
        torre.apilarPlato("Plato Cerámica #1");
        torre.apilarPlato("Plato Cerámica #2");
        torre.apilarPlato("Plato Cerámica #3");
        torre.mostrarTorre();

        System.out.println("Plato superior actual: " + torre.verPlatoSuperior() + "\n");

        System.out.println("--- 2. Llenando la torre y forzando desbordamiento ---");
        torre.apilarPlato("Plato Especial #4");
        torre.mostrarTorre();

        try {
            torre.apilarPlato("Plato Extra #5");
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("--- 3. Retirando platos (Comportamiento LIFO) ---");
        while (!torre.estaVacia()) {
            System.out.println("Retirando: " + torre.retirarPlato());
        }
        torre.mostrarTorre();

        System.out.println("--- 4. Intento de retiro en torre vacía ---");
        try {
            torre.retirarPlato();
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage() + "\n");
        }

        System.out.println("Prueba de Ejercicio 2 completada con éxito.");
    }
}

/*
Ajustes al prompt:
Sin ajustes.
*/

