package presencial;

public abstract class articulos {
	protected String id, titulo;
	protected int ejemplares;
	protected int prestados;

	protected articulos(String id, String titulo, int ejemplares) {
		this.id = id;
		this.titulo = titulo;
		this.ejemplares = ejemplares;
		prestados = ejemplares;
	}

	protected String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected int getEjemplares() {
		return ejemplares;
	}

	protected void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}

	protected int getPrestados() {
		return prestados;
	}

	protected void setPrestados(int prestados) {
		this.prestados = prestados;
	}
	
	protected void restarPrestados() {
		prestados--;
	}
	
	protected void sumarPrestados() {
		prestados++;
	}
	
	@Override
	public String toString() {
		return "articulos [id=" + id + ", titulo=" + titulo + ", ejemplares=" + ejemplares + "]";
	}

	
	
	
	
}
