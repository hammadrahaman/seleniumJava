package custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import test.java.LaunchBrowser;
import java.time.Duration;

public class Commands {
    protected static WebDriver driver ;
    SoftAssert check = new SoftAssert();

    public Commands(WebDriver driver) {
        Commands.driver = LaunchBrowser.getDriver();  // this initialization was the issue built a constructor.
    }



    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static void setText(By locator, String text){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(text);
    }

    public static void waitClick(By locator){

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator), ExpectedConditions.presenceOfElementLocated(locator)));
        getElement(locator).click();
    }

    public boolean assertElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator), ExpectedConditions.presenceOfElementLocated(locator)));
        WebElement element = getElement(locator);
        check.assertTrue(element.isDisplayed(), "The button is not visible");
        check.assertAll();
        return true;
    }


}
