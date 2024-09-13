package presencial;

public class revista extends articulos{

	protected String numPaginas,editorial;
	
	protected revista(String id, String titulo, int ejemplares, String numPaginas, String editorial) {
		super(id, titulo, ejemplares);
		this.numPaginas = numPaginas;
		this.editorial = editorial;
	}

	protected String getNumPaginas() {
		return numPaginas;
	}

	protected void setNumPaginas(String numPaginas) {
		this.numPaginas = numPaginas;
	}

	protected String getEditorial() {
		return editorial;
	}

	protected void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	
}
