package custom.com.dp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import custom.sleep;
import test.java.LaunchBrowser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import maj.utility;
public class check {
    public static WebDriver driver;

    public static void login(){
        check.driver = LaunchBrowser.getDriver();
        driver.manage().window().maximize();
        driver.get("https://sefl-qa.driverplan.io/");
        driver.findElement(By.cssSelector("#username")).sendKeys("dev");
        driver.findElement(By.cssSelector("#password")).sendKeys("Haul@123");
        driver.findElement(By.cssSelector("#kc-login")).click();
        sleep.mediumWait();
    }
}
