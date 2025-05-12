package UI;

import controller.AssetController;
import model.Investor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * UI for displaying the user's asset portfolio.
 * Allows refreshing the view and returning to the dashboard.
 */
public class PortfolioPageUI extends JFrame {
	private final AssetController assetController = new AssetController();
	private final Investor investor;
	private DefaultListModel<String> assetListModel;

	/**
	 * Constructs the portfolio window for the given investor.
	 *
	 * @param investor the logged-in user
	 */
	public PortfolioPageUI(Investor investor) {
		this.investor = investor;
		setTitle("Your Portfolio");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		assetListModel = new DefaultListModel<>();
		JList<String> assetList = new JList<>(assetListModel);
		loadAssets();

		JButton refreshButton = new JButton("Refresh");
		JButton backButton = new JButton("Back");

		refreshButton.addActionListener(e -> loadAssets());
		backButton.addActionListener(e -> {
			dispose();
			investor.openDashboard();
		});

		add(new JScrollPane(assetList), BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(refreshButton);
		buttonPanel.add(backButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	/**
	 * Loads the assets from the database for the logged-in user
	 * and updates the asset list display.
	 */
	private void loadAssets() {
		assetListModel.clear();
		List<String> assets = assetController.viewAssets(investor.getEmail());
		for (String asset : assets) {
			assetListModel.addElement(asset);
		}
	}
}
