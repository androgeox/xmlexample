package ru.georgiy.xmlpackage;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {
    @XmlAttribute(required = true)
    private String number;

    @XmlElement(name = "expiry­date", defaultValue = "01/10")
    private String expiryDate;
    private String type;

    @XmlElement(name = "control­number")
    private Integer controlNumber;

    public CreditCard(String number, String expiryDate, Integer controlNumber, String type) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.type = type;
        this.controlNumber = controlNumber;
    }

    public CreditCard() {
    }
}
