package HashMap;

import java.util.HashMap;

/* La interfaz Map permite almacenar pares clave-valor de manera que sea más fácil
 * buscar un valor a partir de su clave. Las colecciones que implementan Map no pueden
 * contener claves duplicadas. Cada clave únicamente se corresponderá con un valor.
 * */

/* Almacena las claves en una tabla hash admitiendo incluso una entrada null.
 * Es la implementación con mejor rendimiento de todas, pero no garantiza ningún 
 * orden a la hora de realizar las iteraciones. 
 * */

public class EjercicioHashMap {

	public static void main(String[] args) {
		HashMap<Integer,String> hashMap = new HashMap<>();
		hashMap.put(1, "1");
		hashMap.put(3, "3");
		hashMap.put(4, "4");
		hashMap.put(2, "2");
		hashMap.put(5, "5");
		System.out.println(hashMap.values());

	}

}
