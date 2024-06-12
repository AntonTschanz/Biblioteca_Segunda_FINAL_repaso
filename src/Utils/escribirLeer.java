package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import Model.Libros;
import Model.db.LibrosConnect;

public class escribirLeer {
	//XML
	public static ArrayList<Libros> leerXML(String ficheroXML){
		ArrayList<Libros> lList = new ArrayList<Libros>();
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse(ficheroXML);
			
			NodeList nl = d.getElementsByTagName("liburua");
			
			for(int i = 0; i < nl.getLength(); i++) {
				Node node = nl.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
					String titulua = element.getElementsByTagName("titulua").item(0).getTextContent();
					String generoa = element.getElementsByTagName("generoa").item(0).getTextContent();
					int urtea = Integer.parseInt(element.getElementsByTagName("urtea").item(0).getTextContent());
					
					lList.add(new Libros(id, titulua, generoa, urtea));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lList;
	}
	
	//BINARIOS
	public static void crearBinarioLibros() {
		ArrayList<Libros> lList = LibrosConnect.getLibros();
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("Ficheros/Generados/libros.bin")))) {
			oos.writeObject(lList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static ArrayList<Libros> leerBinario(String ficheroBinario){
		ArrayList<Libros> lList = new ArrayList<Libros>();
		
		try {
			File f = new File(ficheroBinario);
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			lList = (ArrayList<Libros>) ois.readObject();
			
		} catch (Exception e) { //Dentro del parentesis hay que poner "Exception e" manualmente
			e.printStackTrace();
		}
		
		return lList;
	}
	
}
