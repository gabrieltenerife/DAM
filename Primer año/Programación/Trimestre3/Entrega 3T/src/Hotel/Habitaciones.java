package Hotel;

public class Habitaciones {

	protected String tipo, precio, numero;
	protected boolean disponible = true;

	public Habitaciones(String numero, String precio, String tipo) {
		super();
		this.numero = numero;
		this.precio = precio;
		this.tipo = tipo;
	}

	public Habitaciones(String tipo, String precio, String numero, boolean disponible) {
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
