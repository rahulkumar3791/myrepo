package com.dom.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOm2 {

	public static final String xmlFilePath = "/home/rahul/Desktop/xmlfile.xml";

	public static void main(String argv[]) {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = documentFactory
					.newDocumentBuilder();

			Document document = documentBuilder.newDocument();

			Element root = document.createElement("company");

			document.appendChild(root);

			Element employee = document.createElement("employee");
			root.appendChild(employee);

			Attr attr = document.createAttribute("count");
			attr.setValue("1");
			employee.setAttributeNode(attr);

			Element firstName = document.createElement("firstname");
			root.appendChild(firstName);

			Attr attr1 = document.createAttribute("group");
			attr1.setValue("134");
			firstName.setAttributeNode(attr1);

			firstName.appendChild(document.createTextNode("James"));
			employee.appendChild(firstName);

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));
			// StreamResult streamResult = new StreamResult(System.out);
			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
