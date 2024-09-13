package Concecionario;

public class Vehiculos {

	//Variables
	protected String modelo, precio, color;
	private String numbastidor;
	
	//Constructores
	public Vehiculos() {
		super();
	}
	public Vehiculos(String modelo, String precio, String color) {
		super();
		this.modelo = modelo;
		this.precio = precio;
		this.color = color;
	}
	
	//Metodos
	public Vehiculos(String numbastidor) {
		super();
		this.numbastidor = numbastidor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumbastidor() {
		return numbastidor;
	}
	public void setNumbastidor(String numbastidor) {
		this.numbastidor = numbastidor;
	}
	
	
	
	
	//NOto
}
