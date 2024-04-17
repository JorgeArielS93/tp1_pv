package ar.edu.unju.fi.ejercicio16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Defino y creo un array para almacenar 5 elementos de tipo String
        String[] nombres = new String[5];

        // Pido al usuario que ingrese nombres para almacenarlos en el arreglo
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el nombre de la persona " + (i + 1) + ": ");
            nombres[i] = entrada.nextLine();
        }

        // Mostro los valores guardados en el array
        System.out.println("\nValores guardados en el array:");
        int j = 0;
        while (j < nombres.length) {
            System.out.println("Nombre " + (j + 1) + ": " + nombres[j]);
            j++;
        }

        // Mostrar el tamaño del array
        System.out.println("\nTamaño del array: " + nombres.length);

        // Solicito al usuario que ingrese un índice para eliminar un elemento del arreglo
        int indice;
        do {
            System.out.print("\nIngrese el índice del elemento a eliminar (entre 0 y " + (nombres.length - 1) + "): ");
            indice = entrada.nextByte();
        } while (indice < 0 || indice >= nombres.length);

        // Eliminar el elemento del arreglo y desplazar los otros elementos si es necesario
        for (int i = indice; i < nombres.length - 1; i++) {
            nombres[i] = nombres[i + 1];
        }
        nombres[nombres.length - 1] = ""; // Asignar un espacio en blanco para eliminar el último elemento

        // Mostrar el arreglo después de eliminar el elemento
        System.out.println("\nArreglo después de eliminar el elemento:");
        for (String nombre : nombres) {
            System.out.println("Nombre: " + nombre);
        }
        entrada.close();
    }
}

