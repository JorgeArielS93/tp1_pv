package ar.edu.unju.fi.ejercicio1;

/**
 * Declare 5 variables de tipo entero para almacenar valores numéricos. Asigne
 * valores numéricos a cada una de las variables. Calcule el promedio y guarde
 * el resultado en otra variable. Muestre por consola el resultado obtenido.
 * Ejemplo: 8, 5, 1, 20, 9 El promedio es: 8.6
 */
public class Main {

	public static void main(String[] args) {
		int num1 = 9;
		int num2 = 7;
		int num3 = 6;
		int num4 = 4;
		int num5 = 3;
		double promedio=(double)(num1 + num2 + num3 + num4 + num5) / 5;
		System.out.println("El Promedio es: " + promedio);
	}

}
