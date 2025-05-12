package controller;

import java.util.List;
import java.util.Map;

import service.PortfolioDE;
import service.ReportService;

/**
 * Controller class responsible for generating reports.
 */
public class ReportController {
	private final ReportService reportService = new ReportService();

	/**
	 * Generates a financial report for the specified user.
	 *
	 * @param userEmail the email of the user
	 */
	public void generateReport(String userEmail) {
		reportService.generateZakatReport(userEmail);
	}

	public Map<String, List<String>> requestReportData(String userEmail) {
		PortfolioDE de = new PortfolioDE();
		return de.fetchPortfolioData(userEmail);
	}
}
