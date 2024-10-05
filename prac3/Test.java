package gcdpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Test {
    static String driverPath = "path_to_geckodriver"; // put the path of GeckoDriver here

    public static void main(String[] args) {
        // Set system property for GeckoDriver
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Initialize Firefox Profile and Options
        FirefoxProfile fp = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(fp);

        // Initialize WebDriver with Firefox and Options
        WebDriver driver = new FirefoxDriver(options);

        // Navigate to the page where GCD form is present
        driver.get("http://example.com"); // replace with the actual URL

        // Maximize browser window
        driver.manage().window().maximize();

        // Fill the form with values for GCD calculation
        driver.findElement(By.name("n1")).sendKeys("36");
        driver.findElement(By.name("n2")).sendKeys("6");

        // Click the button to calculate GCD
        driver.findElement(By.name("btn")).click();

        // Get the result of the GCD calculation
        String result = driver.findElement(By.name("result")).getAttribute("value");

        // Print the result in the console
        System.out.println("GCD = " + result);

        // Close the browser
        driver.quit();
    }
}
