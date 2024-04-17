package ar.edu.unju.fi.ejercicio12.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio12.model.Persona;

public class Main {
	public static DateFormat formateador = new SimpleDateFormat("d/M/yyyy");

	public static void main(String[] args) {
		Persona persona = ingresarDatos();
		mostrarDatos(persona);
		
	}

	public static Calendar parsearFecha(String fechaStr) {

		/**
		 * creo un objeto Calendar llamado fechaNacimiento utilizando
		 * Calendar.getInstance(). Este objeto se utilizará para almacenar la fecha de
		 * nacimiento después de ser parseada. Al llamar a getInstance(), obtenemos una
		 * instancia de Calendar que representa la fecha y hora actuales. Luego, vamos a
		 * modificar esta instancia para establecer la fecha de nacimiento.
		 */
		Calendar fechaNacimiento = Calendar.getInstance();

		try {
			fechaNacimiento.setTime(formateador.parse(fechaStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return fechaNacimiento;
	}

	public static Persona ingresarDatos() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre: ");
		String nombre = entrada.nextLine();
		System.out.print("Ingrese su fecha de nacimiento (d/m/YYYY): ");
		String fechaNacimientoStr = entrada.nextLine();

		// Parsear la fecha de nacimiento
		Calendar fechaNacimiento = parsearFecha(fechaNacimientoStr);

		return new Persona(nombre, fechaNacimiento);
	}
	public static void mostrarDatos(Persona persona) {
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Fecha de nacimiento: " + formateador.format(persona.getFechaNacimiento().getTime()));
        System.out.println("Edad: " + persona.edad() + " años");
        System.out.println("Signo del zodiaco: " + persona.signoZodiacal());
        System.out.println("Estacion: "+ persona.determinarEstacion());
    }
}
