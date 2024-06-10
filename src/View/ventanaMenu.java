package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ventanaMenu extends JFrame{
	public ventanaMenu() {
		
		//Falta el filtro de la tabla de listar los libros por generos
		//Falta que los botones del JMenuBar(Xml y binario) funcionen, 
		//y crear su respectiva ventana que seria una tabla que muestra los datos.
		
		JPanel panelBorder = new JPanel(new BorderLayout());
		JPanel panelGrid = new JPanel(new GridLayout(2, 2));
		JPanel panelGrid2 = new JPanel(new GridLayout(2, 1));
		
		panelBorder.add(panelGrid, BorderLayout.CENTER);
		panelBorder.add(panelGrid2, BorderLayout.NORTH); //Este grid es para poner el jmenubar y el titulo de debajo
		
		Font fuente = new Font("Arial", Font.BOLD, 17);
		
		//JMenuBar (xml y binario)
		JMenuBar mb = new JMenuBar();
		JMenu opciones = new JMenu("Ajustes");
		
		JMenuItem cXML = new JMenuItem("Cargar XML");
		JMenuItem cBinario = new JMenuItem("Cargar Binario");
		
		mb.add(opciones);
		opciones.add(cXML);
		opciones.add(cBinario);
		
		panelGrid2.add(mb);
		
		cXML.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		cBinario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
		//Titulo
		JLabel lbl_titulo = new JLabel("Biblioteca Zornotza");
		lbl_titulo.setFont(fuente);
		panelGrid2.add(lbl_titulo);
		
		//Botones
		JButton btn_listaLibros = new JButton("Lista de libros");
		JButton btn_crearLibro = new JButton("Crear libro");
		JButton btn_crearReserva = new JButton("Hacer reserva");
		JButton btn_crearSocio = new JButton("Crear socio");
		
		panelGrid.add(btn_listaLibros);
		panelGrid.add(btn_crearLibro);
		panelGrid.add(btn_crearReserva);
		panelGrid.add(btn_crearSocio);
		
		btn_listaLibros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaListaLibros vll = new ventanaListaLibros();
				
			}
		});
		
		btn_crearLibro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaRegistrarLibros vrl = new ventanaRegistrarLibros();
				
			}
		});
		
		btn_crearReserva.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaReserva vr = new ventanaReserva();
				
			}
		});
		
		btn_crearSocio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaCrearSocio vcs = new ventanaCrearSocio();
				
			}
		});
		
		setSize(600, 400);
		setContentPane(panelBorder);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Menú");
		setVisible(true);
	}

	public static void main(String[] args) {
		ventanaMenu vm = new ventanaMenu();

	}

}
