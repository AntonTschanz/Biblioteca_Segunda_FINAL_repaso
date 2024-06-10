package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Model.db.SociosConnect;

public class ventanaLogin extends JFrame{
	public ventanaLogin() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		Font fuente = new Font("Arial", Font.BOLD, 40);
		
		//Titulo
		JLabel lbl_titulo = new JLabel("BIBLIOTECA ZORNOTZA");
		lbl_titulo.setFont(fuente);
		lbl_titulo.setBounds(45, 20, 600, 50);
		panel.add(lbl_titulo);
		
		//Usuario
		JLabel lbl_usuario = new JLabel("Usuario:");
		lbl_usuario.setBounds(190, 140, 50, 20);
		panel.add(lbl_usuario);
		
		JTextField txt_usuario = new JTextField();
		txt_usuario.setBounds(270, 140, 100, 20);
		panel.add(txt_usuario);
		
		//Contraseña
		JLabel lbl_contrasena = new JLabel("Contraseña:");
		lbl_contrasena.setBounds(190, 190, 80, 20);
		panel.add(lbl_contrasena);
		
		JPasswordField txt_contrasena = new JPasswordField();
		txt_contrasena.setBounds(270, 190, 100, 20);
		panel.add(txt_contrasena);
		
		//Boton enviar
		
		JButton btn_enviar = new JButton("Entrar");
		btn_enviar.setBounds(230, 250, 100, 25);
		panel.add(btn_enviar);
		
		btn_enviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(SociosConnect.buscarSocio(txt_usuario.getText(), txt_contrasena.getText())) {
					dispose();
					ventanaMenu vm = new ventanaMenu();
				}
				
			}
		});
		
		setSize(600, 400);
		setContentPane(panel);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Login");
		setVisible(true);
	}

}
