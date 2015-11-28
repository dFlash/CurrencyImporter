package net.mpopov.ci.cruise.service;

import java.util.List;
import java.util.Map;

public interface CruiseDateRangeMinPriceService {

	public void updateRates(Map<Long, Double> rates,
			List<Long> excludedCompanyIds);
}
