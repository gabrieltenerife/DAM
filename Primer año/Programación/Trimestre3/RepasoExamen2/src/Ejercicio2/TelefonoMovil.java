package Ejercicio2;

public class TelefonoMovil extends Productos{

	String modelo, marca;
	int memoria;
	double descuento;
	
	public TelefonoMovil(double precio, String modelo, String marca, int memoria, double descuento) {
		super(precio);
		this.modelo = modelo;
		this.marca = marca;
		this.memoria = memoria;
		this.descuento = descuento;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getMemoria() {
		return memoria;
	}
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	
	public static boolean equals (TelefonoMovil a, TelefonoMovil b) {
		boolean equals = false;
		if(a.getMarca().equals(b.getMarca()) && a.getModelo().equals(b.getModelo())) {
			equals = true;
		}
		return equals;
	}
	
	@Override
	public String toString() {
		return "El telefono: " +modelo+ " de la marca " +marca+ " con una memoria de " +memoria+ " gigabites tiene un precio de " +precio+
				" y se le aplica un descuento de " +descuento+ "%";
	}
	@Override
	protected double calcularPrecioFinal(double precio, double descuento) {
		double calcular;
		calcular = descuento / 100.0;
		calcular = precio * calcular;
		calcular = precio - calcular;
		return calcular;
	}
}