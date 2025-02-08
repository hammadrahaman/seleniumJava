package PracticeSet.LH3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;

import static PracticeSet.LH3.waits.*;

public class FiltersRough {
    WebDriver driver;
    Properties prop;
    WebDriverWait wait;

    Actions actions;

    SoftAssert should;

    JavascriptExecutor js;

    String col;

    String datafi;

    private static final String  allLanes = "//*[text()='All Lanes']/ancestor::*[position()='4']";

    private static final String lanes = "//*[contains(text(), 'Lanes:')]/ancestor::*[position()='5']";

    public FiltersRough(WebDriver driver) {
        this.driver = driver;
        this.prop = new Properties();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
        this.actions = new Actions(this.driver);
        should = new SoftAssert();
        js = (JavascriptExecutor) this.driver;
    }


    @FindBy(xpath = "//*[text()='Columns']/parent::div//select[@aria-invalid='false']")
    WebElement filterColumnDropDown;

    @FindBy(xpath = "//*[text()='Operator']/parent::div//select[@aria-invalid='false']")
    WebElement filterOperators;

    @FindBy(xpath = "//*[text()='Value']/parent::div//select[@aria-invalid='false']")
    WebElement filterValue;

    @FindBy(xpath = "//*[text()='Columns']")
    WebElement clickColumn;

    @FindBy(xpath = allLanes+"//*[@data-testid='FilterListIcon']")
    WebElement filterIcon;

    @FindBy(xpath = "//*[@aria-label='Delete']")
    WebElement clearFilter;


    @FindBy(xpath = allLanes+"//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='BoltIcon']")
    WebElement hasMustGoBills;

    @FindBy(xpath = allLanes+"//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='StarsIcon']")
    WebElement hasPriorityBills;

    @FindBy(xpath = lanes+"//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='UploadIcon']")
    WebElement hasHeadLoadOpportunity;

    @FindBy(xpath = allLanes+"//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='DoubleArrowIcon']")
    WebElement hasDirectOpportunity;

    @FindBy(xpath = lanes+"//div[@role='row' and @aria-rowindex='2']/child::div//*[@aria-label='Confirm Projection']")
    WebElement isConfirmed;


    String[] columns = {
            "Lane",
            "Loading",
            "Closed",
            "Expected",
            "Calculated",
            "Relay",
            "Scheduled",
            "Over Under",
            "Projected",

    };

    //
    String[] lastFiveFilters ={
            "hasMustGoBills",
            "hasPriorityBills",
            "hasHeadLoadOpportunity",
            "hasDirectOpportunity",
            "isConfirmed"
    };

    String[] dataFields = {
            "laneDestination",
            "Loa",
            "Clo",
            "Exp",
            "Cal",
            "Rel",
            "Sch",
            "O|U",
            "Proj",
    };




    public void filter(){
        for (int i =0  ;i<columns.length;i++){
            System.out.println("----------------");
            col = columns[i];
            datafi = dataFields[i];
            String xpathDataExtraction = allLanes +"//div[@role='row' and @aria-rowindex='3']/child::div[@data-field='"+dataFields[i]+"']";
            WebElement extractText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDataExtraction)));
            String data = extractText.getText();
            String formattedData = data.split("\n")[0];
            System.out.printf("The data value extracted ==> %s for the column ==> %s and the data field ==> %s \n", formattedData, columns[i], dataFields[i]);
            if(validateColumnForOperator(columns[i], dataFields[i])) continue;
            filterLogic(columns[i], formattedData, dataFields[i] );
        }
    }

    public void lastFiveFilter(){
        for (String lastFiveFilter : lastFiveFilters) {
            lastFive(lastFiveFilter);
        }
    }





    public boolean validateColumnForOperator( String filterOptions, String dataField) {
        if (dataField.equalsIgnoreCase("Loa") || dataField.equalsIgnoreCase("Clo") ||
                dataField.equalsIgnoreCase("Sch") || dataField.equalsIgnoreCase("Proj") ||
                dataField.equalsIgnoreCase("Rel") || dataField.equalsIgnoreCase("O|U")) {
            zeroDataLogic(filterOptions, dataField);
            wait1s();
            try {
                String ex = allLanes + "//div[@role='row' and @aria-rowindex='2']/child::div[@data-field='" + dataField + "']";
               driver.findElement(By.xpath(ex));
            } catch (Exception e) {
                System.out.println("The data is not displayed as expected");
            }

            clearFilter();
            return true;
        }
        return false;
    }

    public void zeroDataLogic(String filterOptions, String dataField) {
        wait1s();
        filterIcon.click();
        wait1s();
        filterColumnDropDown.click();
        System.out.println("\n went in 0");
        String dropdownOptionXpath = "//select//*[text()='" + filterOptions + "']";
        wait1s();
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownOptionXpath)));
        optionElement.click();
        filterOperators.click();
        String ops;
        if (dataField.equalsIgnoreCase("Rel")  || dataField.equalsIgnoreCase("O|U")) {
            ops = "//select//*[text()='is not empty']";
        } else {
            ops = "//select//*[text()='is empty']";
        }
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ops)));
        ele.click();
    }




    public void filterLogic(String filterOptions, String data, String dataField){
        wait1s();
        filterIcon.click();
        wait1s();
        filterColumnDropDown.click();
        String dropdownOptionXpath = "//select//*[text()='"+filterOptions+"']";
        wait1s();
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownOptionXpath)));
        optionElement.click();
        WebElement filterValueInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Filter value']")));
        filterValueInput.sendKeys(data);
        wait1s();
        String expected = expectedDataExtraction(dataField);
        String formattedData = expected.split("\n")[0];
        System.out.printf("The expected result ==> %s and the actual result ==> %s \n", data, formattedData);
        clearFilter();
        should.assertEquals(data, formattedData);
        should.assertAll();
    }


    public String expectedDataExtraction(String dataField){
        String extractExpectedData = allLanes +"//div[@role='row' and @aria-rowindex='2']/child::div[@data-field='"+dataField+"']";
        WebElement expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(extractExpectedData)));
        return expectedElement.getText();
    }


    public void clearFilter(){
        wait2s();
        clearFilter.click();
        wait2s();
    }

    public void lastFive(String column) {
        System.out.println("\n-----------------------");
        System.out.println("Processing column: " + column);
        switch (column) {
            case "hasMustGoBills":
                validatePresenceLastFiveFilters(hasMustGoBills, column);
                break;
            case "hasPriorityBills":
                validatePresenceLastFiveFilters(hasPriorityBills, column);
                break;
            case "hasHeadLoadOpportunity":
                validatePresenceLastFiveFilters(hasHeadLoadOpportunity, column);
                break;
            case "hasDirectOpportunity":
                validatePresenceLastFiveFilters(hasDirectOpportunity, column);
                break;
            case "isConfirmed":
                validatePresenceLastFiveFilters(isConfirmed, column);
                break;
            default:
                System.out.println("Invalid column name: " + column);
        }
    }

    public boolean validatePresenceLastFiveFilters(WebElement element, String column) {
        try {
            wait4s();
            filterIcon.click();
            wait1s();
            filterColumnDropDown.click();
            System.out.println("Selecting filter: " + column);
            String dropdownOptionXpath = "//select//*[text()='" + column + "']";
            wait1s();
            WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownOptionXpath)));
            optionElement.click();
            wait1s();
            filterValue.click();
            WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select//*[text()='true']")));
            ele.click();
            wait1s();
            System.out.println("The column of last five ==> " + column);
            boolean isVisible = element.isDisplayed();
            System.out.println("Element visibility for " + column + ": " + isVisible);
            clearFilter();
            return isVisible;
        } catch (Exception e) {
            System.out.println("Filtered!!! However No result have been found for " + column);
            e.printStackTrace();
            return false;
        }
    }




}
