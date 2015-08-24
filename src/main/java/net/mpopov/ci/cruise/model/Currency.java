package net.mpopov.ci.cruise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "public.currency")
public class Currency
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "currency_currency_id_seq")
    @SequenceGenerator(name = "currency_currency_id_seq",
            sequenceName = "currency_currency_id_seq")
    @Column(name = "currency_id", nullable = false)
    private Long currencyId;

    @Column(name = "name")
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "code")
    @Size(min = 3, max = 3)
    private String code;
    
    @Column(name = "base")
    private Boolean base;

    public Boolean getBase() {
		return base;
	}

	public void setBase(Boolean base) {
		this.base = base;
	}

	/**
     * @return the currencyId
     */
    public Long getCurrencyId()
    {
        return currencyId;
    }

    /**
     * @param currencyId
     *            the currencyId to set
     */
    public void setCurrencyId(Long currencyId)
    {
        this.currencyId = currencyId;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode()
    {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(String code)
    {
        this.code = code;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return String.format("Currency [currencyId=%s, name=%s, code=%s]",
                currencyId, name, code);
    }

}
