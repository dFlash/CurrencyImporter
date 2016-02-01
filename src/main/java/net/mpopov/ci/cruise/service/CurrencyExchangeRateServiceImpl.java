package net.mpopov.ci.cruise.service;

import java.util.List;

import net.mpopov.ci.cruise.dao.CurrencyExchangeRateDAO;
import net.mpopov.ci.cruise.model.CurrencyExchangeRate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("currencyExchangeRateService")
public class CurrencyExchangeRateServiceImpl
        implements CurrencyExchangeRateService
{
    @Autowired
    private CurrencyExchangeRateDAO currencyExchangeRateDAO;

    @Transactional
    public void add(CurrencyExchangeRate currencyExchangeRateExchangeRate)
    {
        currencyExchangeRateDAO.add(currencyExchangeRateExchangeRate);
    }

    @Transactional
    public void save(CurrencyExchangeRate currencyExchangeRate)
    {
        currencyExchangeRateDAO.save(currencyExchangeRate);
    }

    @Transactional
    public List<CurrencyExchangeRate> list()
    {
        return currencyExchangeRateDAO.list();
    }

    @Override
    public String toString()
    {
        return "CurrencyExchangeRateServiceImpl [for test]";
    }

}
