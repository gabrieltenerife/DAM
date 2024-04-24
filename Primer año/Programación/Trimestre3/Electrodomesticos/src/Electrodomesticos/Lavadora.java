package Electrodomesticos;

public class Lavadora extends Electrodomestico {
	
	//Variables
	protected final int cargainicial=5;
	protected int carga;
	//Constructores
	public Lavadora() {
		super();
	}
	public Lavadora(int precio, int peso) {
		super(precio, peso);
	}
	public Lavadora(int precio, int peso, String color, char consumo, int carga) {
		super(precio, peso, color, consumo);
		this.carga = carga;
	}
	//Metodos
	public int getCarga() {
		return carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	public int getCargainicial() {
		return cargainicial;
	}
}