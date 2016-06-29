package ru.georgiy.xmlpackage;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class XMLParsing {
    public static List<CreditCard> parseOrderLines() {
    List<CreditCard> orderLines = new ArrayList<>();
        try {
            File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();
            // Фабрика DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Анализ документа
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlDocument);
            // Получение узла order_line
//            NodeList orderLinesNode = document.getElementsByTagName("order_line");
//            for (int i = 0; i < orderLinesNode.getLength(); i++) {
//                Element orderLineNode = (Element) orderLinesNode.item(i);
//                CreditCard orderLine = new CreditCard();
//                orderLine.setItem(orderLineNode.getAttribute("item"));
//                orderLine.setQuantity(Integer.valueOf(orderLineNode.
//                        getAttribute("quantity")));
//                Node unitPriceNode = orderLineNode.getChildNodes().item(1);
//                orderLine.setUnitPrice(Double.valueOf(unitPriceNode.getFirstChild().getNodeValue()));
//                orderLines.add(orderLine);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return orderLines;
    }
}