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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "public.vessel")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
public class Vessel
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "vessel_vessel_id_seq")
    @SequenceGenerator(name = "vessel_vessel_id_seq",
            sequenceName = "vessel_vessel_id_seq")
    @Column(name = "vessel_id", nullable = false)
    private Long vesselId;

    @Column(name = "name")
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "ufl")
    @Size(min = 1, max = 256)
    private String ufl;

    @Column(name = "description")
    @Size(max = 65536)
    private String description;

    @Column(name = "vessel_category_id")
    @NotNull
    private Long vesselCategory;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    @NotNull
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
    private Company company;

    @Column(name = "gallery_id")
    private Long gallery;

    @Column(name = "description_gallery_id")
    private Long descriptionGallery;

    @Column(name = "schema_gallery_id")
    private Long schemaGallery;

    @Column(name = "build_year")
    @DateTimeFormat(iso = ISO.NONE, pattern = "yyyy")
    @Past
    private Date buildYear;

    @Column(name = "width")
    @Min(0)
    private Float width;

    @Column(name = "length")
    @Min(0)
    private Float length;

    @Column(name = "speed")
    @Min(0)
    private Float speed;

    @Column(name = "capacity")
    @Min(0)
    private Integer capacity;

    @Column(name = "balancer")
    private Boolean balancer;

    @Column(name = "deck_quantity")
    @Min(0)
    private Integer deckQuantity;

    @Column(name = "cabin_quantity")
    @Min(0)
    private Integer cabinQuantity;

    @Column(name = "restaurant_quantity")
    @Min(0)
    private Integer restaurantQuantity;

    @Column(name = "lift_quantity")
    @Min(0)
    private Integer liftQuantity;

    @Column(name = "pool_quantity")
    @Min(0)
    private Integer poolQuantity;

    @Column(name = "is_import")
    private Boolean isImport;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    /**
     * @return the vesselId
     */
    public Long getVesselId()
    {
        return vesselId;
    }

    /**
     * @param vesselId
     *            the vesselId to set
     */
    public void setVesselId(Long vesselId)
    {
        this.vesselId = vesselId;
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
     * @return the vesselCategory
     */
    public Long getVesselCategory()
    {
        return vesselCategory;
    }

    /**
     * @param vesselCategory
     *            the vesselCategory to set
     */
    public void setVesselCategory(Long vesselCategory)
    {
        this.vesselCategory = vesselCategory;
    }

    /**
     * @return the company
     */
    public Company getCompany()
    {
        return company;
    }

    /**
     * @param company
     *            the company to set
     */
    public void setCompany(Company company)
    {
        this.company = company;
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
     * @return the buildYear
     */
    public Date getBuildYear()
    {
        return buildYear;
    }

    /**
     * @param buildYear
     *            the buildYear to set
     */
    public void setBuildYear(Date buildYear)
    {
        this.buildYear = buildYear;
    }

    /**
     * @return the width
     */
    public Float getWidth()
    {
        return width;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(Float width)
    {
        this.width = width;
    }

    /**
     * @return the length
     */
    public Float getLength()
    {
        return length;
    }

    /**
     * @param length
     *            the length to set
     */
    public void setLength(Float length)
    {
        this.length = length;
    }

    /**
     * @return the speed
     */
    public Float getSpeed()
    {
        return speed;
    }

    /**
     * @param speed
     *            the speed to set
     */
    public void setSpeed(Float speed)
    {
        this.speed = speed;
    }

    /**
     * @return the capacity
     */
    public Integer getCapacity()
    {
        return capacity;
    }

    /**
     * @param capacity
     *            the capacity to set
     */
    public void setCapacity(Integer capacity)
    {
        this.capacity = capacity;
    }

    /**
     * @return the balancer
     */
    public Boolean getBalancer()
    {
        return balancer;
    }

    /**
     * @param balancer
     *            the balancer to set
     */
    public void setBalancer(Boolean balancer)
    {
        this.balancer = balancer;
    }

    /**
     * @return the deckQuantity
     */
    public Integer getDeckQuantity()
    {
        return deckQuantity;
    }

    /**
     * @param deckQuantity
     *            the deckQuantity to set
     */
    public void setDeckQuantity(Integer deckQuantity)
    {
        this.deckQuantity = deckQuantity;
    }

    /**
     * @return the cabinQuantity
     */
    public Integer getCabinQuantity()
    {
        return cabinQuantity;
    }

    /**
     * @param cabinQuantity
     *            the cabinQuantity to set
     */
    public void setCabinQuantity(Integer cabinQuantity)
    {
        this.cabinQuantity = cabinQuantity;
    }

    /**
     * @return the restaurantQuantity
     */
    public Integer getRestaurantQuantity()
    {
        return restaurantQuantity;
    }

    /**
     * @param restaurantQuantity
     *            the restaurantQuantity to set
     */
    public void setRestaurantQuantity(Integer restaurantQuantity)
    {
        this.restaurantQuantity = restaurantQuantity;
    }

    /**
     * @return the liftQuantity
     */
    public Integer getLiftQuantity()
    {
        return liftQuantity;
    }

    /**
     * @param liftQuantity
     *            the liftQuantity to set
     */
    public void setLiftQuantity(Integer liftQuantity)
    {
        this.liftQuantity = liftQuantity;
    }

    /**
     * @return the poolQuantity
     */
    public Integer getPoolQuantity()
    {
        return poolQuantity;
    }

    /**
     * @param poolQuantity
     *            the poolQuantity to set
     */
    public void setPoolQuantity(Integer poolQuantity)
    {
        this.poolQuantity = poolQuantity;
    }

    /**
     * @return the schemaGallery
     */
    public Long getSchemaGallery()
    {
        return schemaGallery;
    }

    /**
     * @param schemaGallery
     *            the schemaGallery to set
     */
    public void setSchemaGallery(Long schemaGallery)
    {
        this.schemaGallery = schemaGallery;
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

    /**
     * @return the isEnabled
     */
    public Boolean getIsEnabled()
    {
        return isEnabled;
    }

    /**
     * @param isEnabled
     *            the isEnabled to set
     */
    public void setIsEnabled(Boolean isEnabled)
    {
        this.isEnabled = isEnabled;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Vessel [vesselId=" + vesselId + ", name=" + name + "]";
    }

}
