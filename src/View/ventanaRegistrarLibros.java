package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Libros;
import Model.db.LibrosConnect;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ventanaRegistrarLibros extends JFrame{
    private JTextField txt_titulu;
    private JComboBox<String> comboGenero;
    private JTextField txt_urtea;
    private LibrosConnect lM=new LibrosConnect();
    
    
    public ventanaRegistrarLibros() {
        initialize();
    }

    private void initialize() {
    	setLocationRelativeTo(null);
        setTitle("Liburuen Erregistroa");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(542, 193);


        JPanel panelPrincipal = new JPanel(new BorderLayout());


        JPanel panelSuperior = new JPanel(new FlowLayout());
        JLabel titulo = new JLabel("Formulario de Registro de Libros");
        panelSuperior.add(titulo);

        JPanel panelCentral = new JPanel(new GridLayout(4, 2));
        
        JLabel lbl_titulua = new JLabel("Titulo:");
        txt_titulu = new JTextField();
        JLabel lbl_generoa = new JLabel("Genero:");
        
        comboGenero = new JComboBox<>();
        //Gehitu genero guztiak hemen
        
        comboGenero.addItem("Ficción");
        comboGenero.addItem("No ficción");
        comboGenero.addItem("Ciencia ficción");
        comboGenero.addItem("Fantasía");
        comboGenero.addItem("Misterio");
        
        JLabel lbl_urtea = new JLabel("Año:");
        txt_urtea = new JTextField();
        
        panelCentral.add(lbl_titulua);
        panelCentral.add(txt_titulu);
        panelCentral.add(lbl_generoa);
        panelCentral.add(comboGenero);
        
        panelCentral.add(lbl_urtea);
        panelCentral.add(txt_urtea);
        // Erregistro botoia
        JButton botonRegistrar = new JButton("Erregistratu");
        
        botonRegistrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LibrosConnect.insertLibro(txt_titulu.getText(), (String) comboGenero.getSelectedItem(), Integer.parseInt(txt_urtea.getText()));
				
			}
		});
        
        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        
        
        
        txt_urtea.setColumns(10);
        
        
        panelPrincipal.add(botonRegistrar, BorderLayout.SOUTH);

        // Gehitu panel nagusia JFrame-era
        getContentPane().add(panelPrincipal);

        setVisible(true);
	}
	
}
