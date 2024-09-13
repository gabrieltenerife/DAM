package Concecionario;

public class Alquiler {

	private int descuento;
	private int dias;
	private int preciodia;
	
	public Alquiler(int descuento, int dias, int preciodia) {
		super();
		this.descuento = descuento;
		this.dias = dias;
		this.preciodia = preciodia;
	}

	public static int reservar (int dias, int preciodia, int descuento) {
		int preciofinal = -1;
		if (dias >=1) {
			preciofinal = (dias * preciodia)-descuento;
			return preciofinal;
		}
		else return preciofinal;
	}
}
