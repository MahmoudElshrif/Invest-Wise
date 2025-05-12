package UI;

import model.Investor;

import javax.swing.*;
import java.awt.*;

/**
 * Dashboard UI for navigating between different features of the Wealth Wise system.
 */
public class DashboardUI extends JFrame {
	private final Investor investor;

	/**
	 * Constructs the dashboard interface for the logged-in investor.
	 *
	 * @param investor the current user
	 */
	public DashboardUI(Investor investor) {
		this.investor = investor;

		setTitle("Wealth Wise - Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		buttonPanel.setBackground(Color.WHITE);

		JLabel titleLabel = new JLabel("Welcome, " + investor.getEmail());
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonPanel.add(titleLabel);
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		buttonPanel.add(createButton("Manage Assets", investor::openAssetManager));
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		buttonPanel.add(createButton("View Portfolio", investor::openPortfolio));
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		buttonPanel.add(createButton("Calculate Zakat", investor::openZakatPanel));
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		buttonPanel.add(createButton("Generate Report", investor::openReportPanel));

		JButton logoutButton = createStyledButton("Logout");
		logoutButton.addActionListener(e -> {
			dispose();
			new LoginPageUI().setVisible(true);
		});
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		buttonPanel.add(logoutButton);

		add(buttonPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	/**
	 * Creates a styled button with an attached action and handles disposal of the current frame.
	 *
	 * @param text   the label on the button
	 * @param action the action to perform when clicked
	 * @return a configured JButton
	 */
	private JButton createButton(String text, Runnable action) {
		JButton button = createStyledButton(text);
		button.addActionListener(e -> {
			dispose();
			action.run();
		});
		return button;
	}

	/**
	 * Creates a uniformly styled JButton.
	 *
	 * @param text the label of the button
	 * @return a styled JButton
	 */
	private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setBackground(new Color(70, 130, 180));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		return button;
	}
}
