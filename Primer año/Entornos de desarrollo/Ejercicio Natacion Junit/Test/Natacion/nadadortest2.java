package Natacion;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class nadadortest2 {
	
	private int edad;
	private boolean apto;
	
	public nadadortest2(int edad, boolean apto) {
		super();
		this.edad = edad;
		this.apto = apto;
	}

	@Parameters
	public static Collection<Object[]> datos(){
		return Arrays.asList(new Object[][] {{18,true},{40,true},{15,false}});
	}

	@Test
	public void testedad() {
	
		nadador n = new nadador(edad);
		boolean mayoredad = n.mayordeedad(edad);
		assertEquals(apto,mayoredad);
	}
}