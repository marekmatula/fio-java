package cz.geek.fio.model;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "info",
        "transactionList"
})
@XmlRootElement(name = "AccountStatement", namespace = "http://www.fio.cz/IBSchema")
@Data
public class AccountStatement {
    @XmlElement(name = "Info", namespace = "http://www.fio.cz/IBSchema")
    protected Info info;
    @XmlElement(name = "TransactionList", namespace = "http://www.fio.cz/IBSchema")
    protected TransactionList transactionList;
}


