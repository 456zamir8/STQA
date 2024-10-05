import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.WebElement;

public class FB_login {
    static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; 

    public static void main(String[] args) {
        // Set the path for the GeckoDriver
        System.setProperty("webdriver.gecko.driver", driverPath);

        // Create a new Firefox profile
        FirefoxProfile fp = new FirefoxProfile();
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(fp);

        // Instantiate the Firefox WebDriver
        WebDriver driver = new FirefoxDriver(options);
        String appUrl = "https://www.facebook.com/";

        // Launch the browser and open the application URL
        driver.get(appUrl);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Declare and initialize the expected title of the webpage
        String expectedTitle = "Facebook – log in or sign up";

        // Fetch the title of the web page
        String actualTitle = driver.getTitle();

        // Compare the expected title of the page with the actual title of the page
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Verification Successful - The correct title is displayed on the web page.");
        } else {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
        }

        // Enter a valid username in the email textbox
        WebElement username = driver.findElement(By.id("email"));
        username.clear();
        username.sendKeys("your_email@example.com"); // Replace with your email

        // Enter a valid password in the password textbox
        WebElement password = driver.findElement(By.id("pass"));
        password.clear();
        password.sendKeys("your_password"); // Replace with your password

        // Click on the Log In button
        WebElement logInButton = driver.findElement(By.name("login")); // Updated to use the name attribute for better stability
        logInButton.click();

        // Optionally, add a wait here to let the page load (consider using WebDriverWait)

        // Close the web browser
        driver.close();
        System.out.println("Test script executed successfully.");

        // Terminate the program
        System.exit(0);
    }
}
