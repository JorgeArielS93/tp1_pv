package ar.edu.unju.fi.ejercicio10.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio10.model.Pizza;

public class Main {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			Pizza pizza = new Pizza();
			int diametro = obtenerDiametroValido(entrada, i);
			boolean ingredientesEspeciales = obtenerIngredientesEspecialesValidos(entrada, i);
			pizza.setDiametro(diametro);
			pizza.setIngredientesEspeciales(ingredientesEspeciales);
			pizza.calcularPrecio();
			pizza.calcularArea();
			mostrarInformacionPizza(i + 1, pizza);
		}
		entrada.close();
	}

	public static int obtenerDiametroValido(Scanner entrada, int numeroPizza) {
		int diametro;
		do {
			System.out.println("Ingrese el diámetro de la pizza " + (numeroPizza + 1) + ":");
			while (!entrada.hasNextInt()) {
				System.out.println("¡Error! Debe ingresar un número entero para el diámetro.");
				entrada.next();
			}
			diametro = entrada.nextInt();
			if (diametro != 20 && diametro != 30 && diametro != 40) {
				System.out.println("¡Error! El diámetro debe ser 20, 30 o 40.");
			}
		} while (diametro != 20 && diametro != 30 && diametro != 40);
		return diametro;
	}

	public static boolean obtenerIngredientesEspecialesValidos(Scanner entrada, int numeroPizza) {
		boolean ingredientesEspeciales;
		System.out.println("¿La pizza tiene ingredientes especiales? (true/false)");
		while (true) {
			String input = entrada.next().toLowerCase();
			if (input.equals("true") || input.equals("false")) {
				ingredientesEspeciales = Boolean.parseBoolean(input);
				break;
			} else {
				System.out.println(
						"¡Error! Debe ingresar 'true' o 'false' para indicar si la pizza tiene ingredientes especiales.");
			}
		}
		return ingredientesEspeciales;
	}

	public static void mostrarInformacionPizza(int numeroPizza, Pizza pizza) {
		System.out.println("** Pizza " + numeroPizza + " **");
		System.out.println("Diámetro = " + pizza.getDiametro());
		System.out.println("Ingredientes especiales = " + pizza.isIngredientesEspeciales());
		System.out.println("Precio Pizza = " + pizza.getPrecio() + "$");
		System.out.println("Área de la pizza = " + pizza.getArea());
	}
}