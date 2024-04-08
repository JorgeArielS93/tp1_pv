package ar.edu.unju.fi.ejercicio6.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	private Integer dni;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String provincia;

	public Persona() {

	}

	public Persona(Integer dni, String nombre, LocalDate fechaNacimiento, String provincia) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = provincia;
	}
	

	public Persona(Integer dni, String nombre, LocalDate fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.provincia = "Jujuy";
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		String mensajeEdad;
		if (esMayorDeEdad()) {
			mensajeEdad = "La persona es mayor de edad";
		} else {
			mensajeEdad = "La persona no es mayor de edad";
		}

		return "Persona dni=" + dni + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", provincia="
				+ provincia + ", edad=" + calcularEdad() + ", " + mensajeEdad;
	}

	public int calcularEdad() {
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, fechaActual);
		return periodo.getYears();
	}

	public boolean esMayorDeEdad() {
		return calcularEdad() >= 18;
	}

}
