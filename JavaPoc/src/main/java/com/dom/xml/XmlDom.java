package com.dom.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlDom {
	public static void main(String[] args) {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("", "Document");
            doc.appendChild(mainRootElement);
 
            // append child elements to root element
            mainRootElement.appendChild(getCompany(doc, "Paypal"));
            mainRootElement.appendChild(getCompany(doc,  "eBay"));
            mainRootElement.appendChild(getCompany(doc,  "Google"));
 
            // output DOM XML to console 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
           
            
            
 
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static Node getCompany(Document doc,  String name) {
        Element company = doc.createElement("Dangerous");
        
        company.appendChild(getCompanyElements(doc, "12",company, "Permission", name));
        return company;
    }
    
 
    // utility method to create text node
    private static Node getCompanyElements(Document doc, String id,Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.setAttribute("id", id);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
