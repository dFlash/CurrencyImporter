//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.23 at 04:53:30 PM EEST 
//


package net.mpopov.ci.xml.model.currency;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.mpopov.ci.xml.model.currency package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ValCurs_QNAME = new QName("", "ValCurs");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.mpopov.ci.xml.model.currency
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValCursType }
     * 
     */
    public ValCursType createValCursType() {
        return new ValCursType();
    }

    /**
     * Create an instance of {@link ValuteType }
     * 
     */
    public ValuteType createValuteType() {
        return new ValuteType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValCursType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ValCurs")
    public JAXBElement<ValCursType> createValCurs(ValCursType value) {
        return new JAXBElement<ValCursType>(_ValCurs_QNAME, ValCursType.class, null, value);
    }

}
