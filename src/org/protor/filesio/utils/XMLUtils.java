package org.protor.filesio.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.vavr.Tuple2;

public class XMLUtils {

	/**
	 * Prints on standard output stream the content of a file
	 * @param fileName a valid file name
	 * @return number of lines printed
	 * @throws IOException
	 */
	public static int printFileContent(String fileName) throws IOException {

		File theFile = new File(fileName);

		if (!theFile.exists() || theFile.isDirectory())
			return 0;

		FileReader fr;
		fr = new FileReader(theFile);
		System.out.println("[XMLUtils.printFileContent] Reading file, line by line...");

		BufferedReader br = new BufferedReader(fr);
		String currentLine;
		int counter = 0;

		while ((currentLine = br.readLine()) != null) {
			System.out.println(++counter + ": " + currentLine);
		}
		return counter;
	}

	/**
	 * Get a list of occurrences of an attribute for a given XPath search string
	 * into a _node_
	 *
	 * @author Agostino De Marco
	 * @param node to start searching
	 * @param path to node where attribute is searched for
	 * @param attribute label
	 * @return list of attribute values
	 */	
	public static List<String> getXMLAttributesByPath(Node node, String path, String attribute) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Node importedNode = doc.importNode(node, true);
			doc.appendChild(importedNode);

			List<String> attributes = XMLUtils.getXMLPropertiesByPath(doc, path+"/@"+ attribute);

			System.out.println("getXMLAttributesByPath :: attributes \""+ attribute +"\" found: " + attributes.size());
			return attributes;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Get the list of property values for a given XPath expression
	 * @param document
	 * @param string expression
	 * @return list of properties (strings)
	 */
	public static List<String> getXMLPropertiesByPath(Document doc, XPath xpath, String expression) {
		try {

			XPathExpression expr =
					xpath.compile(expression);

			// evaluate expression result on XML document
			List<String> list_elements = new ArrayList<String>();
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++)
				list_elements.add(nodes.item(i).getNodeValue());

			return list_elements;

		} catch (XPathExpressionException ex1) {

			ex1.printStackTrace();
			return null; // ??
		}
	}	

	public static NodeList getXMLNodeListByPath(Document doc, String expression) {
		try {
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr =
					xpath.compile(expression);
			// evaluate expression result on XML document
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			return nodes;
		} catch (XPathExpressionException ex1) {
			System.err.println("########################## XMLUtils :: getXMLNodeListByPath");
			ex1.printStackTrace();
			return null; // ??
		}
	}	
	
	/**
	 * Get the first occurrence of a property for a given XPath search string
	 * into a _node_
	 *
	 * @author Agostino De Marco
	 * @param node
	 * @param expression 
	 * @return property value
	 */
	public static String getXMLPropertyByPath(Node node, String expression) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Node importedNode = doc.importNode(node, true);
			doc.appendChild(importedNode);
			List<String> props = XMLUtils.getXMLPropertiesByPath(doc, expression);
			System.out.println("XMLUtils :: getXMLPropertyByPath :: properties found: " + props.size());
			System.out.println("props[0] " + props.get(0));
			if (props.size() == 0)
				return null;
			else
				return props.get(0);
			
		} catch (ParserConfigurationException e) {
			System.err.println("########################## XMLUtils :: getXMLPropertyByPath");
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * Get the list of property values for a given XPath expression
	 * @param document
	 * @param string expression - NOTE: put "/text()" at the end of the expression 
	 * @return list of properties (strings)
	 */
	public static List<String> getXMLPropertiesByPath(Document doc, String expression) {
		try {

			// Once we have document object. We are ready to use XPath. Just create an xpath object using XPathFactory.
			// Create XPathFactory object
			XPathFactory xpathFactory = XPathFactory.newInstance();

			// Create XPath object
			XPath xpath = xpathFactory.newXPath();

			XPathExpression expr =
					xpath.compile(expression);


			// evaluate expression result on XML document
			List<String> list_elements = new ArrayList<>();
			NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

			for (int i = 0; i < nodes.getLength(); i++)
				list_elements.add(nodes.item(i).getNodeValue());

			return list_elements;

		} catch (XPathExpressionException ex1) {
			ex1.printStackTrace();
			return null; // ??
		}
	} 	

	public static void writeDocumentToXml(Document doc, String filenameWithPathAndExt) {
		try {
			//System.out.println(""+doc);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult((new File(filenameWithPathAndExt)));
			transformer.transform(source, result);
			System.out.println("Data successfully written to " + filenameWithPathAndExt);

		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}	
	
	@SafeVarargs
	public static org.w3c.dom.Element createXMLElementWithAttributes(Document doc, String elementName, 
			Tuple2<String,String>... attributeValueTuples) {
		org.w3c.dom.Element element = doc.createElement(elementName);
		Arrays.stream(attributeValueTuples)
			.forEach( tpl -> {
				org.w3c.dom.Attr a = doc.createAttribute(tpl._1());
				a.setValue(tpl._2());
				element.setAttributeNode(a);
			});
		return element;
	}
	
	@SafeVarargs
	public static org.w3c.dom.Element createXMLElementWithContentAndAttributes(Document doc, String elementName, String content,
			Tuple2<String,String>... attributeValueTuples) {
		org.w3c.dom.Element element = doc.createElement(elementName);
		Arrays.stream(attributeValueTuples)
			.forEach( tpl -> {
				org.w3c.dom.Attr a = doc.createAttribute(tpl._1());
				a.setValue(tpl._2());
				element.setAttributeNode(a);
			});

		element.appendChild(doc.createTextNode(content));

		return element;
	}	
	
}
