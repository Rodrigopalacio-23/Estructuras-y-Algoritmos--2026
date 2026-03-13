package JAVA;
import java.util.Scanner;

//Sistema de acceso con LOgica Booleana

public class Ejercicio2 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Sistema de acceso del Evento"); 
    System.out.println("Ingrese su edad: ");
    int edad = sc.nextInt();
        if (edad >= 65) {

            System.out.println("Bienvenido Socio Honorario");

        } 
        else if (edad >= 18) {

            System.out.print("¿Tienes invitación? (1.Si | 2.No): ");
            int invitacion = sc.nextInt();

            if (invitacion == 1) {
                System.out.println("Bienvenido al evento");
            } else {
                System.out.println("No puedes acceder sin invitación");
            }

        } 
        else {

            System.out.print("¿Accedes con tutor? (1.Si | 2.No): ");
            int acceso = sc.nextInt();

            if (acceso == 1) {

                System.out.print("¿Tu tutor tiene invitación? (1.Si | 2.No): ");
                int accesoT = sc.nextInt();

                if (accesoT == 1) {
                    System.out.println("Bienvenido, puedes acceder con tu tutor");
                } else {
                    System.out.println("Tu tutor no tiene invitación");
                }

            } else {
                System.out.println("No puedes acceder, eres menor de edad");
            }

        }

        sc.close();
    }
}
 