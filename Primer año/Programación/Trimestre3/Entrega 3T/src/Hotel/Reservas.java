package Hotel;

public class Reservas {

	protected String dni, nombre, numero, fecha;
	protected int noches;
	
	public Reservas() {
		super();
	}

	public Reservas(String dni, String nombre, String numero, int noches, String fecha) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numero = numero;
		this.noches = noches;
		this.fecha = fecha;
	}

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getNoches() {
		return noches;
	}

	public void setNoches(int noches) {
		this.noches = noches;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
