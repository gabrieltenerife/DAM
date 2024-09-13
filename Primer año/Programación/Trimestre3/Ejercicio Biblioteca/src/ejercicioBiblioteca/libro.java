package ejercicioBiblioteca;

public class libro {
	//Atributos o propiedades de un libro
	protected String titulo, isbn, autor, genero, publicacion;
	protected int numEjemplares;
	
	//Constructores
	protected libro() {
		
	}

	protected libro(String titulo, String isbn, String autor, String genero, String publicacion, int ejemplares) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
		this.genero = genero;
		this.publicacion = publicacion;
		numEjemplares = ejemplares;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected String getIsbn() {
		return isbn;
	}

	protected void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	protected String getAutor() {
		return autor;
	}

	protected void setAutor(String autor) {
		this.autor = autor;
	}

	protected String getGenero() {
		return genero;
	}

	protected void setGenero(String genero) {
		this.genero = genero;
	}

	protected String getPublicacion() {
		return publicacion;
	}

	protected void setPublicacion(String publicacion) {
		this.publicacion = publicacion;
	}

	protected int getNumEjemplares() {
		return numEjemplares;
	}

	protected void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}
	
	protected void prestamo() {
		numEjemplares--;
	}
	protected void devolucion() {
		numEjemplares++;
	}
}
