package test.java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class LaunchBrowser {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if(driver!=null){
            System.out.println("The driver driver runs");
        } else {
            System.out.println("The driver down");
        }
        return driver;
    }

    public  static void setDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions down = new FirefoxOptions();
        down.addArguments("--headless");
         driver = new FirefoxDriver(down);
    }


}


