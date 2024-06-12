package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		String[] cols = {"codigo", "titulo", "genero", "anio"};
		
		JPanel panel = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		panel.add(scroll, BorderLayout.CENTER);
		
		DefaultTableModel dtm = new DefaultTableModel();
		
		for(String col : cols) {
			dtm.addColumn(col);
		}
		
		JTable tabla = new JTable(dtm);
		
		scroll.setViewportView(tabla);
		
		//Filtro
		JComboBox<String> combo_filtro = new JComboBox<String>();
		combo_filtro.addItem("Todos");
		combo_filtro.addItem("Ficción");
		combo_filtro.addItem("Fantasía");
		combo_filtro.addItem("Ciencia ficción");
		combo_filtro.addItem("Misterio");
		combo_filtro.addItem("No ficción");
		
		//Cargar todos los libros inicialmente
		cargarLibros(dtm, LibrosConnect.getLibros(), null);
		
		
		combo_filtro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(combo_filtro.getSelectedItem().equals("Todos")) {
					cargarLibros(dtm, LibrosConnect.getLibros(), null);
				} else {
					cargarLibros(dtm, null, LibrosConnect.getLibrosXgenero((String) combo_filtro.getSelectedItem()));
				}
				
			}
		});
		
		panel.add(combo_filtro, BorderLayout.SOUTH);
		
		
		setSize(600, 400);
		setContentPane(panel);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Lista de libros");
		setVisible(true);
	}
	
	private void cargarLibros(DefaultTableModel dtm, ArrayList<Libros> lList, ArrayList<Libros> lListXgenero) {
		dtm.setRowCount(0);
		
		if(lList != null) {
			for(Libros l : lList) {
				dtm.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getGenero(), l.getAnio()});
			}
		} else {
			for(Libros l : lListXgenero) {
				dtm.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getGenero(), l.getAnio()});
			}
		}
		
		
		
		
	}
}
