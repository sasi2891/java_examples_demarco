package org.protor.sandbox.salvatore.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.protor.filesio.utils.XMLUtils;
import org.protor.sandbox.salvatore.Car;
import org.protor.sandbox.salvatore.EnumEngineType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MYTest03 {

	public static void main(String[] args) {
		//C:\Users\PC4.DESKTOP-I9IUIOA\Desktop\github\java_examples_demarco\input

		//String fileName= "cars.xml";	
		//File carsFile=new File("input"+ File.separator +fileName); //dopo new è la chiamata al costruttore di questa classe

		if(args.length != 0 ) {
			//get the file name
			String filePath= args[0]; //in questa run configuration ho passato una stringa in inpur al main e creo unoggetto di tipo stringa e lo chiamo filename e lo associo alla mia stringa contenuta in posizione 0 dell array
			File carsFile=new File(filePath);
			if(!carsFile.exists()) { // . exist è un metodo della classe file che mi comunica se il file esiste o no con un booleano
				System.err.println("File " + carsFile.getAbsolutePath() +" not found./n"
						+"Terminating");
				System.exit(1);}

			System.out.println("Found file: " +carsFile.getAbsolutePath());
			System.out.println("----------Now reading XML content ---------");
			DocumentBuilderFactory dbFactory =DocumentBuilderFactory.newInstance(); //serve per fare il parsing degli xml mi crea un oggetto utilizzando una funzione statica new instance
			DocumentBuilder dBuilder;
			try {
				dBuilder=dbFactory.newDocumentBuilder(); //qui è diverso utilizzo un metodo e non una funzione statica
				Document doc = dBuilder.parse(carsFile);//quest oggetto c ha un interfaccia che vuole un file che devi fare tramite una factory
				//prendo un oggetto utilizzio una funzione di quest oggetto per creare un altro oggetto
				//Document doc;
				System.out.println("File XML parsed.");//ho creato l oggetto e lo posso utilizzare
			doc.getDocumentElement().normalize();
			System.out.println("Root Element : "+ doc.getDocumentElement().getNodeName());  //ci dovrebbe dare cars il nome del primo nodo la radice
			NodeList nodeList = doc.getElementsByTagName("car"); //creo un oggetto di tipo nodelist che mi dice i nodi e con getlenght mi dice quante di quelle stringhe ci sono nel document
			System.out.println("N. cars: " + nodeList.getLength());
			
			
			
			List<Car> cars= new ArrayList<>();
			
			for(int iNode =0; iNode<nodeList.getLength();iNode++ ) {
				Node node = nodeList.item(iNode);//certa entità che mi indica un elemento in una generico documento mi fa accedere all iesimo nodo
			System.out.println("\n Current Element :"+ node.getNodeName());
			if(node.getNodeType()==Node.ELEMENT_NODE) {
				
			Element elem=(Element)node; //sto facendo un casting trsformo node in un oggetto di classe element
			NamedNodeMap attributesMap = elem.getAttributes();
			System.out.println("N. Attributes: "+ attributesMap.getLength());
			System.out.println("Car id :"+ elem.getAttribute("id"));
			
			String carName =XMLUtils.getXMLPropertyByPath(node, "//name/text()"); //X path serve a cercare i nodi all interno degli alberi xml  
			System.out.println("Car name:  "+carName);
			String passString=XMLUtils.getXMLAttributesByPath(node,"//passengers/text()", "value").get(0);
			System.out.println("Passengers: "+ passString);
			int pass=Integer.parseInt(passString);
			//create an object of class car
			EnumEngineType engineType;
			String engineTypeString=XMLUtils.getXMLAttributesByPath(node,"//engine_type/text()", "value").get(0).toUpperCase();
			switch (engineTypeString) {
			case "THERMICAL":
				engineType=EnumEngineType.THERMICAL;
				
				break;
			case "HYBRID":
				engineType=EnumEngineType.HYBRID;
				
				break;
			case "ELECTRIC":
				engineType=EnumEngineType.ELECTRIC;
				
				break;
			
			
			}
			double range=Double.parseDouble(s)
		
			}
			}
			
			
			
			
			} catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			} 

		}


		else {
			System.err.println(" You must run this program with the arguments. \n"
					+ "Terminating.");
			System.exit(1);

		}

	}
}