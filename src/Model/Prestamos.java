package Model;

public class Prestamos {
	private String documento;
	private int codigolibro;
	private String fechaprestamo;
	private String fechadevolucion;
	
	public Prestamos() {
		
	}
	
	public Prestamos(String documento, int codigolibro, String fechaprestamo, String fechadevolucion) {
		super();
		this.documento = documento;
		this.codigolibro = codigolibro;
		this.fechaprestamo = fechaprestamo;
		this.fechadevolucion = fechadevolucion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public int getCodigolibro() {
		return codigolibro;
	}

	public void setCodigolibro(int codigolibro) {
		this.codigolibro = codigolibro;
	}

	public String getFechaprestamo() {
		return fechaprestamo;
	}

	public void setFechaprestamo(String fechaprestamo) {
		this.fechaprestamo = fechaprestamo;
	}

	public String getFechadevolucion() {
		return fechadevolucion;
	}

	public void setFechadevolucion(String fechadevolucion) {
		this.fechadevolucion = fechadevolucion;
	}

	@Override
	public String toString() {
		return "Prestamos [documento=" + documento + ", codigolibro=" + codigolibro + ", fechaprestamo=" + fechaprestamo
				+ ", fechadevolucion=" + fechadevolucion + "]";
	}
	
}
