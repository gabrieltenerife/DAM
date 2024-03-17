package InterfazList;

import java.util.LinkedList;

/* LinkedList es la implementación de las interfaces List y Deque. Se compone de una
 * lista doblemente enlazada en la que cada elemento almacena una referencia a los 
 * elementos siguiente y anterior. Es la colección ideal para implementar TAD pila y
 * cola.
 * */

/* TAD cola: tipo abstracto de datos que permite almacenar y recuperar información
 * siguiendo un esquema FIFO.
 * Toda cola debe contar con las operaciones encolar(add) y desencolar(remove).
 * En todo momento se tendrá acceso al elemento que más tiempo lleva almacenado.
 * */

public class ejerciciosTadCola {
	final LinkedList cola;
	protected ejerciciosTadCola() {
		this.cola = new LinkedList();
	}
	protected void encolar(Object elemento) {
		cola.add(elemento);
	}
	protected Object desencolar() {
		return cola.remove();
	}
	protected Object frente() {
		return cola.peek();
	}
	public static void main(String[] args) {
		ejerciciosTadCola c = new ejerciciosTadCola();
		System.out.println("Elemento en el frente: "+c.frente());
		for (int i=1; i<=3; i++) {
			c.encolar(i);
		}
		System.out.println("Elemento en el frente: "+c.frente());
		c.desencolar();
		System.out.println("Elemento en el frente: "+c.frente());
		c.desencolar();
		System.out.println("Elemento en el frente: "+c.frente());
	}

}
