package p8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class FindAllLinks {
    static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe";

    public static void main(String[] args) {
        // Set the path for the GeckoDriver
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Create FirefoxOptions instance
        FirefoxOptions options = new FirefoxOptions();
        // Instantiate the Firefox WebDriver
        WebDriver driver = new FirefoxDriver(options);

        // Set the application URL
        String appUrl = "https://www.google.co.in/";
        // Launch the browser and open the application URL
        driver.get(appUrl);

        // Find all <a> tag elements
        List<WebElement> links = driver.findElements(By.tagName("a"));

        // Print all link texts and the total count of links
        System.out.println("Total No. of Links: " + links.size());
        for (int i = 0; i < links.size(); i++) {
            String linkText = links.get(i).getText();
            if (!linkText.isEmpty()) { // Check if link text is not empty
                System.out.println((i + 1) + ": " + linkText);
            }
        }

        // Close the browser
        driver.quit();
    }
}
