package net.mpopov.ci.cruise.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mpopov.ci.cruise.model.CruiseDateRangeMinPrice;

@Repository
public class CruiseDateRangeMinPriceDAOImpl
        implements CruiseDateRangeMinPriceDAO
{

    @Autowired
    private SessionFactory sessionFactory;

    public void add(CruiseDateRangeMinPrice cruiseDateRangeMinPrice)
    {
        sessionFactory.getCurrentSession().save(cruiseDateRangeMinPrice);
    }

    public void save(CruiseDateRangeMinPrice cruiseDateRangeMinPrice)
    {
        sessionFactory.getCurrentSession().merge(cruiseDateRangeMinPrice);
    }

    public void remove(Long currencyId)
    {
        String hql = "delete from CruiseDateRangeMinPrice cruiseDateRangeMinPrice "
                + " where cruiseDateRangeMinPrice.currency.currencyId = :currencyId";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("currencyId", currencyId);

        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<CruiseDateRangeMinPrice> listCbrMinPrices(
            List<Long> excludedCompanyIds)
    {
        String hqlTmpl = " from CruiseDateRangeMinPrice cruiseDateRangeMinPrice %s               "
                + " order by cruiseDateRange.cruiseDateRangeId, cruiseDateRangeMinPriceId ";

        String condition = "";
        if (excludedCompanyIds != null && !excludedCompanyIds.isEmpty())
        {
            condition += " where cruiseDateRangeMinPrice.cruiseDateRange.cruise.vessel.company.companyId "
                    + "    not in (:excludedCompanyIds)";
        }

        String hql = String.format(hqlTmpl, condition);

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        if (excludedCompanyIds != null && !excludedCompanyIds.isEmpty())
        {
            query.setParameterList("excludedCompanyIds", excludedCompanyIds);
        }

        List<CruiseDateRangeMinPrice> cruiseDateRangeMinPrices = query.list();

        return cruiseDateRangeMinPrices;
    }

    @Override
    public void removeByDataRange(Long cruiseDateRangeId)
    {
        String hql = "delete from CruiseDateRangeMinPrice cruiseDateRangeMinPrice   "
                + " where cruiseDateRangeMinPrice.cruiseDateRange.cruiseDateRangeId "
                + " = :cruiseDateRangeId                                            ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("cruiseDateRangeId", cruiseDateRangeId);

        query.executeUpdate();
    }

}
