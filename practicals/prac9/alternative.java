package p9;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class ComboBox {
    static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe";

    public static void main(String[] args) {
        // Set the path for the GeckoDriver
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Create FirefoxOptions instance
        FirefoxOptions options = new FirefoxOptions();

        // Instantiate the Firefox WebDriver
        WebDriver driver = new FirefoxDriver(options);
        
        // Define the application URL
        String appUrl = "https://www.toolsqa.com/automation-practice-form/";
        // Open the application URL in the browser
        driver.get(appUrl);

        // Locate the dropdown element using its ID
        Select dropdown = new Select(driver.findElement(By.id("continents")));

        // Get all options in the dropdown
        List<WebElement> optionsList = dropdown.getOptions();
        int totalOptions = optionsList.size();

        // Print each option's text and the total number of options
        System.out.println("Dropdown Options:");
        for (WebElement option : optionsList) {
            System.out.println(option.getText());
        }
        System.out.println("Total No. of Items in Dropdown: " + totalOptions);

        // Close the browser
        driver.quit();
    }
}
