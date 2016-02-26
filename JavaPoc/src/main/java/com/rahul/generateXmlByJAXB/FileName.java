package com.rahul.generateXmlByJAXB;

import javax.xml.bind.annotation.XmlAttribute;

public class FileName {

	String fileName;

	public String getFileName() {
		return fileName;
	}
	@XmlAttribute(name="group")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
}
