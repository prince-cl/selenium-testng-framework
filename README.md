# Selenium TestNG Automation Framework

A Maven-based Selenium automation framework built using **Java + TestNG**, following **Page Object Model (POM)** design.

---

## 🧰 Tech Stack
- Java 23
- Selenium 4
- TestNG
- Maven
- WebDriverManager
- Extent Reports
- Apache POI (Excel)
- Git & GitHub

---

## 📁 Project Structure

selenium-testng-framework  
├── src/test/java  
│   ├── base        → BaseTest (setup & teardown)  
│   ├── pages       → Page Object classes  
│   ├── tests       → Test classes  
│   ├── utils       → DriverFactory, WaitUtil, ExcelReader  
│   ├── listeners   → TestNG listeners  
│   ├── retry       → Retry logic  
│   └── reporting   → Extent report management  
│  
├── src/test/resources  
│   ├── config.properties  
│   └── TestData.xlsx  
│  
├── reports         → Extent HTML reports  
├── pom.xml  
├── testng.xml  
└── README.md  

---

## ▶️ How to Run Tests

### Run via Maven
