package net.mpopov.ci.cruise.dao;

import java.util.List;

import net.mpopov.ci.cruise.model.CruiseDateRangeMinPrice;

public interface CruiseDateRangeMinPriceDAO {
	
	public void add(CruiseDateRangeMinPrice cruiseDateRangeMinPrice);
	
	public void save(CruiseDateRangeMinPrice cruiseDateRangeMinPrice);
	
	public void remove(Long currencyId);
	
	public List<CruiseDateRangeMinPrice> listCbrMinPrices(List<Long> excludedCompanyIds);

}
