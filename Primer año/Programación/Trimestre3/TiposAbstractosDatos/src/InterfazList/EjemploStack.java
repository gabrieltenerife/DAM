package InterfazList;

import java.util.Stack;

/* Aun siendo una clase que implementa la interfaz List, en realidad representa al
 * TAD pila en el que se utiliza LIFO como modo de acceso a los elementos.
 * Al ser un clase derivada de Vector, los acceso también son sincronizados, por lo 
 * que ralentiza las operaciones.
 * Su uso es ineficiente, es mejor usar interfaz Deque o Likedist, sólo para accesos 
 * sincronizados con hilos.
 * */
public class EjemploStack {

	public static void main(String[] args) {
		Stack st = new Stack();

		st.push("Probando");
		st.push("el");
		st.push("ejercicio");
		st.push("una");
		st.push("cola");
		System.out.println("Posicion en la cola: "+st.search("ejercicio"));
	}

}
