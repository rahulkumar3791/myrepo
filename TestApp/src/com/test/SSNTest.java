package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SSNTest {

	public static void main(String[] args) {
		
		List<String> ssns = new ArrayList<String>();
	       
		//Valid SSNs
		ssns.add("123-45-6789"); 
		ssns.add("856-45-6789"); 
		 
		//Invalid SSNs
		ssns.add("901-45-6789"); 
		ssns.add("85-345-6789");
		ssns.add("856-453-6789");
		ssns.add("856-45-67891");
		ssns.add("856-456789");
		 
		//String regex="^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$";
		String ssregex="^\\d{3}[- ]\\d{2}[- ]\\d{4}$";
		 
		Pattern pattern = Pattern.compile(ssregex);
		 
		for (String number : ssns)
		{
		    Matcher matcher = pattern.matcher(number);
		    System.out.println(matcher.matches());
		}
		}

}
