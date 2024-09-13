package Natacion;

public class nadador {

	//Variables
	private int edad, puntuacion, dificultad;
	//Constructores
	public nadador() {
	}
	public nadador(int puntuacion, int dificultad) {
		this.puntuacion = puntuacion;
		this.dificultad = dificultad;
	}

	public nadador(int edad) {
		this.edad = edad;
	}
	//Metodos
	public static int puntuacionfinal(int dificultad, int puntuacion) {	
		int puntuacionfinal = dificultad * puntuacion;
		return puntuacionfinal;
	}
	
	public static boolean mayordeedad(int edad) {
		boolean apto = false;
		if(edad>=18) {
			apto = true;
		} 
		return apto;
	}
}