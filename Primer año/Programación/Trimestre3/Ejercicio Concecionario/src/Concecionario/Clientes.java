package Concecionario;

public class Clientes {

	//Variables
	protected String nombre, apellido;
	private String dni;
	
	//Constructores
	public Clientes() {
		super();
	}
	public Clientes(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	//Metodos
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
	
	
	
	
	
	
	//NOto
}
