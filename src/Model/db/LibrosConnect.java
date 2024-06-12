package Model.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Libros;

public class LibrosConnect {
	public static ArrayList<Libros> getLibros(){
		ArrayList<Libros> lList = new ArrayList<Libros>();
		Connection con = Controller.conexion();
		
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM libros";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String genero = rs.getString("genero");
				int anio = rs.getInt("anio");
				Libros l = new Libros(codigo, titulo, genero, anio);
				lList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error en getLibros()");
		}
		
		return lList;
	}
	
	public static void insertLibro(String titulo, String genero, int anio) {
		Connection con = Controller.conexion();
		
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO libros(titulo, genero, anio) VALUES ('" + titulo + "', '" + genero + "'," + anio + ")";
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error en insertLibro()");
		}
	}
	
	public static ArrayList<Libros> getLibrosXgenero(String xgenero){
		ArrayList<Libros> lList = new ArrayList<Libros>();
		Connection con = Controller.conexion();
		
		try {
			Statement st = con.createStatement();
			String sql = "SELECT * FROM libros WHERE genero = '" + xgenero + "'";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int codigo = rs.getInt("codigo");
				String titulo = rs.getString("titulo");
				String genero = rs.getString("genero");
				int anio = rs.getInt("anio");
				Libros l = new Libros(codigo, titulo, genero, anio);
				lList.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error en getLibrosXgenero()");
		}
		
		return lList;
	}
}
