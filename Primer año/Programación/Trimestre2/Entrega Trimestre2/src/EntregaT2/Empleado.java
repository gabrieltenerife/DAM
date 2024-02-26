package EntregaT2;

public class Empleado {

	//Variables
	protected String dni, nombre;
	protected int edad;
	protected boolean casado;
	protected double salario;
	
	//Constructores
	public Empleado() {
		super();
	}
	public Empleado(String dni, String nombre, int edad, boolean casado, double salario) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.casado = casado;
		this.salario = salario;
	}
	
	//Metodos
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isCasado() {
		return casado;
	}
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
