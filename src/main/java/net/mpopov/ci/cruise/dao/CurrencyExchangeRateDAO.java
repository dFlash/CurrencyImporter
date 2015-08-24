package net.mpopov.ci.cruise.dao;

import java.util.List;

import net.mpopov.ci.cruise.model.CurrencyExchangeRate;

public interface CurrencyExchangeRateDAO
{

    public void add(CurrencyExchangeRate currencyExchangeRate);

    public void save(CurrencyExchangeRate currencyExchangeRate);

    public CurrencyExchangeRate load(Long currencyExchangeRateId);

    public List<CurrencyExchangeRate> list();

}