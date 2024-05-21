package test.java;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        WebDriverManager.chromedriver().setup();
        ChromeOptions down = new ChromeOptions();
        //down.addArguments("--headless");
         driver = new ChromeDriver(down);
    }


}


