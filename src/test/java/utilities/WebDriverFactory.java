package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//	- Write a static method in WebDriverFactory class
//	- Return type is WebDriver
//	- method name getDriver
//	- it accepts one String argument, and returns the browser according to what string is passed
//	- if "chrome" --> returns chrome browser
//	- if "firefox" --> returns firefox browser

public class WebDriverFactory {

    public static WebDriver getDriver (String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            //WebDriver driver = new ChromeDriver();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Given browser type does not exist. Driver = null!");
            return null;
        }
    }
}

