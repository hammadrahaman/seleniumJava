package PracticeSet.LH;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static PracticeSet.LH.waits.*;

public class WeightCubeHandling {
    WebDriver driver;
     WebDriverWait wait;
     SoftAssert should;

    private final JavascriptExecutor js;

    int numberOfShipments;


    public WeightCubeHandling(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        should = new SoftAssert();
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//*[contains(text(), 'Lanes:')]/ancestor::div[5]//*[contains(@role, 'row') and contains(@class, 'MuiDataGrid-row')]")
    List<WebElement> lanes;

    @FindBy(xpath = "//div[@data-field='weight' and not(@role='columnheader')]")
    List<WebElement> weightList;
// weightList handle virtualization.  //div[@data-id='all-shipments']//div[@data-rowindex='20']//*[@data-field='weight']   //div[@data-id='all-shipments']//div[@data-rowindex='0']//*[@data-field='weight']
    @FindBy(xpath = "//div[@data-field='volume' and not(@role='columnheader')]")
    List<WebElement> volumeList;

    @FindBy(xpath = "//div[@data-field='handlingUnits' and not(@role='columnheader')]")
    List<WebElement> handlingUnitsList;


    @FindBy(xpath = "//*[@id='shipments-by-select']")
    WebElement drpDwn;

    @FindBy(xpath = "//*[text()='All Shipments']")
    WebElement allShipmentDrpDwn;

    @FindBy(xpath = "//*[@aria-label='All Shipments']//*[2]")
    WebElement numberOfAllShipments;

    @FindBy(xpath = "//*[@id='terminalListAutoComplete']")
    WebElement terminal;

    @FindBy(xpath = "//*[@data-option-index=\"0\"]")
    WebElement firstOptionTerminal;

    int totalHandling ;
    int totalVolume ;
    int totalSumWeight;




    public void selectTerminal(String terminalName){
        wait1s();
        System.out.println("Terminal: "+ terminalName);
        terminal.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, terminalName);
        firstOptionTerminal.click();
        wait1s();
    }



    public void calculateSum(){
            String baseXPathWeight = "//div[@data-id='all-shipments']//div[@data-rowindex='%d']//*[@data-field='weight']";
            String baseXPathVolume = "//div[@data-id='all-shipments']//div[@data-rowindex='%d']//*[@data-field='volume']";
            String baseXPathHandling = "//div[@data-id='all-shipments']//div[@data-rowindex='%d']//*[@data-field='handlingUnits']";

            for (int i = 0; i <numberOfShipments; i++) {
                String xPathWeight = String.format(baseXPathWeight, i);
                String xPathVolumn = String.format(baseXPathVolume, i);
                String xPathHandling = String.format(baseXPathHandling, i);
                WebElement eleWeight = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathWeight)));
                WebElement eleVolume = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathVolumn)));
                WebElement eleHandling = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathHandling)));
                if (!isElementInViewport(eleWeight)) {
                    scrollElementIntoView(eleWeight);
                }
                wait.until(ExpectedConditions.visibilityOf(eleWeight));
                String weightValue = eleWeight.getText().replace(",", "");
                String volumeValue = eleVolume.getText().replace(",", "");
                String handlinValue = eleHandling.getText().replace(",", "");
                System.out.printf("Iteration %d => weightValue %s, volumeValue %s, handlinValue %s%n", i, weightValue, volumeValue, handlinValue);
                int weight = Integer.parseInt(weightValue);
                int volume = Integer.parseInt(volumeValue);
                int handling = Integer.parseInt(handlinValue);
                totalSumWeight += weight;
                totalVolume += volume;
                totalHandling += handling;
                System.out.println("Weight for each loop: "+totalSumWeight);
                System.out.println();

            }
        System.out.println("------------");
        System.out.println("TotalSum: "+ totalSumWeight);
        System.out.println("totalVolume: "+ totalVolume);
        System.out.println("totalHandling: "+totalHandling);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        }



        private boolean isElementInViewport(WebElement element) {
            return (Boolean) js.executeScript(
                    "var rect = arguments[0].getBoundingClientRect();" +
                            "return (rect.top >= 0 && rect.bottom <= window.innerHeight);",
                    element);
        }

        private void scrollElementIntoView(WebElement element) {
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            try {
                Thread.sleep(500); //
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }




    public void selectLanes() {
        wait.until(ExpectedConditions.visibilityOfAllElements(lanes));
        selectTerminal("AUZ");
        wait2s();
        System.out.println("lane: "+lanes.size());
        for (int i = 0; i < lanes.size(); i++) {
            WebElement projElement = lanes.get(i).findElement(By.xpath(".//div[@data-field='Cal']")); // have taken cal value rather proj value
            String projValue = projElement.getText();
            System.out.println("projValue: " + projValue);
            if (projValue.equals("3")){
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
        String number1 = driver.findElement(By.xpath("//div[@aria-label=\"All Shipments\"]")).getText();
        System.out.println("NumberString: "+ number1);
        String[] parts = number1.split(":");
        String number = parts[parts.length - 1].trim(); // Get the last part and trim any spaces.
        System.out.println("Number: " + number);
         numberOfShipments = Integer.parseInt(number);

    }


public void weightUi(){
        WebElement element = driver.findElement(By.xpath("//div[@data-id='all-shipments-footer']//p[contains(@aria-label, ',')]"));
        String attributeValue = element.getAttribute("aria-label").replace(",", "");  //
        System.out.println("volumeAttr: "+ attributeValue);
        int weightFromUi = Integer.parseInt(attributeValue);
        System.out.println("weightFromUi: "+weightFromUi);
        should.assertEquals(totalSumWeight, weightFromUi, "Weight mismatch between UI and calculated total");
        should.assertAll();
}


public void volumeUi(){
        WebElement element = driver.findElement(By.xpath("//div[@data-id='all-shipments-footer']//*[text()='CuFt']/preceding-sibling::p"));
    String text = element.getText().toLowerCase();
        if(text.contains("k")){
           text = element.getAttribute("aria-label").replace(",", "");
        }
        int cubeFromUi = Integer.parseInt(text);
        System.out.println("cubeFromUi: "+ cubeFromUi);
        should.assertEquals(totalVolume, cubeFromUi, "Volume mismatch between UI and calculated total");
        should.assertAll();
}


public void handlingUi(){
    WebElement element = driver.findElement(By.xpath("//div[@data-id='all-shipments-footer']//*[text()='Handling Units']/preceding-sibling::p"));
    String text = element.getText();
    int handlingUnitsFromUi = Integer.parseInt(text);
    System.out.println("handlingUnitsFromUi: "+ handlingUnitsFromUi);
    should.assertEquals(totalHandling, handlingUnitsFromUi, "Handling Units mismatch between UI and calculated total");
    should.assertAll();
}



}
