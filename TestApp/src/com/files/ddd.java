package com.files;
import java.io.File;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ddd {
	
	public static void main(String[] args) {

		File f = new File("/home/rahul/Desktop/xml/CCN.xml");
		transform(f);
	}
	public static void transform(File fXmlFile) {
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Node rootNode = doc.getDocumentElement();
			removeNodes(rootNode);
			NodeList nodeList = rootNode.getChildNodes();
			if (rootNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elt = (Element) rootNode;
				//NodeList nameList = elt.getChildNodes();

				NamedNodeMap attributes = elt.getAttributes();
				int numAttrs = attributes.getLength();
				for (int k = 0; k < numAttrs; k++) {
					Attr attr = (Attr) attributes.item(k);
					String attrName = attr.getNodeName();
					String attrValue = attr.getNodeValue();
					///System.out.println("Root element attribute Name : " + attrName);
					///System.out.println("Root Element Attribute value:  " + attrValue);
				}
			}
			printAllChildNode( nodeList);
			HashSet<String> hm = new HashSet<String>();
			HashSet<String> kl=printAllChildNodeData(nodeList,hm);
			 
			 for(String str:kl)
			 {
				System.out.println(str); 
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void childNodeAttrValues(Node p )
	{
		if (p.getNodeType() == Node.ELEMENT_NODE) {
			Element elt = (Element) p;
			//NodeList nameList = elt.getChildNodes();
	
			NamedNodeMap attributes = elt.getAttributes();
			int numAttrs = attributes.getLength();
			for (int k = 0; k < numAttrs; k++) {
				Attr attr = (Attr) attributes.item(k);
				String attrName = attr.getNodeName();
				String attrValue = attr.getNodeValue();
				///System.out.println("Child Element attribute Name : " + attrName);
				///System.out.println("Child Element Attribute value:  " + attrValue);
			}
		}
	}
	
	public static void removeNodes(Node node) {
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			removeNodes(list.item(i));
		}
		boolean emptyElement = node.getNodeType() == Node.ELEMENT_NODE
				&& node.getChildNodes().getLength() == 0;
		boolean emptyText = node.getNodeType() == Node.TEXT_NODE
				&& node.getNodeValue().trim().isEmpty();
		if (emptyElement || emptyText) {
			node.getParentNode().removeChild(node);
		}
	}

	public static void printAllChildNode(NodeList nodeList)
	{
	for (int i = 0; i < nodeList.getLength(); i++) 
	{
		Node p = nodeList.item(i);
		if (p.getNodeType() == Node.ELEMENT_NODE) {
		removeNodes(p);
	   /// System.out.println("Node name ==> "+p.getNodeName());
		childNodeAttrValues(p);
		}
		if(p.hasChildNodes())
		{
			NodeList nodeList1 = p.getChildNodes();
			printAllChildNode(nodeList1);
		}
	}
	}	 
	
	
	
	
	private static HashSet<String> printAllChildNodeData(NodeList rootNode,HashSet<String> hm){
		 

		  for(int index = 0; index < rootNode.getLength(); index ++){

		    Node aNode = rootNode.item(index);

		    if (aNode.getNodeType() == Node.ELEMENT_NODE){

		      NodeList childNodes = aNode.getChildNodes();

		      if (childNodes.getLength() > 0){
		    	 
		    	  
		        
		        hm.add(childNodes.item(0).getTextContent());
		        
		        
		        	
		       

		      }

		      printAllChildNodeData(aNode.getChildNodes(),hm);

		    }

		  }
		  return hm;
	}
	
}