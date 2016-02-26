package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPatterns {

	public static void main(String[] args) {
		List<String> cards = new ArrayList<String>();

		// Valid Credit Cards
		cards.add("4676-7713-0154-5024"); 
		cards.add("4688-5434-2345-2343"); 
		//valid Mobile Number
		cards.add("+919716182868");
		//valid ZipCode
		cards.add("122001");
		//valid DOB
		cards.add("12/10/2015");

		// Invalid Credit Card
		cards.add("1234-3333-5555-2222"); 
		
		
		/*String CCregex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|"
				+ "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|"
				+ "(?<amex>3[47][0-9]{13})|"
				+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|"
				+ "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";*/
	   //String mobileRegex="^(?:0091|\\+91|0)[7-9][0-9]{9}$";
	    // String zipCode="^[0-9]{6}(?:-[0-9]{4})?$";
		String dobRegex="^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";

		Pattern pattern = Pattern.compile(dobRegex);
		for (String card : cards) {
			card = card.replaceAll("-", "");
			Matcher matcher = pattern.matcher(card);
			if(matcher.find())
			{
				System.out.println("=====matcher====== " + matcher.matches());
			}
			else
			{
				System.out.println("=====matcher else ====== " + matcher.matches());
			}
		}
	}
}
