package listas_enlazadas.ejercicio10;

import java.util.Objects;

/**
 * Clase de dominio Alumno para validar la lista enlazada genérica con objetos complejos.
 */
public class Alumno {
    private final int legajo;
    private final String nombre;
    private final double promedio;

    public Alumno(int legajo, String nombre, double promedio) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return legajo == alumno.legajo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(legajo);
    }

    @Override
    public String toString() {
        return String.format("Alumno[Legajo=%d, Nombre=\"%s\", Promedio=%.1f]", legajo, nombre, promedio);
    }
}

