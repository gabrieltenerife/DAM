package Natacion;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)

public class nadadortest3 {
	
	
	private int dificultad;
	private int puntuacion;
	private int puntuacionfinal;
	
	public nadadortest3(int dificultad, int puntuacion, int puntuacionfinal) {
		super();
		this.dificultad = dificultad;
		this.puntuacion = puntuacion;
		this.puntuacionfinal = puntuacionfinal;
	}

	@Parameters
	public static Collection<Object[]> datos(){
		return Arrays.asList(new Object[][] {{5,6,30},{1,0,0},{7,9,63}});
	}

	@Test
	public void testpuntuacionfinal() {
	
		nadador n = new nadador(dificultad, puntuacion);
		int Tfinal = n.puntuacionfinal(dificultad, puntuacion);
		assertEquals("Error",puntuacionfinal,Tfinal);
	}
}