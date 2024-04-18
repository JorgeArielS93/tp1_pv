package ar.edu.unju.fi.ejercicio18.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio18.model.DestinoTuristico;
import ar.edu.unju.fi.ejercicio18.model.Pais;

public class Main {
	public static List<DestinoTuristico> destinosTuristicos = new ArrayList<>();
	public static List<Pais> paises = new ArrayList<>();
	public static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// Precarga de paises
		precargarPaises();
		precargarDestinosTuristicos();

		int opc;
		do {
			mostrarMenu();
			opc = entrada.nextInt();
			entrada.nextLine(); // Limpiar el buffer

			switch (opc) {
			case 1:
				altaDestinoTuristico();
				break;
			case 2:
				mostrarDestinosTuristicos();
				break;
			case 3:
				modificarPaisDestino();
				break;
			case 4:
				limpiarDestinosTuristicos();
				break;
			case 5:
				eliminarDestinoTuristico();
				break;
			case 6:
				mostrarDestinosTuristicosOrdenados();
				break;
			case 7:
				mostrarPaises();
				break;
			case 8:
				mostrarDestinosPorPais();
				break;
			case 9:
				System.out.println("Eligió Salir, saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida, por favor ingrese un número del 1 al 9.");
			}
		} while (opc != 9);

		entrada.close();
	}

	public static void mostrarMenu() {
		System.out.println("\nMenú de opciones:");
		System.out.println("1 - Alta de destino turístico");
		System.out.println("2 - Mostrar todos los destinos turísticos");
		System.out.println("3 - Modificar el país de un destino turístico");
		System.out.println("4 - Limpiar el ArrayList de destinos turísticos");
		System.out.println("5 - Eliminar un destino turístico");
		System.out.println("6 - Mostrar los destinos turísticos ordenados por nombre");
		System.out.println("7 - Mostrar todos los países");
		System.out.println("8 - Mostrar los destinos turísticos que pertenecen a un país");
		System.out.println("9 - Salir");
		System.out.print("Ingrese su opción: ");
	}

	public static void precargarPaises() {
		paises.add(new Pais("ESP", "España"));
		paises.add(new Pais("FRA", "Francia"));
		paises.add(new Pais("USA", "Estados Unidos"));
		paises.add(new Pais("ITA", "Italia"));
		paises.add(new Pais("CHN", "China"));
		paises.add(new Pais("MEX", "México"));
		paises.add(new Pais("TUR", "Turquía"));
		paises.add(new Pais("DEU", "Alemania"));
		paises.add(new Pais("THA", "Tailandia"));
		paises.add(new Pais("GBR", "Reino Unido"));
		paises.add(new Pais("ARG", "Argentina"));
	}

	public static void altaDestinoTuristico() {
		try {
			System.out.println("\nAlta destino Turistico:");
			System.out.print("Ingrese el codigo: ");
			String codigo = entrada.nextLine();
			System.out.print("Ingrese el nombre: ");
			String nombre = entrada.nextLine();
			System.out.print("Ingrese el Precio");
			double precio = entrada.nextDouble();
			entrada.nextLine(); // Limpiar basura del buffer

			System.out.println("\nIngrese el país (código) \n");
			for (Pais pais : paises) {
				System.out.println(pais.getCodigo()+"  "+pais.getNombre());
			}
			System.out.print("\nIngrese el codigo correspondiente:");
			
			String codigoPais = entrada.nextLine();
			Pais pais = null;
			// Busco el país en la lista de países
			for (Pais p : paises) {
				if (p.getCodigo().equalsIgnoreCase(codigoPais)) {
					pais = p;
					break;
				}
			}

			if (pais != null) {
				System.out.print("Ingrese la cantidad de días: ");
				int cantidadDias = entrada.nextInt();
				entrada.nextLine(); // Limpiar basura del buffer

				DestinoTuristico destino = new DestinoTuristico(codigo, nombre, precio, pais, cantidadDias);
				destinosTuristicos.add(destino);
				System.out.println("Destino turístico agregado correctamente.");
			} else {
				System.out.println("El país no existe. No se pudo agregar el destino turístico.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Error: Se esperaba un valor numérico para el precio o la cantidad de días.");
			entrada.nextLine(); // Limpiar basura del buffer
		} catch (NoSuchElementException e) {
			System.out.println("Error: No se pudo leer la entrada del usuario.");
		} catch (Exception e) {
			System.out.println("Error desconocido: " + e.getMessage());
		} finally {
			entrada.nextLine(); // Limpiar basura del buffer
		}
	}

	public static void mostrarDestinosTuristicos() {
		System.out.println("\nDestinos Turisticos:\n");

		if (destinosTuristicos.isEmpty()) {
			System.out.println("No hay destinos turisticos cargados.");
		} else {
			for (DestinoTuristico destinoTuristico : destinosTuristicos) {
				System.out.println("codigo:"+destinoTuristico.getCodigo()+"  "+destinoTuristico.getNombre());
			}

		}
	}

	public static void modificarPaisDestino() {
	    try {
	        System.out.println("\nModificar los datos de un destino turístico:\n");
	        System.out.print("Ingrese el código del destino turístico: ");
	        String codigo = entrada.nextLine();
	        boolean destinoEncontrado = false;
	        for (DestinoTuristico destinoTuristico : destinosTuristicos) {
	            if (destinoTuristico.getCodigo().equalsIgnoreCase(codigo)) {
	                destinoEncontrado = true;
	                System.out.println("\nModificar el país del destino turístico:\n");
	                System.out.print("Ingrese el país (código): ");
	                String codigoPais = entrada.nextLine();
	                Pais pais = null;
	                // Buscar el país en la lista de países
	                for (Pais p : paises) {
	                    if (p.getCodigo().equalsIgnoreCase(codigoPais)) {
	                        pais = p;
	                        break;
	                    }
	                }

	                if (pais != null) {
	                    destinoTuristico.setPais(pais);
	                    System.out.println("País del destino turístico modificado correctamente.");
	                } else {
	                    System.out.println("El país no existe. No se pudo modificar el destino turístico.");
	                }
	            }
	        }

	        if (!destinoEncontrado) {
	            System.out.println("No se encontró ningún destino turístico con ese código.");
	        }
	    } catch (InputMismatchException e) {
	        System.out.println("Error: Se esperaba un tipo de dato específico.");
	    } catch (NoSuchElementException e) {
	        System.out.println("Error: No se pudo encontrar el elemento solicitado.");
	    } catch (Exception e) {
	        System.out.println("Error inesperado: " + e.getMessage());
	    } finally {
	        entrada.nextLine(); // Limpiar el buffer de entrada
	    }
	}


	public static void limpiarDestinosTuristicos() {
		destinosTuristicos.clear();
		System.out.println("\nSe han borrado todos  los destinos turisticos.\n");
	}

	public static void eliminarDestinoTuristico() {
	    try {
	        System.out.println("\nEliminar un destino turístico:\n");
	        System.out.print("Ingrese el código del destino turístico: ");
	        String codigo = entrada.nextLine();
	        boolean destinoEncontrado = false;
	        Iterator<DestinoTuristico> iterador = destinosTuristicos.iterator();
	        while (iterador.hasNext()) {
	            DestinoTuristico destinoTuristico = iterador.next();
	            if (destinoTuristico.getCodigo().equalsIgnoreCase(codigo)) {
	                iterador.remove();
	                System.out.println("Destino turístico eliminado correctamente.");
	                destinoEncontrado = true;
	                break; // Salir del bucle una vez que se encuentra el destino turístico
	            }
	        }
	        if (!destinoEncontrado) {
	            System.out.println(
	                    "No se puede eliminar el destino turístico, no se encontró ningún destino turístico con ese código.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Error: No se encontró el código del destino turístico.");
	    } catch (Exception e) {
	        System.out.println("Error inesperado: " + e.getMessage());
	    } 
	}
	public static void mostrarDestinosTuristicosOrdenados() {
		System.out.println("\nMostrar todos los Destinos Turisticos ordenados por apellido:\n");
		destinosTuristicos.sort(Comparator.comparing(DestinoTuristico::getNombre));
		for (DestinoTuristico destinoTuristico : destinosTuristicos) {
			System.out.println("codigo: "+destinoTuristico.getCodigo()+"  "+destinoTuristico.getNombre());
		}
	}

	public static void mostrarPaises() {
		System.out.println("\nPaises con destinos turisticos:\n");
		for (Pais pais : paises) {
			System.out.println("Codigo: "+pais.getCodigo()+"  Nombre: "+ pais.getNombre());
		}
	}

	public static void mostrarDestinosPorPais() {
		System.out.println("\nDestinos turísticos que pertenecen a un país");
		System.out.print("Ingrese el codigo del pais:");
		String codPais=entrada.nextLine();
		boolean paisEncontrado = false;
		for (DestinoTuristico destinoTuristico : destinosTuristicos) {
			if (destinoTuristico.getPais().getCodigo().equalsIgnoreCase(codPais)) {
				System.out.println(destinoTuristico.getPais().getNombre()+"  "+destinoTuristico.getNombre());
				paisEncontrado=true;
			}
		}
		if (!paisEncontrado) {
            System.out.println("No se encontró ningún destino turistico con ese Pais.");
        }
	}

	public static void precargarDestinosTuristicos() {
		// Precarga de destinos turísticos
		Pais pais1 = new Pais("ITA", "Italia");
		Pais pais2 = new Pais("ARG", "Argentina");
		Pais pais3 = new Pais("ESP", "España");

		DestinoTuristico destino1 = new DestinoTuristico("DT1", "Roma", 500.0, pais1, 5);
		DestinoTuristico destino2 = new DestinoTuristico("DT2", "Yapeyu", 700.0, pais2, 7);
		DestinoTuristico destino3 = new DestinoTuristico("DT3", "Barcelona", 600.0, pais3, 6);
		DestinoTuristico destino4 = new DestinoTuristico("DT4", "Jujuy", 900.0, pais2, 9);

		destinosTuristicos.add(destino1);
		destinosTuristicos.add(destino2);
		destinosTuristicos.add(destino3);
		destinosTuristicos.add(destino4);
	}

}