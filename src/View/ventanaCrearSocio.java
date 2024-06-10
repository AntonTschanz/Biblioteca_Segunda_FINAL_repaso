package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.db.SociosConnect;

public class ventanaCrearSocio extends JFrame{
	public ventanaCrearSocio() {
		
		JPanel panelBorder = new JPanel(new BorderLayout());
		JPanel panelFlow = new JPanel(new FlowLayout());
		JPanel panelBox = new JPanel();
		panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.Y_AXIS));
		
		panelFlow.add(panelBox);
		panelBorder.add(panelFlow, BorderLayout.CENTER);
		
		//DNI
		JLabel lbl_dni = new JLabel("DNI:");
		JTextField txt_dni = new JTextField();
		txt_dni.setColumns(15);
		
		panelBox.add(lbl_dni);
		panelBox.add(txt_dni);
		
		//Nombre
		JLabel lbl_nombre = new JLabel("Nombre:");
		JTextField txt_nombre = new JTextField();
		
		panelBox.add(lbl_nombre);
		panelBox.add(txt_nombre);
		
		//Contrasena
		JLabel lbl_contrasena = new JLabel("Contraseña:");
		JPasswordField txt_contrasena = new JPasswordField();
		
		panelBox.add(lbl_contrasena);
		panelBox.add(txt_contrasena);
		
		//Direccion
		JLabel lbl_direccion = new JLabel("Dirección:");
		JTextField txt_direccion = new JTextField();
		
		panelBox.add(lbl_direccion);
		panelBox.add(txt_direccion);
		
		//Boton
		JButton btn_agregar = new JButton("Agregar");
		panelBox.add(btn_agregar);
		
		btn_agregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txt_dni.getText().equals("") || txt_nombre.getText().equals("") ||txt_contrasena.getText().equals("") || txt_direccion.getText().equals("")) {
					System.err.println("ERROR, DATOS EN BLANCO");
				} else {
					SociosConnect.insertSocio(txt_dni.getText(), txt_nombre.getText(), txt_direccion.getText(), txt_contrasena.getText() );
				}
				
				
			}
		});
		

		
//		setSize(400, 400);
		setContentPane(panelBorder);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Crear Socio");
		setVisible(true);
	}
}
