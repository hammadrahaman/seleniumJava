package PracticeSet.LH3;



import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Properties;

import static PracticeSet.LH3.waits.*;

public class Filters {
    WebDriver driver;
    Properties prop;
    WebDriverWait wait;
    Actions actions;
    SoftAssert should;
    JavascriptExecutor js;
    String col;
    String datafi;

    private static final String allLanes = "//*[text()='All Lanes']/ancestor::*[position()='4']";
    private static final String lanes = "//*[contains(text(), 'Lanes:')]/ancestor::*[position()='5']";

    public Filters(WebDriver driver) {
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

    @FindBy(xpath = allLanes + "//*[@data-testid='FilterListIcon']")
    WebElement filterIcon;

    @FindBy(xpath = "//*[@aria-label='Delete']")
    WebElement clearFilter;

    @FindBy(xpath = allLanes + "//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='BoltIcon']")
    WebElement hasMustGoBills;

    @FindBy(xpath = allLanes + "//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='StarsIcon']")
    WebElement hasPriorityBills;

    @FindBy(xpath = lanes + "//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='UploadIcon']")
    WebElement hasHeadLoadOpportunity;

    @FindBy(xpath = allLanes + "//div[@role='row' and @aria-rowindex='2']/child::div//*[@data-testid='DoubleArrowIcon']")
    WebElement hasDirectOpportunity;

    @FindBy(xpath = lanes + "//div[@role='row' and @aria-rowindex='2']/child::div//*[@aria-label='Confirm Projection']")
    WebElement isConfirmed;

    String[] columns = {
            "Lane", "Loading", "Closed", "Expected", "Calculated",
            "Relay", "Scheduled", "Over Under", "Projected",
    };

    String[] lastFiveFilters = {
            "hasMustGoBills", "hasPriorityBills", "hasHeadLoadOpportunity",
            "hasDirectOpportunity", "isConfirmed"
    };

    String[] dataFields = {
            "laneDestination", "Loa", "Clo", "Exp", "Cal",
            "Rel", "Sch", "O|U", "Proj",
    };

    // 🔹 Iterate through column filters
    public void filter() {
        for (int i = 0; i < columns.length; i++) {
            System.out.println("----------------");
            col = columns[i];
            datafi = dataFields[i];
            String xpathDataExtraction = allLanes + "//div[@role='row' and @aria-rowindex='3']/child::div[@data-field='" + datafi + "']";
            WebElement extractText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathDataExtraction)));
            String data = extractText.getText().split("\n")[0];
            System.out.printf("Extracted: %s | Column: %s | Data Field: %s\n", data, col, datafi);

            if (validateColumnForOperator(col, datafi)) continue;
            filterLogic(col, data, datafi);
        }
    }

    public void lastFiveFilter() {
        for (String filter : lastFiveFilters) {
            lastFive(filter);
        }
    }

    public boolean validateColumnForOperator(String filterOptions, String dataField) {
        if (dataField.matches("Loa|Clo|Sch|Proj|Rel|O\\|U")) {
            zeroDataLogic(filterOptions, dataField);
            wait1s();
            try {
                driver.findElement(By.xpath(allLanes + "//div[@role='row' and @aria-rowindex='2']/child::div[@data-field='" + dataField + "']"));
            } catch (NoSuchElementException e) {
                System.out.println("Expected data is not displayed.");
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
        String dropdownOptionXpath = "//select//*[text()='" + filterOptions + "']";
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownOptionXpath)));
        optionElement.click();
        filterOperators.click();
        String ops = (dataField.matches("Rel|O\\|U")) ? "//select//*[text()='is not empty']" : "//select//*[text()='is empty']";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ops))).click();
    }

    public void filterLogic(String filterOptions, String data, String dataField) {
        wait1s();
        filterIcon.click();
        wait1s();
        filterColumnDropDown.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select//*[text()='" + filterOptions + "']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Filter value']"))).sendKeys(data);
        wait1s();
        String formattedData = expectedDataExtraction(dataField).split("\n")[0];
        System.out.printf("Expected: %s | Actual: %s\n", data, formattedData);
        clearFilter();
        should.assertEquals(data, formattedData);
        should.assertAll();
    }

    public String expectedDataExtraction(String dataField) {
        String extractExpectedData = allLanes + "//div[@role='row' and @aria-rowindex='2']/child::div[@data-field='" + dataField + "']";
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(extractExpectedData))).getText();
    }

    public void clearFilter() {
        wait2s();
        clearFilter.click();
        wait2s();
    }

    public void lastFive(String column) {
        System.out.println("\n-----------------------");
        System.out.println("Processing column: " + column);
        WebElement element = getLastFiveElement(column);
        if (element != null) {
            validatePresenceLastFiveFilters(element, column);
        } else {
            System.out.println("Invalid column: " + column);
        }
    }

    private WebElement getLastFiveElement(String column) {
        switch (column) {
            case "hasMustGoBills": return hasMustGoBills;
            case "hasPriorityBills": return hasPriorityBills;
            case "hasHeadLoadOpportunity": return hasHeadLoadOpportunity;
            case "hasDirectOpportunity": return hasDirectOpportunity;
            case "isConfirmed": return isConfirmed;
            default: return null;
        }
    }

    public void validatePresenceLastFiveFilters(WebElement element, String column) {
        try {
            wait4s();
            filterIcon.click();
            wait1s();
            filterColumnDropDown.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select//*[text()='" + column + "']"))).click();
            wait1s();
            filterValue.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select//*[text()='true']"))).click();
            wait1s();
            System.out.println("Column: " + column + " | Visible: " + element.isDisplayed());
            clearFilter();
        } catch (Exception e) {
            System.out.println("No result found for " + column);
            e.printStackTrace();
        }
    }
}
