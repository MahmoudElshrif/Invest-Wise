package UI;

import controller.AssetController;
// import javafx.event.ActionEvent;
import model.Investor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * UI for managing user assets. Allows users to add, view, and refresh assets.
 */
public class AssetManagementUI extends JFrame {
	private final AssetController assetController = new AssetController();
	private final Investor investor;
	private DefaultListModel<String> assetListModel;

	/**
	 * Constructs the asset management window for the given investor.
	 *
	 * @param investor the logged-in investor
	 */
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
		JButton removeButton = new JButton("Remove");
		JButton backButton = new JButton("Back");

		bottomPanel.add(refreshButton);
		bottomPanel.add(removeButton);
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

		removeButton.addActionListener(e -> {
			int index = assetList.getSelectedIndex();

			if (index == -1) {
				JOptionPane.showMessageDialog(this, "no item selected");
			} else {
				RemoveAsset(index);
			}
		});

		refreshButton.addActionListener(e -> loadAssets());
		backButton.addActionListener(e -> {
			dispose();
			investor.openDashboard();
		});

		loadAssets();
	}

	/**
	 * Removes the selected asset from the investor's portfolio
	 * 
	 * @param assetID
	 */
	public void RemoveAsset(int assetID) {
		if (assetID >= 0 && assetID < assetListModel.size()) {
			assetController.removeAsset(investor.getEmail(), assetListModel.get(assetID));
			loadAssets();
			JOptionPane.showMessageDialog(this, "Asset removed from the list.");
		} else {
			JOptionPane.showMessageDialog(this, "Invalid asset ID.");
		}
	}

	/**
	 * Loads the user's asset list from the database and updates the UI.
	 */
	private void loadAssets() {
		assetListModel.clear();
		List<String> assets = assetController.viewAssets(investor.getEmail());
		for (String asset : assets) {
			assetListModel.addElement(asset);
		}
	}
}
