package Electrodomesticos;

public class Televicion extends Electrodomestico {
	
	//Variables
	protected final int pulgadasinicial=20;
	protected int pulgadas;
	protected boolean tdt=false;
	//Constructores
	public Televicion() {
		super();
	}
	public Televicion(int precio, int peso) {
		super(precio, peso);
	}
	public Televicion(int precio, int peso, String color, char consumo, int pulgadas, boolean tdt) {
		super(precio, peso, color, consumo);
		this.pulgadas = pulgadas;
		this.tdt = tdt;
	}
	//Metodos
	public int getPulgadas() {
		return pulgadas;
	}
	public void setPulgadas(int pulgadas) {
		this.pulgadas = pulgadas;
	}
	public boolean isTdt() {
		return tdt;
	}
	public void setTdt(boolean tdt) {
		this.tdt = tdt;
	}
	public int getPulgadasinicial() {
		return pulgadasinicial;
	}
}
