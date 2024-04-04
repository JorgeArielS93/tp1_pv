package ar.edu.unju.fi.ejercicio3;

import java.util.Scanner;

/**
 * Declare las variables necesarias para realizar lo siguiente:
 * Solicitar al usuario que ingrese por consola un número entero que debe ser almacenado en
 * una variable (Investigue como utilizar la clase Scanner para poder ingresar
 * datos por consola).
 * Si el número ingresado es impar mostrar el doble del número y si es par mostrar el triple del número.
 */
public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese un numero entero:");
		int num = entrada.nextInt();
		if (num % 2 == 0) {
			System.out.println("El numero " + num + " es PAR, el Triple es: " + num * 3);
		} else {
			System.out.println("El numero " + num + " es IMPAR, el Doble es: " + num * 2);
		}
		entrada.close();
	}

}
