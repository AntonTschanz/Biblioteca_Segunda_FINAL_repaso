package Model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Socios;

public class SociosConnect {
	public static ArrayList<Socios> getSocios(){
		ArrayList<Socios> sList = new ArrayList<Socios>();
		Connection con = Controller.conexion();
		
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM socios";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String domicilio = rs.getString("domicilio");
				String contrasena = rs.getString("contrasena");
				Socios s = new Socios(documento, nombre, domicilio, contrasena);
				sList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error en statement getSocios()");
		}
		
		return sList;
	}
	
	public static boolean buscarSocio(String usuario, String contrasena) {
		ArrayList<Socios> sList = getSocios();
		boolean encontrado = false;
		for(Socios s : sList) {
			if(s.getNombre().equals(usuario) && s.getContrasena().equals(contrasena)) {
				encontrado = true;
			}
		}
		
		return encontrado;
	}
	
	public static void insertSocio(String documento, String nombre, String domicilio, String contrasena) {
		Connection con = Controller.conexion();
		
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO socios VALUES ('" + documento + "', '" + nombre + "', '" + domicilio + "', '" + contrasena + "')";
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error en insertSocio()");
		}
	}
}
