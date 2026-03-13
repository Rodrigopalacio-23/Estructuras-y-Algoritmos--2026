package JAVA;
import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = sc.nextLine();
        System.out.println("Ingrese una letra al azar: ");
        char letra = sc.next().charAt(0);

        //Operacion1: Contar cuantas veces aparece esa letra en la frase(Sin importar mayus/ minus)
        int contador = 0;
        for (char c : frase.toLowerCase().toCharArray()) {
            if (c == Character.toLowerCase(letra)) {
                contador++;
            }
        }
        System.out.println("La letra '" + letra + "' aparece " + contador + " veces en la frase.");

        //Operacion2: Invertir la frase completa
        String fraseInvertida = new StringBuilder(frase).reverse().toString();
        System.out.println("Frase invertida: " + fraseInvertida);
        
        //Operacion3: Indicar si la frase empieza con la palabra "Java"
        boolean empiezaConJava = frase.startsWith("Java");
        System.out.println("¿La frase empieza con 'Java'? " + empiezaConJava);

        sc.close(); 
    }
}
