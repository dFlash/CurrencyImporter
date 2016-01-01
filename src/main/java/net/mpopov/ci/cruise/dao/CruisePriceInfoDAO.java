package net.mpopov.ci.cruise.dao;

import java.util.List;

import net.mpopov.ci.cruise.model.CruisePriceInfo;

public interface CruisePriceInfoDAO
{

    public void add(CruisePriceInfo cruisePriceInfo);

    public void remove(Long cruiseDateRangeId, Long cabinId);

    public List<CruisePriceInfo> listCbrPrices(
            List<Long> excludedCompanyIds);
}
