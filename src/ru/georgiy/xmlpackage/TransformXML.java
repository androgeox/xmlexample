package ru.georgiy.xmlpackage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;

import static ru.georgiy.xmlpackage.Main.newXml;
import static ru.georgiy.xmlpackage.Main.xmlDocument;
import static ru.georgiy.xmlpackage.Main.xsltDocument;

public class TransformXML {


    public TransformXML() {
    }

    public File transform(){
        StringWriter writer = new StringWriter();
        try {
            TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
            Transformer transformer = factory.newTransformer(new StreamSource(xsltDocument));
            transformer.transform(new StreamSource(xmlDocument), new StreamResult(newXml));
//
//            JAXBContext jaxbContext = JAXBContext.newInstance( CreditCard.class );
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(writer, newXml);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
//        } catch (PropertyException e) {
//            e.printStackTrace();
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        return newXml;
    }
}
