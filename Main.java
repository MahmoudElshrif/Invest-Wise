import db.UserDB;
import service.AssetService;
import service.ReportService;
import service.ZakatService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZakatService zakatService = new ZakatService();
        zakatService.calculateZakat("test@example.com");

        ReportService reportService = new ReportService();
        reportService.generateReport("test@example.com");
    }
}