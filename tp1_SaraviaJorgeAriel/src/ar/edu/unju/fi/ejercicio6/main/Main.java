package ar.edu.unju.fi.ejercicio6.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio6.model.Persona;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		//persona creada con el constructor por defecto 
		Persona persona= new Persona();
		persona=ingresarDatosPersona();
		//persona creado con el constructor parametrizado
		Persona persona2= ingresarDatosPersona();
		// persona creada con provincia de Jujuy
		Persona persona3=ingresarDatosPersonaSP();
		mostrarDatos(persona);
		mostrarDatos(persona2);
		mostrarDatos(persona3);
		
	}
	
	public static Persona ingresarDatosPersona() {
        // Solicitar los datos
        System.out.println("Ingrese el DNI:");
        int dni = scanner.nextInt();
        scanner.nextLine(); // limpiar basura

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento d/M/yyyy :");
        String fechaNacimientoStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

        System.out.println("Ingrese la provincia:");
        String provincia = scanner.nextLine();

        // Crear una instancia de Persona con los datos ingresados
        Persona persona = new Persona(dni, nombre, fechaNacimiento, provincia);
        return persona;
    }
	
	public static Persona ingresarDatosPersonaSP() {
        // Solicitar los datos
        System.out.println("Ingrese el DNI:");
        int dni = scanner.nextInt();
        scanner.nextLine(); // limpiar basura

        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento d/M/yyyy :");
        String fechaNacimientoStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);

        // Crear una instancia de Persona con los datos ingresados
        Persona persona = new Persona(dni, nombre, fechaNacimiento);
        return persona;
    }
	
	public static void mostrarDatos(Persona persona) {
		System.out.println(persona.toString());
	}
	
}
