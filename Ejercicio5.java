package JAVA;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] temperaturas = new double[3][3];

        
        // Operación 1: Llenar la matriz con datos del usuario
        System.out.println("Ingrese las temperaturas para 3 ciudades durante 3 días:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Temperatura ciudad " + (i + 1) + ", día " + (j + 1) + ": ");
                temperaturas[i][j] = sc.nextDouble();
            }
        }

        // Operación 2: Calcular el promedio de temperatura por cada ciudad (promedio de cada fila)
        System.out.println("\nPromedio de temperaturas por ciudad:");
        for (int i = 0; i < 3; i++) {
            double suma = 0;
            for (int j = 0; j < 3; j++) {
                suma += temperaturas[i][j];
            }
            double promedio = suma / 3;
            System.out.println("Ciudad " + (i + 1) + ": " + String.format("%.2f", promedio) + "°C");
        }

        // Operación 3: Encontrar la temperatura más alta y su posición
        double maxTemp = temperaturas[0][0];
        int maxFila = 0;
        int maxColumna = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (temperaturas[i][j] > maxTemp) {
                    maxTemp = temperaturas[i][j];
                    maxFila = i;
                    maxColumna = j;
                }
            }
        }
        System.out.println("\nTemperatura más alta: " + maxTemp + "°C");
        System.out.println("Posición: Ciudad " + (maxFila + 1) + ", Día " + (maxColumna + 1));

        sc.close();
    }
}
