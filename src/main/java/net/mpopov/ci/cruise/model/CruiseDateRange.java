package net.mpopov.ci.cruise.model;

import java.util.Date;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "public.cruise_date_range")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
public class CruiseDateRange
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cruise_date_range_cruise_date_range_id_seq")
    @SequenceGenerator(name = "cruise_date_range_cruise_date_range_id_seq",
            sequenceName = "cruise_date_range_cruise_date_range_id_seq")
    @Column(name = "cruise_date_range_id", nullable = false)
    private Long cruiseDateRangeId;

    @Column(name = "begin_date")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @NotNull
    private Date beginDate;

    @Column(name = "end_date")
    @DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
    @NotNull
    private Date endDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cruise_id")
    @NotNull
    private Cruise cruise;

    @Column(name = "cruise_min_price_id")
    private Long cruiseMinPrice;

    @Column(name = "start_sity_id")
    private Long startSityId;

    public Long getCruiseMinPrice()
    {
        return cruiseMinPrice;
    }

    public void setCruiseMinPrice(Long cruiseMinPrice)
    {
        this.cruiseMinPrice = cruiseMinPrice;
    }

    public Long getStartSityId()
    {
        return startSityId;
    }

    public void setStartSityId(Long startSityId)
    {
        this.startSityId = startSityId;
    }

    /**
     * @return the cruiseDateRangeId
     */
    public Long getCruiseDateRangeId()
    {
        return cruiseDateRangeId;
    }

    /**
     * @param cruiseDateRangeId
     *            the cruiseDateRangeId to set
     */
    public void setCruiseDateRangeId(Long cruiseDateRangeId)
    {
        this.cruiseDateRangeId = cruiseDateRangeId;
    }

    /**
     * @return the beginDate
     */
    public Date getBeginDate()
    {
        return beginDate;
    }

    /**
     * @param beginDate
     *            the beginDate to set
     */
    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate()
    {
        return endDate;
    }

    /**
     * @param endDate
     *            the endDate to set
     */
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    /**
     * @return the cruise
     */
    public Cruise getCruise()
    {
        return cruise;
    }

    /**
     * @param cruise
     *            the cruise to set
     */
    public void setCruise(Cruise cruise)
    {
        this.cruise = cruise;
    }



    @Override
    public String toString()
    {
        return "CruiseDateRange [cruiseDateRangeId=" + cruiseDateRangeId
                + ", beginDate=" + beginDate + ", endDate=" + endDate
                + ", cruise=" + cruise + ", startSityId=" + startSityId
                + "]";
    }

}
