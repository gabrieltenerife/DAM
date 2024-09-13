package Ejercicio2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
	
		ArrayList<Producto>lista=new ArrayList<Producto>();
		TelefonoMovil t1 = new TelefonoMovil(1500,"Iphone15","Apple",128,50);
		TelefonoMovil t2 = new TelefonoMovil(1000,"Iphone14","Apple",128,80);
		Tablet t3 = new Tablet(700,"SamsungSurface","Samsung",128,310);
		Tablet t4 = new Tablet(1000,"Tablexiao","Xiaomi",128,80);
		
		lista.add(t1);
		lista.add(t2);
		lista.add(t3);
		lista.add(t4);
		
		for(Producto p:lista) {
			System.out.println(p.toString());
		}

	}
}
