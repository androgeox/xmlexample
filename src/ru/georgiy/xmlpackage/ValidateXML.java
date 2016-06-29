package ru.georgiy.xmlpackage;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.File;
import java.io.IOException;

import static ru.georgiy.xmlpackage.Main.xmlDocument;
import static ru.georgiy.xmlpackage.Main.xsdDocument;

public class ValidateXML {

    public ValidateXML() {
    }

    public File validate(){
        try {
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(xsdDocument);

//            JAXBContext jaxbContext = JAXBContext.newInstance( CreditCard.class );
//            Marshaller marshaller = jaxbContext.createMarshaller();
//            marshaller.setEventHandler(new MyValidationEventHandler());
            Validator validator = schema.newValidator();
            validator.setErrorHandler(new MyErrorHandler());
            validator.validate(new StreamSource(xsdDocument), new StreamResult(xmlDocument));
            System.out.println("document validated");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("document did not validate");
        } catch (SAXException sax){
            sax.printStackTrace();
        }
        return xmlDocument;
    }
}
