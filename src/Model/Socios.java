package Model;

public class Socios {
	private String documento;
	private String nombre;
	private String domicilio;
	private String contrasena;
	
	public Socios() {
		
	}
	
	public Socios(String documento, String nombre, String domicilio, String contrasena) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.contrasena = contrasena;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "Socios [documento=" + documento + ", nombre=" + nombre + ", domicilio=" + domicilio + ", contrasena="
				+ contrasena + "]";
	}
	
}
