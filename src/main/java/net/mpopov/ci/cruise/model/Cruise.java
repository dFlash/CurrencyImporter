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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "public.cruise")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
public class Cruise
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "cruise_cruise_id_seq")
    @SequenceGenerator(name = "cruise_cruise_id_seq",
            sequenceName = "cruise_cruise_id_seq")
    @Column(name = "cruise_id", nullable = false)
    private Long cruiseId;

    @Column(name = "name")
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "ufl")
    @Size(min = 1, max = 256)
    private String ufl;

    @Column(name = "cruise_category_id")
    @NotNull
    private Long cruiseCategory;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vessel_id")
    @NotNull
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
    private Vessel vessel;

    @Column(name = "cruise_language_service_id")
    private Long cruiseLanguageService;

    @Column(name = "description")
    @Size(max = 65536)
    private String description;

    @Column(name = "gallery_id")
    private Long gallery;

    @Column(name = "description_gallery_id")
    private Long descriptionGallery;

    @Column(name = "region_id")
    private Long region;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "currency_id")
    @NotNull
    private Currency currency;

    @Column(name = "price_value")
    @NotNull
    @Min(1)
    @Max(100000)
    private Integer priceValue;

    @Column(name = "is_simple_description")
    private boolean isSimpleDescription;

    @Column(name = "simple_price_description")
    @Size(max = 65536)
    private String simplePriceDescription;

    @Column(name = "simple_route_description")
    @Size(max = 65536)
    private String simpleRouteDescription;

    @Column(name = "simple_itinerary_description")
    @Size(max = 65536)
    private String simpleItineraryDescription;

    @Column(name = "special_offer")
    @Size(max = 256)
    private String specialOffer;

    @Column(name = "is_import")
    private Boolean isImport;

    @Column(name = "is_disabled")
    private Boolean isDisabled;

    @Column(name = "is_disabled_ru")
    private Boolean isDisabledRu;

    @Column(name = "is_disabled_ua")
    private Boolean isDisabledUa;

    public Boolean getIsDisabledRu() {
		return isDisabledRu;
	}

	public void setIsDisabledRu(Boolean isDisabledRu) {
		this.isDisabledRu = isDisabledRu;
	}

	public Boolean getIsDisabledUa() {
		return isDisabledUa;
	}

	public void setIsDisabledUa(Boolean isDisabledUa) {
		this.isDisabledUa = isDisabledUa;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public void setSimpleDescription(boolean isSimpleDescription) {
		this.isSimpleDescription = isSimpleDescription;
	}

	/**
     * @return the cruiseId
     */
    public Long getCruiseId()
    {
        return cruiseId;
    }

    /**
     * @param cruiseId
     *            the cruiseId to set
     */
    public void setCruiseId(Long cruiseId)
    {
        this.cruiseId = cruiseId;
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
     * @return the ufl
     */
    public String getUfl()
    {
        return ufl;
    }

    /**
     * @param ufl
     *            the ufl to set
     */
    public void setUfl(String ufl)
    {
        this.ufl = ufl;
    }

    /**
     * @return the cruiseCategory
     */
    public Long getCruiseCategory()
    {
        return cruiseCategory;
    }

    /**
     * @param cruiseCategory
     *            the cruiseCategory to set
     */
    public void setCruiseCategory(Long cruiseCategory)
    {
        this.cruiseCategory = cruiseCategory;
    }

    /**
     * @return the vessel
     */
    public Vessel getVessel()
    {
        return vessel;
    }

    /**
     * @param vessel
     *            the vessel to set
     */
    public void setVessel(Vessel vessel)
    {
        this.vessel = vessel;
    }

    /**
     * @return the cruiseLanguageService
     */
    public Long getCruiseLanguageService()
    {
        return cruiseLanguageService;
    }

    /**
     * @param cruiseLanguageService
     *            the cruiseLanguageService to set
     */
    public void setCruiseLanguageService(
    		Long cruiseLanguageService)
    {
        this.cruiseLanguageService = cruiseLanguageService;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the gallery
     */
    public Long getGallery()
    {
        return gallery;
    }

    /**
     * @param gallery
     *            the gallery to set
     */
    public void setGallery(Long gallery)
    {
        this.gallery = gallery;
    }

    /**
     * @return the descriptionGallery
     */
    public Long getDescriptionGallery()
    {
        return descriptionGallery;
    }

    /**
     * @param descriptionGallery
     *            the descriptionGallery to set
     */
    public void setDescriptionGallery(Long descriptionGallery)
    {
        this.descriptionGallery = descriptionGallery;
    }

    /**
     * @return the region
     */
    public Long getRegion()
    {
        return region;
    }

    /**
     * @param region
     *            the region to set
     */
    public void setRegion(Long region)
    {
        this.region = region;
    }

    /**
     * @return the isSimpleDescription
     */
    public boolean getIsSimpleDescription()
    {
        return isSimpleDescription;
    }

    /**
     * @param isSimpleDescription
     *            the isSimpleDescription to set
     */
    public void setIsSimpleDescription(boolean isSimpleDescription)
    {
        this.isSimpleDescription = isSimpleDescription;
    }

    /**
     * @return the simplePriceDescription
     */
    public String getSimplePriceDescription()
    {
        return simplePriceDescription;
    }

    /**
     * @param simplePriceDescription
     *            the simplePriceDescription to set
     */
    public void setSimplePriceDescription(String simplePriceDescription)
    {
        this.simplePriceDescription = simplePriceDescription;
    }

    /**
     * @return the simpleRouteDescription
     */
    public String getSimpleRouteDescription()
    {
        return simpleRouteDescription;
    }

    /**
     * @param simpleRouteDescription
     *            the simpleRouteDescription to set
     */
    public void setSimpleRouteDescription(String simpleRouteDescription)
    {
        this.simpleRouteDescription = simpleRouteDescription;
    }

    /**
     * @return the simpleItineraryDescription
     */
    public String getSimpleItineraryDescription()
    {
        return simpleItineraryDescription;
    }

    /**
     * @param simpleItineraryDescription
     *            the simpleItineraryDescription to set
     */
    public void setSimpleItineraryDescription(String simpleItineraryDescription)
    {
        this.simpleItineraryDescription = simpleItineraryDescription;
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
     * @return the priceValue
     */
    public Integer getPriceValue()
    {
        return priceValue;
    }

    /**
     * @param priceValue
     *            the priceValue to set
     */
    public void setPriceValue(Integer priceValue)
    {
        this.priceValue = priceValue;
    }

    /**
     * @return the specialOffer
     */
    public String getSpecialOffer()
    {
        return specialOffer;
    }

    /**
     * @param specialOffer
     *            the specialOffer to set
     */
    public void setSpecialOffer(String specialOffer)
    {
        this.specialOffer = specialOffer;
    }

    /**
     * @return the isImport
     */
    public Boolean getIsImport()
    {
        return isImport;
    }

    /**
     * @param isImport
     *            the isImport to set
     */
    public void setIsImport(Boolean isImport)
    {
        this.isImport = isImport;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Cruise [cruiseId=" + cruiseId + ", name=" + name + "]";
    }

}
