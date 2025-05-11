package controller;

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
        reportService.generateReport(userEmail);
    }
}
