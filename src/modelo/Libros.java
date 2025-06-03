package modelo;

public class Libros {

	private String isbn;
	private String titulo;
	private String autor;
	private String genero;
	private int anio_publicacion;
	private boolean disponible;

	public Libros(String isbn, String titulo, String autor, String genero, int anio_publicacion, boolean disponible) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.anio_publicacion = anio_publicacion;
		this.disponible = disponible;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getGenero() {
		return genero;
	}

	public int getAnio_publicacion() {
		return anio_publicacion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setAnio_publicacion(int anio_publicacion) {
		this.anio_publicacion = anio_publicacion;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

}
