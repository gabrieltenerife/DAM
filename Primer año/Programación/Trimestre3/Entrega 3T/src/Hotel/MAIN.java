package Hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) {
		
		//Variables
		String user;
		int opcion, opcion2, opcion3;
		final String AdminU="admin", AdminP="123";
		Scanner sc = new Scanner (System.in);
		ArrayList <Persona> Login = new ArrayList <Persona>();	
		Persona P;
		
		
		do {
		menu1();
		opcion = sc.nextInt();
		switch(opcion) {
		case 0:
			if(Loginadmin(sc, AdminU, AdminP)==true) {
				menu3();
				opcion2 = sc.nextInt();
				switch(opcion2) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				}
			}
			break;
		case 1:
			if(Loguear(sc, Login) == true) {
				do {
					menu2();
					opcion3 = sc.nextInt();
					switch(opcion3) {
					case 1:
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					case 4:System.out.println("Se a cerrado su sesion correctamente");
						break;
					}
				}while(opcion3!=4);
				
				
			}
			break;
		case 2: 
			System.out.println("Introduzca un nombre de usuario");
			user = sc.next();
			if(!comprobarusuario(user, Login)) {
				registrar(user, Login, sc);
			} else {System.out.println("Este nombre de usuario ya esta siendo utilizado");}
			break;
		}
		}while(opcion!=3);
		
		
	}

	//Metodos
	public static void menu1() {
		System.out.println("Bienvenido a la cadena de hoteles sol!");
		System.out.println("--------------------------------------");
		System.out.println("1. Iniciar sesion");
		System.out.println("2. Registrarse");
		System.out.println("3. Salir");
		System.out.println("--------------------------------------*");
		System.out.println("*presione 0 admin*");
	}
	
	public static void menu2() {
		System.out.println("1. Reservar habitaciones");
		System.out.println("2. Ver mis habitaciones reservadas");
		System.out.println("3. Ver habitaciones disponibles para una fecha");
		System.out.println("4. Cerrar sesión");
	}
	
	public static void menu3() {
		System.out.println("1. Dar de alta habitacion");
		System.out.println("2. Dar de baja habitacion");
		System.out.println("3. Modificar datos de habitacion");
		System.out.println("4. Cerrar sesión");
	}
	
	public static boolean comprobarusuario(String user, ArrayList<Persona>Login) {

		boolean existe = false;
		for(Persona P:Login) {
			if(((Usuario)P).getUsuariouser().equals(user)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public static boolean Loguear(Scanner sc, ArrayList<Persona>Login) {
		
		boolean entrar = false;
		System.out.println("Introduzca su usuario:");
		String user = sc.next();
		for(Persona P:Login){
			if(((Usuario)P).getUsuariouser().equals(user)) {
				System.out.println("Introduzca su contraseña:");
				String password = sc.next();
				if(((Usuario)P).getContraseñauser().equals(password)) {
					entrar = true;
				}else {System.out.println("Contraseña incorrecta");}
			}else {System.out.println("El usuario no existe");}
		}
		return entrar;
	}
	
	public static boolean Loginadmin(Scanner sc, final String AdminU, final String AdminP) {
		boolean login = false;
		System.out.println("Introduzca usuario administrador");
		String usuario = sc.next();
		if(usuario.equals(AdminU)) {
			System.out.println("Introduzca contraseña administrador");
			String password = sc.next();
			if(password.equals(AdminP)) {
				login = true;
			} else {System.out.println("Contraseña incorrecta");}
		}else {System.out.println("Usuario incorrecto");}
		return login;
	}
	
	public static void registrar(String user, ArrayList<Persona>Login, Scanner sc){
		System.out.println("Introduzca una contraseña");
		String password = sc.next();
		System.out.println("Introduzca su nombre");
		String nombre = sc.next();
		System.out.println("Introduzca su apellido");
		String apellido = sc.next();
		System.out.println("Introduzca su DNI");
		String dni = sc.next();
		Persona P = new Usuario (nombre, apellido, dni, user, password);
		Login.add(P);
	}
	
	//NTIO
}