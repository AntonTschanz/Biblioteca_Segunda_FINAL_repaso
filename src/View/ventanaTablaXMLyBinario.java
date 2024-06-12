package View;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Libros;

public class ventanaTablaXMLyBinario extends JFrame{
	public ventanaTablaXMLyBinario(String[] cols, ArrayList<Libros> lList) {
		
		JPanel panelBorder = new JPanel(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		panelBorder.add(scroll, BorderLayout.CENTER);
		
		DefaultTableModel dtm = new DefaultTableModel();
		
		
		for(String col : cols) {
			dtm.addColumn(col);
		}
		
		for(Libros l : lList) {
			dtm.addRow(new Object[] {l.getCodigo(), l.getTitulo(), l.getGenero(), l.getAnio()});
		}
		
		JTable tabla = new JTable(dtm);
		
		scroll.setViewportView(tabla);
		
		
		
		
		
		setSize(600, 400);
		setContentPane(panelBorder);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Lista de XML/Binario");
		setVisible(true);
	}
}
