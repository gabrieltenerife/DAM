package Selva;

public class Herviboro extends Dinosaurio {
	//Cons
		public Herviboro(String nombre, String ruido, int ataque, int vida) {
			super(nombre, ruido, ataque, vida);
		}
		
		
		@Override
		public int comer(int ataque, int vida) {
			int hp = ataque;
			return hp;
		}
		@Override
		public void ruido(String ruido) {
			System.out.println(ruido + "!!!");
		}
	}

