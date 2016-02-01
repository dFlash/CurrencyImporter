//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.08.23 at 04:53:30 PM EEST 
//

package net.mpopov.ci.xml.model.currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ValuteType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ValuteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CharCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Nominal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValuteType",
        propOrder = { "numCode", "charCode", "nominal", "name", "value" })
public class ValuteType
{

    @XmlElement(name = "NumCode")
    protected int numCode;

    @XmlElement(name = "CharCode", required = true)
    protected String charCode;

    @XmlElement(name = "Nominal")
    protected int nominal;

    @XmlElement(name = "Name", required = true)
    protected String name;

    @XmlElement(name = "Value", required = true)
    protected String value;

    @XmlAttribute(name = "ID")
    protected String id;

    /**
     * Gets the value of the numCode property.
     * 
     */
    public int getNumCode()
    {
        return numCode;
    }

    /**
     * Sets the value of the numCode property.
     * 
     */
    public void setNumCode(int value)
    {
        this.numCode = value;
    }

    /**
     * Gets the value of the charCode property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCharCode()
    {
        return charCode;
    }

    /**
     * Sets the value of the charCode property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCharCode(String value)
    {
        this.charCode = value;
    }

    /**
     * Gets the value of the nominal property.
     * 
     */
    public int getNominal()
    {
        return nominal;
    }

    /**
     * Sets the value of the nominal property.
     * 
     */
    public void setNominal(int value)
    {
        this.nominal = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setName(String value)
    {
        this.name = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getValue()
    {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getID()
    {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setID(String value)
    {
        this.id = value;
    }

}
