package service;

import java.util.List;
import java.util.Map;

import DB.PortfolioDB;

public class PortfolioDE {

	PortfolioDB db = new PortfolioDB();

	public Map<String, List<String>> fetchPortfolioData(String userEmail) {

		return db.readPortfolio();
	}

}
