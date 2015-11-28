package net.mpopov.ci.cruise.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "public.cruise_date_range_min_price")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
public class CruiseDateRangeMinPrice
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cruise_date_range_min_price_id_seq")
    @SequenceGenerator(name = "cruise_date_range_min_price_id_seq",
            sequenceName = "cruise_date_range_min_price_id_seq")
    @Column(name = "cruise_date_range_min_price_id", nullable = false)
    private Long cruiseDateRangeMinPriceId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "currency_id")
    @NotNull
    private Currency currency;

    @Column(name = "price_value")
    @NotNull
    private Double minPriceValue;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cruise_date_range_id")
    @NotNull
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
    private CruiseDateRange cruiseDateRange;

    public Long getCruiseDateRangeMinPriceId()
    {
        return cruiseDateRangeMinPriceId;
    }

    public void setCruiseDateRangeMinPriceId(Long cruiseDateRangeMinPriceId)
    {
        this.cruiseDateRangeMinPriceId = cruiseDateRangeMinPriceId;
    }

    public Currency getCurrency()
    {
        return currency;
    }

    public void setCurrency(Currency currency)
    {
        this.currency = currency;
    }

    public Double getMinPriceValue()
    {
        return minPriceValue;
    }

    public void setMinPriceValue(Double minPriceValue)
    {
        this.minPriceValue = minPriceValue;
    }

    public CruiseDateRange getCruiseDateRange()
    {
        return cruiseDateRange;
    }

    public void setCruiseDateRange(CruiseDateRange cruiseDateRange)
    {
        this.cruiseDateRange = cruiseDateRange;
    }
    
    @Override
    public String toString()
    {
        return "CruiseDateRangeMinPrice [cruiseDateRangeMinPriceId="
                + cruiseDateRangeMinPriceId + ", currency=" + currency
                + ", minPriceValue=" + minPriceValue + ", cruiseDateRange="
                + cruiseDateRange.toString() + "]";
    }

}
