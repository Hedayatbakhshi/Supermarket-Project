# Supermarket-Project

A comprehensive Java Swing-based Supermarket Management System for managing customers, inventory, sales, and reporting. This project is designed to demonstrate best practices in Java desktop application development, including secure authentication, modular code organization, and user-friendly GUI design.

---

## Table of Contents

- [Features](#features)
- [Screenshots](#screenshots)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation & Setup](#installation--setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Database Schema](#database-schema)
- [Security](#security)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## Features

- **User Authentication**
  - Secure login system using BCrypt password hashing
  - User registration with validation
  - Password reset (with safe update in the database)

- **Customer Management**
  - Register new customers with required details (name, contact, gender, email, etc.)
  - List, update, or delete customers
  - Track customer balances

- **Inventory Management**
  - Add, update, delete, and search products by name or category
  - Categorize products and manage product units (e.g., kg, ml, pcs)
  - Track product expiry dates and stock levels

- **Sales and Purchases**
  - Sell products to customers, automatically deducting from their balance
  - Print receipts for purchases
  - Record purchase history for each customer

- **Reports & Data Export**
  - Generate and view reports for purchases, customers, and products
  - Export reports to Excel (`.xlsx`) or CSV format
  - Clear purchase history with confirmation

- **User Interface**
  - Modern, intuitive UI built with NetBeans GUI Builder
  - Easy navigation between modules
  - Responsive feedback and error messages

- **Extensible & Maintainable Code**
  - Modular class structure (DAL, Helper, UI forms)
  - Easy to add new features or modify existing ones

---

## Screenshots

> ![image](https://github.com/user-attachments/assets/90714a9e-b805-434c-b880-bb20fa18e5c6)
> ![image](https://github.com/user-attachments/assets/5e277683-05fb-4a65-bf67-010599566ba5)
> ![image](https://github.com/user-attachments/assets/dcac0306-70fd-4bce-aa8a-abb4252cf912)
> ![image](https://github.com/user-attachments/assets/f7153094-1da8-418c-b2e8-62108350a5c1)
> ![image](https://github.com/user-attachments/assets/3f08d71f-9ff2-467c-b2d2-a1605ffac8c6)
> ![image](https://github.com/user-attachments/assets/317841a5-8c8c-4f07-9d14-b8380fe83db2)
> ![image](https://github.com/user-attachments/assets/45eb7a2c-8d70-40a8-89f1-0f1060db9875)







- ![Login Screen](screenshots/login.png)
- ![Dashboard](screenshots/dashboard.png)
- ![Inventory Management](screenshots/inventory.png)
- ![Customer Registration](screenshots/customer_registration.png)
- ![Reports](screenshots/reports.png)

---

## Technologies Used

- **Java SE** (Swing)
- **NetBeans IDE** (GUI builder and code editor)
- **MySQL** (database)
- **JDBC** (database connectivity)
- **jBCrypt** (password encryption)
- **Apache POI** (Excel export)
- **Maven** (optional, for dependency management)

---

## Getting Started

### Prerequisites

- Java JDK 8 or above
- NetBeans IDE (recommended)
- MySQL Server
- Maven (optional, for managing dependencies)

### Installation & Setup

1. **Clone the repository**
    ```bash
    git clone https://github.com/Hedayatbakhshi/Supermarket-Project.git
    ```

2. **Open the project in NetBeans**
   - Go to `File > Open Project…` and select the cloned folder.

3. **Set up the database**
   - Create a database named `supermarket` in MySQL.
   - Import the SQL schema provided in the project (`docs/schema.sql` or similar).
   - Example (replace with your actual SQL file):
     ```bash
     mysql -u yourUser -p supermarket < docs/schema.sql
     ```

4. **Configure database credentials**
   - Open `DAL.java` and update the MySQL host, username, and password as needed.

5. **Build and run the project**
   - Press `F6` or click the Run button in NetBeans.
   - The application will launch, starting with the login window.

---

## Usage

1. **Login**
   - Use your username and password or register as a new user.
2. **Customer Management**
   - Add, update, or remove customers.
3. **Inventory Management**
   - Add new products, update details, or search for products.
4. **Sales**
   - Select products, enter quantity, and process sales. Receipts are generated and customer balances updated automatically.
5. **Reports**
   - Choose a report type (purchases, customers, products) and export to Excel or CSV.

---

## Project Structure

```
Supermarket-Project/
├── src/
│   └── supermarket/
│       ├── DAL.java               // Data Access Layer
│       ├── Helper.java            // Utility and helper methods
│       ├── Login.java             // Login window
│       ├── Dashboard.java         // Main dashboard
│       ├── UserAddCustomerInformation.java // Customer registration
│       ├── SupermarketInventorySystem.java // Inventory management
│       ├── Reports.java           // Reporting and export
│       └── ...                    // Other UI and logic classes
├── docs/
│   └── schema.sql                 // SQL schema for the database
├── lib/
│   └── ...                        // Third-party JARs (jBCrypt, Apache POI, etc.)
├── README.md
└── ...
```

---

## Database Schema

> **Tip:** Adjust the schema details below to match your actual implementation.

**Tables:**

- `users`: Stores user info (`user_id`, `username`, `password`, `email`, `gender`, `balance`, etc.)
- `products`: Stores product details (`product_id`, `product_name`, `unit_price`, `unit`, `category`, `product_date`, `expire_date`)
- `purchases`: Records each purchase (`purchase_id`, `user_id`, `product_id`, `quantity`, `total_cost`, `purchase_date`)

**Sample SQL Table:**

```sql
CREATE TABLE users (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(100),
  gender VARCHAR(10),
  balance DOUBLE DEFAULT 0,
  contact_number VARCHAR(20),
  fathername VARCHAR(50)
);

CREATE TABLE products (
  product_id INT PRIMARY KEY AUTO_INCREMENT,
  product_name VARCHAR(100) NOT NULL,
  unit_price DOUBLE NOT NULL,
  unit VARCHAR(10),
  category VARCHAR(50),
  product_date DATE,
  expire_date DATE
);

CREATE TABLE purchases (
  purchase_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  product_id INT,
  quantity INT,
  total_cost DOUBLE,
  purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (product_id) REFERENCES products(product_id)
);
```

---

## Security

- Passwords are stored as **hashed strings** using BCrypt, not plain text.
- All sensitive operations (like password reset, user management) perform validation and error handling.
- SQL injection is prevented by using prepared statements in all database operations.

---

## Contributing

1. **Fork** this repository.
2. **Clone** your fork:
    ```bash
    git clone https://github.com/Hedayatbakhshi/Supermarket-Project.git
    ```
3. **Commit your changes** with clear messages.
4. **Push to your fork** and submit a **pull request**.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

- **Author:** Hedayat Bakhshi
- **GitHub:** [Hedayatbakhshi](https://github.com/Hedayatbakhshi)
- **Issues:** [Submit a bug or feature request](https://github.com/Hedayatbakhshi/Supermarket-Project/issues)

---

**If you find this project useful or inspiring, please star the repository and share your feedback!**
