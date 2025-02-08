package PracticeSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class code {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///Users/hammadrahaman/Downloads/reference_page.html");
        WebElement searchInput = driver.findElement(By.id("search-input"));
        WebElement searchButton = driver.findElement(By.id("search-button"));
        Assert.assertTrue(searchInput.isDisplayed());
        Assert.assertTrue(searchButton.isDisplayed());
        Assert.assertNull(searchInput, "Search query input should be empty initially");
        Assert.assertNull(searchButton, "Submit button should be empty initially");
        driver.quit();
    }
}
