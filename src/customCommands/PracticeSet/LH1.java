package PracticeSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import test.java.LaunchBrowser;
import java.time.Duration;

public class LH1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://saia-qa.livehaul.io/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='username']")));
        usernameField.sendKeys("hammad.rahaman@optym.com");

        // Wait for the password field to be present
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='password']")));
        passwordField.sendKeys("Hunt@1310");

        // Wait for the login button to be clickable and click it
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='kc-form-login']//input[@name='login']")));
        loginButton.click();
       // driver.wait(2000);

        String directVar = "div[class='flex gap-5 align-center pointer MuiBox-root css-p83cy4'] p[class='MuiTypography-root MuiTypography-body1 css-1kkse3p']";


        WebElement  directAssert = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(directVar)));
        directAssert.isDisplayed();
        //column rec
        driver.findElement(By.cssSelector("div[class='MuiDataGrid-root MuiDataGrid-root--densityStandard css-79rgty'] div[aria-label='Efficiency opportunities available.']")).isDisplayed();

        //column lane
        driver.findElement(By.xpath("//div[@class='MuiDataGrid-root MuiDataGrid-root--densityStandard css-79rgty']//div[@class='MuiDataGrid-columnHeaderTitle css-cc8tf1'][normalize-space()='Lane']")).isDisplayed();

        //column loD
        driver.findElement(By.cssSelector("div[class='MuiDataGrid-root MuiDataGrid-root--densityStandard css-79rgty']  p[aria-label=\"Loaded freight in the lane'\"]")).isDisplayed();

        //column cal
        driver.findElement(By.cssSelector("div[class='MuiDataGrid-root MuiDataGrid-root--densityStandard css-79rgty'] p[aria-label='Calculated projected trailer count']")).isDisplayed();

        //column in rel
        driver.findElement(By.cssSelector("div[class='MuiDataGrid-root MuiDataGrid-root--densityStandard css-79rgty'] p[aria-label='Relay trailer count']")).isDisplayed();

        //oiu
        driver.findElement(By.cssSelector("div[class='MuiDataGrid-columnHeader MuiDataGrid-columnHeader--alignCenter MuiDataGrid-columnHeader--sortable MuiDataGrid-columnHeader--numeric projection-grid-header '] p")).isDisplayed();
//proj

        driver.findElement(By.cssSelector("div[class='MuiDataGrid-root MuiDataGrid-root--densityStandard css-79rgty'] p[aria-label='Projected trailer count']")).isDisplayed();


        //search filter
        driver.findElement(By.cssSelector("div[class='MuiDataGrid-root MuiDataGrid-root--densityStandard css-79rgty'] div div input[placeholder='Search']")).sendKeys("GBO");

        //all lanes
        String text = driver.findElement(By.xpath("//div[@class='MuiFormControl-root css-13sljp9']//div//div")).getText();
        System.out.println("checking "+ text );


   WebElement ship =     driver.findElement(By.xpath("(//div[@class='MuiDataGrid-columnHeaderTitleContainer'])[3]"));
    ship.isDisplayed();
    String check = ship.getText();
        System.out.println("Chekcing test=====" + check);
        driver.quit();
    }
}
