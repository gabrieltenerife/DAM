package dinosaurios;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Variables
		Scanner sc = new Scanner(System.in);
		ArrayList <Dinosaurio> dino = new ArrayList <Dinosaurio>();
		ArrayList <Jugador> player = new ArrayList <Jugador>();
		int opcion, pasar = 0;
		String user;
		
		do {
		menu();
		opcion = sc.nextInt();
		switch(opcion) {
			case 1:
				System.out.println("Introduce un nombre de usuario");
				user = sc.next();
				if (!comprobarusuario(player, user)) {
					registrarusuario(player,user,sc);
				}else System.out.println("Este usuario ya se encuentra registrado");
				break;
			case 2:
				System.out.println("Introduce un nombre de usuario");
				user = sc.next();
				if (comprobarusuario(player, user)) {
				  if (comprobarcontraseña(player, user, sc)) {
					  pasar = 1;
				  } else System.out.println("Contraseña erronea");
				} else System.out.println("Este usuario no existe");
				break;
				
			case 3:
				for(Jugador j1 : player) {
					System.out.println("contraseña: " + j1.getContraseña() + "usuario:" + j1.getUsuario());
				}
				break;
		}
	
			
		
		}while (pasar != 1);
		
	}
	
	//Metodos
	
	public static void menu() {
		System.out.println("1. Registrarse");
		System.out.println("2. Loguearse");
	}
	
	
	
	public static void menu1() {
		System.out.println("Registar dinosaurio");
		System.out.println("Atacar dinosaurio");
		System.out.println("Salir");
	}
	
	
	public static boolean comprobarusuario(ArrayList <Jugador> player, String user) {
		boolean existe = false;
		for(Jugador p1:player) {
			if(p1.getUsuario().equals(user)) {
				existe = true; 
				break;
			}
			else existe = false;
		}
		return existe;
	}
	
	public static boolean comprobarcontraseña(ArrayList <Jugador> player, String user, Scanner sc ) {
		boolean correcto = false;
		
		System.out.print("Introduce tu contraseña");
		String password = sc.next();
		for(Jugador p1:player) {
			if(p1.getUsuario().equals(user) && p1.getContraseña().equals(password)) {
				correcto = true;
			} else correcto = false;
		}
		
		return correcto;
	}
	
	public static void registrarusuario (ArrayList <Jugador> player, String user, Scanner sc) {
		System.out.println("Introduce una contraseña");
		String password = sc.next();
		Jugador e = new Jugador (user, password);
		player.add(e);
	}
	
	public static void registardino(ArrayList <Dinosaurio> dino, Scanner sc) {
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
