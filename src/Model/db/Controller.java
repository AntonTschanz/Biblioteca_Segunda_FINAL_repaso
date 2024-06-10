package Model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Controller {
	public static Connection conexion() {
		String URI = "jdbc:mysql://localhost:3306/bibliotecabd";
		String usr = "root";
		String psw = "";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URI, usr, psw);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error en conexion()");
		}
		
		return con;
	}
}
