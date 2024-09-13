package Ejercicio2;

public abstract class Producto {
	double precio;

	public Producto(double precio) {
		super();
		this.precio = precio;
	}

	public double isPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public double getPrecio() {
		return precio;
	}

	public abstract double calcularPrecioFinal(double precio, double descuento);
}
