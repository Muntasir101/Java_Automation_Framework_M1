package rough;
import utils.PropertyReader;

public class DemoProperties {
    public static void main(String[] args) {
        PropertyReader propertyReader = new PropertyReader("src/main/java/config/baseConfig.properties");

        // Read properties
        String baseUrl = propertyReader.getProperty("baseUrl");
        int implicitWaitTimeout = Integer.parseInt(propertyReader.getProperty("implicit.wait.timeout"));
        int explicitWaitTimeout = Integer.parseInt(propertyReader.getProperty("explicit.wait.timeout"));
        int pageLoadTimeout = Integer.parseInt(propertyReader.getProperty("page.load.timeout"));

        // Use the properties
        System.out.println("Base URL: " + baseUrl);
        System.out.println("Implicit Wait Timeout: " + implicitWaitTimeout);
        System.out.println("Explicit Wait Timeout: " + explicitWaitTimeout);
        System.out.println("Page Load Timeout: " + pageLoadTimeout);
    }
}

/*
output:
Base URL: https://example.com
Implicit Wait Timeout: 10
Explicit Wait Timeout: 20
Page Load Timeout: 30
 */
