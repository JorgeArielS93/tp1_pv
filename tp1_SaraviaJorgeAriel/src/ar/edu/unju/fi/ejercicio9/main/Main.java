package ar.edu.unju.fi.ejercicio9.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio9.model.Producto;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Producto[] productos = new Producto[3];

        for (int i = 0; i < productos.length; i++) {
            productos[i] = new Producto();
            System.out.println("Ingrese los datos para el producto " + (i + 1) + ":");

            System.out.print("Nombre: ");
            productos[i].setNombre(entrada.nextLine());

            System.out.print("Código: ");
            productos[i].setCodigo(entrada.nextLine());

            System.out.print("Precio: ");
            productos[i].setPrecio(entrada.nextDouble());

            System.out.print("Descuento: ");
            productos[i].setDescuento(entrada.nextInt());
            entrada.nextLine(); // limpiar basura

            System.out.println("Producto " + (i + 1) + " creado con éxito.\n");
        }

        mostrarProductos(productos);
    }

    public static void mostrarProductos(Producto[] productos) {
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto " + (i + 1) + ":");
            System.out.println("Nombre: " + productos[i].getNombre());
            System.out.println("Código: " + productos[i].getCodigo());
            System.out.println("Precio: " + productos[i].getPrecio());
            System.out.println("Descuento: " + productos[i].getDescuento());
            System.out.println("Precio con descuento: " + productos[i].calcularDescuento());
            System.out.println();
        }
    }
}
