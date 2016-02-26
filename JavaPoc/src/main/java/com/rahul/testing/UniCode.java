package com.rahul.testing;

import org.apache.commons.lang.StringEscapeUtils;

public class UniCode {
	
	public static void main(String[] args) {
		
		
		String sJava1="\u5f70\u5316\u9280\u884c\u884c\u52d5\u7db2\u9280.apk";
	    String sJava2="\u0905\u092E\u0940\u0924\u093E\u092A";
	    String sJava="\\u0048\\u0065\\u006C\\u006C\\u006F";
		System.out.println("=====HIIII=====" + StringEscapeUtils.unescapeJava(sJava));
		System.out.println("=====HIIII=====" + StringEscapeUtils.unescapeJava(sJava1));
		System.out.println("=====HIIII=====" + StringEscapeUtils.unescapeJava(sJava2));
	}
	

}
