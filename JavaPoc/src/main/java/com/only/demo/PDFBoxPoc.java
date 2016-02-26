package com.only.demo;

import java.io.IOException;
import java.util.Locale;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFBoxPoc {
	
	public static void main(String[] args) throws IOException {
		
		
		
		String sJava1="\u5f70\u5316\u9280\u884c\u884c\u52d5\u7db2\u9280.apk";
	    String sJava2="\u0905\u092E\u0940\u0924\u093E\u092A";
	    String sJava="\\u0048\\u0065\\u006C\\u006C\\u006F";
		//System.out.println("=====HIIII=====" + StringEscapeUtils.unescapeJava(sJava));
		///System.out.println("=====HIIII=====" + StringEscapeUtils.unescapeJava(sJava1));
		//System.out.println("=====HIIII=====" + StringEscapeUtils.unescapeJava(sJava2));
		
		
		
		
		
		
		
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
		//PDType3Font ont = PDTypeFont.HELVETICA;
		
		Locale l=new Locale("\u5f70\u5316\u9280\u884c\u884c\u52d5\u7db2\u9280.apk");
		System.out.println(l);

		PDType1Font font = PDType1Font.HELVETICA;
		
		contentStream.setFont(font, 12);
		contentStream.beginText();
		//contentStream.moveTextPositionByAmount(100, 400);
		contentStream.drawString(l.toString());
		contentStream.endText();
		contentStream.close();
		document.save("/home/rahul/Desktop/test1.pdf");
		document.close();
	}

}
