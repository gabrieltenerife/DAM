package natacion;

public class nadador {

	//Variables
	protected String nombre, dni, fecha;
	protected int dorsal, puntuacion, dificultad;
	
	//Constructores
	public nadador() {
		super();
	}
	public nadador(String nombre, String dni, String fecha, int dorsal, int puntuacion, int dificultad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.fecha = fecha;
		this.dorsal = dorsal;
		this.puntuacion = puntuacion;
		this.dificultad = dificultad;
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