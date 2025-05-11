package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportPanelUI extends JFrame {

	public ReportPanelUI() {
		// Set the title of the JFrame
		setTitle("Report Panel");

		// Set the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the layout for the JFrame
		setLayout(new BorderLayout());

		// Create a panel to hold components
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2, 10, 10));

		// Add some components to the panel
		panel.add(new JLabel("Report Name:"));
		panel.add(new JTextField(15));
		panel.add(new JLabel("Description:"));
		panel.add(new JTextArea(3, 15));

		// Add the panel to the JFrame
		add(panel, BorderLayout.CENTER);

		// Add a button at the bottom
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		JButton generateButton = new JButton("Generate Report");
		buttonPanel.add(generateButton);

		JButton backButton = new JButton("Back to Main Menu");
		buttonPanel.add(backButton);

		add(buttonPanel, BorderLayout.SOUTH);

		// Add action listener for the back button
		backButton.addActionListener(e -> {
			dispose();
			new MainMenuUI();
		});

		// Set the size of the JFrame
		setSize(400, 200);

		// Center the JFrame on the screen
		setLocationRelativeTo(null);

		setVisible(true);
	}

	public static void main(String[] args) {
		// Create an instance of ReportPanelUI and make it visible
		SwingUtilities.invokeLater(() -> {
			ReportPanelUI frame = new ReportPanelUI();
			frame.setVisible(true);
		});
	}
}
