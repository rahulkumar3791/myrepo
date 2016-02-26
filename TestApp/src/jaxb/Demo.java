package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(JaxbFile.class);

        JaxbFile pt = new JaxbFile();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.setProperty("eclipselink.media-type", "application/json");
       // marshaller.marshal(pt, System.out);
        
     
        marshaller.marshal(pt, System.out);
    }

}
