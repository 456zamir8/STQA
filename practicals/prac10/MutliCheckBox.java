/*Creating the script in JAVA: 
(NOTE that this script will be run by Eclipse IDE) 
(In simple words, it’s like we are  
-ordering Eclipse to run a script or to do a job  
-of opening the browser, visiting the URL 
-and finding the WebElement By “xpath” with the help of Selenium Drivers 
-and to show the result. 
-Hence automating the work in browser) 

• Now we’ll put the path of our LOCAL FILE(multicheckbox.html) in a string 
• Also put the path of “geckodriver” in a String driverPath */



package p10; 

import java.util.List; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.firefox.*; 
import org.openqa.selenium.firefox.FirefoxOptions; 
import org.openqa.selenium.firefox.FirefoxProfile; 
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class MultiCheckBox { 
    static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; 
    public static void main(String[] args) { 
        System.setProperty("webdriver.gecko.driver",driverPath); 
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
        //capabilities.setCapability("marionette",true); 
        //ProfilesIni allProfiles = new ProfilesIni(); 
        //FirefoxProfile fp = new FirefoxProfile(); 
        //fp.setPreference(FirefoxProfile.PORT_PREFERENCE,"7055"); 
        //FirefoxOptions options = new FirefoxOptions(); 
        //options.setProfile(fp); 
        WebDriver driver = new FirefoxDriver(); 
        String appUrl = "https://www.toolsqa.com/automation-practice-form/"; 
        //DYNAMIC URL(WEBSITE) 
        //String appUrl = "file:///D:/Usman/College/503%20pracs/multicheckbox.html"; //STATIC URL(LOCAL FILE) 
        driver.get(appUrl); 
         
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); 
        
        int checkedCount = 0, 
        int uncheckedCount = 0; 
        for(int i=0; i<checkBoxes.size(); i++){ 
            System.out.println(i + " checkbox is selected " + checkBoxes.get(i).isSelected()); 
            if(checkBoxes.get(i).isSelected()) 
            {
                checkedCount++;
            } 
            else 
            {
                uncheckedCount++;
            } 
        } 
        //driver.quit(); 
        System.out.println("No. of selected checkbox: " + checkedCount); 
        System.out.println("No. of unselected checkbox: " + uncheckedCount); 
    } 
}