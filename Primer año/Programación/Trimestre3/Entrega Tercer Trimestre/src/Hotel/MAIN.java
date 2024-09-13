	package Hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class MAIN {

	public static void main(String[] args) throws Controlexepciones {
		
		//PARA ADMIN USUARIO=ADMIN CONTRASEÑA=123
		
		//Variables
		String user, numero, dni="0";
		int opcion, opcion2, opcion3;
		final String AdminU="admin", AdminP="123";
		Scanner sc = new Scanner (System.in);
		ArrayList <Usuario> Login = new ArrayList <Usuario>();
		ArrayList <Habitaciones> rooms = new ArrayList <Habitaciones>();
		ArrayList <Reservas> reserva = new ArrayList <Reservas>();
		
		do {
		menu1();
		opcion = sc.nextInt();
		switch(opcion) {
		case 0:
			if(Loginadmin(sc, AdminU, AdminP)==true) {
				do {
					menu3();
					opcion2 = sc.nextInt();
					switch(opcion2) {
					case 1:
						System.out.println("Introduce el numero de habitacion");
						numero = sc.next();
						if(!comprobarhabitacion(numero, rooms)) {
							registrarhabitacion(rooms, sc, numero);
						}else{System.out.println("Esta habitacion ya esta registrada");}
						break;
					case 2:
						System.out.println("Introduce el numero de habitacion");
						numero = sc.next();
						if(!bajahabitacion(rooms,numero)) {
							System.out.println("No existe ninguna habitacion con numero : " +numero+ " registrada");
						}
						break;
					case 3:
						modificarhabitacion(rooms, sc);
						break;
					case 4: System.out.println("Sesion cerrada correctametne");
						break;
					}
				}while(opcion2!=4);
			}
			break;
		case 1:
			System.out.println("Introduzca su usuario:");
			user = sc.next();
			if(Loguear(sc, Login, user) == true) {
				do {
					menu2();
					opcion3 = sc.nextInt();
					switch(opcion3) {
					case 1:
						reservarhabitaciones(rooms, Login, user, sc, reserva);
						break;
						
					case 2:
						verhabitacionesnodisponibles(rooms);
						break;

					case 3:
						verhabitacionesdisponibles(rooms);
						break;
						
					case 4:
						misreservas(reserva, Login, user);
						break;
						
					case 5:System.out.println("Se a cerrado su sesion correctamente");
						break;
					}
				}while(opcion3!=5);
				
			}
			break;
		case 2: 
			System.out.println("Introduzca un nombre de usuario");
			user = sc.next();
			if(!comprobarusuario(user, Login)) {
				registrar(user, Login, sc, dni);
			} else {System.out.println("Este nombre de usuario ya esta siendo utilizado");}
			break;
		
		case 3:
			System.out.println("Gracias por visitar hoteles sol!");
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
		System.out.println("1. Reservar habitaciones para una fecha");
		System.out.println("2. Ver habitaciones ocupadas");
		System.out.println("3. Ver habitaciones disponibles");
		System.out.println("4. Ver mis habitaciones reservadas");
		System.out.println("5. Cerrar sesión");
	}
	
	public static void menu3() {
		System.out.println("1. Dar de alta habitacion");
		System.out.println("2. Dar de baja habitacion");
		System.out.println("3. Modificar datos de habitacion");
		System.out.println("4. Cerrar sesión");
	}
	
	public static boolean comprobarusuario(String user, ArrayList<Usuario>Login) {

		boolean existe = false;
		for(Usuario P:Login) {
			if(((Usuario)P).getUsuariouser().equals(user)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public static boolean comprobarhabitacion(String numero, ArrayList<Habitaciones>rooms) {

		boolean existe = false;
		for(Habitaciones H:rooms) {
			if(H.getNumero().equals(numero)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public static boolean Loguear(Scanner sc, ArrayList<Usuario>Login, String user) {
		
		boolean entrar = false;;
		for(Usuario P:Login){
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
	
	public static void registrar(String user, ArrayList<Usuario>Login, Scanner sc, String dni) throws Controlexepciones{
		System.out.println("Introduzca una contraseña");
		String password = sc.next();
		System.out.println("Introduzca su nombre");
		String nombre = sc.next();
		System.out.println("Introduzca su primer apellido");
		String apellido = sc.next();
		do {
		System.out.println("Introduzca su DNI");
		dni = sc.next();
		try {
		if(dni.length()!=9) throw new Controlexepciones(
				"El valor debe tener 9 digitos"
				);
		else {Usuario P = new Usuario (nombre, apellido, dni, user, password);
		Login.add(P);}
		System.out.println("Registrado correctamente");
		}
		catch(Controlexepciones e) {
			System.out.println("Exepcion capturada: " +e.getMessage());
		}
		}while(dni.length()!=9);
	}
	
	public static void registrarhabitacion(ArrayList<Habitaciones>rooms, Scanner sc, String numero){
		System.out.println("Introduzca el precio por noche");
		int precio = sc.nextInt();
		System.out.println("Introduzca el tipo de habitacion");
		String tipo = sc.next();
		Habitaciones H = new Habitaciones (numero, precio, tipo);
		rooms.add(H);
	}
	
	public static boolean bajahabitacion (ArrayList<Habitaciones>rooms, String numero) {
		boolean existe=false;
				
		for(Habitaciones e1:rooms) {
			if(e1.getNumero().equals(numero)) {
				existe=true;
				rooms.remove(e1);
				System.out.println("Habitacion con numero : " +numero+ " eliminada correctamente");
				break;
			}
		}
		return existe;
	}
	
	public static void modificarhabitacion(ArrayList<Habitaciones>rooms,Scanner sc) {
		System.out.println("Introduce el numero de habitacion");
		String numero = sc.next();
		for(Habitaciones h:rooms) {
			if(h.getNumero().equals(numero)) {
				System.out.println("El precio actual de la habitacion es de :" +h.getPrecio()+ " introduzca un nuevo valor");
				int precio = sc.nextInt();
				System.out.println("El tipo actual de la habitacion es :" +h.getTipo()+ " introduzca un nuevo tipo de habitacion");
				String tipo = sc.next();
				System.out.println("Actual mente el estado de disponibilidad de la habitacion es: " +h.disponible+ " elija una dispoinibilidad");
				boolean disponible = sc.nextBoolean();
				Habitaciones H = new Habitaciones(tipo, precio, numero, disponible);
				rooms.remove(h);
				rooms.add(H);
			} else {System.out.println("Este numero de habitacion no se encuentra registrado en el sistema");}
		}
	}

	public static void verhabitacionesdisponibles(ArrayList<Habitaciones>rooms) {
		System.out.println("Se encuentran disponibles las siguientes habitaciones:");
		for(Habitaciones h:rooms) {
			
				if(h.disponible == true) {
					System.out.println("disponible habitacion numero " +h.numero+ "habitacion de tipo " +h.tipo+ " con un precio por noche de " +h.precio+"$.");
				}else {System.out.println("Habitacion ocupada en este momento");}
		}
	}
	
	public static void verhabitacionesnodisponibles(ArrayList<Habitaciones>rooms) {
		System.out.println("Se encuentran reservadas las siguientes habitaciones:");
		for(Habitaciones h:rooms) {
				if(h.disponible == false) {
					System.out.println("Ocupada habitacion numero " +h.numero+ "habitacion de tipo " +h.tipo+ " con un precio por noche de " +h.precio+"$.");
				}else {System.out.println("Habitacion libre en este momento");}
		}
	}
	
	public static void reservarhabitaciones(ArrayList<Habitaciones>rooms,ArrayList<Usuario>Login, String user, Scanner sc,ArrayList<Reservas>reserva){
		
		System.out.println("En estos momentos se encuentran disponibles encuentran disponibles las siguientes habitaciones:");
		for(Habitaciones h:rooms) {
			if(rooms.size()>0) {
				if(h.disponible == true) {
					System.out.println("Disponible habitacion numero " +h.numero+ " habitacion de tipo " +h.tipo+ " con un precio por noche de " +h.precio+"$.");
				}
			} else {System.out.println("No existen habitaciones disponibles en este momento");}
		}
		System.out.println("Introduzca el numero de habitacion que desea reservar:");
		String numero = sc.next();
			for(Habitaciones H:rooms) {
				if(H.getNumero().equals(numero) && H.disponible==true) {
					System.out.println("Introduzca la fecha en la que desee realizar la reserva:");
					String fecha = sc.next();
					System.out.println("Introduzca el numero de noches que desee reservar:");
					int noches = sc.nextInt();
					
					for(Usuario p:Login){
						if(((Usuario)p).getUsuariouser().equals(user)) {
							String nom = ((Usuario)p).getNombre();
							String id = ((Usuario)p).getDni();
							Reservas r = new Reservas (id, nom, numero, noches, fecha);
							reserva.add(r);
							System.out.println("Se ha realizado una reserva exitosamente de la habitacion numero " +numero+ " a nombre de el sr/a " +nom+ " con dni " +id+ " el dia " +fecha+ " y durante un periodo de " +noches+ " noches.");
							for(Habitaciones ha:rooms){
								if(ha.getNumero().equals(numero)) {
									int cobro = 1;
									cobro = noches * ha.getPrecio();
									System.out.println("El total a pagar cuando se realize el Check-out es de :" +cobro+ "$");
								}
							}
						}
					}
					for(int i=0;i<rooms.size();i++) {
						if(rooms.get(i).getNumero().equals(numero)) {
							rooms.get(i).setDisponible(false);
						}
					}
				}
			}
	}
	
	public static void misreservas(ArrayList<Reservas>reserva, ArrayList<Usuario>Login, String user) {
		for(Usuario p:Login) {
			if(((Usuario)p).getUsuariouser().equals(user)) {
				for(Reservas r:reserva) {
					if(((Usuario)p).getDni().equals(r.getDni())) {
						System.out.println("Usted tiene una reserva de la habitacion numero " +r.getNumero()+ " a nombre de el sr/a " +r.getNombre()+ " con dni " +r.getDni()+ " el dia " +r.getFecha()+ " y durante un periodo de " +r.getNoches()+ " noches.");
					}
				}
			}
		}
	}
}