package PracticeSet.LH;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LH3 {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to your ChromeDriver

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saia-qa.livehaul.io/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='username']")));
        usernameField.sendKeys("hammad.rahaman@optym.com");

        // Wait for the password field to be present
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='password']")));
        passwordField.sendKeys("Hunt@1310");
        Thread.sleep(3000);
        // Wait for the login button to be clickable and click it
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='kc-form-login']//input[@name='login']")));
        loginButton.click();
        Thread.sleep(3000);
        // Open the desired URL
        Thread.sleep(3000);Thread.sleep(3000);
        // All Shipments drop-down
        WebElement allShipmentsDropdown = driver.findElement(By.cssSelector("div[aria-labelledby=\"shipments-by-select-label shipments-by-select\"]"));
        Assert.assertTrue(allShipmentsDropdown.isDisplayed());
        allShipmentsDropdown.click();

        // Dropdown value
        WebElement dropdownValue = driver.findElement(By.xpath("//li[@data-value=\"AllShipments\"]"));
        Assert.assertTrue(dropdownValue.isDisplayed());
        Thread.sleep(3000);
        dropdownValue.click();

        // Shipment columns
        WebElement shipment = driver.findElement(By.xpath("//p[@aria-label=\"Unique identifier for shipment.\"]"));
        Assert.assertTrue(shipment.isDisplayed());

        WebElement destination = driver.findElement(By.xpath("//p[@aria-label=\"Destination terminal of the shipment.\"]"));
        Assert.assertTrue(destination.isDisplayed());

        WebElement props = driver.findElement(By.xpath("//p[@aria-label=\"Special Properties\"]"));
        Assert.assertTrue(props.isDisplayed());

        WebElement origin = driver.findElement(By.xpath("//p[@aria-label=\"Origin terminal of the shipment.\"]"));
        Assert.assertTrue(origin.isDisplayed());

        WebElement weight = driver.findElement(By.xpath("//p[@aria-label=\"Weight (in lbs) of the shipment.\"]"));
        Assert.assertTrue(weight.isDisplayed());

        // Using CSS selectors for the remaining elements
        WebElement cube = driver.findElement(By.cssSelector("p[aria-label=\"Volume (in cubic feet) of the shipment\"]"));
        Assert.assertTrue(cube.isDisplayed());

        WebElement handUnits = driver.findElement(By.cssSelector("p[aria-label=\"Number of pallets the shipment contains.\"]"));
        Assert.assertTrue(handUnits.isDisplayed());

        WebElement status = driver.findElement(By.cssSelector("p[aria-label=\"Describes current state of the shipment.\"]"));
        Assert.assertTrue(status.isDisplayed());

        WebElement eta = driver.findElement(By.cssSelector("p[aria-label=\"Expected time of arrival of the shipment at the terminal being viewed.\"]"));
        Assert.assertTrue(eta.isDisplayed());

        // Additional shipment details
        WebElement locations = driver.findElement(By.xpath("//p[@aria-label=\"Current location of the shipment\"]"));
        Assert.assertTrue(locations.isDisplayed());

        WebElement cutTimes = driver.findElement(By.xpath("//p[@aria-label=\"Latest time a shipment can leave the terminal and still make service.\"]"));
        Assert.assertTrue(cutTimes.isDisplayed());

        WebElement shipper = driver.findElement(By.xpath("//p[@aria-label=\"Shipper\"]"));
        Assert.assertTrue(shipper.isDisplayed());

        WebElement defLanes = driver.findElement(By.cssSelector("p[aria-label=\"Default Lane of the Shipment.\"]"));
        Assert.assertTrue(defLanes.isDisplayed());

        // Page Line Up
        WebElement lineup = driver.findElement(By.xpath("//a[@aria-label=\"Lineup\"]"));
        Assert.assertTrue(lineup.isDisplayed());

        // Shipments to be loaded
        WebElement shipmentsToBeLoaded = driver.findElement(By.cssSelector("div[aria-labelledby=\"shipments-by-select-label shipments-by-select\"]"));
        Assert.assertTrue(shipmentsToBeLoaded.isDisplayed());

        WebElement proNo = driver.findElement(By.xpath("//p[@aria-label=\"Unique identifier for shipment.\"]"));
        Assert.assertTrue(proNo.isDisplayed());
        WebElement lineup1 = driver.findElement(By.xpath("//a[@aria-label=\"Lineup\"]"));
        Assert.assertTrue(lineup1.isDisplayed());
        lineup1.click();
        Thread.sleep(3000);
        WebElement prtyScore = driver.findElement(By.xpath("//p[@aria-label=\"Shipment priority score\"]"));
        Assert.assertTrue(prtyScore.isDisplayed());
        Thread.sleep(3000);
        WebElement originShipment = driver.findElement(By.xpath("//p[@aria-label=\"Origin terminal of the shipment.\"]"));
        Assert.assertTrue(originShipment.isDisplayed());
        Thread.sleep(3000);
        WebElement destinationShipment = driver.findElement(By.xpath("//p[@aria-label=\"Destination terminal of the shipment.\"]"));
        Assert.assertTrue(destinationShipment.isDisplayed());
        Thread.sleep(3000);
        WebElement weightShipment = driver.findElement(By.xpath("//p[@aria-label=\"Weight (in lbs) of the shipment.\"]"));
        Assert.assertTrue(weightShipment.isDisplayed());
        Thread.sleep(3000);
        WebElement cubeShipment = driver.findElement(By.xpath("//p[@aria-label=\"Volume (in cubic feet) of the shipment\"]"));
        Assert.assertTrue(cubeShipment.isDisplayed());
        Thread.sleep(3000);
        WebElement statusShipment = driver.findElement(By.cssSelector("p[aria-label=\"Describes current state of the shipment.\"]"));
        Assert.assertTrue(statusShipment.isDisplayed());
        Thread.sleep(3000);
        WebElement locationShipment = driver.findElement(By.cssSelector("p[aria-label=\"Current location of the shipment\"]"));
        Assert.assertTrue(locationShipment.isDisplayed());
        Thread.sleep(3000);
        WebElement etaShipment = driver.findElement(By.cssSelector("p[aria-label=\"Expected time of arrival of the shipment at the terminal being viewed.\"]"));
        Assert.assertTrue(etaShipment.isDisplayed());
        Thread.sleep(3000);
        WebElement propsShipment = driver.findElement(By.cssSelector("p[aria-label=\"Special Properties\"]"));
        Assert.assertTrue(propsShipment.isDisplayed());
        Thread.sleep(3000);
        // Strip Trailers Dropdown
        WebElement stripTrailersDropdown = driver.findElement(By.xpath("//li[@data-value=\"stripTrailers\"]"));
        Assert.assertTrue(stripTrailersDropdown.isDisplayed());
        Thread.sleep(3000);
        // Trailer details
        WebElement trailerId = driver.findElement(By.xpath("//div[contains(@class, 'MuiDataGrid-columnHeaderDraggableContainer')]/following::div//div[@aria-label='Assigned Trailer ID']"));
        Assert.assertTrue(trailerId.isDisplayed());
        Thread.sleep(3000);
        WebElement priority = driver.findElement(By.xpath("(//div[contains(@class, 'MuiDataGrid-columnHeaderDraggableContainer')]/following::div//p[@aria-label='Manifest Priority Score'])[2]"));
        Assert.assertTrue(priority.isDisplayed());

        WebElement originTrailer = driver.findElement(By.cssSelector("p[aria-label=\"Trailer Load origin'\"]"));
        Assert.assertTrue(originTrailer.isDisplayed());

        WebElement locationTrailer = driver.findElement(By.cssSelector("div[aria-label=\"Current location of the shipment\"]"));
        Assert.assertTrue(locationTrailer.isDisplayed());

        WebElement statusTrailer = driver.findElement(By.xpath("(//div[@aria-label='Status of Trailer'])[2]"));
        Assert.assertTrue(statusTrailer.isDisplayed());

        WebElement etaTrailer = driver.findElement(By.cssSelector("div[aria-label=\"Expected time of arrival of the shipment at the terminal being viewed\"]"));
        Assert.assertTrue(etaTrailer.isDisplayed());

        // Close the browser
        driver.quit();
    }
}
