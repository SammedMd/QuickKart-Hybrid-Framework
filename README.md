# QuickKart Hybrid Automation Framework 🚀

This is a Hybrid Test Automation Framework built using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and **Apache POI**.  
The project is based on the demo e-commerce application **DemoWebShop** and will be enhanced module-by-module.

---

## ✅ Completed Modules

- [x] **Register Module** — Dynamic data-driven registration using Excel
- [ ] **Login Module** — (Coming Next)
- [ ] **Add to Cart**
- [ ] **Checkout**
- [ ] **My Orders**
- [ ] **Reports, Logs & Screenshots**

---

## 🔧 Technologies & Tools Used

- Java
- Selenium WebDriver
- TestNG
- Apache POI (for Excel data)
- Maven
- Log4j (logging)
- Extent Reports (coming soon)
- Git & GitHub

---

## 🧱 Framework Structure

```
src/
├── test/java/
│   ├── base/             # Base setup and teardown
│   ├── pages/            # Page Object Model classes
│   ├── testcases/        # All TestNG test classes
│   ├── utilities/        # ExcelUtils, DataProvider, ConfigReader
│
├── main/resources/
│   ├── testdata/         # Testdata Excel files
│   └── config.properties # App configurations
│
└── testng.xml            # TestNG Suite File
```

## 🧪 How to Run the Tests
1. Clone the repo  
2. Open in Eclipse/VS Code  
3. Update `config.properties` with browser + URL  
4. Right-click on `testng.xml` → Run As → TestNG Suite

---

## 📌 Author
- **Sammed Mudeppagol**  
  QA Automation Engineer | [LinkedIn](https://www.linkedin.com/in/sammedmd/)  
  📧 Email: mdsammed07@gmail.com  

---

## 📌 Note
> This is an ongoing project. More modules like login, cart, checkout, and reports will be added daily. Stay tuned!
