package JAVA;
import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main (String[] args){ 
     Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del Usuario: ");
        String nombre = sc.nextLine();
        System.out.println("Edad del usuario: ");
        int edad = sc.nextInt();
        System.out.println("Sueldo deseado: ");
        double sueldo = sc.nextDouble();
        double totalA = sueldo * 12;
        double totalBono = totalA *0.15;
        double ganancia = totalA + totalBono;

        System.out.println("Hola: " + nombre + ", con tu edad de: " + edad + " años, tu sueldo anual con bono seria: " + ganancia);


    }
}
