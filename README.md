# QuickKart Hybrid Automation Framework 🚀

A **Hybrid Test Automation Framework** built with **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and **Apache POI**, automating workflows on the **Demo Web Shop** site with cross-browser support and modular architecture.

---

## ✅ Completed Modules

- [x] **Register Module** – Data-driven registration using Excel and unique email generation
- [x] **Login Module** – Validates multiple login scenarios (valid, invalid, blank, invalid format)
- [x] **Add to Cart** – Product search + add-to-cart with success message validation
- [ ] **Checkout**
- [ ] **My Orders**
- [ ] **Reports, Logs & Screenshots**

---

## 🌐 Cross-Browser Testing Support

Supports parallel execution on:

- ✅ Chrome  
- ✅ Firefox  
- ✅ Edge  

Configured via **TestNG suite** (`testng.xml`).

---

## 🔧 Technologies & Tools Used

- Java  
- Selenium WebDriver  
- TestNG  
- Apache POI (Excel)  
- Log4j2 (real-time logging)  
- Extent Reports (HTML reports – will be added)  
- Maven  
- Git & GitHub

---

## 🧱 Framework Structure

src/
├── test/java/
│ ├── base/ # BaseClass for WebDriver setup & teardown
│ ├── pages/ # Page classes (LoginPage, RegisterPage, etc.)
│ ├── testcases/ # TestNG test classes (LoginTest, RegisterTest, etc.)
│ ├── utilities/ # ExcelUtils, ConfigReader, etc.
│
├── main/resources/
│ ├── testdata/ # Excel files for test data
│ ├── config.properties
│ └── log4j2.xml
│
├── Logs/ # Log4j-generated logs (kept visible for HR review)
├── testng.xml # Parallel execution config

---

## 🧪 How to Run the Tests

1. Clone the repository  
2. Open in **Eclipse** or **VS Code**  
3. Run `mvn clean install` to download dependencies  
4. Update `config.properties` and Excel data if needed  
5. Right-click `testng.xml` > **Run as TestNG Suite**

---

## 🧠 Scenario Coverage

### 🔐 Login Scenarios:
- ✅ Valid Registered User Login  
- 🚫 Unregistered Email  
- ❌ Blank Username  
- ❌ Blank Password  
- ❗ Invalid Email Format  

---

## 📂 Logs

- ✅ Logs are stored in the `Logs/` directory  
- ✅ Uses **log4j2** for capturing test execution info  
- ✅ Includes browser, thread ID, page navigation, test results

---

## 👤 Author

**Sammed Mudeppagol**  
QA Automation Engineer 
📧 mdsammed07@gmail.com  
🔗 [LinkedIn Profile](https://www.linkedin.com/in/sammed-mudeppagoll/)

---

## ⚠️ Note

> This project is actively being developed.  
> Modules like **Checkout**, **My Orders**, and **Reporting** will be added s