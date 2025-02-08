package PracticeSet.LH2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static PracticeSet.LH.waits.*;

public class SumWeightAllShipments {
    WebDriver driver;
     WebDriverWait wait;
     SoftAssert should;

    int totalSumOfWeight=0;

    // Constructor for initializing the WebDriver
    public SumWeightAllShipments(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        should = new SoftAssert();
    }

    @FindBy(xpath = "//*[contains(text(), 'Lanes:')]/ancestor::div[5]//*[contains(@role, 'row') and contains(@class, 'MuiDataGrid-row')]")
    List<WebElement> lanes;

    @FindBy(xpath = "//div[@data-field='weight' and not(@role='columnheader')]")
    List<WebElement> weightList;

    @FindBy(xpath = "//*[@id='shipments-by-select']")
    WebElement drpDwn;

    @FindBy(xpath = "//*[text()='All Shipments']")
    WebElement allShipmentDrpDwn;




    // Login method
    public void login() {
        driver.get("https://saia-qa.livehaul.io/");
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='username']")));
        usernameField.sendKeys("hammad.rahaman@optym.com");
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='kc-form-login']//input[@id='password']")));
        passwordField.sendKeys("Hunt@1310");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='kc-form-login']//input[@name='login']")));
        loginButton.click();
        wait4s();
    }

    // Method to select lanes and fetch 'Proj' values
    public void selectLanes() {
        wait.until(ExpectedConditions.visibilityOfAllElements(lanes));
        for (int i = 0; i < lanes.size(); i++) {
            WebElement projElement = lanes.get(i).findElement(By.xpath(".//div[@data-field='Proj']"));
            String projValue = projElement.getText();
            System.out.println("projValue: " + projValue);
            if (!projValue.equals("0")){
                projElement.click();
                break;
            }
        }
    }




    public void selectAllShipments(){
        wait1s();
        drpDwn.click();
        allShipmentDrpDwn.click();
        wait2s();
    }


    public void calculateWeight(){
        for(int i=0; i<weightList.size(); i++){
            String weightText = weightList.get(i).getText().replace(",", "");
            int actualWeight = Integer.parseInt(weightText);
            totalSumOfWeight += actualWeight;
            System.out.println("Weight for each loop: "+totalSumOfWeight);
        }
        System.out.println("Total Weight: " + totalSumOfWeight);
    }


public void getWeightValueFromUi(){
        WebElement element = driver.findElement(By.xpath("//div[@data-id='all-shipments-footer']//p[contains(@aria-label, ',')]"));
        String attributeValue = element.getAttribute("aria-label").replace(",", "");
        int weightFromUi = Integer.parseInt(attributeValue);
        System.out.println("weightFromUi: "+weightFromUi);
        should.assertEquals(totalSumOfWeight, weightFromUi, "Weight mismatch between UI and calculated total");
        should.assertAll();
}

}
