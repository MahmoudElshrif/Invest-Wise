package UI;

import controller.ZakatController;
import model.Investor;

import javax.swing.*;
import java.awt.*;

/**
 * UI panel for calculating zakat for a user's assets.
 */
public class ZakatPanelUI extends JFrame {
	private final ZakatController zakatController = new ZakatController();
	private final Investor investor;

	/**
	 * Constructs the zakat calculator window for the given investor.
	 *
	 * @param investor the logged-in user
	 */
	public ZakatPanelUI(Investor investor) {
		this.investor = investor;
		setTitle("Zakat Calculator");
		setSize(350, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout());

		JButton calculateButton = new JButton("Calculate Zakat");
		JLabel resultLabel = new JLabel("Zakat: ");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

		/**
		 * When the "Calculate Zakat" button is clicked, this retrieves the
		 * zakat amount from the controller and updates the result label.
		 */
		calculateButton.addActionListener(e -> {
			double zakat = zakatController.calculateZakat(investor.getEmail());
			resultLabel.setText("Zakat due: " + zakat + " EGP");
		});

		// Back button
		JButton backButton = new JButton("Back");
		backButton.addActionListener(e -> {
			dispose();
			investor.openDashboard();
		});

		JPanel bottomPanel = new JPanel(new FlowLayout());
		bottomPanel.add(calculateButton);
		bottomPanel.add(backButton);

		panel.add(resultLabel, BorderLayout.CENTER);
		panel.add(bottomPanel, BorderLayout.SOUTH);
		add(panel);
	}
}
