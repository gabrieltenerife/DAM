package presencial;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class prestamos {
	protected String dni;
	protected String fechaI, fechaF, fechaD;
	protected ArrayList<articulos>artArray=new ArrayList<articulos>();
	
	protected prestamos(String dni, String fechaI, String fechaF, ArrayList<articulos> artArray) {
		this.dni = dni;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.artArray = artArray;
	}
	
	protected prestamos(String dni, String fechaI, String fechaD) {
		this.dni = dni;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.artArray = artArray;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getFechaI() {
		return fechaI;
	}

	protected void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}

	protected String getFechaF() {
		return fechaF;
	}

	protected void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}
	
	protected String getFechaD() {
		return fechaD;
	}

	protected void setFechaD(String fechaD) {
		this.fechaD = fechaD;
	}

	protected ArrayList<articulos> getArtArray() {
		return artArray;
	}

	protected void setArtArray(ArrayList<articulos> artArray) {
		this.artArray = artArray;
	}

	protected void mostrarArticulos() {
		System.out.println("El usuario con dni: "+this.dni);
		System.out.println("Tiene prestados: ");
		for(articulos a: artArray) {
			System.out.println("ID: "+a.getId());
			System.out.println("Nombre: "+a.getTitulo());
			System.out.println("Tipo: "+a.getClass());
		}
		System.out.println("Se los llevo el día "+fechaI+" y los tiene que devolver el día"+fechaF);
		
	}
	
	protected void añadirArticulo(articulos a) {
		artArray.add(a);
	}

	protected String hacerDevolucion() {
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.fechaD = fechaActual.format(formatoFecha);
		return fechaF;
	}

	
	
}
