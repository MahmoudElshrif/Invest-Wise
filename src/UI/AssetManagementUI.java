package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI class responsible for displaying the asset management panel.
 */
public class AssetManagementUI extends JFrame {

	public AssetManagementUI() {
		// Set up the JFrame
		setTitle("Asset Management");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		// Add a label
		JLabel label = new JLabel("Add your asset details:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label, BorderLayout.CENTER);

		// Add a button to go back to MainMenuUI
		JButton backButton = new JButton("Back to Main Menu");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Navigate back to MainMenuUI
				new MainMenuUI().setVisible(true);
				dispose(); // Close the current window
			}
		});
		add(backButton, BorderLayout.SOUTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		// Launch the AssetManagementUI
		SwingUtilities.invokeLater(() -> {
			AssetManagementUI ui = new AssetManagementUI();
			ui.setVisible(true);
		});
	}
}
