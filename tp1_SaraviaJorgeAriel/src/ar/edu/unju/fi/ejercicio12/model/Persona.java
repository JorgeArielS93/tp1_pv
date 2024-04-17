package ar.edu.unju.fi.ejercicio12.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Persona {
	private String nombre;
	private Calendar fechaNacimiento;

	

	public Persona() {
	}

	public Persona(String persona, Calendar fechaNacimiento) {
		super();
		this.nombre = persona;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String persona) {
		this.nombre = persona;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [persona=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public int edad() {
		Calendar hoy = GregorianCalendar.getInstance();
		int edad = hoy.get(Calendar.YEAR) - this.fechaNacimiento.get(Calendar.YEAR);
		// Si aún no ha cumplido años en el año actual, restamos 1 a la edad
		if (hoy.get(Calendar.MONTH) < fechaNacimiento.get(Calendar.MONTH)
				|| (hoy.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)
						&& hoy.get(Calendar.DAY_OF_MONTH) < fechaNacimiento.get(Calendar.DAY_OF_MONTH))) {
			edad--;
		}

		return edad;
	}

	public String signoZodiacal() {
	    int mes = fechaNacimiento.get(Calendar.MONTH) + 1; // Sumamos 1 para ajustar el índice del mes
	    int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
	    String signo = "";

	    if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
	        signo = "Aries";
	    } else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
	        signo = "Tauro";
	    } else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
	        signo = "Géminis";
	    } else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
	        signo = "Cáncer";
	    } else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
	        signo = "Leo";
	    } else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
	        signo = "Virgo";
	    } else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
	        signo = "Libra";
	    } else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
	        signo = "Escorpio";
	    } else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
	        signo = "Sagitario";
	    } else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
	        signo = "Capricornio";
	    } else if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
	        signo = "Acuario";
	    } else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) {
	        signo = "Piscis";
	    } else {
	        signo = "Fecha de nacimiento inválida";
	    }
	    return signo;
	}


	public String determinarEstacion() {
	    int mes = fechaNacimiento.get(Calendar.MONTH) + 1; // Ajustamos el mes porque Calendar.MONTH comienza desde 0
	    int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);
	    String estacion;

	    if (mes == 1 || mes == 2) {
	        estacion = "Verano";
	    } else if (mes == 3) {
	        if (dia < 21)
	            estacion = "Verano";
	        else
	            estacion = "Otoño";
	    } else if (mes >= 4 && mes <= 5) {
	        estacion = "Otoño";
	    } else if (mes == 6) {
	        if (dia < 21)
	            estacion = "Otoño";
	        else
	            estacion = "Invierno";
	    } else if (mes >= 7 && mes <= 8) {
	        estacion = "Invierno";
	    } else if (mes == 9) {
	        if (dia < 23)
	            estacion = "Invierno";
	        else
	            estacion = "Primavera";
	    } else if (mes >= 10 && mes <= 11) {
	        estacion = "Primavera";
	    } else if (mes == 12) {
	        if (dia < 21)
	            estacion = "Primavera";
	        else
	            estacion = "Verano";
	    } else {
	        estacion = "Fecha de nacimiento inválida";
	    }

	    return estacion;
	}

}
