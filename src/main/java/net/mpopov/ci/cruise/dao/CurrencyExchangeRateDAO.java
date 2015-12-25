package net.mpopov.ci.cruise.dao;

import java.util.List;

import net.mpopov.ci.cruise.model.CurrencyExchangeRate;

public interface CurrencyExchangeRateDAO
{

    public void add(CurrencyExchangeRate currencyExchangeRate);

    public void save(CurrencyExchangeRate currencyExchangeRate);

    public CurrencyExchangeRate load(Long currencyId, Short sourceType);

    public List<CurrencyExchangeRate> list();

}