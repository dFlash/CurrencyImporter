package net.mpopov.ci.cruise.service;

import java.util.List;

import net.mpopov.ci.cruise.dao.CurrencyDAO;
import net.mpopov.ci.cruise.model.Currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService
{
    @Autowired
    private CurrencyDAO currencyDAO;

    @Transactional
    public void add(Currency currency)
    {
        currencyDAO.add(currency);
    }

    @Transactional
    public void save(Currency currency)
    {
        currencyDAO.save(currency);
    }

    @Transactional
    public Currency loadBaseId()
    {
        return currencyDAO.loadBaseId();
    }

    @Transactional
    public Currency load(Long currencyId)
    {
        return currencyDAO.load(currencyId);
    }

    @Transactional
    public List<Currency> list()
    {
        return currencyDAO.list();
    }

}
