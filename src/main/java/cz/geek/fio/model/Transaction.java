package cz.geek.fio.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "column22",
        "column0",
        "column1",
        "column14",
        "column2",
        "column10",
        "column3",
        "column12",
        "column4",
        "column5",
        "column6",
        "column7",
        "column16",
        "column8",
        "column9",
        "column18",
        "column25",
        "column26",
        "column17"
})
@Data
public class Transaction {

    @XmlElement(name = "column_22", namespace = "http://www.fio.cz/IBSchema", required = true)
    protected Column22 column22;
    @XmlElement(name = "column_0", namespace = "http://www.fio.cz/IBSchema", required = true)
    protected Column0 column0;
    @XmlElement(name = "column_1", namespace = "http://www.fio.cz/IBSchema", required = true)
    protected Column1 column1;
    @XmlElement(name = "column_14", namespace = "http://www.fio.cz/IBSchema", required = true)
    protected Column14 column14;
    @XmlElement(name = "column_2", namespace = "http://www.fio.cz/IBSchema")
    protected Column2 column2;
    @XmlElement(name = "column_10", namespace = "http://www.fio.cz/IBSchema")
    protected Column10 column10;
    @XmlElement(name = "column_3", namespace = "http://www.fio.cz/IBSchema")
    protected Column3 column3;
    @XmlElement(name = "column_12", namespace = "http://www.fio.cz/IBSchema")
    protected Column12 column12;
    @XmlElement(name = "column_4", namespace = "http://www.fio.cz/IBSchema")
    protected Column4 column4;
    @XmlElement(name = "column_5", namespace = "http://www.fio.cz/IBSchema")
    protected Column5 column5;
    @XmlElement(name = "column_6", namespace = "http://www.fio.cz/IBSchema")
    protected Column6 column6;
    @XmlElement(name = "column_7", namespace = "http://www.fio.cz/IBSchema")
    protected Column7 column7;
    @XmlElement(name = "column_16", namespace = "http://www.fio.cz/IBSchema")
    protected Column16 column16;
    @XmlElement(name = "column_8", namespace = "http://www.fio.cz/IBSchema")
    protected Column8 column8;
    @XmlElement(name = "column_9", namespace = "http://www.fio.cz/IBSchema")
    protected Column9 column9;
    @XmlElement(name = "column_18", namespace = "http://www.fio.cz/IBSchema")
    protected Column18 column18;
    @XmlElement(name = "column_25", namespace = "http://www.fio.cz/IBSchema")
    protected Column25 column25;
    @XmlElement(name = "column_26", namespace = "http://www.fio.cz/IBSchema")
    protected Column26 column26;
    @XmlElement(name = "column_17", namespace = "http://www.fio.cz/IBSchema")
    protected Column17 column17;

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })

    @Data
    public static class Column0 {

        @XmlValue
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column1 {

        @XmlValue
        protected BigDecimal value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column10 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column12 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class Column14 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;


        public String getValue() {
            return value;
        }


        public void setValue(String value) {
            this.value = value;
        }


        public String getName() {
            return name;
        }


        public void setName(String value) {
            this.name = value;
        }


        public BigInteger getId() {
            return id;
        }


        public void setId(BigInteger value) {
            this.id = value;
        }

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column16 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column17 {

        @XmlValue
        protected long value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column18 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column2 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;

    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column22 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column25 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column26 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column3 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column4 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column5 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column6 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column7 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column8 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    @Data
    public static class Column9 {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "name", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlSchemaType(name = "token")
        protected String name;
        @XmlAttribute(name = "id", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger id;
    }

}
