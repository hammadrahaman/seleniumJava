package PracticeSet.LH;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static PracticeSet.LH.waits.wait1s;
import static PracticeSet.LH.waits.wait4s;
import static PracticeSet.LH3.waits.wait2s;

public class Base {

    public static WebDriver driver;
    WebDriverWait wait;

    public WebDriver initializeDriver(){
        System.setProperty("webdriver.chrome.driver",
                (System.getProperty("user.dir") + "//src//test//java//driverplan//chromedriver"));
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("--incognito");
      //  options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        options.addArguments("--disable-extensions");
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait=  new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://saia-qa.livehaul.io/");
        //  //*[text()='Optym Team Login']

        WebElement optymLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Optym Team Login']")));
        optymLogin.click();
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-report-value='Email_Phone_Skype_Entry']")));
        usernameField.sendKeys("haul.lh.automation@optym.com");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='password']")));
       // passwordField.sendKeys(Keys.COMMAND, "a", Keys.BACK_SPACE);

        passwordField.sendKeys("gjpqWEBvDJ2sq#M6");
        wait1s();
        wait2s();
        WebElement signIn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='submit']")));

        signIn.click();

        wait4s();
        return driver;
}

}
