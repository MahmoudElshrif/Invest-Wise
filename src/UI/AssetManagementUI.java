package UI;

import controller.AssetController;
import model.Investor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AssetManagementUI extends JFrame {
	private final AssetController assetController = new AssetController();
	private final Investor investor;
	private DefaultListModel<String> assetListModel;

	public AssetManagementUI(Investor investor) {
		this.investor = investor;

		setTitle("Asset Manager");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout());

		JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
		JTextField assetNameField = new JTextField();
		JTextField assetValueField = new JTextField();

		inputPanel.add(new JLabel("Asset Name:"));
		inputPanel.add(assetNameField);
		inputPanel.add(new JLabel("Asset Value (EGP):"));
		inputPanel.add(assetValueField);

		JButton addButton = new JButton("Add Asset");
		inputPanel.add(addButton);

		panel.add(inputPanel, BorderLayout.NORTH);

		assetListModel = new DefaultListModel<>();
		JList<String> assetList = new JList<>(assetListModel);
		JScrollPane scrollPane = new JScrollPane(assetList);
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel(new FlowLayout());
		JButton refreshButton = new JButton("Refresh");
		JButton backButton = new JButton("Back");

		bottomPanel.add(refreshButton);
		bottomPanel.add(backButton);
		panel.add(bottomPanel, BorderLayout.SOUTH);

		add(panel);
		setVisible(true);

		addButton.addActionListener(e -> {
			String name = assetNameField.getText().trim();
			String valueStr = assetValueField.getText().trim();

			if (name.isEmpty() || valueStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Please fill in both fields.");
				return;
			}

			try {
				double value = Double.parseDouble(valueStr);
				assetController.addAsset(investor.getEmail(), name, value);
				JOptionPane.showMessageDialog(this, "✅ Asset added!");
				assetNameField.setText("");
				assetValueField.setText("");
				loadAssets();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "❌ Invalid number format.");
			}
		});

		refreshButton.addActionListener(e -> loadAssets());
		backButton.addActionListener(e -> {
			dispose();
			investor.openDashboard();
		});

		loadAssets();
	}

	private void loadAssets() {
		assetListModel.clear();
		List<String> assets = assetController.viewAssets(investor.getEmail());
		for (String asset : assets) {
			assetListModel.addElement(asset);
		}
	}
}