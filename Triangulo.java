package JAVA;
import java.util.Scanner;

//Desarrollar un programa que cargue los lados de un triangulo e implemente los siguientes metodos: Inicializar los atributos
//Imrimir el valor del lado mayor y potro metodo que muestre si es equilatero o no

public class Triangulo {

    private int lado1;
    private int lado2;
    private int lado3;

    // Constructor para inicializar los atributos
    public Triangulo(int l1, int l2, int l3) {
        lado1 = l1;
        lado2 = l2;
        lado3 = l3;
    }

    // Método para obtener el lado mayor
    public int ladoMayor() {
        int mayor = lado1;
        if (mayor < lado2) {
            mayor = lado2;
        }
        if (mayor < lado3) {
            mayor = lado3;
        }
        return mayor;
    }

    // Método para verificar si es equilátero
    public boolean esEquilatero() {
        return lado1 == lado2 && lado2 == lado3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer lado del triangulo: ");
        int l1 = sc.nextInt();
        System.out.println("Ingrese el segundo lado del triangulo: ");
        int l2 = sc.nextInt();
        System.out.println("Ingrese el tercer lado del triangulo: ");
        int l3 = sc.nextInt();

        Triangulo triangulo = new Triangulo(l1, l2, l3);

        System.out.println("El lado mayor es: " + triangulo.ladoMayor());
        if (triangulo.esEquilatero()) {
            System.out.println("Es equilatero");
        } else {
            System.out.println("No es equilatero");
        }
    }
}

