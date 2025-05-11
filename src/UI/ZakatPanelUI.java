package UI;

import javax.swing.*;
import java.awt.*;

public class ZakatPanelUI extends JFrame {
	public ZakatPanelUI() {
		setTitle("Zakat Panel");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Create a button to go back to the main menu
		JButton backButton = new JButton("Back to Main Menu");
		backButton.addActionListener(e -> {
			dispose();
			new MainMenuUI();
			// You can replace this with actual navigation logic
		});

		// Add the button to the bottom of the frame
		add(backButton, BorderLayout.SOUTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ZakatPanelUI zakatPanel = new ZakatPanelUI();
			zakatPanel.setVisible(true);
		});
	}
}