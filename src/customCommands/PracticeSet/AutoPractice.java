package PracticeSet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoPractice {

    public  WebDriver driver;

    WebDriverWait wait;
    @FindBy(xpath = "//*[text()=\"Alerts, Frame & Windows\"]")
    WebElement tab;
    public void initializePageFactory() {
        PageFactory.initElements(driver, this);
    }

    public static void main(String[] args) {

        AutoPractice d = new AutoPractice();
        d.wait = new WebDriverWait(d.driver, Duration.ofSeconds(10));
     WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--incognito");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
         d.driver = new ChromeDriver(options);
         d.initializePageFactory();
         WebDriver driver = d.driver;
        d.driver.get("https://demoqa.com/");
        System.out.println(driver.getCurrentUrl());
        d.tab.click();
        driver.findElement(By.xpath("//*[@id=\"item-0\"]//*[text()=\"Browser Windows\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"tabButton\"]")).click();



    }
}
