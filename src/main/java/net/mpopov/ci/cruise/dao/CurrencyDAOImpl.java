package net.mpopov.ci.cruise.dao;

import java.util.List;

import net.mpopov.ci.cruise.model.Currency;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("currencyDAO")
public class CurrencyDAOImpl implements CurrencyDAO
{
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Currency currency)
    {
        sessionFactory.getCurrentSession().save(currency);
    }

    public void save(Currency currency)
    {
        sessionFactory.getCurrentSession().merge(currency);
    }

    public Currency load(Long currencyId)
    {
        return (Currency) sessionFactory.getCurrentSession().get(Currency.class,
                currencyId);
    }

    @SuppressWarnings("unchecked")
    public Currency loadBaseId()
    {
        String hql = "from Currency currency where currency.base = true";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<Currency> list = query.list();

        if (list.isEmpty())
            return null;

        return list.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<Currency> list()
    {
        String hql = "from Currency currency ";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        List<Currency> list = query.list();

        return list;
    }
}
