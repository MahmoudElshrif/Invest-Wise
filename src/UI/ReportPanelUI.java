package UI;

import controller.ReportController;
import model.Investor;

import javax.swing.*;
import java.awt.*;

/**
 * UI for generating a financial report for the logged-in user.
 */
public class ReportPanelUI extends JFrame {
	private final ReportController reportController = new ReportController();
	private final Investor investor;

	/**
	 * Constructs the report panel for the given investor.
	 *
	 * @param investor the logged-in user
	 */
	public ReportPanelUI(Investor investor) {
		this.investor = investor;
		setTitle("Generate Report");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JButton generateButton = new JButton("Generate Report");
		JButton backButton = new JButton("Back");
		JLabel statusLabel = new JLabel("Click to generate report");
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

		generateButton.addActionListener(e -> {
			reportController.generateReport(investor.getEmail());
			statusLabel.setText("✅ Report saved to /data/ folder");
		});

		setLayout(new BorderLayout());
		add(statusLabel, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(generateButton);
		buttonPanel.add(backButton);
		add(buttonPanel, BorderLayout.CENTER);

		backButton.addActionListener(e -> {
			dispose();
			investor.openDashboard();
		});
	}
}
