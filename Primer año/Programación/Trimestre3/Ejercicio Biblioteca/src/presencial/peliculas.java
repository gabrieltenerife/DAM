package presencial;

public class peliculas extends articulos {

	protected int duracion;

	protected peliculas(String id, String titulo, int ejemplares, int duracion) {
		super(id, titulo, ejemplares);
		this.duracion = duracion;
	}

	protected int getDuracion() {
		return duracion;
	}

	protected void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
		
}
