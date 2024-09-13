package Hotel;

public class Habitaciones {

	protected String tipo, numero;
	protected int precio;
	protected boolean disponible = true;

	public Habitaciones(String numero, int precio, String tipo) {
		super();
		this.numero = numero;
		this.precio = precio;
		this.tipo = tipo;
	}
	
	public Habitaciones(String tipo, int precio, String numero, boolean disponible) {
		super();
		this.tipo = tipo;
		this.precio = precio;
		this.numero = numero;
		this.disponible = disponible;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
