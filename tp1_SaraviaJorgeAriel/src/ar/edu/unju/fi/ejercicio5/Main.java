package ar.edu.unju.fi.ejercicio5;

import java.util.Scanner;

/**
 * Declare las variables necesarias para solicitar al usuario que ingrese por
 * consola un número entero que esté comprendido entre [1,9], mostrar por
 * consola la tabla de multiplicar correspondiente al número ingresado. (usar la
 * estructura de control iterativa for)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número entero entre 1 y 9:");
        int numero = scanner.nextInt();
        if (numero < 1 || numero > 9) {
            System.out.println("El número ingresado no está dentro del rango [1, 9].");
        } else {
            System.out.println("Tabla de multiplicar del " + numero + ":");
            for (int i = 0; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }
        }
        // Cerrar el Scanner
        scanner.close();
    }
}

