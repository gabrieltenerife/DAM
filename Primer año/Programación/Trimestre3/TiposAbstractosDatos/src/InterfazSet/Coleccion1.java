package InterfazSet;
/* Implementación que almacena los elementos en una tabla hash, permite el acceso 
 * más rápido a los elementos. No permite realizar accesos secuenciales y los 
 * elementos no están ordenados por ningún criterio.
 * */


import java.util.HashSet;
import java.util.Iterator;

public class Coleccion1 {
	
	public static void main(String [] args) {
		HashSet alumnos = new HashSet();
		
		alumnos.add("David");
		alumnos.add("Javier");
		alumnos.add("Alicia");
		alumnos.add("Esperanza");
		System.out.println("Todos los elementos:" + alumnos);
		
		
		alumnos.add("Javier");
		System.out.println("Todos los elementos:\t" + alumnos);
		
		//Recorrer los elementos
		Iterator<String> it = alumnos.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
}
