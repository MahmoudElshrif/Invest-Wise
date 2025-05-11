package service;

import DB.PortfolioDB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Handles generation of user financial reports.
 */
public class ReportService {
	private final PortfolioDB portfolioDB = new PortfolioDB();
	private final ZakatService zakatService = new ZakatService();

	/**
	 * Generates a text report for the user's assets and zakat.
	 *
	 * @param userEmail the user's email
	 */
	public void generateZakatReport(String userEmail) {
		List<String> assets = portfolioDB.getAssets(userEmail);
		double zakat = zakatService.calculateZakat(userEmail);

		try (FileWriter writer = new FileWriter("data/" + userEmail.replace("@", "_") + "_report.txt")) {
			writer.write("📈 Wealth Wise Report for " + userEmail + "\n\n");
			writer.write("Assets:\n");
			for (String asset : assets) {
				writer.write(" - " + asset + "\n");
			}
			writer.write("\n💰 Zakat Due: " + zakat + "\n");
			System.out.println("✅ Report saved to /data/ folder.");
		} catch (IOException e) {
			System.out.println("❌ Failed to write report: " + e.getMessage());
		}
	}

	public void generatePortfolioReport(String userEmail){

	}
}
