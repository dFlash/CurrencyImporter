package net.mpopov.ci.cruise.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.mpopov.ci.cruise.model.CruisePriceInfo;

@Repository
public class CruisePriceInfoDAOImpl implements CruisePriceInfoDAO
{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(CruisePriceInfo cruisePriceInfo)
    {
        sessionFactory.getCurrentSession().save(cruisePriceInfo);
    }

    @Override
    public void remove(Long cruiseDateRangeId, Long cabinId)
    {
        String hql = "delete from CruisePriceInfo cruisePriceInfo                  "
                + "   where cruiseDateRange.cruiseDateRangeId = :cruiseDateRangeId "
                + "     and cabinId = :cabinId                                     ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("cruiseDateRangeId", cruiseDateRangeId);
        query.setParameter("cabinId", cabinId);

        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CruisePriceInfo> listCbrPrices(
            List<Long> excludedCompanyIds)
    {
        String hqlTmpl = " from CruisePriceInfo cruisePriceInfo %s                "
                + " order by cruiseDateRange.cruiseDateRangeId, cabinId, dateTime ";

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

        List<CruisePriceInfo> cruisesPricesInfo = query.list();

        return cruisesPricesInfo;
    }

}
