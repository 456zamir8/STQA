//AIM: Write and test a program for logging in facebook webpage. 

/* Creating the script in JAVA: 
(NOTE that this script will be run by Eclipse IDE) 
(In simple words, it’s like we are  
-ordering Eclipse to run a script or to do a job  
-of opening the browser, visiting the URL 
-and putting credentials in textboxes and clicking button with the help of Selenium Drivers
-and to show the result. 
-Hence automating the work in browser for logging in) */

// put the path of “geckodriver” in a String driverPath 
// put the ID’s in the .id() method respectively. 

public class FB_login { 
    static String driverPath = "C:\\Users\\Usman\\503\\geckodriver.exe"; // put the path of “geckodriver” in a String driverPath
    public static void main(String[] args) { 
        System.setProperty("webdriver.gecko.driver", driverPath); 
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
        //capabilities.setCapability("marionette",true); 
        ProfilesIni allProfiles = new ProfilesIni(); 
        FirefoxProfile fp = new FirefoxProfile(); 
        fp.setPreference(FirefoxProfile.PORT_PREFERENCE,"7055"); 
        FirefoxOptions options = new FirefoxOptions(); 
        options.setProfile(fp); 
           
        //objects and variables instantiation 
        WebDriver driver = new FirefoxDriver(options); 
        String appUrl = "https://www.facebook.com/"; 
           
        //launch the firefox browser and open the application url 
        driver.get(appUrl); 
           
        //maximize the browser window 
        driver.manage().window().maximize(); 
           
        //declare and initialize the variable to store the expected title of the webpage. 
        String expectedTitle = "Facebook - log in or sign up"; 
           
        //fetch the title of the web page and save it into a string variable 
        String actualTitle = driver.getTitle(); 
           
        //compare the expected title of the page with the actual title of the page and print the result 
        if (expectedTitle.equals(actualTitle)) { 
            System.out.println("Verification Successful - The correct title is displayed on the web page."); 
        } 

        else { 
         System.out.println("Verification Failed - An incorrect title is displayed on the web page."); 
        } 
 
        //enter a valid username in the email textbox 
        WebElement username = driver.findElement(By.id("email")); 
        username.clear(); 
        username.sendKeys("your email id");  
           
        //enter a valid password in the password textbox 
        WebElement password = driver.findElement(By.id("pass")); 
        password.clear(); 
        password.sendKeys("your password"); 
         
        password.sendKeys(Keys.ENTER); 
         
        //click on the Sign in button 
        WebElement LogInButton = driver.findElement(By.id("u_0_2")); 
        LogInButton.click(); 
           
        //close the web browser 
        driver.close(); 
        System.out.println("Test script executed successfully."); 
           
        //terminate the program 
        System.exit(0); 
    } 
} 
