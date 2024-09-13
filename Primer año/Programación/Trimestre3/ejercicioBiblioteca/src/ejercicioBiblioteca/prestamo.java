package ejercicioBiblioteca;

public class prestamo {
	protected String ISBN, dni, fechaInicio, fechaFinal, fechaDevolucion;

	protected prestamo() {
		
	}
	
	protected prestamo(String iSBN, String dni, String fechaInicio, String fechaFinal) {
		ISBN = iSBN;
		this.dni = dni;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
	}
	
	protected String getISBN() {
		return ISBN;
	}

	protected void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getFechaInicio() {
		return fechaInicio;
	}

	protected void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	protected String getFechaFinal() {
		return fechaFinal;
	}

	protected void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	protected String getFechaDevolucion() {
		return fechaDevolucion;
	}

	protected void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	@Override
	public String toString() {
		return "prestamo del libro con " + ISBN + ", al usuario con dni=" + dni + ", se lo llevo " + fechaInicio + ", tiene que devolver " + fechaFinal
				+ ", y lo ha devuelto " + fechaDevolucion;
	}
	

	
}
