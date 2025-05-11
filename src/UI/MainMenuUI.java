package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuUI extends JFrame {
	public MainMenuUI() {
		// Set up the frame
		super("Main Menu");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLayout(new BorderLayout());

		// Create a panel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding
		buttonPanel.setBackground(Color.WHITE);

		// Add "Main Menu" label above the buttons
		JLabel titleLabel = new JLabel("Main Menu");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(titleLabel);
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing below the label

		// Add buttons using helper method
		JButton showAssetsButton = createButton("Show Assets");
		showAssetsButton.addActionListener(
				e -> {
					dispose(); // Close the current window
					new AssetManagementUI(); // Open Asset Management UI
				});
		buttonPanel.add(showAssetsButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons

		JButton showPortfolioButton = createButton("Show Portfolio");
		showPortfolioButton.addActionListener(
				e -> {
					dispose(); // Close the current window
					new PortfolioPageUI(); // Open Portfolio Page UI
				});
		buttonPanel.add(showPortfolioButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons

		JButton showZakatButton = createButton("Show Zakat");
		showZakatButton.addActionListener(
				e -> {
					dispose(); // Close the current window
					new ZakatPanelUI(); // Open Zakat Panel UI
				});
		buttonPanel.add(showZakatButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons

		JButton generateReportButton = createButton("Generate Report");
		generateReportButton.addActionListener(
				e -> {
					dispose(); // Close the current window
					new ReportPanelUI(); // Open Report Page UI
				});
		buttonPanel.add(generateReportButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing between buttons

		JButton logoutButton = createButton("Logout");
		logoutButton.addActionListener(
				e -> {
					dispose(); // Close the current window
					new SignUpPage(); // Open Signup Page UI
				});
		buttonPanel.add(logoutButton);

		// Add the panel to the frame
		add(buttonPanel, BorderLayout.CENTER);

		// Make the frame visible
		setVisible(true);
	}

	private JButton createButton(String text) {
		JButton button = createStyledButton(text);
		return button;
	}

	private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setBackground(new Color(70, 130, 180)); // Steel blue color
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		return button;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(MainMenuUI::new);
	}
}
