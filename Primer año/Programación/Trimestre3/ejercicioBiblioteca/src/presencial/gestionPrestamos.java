package presencial;

import java.util.ArrayList;

public class gestionPrestamos {

		protected ArrayList <prestamos> listaPrestamos = new ArrayList <prestamos> ();

		protected void verPrestamos(String dni) {
			boolean encontrado=false;
			for(prestamos p: listaPrestamos) {
				if(p.getDni().equals(dni)) {
					p.mostrarArticulos();
					encontrado=true;
				}
			}
			if(!encontrado) System.out.println("No se ha podido mostrar los préstamos");
		}
		
		protected String devolverPrestamo (String dni, String fechaInicio) {
			boolean devuelto = false;
			String fechaFin="";
			for(prestamos p: listaPrestamos) {
				if(p.getDni().equals(dni) && p.getFechaI().equals(fechaInicio)) {
					fechaFin = p.hacerDevolucion();
					devuelto=true;
				}
			}
			if (devuelto) System.out.println("Realizada la devolución");
			else System.out.println("No se ha podido realizar la devolución");
			return fechaFin;
		}
		
		protected void prestamosActivos() {
			boolean activos = false;
			for(prestamos p: listaPrestamos) {
				if(!p.getFechaD().isEmpty()) {
					p.mostrarArticulos();
					activos = true;
				}
			}
			if(!activos) System.out.println("No hay préstamos activos");
		}
		
}
