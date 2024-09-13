package Ejercicio2;

public abstract class Productos {
	
	double precio;

	public Productos(double precio) {
		super();
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	protected abstract double calcularPrecioFinal(double precio, double descuento);
}
