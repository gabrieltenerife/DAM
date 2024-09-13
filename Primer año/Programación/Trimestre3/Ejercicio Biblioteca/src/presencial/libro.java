package presencial;

public class libro extends articulos{

	protected String isbn;
	
	protected libro(String id, String titulo, int ejemplares, String isbn) {
		super(id, titulo, ejemplares);
		this.isbn = isbn;
	}

	protected String getIsbn() {
		return isbn;
	}

	protected void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
