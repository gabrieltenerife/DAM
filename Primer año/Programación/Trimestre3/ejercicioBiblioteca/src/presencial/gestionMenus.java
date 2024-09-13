package presencial;

public class gestionMenus {
	
	protected void menuRegistro() {
		System.out.println("Menu de Registro");
		System.out.println("1.- Administrador");
		System.out.println("2.- Usuario");
		System.out.println("3.- Salir");
	}
	
	protected void menuAdministrador() {
		System.out.println("Menu del Administrador");
		System.out.println("1.- Dar de alta usuario");
		System.out.println("2.- Dar de baja usuario");
		System.out.println("3.- Dar de alta artículo");
		System.out.println("4.- Dar de baja artículo");
		System.out.println("5.- Ver préstamos de un usuario");
		System.out.println("6.- Penalizar a un usuario");
		System.out.println("7.- Salir");
	}
	
	protected void menuUsuario() {
		System.out.println("Menu del Usuario");
		System.out.println("1.- Hacer préstamo");
		System.out.println("2.- Hacer devolución");
		System.out.println("3.- Ver préstamos activos");
		System.out.println("4.- Salir");
	}
	
	protected void menuArticulos() {
		System.out.println("Menu de Artículos");
		System.out.println("1.- Libro");
		System.out.println("2.- Revista");
		System.out.println("3.- Película");
		System.out.println("4.- Salir");
	}
	
}
