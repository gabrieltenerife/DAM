package Ej2;

public class Tablet extends Producto {

	protected String modelo, marca;
	protected int memoria,descuento;
	
	public Tablet(double precio, String modelo, String marca, int memoria, int descuento) {
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

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public static boolean equals (Tablet t, Tablet t1) {
		boolean equals = false;
		if(t.modelo.equals(t1.modelo)) {
			equals = true;
		}
		return equals;
	}



	@Override
	public String toString() {
		return "Tablet [modelo=" + modelo + ", marca=" + marca + ", memoria=" + memoria + ",precio=\" + precio descuento=" + descuento
				+ "]";
	}

	@Override
	public double calcularPrecioFinal(double precio, double descuento) {
		double resultado = precio - descuento;
		return resultado;
	}
}
