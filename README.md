QuickKart Hybrid Automation Framework

Hybrid Selenium Framework for Demowebshop/QuickKart
A Modular, Data-Driven Test Automation Framework built with Selenium WebDriver, TestNG, Maven, and the Page Object Model.

🚀 Project Status
✅ Register module (Excel-driven)
🔜 Login module (in progress)
🔜 Add to Cart module (upcoming)
🔜 Checkout & My Orders modules (planned)

🛠️ Tech Stack
Java 11+
Selenium WebDriver
TestNG
Maven
Page Object Model (POM)
Apache POI (Excel Data)
log4j2 (Logging)
ExtentReports (HTML Reports)
WebDriverManager

📂 Project Structure
QuickKart-Hybrid-Framework/
├── pom.xml
├── testng.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   └── BaseClass.java
│   │   │   ├── pages
│   │   │   │   └── RegisterPage.java
│   │   │   └── utilities
│   │   │       ├── ConfigurationReader.java
│   │   │       ├── ExcelUtils.java
│   │   │       └── DataProviderUtils.java
│   │   └── resources
│   │       ├── config.properties
│   │       ├── log4j2.properties
│   │       └── testdata
│   │           └── TestData.xlsx
│   └── test
│       └── java
│           └── testcases
│               └── RegisterTest.java

⚙️ Setup & Execution
Clone the repository:
git clone https://github.com/SammedMd/QuickKart-Hybrid-Framework.git
cd QuickKart-Hybrid-Framework

Configure Properties:
Open src/main/resources/config.properties and update:
browser=chrome
url=https://demowebshop.tricentis.com

Install dependencies & build:
mvn clean compile
Run tests:
Via TestNG XML:
mvn test -DsuiteXmlFile=testng.xml

📊 Reports & Logs
ExtentReports: After execution, open test-output/ExtentReport.html for detailed HTML reports.
Logs: Check console output for log4j2 messages.

🤝 Contributing
Fork the repo
Create a feature branch (git checkout -b feature/LoginModule)
Commit changes (git commit -m "Add Login module")
Push branch (git push origin feature/LoginModule)
Open a Pull Request

📜 License
This project is open-source and available under the MIT License.