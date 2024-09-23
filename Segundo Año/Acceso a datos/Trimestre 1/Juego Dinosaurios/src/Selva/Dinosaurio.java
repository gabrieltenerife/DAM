package Selva;

public abstract class Dinosaurio {
	
	//Variables
	String nombre, dieta, ruido;
	int ataque, vida;
	
	//Constructor
	public Dinosaurio() {
		super();
	}
	public Dinosaurio(String nombre, String ruido, int ataque, int vida) {
		super();
		this.nombre = nombre;
		this.ruido = ruido;
		this.ataque = ataque;
		this.vida = vida;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRuido() {
		return ruido;
	}
	public void setRuido(String ruido) {
		this.ruido = ruido;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	//Metodos
	public abstract int comer (int ataque, int vida);
	public abstract void ruido (String ruido);
}//Noto