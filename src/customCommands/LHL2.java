import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.ElementClickInterceptedException;

import java.time.Duration;

public class LHL2 {

    public static void main(String[] args) throws InterruptedException {

        String dest = "//p[@aria-label='Shipment Destinations']";
        String total = "div[aria-label='Total tonnage for this destination.']";
        String priority = "p[aria-label='Number of Priority Shipments: 1']";
        String upstream = "p[aria-label=\"Freight that is expected to arrive during this time window but has not yet departed an upstream facility.\"]";
        String booked = "p[aria-label=\"Freight that is not yet picked up. (Pre-Pickup)\"]";
        String enroute = "p[aria-label=\"Freight that is on its way to this terminal on a linehaul move.\"]";
        String term = "p[aria-label=\"Freight that is at the terminal, either in the yard or on the dock.\"]";
        String loaded = "p[aria-label=\"Freight that has already been loaded to its next destination.\"]";
        String downArrow = "div[data-id=\"ShipmentByDestination-GBO-P-GBO\"] svg[data-testid=\"ExpandMoreIcon\"] path[d=\"M16.59 8.59 12 13.17 7.41 8.59 6 10l6 6 6-6z\"]";

        // Set the path to the ChromeDriver executable


        WebDriver driver = new ChromeDriver();
        driver.get("https://saia-qa.livehaul.io/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='username']")));
        usernameField.sendKeys("hammad.rahaman@optym.com");

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='password']")));
        passwordField.sendKeys("Hunt@1310");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='kc-form-login']//input[@name='login']")));
        loginButton.click();

        driver.manage().window().maximize();
        Thread.sleep(5000);
       WebElement gbo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@role='cell'])[5]")));
        gbo.isDisplayed();
        gbo.click();

        // Interact with each element
        WebElement destElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(dest)));
        destElement.isDisplayed();

        WebElement totalElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(total)));
        totalElement.isDisplayed();

        WebElement priorityElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(priority)));
        priorityElement.isDisplayed();

        WebElement upstreamElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(upstream)));
        upstreamElement.isDisplayed();

        WebElement bookedElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(booked)));
        bookedElement.isDisplayed();

        WebElement enrouteElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(enroute)));
        enrouteElement.isDisplayed();

        WebElement termElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(term)));
        termElement.isDisplayed();

        WebElement loadedElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loaded)));
        loadedElement.isDisplayed();

       WebElement downArrowElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(downArrow)));
        downArrowElement.click();
        // Perform any other actions or assertions needed

        // Example of using SoftAssert
        SoftAssert softAssert = new SoftAssert();
        // Add assertions here
        // Example: softAssert.assertTrue(condition, "Assertion message");

        // Finalize assertions
        softAssert.assertAll();

        // Close the driver
        driver.quit();
    }
}
