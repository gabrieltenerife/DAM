package Tienda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

class Test {
	
	@RunWith(Parameterized.class)
	private int precio;
	private int cantidad;
	private int descuento;
	private int resultado;
	
	public Test(int precio, int cantidad, int descuento, int resultado) {
		super();
		this.precio = precio;
		this.cantidad = cantidad;
		this.descuento = descuento;
		this.resultado = resultado;
	}
	
	@Parameters
	public static Collection<Object[]> datos(){
		return Arrays.asList(new Object[][] {{50,2,10,90},{100,1,50,50},{10,10,10,90}});
	}
	
	@Test
	public void testcompratele () {
		Televisores e = new Televisores (precio,cantidad,descuento);
		int resultadofinal = e.preciototal(precio, cantidad, descuento);
		assertEquals("Error",resultado,resultadofinal);
	}
}