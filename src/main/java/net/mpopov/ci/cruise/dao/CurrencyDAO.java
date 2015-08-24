package net.mpopov.ci.cruise.dao;

import java.util.List;

import net.mpopov.ci.cruise.model.Currency;

public interface CurrencyDAO
{

    public void add(Currency currency);

    public void save(Currency currency);

    public Currency load(Long currencyId);

    public List<Currency> list();

	public Currency loadBaseId();

}