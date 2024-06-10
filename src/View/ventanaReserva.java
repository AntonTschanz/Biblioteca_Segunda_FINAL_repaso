package View;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Libros;
import Model.Socios;
import Model.db.LibrosConnect;
import Model.db.PrestamosConnect;
import Model.db.SociosConnect;

public class ventanaReserva extends JFrame {

	public static void main(String[] args) {
		new ventanaReserva();
	}

	private JTextField txtFechaPrestamo;
	private JTextField txtFechaDevolucion;
	private JComboBox combo_socios;
	private JComboBox combo_libros;
	ArrayList<Socios> sList = SociosConnect.getSocios();
	ArrayList<Libros> lList = LibrosConnect.getLibros();

	public ventanaReserva() {
		initialize();
	}

	private void initialize() {
		setSize(257, 234);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(new JLabel("ID Socio:"));

		combo_socios = new JComboBox();
		combo_socios.addItem("Seleccionar Opcion");
		// Gainontzeko Datuak Sartu
		
		for(Socios s : sList) {
			combo_socios.addItem(s.getDocumento());
		}
		
		combo_libros = new JComboBox();
		combo_libros.addItem("Seleccionar Opcion");
		// Gainontzeko Datuak Sartu
		
		for(Libros l : lList) {
			combo_libros.addItem(l.getCodigo());
		}
		
		
		getContentPane().add(combo_socios);
		getContentPane().add(new JLabel("ID Libro:"));
		getContentPane().add(combo_libros);
		getContentPane().add(new JLabel("Fecha Prestamo:"));
		txtFechaPrestamo = new JTextField(20);
		getContentPane().add(txtFechaPrestamo);
		getContentPane().add(new JLabel("Fecha devolución:"));
		txtFechaDevolucion = new JTextField(20);
		getContentPane().add(txtFechaDevolucion);
		JButton btnAgregar = new JButton("Agregar");
		
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrestamosConnect.insertPrestamo((String) combo_socios.getSelectedItem(), (int) combo_libros.getSelectedItem(), txtFechaPrestamo.getText(), txtFechaDevolucion.getText());
				
			}
		});
		
		
		
		getContentPane().add(btnAgregar);
		setVisible(true);
	}

}



