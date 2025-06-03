package modelo;

import java.time.LocalDate;

public class Prestamos {

	private int id;
	private String isbn;
	private int id_socio;
	private LocalDate fecha_prestamo;
	
	public Prestamos(int id, String isbn, int id_socio, LocalDate fecha_prestamo) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.id_socio = id_socio;
		this.fecha_prestamo = fecha_prestamo;
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public int getId_socio() {
		return id_socio;
	}

	public LocalDate getFecha_prestamo() {
		return fecha_prestamo;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setId_socio(int id_socio) {
		this.id_socio = id_socio;
	}

	public void setFecha_prestamo(LocalDate fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}

	
	
}
