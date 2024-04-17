package ar.edu.unju.fi.ejercicio15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int tamanioArray;
        do {
            System.out.print("Ingrese un número entero en el rango [5, 10]: ");
            tamanioArray = entrada.nextInt();
        } while (tamanioArray < 5 || tamanioArray > 10);

        // Crear un array de tipo String de tamaño especificado por el usuario
        String[] nombres = new String[tamanioArray];

        // Solicitar al usuario que ingrese nombres para el array
        for (int i = 0; i < tamanioArray; i++) {
        	int pos = i +1;
            System.out.print("Ingrese un nombre de persona para la posición " + pos + ": ");
            nombres[i] = entrada.next();
        }

        // Mostrar el valor de cada posición del array comenzando por el primer índice 0
        System.out.println("Valores en el array (comenzando por el primer índice 0):");
        for (int i = 0; i < tamanioArray; i++) {
            System.out.println("Posición " + i + ": " + nombres[i]);
        }

        // Mostrar el contenido del array comenzando con la última posición del array
        System.out.println("\nValores del array (comenzando por la última posición del array):");
        for (int i = tamanioArray - 1; i >= 0; i--) {
            System.out.println("Posición " + i + ": " + nombres[i]);
        }
        entrada.close();
    }
}
