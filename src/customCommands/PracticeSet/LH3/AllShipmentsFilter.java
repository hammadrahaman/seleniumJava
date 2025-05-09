package PracticeSet.LH3;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Properties;

import static PracticeSet.LH.waits.wait1s;
import static PracticeSet.LH3.waits.*;
import org.openqa.selenium.Keys;

public class AllShipmentsFilter {
    WebDriver driver;
    Properties prop;
    WebDriverWait wait;
    Actions actions;
    SoftAssert should;
    JavascriptExecutor js;

    private static final String allShipments = "//*[text()='All Shipments']/ancestor::*[position()='8']";
    public AllShipmentsFilter(WebDriver driver) {
        this.driver = driver;
        this.prop = new Properties();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
        this.actions = new Actions(this.driver);
        should = new SoftAssert();
        js = (JavascriptExecutor) this.driver;
    }

    @FindBy(xpath = "(//*[@aria-label='Menu'])[position() > 1]")
    List<WebElement> filterIcons;

    @FindBy(xpath = "(//*[@aria-label='Menu'])[position() > 1]/ancestor::*[position()=3]")
    List<WebElement> column;

    @FindBy(xpath = "//*[text()='Filter']")
    WebElement filterOption;

    @FindBy(xpath = "//*[contains(text(), 'Lanes:')]/ancestor::div[5]//*[contains(@role, 'row') and contains(@class, 'MuiDataGrid-row')]")
    List<WebElement> lanes;
    @FindBy(xpath = "//*[@id='terminalListAutoComplete']")
    WebElement terminal;

    @FindBy(xpath = "//*[@data-option-index='0']")
    WebElement firstOptionTerminal;


    @FindBy(xpath = "//*[@id='shipments-by-select']")
    WebElement drpDwn;

    @FindBy(xpath = "//*[text()='All Shipments']")
    WebElement allShipmentDrpDwn;

    @FindBy(xpath = "//*[@aria-label='Delete']")
    WebElement clearFilter;

    @FindBy(xpath = allShipments+"//*[@data-rowindex='1']")
    WebElement secondRow;


    @FindBy(xpath = allShipments + "//*[@data-testid='FilterListIcon']")
    WebElement filterIcon1;


    @FindBy(xpath = "//*[text()='Columns']/parent::div//select[@aria-invalid='false']")
    WebElement filterColumnDropDown;


    @FindBy(xpath = "//*[text()='Value']/parent::div//input")
    WebElement filterValueInput;

    @FindBy(xpath = "//*[text()='Value']/parent::div//select")
    WebElement filterValueSelect;

    @FindBy(xpath = "//*[text()='Operator']/parent::div//select[@aria-invalid='false']")
    WebElement filterOperators;


    public void selectLanes() {
        wait.until(ExpectedConditions.visibilityOfAllElements(lanes));
        selectTerminal("AUZ");
        wait2s();
        System.out.println("lane: "+lanes.size());
        for (int i = 0; i < lanes.size(); i++) {
            WebElement projElement = lanes.get(i).findElement(By.xpath(".//div[@data-field='Cal']")); // have taken cal value rather proj value
            String projValue = projElement.getText();
            System.out.println("projValue: " + projValue);
            int proj = Integer.parseInt(projValue);
            if (proj>3){
                projElement.click();
                break;
            }
        }
    }

    public void selectTerminal(String terminalName){
        wait1s();
        System.out.println("Terminal: "+ terminalName);
        terminal.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, terminalName);
        firstOptionTerminal.click();
        wait1s();
    }

    public void selectAllShipments(){
        wait1s();
        drpDwn.click();
        allShipmentDrpDwn.click();
        wait2s();
    }

    public void clearFilter() {
        wait2s();
        clearFilter.click();
        wait2s();
    }

    //    String xp = "(//*[text()='All Shipments']/ancestor::*[position()='8']//*[@role='columnheader'])[position()>2]";

    public void filterLogic(){
       for(int i=0; i<filterIcons.size();i++){
           System.out.println("------------");
           wait3s();
           String columnName = column.get(i).getText();
           String actualText = extractDataActual(i);
           System.out.printf("The column: %s | The actualData: %s | The size filter: %s ", columnName, actualText, filterIcons.size());
           if(columnName.equalsIgnoreCase("Props")) continue;
           if(timeFilters(columnName, i)) continue;
           if (statusFilter(columnName, i, actualText)) continue;
           wait2s();
           actions.moveToElement(column.get(i)).perform();
           wait2s();
           filterIcons.get(i).click();
           filterOption.click();
           filterValueForInput(actualText, columnName);
           wait1s();
           String expectedText = extractDataExpected(i);
           System.out.printf("\nExpected: %s | Actual: %s | Column: %s\n", expectedText, actualText, columnName);
           assertion(expectedText,actualText);
           clearFilter();
       }
    }

    public boolean statusFilter(String columnName, int i, String actualText){
        if(columnName.equals("Status")) {
            actions.moveToElement(column.get(i)).perform();
            filterIcons.get(i).click();
            filterOption.click();
            filterValueSelect.click();
            String clo = "//select//*[text()='Closed']";
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clo)));
            ele.click();
            wait1s();
            String expectedText = extractDataExpected(i);
            assertion(expectedText,actualText);
            wait1s();
            clearFilter();
            return true;
        }
        return false;
    }

    public Boolean timeFilters(String columnName, int i){
        try{
        if (columnName.equalsIgnoreCase("ETA" ) || columnName.equalsIgnoreCase("Cut Time")){
            int c = i+2;
            actions.moveToElement(column.get(i)).perform();
            filterIcons.get(i).click();
            filterOption.click();
            filterOperators.click();
            String ops =  "//select//*[text()='is empty']";
           WebElement ope = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ops)));
           ope.click();
            String val = allShipments+"//*[@data-rowindex='1']//*[@data-colindex='"+c+"']//*";
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(val)));
            String actual = ele.getText();
            clearFilter();
            wait1s();
            return true;
        }
    }
        catch (Exception e){
            System.out.println("The data is not displayed which is expected");
            clearFilter();
            wait1s();
            return true;
    }
    return false;
}


    public String extractDataActual(int i){
        wait2s();
        int c = i+2;
        String val = allShipments+"//*[@data-rowindex='1']//*[@data-colindex='"+c+"']";
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(val)));
        return ele.getText();
    }

    public String extractDataExpected(int i){
        wait2s();
        int c = i+2;
        String val = allShipments+"//*[@data-rowindex='0']//*[@data-colindex='"+c+"']/*";
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(val)));
        return ele.getText();
    }

    public void filterValueForInput(String in, String columnName) {
            wait1s();
            filterValueInput.sendKeys(in);

    }



    public void filterProperties(String column){
        wait4s();
        filterIcon1.click();
        waits.wait1s();
        filterColumnDropDown.click();
        System.out.println("Selecting filter: " + column);
        String dropdownOptionXpath = "//select//*[text()='" + column + "']";
        waits.wait1s();
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownOptionXpath)));
        optionElement.click();
        waits.wait1s();
    }

    public void assertion(String ex, String ac){
        System.out.printf("\nExpected: %s | Actual: %s\n", ex, ac);
        should.assertEquals(ac, ex);
        should.assertAll();
    }

}
