package Model.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PrestamosConnect {
	public static void insertPrestamo(String documento, int codigolibro, String fechaprestamo, String fechadevolucion) {
		Connection con = Controller.conexion();
		
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO prestamos VALUES ('" + documento + "'," + codigolibro + ", '" + fechaprestamo + "', '" + fechadevolucion + "')";
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error en insertPrestamo()");
		}
	}
}
