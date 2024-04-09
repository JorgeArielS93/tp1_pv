package ar.edu.unju.fi.ejercicio7.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio7.model.Empleado;

public class Main {

	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		// Crear una instancia de Empleado
		Empleado empleado = ingresarDatosEmpleado();

		// Mostrar el salario actual
		System.out.println("Salario antes del aumento: $" + empleado.getSalario());

		// Dar un aumento al salario
		empleado.darAumento();

		// Mostrar el salario después del aumento
		System.out.println("Salario después del aumento: $" + empleado.getSalario());
	}

	public static Empleado ingresarDatosEmpleado() {
        System.out.println("Ingrese el nombre:");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese el Legajo:");
        int legajo = entrada.nextInt();
        System.out.println("Ingrese el Sueldo:");
        double sueldo = entrada.nextDouble(); 
        entrada.nextLine(); // Limpiar basura
        return new Empleado(nombre, legajo, sueldo);
    }
}
