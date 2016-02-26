package com.only.demo;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Appvigil This class deals with the regex mapping
 * 
 */
public class JaxbTest {

	public static void main(String[] args) throws JAXBException {

		Set<Regex> regexes = new HashSet<Regex>();
		Set<Type> types = new HashSet<Type>();

		Category c = new Category();

		Regex r = new Regex();
		r.setDesc("type");
		r.setPattern("abc");
		regexes.add(r);

		r = new Regex();
		r.setDesc("type2");
		r.setPattern("abcd");
		regexes.add(r);

		Type t = new Type();
		t.setRegexes(regexes);
		t.setType("cards");
		types.add(t);
		t = new Type();
		t.setRegexes(regexes);
		t.setType("account-number");
		types.add(t);
		c.setTypes(types);
		c.setName("financial");

		JAXBContext jaxbContext = JAXBContext.newInstance(Category.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.marshal(c, System.out);

	}

}

@XmlRootElement
class Category {

	Set<Type> types;
	String name;

	@XmlElement(name = "type")
	public Set<Type> getTypes() {
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

@XmlRootElement
class Type {
	Set<Regex> regexes;
	String type;

	@XmlElement(name = "regex")
	public Set<Regex> getRegexes() {
		return regexes;
	}

	public void setRegexes(Set<Regex> regexes) {
		this.regexes = regexes;
	}

	@XmlAttribute(name = "name")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}

@XmlRootElement
class Regex {

	String desc;

	String pattern;

	@XmlAttribute(name = "desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@XmlValue
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
