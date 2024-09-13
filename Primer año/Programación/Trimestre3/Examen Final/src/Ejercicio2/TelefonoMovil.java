package Ejercicio2;

public class TelefonoMovil extends Producto {
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
	
	public static boolean equals (TelefonoMovil p, TelefonoMovil p1) {
		boolean igual = false;
		if(p==p1) {
			igual = true;
		}
		return igual;
	}

	@Override
	public String toString() {
		return "TelefonoMovil [modelo=" + modelo + ", marca=" + marca + ", memoria=" + memoria + ", descuento="
				+ descuento + ", precio=" + precio + "]";
	}

	@Override
	public double calcularPrecioFinal(double precio, double descuento) {
		double resultado;
		resultado = precio -(precio*(descuento/100));
		return resultado;
	}
}
