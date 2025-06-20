# Supermarket Management System

This project is a **Java-based Supermarket Management System** with a graphical user interface (GUI) built using Swing and NetBeans GUI Designer. It features modules for managing purchases, customers, products, and generating reports, with secure user
registration and login. The system uses a relational database (such as MariaDB ) for persistent data storage.

---

## Features

### 1. Customer Management
- User registration with secure password hashing (BCrypt)
- Login and authentication
- Add, update, view, and delete customer information
- Gender selection, contact, and email validation

### 2. Product Management
- Add, edit, and view products
- Track product details: name, unit price, category, production and expiry dates, unit

### 3. Purchases Management
- Record purchases, associating customers and products
- Track purchase quantity, total cost, and date

### 4. Reporting
- **View Reports:** Purchases, Customers, and Products
- **Export Reports:** Save displayed table data as Excel (`.xlsx`) or CSV files, with the ability to choose the file location and type via a file dialog

### 5. User Interface
- Modern, user-friendly GUI built with Java Swing
- NetBeans GUI Designer generated code for rapid development
- Visual feedback and dialogs for user actions

### 6. Database Access Layer (DAL)
- Handles all SQL operations through a dedicated class
- Uses prepared statements to prevent SQL injection

---

## Requirements

- **Java JDK 8+**
- **NetBeans IDE** (recommended for GUI editing)
- **Database:** MySQL, SQLite, or compatible JDBC database
- **Libraries:**
  - [jBCrypt](https://www.mindrot.org/projects/jBCrypt/) (for password hashing)
  - [Apache POI](https://poi.apache.org/) (for Excel export)
- Database driver for your chosen DB (e.g., `mysql-connector-java` or `sqlite-jdbc`)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/supermarket.git
```

### 2. Open in NetBeans

- Open NetBeans IDE.
- Choose **File > Open Project** and select the cloned folder.

### 3. Configure the Database

- Edit the `DAL` class to set your database URL, username, and password.
- Run SQL scripts (if provided) to create tables for users, products, and purchases.

### 4. Add Required Libraries

- Download and add `jBCrypt` and `Apache POI` JARs to your project’s libraries.
- If using MySQL or SQLite, add the corresponding JDBC driver.

### 5. Build and Run

- Press `F6` or click the Run button in NetBeans to launch the application.

---

## Usage

- **User Registration:** Register new customers using the registration form.
- **Login:** Access the system with your credentials.
- **Manage Products & Purchases:** Use the GUI to add, edit, or view products and record purchases.
- **Reports:** Select a report type (Purchases, Customers, Products) and export as Excel or CSV using the Save button.

---

## Example Screenshots


> ![image](https://github.com/user-attachments/assets/f715092b-34a0-4e16-a037-37a7869ef62e)

> ![image](https://github.com/user-attachments/assets/ceccff20-47ad-453b-b0c8-3b83a900eae8)

> ![image](https://github.com/user-attachments/assets/e5562f2c-0abc-4691-b9b5-8a764c0cd929)

> ![image](https://github.com/user-attachments/assets/87e504a5-3c73-40ef-bc36-9530fe3299e2)

> ![image](https://github.com/user-attachments/assets/03e5a097-0148-4823-b0e7-dddd3ec4cdd5)

> ![image](https://github.com/user-attachments/assets/819197e5-52c2-4f7f-8e66-88828935c95e)

> ![image](https://github.com/user-attachments/assets/880078e3-d4f5-44cc-986c-144265a98dbb)







---

## Project Structure

- `supermarket/`: Main Java package containing all source files
  - `DAL.java`: Database access layer
  - `Reports.java`: Report generation and export (CSV/Excel)
  - `UserAddCustomerInformation.java`: Customer registration form
  - `CustomerInformation.java`: Customer info management
  - `Login.java`: User login form
  - _...other GUI forms and utility classes..._
- `Images/`: Icons and GIFs used in the GUI

---

## Security

- Passwords are hashed using BCrypt before storage.
- SQL queries use parameterized statements to protect against SQL injection.

---

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## License

[ MIT License

Copyright (c) 2025 Hedayatbakhshi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
]

---
# Supermarket Management System – Database Schema

This project uses a **relational database** (e.g., MySQL or MariaDB) to store information about products, users, and purchases.

## Database Tables

### 1. `products`
| Column        | Type         | Null | Key | Extra          |
|---------------|--------------|------|-----|----------------|
| product_id    | int(11)      | NO   | PRI |                |
| product_name  | text         | YES  |     |                |
| unit_price    | double       | YES  |     |                |
| category      | text         | YES  |     |                |
| product_date  | text         | YES  |     |                |
| expire_date   | text         | YES  |     |                |
| unit          | text         | YES  |     |                |

### 2. `users`
| Column         | Type              | Null | Key | Extra          |
|----------------|-------------------|------|-----|----------------|
| user_id        | int(11)           | NO   | PRI | auto_increment |
| username       | varchar(32)       | YES  | UNI |                |
| password       | varchar(64)       | YES  |     |                |
| email          | varchar(255)      | YES  |     |                |
| gender         | varchar(20)       | YES  |     |                |
| contact_number | varchar(15)       | YES  |     |                |
| fathername     | varchar(100)      | YES  |     |                |
| balance        | decimal(10,2)     | YES  |     | DEFAULT 0.00   |

### 3. `purchases`
| Column        | Type           | Null | Key | Extra           |
|---------------|----------------|------|-----|-----------------|
| id            | int(11)        | NO   | PRI | auto_increment  |
| user_id       | int(11)        | NO   | MUL |                 |
| product_id    | int(11)        | NO   | MUL |                 |
| quantity      | int(11)        | NO   |     |                 |
| total_cost    | decimal(10,2)  | NO   |     |                 |
| purchase_date | datetime       | NO   |     | DEFAULT CURRENT_TIMESTAMP |

---

## SQL Table Creation

```sql
CREATE TABLE products (
  product_id   INT(11) PRIMARY KEY,
  product_name TEXT,
  unit_price   DOUBLE,
  category     TEXT,
  product_date TEXT,
  expire_date  TEXT,
  unit         TEXT
);

CREATE TABLE users (
  user_id        INT(11) PRIMARY KEY AUTO_INCREMENT,
  username       VARCHAR(32) UNIQUE,
  password       VARCHAR(64),
  email          VARCHAR(255),
  gender         VARCHAR(20),
  contact_number VARCHAR(15),
  fathername     VARCHAR(100),
  balance        DECIMAL(10,2) DEFAULT 0.00
);

CREATE TABLE purchases (
  id            INT(11) PRIMARY KEY AUTO_INCREMENT,
  user_id       INT(11) NOT NULL,
  product_id    INT(11) NOT NULL,
  quantity      INT(11) NOT NULL,
  total_cost    DECIMAL(10,2) NOT NULL,
  purchase_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(user_id),
  FOREIGN KEY (product_id) REFERENCES products(product_id)
);
```

---
## CSV File
https://github.com/Hedayatbakhshi/Supermarket-Project/blob/master/products.csv

---

## Notes

- **Password Storage:** Passwords are stored as BCrypt hashes.
- **Data Types:** Adapt column types if you use another database (e.g., SQLite).
- **Relationships:** Purchases reference both users and products via foreign keys.

---

## Initial Setup

1. Copy the above SQL and run it in your database (MySQL/MariaDB/etc.).
2. Update your Java `DAL` class to point to your database (JDBC URL, username, password).
3. Add some sample data if you wish to test the GUI.

---

## Backup and Restore

- To backup:  
  `mysqldump -u [user] -p [database] > backup.sql`
- To restore:  
  `mysql -u [user] -p [database] < backup.sql`

---

For more details, see the main [README.md](./README.md).




## Acknowledgements

- [jBCrypt](https://www.mindrot.org/projects/jBCrypt/)
- [Apache POI](https://poi.apache.org/)
- NetBeans IDE

---

## Contact

For questions or support, please send e-mail if you interested to my project to hedayatbakhshi001@gmail.com .
Also I know some of things are not available but Inshallah I try myself to do my best :)
