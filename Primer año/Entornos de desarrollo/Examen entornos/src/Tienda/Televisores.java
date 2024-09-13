package Tienda;

public class Televisores {

	private int precio;
	private int cantidad;
	private int descuento;
	
	public Televisores(int precio, int cantidad, int descuento) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.descuento = descuento;
	}
	
	public static int preciototal (int precio, int cantidad, int descuento) {
		int resultado = -1;
		if(cantidad >= 1) {
			resultado = (precio * cantidad) - descuento;
			return resultado;
		}
		else return resultado;
	}
	
	
}
