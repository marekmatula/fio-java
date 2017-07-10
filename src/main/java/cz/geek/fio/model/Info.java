package cz.geek.fio.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "accountId",
        "bankId",
        "currency",
        "iban",
        "bic",
        "openingBalance",
        "closingBalance",
        "dateStart",
        "dateEnd",
        "yearList",
        "idList",
        "idFrom",
        "idTo",
        "idLastDownload"
})
public class Info {
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    protected String accountId;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    protected String bankId;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    protected String currency;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    protected String iban;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    protected String bic;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    protected BigDecimal openingBalance;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    protected BigDecimal closingBalance;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateStart;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateEnd;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger yearList;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger idList;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger idFrom;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger idTo;
    @XmlElement(namespace = "http://www.fio.cz/IBSchema")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger idLastDownload;
}
