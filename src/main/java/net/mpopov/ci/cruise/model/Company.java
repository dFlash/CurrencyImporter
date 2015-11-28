package net.mpopov.ci.cruise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "public.company")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "DISK_REGION")
public class Company
{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "company_company_id_seq")
    @SequenceGenerator(name = "company_company_id_seq",
            sequenceName = "company_company_id_seq")
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "name")
    @Size(min = 1, max = 256)
    private String name;

    @Column(name = "ufl")
    @Size(min = 1, max = 256)
    private String ufl;

    @Column(name = "company_category_id")
    @NotNull
    private Long companyCategory;

    @Column(name = "company_cruise_category_id")
    private Long companyCruiseCategory;

    @Column(name = "description")
    @Size(max = 65536)
    private String description;

    @Column(name = "gallery_id")
    private Long gallery;

	public Long getCompanyCruiseCategory() {
		return companyCruiseCategory;
	}

	public void setCompanyCruiseCategory(Long companyCruiseCategory) {
		this.companyCruiseCategory = companyCruiseCategory;
	}

	/**
     * @return the companyId
     */
    public Long getCompanyId()
    {
        return companyId;
    }

    /**
     * @param companyId
     *            the companyId to set
     */
    public void setCompanyId(Long companyId)
    {
        this.companyId = companyId;
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
     * @return the companyCategory
     */
    public Long getCompanyCategory()
    {
        return companyCategory;
    }

    /**
     * @param companyCategory
     *            the companyCategory to set
     */
    public void setCompanyCategory(Long companyCategory)
    {
        this.companyCategory = companyCategory;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Company [companyId=" + companyId + ", name=" + name + "]";
    }

}
