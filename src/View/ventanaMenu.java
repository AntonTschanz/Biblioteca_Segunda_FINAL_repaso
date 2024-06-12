package View;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilderFactory;

import Model.Libros;
import Utils.escribirLeer;

public class ventanaMenu extends JFrame{
	public ventanaMenu() {
		
		JPanel panelBorder = new JPanel(new BorderLayout());
		JPanel panelGrid = new JPanel(new GridLayout(2, 2));
		JPanel panelGrid2 = new JPanel(new GridLayout(2, 1)); //Este grid es para poner el jmenubar y el titulo 
		
		panelBorder.add(panelGrid, BorderLayout.CENTER);
		panelBorder.add(panelGrid2, BorderLayout.NORTH); 
		
		Font fuente = new Font("Arial", Font.BOLD, 17);
		
		//JMenuBar (xml y binario)
		JMenuBar mb = new JMenuBar();
		JMenu opciones = new JMenu("Ajustes");
		
		JMenuItem cargarXML = new JMenuItem("Cargar XML");
		JMenuItem cargarBinario = new JMenuItem("Cargar Binario");
		JMenuItem crearBinarioLibros = new JMenuItem("Crear Binario Libros");
		
		mb.add(opciones);
		opciones.add(cargarXML);
		opciones.add(cargarBinario);
		opciones.add(crearBinarioLibros);
		
		panelGrid2.add(mb);
		
		cargarXML.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] cols = {"id", "titulua", "generoa", "urtea"};
				String ficheroXML = "Ficheros/liburuak.xml";
				ArrayList<Libros> lList = escribirLeer.leerXML(ficheroXML);
				
				ventanaTablaXMLyBinario vtxb = new ventanaTablaXMLyBinario(cols, lList);
			}
		});
		
		cargarBinario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] cols = {"codigo", "titulo", "genero", "anio"};
				String ficheroBinario = "Ficheros/Generados/libros.bin";
				ArrayList<Libros> lList = escribirLeer.leerBinario(ficheroBinario);
				
				ventanaTablaXMLyBinario vtxb = new ventanaTablaXMLyBinario(cols, lList);
			}
		});
		
		crearBinarioLibros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				escribirLeer.crearBinarioLibros();
				
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
