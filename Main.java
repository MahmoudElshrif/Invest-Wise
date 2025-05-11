import db.UserDB;
import service.AssetService;
import service.ReportService;
import service.ZakatService;
import ui.SignUpPage;

import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the Wealth Wise application.
 */
public class Main {

    /**
     * Launches the Sign-Up page for the user.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.main(args);
    }
}
