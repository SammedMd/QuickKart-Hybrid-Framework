# QuickKart - Hybrid Automation Framework

This is a hybrid Selenium automation framework for testing the **Demo Web Shop (QuickKart)** website.

---

## 🚀 Features

- Selenium WebDriver with Java
- TestNG for test execution
- Page Object Model (POM) Design Pattern
- Excel-based Data-Driven Testing (Apache POI)
- Log4j for logging
- Extent Reports for rich HTML reports
- Screenshots for selected failures only
- Cross-browser Testing (Chrome, Firefox)
- Parallel execution using TestNG & ThreadLocal WebDriver

---

## 📂 Project Structure

src
└── test
└── java
├── base # BaseClass (browser setup/teardown)
├── pages # Page classes (LoginPage, RegisterPage, etc.)
├── testcases # Test classes (LoginTest, RegisterTest, etc.)
├── utilities # ExcelUtils, ScreenshotUtility, ExtentListener, etc.
└── testdata # Excel files for test data

---

## 🧪 Test Execution

### ✅ Run All Tests in Chrome & Firefox (Parallel)

> Right-click on `testng.xml` → Run As → **TestNG Suite**

This will:
- Launch both Chrome and Firefox
- Run tests in the order: Register → Login → Home → AddToCart
- Generate separate reports per browser

### ▶️ To Run a Specific Test Class

- Open `testng.xml`
- Add/remove the `<class name="..."/>` tags under the test section
- Run the suite again

---

## 📸 Screenshots

- Screenshots are captured **only when explicitly marked** in your code using a custom `CAPTURE_SCREENSHOT` flag
- They are saved in the `/screenshots/` folder
- Helpful for debugging **specific functional bugs only** (not for code errors)

---

## 📑 Reporting

- ExtentReports HTML reports are auto-generated under the `/extent-reports/` folder
- Separate report per browser (example below):

Report_chrome_20250805_213010.html
Report_firefox_20250805_213011.html


- Each report includes:
- Test pass/fail status
- Logs
- Screenshot (if any) for failed test steps

---

## 🔧 Technologies Used

- Java 17+
- Selenium WebDriver
- TestNG
- Apache POI
- Log4j
- ExtentReports
- Maven

---

## 👤 Author

**Sammed Mudeppagol**  
QA Automation Engineer  
📧 mdsammed07@gmail.com  
🔗 [LinkedIn Profile](https://www.linkedin.com/in/sammed-mudeppagoll/)

---

## ⚠️ Note

> This project is actively being developed.  
> Modules like **Checkout**, **My Orders**, and advanced **Reporting** will be added soon.