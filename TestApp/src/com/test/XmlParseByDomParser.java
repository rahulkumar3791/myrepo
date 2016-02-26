package com.test;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParseByDomParser {

	public static void main(String[] args) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("person.xml");

			NodeList nodeList = doc.getElementsByTagName("person");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node p = nodeList.item(i);
				if (p.getNodeType() == Node.ELEMENT_NODE) {

					Element person = (Element) p;
					String id = person.getAttribute("id");
					NodeList nameList = person.getChildNodes();
					for (int j = 0; j < nameList.getLength(); j++) {
						Node n = nameList.item(j);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element name = (Element) n;
							System.out.println("person id : " + id
									+ " name is :" + name.getTagName() + "= "
									+ name.getTextContent());
						}
					}
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
