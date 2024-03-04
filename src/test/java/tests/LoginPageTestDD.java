package tests;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import com.opencsv.CSVReader;
import utils.PropertyReader;

import java.io.FileReader;
import java.io.IOException;

public class LoginPageTestDD extends BaseTest{
    private static final Logger logger = LogManager.getLogger(LoginPageTestDD.class);
    private LoginPage loginPage;
    @Test(dataProvider = "userDataProvider")
    public void testLogin(String email, String password) {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");
        // Read properties
        String baseUrl = propertyReader.getProperty("baseUrl");
        // Initialize LoginPage
        driver.get(baseUrl+ "?route=account/login");
        logger.info("Login page open successfully");


        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.enterEmailAddress(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @DataProvider(name = "userDataProvider")
    public Object[][] userDataProvider() throws IOException, CsvException {
        // Path to the CSV file
        String csvFile = "src/main/java/data/users.csv";

        // Read data from CSV file
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            // Get all rows from the CSV file
            return reader.readAll().stream().skip(1) // Skip header row
                    .map(row -> new String[]{row[0], row[1]}) // Map each row to an array
                    .toArray(Object[][]::new); // Convert to 2D array
        }
    }
}
