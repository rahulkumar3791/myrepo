package jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlRootElement(name="Root")
public class JaxbFile {

    
    protected BigDecimal name;
    protected BigDecimal mob;                    
    protected XMLGregorianCalendar address;
    
    
    
    
    
    @XmlElement(name = "name", required = true)
	public BigDecimal getname() {
		return name;
	}
    
                        
    @XmlElement(name = "mob", required = true, nillable = true)
	public BigDecimal getmob() {
		return mob;
	}
    @XmlElement(name = "address", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
	public XMLGregorianCalendar getaddress() {
		return address;
	}
	
    
	public void setname(BigDecimal name) {
		this.name = name;
	}
	public void setmob(BigDecimal mob) {
		this.mob = mob;
	}
	public void setaddress(XMLGregorianCalendar address) {
		this.address = address;
	}
    
    
    
    
    
    
    

}