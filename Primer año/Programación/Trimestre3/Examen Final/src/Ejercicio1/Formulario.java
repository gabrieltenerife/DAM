package Ejercicio1;

import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String array [] = new String [3];
		String nombre=null, apellido=null, dni=null;
		int opcion;
		boolean salir = false;
		
		//Cada caso del menu recoge el dato y lo introduce en el lugar correspondiente del array
		/*
		 * En el caso 4 comprueba el si el array se encuentra lleno con el metodo correspondiente, explicado mas abajo, 
		 * en caso de que se encuentre completo el boolean salir se pondra en true, que finaliza el bucle 
		 * imprime los datos con el metodo mostrardatos explicado mas adelante y cierra el programa.
		 * En caso contrario se llamara al metodo que indica que campos se encuetran vacios, explicado mas abajo.
		 */
		do {
			System.out.println("Introduce una opcion");
			mostarmenu();
			opcion = sc.nextInt();
			switch(opcion) {
				case 1:
					System.out.println("Introduce tu nombre");
					nombre = sc.next();
					nombrein(array, nombre);
					break;
				case 2:
					System.out.println("Introduce tu apellido");
					apellido = sc.next();
					apellidoin(array,apellido);
					break;
				case 3:
					System.out.println("Introduce tu dni");
					dni = sc.next();
					dniin(array,dni);
					break;
				case 4:
					if(comprobarllenado(array)) {
						System.out.println("Formulario completado");
						mostrardatos(nombre, apellido, dni);
						salir = true;
					}
					else {comprobarvacios(array);}
					break;
			}
		}while(salir==false);
	}
	
	//Este metodo muestra el menu
	public static void mostarmenu () {
		System.out.println("1. Introducir nombre");
		System.out.println("2. Introducir apellido");
		System.out.println("3. Introducir DNI");
		System.out.println("4. Finalizar");
		
	//Los siguientes metodos recogen e introducen cada uno de los datos en una posicion del array
	}
	public static void nombrein (String array [], String nombre) {
		array[0] = nombre;
	}
	public static void apellidoin (String array [], String apellido) {
		array[1] = apellido;
	}
	public static void dniin (String array [], String dni) {
		array[2] = dni;
	}
	
	//Este metodo comprueba si existe algun campo vacio en el array
	public static boolean comprobarllenado(String array []) {
		boolean lleno = true;
		for(int i=0;i<array.length;i++) {
			if(array[i]==null) {
				lleno = false;
			}
		}
		return lleno;
	}
	
	//Este metodo te indica que campos estan vacios en el array
	public static void comprobarvacios(String array []) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==null) {
				if(i==0) {System.out.println("El campo nombre esta vacio");}
				else if (i==1) {System.out.println("El campo apellido esta vacio");}
				else {System.out.println("El campo DNI esta vacio");} 
			}
		}	
		System.out.println("Complete los campos antes de continuar");
		System.out.println("--------------------------------------");
	}
	
	//Imprime los datos en pantalla
	public static void mostrardatos(String nombre, String apellido, String dni) {
		System.out.println("Su nombre es: " +nombre+ " su apellido es: " +apellido+ " su DNI es: " +dni);
	}
}
