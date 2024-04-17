package ar.edu.unju.fi.ejercicio17.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio17.model.Jugador;

public class Main {
	private static ArrayList<Jugador> jugadores = new ArrayList<>();
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		int opc;
		jugadores.addAll(cargarJugadores());
		do {
			mostrarMenu();
			opc = entrada.nextInt();
			entrada.nextLine(); // Limpiar la basura del buffer
			switch (opc) {
			case 1:
				altaJugador();
				break;
			case 2:
				mostrarDatosJugador();
				break;
			case 3:
				mostrarJugadoresOrdenados();
				break;
			case 4:
				modificarJugador();
				break;
			case 5:
				eliminarJugador();
				break;
			case 6:
				mostrarCantidadTotalJugadores();
				break;
			case 7:
				mostrarCantidadPorNacionalidad();
				break;
			case 8:
				System.out.println("Eligio Salir, saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida, por favor ingrese un número del 1 al 8.");
			}
		} while (opc != 8);

		entrada.close();
	}

	public static void mostrarMenu() {
		System.out.println("\nMenú de opciones:");
		System.out.println("1 - Alta de jugador");
		System.out.println("2 - Mostrar los datos del jugador");
		System.out.println("3 - Mostrar todos los jugadores ordenados por apellido");
		System.out.println("4 - Modificar los datos de un jugador");
		System.out.println("5 - Eliminar un jugador");
		System.out.println("6 - Mostrar la cantidad total de jugadores");
		System.out.println("7 - Mostrar la cantidad de jugadores que pertenecen a una nacionalidad");
		System.out.println("8 - Salir");
		System.out.print("Ingrese su opción: ");
	}

	private static void altaJugador() {
	    System.out.println("Alta de jugador:");
	    try {
	        System.out.print("Ingrese el nombre: ");
	        String nombre = entrada.nextLine();
	        System.out.print("Ingrese el apellido: ");
	        String apellido = entrada.nextLine();
	        System.out.println("Ingrese la fecha de nacimiento d/M/yyyy :");
	        String fechaNacimientoStr = entrada.nextLine();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
	        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
	        System.out.print("Ingrese la nacionalidad: ");
	        String nacionalidad = entrada.nextLine();
	        System.out.print("Ingrese la estatura (en metros): ");
	        double estatura = entrada.nextDouble();
	        System.out.print("Ingrese el peso (en kilogramos): ");
	        double peso = entrada.nextDouble();
	        entrada.nextLine(); // Limpiar basura del buffer
	        System.out.print("Ingrese la posición (delantero, medio, defensa, arquero): ");
	        String posicion = entrada.nextLine();

	        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
	        jugadores.add(jugador);
	        System.out.println("Jugador agregado correctamente.");
	    } catch (DateTimeParseException e) {
	        System.out.println("Error al ingresar la fecha de nacimiento. Formato incorrecto.");
	    } catch (InputMismatchException e) {
	        System.out.println("Error al ingresar la estatura o el peso. Formato incorrecto.");
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error inesperado: " + e.getMessage());
	    } finally {
	        entrada.nextLine(); // Limpiar basura del buffer en caso de excepción
	    }
	}


	private static void mostrarDatosJugador() {
	    System.out.println("Mostrar los datos del jugador:");
	    try {
	        System.out.print("Ingrese el nombre: ");
	        String nombre = entrada.nextLine();
	        System.out.print("Ingrese el apellido: ");
	        String apellido = entrada.nextLine();
	        boolean jugadorEncontrado = false;
	        for (Jugador jugador : jugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                System.out.println("\nNombre: " + jugador.getNombre());
	                System.out.println("Apellido: " + jugador.getApellido());
	                System.out.println("Fecha de nacimiento: " + jugador.getFechaNacimiento());
	                System.out.println("Nacionalidad: " + jugador.getNacionalidad());
	                System.out.println("Estatura: " + jugador.getEstatura() + " metros");
	                System.out.println("Peso: " + jugador.getPeso() + " kilogramos");
	                System.out.println("Posición: " + jugador.getPosicion());
	                System.out.println("Edad: " + jugador.calcularEdad() + " años");
	                jugadorEncontrado = true;
	                break; // Salir del bucle una vez que se encuentra el jugador
	            }
	        }
	        if (!jugadorEncontrado) {
	            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
	        }
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error al mostrar los datos del jugador: " + e.getMessage());
	    } finally {
	        entrada.nextLine(); // Limpiar basura del buffer
	    }
	}


	private static void mostrarJugadoresOrdenados() {
		System.out.println("Mostrar todos los jugadores ordenados por apellido:");
		jugadores.sort(Comparator.comparing(Jugador::getApellido));
		for (Jugador jugador : jugadores) {
			System.out.println("Nombre: " + jugador.getNombre() + " " + jugador.getApellido());
		}
	}

	private static void modificarJugador() {
	    System.out.println("Modificar los datos de un jugador:");
	    try {
	        System.out.print("Ingrese el nombre: ");
	        String nombre = entrada.nextLine();
	        System.out.print("Ingrese el apellido: ");
	        String apellido = entrada.nextLine();

	        boolean jugadorEncontrado = false;
	        for (Jugador jugador : jugadores) {
	            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
	                System.out.println("Ingrese los nuevos datos:");
	                System.out.print("Nuevo nombre: ");
	                jugador.setNombre(entrada.nextLine());
	                System.out.print("Nuevo apellido: ");
	                jugador.setApellido(entrada.nextLine());
	                System.out.println("Ingrese la fecha de nacimiento d/M/yyyy :");
	                String fechaNacimientoStr = entrada.nextLine();
	                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
	                LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
	                jugador.setFechaNacimiento(fechaNacimiento);
	                System.out.print("Nueva nacionalidad: ");
	                jugador.setNacionalidad(entrada.nextLine());
	                System.out.print("Nueva estatura (en metros): ");
	                jugador.setEstatura(entrada.nextDouble());
	                System.out.print("Nuevo peso (en kilogramos): ");
	                jugador.setPeso(entrada.nextDouble());
	                entrada.nextLine(); // Limpiar la basura del buffer
	                System.out.print("Nueva posición (delantero, medio, defensa, arquero): ");
	                jugador.setPosicion(entrada.nextLine());
	                System.out.println("Datos modificados correctamente.");
	                jugadorEncontrado = true;
	                break; // Salir del bucle una vez que se encuentra y modifica el jugador
	            }
	        }
	        if (!jugadorEncontrado) {
	            System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
	        }
	    } catch (Exception e) {
	        System.out.println("Ocurrió un error al modificar los datos del jugador: " + e.getMessage());
	    } finally {
	        entrada.nextLine(); // Limpiar residuos del bufer
	    }
	}


	private static void eliminarJugador() {
		System.out.println("Eliminar un jugador:");
		System.out.print("Ingrese el nombre: ");
		String nombre = entrada.nextLine();
		System.out.print("Ingrese el apellido: ");
		String apellido = entrada.nextLine();
		
		boolean jugadorEncontrado = false;
		Iterator<Jugador> iterador = jugadores.iterator();
		while (iterador.hasNext()) {
			Jugador jugador = iterador.next();
			if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
				iterador.remove();
				System.out.println("Jugador eliminado correctamente.");
				jugadorEncontrado = true;
				break; // Salir del bucle una vez que se encuentra el jugador
			}
		}
		if (!jugadorEncontrado) {
		    System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
		}
	}

	private static void mostrarCantidadTotalJugadores() {
		System.out.println("Cantidad total de jugadores: " + jugadores.size());
	}

	private static void mostrarCantidadPorNacionalidad() {
		System.out.print("Ingrese la nacionalidad: ");
		String nacionalidad = entrada.nextLine();
		int cantidad = 0;
		for (Jugador jugador : jugadores) {
			if (jugador.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
				cantidad++;
			}
		}
		System.out.println("Cantidad de jugadores de la nacionalidad '" + nacionalidad + "': " + cantidad);
	}

	private static ArrayList<Jugador> cargarJugadores() {
		ArrayList<Jugador> jugadores = new ArrayList<>();
		
		Jugador jugador1 = new Jugador("Juan", "Pérez", LocalDate.of(1990, 1, 15), "Argentina", 1.75, 70, "Delantero");
		jugadores.add(jugador1);

		Jugador jugador2 = new Jugador("Luis", "González", LocalDate.of(1995, 5, 25), "Uruguay", 1.80, 75, "Defensa");
		jugadores.add(jugador2);

		Jugador jugador3 = new Jugador("Carlos", "Martínez", LocalDate.of(1992, 9, 10), "Chile", 1.70, 68, "Medio");
		jugadores.add(jugador3);

		return jugadores;
	}
}
