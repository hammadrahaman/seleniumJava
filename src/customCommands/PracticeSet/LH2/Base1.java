package PracticeSet.LH2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static PracticeSet.LH.waits.wait4s;

public class Base1 {

    public static WebDriver driver;
    WebDriverWait wait;

    public WebDriver initializeDriver(){
        System.setProperty("webdriver.chrome.driver",
                (System.getProperty("user.dir") + "//src//test//java//driverplan//chromedriver"));
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.addArguments("--incognito");
       options.addArguments("--headless");
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
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='username']")));
        usernameField.sendKeys("hammad.rahaman@optym.com");
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='password']")));
        passwordField.sendKeys("Hunt@1310");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='kc-form-login']//input[@name='login']")));
        loginButton.click();
        wait4s();
        return driver;
}

}
