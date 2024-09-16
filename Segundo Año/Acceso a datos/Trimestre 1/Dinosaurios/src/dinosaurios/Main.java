package dinosaurios;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		ArrayList <Dinosaurio> dino = new ArrayList <Dinosaurio>();
		int opcion;
		
		
		menu();
		opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			
			break;
		case 2:
			break;
		case 3:
			break;
		}

	}
	
	//Metodos
	
	public static void menu() {
		System.out.println("Registar dinosaurio");
		System.out.println("Atacar dinosaurio");
		System.out.println("Salir");
	}
	
	public static void registar(ArrayList <Dinosaurio> dino, Scanner sc) {
		System.out.println("1. Carnivoro");
		System.out.println("2. Herbivoro");
		System.out.println("3. Omnivoro");
		int opcion = sc.nextInt();
		switch (opcion) {
			case 1:
				System.out.println("Introduce un nombre");
				String nombre = sc.next();
				System.out.println("Introduce un ruido");
				String ruido = sc.next();
				System.out.println("Introduce un ataque");
				int ataque = sc.nextInt();
				System.out.println("Introduce un vida");
				int vida = sc.nextInt();
				Dinosaurio d = new Carnivoro (nombre, ruido, ataque, vida);
				dino.add(d);
				break;
			case 2:
				System.out.println("Introduce un nombre");
				String nombre1 = sc.next();
				System.out.println("Introduce un ruido");
				String ruido1 = sc.next();
				System.out.println("Introduce un ataque");
				int ataque1 = sc.nextInt();
				System.out.println("Introduce un vida");
				int vida1 = sc.nextInt();
				Dinosaurio d1 = new Herviboro (nombre1, ruido1, ataque1, vida1);
				dino.add(d1);
				break;
			case 3:
				System.out.println("Introduce un nombre");
				String nombre2 = sc.next();
				System.out.println("Introduce un ruido");
				String ruido2 = sc.next();
				System.out.println("Introduce un ataque");
				int ataque2 = sc.nextInt();
				System.out.println("Introduce un vida");
				int vida2 = sc.nextInt();
				Dinosaurio d2 = new omnivoro (nombre2, ruido2, ataque2, vida2);
				dino.add(d2);
				break;
		}
	}
}
