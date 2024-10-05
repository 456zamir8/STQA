// AIM: Write and test a program to get the number of items in a list/combo box.

/*Creating the script in JAVA: 
(NOTE that this script will be run by Eclipse IDE) 
(In simple words, it’s like we are  
-ordering Eclipse to run a script or to do a job  
-of opening the browser, visiting the URL 
-and finding the WebElement By “ID” with the help of “Select” class and Selenium Drivers 
-and to show the result. 
-Hence automating the work in browser) 

• Now we’ll put the path of our LOCAL FILE(combobox.html) in a string 
• Also put the path of “geckodriver” in a String driverPath */ 

package p9; 
 
import java.util.List; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.firefox.*; 
import org.openqa.selenium.firefox.FirefoxOptions; 
import org.openqa.selenium.firefox.FirefoxProfile; 
import org.openqa.selenium.firefox.internal.ProfilesIni; 
import org.openqa.selenium.support.ui.Select; 
 
public class ComboBox { 
    static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; 
    public static void main(String[] args) {   
        System.setProperty("webdriver.gecko.driver",driverPath); 
        //NOTE THAT: following commented lines are required for old machines 
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
        //capabilities.setCapability("marionette",true); 
        //ProfilesIni allProfiles = new ProfilesIni(); 
        //FirefoxProfile fp = new FirefoxProfile(); 
        //fp.setPreference(FirefoxProfile.PORT_PREFERENCE,"7055"); 
        //FirefoxOptions options = new FirefoxOptions(); 
        //options.setProfile(fp); 
        WebDriver driver = new FirefoxDriver(); 
        String appUrl ="https://www.toolsqa.com/automation-practice-form/"; 
        //DYNAMIC URL(WEBSITE) 
        //String appUrl = " file:///D:/Usman/College/503%20pracs/combobox.html"; //STATIC URL(LOCAL FILE) 
        driver.get(appUrl); 
   
        Select oSelect = new Select(driver.findElement(By.id("continents"))); 
        //Select oSelect = new 
        Select(driver.findElement(By.tagName("select"))); //this works too 
   
        List<WebElement> oSize = oSelect.getOptions(); 
        int iListSize = oSize.size(); 
   
        for(int i = 0; i < iListSize; i++) 
        { 
            // Storing the value of the option  
            String sValue = oSelect.getOptions().get(i).getText(); 
            // Printing the stored value 
            System.out.println(sValue);    
        } 
        System.out.println("Total No. Items in Dropdown: "+iListSize); 
        //driver.quit();  
    } 
} 