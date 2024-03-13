package custom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.LaunchBrowser;
import java.time.Duration;
import static custom.Commands.getElement;

//Assert.assertEquals(actualText, expectedText, "Verification message mismatch");
public class Assertion {

    protected static WebDriver driver ;

    public Assertion(){
        this.driver = LaunchBrowser.getDriver();
    }

    public  void verificationeMessage(By locator, String expectedText, String errorMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.and(ExpectedConditions.presenceOfElementLocated(locator), ExpectedConditions.presenceOfElementLocated(locator)));
        String actualText = getElement(locator).getText();
        if (!actualText.equals(expectedText)) {
            throw new AssertionError(errorMessage + "\nExpected: " + expectedText + "\nActual: " + actualText);
        }

    }
}
