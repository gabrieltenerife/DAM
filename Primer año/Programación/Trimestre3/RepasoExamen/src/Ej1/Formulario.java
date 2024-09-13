package Ej1;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Formulario {

	public static void main(String[] args) {
		
		String array [] = new String [3];
		Scanner sc = new Scanner (System.in);
		int menu;
		String dato;
		boolean salir = false;
		
		do {
		System.out.println("Selecciona una opcion");
		mostrarmenu();
		menu = sc.nextInt();
		switch(menu) {
			case 1:
				System.out.println("Introduzca un usuario");
				dato = sc.next();
				introducirusuario(dato, array);
				break;
			case 2:
				System.out.println("Introduzca una contraseña");
				dato = sc.next();
				introducircontraseña(dato, array);
				break;
			case 3:
				System.out.println("Introduzca su DNI");
				dato = sc.next();
				introducirdni(dato, array);
				break;
			case 4:
				if(!comprobarrellenado(array)){
					System.out.println("Le falta algun dato por rellenar");
				}
				else {
					mostrarrelleno(array);
					salir = true;}
				break;
		}
		}while(salir != true);
		
		
	}
	
	public static void mostrarmenu() {
		System.out.println("1. Rellenar usuario");
		System.out.println("2. Rellenar contraseña");
		System.out.println("3. Rellenar DNI");
		System.out.println("4. Finalizar");
	}
	
	public static void introducirusuario (String dato, String [] array) {
		array [0] = dato;
	}
	
	public static void introducircontraseña (String dato, String [] array) {
		array [1] = dato;
	}
	
	public static void introducirdni (String dato, String [] array) {
		array [2] = dato;
	}
	
	public static boolean comprobarrellenado (String [] array) {
		boolean relleno = true;
		for(int i = 0; i<array.length; i++) {
			if(array[i] == null) {
				relleno = false;
			}
		}
		return relleno;
	}
	
	public static void mostrarrelleno (String [] array) {
		System.out.println("Su usuario es :" + array[0]);
		System.out.println("Su contraseña es :" + array[1]);
		System.out.println("Su dni es :" + array[2]);
	}
	
	
}
