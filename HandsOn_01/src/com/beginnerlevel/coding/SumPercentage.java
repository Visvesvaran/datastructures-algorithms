package com.beginnerlevel.coding;

import java.util.HashMap;
import java.util.List;

public class SumPercentage {

	public Float calculatePercentage(List<LiablityExtract> listLiablityExtract) {
		Float sum = 0.0f;

		HashMap<String, Float> hashLiabilityExtract = new HashMap<>();
		for (LiablityExtract liablityExtract : listLiablityExtract) {
			if (!hashLiabilityExtract.containsKey(liablityExtract.getName())) {
				hashLiabilityExtract.put(liablityExtract.getName(), liablityExtract.getPercentage());
			} else {
				if (hashLiabilityExtract.get(liablityExtract.getName()) < liablityExtract.getPercentage()) {
					hashLiabilityExtract.put(liablityExtract.getName(), liablityExtract.getPercentage());
				}
			}
		}
		for (String key : hashLiabilityExtract.keySet()) {
			sum += hashLiabilityExtract.get(key);
		}

		return sum;
	}

}
