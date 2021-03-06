//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.26 at 10:02:47 PM EET 
//

package net.mpopov.ci.configuration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for configurationType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="configurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="delay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tempDirectory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="defaultCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="forCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sourceType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="currenciesList" type="{}currenciesListType"/>
 *         &lt;element name="excludedCompanyIds" type="{}excludedCompanyIdsList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configurationType",
        propOrder = { "delay", "tempDirectory", "defaultCurrencyId",
                "forCurrencyId", "sourceType", "currenciesList",
                "excludedCompanyIds" })
public class ConfigurationType
{

    @XmlElement(defaultValue = "10")
    protected Integer delay;

    @XmlElement(required = true)
    protected String tempDirectory;

    protected long defaultCurrencyId;

    protected long forCurrencyId;

    protected short sourceType;

    @XmlElement(required = true)
    protected CurrenciesListType currenciesList;

    protected ExcludedCompanyIdsList excludedCompanyIds;

    /**
     * Gets the value of the delay property.
     * 
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getDelay()
    {
        return delay;
    }

    /**
     * Sets the value of the delay property.
     * 
     * @param value
     *            allowed object is {@link Integer }
     * 
     */
    public void setDelay(Integer value)
    {
        this.delay = value;
    }

    /**
     * Gets the value of the tempDirectory property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getTempDirectory()
    {
        return tempDirectory;
    }

    /**
     * Sets the value of the tempDirectory property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setTempDirectory(String value)
    {
        this.tempDirectory = value;
    }

    /**
     * Gets the value of the defaultCurrencyId property.
     * 
     */
    public long getDefaultCurrencyId()
    {
        return defaultCurrencyId;
    }

    /**
     * Sets the value of the defaultCurrencyId property.
     * 
     */
    public void setDefaultCurrencyId(long value)
    {
        this.defaultCurrencyId = value;
    }

    /**
     * Gets the value of the forCurrencyId property.
     * 
     */
    public long getForCurrencyId()
    {
        return forCurrencyId;
    }

    /**
     * Sets the value of the forCurrencyId property.
     * 
     */
    public void setForCurrencyId(long value)
    {
        this.forCurrencyId = value;
    }

    /**
     * Gets the value of the sourceType property.
     * 
     */
    public short getSourceType()
    {
        return sourceType;
    }

    /**
     * Sets the value of the sourceType property.
     * 
     */
    public void setSourceType(short value)
    {
        this.sourceType = value;
    }

    /**
     * Gets the value of the currenciesList property.
     * 
     * @return possible object is {@link CurrenciesListType }
     * 
     */
    public CurrenciesListType getCurrenciesList()
    {
        return currenciesList;
    }

    /**
     * Sets the value of the currenciesList property.
     * 
     * @param value
     *            allowed object is {@link CurrenciesListType }
     * 
     */
    public void setCurrenciesList(CurrenciesListType value)
    {
        this.currenciesList = value;
    }

    /**
     * Gets the value of the excludedCompanyIds property.
     * 
     * @return possible object is {@link ExcludedCompanyIdsList }
     * 
     */
    public ExcludedCompanyIdsList getExcludedCompanyIds()
    {
        return excludedCompanyIds;
    }

    /**
     * Sets the value of the excludedCompanyIds property.
     * 
     * @param value
     *            allowed object is {@link ExcludedCompanyIdsList }
     * 
     */
    public void setExcludedCompanyIds(ExcludedCompanyIdsList value)
    {
        this.excludedCompanyIds = value;
    }

}
