package Concecionario;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
class Test {
	
	private int descuento;
	private int dias;
	private int preciodia;
	private int preciofinal;
	
	public Test(int descuento, int dias, int preciodia, int preciofinal) {
		super();
		this.descuento = descuento;
		this.dias = dias;
		this.preciodia = preciodia;
		this.preciofinal = preciofinal;
	}
	
	@Parameters
	
	public static Collection <Objects[]> datos (){
		return Arrays.asList(new Object[][] {{1,5,2,9},{2,5,2,8},{0,0,3,-1}})
	}
	
	@Test
	
	public void test() {
		Alquiler a = new Alquiler (descuento,dias,preciodia);
		int resultado = a.reservar(dias, preciodia, descuento);
		assertEquals("Error",preciofinal,resultado);
	}
}
