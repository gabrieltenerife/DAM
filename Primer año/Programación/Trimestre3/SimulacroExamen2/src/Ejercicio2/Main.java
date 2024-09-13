package Ejercicio2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		funcionprueba();

		
	}
	
	public static void funcionprueba() {
		ArrayList <Productos> tienda = new ArrayList <Productos>();
		Productos p = new TelefonoMovil (999, "Iphone11", "apple", 100, 15);
		Productos p1 = new TelefonoMovil (600, "Iphone10", "apple", 60, 25);
		Productos p2 = new Tablet (1200, "Ipad", "apple", 250, 5);
		Productos p3 = new Tablet (1800, "ipadpro", "apple", 1000, 10);
		tienda.add(p);
		tienda.add(p1);
		tienda.add(p2);
		tienda.add(p3);
		
		for(Productos e : tienda) {
			System.out.println(e.toString());
			System.out.print("w");
		}
	}
	
}
