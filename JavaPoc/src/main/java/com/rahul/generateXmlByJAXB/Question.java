package com.rahul.generateXmlByJAXB;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Question")
public class Question {
	private int id;
	private List<Answer> answers;

	public Question() {
	}

	public Question(int id,  List<Answer> answers) {
		super();
		this.id = id;
		this.answers = answers;
	}

	@XmlAttribute(name="Id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name="Answer")
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}