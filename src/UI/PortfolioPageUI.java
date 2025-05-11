package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI class responsible for displaying user's portfolio.
 */
public class PortfolioPageUI extends JFrame {

	/**
	 * Constructor to set up the PortfolioPage.
	 */
	public PortfolioPageUI() {
		setTitle("Portfolio Page");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Set up the content
		initializeUI();
	}

	/**
	 * Initializes the UI components.
	 */
	private void initializeUI() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JLabel titleLabel = new JLabel("Your Portfolio", SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(titleLabel, BorderLayout.NORTH);

		JTextArea assetsArea = new JTextArea();
		assetsArea.setEditable(false);
		assetsArea.setText("Asset list will be displayed here...");
		panel.add(new JScrollPane(assetsArea), BorderLayout.CENTER);

		// Add a back button
		JButton backButton = new JButton("Back to Main Menu");
		backButton.addActionListener(e -> {
			dispose(); // Close the current window
			new MainMenuUI(); // Open the MainMenuUI
		});
		panel.add(backButton, BorderLayout.SOUTH);

		add(panel);

		setVisible(true);
	}

	/**
	 * Displays the list of user's assets in the portfolio.
	 */
	public void showAssets() {
		// TODO: Populate the asset list dynamically
		System.out.println("Your portfolio:");
	}

}
