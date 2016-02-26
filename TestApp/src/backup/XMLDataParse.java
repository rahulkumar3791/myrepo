package backup;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDataParse {

	
	static String attrVal="";
	static String nodeVal="";
	public static void main(String argv[]) {

		try {
			/**
			 * create document file object and taking filename's path
			 * 
			 */
			File fXmlFile = new File(
					"/home/rahul/Desktop/xml/CCN.xml");
			/**
			 * Get Document Builder
			 * 
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			/**
			 * Build Document
			 * 
			 */
			Document doc = dBuilder.parse(fXmlFile);
			/**
			 * Normalize the XML Structure;
			 * 
			 */
			doc.getDocumentElement().normalize();
			/**
			 * saving root node in a variable.
			 * 
			 */
			Node rootNode = doc.getDocumentElement();
			//System.out.println("Root node name is  :"
				//	+ doc.getDocumentElement().getNodeName());
			removeNodes(rootNode);

			/**
			 * to store the child nodes as node list.
			 * 
			 */
	
			
			//NodeList list = doc.getElementsByTagName("*");
	        // System.out.println("XML Elements: ");
	         /*for (int i=0; i<list.getLength(); i++) {
	           // Get element
	           Element elt = (Element)list.item(i);
	          // System.out.println(elt.getNodeName());
	           NodeList nameList = elt.getChildNodes();
			
				//Element element = (Element) nodeList.item(0);
				NamedNodeMap attributes = elt.getAttributes();
				int numAttrs = attributes.getLength();

				for (int k = 0; k < numAttrs; k++) {
					Attr attr = (Attr) attributes.item(k);
					String attrName = attr.getNodeName();
                    System.out.println("node names "+attrName);
					String attrValue = attr.getNodeValue();
					attrVal=attrValue;
					//System.out.println("========HHHHHHHHHHH========="   +attrVal);
				}
				for (int j = 0; j < nameList.getLength(); j++) {
					Node n = nameList.item(j);
					if (n.getNodeType() == Node.ELEMENT_NODE) {
						Element elt2 = (Element) n;
						nodeVal=elt2.getTextContent();
						System.out.println("===KKKKK===="+nodeVal);
					}
				}
                     
	           
	         }*/
	      

		

	
			NodeList nodeList = rootNode.getChildNodes();
			String s1 = "";
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node p = nodeList.item(i);
			//	System.out.println("Child Node Name is : " + p.getNodeName());
				if (p.getNodeType() == Node.ELEMENT_NODE) {
					Element elt = (Element) p;
					NodeList nameList = elt.getChildNodes();
					
					
					//Element element = (Element) nodeList.item(0);
					NamedNodeMap attributes = elt.getAttributes();
					int numAttrs = attributes.getLength();

					for (int k = 0; k < numAttrs; k++) {
						Attr attr = (Attr) attributes.item(k);
						String attrName = attr.getNodeName();

						String attrValue = attr.getNodeValue();
						System.out.println("Found attribute:       " + attrName
							+ " with value:         " + attrValue);
					}
					
					
					for (int j = 0; j < nameList.getLength(); j++) {
						Node n = nameList.item(j);
						if (n.getNodeType() == Node.ELEMENT_NODE) {
							Element elt2 = (Element) n;
							System.out.println("========="+elt2.getTextContent());
							s1 += elt2.getTextContent() + ",";
						
						}
					}
				}
			}
		//	System.out.println("xml file all data gets ::" + s1);
		} catch (Exception e) {
			e.printStackTrace();
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

}
