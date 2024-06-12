package Model;

import java.io.Serializable;
//Hay que agregar el "implements Serializable" si queremos trabajar con los ficheros binarios.
public class Libros implements Serializable{
	private int codigo;
	private String titulo;
	private String genero;
	private int anio;
	
	public Libros() {
		
	}
	
	public Libros(int codigo, String titulo, String genero, int anio) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.genero = genero;
		this.anio = anio;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Libros [codigo=" + codigo + ", titulo=" + titulo + ", genero=" + genero + ", anio=" + anio + "]";
	}
	
}
