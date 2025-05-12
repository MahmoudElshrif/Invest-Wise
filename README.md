# Wealth Wise

Wealth Wise is a Java-based application designed to help users manage their financial assets, portfolios, and reports. Below is an overview of the key Java files in the project and their respective functionalities:

## Controller Layer

1. **AssetController.java**

   - Handles asset-related operations such as adding, viewing, and removing assets.

2. **AuthController.java**

   - Manages user authentication, including login and registration.

3. **ReportController.java**

   - Facilitates the generation and retrieval of financial reports.

4. **ZakatController.java**
   - Calculates and manages Zakat-related functionalities.

## Database Layer

1. **AssetDB.java**

   - Handles database operations related to assets, such as storing and retrieving asset data.

2. **PortfolioDB.java**

   - Manages database interactions for user portfolios.

3. **UserDB.java**
   - Handles user-related database operations, including user information storage and retrieval.

## Model Layer

1. **Investor.java**
   - Represents the user (investor) in the system, including their attributes and behaviors.

## Service Layer

1. **AssetService.java**

   - Provides business logic for asset management, acting as a bridge between the controller and database layers.

2. **AuthService.java**

   - Implements authentication logic, including password validation and user session management.

3. **PortfolioDE.java**

   - Handles portfolio-related business logic.

4. **ReportService.java**

   - Provides services for generating and managing financial reports.

5. **ZakatService.java**
   - Implements the logic for Zakat calculations and related operations.

## UI Layer

1. **AssetManagementUI.java**

   - Provides a graphical user interface for managing user assets, including adding, viewing, and editing assets.

2. **DashboardUI.java**

   - Displays the main dashboard for users after login, providing access to various features.

3. **LoginPageUI.java**

   - Handles the user login interface.

4. **ReportPanelUI.java**

   - Displays financial reports to the user.

5. **PortfolioPageUI.java**

   - Provides an interface for managing and viewing user portfolios.

6. **SignUpPage.java**

   - Handles the user registration interface.

7. **ZakatPanelUI.java**
   - Provides a user interface for Zakat-related functionalities.

---

This project is structured to follow a clear separation of concerns, with each layer handling specific responsibilities to ensure maintainability and scalability.
