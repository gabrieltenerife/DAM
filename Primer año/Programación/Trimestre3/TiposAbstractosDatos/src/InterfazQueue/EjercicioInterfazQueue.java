package InterfazQueue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* También es conocida como cola, representa una estructura de almacenamiento FIFO.
 * Existen varias implementaciones de esta interfaz que permiten implementar colas
 * cuyo comportamiento difiere a las anteriores.
 * */

/* PriorityQueue: los elementos son ordenados de acuerdo con su orden natural.
 * Este tipo de colas no permite nulos ni la inserción de objetos no comparables, 
 * aunque sí duplicados.
 * */

/* ArrayQueue: array que implementa la subinterfaz Deque de la interfez Queue. 
 * Utiliza la matriz de tamaño variable y no admite la inserción de elementos nulos.
 * Puede ser usada como pila, como cola o como ambos a la vez, dado que permite 
 * insertar elementos por ambos extremos.
 * */
public class EjercicioInterfazQueue {

	public static void main(String[] args) {
		PriorityQueue numeros = new PriorityQueue();
		numeros.add(22);
		numeros.add(54);
		numeros.add(17);
		numeros.add(36);
		//devuelve true si no existen elementos en la colección.
		while (!numeros.isEmpty()) {
			System.out.println(numeros.remove());
		}
		
		ArrayDeque nombres = new ArrayDeque();
		nombres.add("Lorena"); // Lorena
		nombres.add("Ivan");   // Lorena Ivan
		nombres.push("Aaron"); // Aaron Lorena Ivan
		nombres.add("David");  // Aaron Lorena Ivan David
		nombres.push("Alex");  // Alex Aaron Lorena Ivan David
		nombres.add("Diego");  // Alex Aaron Lorena Ivan David Diego
		nombres.add("Daniel"); // Alex Aaron Lorena Ivan David Diego Daniel
		while (!nombres.isEmpty()) {
			System.out.println(nombres.pop());
		}

	}

}
