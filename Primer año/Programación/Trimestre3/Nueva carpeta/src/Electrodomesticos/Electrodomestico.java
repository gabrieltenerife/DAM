package Electrodomesticos;

public abstract class Electrodomestico {
	
	//Variables
	protected final int preciobase=100, pesobase=5;
	protected final String colorbase="blanco";
	protected final char consumobase='F';
	protected int precio, peso;
	protected String color;
	protected char consumo;
	
	//Constructores 
	public Electrodomestico() {
		super();
	}
	public Electrodomestico(int precio, int peso) {
		super();
		this.precio = precio;
		this.peso = peso;
	}
	public Electrodomestico(int precio, int peso, String color, char consumo) {
		super();
		this.precio = precio;
		this.peso = peso;
		this.color = color;
		this.consumo = consumo;
	}
	
	//MetodosG&S
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getConsumo() {
		return consumo;
	}
	public void setConsumo(char consumo) {
		this.consumo = consumo;
	}
	public int getPreciobase() {
		return preciobase;
	}
	public int getPesobase() {
		return pesobase;
	}
	public String getColorbase() {
		return colorbase;
	}
	public char getConsumobase() {
		return consumobase;
	}
	
	//Metodos
	public static char comprobarConsumoEnergetico (char consumo) {
		
		boolean existe=false;
		char[]lista={'A','B','C','D','E','D'};
		for(char c:lista) {
			if(consumo==c) {
				existe = true;
			}
		}
		if (existe == false) {
			consumo = 'F';
		}
		return consumo;
	}
	
	public static String ComprobarColor(String color) {
		
		boolean existe=false;
		String[]lista={"blanco", "negro", "azul", "gris"};
		for(String c:lista) {
			if(color==c) {
				existe = true;
			}
		}
		if (existe == false) {
			color = "blanco";
		}
		return color;
	}
	
	public static void precioFinal (char consumo, int precio) {
		
		String[][]precioconsumo= {{"A","100"},{"B","80"},{"C","60"},{"D","50"},{"E","30"},{"F","10"},};
		String[][]preciotamaño= {};
		
		
	}
}