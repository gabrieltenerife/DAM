package InterfazList;

import java.util.LinkedList;

/* TAD pila: tipo abstracto de dato que permite recuperar y almacenar información
 * siguiendo un esquema LIFO.
 * Toda pila debe contar con las operaciones apilar(push) y desapilar(pop).
 * En todo momento se tendrá acceso a la cima de la pila.
 * */

public class ejerciciosTadPila {
	
	private final LinkedList pila;
	protected ejerciciosTadPila() {
		this.pila = new LinkedList();
	}
	protected void apilar(Object elemento) {
		pila.push(elemento);
	}
	protected Object desapilar() {
		return pila.pop();
	}
	protected Object cima() {
		return pila.peek();
	}
	public static void main(String[] args) {
		ejerciciosTadPila p = new ejerciciosTadPila();
		System.out.println("Elemento TOS: "+p.cima());
		for(int i=1; i<=3; i++) {
			p.apilar(i);
		}
		System.out.println("Elemento TOS: "+p.cima());
		p.apilar(4);
		System.out.println("Elemento TOS: "+p.cima());
		p.desapilar();
		System.out.println("Elemento TOS: "+p.cima());
	}

}
