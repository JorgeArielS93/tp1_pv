package ar.edu.unju.fi.ejercicio14;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		// Solicitar al usuario que ingrese un número en el rango [3, 10]
		int tamanioArray;
		do {
			System.out.print("Ingrese un número entero en el rango [3, 10]: ");
			tamanioArray = entrada.nextInt();
		} while (tamanioArray < 3 || tamanioArray > 10);

		// Crear un array de tamaño especificado por el usuario
		int[] numeros = new int[tamanioArray];

		// Solicitar al usuario que ingrese valores para el array
		
		for (int i = 0; i < tamanioArray; i++) {
			int pos = i+1;
			System.out.print("Ingrese un número entero para la posición " + pos + ": ");
			numeros[i] = entrada.nextInt();
		}

		// Mostrar el valor de cada posición del array
		System.out.println("Valores en el array:");
		for (int i = 0; i < tamanioArray; i++) {
			System.out.println("Posición " + i + ": " + numeros[i]);
		}

		// Calcular la suma de todos los valores en el array
		int suma = 0;
		for (int num : numeros) {
			suma += num;
		}

		System.out.println("Suma de todos los valores en el array: " + suma);
		entrada.close();
	}
}
