package dinosaurios;

public class Carnivoro extends Dinosaurio{
	//Cons
	public Carnivoro(String nombre, String ruido, int ataque, int vida) {
		super(nombre, ruido, ataque, vida);
	}
	
	
	@Override
	public int comer(int ataque, int vida) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void ruido(String ruido) {
		System.out.println(ruido + "!!!");
	}
}
