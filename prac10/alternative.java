package p10;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MultiCheckBox {
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

        // Locate all checkboxes on the page
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        int checkedCount = 0;
        int uncheckedCount = 0;

        // Iterate through the checkboxes and count checked and unchecked
        for (int i = 0; i < checkBoxes.size(); i++) {
            boolean isSelected = checkBoxes.get(i).isSelected();
            System.out.println(i + " checkbox is selected: " + isSelected);

            if (isSelected) {
                checkedCount++;
            } else {
                uncheckedCount++;
            }
        }

        // Print the results
        System.out.println("Number of selected checkboxes: " + checkedCount);
        System.out.println("Number of unselected checkboxes: " + uncheckedCount);

        // Close the browser
        driver.quit();
    }
}
