package com.rahul.generateXmlByJAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Answer")

public class Answer {
	
	private FileName fileName;

	public Answer() {
	}

	public Answer(FileName fileName) {
		super();
		this.fileName=fileName;
	}

	public FileName getFileName() {
		return fileName;
	}
	@XmlElement(name="FileName")
	public void setFileName(FileName fileName) {
		this.fileName = fileName;
	}

	

}
