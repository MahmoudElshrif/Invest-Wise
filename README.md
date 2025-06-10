# 💰 Wealth Wise

**Wealth Wise** is a Java-based desktop application designed to help users manage their **financial assets**, **portfolios**, **Zakat**, and **detailed reports**. The project follows a clean, layered architecture with a strong separation of concerns, ensuring maintainability and scalability.

---

## 🧱 Architecture Overview

The application is divided into multiple logical layers:

### 📦 Controller Layer

Handles user actions and connects the UI with the business logic.

- **`AssetController.java`** – Manage asset operations (add, view, delete).
- **`AuthController.java`** – Handle user authentication (login, registration).
- **`ReportController.java`** – Generate and retrieve financial reports.
- **`ZakatController.java`** – Calculate and manage Zakat obligations.

---

### 🗃️ Database Layer

Manages data persistence and interaction with the underlying storage.

- **`AssetDB.java`** – Perform CRUD operations for assets.
- **`PortfolioDB.java`** – Manage data related to user portfolios.
- **`UserDB.java`** – Handle user information and credentials.

---

### 🧍 Model Layer

Represents the core data structures used throughout the system.

- **`Investor.java`** – Defines user properties and behavior (i.e., the investor).

---

### 🧠 Service Layer

Implements the application's core business logic.

- **`AssetService.java`** – Connects asset operations between the UI and DB.
- **`AuthService.java`** – Handles login validation and session management.
- **`PortfolioDE.java`** – Business logic for portfolio management.
- **`ReportService.java`** – Generates financial summaries and analysis.
- **`ZakatService.java`** – Calculates Zakat obligations accurately.

---

### 🖥️ UI Layer

Provides a graphical interface to enhance user interaction.

- **`AssetManagementUI.java`** – GUI for adding/editing/viewing assets.
- **`DashboardUI.java`** – Main landing interface post-login.
- **`LoginPageUI.java`** – User login screen.
- **`SignUpPage.java`** – User registration screen.
- **`PortfolioPageUI.java`** – Manage and view portfolios.
- **`ReportPanelUI.java`** – Display financial reports.
- **`ZakatPanelUI.java`** – Interact with Zakat calculator and results.

---

## 🧩 Key Features

- 🔐 **User Authentication** – Register and login securely.
- 📊 **Asset Management** – Track, add, and view various financial assets.
- 🗂️ **Portfolio Overview** – Monitor overall financial health.
- 📑 **Report Generation** – Visualize and export detailed financial reports.
- 🕌 **Zakat Calculator** – Automatically compute Zakat based on assets.
- 🖼️ **User-Friendly GUI** – Interactive and clean Swing-based interfaces.

---

## 🚀 Getting Started

### 🧰 Requirements

- Java JDK 8 or later
- Java IDE (e.g., IntelliJ, Eclipse, NetBeans)

---
