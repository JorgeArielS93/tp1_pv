package ar.edu.unju.fi.ejercicio2;

/**
 * Declare variables que permitan almacenar los siguientes datos en el lenguaje Java: 
 * + El nombre de un país. 
 * + La edad de una persona. 
 * + La altura de un edificio. 
 * + El precio de un producto de supermercado.
 * + Número de teléfono. 
 * + El cálculo de coseno de 0.5 
 * Asigne valores a cada variable y muéstrelas por consola.
 */
public class Main {
	
	static String nombrePais = "Argentina PAPÁÁÁ!!!";
	static int edad = 96, telefono = 4237700;
	static double altura = 20.5, precio = 200.99;
	static double coseno = Math.cos(0.5);

	public static void main(String[] args) {
		mostrarDatos();
	}
	
	public static void mostrarDatos() {
		System.out.println("Nombre del Pais: " + nombrePais + "\nEdad: " + edad + " años" + "\nTelefono: " + telefono
				+ "\nAltura de Edificio: " + altura + " m2" + "\nPrecio: " + precio +"$"+ "\nCoseno de 0.5: " + coseno);
	}

}
