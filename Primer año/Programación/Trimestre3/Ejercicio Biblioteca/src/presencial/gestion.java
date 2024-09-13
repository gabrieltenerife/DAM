package presencial;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class gestion {
	protected persona p;
	protected String dni, nombre, apellidos, codigoUsuario, id, titulo, isbn, numPag, editorial;
	protected int duracion, ejemplares;
	protected String fechaInicio, fechaFin;
	protected articulos a;
	protected gestionMenus gm = new gestionMenus();
	protected gestionPrestamos gp = new gestionPrestamos();
	protected prestamos pr;
	protected ArrayList<persona>Personas=new ArrayList<persona>();
	protected ArrayList<articulos>Articulos=new ArrayList<articulos>();
	Scanner sc = new Scanner (System.in);
	int opcion;
	
	protected void gestionAdmin(int opcion) {
		switch (opcion) {
			case 1: if(!comprobarExisteUsuario()) {
						darAltaUsuario();
					}
					else System.out.println("El usuario ya está dado de alta");
				break;
			case 2: if(comprobarExisteUsuario()) {
						darBajaUsuario();
					}
					else System.out.println("El usuario no está dado de alta");
				break;
			case 3: if(!comprobarExisteArticulo()) {
						darAltaArticulo();
					}
					else System.out.println("El artículo ya está dado de alta");
				break;
			case 4: if(comprobarExisteArticulo()) {
						darBajaArticulo();
					}
					else System.out.println("El artículo no está dado de alta");
				break;
			case 5: if(comprobarExisteUsuario()) {
						verPrestamosCliente();
					}
					else System.out.println("El usuario no existe");
				break;
			case 6: if(comprobarExisteUsuario()) {
						penalizarUsuario();
					}
					else System.out.println("El usuario no existe");
				break;
			case 7: System.out.println("Volvemos al menú principal");	
		}
	}
	
	protected void gestionUsuario(int opcion) {
		switch (opcion) {
			case 1: if(comprobarExisteUsuario()) {
						hacerPrestamo();
					}
					else System.out.println("El préstamo no se ha podido realizar");
				break;
			case 2: if(comprobarExisteUsuario()) {
						hacerDevolucion();
					}
					else System.out.println("No se puede hacer la devolución");
				break;
			case 3: if(comprobarExisteUsuario()) {
						verPrestamosActivos();
					}
					else System.out.println("No se han podido ver los préstamos, el alumno no existe");
				break;
			case 4: System.out.println("Volvemos al menú principal");	
		}
	}
	
	
	protected void darAltaAdministrador() {
		
	}
	
	protected boolean comprobarExisteAdministrador() {
		return true;
	}
	
	protected void darAltaUsuario() {
		System.out.println("DNI: ");
		dni = sc.next();
		System.out.println("Nombre: ");
		nombre = sc.next();
		System.out.println("Apellidos: ");
		apellidos = sc.next();
		System.out.println("Código Usuario: ");
		codigoUsuario = sc.next();
		p = new usuario(dni,nombre,apellidos,codigoUsuario);
		Personas.add(p);
	}
	
	protected boolean comprobarExisteUsuario() {
		System.out.println("DNI: ");
		dni = sc.next();
		boolean encontrado = false;
		for (persona us: Personas) {
			if(us.getDni().equals(dni)) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	protected void darBajaUsuario() {
		System.out.println("DNI: ");
		dni = sc.next();
		boolean encontrado = false;
		for (persona us: Personas) {
			if(us.getDni().equals(dni)) {
				Personas.remove(us);
				encontrado = true;
			}
		}
		if (encontrado) System.out.println("Usuario eliminado");
		else System.out.println("El usuario no se ha podido eliminar");
	}
	
	protected void darAltaArticulo() {
		System.out.println("ID del artículo: ");
		id=sc.next();
		System.out.println("Título: ");
		titulo=sc.next();
		gm.menuArticulos();
		opcion=sc.nextInt();
		switch(opcion) {
			case 1: System.out.println("ISBN: ");
			  		isbn=sc.next();
			  		System.out.println("Numero ejemplares: ");
			  		ejemplares=sc.nextInt();
			  		a = new libro(id,titulo,ejemplares,isbn);
			  		Articulos.add(a);
				break;
			case 2: System.out.println("Numero ejemplares: ");
	  				ejemplares=sc.nextInt();
					System.out.println("Número páginas: ");
					numPag=sc.next();
					System.out.println("Editorial: ");
					editorial=sc.next();
					a = new revista(id,titulo,ejemplares,numPag,editorial);
					Articulos.add(a);
				break;
			case 3: System.out.println("Numero ejemplares: ");
	  				ejemplares=sc.nextInt();
					System.out.println("Duracion: ");
			 		duracion=sc.nextInt();
			 		a = new peliculas(id,titulo,ejemplares,duracion);
			 		Articulos.add(a);
				break;
			case 4: System.out.println("Salimos al menú anterior");
			 	break;
			 default: System.out.println("Opcion incorrecta, volvemos al menú anterior");	
		}
	}
	
	protected boolean comprobarExisteArticulo() {
		System.out.println("ID: ");
		id = sc.next();
		boolean encontrado = false;
		for (articulos ar: Articulos) {
			if(ar.getId().equals(id)) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	
	protected void mostrarArticulosDisponibles() {
		for(articulos a: Articulos) {
			if(a.getEjemplares()>0) {
				a.toString();
			}
		}
	}
	
	protected void darBajaArticulo() {
		System.out.println("ID: ");
		id = sc.next();
		boolean encontrado = false;
		for (articulos ar: Articulos) {
			if(ar.getId().equals(id)) {
				Personas.remove(ar);
				encontrado = true;
			}
		}
		if (encontrado) System.out.println("Artículo eliminado");
		else System.out.println("El artículo no se ha podido eliminar");
	}
	
	protected void verPrestamosCliente() {
		System.out.println("DNI: ");
		dni = sc.next();
		gp.verPrestamos(dni);
	}
	
	protected void penalizarUsuario() {
		
	}
	
	protected void hacerPrestamo() {
		boolean prestado = false;
		System.out.println("DNI: ");
		dni = sc.next();
		for(persona p: Personas) {
			if(p.getDni().equals(id)) {
				prestado=true;
				gm.menuArticulos();
				int art = sc.nextInt();
				// Obtener la fecha actual
		        LocalDate fechaActual = LocalDate.now();
		        LocalDate fechaFinal = LocalDate.now();
		        fechaFinal.plusDays(10);
		        // Formatear la fecha como una cadena
		        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        fechaInicio = fechaActual.format(formatoFecha);
		        DateTimeFormatter formatoFechaFinal = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		        fechaFin = fechaFinal.format(formatoFechaFinal);
		        pr = new prestamos(dni,fechaInicio,fechaFin);
				boolean salir = false;
				do {
					mostrarArticulosDisponibles();
					System.out.println("Indique el id del artículo: ");
					id = sc.next();
					for(articulos a: Articulos) {
						if(a.getId().equals(id)) {
							pr.añadirArticulo(a);
							a.restarPrestados();
						}
					}
					System.out.println("¿Quiere seguir reservando?");
					char seguir=sc.next().toLowerCase().charAt(0);
					if (seguir=='s')salir=true;
				} while (!salir);
			}
		}
		if(prestado) System.out.println("Prestamo realizado");
		else System.out.println("Usuario sancionado, no se puedo realizar el prestamo"); 
	}
	
	protected void hacerDevolucion() {
		System.out.println("DNI: ");
		dni = sc.next();
		System.out.println("Fecha Inicio: ");
		fechaInicio = sc.next();
		fechaFin = gp.devolverPrestamo(dni, fechaInicio);
		if(compararFechas(fechaFin)) {
			for(persona p: Personas) {
				if(p.getDni().equals(id)) {
					((usuario) p).setSancionado(true);
				}
			}	
		}
        
	}
	
	protected void verPrestamosActivos() {
		
	}
	
	private boolean compararFechas(String fechaFin) {
		boolean sancion = false;
		LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaDevolucion = fechaActual.format(formatoFecha);
     

        // Convertir las cadenas a LocalDate
        LocalDate f1 = LocalDate.parse(fechaFin, formatoFecha);
        LocalDate f2 = LocalDate.parse(fechaDevolucion, formatoFecha);

        // Comparar las fechas
        if (f2.isAfter(f1)) {
            sancion = true;
        }
        return sancion;
	}
}
