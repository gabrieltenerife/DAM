import java.util.ArrayList;

public class Musico {

	private String nombre;
	private int formacion;
	private String genero;
	private String frontman;
	private String discorgrafica;
	private String PaisDeOrigen;
	private ArrayList <String> Discos;

	public Musico(String nombre, int formacion, String genero, String frontman, String paisDeOrigen, String discorgrafica, ArrayList <String> Discos) {
		this.nombre = nombre;
		this.formacion = formacion;
		this.genero = genero;
		this.frontman = frontman;
		PaisDeOrigen = paisDeOrigen;
		this.discorgrafica = discorgrafica;
		this.Discos = Discos;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFrontman() {
		return frontman;
	}

	public void setFrontman(String frontman) {
		this.frontman = frontman;
	}

	public String getDiscorgrafica() {
		return discorgrafica;
	}

	public void setDiscorgrafica(String discorgrafica) {
		this.discorgrafica = discorgrafica;
	}

	public String getPaisDeOrigen() {
		return PaisDeOrigen;
	}

	public void setPaisDeOrigen(String paisDeOrigen) {
		PaisDeOrigen = paisDeOrigen;
	}

	public ArrayList<String> getDiscos() {
		return Discos;
	}

	public void setDiscos(ArrayList<String> discos) {
		Discos = discos;
	}

	@Override
	public String toString() {
		return "El grupo se llama " + nombre + " formado en " + formacion + " y su estilo musical es " + genero;
	}
	
}