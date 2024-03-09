# Selenium Test Framework

This project is a Selenium-based test automation framework for web applications. It includes setup for WebDriver initialization, page object model (POM) structure, data-driven testing, screenshot capture on test failure, and Allure reporting integration.

## Project Structure


## Features

- **Page Object Model (POM)**: Organize web pages into page classes for better maintainability and readability.
- **Data-Driven Testing**: Use external data sources (e.g., CSV files) to parameterize tests.
- **Screenshot Capture**: Capture screenshots automatically on test failure for debugging purposes.
- **Allure Reporting**: Integrate Allure reporting for generating interactive and informative test reports.
- **TestNG Integration**: Use TestNG for test execution and configuration through the testng.xml file.
- **WebDriver Setup**: Initialize WebDriver for different browsers (Chrome, Firefox, etc.) before test execution.

## Usage

1. Clone the repository:

git clone https://github.com/muntasir101/selenium-test-framework.git

2. Install dependencies using Maven:

cd selenium-test-framework
mvn clean install


3. Run tests using TestNG:

mvn test


4. View Allure reports:

allure serve target/allure-results

5. Customize tests, page objects, and configurations according to your application requirements.

## Dependencies

- Selenium WebDriver
- TestNG
- Allure TestNG
- Apache Commons IO

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
