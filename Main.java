import db.UserDB;
import service.AssetService;
import service.ReportService;
import service.ZakatService;
import ui.SignUpPage;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.main(args);
    }
}