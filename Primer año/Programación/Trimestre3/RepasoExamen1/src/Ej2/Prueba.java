package Ej2;

import java.util.ArrayList;

public class Prueba {

	public static void main(String[] args) {
		
		ArrayList<Producto>array=new ArrayList<Producto>();
		Tablet t = new Tablet (150,"Macair","apple",64,0);
		Telefonomovil e = new Telefonomovil (160,"iphone","samsung",64,10);
		array.add(e);
		array.add(t);
		
		for(Producto p : array) {
			System.out.println(p.toString());
			if(p.getClass().equals(e)) {
				System.out.println(e.calcularPrecioFinal(e.precio, e.descuento));
			}
			else {
				System.out.println(t.calcularPrecioFinal(t.precio, t.descuento));
			}
			
		
			//System.out.println(p.calcularPrecioFinal(p.precio, p.getClass()));
		}
	
	}

}
