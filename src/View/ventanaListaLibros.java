package View;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Libros;
import Model.db.LibrosConnect;

public class ventanaListaLibros extends JFrame{
	public ventanaListaLibros() {
		
		//Falta hacer el filtro de la tabla.
		
		String[] cols = {"codigo", "titulo", "genero", "anio"};
		ArrayList<Libros> lList = LibrosConnect.getLibros();
		
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		panel.add(scroll, BorderLayout.CENTER);
		
		DefaultTableModel dtm = new DefaultTableModel();
		
		for(String col : cols) {
			dtm.addColumn(col);
		}
		
		for(Libros l : lList) {
			dtm.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getGenero(), l.getAnio()});
		}
		
		JTable tabla = new JTable(dtm);
		
		scroll.setViewportView(tabla);
		
		//Filtro
		
		JComboBox<String> combo_filtro = new JComboBox<String>();
		
		combo_filtro.addItem("Ficción");
		combo_filtro.addItem("Fantasía");
		combo_filtro.addItem("Ciencia ficción");
		combo_filtro.addItem("Misterio");
		combo_filtro.addItem("No ficción");
		
//		if(combo_filtro.getSelectedItem()) {
//			
//		}
		
		
		panel.add(combo_filtro, BorderLayout.SOUTH);
		
		
		setSize(600, 400);
		setContentPane(panel);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Lista de libros");
		setVisible(true);
	}
}
