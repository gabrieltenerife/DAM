package presencial;

public abstract class persona {
	protected String dni, nombre, apellidos;

	protected persona(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	protected String getDni() {
		return dni;
	}

	protected void setDni(String dni) {
		this.dni = dni;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected String getApellidos() {
		return apellidos;
	}

	protected void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
