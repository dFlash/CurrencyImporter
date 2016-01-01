package net.mpopov.ci.cruise.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "public.cruise_price_info")
public class CruisePriceInfo
{
    @Id
    @Column(name = "date_time")
    @DateTimeFormat(iso = ISO.NONE, pattern = "yyyy-MM-dd H:mm")
    @NotNull
    private Date dateTime;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cruise_date_range_id")
    @NotNull
    private CruiseDateRange cruiseDateRange;

    @Id
    @Column(name = "cabin_id")
    @NotNull
    private Long cabinId;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "currency_id")
    @NotNull
    private Currency currency;

    @Column(name = "cruise_price_id")
    @NotNull
    private Long cruisePriceId;

    @Column(name = "price_value")
    @NotNull
    private Double priceValue;

    @Column(name = "price_value_one")
    private Double priceValueOne;

    @Column(name = "price_value_two")
    private Double priceValueTwo;

    @Column(name = "price_value_three")
    private Double priceValueThree;

    @Column(name = "price_value_four")
    private Double priceValueFour;

    @Column(name = "price_value_add_c")
    private Double priceValueAddChild;

    @Column(name = "price_value_add_cc")
    private Double priceValueAdd2Child;

    @Column(name = "price_port_adult")
    @NotNull
    private Double pricePortAdult;

    @Column(name = "price_port_child")
    @NotNull
    private Double pricePortChild;

    public Double getPriceValueOne()
    {
        return priceValueOne;
    }

    public void setPriceValueOne(Double priceValueOne)
    {
        this.priceValueOne = priceValueOne;
    }

    public Double getPriceValueTwo()
    {
        return priceValueTwo;
    }

    public void setPriceValueTwo(Double priceValueTwo)
    {
        this.priceValueTwo = priceValueTwo;
    }

    public Double getPriceValueThree()
    {
        return priceValueThree;
    }

    public void setPriceValueThree(Double priceValueThree)
    {
        this.priceValueThree = priceValueThree;
    }

    public Double getPriceValueFour()
    {
        return priceValueFour;
    }

    public void setPriceValueFour(Double priceValueFour)
    {
        this.priceValueFour = priceValueFour;
    }

    public Double getPriceValueAddChild()
    {
        return priceValueAddChild;
    }

    public void setPriceValueAddChild(Double priceValueAddChild)
    {
        this.priceValueAddChild = priceValueAddChild;
    }

    public Double getPriceValueAdd2Child()
    {
        return priceValueAdd2Child;
    }

    public void setPriceValueAdd2Child(Double priceValueAdd2Child)
    {
        this.priceValueAdd2Child = priceValueAdd2Child;
    }

    public Double getPricePortAdult()
    {
        return pricePortAdult;
    }

    public void setPricePortAdult(Double pricePortAdult)
    {
        this.pricePortAdult = pricePortAdult;
    }

    public Double getPricePortChild()
    {
        return pricePortChild;
    }

    public void setPricePortChild(Double pricePortChild)
    {
        this.pricePortChild = pricePortChild;
    }

    public Double getPriceValue()
    {
        return priceValue;
    }

    public void setPriceValue(Double priceValue)
    {
        this.priceValue = priceValue;
    }

    /**
     * @return the dateTime
     */
    public Date getDateTime()
    {
        return dateTime;
    }

    /**
     * @param dateTime
     *            the dateTime to set
     */
    public void setDateTime(Date dateTime)
    {
        this.dateTime = dateTime;
    }

    /**
     * @return the cruiseDateRange
     */
    public CruiseDateRange getCruiseDateRange()
    {
        return cruiseDateRange;
    }

    /**
     * @param cruiseDateRange
     *            the cruiseDateRange to set
     */
    public void setCruiseDateRange(CruiseDateRange cruiseDateRange)
    {
        this.cruiseDateRange = cruiseDateRange;
    }

    /**
     * @return the currency
     */
    public Currency getCurrency()
    {
        return currency;
    }

    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency(Currency currency)
    {
        this.currency = currency;
    }

    /**
     * @return
     */
    public Long getCabinId()
    {
        return cabinId;
    }

    /**
     * @param cabinId
     */
    public void setCabinId(Long cabinId)
    {
        this.cabinId = cabinId;
    }

    /**
     * @return
     */
    public Long getCruisePriceId()
    {
        return cruisePriceId;
    }

    /**
     * @param cruisePriceId
     */
    public void setCruisePriceId(Long cruisePriceId)
    {
        this.cruisePriceId = cruisePriceId;
    }

    @Override
    public String toString()
    {
        return "CruisePriceInfo [dateTime=" + dateTime + ", cruiseDateRange="
                + cruiseDateRange + ", cabinId=" + cabinId + ", currency="
                + currency + ", cruisePriceId=" + cruisePriceId
                + ", priceValue=" + priceValue + ", priceValueOne="
                + priceValueOne + ", priceValueTwo=" + priceValueTwo
                + ", priceValueThree=" + priceValueThree + ", priceValueFour="
                + priceValueFour + ", priceValueAddChild=" + priceValueAddChild
                + ", priceValueAdd2Child=" + priceValueAdd2Child
                + ", pricePortAdult=" + pricePortAdult + ", pricePortChild="
                + pricePortChild + "]";
    }

}
