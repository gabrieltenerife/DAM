public class Musico {

	private String nombre;
	private int formacion;
	private String genero;
	
	public Musico(String nombre, int formacion, String genero) {
		super();
		this.nombre = nombre;
		this.formacion = formacion;
		this.genero = genero;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFormacion() {
		return formacion;
	}
	public void setFormacion(int formacion) {
		this.formacion = formacion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "El grupo se llama " + nombre + " formado en " + formacion + " y su estilo musical es " + genero;
	}
	
}