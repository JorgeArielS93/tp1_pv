package ar.edu.unju.fi.ejercicio8.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio8.model.CalculadoraEspecial;

public class Main {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
        System.out.print("Por favor, ingrese el valor de n: ");
        int n = entrada.nextInt();

        CalculadoraEspecial calculadora = new CalculadoraEspecial(n);

        int sumatoria = calculadora.calcularSumatoria(n);
        System.out.println("El resultado de la sumatoria es: " + sumatoria);

        int productoria = calculadora.calcularProductoria(n);
        System.out.println("El resultado de la productoria es: " + productoria);
        entrada.close();
	}

}
