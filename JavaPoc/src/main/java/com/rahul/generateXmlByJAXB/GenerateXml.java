package com.rahul.generateXmlByJAXB;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GenerateXml {
	public static void main(String[] args) {

		try {

			Answer ans = new Answer();

			FileName fnn = new FileName();
			fnn.setFileName("okkk");
			
			ans.setFileName(fnn);

			//Question question = new Question(1, l);

			File file = new File("/home/rahul/Desktop/question.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Question.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(ans, file);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

}
