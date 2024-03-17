package LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* Se diferencia en que mantiene una lista con un enlace doble en todas sus entradas.
 * Es más costosa, pero se define el orden de iteración, que normalmente es el orden
 * en que se insertaron las claves en el mapa. El orden de inserción no se verá 
 * afectado si una clave se reinserta en el mapa.
 * */

public class EjercicioLinkedHashMap {

	public static void main(String[] args) {
		LinkedHashMap<Integer,String> hashMap = new LinkedHashMap<>();
		hashMap.put(1, "1");
		hashMap.put(3, "3");
		hashMap.put(4, "4");
		hashMap.put(2, "2");
		hashMap.put(5, "5");
		System.out.println(hashMap.values());

	}

}
