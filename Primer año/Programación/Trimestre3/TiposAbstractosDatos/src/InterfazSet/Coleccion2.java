package InterfazSet;
/* Es una tabla hash con enlaces que permite almacenar los elementos ordenados 
  según han sido insertados.
 * */
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Coleccion2 {

	public static void main(String[] args) {
		LinkedHashSet alumnos = new LinkedHashSet();

		alumnos.add("David");
		alumnos.add("Javier");
		alumnos.add(null);
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
