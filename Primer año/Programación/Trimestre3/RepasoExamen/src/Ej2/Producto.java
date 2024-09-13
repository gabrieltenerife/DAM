package Ej2;

public abstract class Producto {
	protected double precio;

	public Producto(double precio) {
		super();
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public abstract double calcularPrecioFinal(double precio, double descuento);
}
