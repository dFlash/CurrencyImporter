package net.mpopov.ci.cruise.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "public.currency_exchange_rate")
public class CurrencyExchangeRate
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "currency_exchange_rate_currency_exchange_rate_id_seq")
    @SequenceGenerator(
            name = "currency_exchange_rate_currency_exchange_rate_id_seq",
            sequenceName = "currency_exchange_rate_currency_exchange_rate_id_seq")
    @Column(name = "currency_exchange_rate_id", nullable = false)
    private Long currencyExchangeRateId;

    @Column(name = "date_time")
    @DateTimeFormat(iso = ISO.NONE, pattern = "yyyy-MM-dd H:mm")
    @NotNull
    private Date dateTime;

    @Column(name = "currency_id")
    @NotNull
    private Long currencyId;

    @Column(name = "rate_value")
    @NotNull
    private Double rateValue;

    @Column(name = "for_currency_id")
    private Long forCurrencyId;

    @Column(name = "source_type")
    @NotNull
    private Short sourceType;

    public Long getCurrencyId()
    {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId)
    {
        this.currencyId = currencyId;
    }

    public Long getCurrencyExchangeRateId()
    {
        return currencyExchangeRateId;
    }

    public void setCurrencyExchangeRateId(Long currencyExchangeRateId)
    {
        this.currencyExchangeRateId = currencyExchangeRateId;
    }

    public Date getDateTime()
    {
        return dateTime;
    }

    public void setDateTime(Date dateTime)
    {
        this.dateTime = dateTime;
    }

    public Double getRateValue()
    {
        return rateValue;
    }

    public void setRateValue(Double rateValue)
    {
        this.rateValue = rateValue;
    }

    public Long getForCurrencyId()
    {
        return forCurrencyId;
    }

    public void setForCurrencyId(Long forCurrencyId)
    {
        this.forCurrencyId = forCurrencyId;
    }

    public Short getSourceType()
    {
        return sourceType;
    }

    public void setSourceType(Short sourceType)
    {
        this.sourceType = sourceType;
    }

    @Override
    public String toString()
    {
        return "CurrencyExchangeRate [currencyExchangeRateId="
                + currencyExchangeRateId + ", dateTime=" + dateTime
                + ", currencyId=" + currencyId + ", rateValue=" + rateValue
                + ", forCurrencyId=" + forCurrencyId + ", sourceType="
                + sourceType + "]";
    }

}
