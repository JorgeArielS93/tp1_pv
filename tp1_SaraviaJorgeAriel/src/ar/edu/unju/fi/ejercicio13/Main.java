package ar.edu.unju.fi.ejercicio13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int[] numeros = new int[8];

        // Pedir al usuario que ingrese los valores y almacenarlos en el array
        for (int i = 0; i < numeros.length; i++) {
        	int pos = i+1;
            System.out.print("Ingrese el número en la posición " + pos + ": ");
            numeros[i] = entrada.nextInt();
        }

        // Mostrar por consola el índice y el valor almacenado en esa posición
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Índice: " + i + ", Valor: " + numeros[i]);
        }
        entrada.close();
    }
}

