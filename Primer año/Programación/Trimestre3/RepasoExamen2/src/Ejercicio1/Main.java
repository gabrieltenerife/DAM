package Ejercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exepciones {
		
		int menu, menure;
		boolean salir = false;
		String array [] = new String [3];
		Scanner sc = new Scanner(System.in);
		String usuario="0", contraseña="0", dni="0";
		
		do {
		mostrarmenu();
		 menu = sc.nextInt();
		switch(menu) {
		case 1:
			if(array [0]==null) {
				usuario(usuario, sc, array);
			}else {
				menureintroducir();
				menure = sc.nextInt();
				switch(menure) {
					case 1:
						usuario(usuario, sc, array);
						break;
					default: System.out.println("Introduzca el siguiente dato");
						break;
				}
			}
			break;
		case 2:
			if(array [1]==null) {
				contraseña(contraseña, sc, array);
			}else {
				menureintroducir();
				menure = sc.nextInt();
				switch(menure) {
					case 1:
						contraseña(contraseña, sc, array);
						break;
					default: System.out.println("Introduzca el siguiente dato");
						break;
				}
			}
			break;
		case 3:
			if(array [2]==null) {
				dni(dni, sc, array);
			}else {
				menureintroducir();
				menure = sc.nextInt();
				switch(menure) {
					case 1:
						dni(dni, sc, array);
						break;
					default: System.out.println("Introduzca el siguiente dato");
						break;
				}
			}
			break;
		case 4:
			if(!comprobar(array)) {
				System.out.println("Guardado correctamente");
				System.out.println("Usuario: " + array[0]);
				System.out.println("Contraseña: " + array[1]);
				System.out.println("DNI: " + array[2]);
				salir = true;
			} else {System.out.println("Rellene todos los campos antes de finalizar");}
			break;
		}
		}while(!salir);
	}


	public static void mostrarmenu() {
		System.out.println("1. Rellenar Usuario");
		System.out.println("2. Rellenar Contraseña");
		System.out.println("3. Rellenar DNI");
		System.out.println("4. Finalizar");
	}
	
	public static void menureintroducir() {
		System.out.println("1. Reintroducir");
		System.out.println("2. Salir");
	}
	
	
	public static void usuario(String usuario, Scanner sc, String [] array) {
			System.out.println("Introduzca un usuario:");
			usuario = sc.next();
			array [0] = usuario;
	}
	
	public static void contraseña(String contraseña, Scanner sc, String [] array) {
			System.out.println("Introduzca una contraseña:");
			contraseña = sc.next();
			array [1] = contraseña;
					
	}
	
	public static void dni(String dni, Scanner sc, String [] array) throws Exepciones {
			do {
			System.out.println("Introduzca un dni:");
			dni = sc.next();
			try {
			if(dni.length()!=9) throw new Exepciones ("LongitudDNINoValidaException");
			}
			catch (Exepciones e) {
				System.out.println("Error: " + e.getMessage());
			}
			}while(dni.length()!=9);
			
			try {
			char letra = dni.charAt(8);
			if(!Character.isLetter(letra)) throw new Exepciones ("UltimoDigitoNoLetraException");
			array [2] = dni;
			}
			catch(Exepciones e) {
				System.out.println("Error :" + e.getMessage());
			}
	}
	
	public static boolean comprobar(String [] array) {
		boolean vacio = false;
		for(int i=0; i<array.length;i++) {
			if(array[i] == null) {
				vacio = true;
			}
		}
		return vacio;
	}
}