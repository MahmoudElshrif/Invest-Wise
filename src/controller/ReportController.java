package controller;

import service.ReportService;

public class ReportController {
    private final ReportService reportService = new ReportService();

    public void generateReport(String userEmail) {
        reportService.generateReport(userEmail);
    }
}
