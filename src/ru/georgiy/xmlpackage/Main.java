package ru.georgiy.xmlpackage;

import org.xml.sax.SAXException;

import java.io.File;
import java.nio.file.Paths;

public class Main {

    public static final File xmlDocument = Paths.get("src/main/resources/input.xml").toFile();
    public static final File xsltDocument = Paths.get("src/main/resources/stylesheet.xsl").toFile();
    public static final File xsdDocument = Paths.get("src/main/resources/schema.xsd").toFile();
    public static final File newXml = Paths.get("src/main/resources/out.xml").toFile();

    public static void main(String[] args) {
        try {
            ValidateXML validateXML = new ValidateXML();
            validateXML.validate();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        TransformXML transformXML = new TransformXML();
        transformXML.transform();

        try {
            ValidateXML newValidation = new ValidateXML();
            newValidation.validate();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
