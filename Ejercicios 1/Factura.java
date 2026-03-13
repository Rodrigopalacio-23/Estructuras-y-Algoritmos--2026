package JAVA;
import java.util.Scanner;

public class Factura {
   public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Precio del Producto: ");
    double precio = sc.nextDouble();
    double iva = precio *0.21;
    double total = precio + iva;

    System.out.println("IVA: "+ iva + "| Total: "+ total);
   } 
}
