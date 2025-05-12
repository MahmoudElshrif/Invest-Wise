package model;

import UI.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Investor {
	private String name;
	private String email;
	private String password;

	public Investor(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void openDashboard() {
		new DashboardUI(this).setVisible(true);
	}

	public void openPortfolio() {
		new PortfolioPageUI(this).setVisible(true);
	}

	public void openZakatPanel() {
		new ZakatPanelUI(this).setVisible(true);
	}

	public void openReportPanel() {
		new ReportPanelUI(this).setVisible(true);
	}

	public void openAssetManager() {
		new AssetManagementUI(this).setVisible(true);
	}

}