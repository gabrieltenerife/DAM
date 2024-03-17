package TreeMap;

import java.util.TreeMap;

/* Es bastante más lento que HashMap, ya que almacena las claves ordenadas ascenden-
 * temente en un árbol. Las claves deben implementar la interfaz Comparable.
 * En esta colección no se admiten valores null.
 * */

public class EjercicioTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer,String> puntuaciones = new TreeMap<>();
		puntuaciones.put(8, "Notable");
		puntuaciones.put(5, "Aprobado");
		puntuaciones.put(10, "Matricula");
		puntuaciones.put(6, "Bien");
		puntuaciones.put(9, "Sobresaliente");
		puntuaciones.put(7, "Notable");
		System.out.println(puntuaciones.values());
		puntuaciones.replace(7, "Notable", "Notable bajo");
		System.out.println(puntuaciones.values());
		System.out.println("Por debajo de "+puntuaciones.firstKey()+" es suspenso");
		

	}

}
