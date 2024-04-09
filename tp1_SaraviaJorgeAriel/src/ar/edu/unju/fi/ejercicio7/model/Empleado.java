package ar.edu.unju.fi.ejercicio7.model;

public class Empleado {
	private String nombre;
    private int legajo;
    private double salario;
	
	// Constantes
    public static final double SALARIO_MINIMO = 210000.00;
    public static final double AUMENTO_POR_MERITOS = 20000.00;
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

	public Empleado(String nombre, int legajo, double salario) {
		this.nombre = nombre;
		this.legajo = legajo;
		
		// Asignación del salario verificando si es mayor o igual al salario mínimo
		if (salario >= SALARIO_MINIMO) {
			this.salario = salario;
		} else {
			this.salario = SALARIO_MINIMO;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", legajo=" + legajo + ", salario=" + salario + "]";
	}
	
	 public void mostrarDatos() {
	        System.out.println("Nombre del empleado: " + nombre);
	        System.out.println("Legajo: " + legajo);
	        System.out.println("Salario $: " + String.format("%.2f", salario));
	    }
	 
	 public void darAumento() {
		    salario += AUMENTO_POR_MERITOS;
		}
	
}
