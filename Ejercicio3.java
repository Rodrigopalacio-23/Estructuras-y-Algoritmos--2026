package JAVA;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main (String[] args){
    int clave;
    int intentos = 0;
    int pin = 1234;
    Scanner sc = new Scanner(System.in);
    do {
        System.out.println("Ingrese su PIN de 4 Digitos: ");
        clave = sc.nextInt();
        intentos++;

        if(clave == pin){
            System.out.println("Bienvenido");
            break;
        }else{
            System.out.println("PIN incorrecto");
        }
    } while (intentos < 3);

     if(clave != pin){
             System.out.println("Cuenta Bloqueada");
        }
        sc.close();
    }
}
