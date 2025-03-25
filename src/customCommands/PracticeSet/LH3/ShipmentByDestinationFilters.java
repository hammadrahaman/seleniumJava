package PracticeSet.LH3;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static PracticeSet.LH3.waits.*;


public class ShipmentByDestinationFilters {

    WebDriver driver;
    Properties prop;
    WebDriverWait wait;
    Actions actions;
    SoftAssert should;
    JavascriptExecutor js;
    String dataField;


    String ac;

    String ex;

    String tex;
    String ab;
    public ShipmentByDestinationFilters(WebDriver driver) {
        this.driver = driver;
        this.prop = new Properties();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        //this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
        this.actions = new Actions(this.driver);
        should = new SoftAssert();
        js = (JavascriptExecutor) this.driver;
    }

    private static final String shipmentByDestination = "//*[text()='Shipments By Destination']/ancestor::*[position()='8']";


    String a = "//*[@aria-rowindex='%d']//*[@data-field='%s']/*/*[contains(@class, 'flex-column') or contains(@class, 'flex-center')]" ;

    @FindBy(xpath = shipmentByDestination + "//*[@data-testid='FilterListIcon']")
    WebElement filterIcon;

    @FindBy(xpath = "//*[@id='terminalListAutoComplete']")
    WebElement terminal;

    @FindBy(xpath = "//*[@data-option-index='0']")
    WebElement firstOptionTerminal;


    @FindBy(xpath = "//*[contains(text(), 'Lanes:')]/ancestor::div[5]//*[contains(@role, 'row') and contains(@class, 'MuiDataGrid-row') and not(contains(@aria-rowindex, '2'))]")
    List<WebElement> lanes;

    @FindBy(xpath = "//*[text()='Columns']/parent::div//select[@aria-invalid='false']")
    WebElement filterColumnDropDown;

    @FindBy(xpath = "//*[text()='Operator']/parent::div//select[@aria-invalid='false']")
    WebElement filterOperators;

    @FindBy(xpath = "//*[text()='Value']/parent::div//select[@aria-invalid='false']")
    WebElement filterValueTrueFalse;

    @FindBy(xpath = "//*[text()='Value']/parent::div//input")
    WebElement filterValueInput;

    @FindBy(xpath = shipmentByDestination+"//*[@data-rowindex='0']//*[@data-testid='DoubleArrowIcon']")
    WebElement hasDirectOpportunity;

    @FindBy(xpath = "//*[@data-rowindex='0']//*[@data-testid='UploadIcon']")
    WebElement hasHeadLoadOpportunity;

    @FindBy(xpath = shipmentByDestination+"//*[@data-rowindex='1']//*[@data-field='destination']")
    WebElement shipmentDestination;

    @FindBy(xpath = shipmentByDestination+"//*[@data-rowindex='0']//*[@data-field='destination']" )
    WebElement shipmentDestinationActual;


    @FindBy(xpath = "//*[@aria-label='Delete']")
    WebElement clearFilter;

    @FindBy(xpath = "//*[@data-testid='UpdateOutlinedIcon']")
    WebElement forCaste;


    @FindBy(xpath = "//*[@aria-label='Must Go Shipment']")
    WebElement mustGo;


    @FindBy(xpath = "//*[@aria-label='Priority Shipment']")
    WebElement priorityShip;

    @FindBy(xpath = shipmentByDestination+"//*[@aria-rowindex='2']//*[@aria-label='Expand']")
    WebElement expand;

    @FindBy(xpath = "//*[@id='shipments-by-select']")
    WebElement drpDwn;

    @FindBy(xpath = "//*[text()='All Shipments']")
    WebElement allShipmentDrpDwn;

    @FindBy(xpath = "//*[@data-value='ShipmentsByDestination']")
    WebElement shipmentByDestinationDrpDwn;

    String[] shipmentOptions = {
            "hasDirectOpportunity",
            "hasHeadLoadOpportunity",
            "Shipment Destination",
            "hasMustGoBills",
            "hasPriorityBills",
            "hasHazmat",
            // "Shipments to be Loaded"
    };

    String [] multiColumns ={
            "Total (Lbs)",
            "Total (CuFt)",
            "Total (Shipments)",
            "Total (Tr Eq)",
            "Priority Shipments",
            "Upstream (Lbs)",
            "Upstream (CuFt)",
            "Booked (Lbs)",
            "Booked (CuFt)",
            "InCity (Lbs)",
            "InCity (CuFt)",
            "Enroute (Lbs)",
            "Enroute (CuFt)",
            "At Term (Lbs)",
            "At Term (CuFt)",
            "Loaded (Lbs)",
            "Loaded (CuFt)",
            "Forecast (Lbs)",
            "Forecast (CuFt)",
    };





    public String extractDataField(String column) {
        Map<String, String> fieldMapping = Map.of(
                "Total", "totalTonnage",
                "Upstream", "upstream hide",
                "Booked", "booked hide",
                "InCity", "in_city hide",
                "Enroute", "enroute hide",
                "At Term", "at_term hide",
                "Loaded", "loaded hide",
                "Forecast", "forecast",
                "Priority", "priority"
        );

        return fieldMapping.entrySet().stream()
                .filter(entry -> column.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse("UNKNOWN");
    }



    public String getCategory(String column) {
        Map<String, String> categoryMap = Map.of(
                "Lbs", "Lbs",
                "CuFt", "CuFt",
                "Tr Eq", "Tr Eq",
                "(Shipments)", "Shipments",
                "Priority", "Priority"
        );

        return categoryMap.keySet().stream()
                .filter(column::contains)
                .map(categoryMap::get)
                .findFirst()
                .orElse("OTHER");
    }



    public void multiFilter(){
        for (String col : multiColumns){
            System.out.println("-------------");
            String dataField = extractDataField(col);
            filterSegregationForCubeVolume(col, dataField);
        }
    }


    public void filterSegregationForCubeVolume(String column, String dataField){
        switch (getCategory(column)){
            case "Lbs":
                ex = filterForCubeVolume("Lbs", dataField);
                filterLogic(column);
                filterValueForInput(ex);
                ac = multiFilterDataExtraction("Lbs", dataField);
                assertion(ex, ac);
                clearFilter();
                break;
            case "CuFt":
                ex = filterForCubeVolume("CuFt", dataField);
                filterLogic(column);
                filterValueForInput(ex);
                ac = multiFilterDataExtraction("CuFt", dataField);
                assertion(ex, ac);
                clearFilter();
                break;
            case "Tr Eq":
                ex = filterForCubeVolume("Tr Eq", dataField);
                filterLogic(column);
                filterValueForInput(ex);
                ac = multiFilterDataExtraction("Tr Eq", dataField);
                assertion(ex, ac);
                clearFilter();
                break;
            case "Shipments":
                ex = filterForCubeVolume("Shipments", dataField);
                filterLogic(column);
                filterValueForInput(ex);
                ac = multiFilterDataExtraction("Shipments", dataField);
                assertion(ex, ac);
                clearFilter();
                break;
            case "Priority":
                ex = filterForCubeVolume("Shipments", dataField);
                filterLogic(column);
                filterValueForInput(ex);
                ac = multiFilterDataExtraction("Shipments", dataField);
                assertion(ex, ac);
                clearFilter();
        }
    }

    public String filterForCubeVolume(String type, String dataField){
        String xp = "//*[@aria-rowindex='3']//*[@data-field='"+dataField+"']//*[contains(text(), '"+type+"')]/preceding-sibling::p";
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
        tex = optionElement.getText();
        if(tex.contains("k")){
            tex = optionElement.getAttribute("aria-label");
        }
        System.out.println("Extracted data: "+tex );
        return tex;
    }


    public String multiFilterDataExtraction(String type, String dataField){
        String xp = "//*[@aria-rowindex='2']//*[@data-field='"+dataField+"']//*[contains(text(), '"+type+"')]/preceding-sibling::p";
        WebElement optionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xp)));
        ab = optionElement.getText();
        if(ab.contains("k")){
            ab = optionElement.getAttribute("aria-label");
        }
        System.out.println("Extracted data: "+ab );
        return ab;
    }







    public void iconFilters(String filterOptions){
        System.out.println("--------------");
        switch (filterOptions){
            case "hasDirectOpportunity":
                filterLogic(filterOptions);
                filterValueForTrueFalse("true");
                iconFilterElementVisibilityCheck(hasDirectOpportunity, filterOptions);
                break;
            case "hasHeadLoadOpportunity":
                filterLogic(filterOptions);
                filterValueForTrueFalse("true");
                iconFilterElementVisibilityCheck(hasHeadLoadOpportunity, filterOptions);
                break;
            case  "Shipment Destination":
                String actual = extractData(shipmentDestination);
                filterLogic(filterOptions);
                filterValueForInput(actual);
                String expected = extractData(shipmentDestinationActual);
                assertion(expected, actual);
                clearFilter();
                break;
            case "hasMustGoBills":
                filterLogic(filterOptions);
                filterValueForTrueFalse("true");
                expand(expand, filterOptions);
                iconFilterElementVisibilityCheck(mustGo,filterOptions);
                break;
            case "hasPriorityBills":
                filterLogic(filterOptions);
                filterValueForTrueFalse("true");
                expand(expand, filterOptions);
                iconFilterElementVisibilityCheck(priorityShip,filterOptions);
                break;
            case "hasHazmat":
                filterLogic(filterOptions);
                filterValueForTrueFalse("true");
                expand(expand, filterOptions);
                iconFilterElementVisibilityCheck(mustGo,filterOptions);
                break;
        }

    }



    public void expand(WebElement element, String column){
        try{
            System.out.println("inside expand method");
            wait1s();
            filterIcon.click(); //closed filer
            element.click();
            wait1s();
            filterIcon.click();
            wait1s();// opened filter
        }catch (Exception e){
            wait1s();
            filterIcon.click();
            System.out.println("No result found for " + column+ " column");
        }
    }

    public void assertion(String ex, String ac){
        System.out.printf("\nExpected: %s | Actual: %s\n", ex, ac);
        should.assertEquals(ac, ex);
        should.assertAll();
    }


    public void iconFilterElementVisibilityCheck(WebElement element, String column){
        try{
            element.isDisplayed();
            System.out.println("Column: " + column + " | Visible: " + element.isDisplayed());
            clearFilter();
        }catch (Exception e){
            wait1s();
            clearFilter();
            System.out.println("No result found for filter " + column+ " as true ");
            iconFilterApplyFalse(column, element);  // no element found apply false and check
        }
    }


    public void iconFilterApplyFalse(String column, WebElement element) {
        filterLogic(column);
        filterValueForTrueFalse("false");
        System.out.printf("selecting false as value for the column %s:\n", column);
            try {
                if (!element.isDisplayed()) {
                    System.out.println("Element is NOT displayed");
                    clearFilter();
                }
            } catch (NoSuchElementException e) {
                System.out.println("Element is NOT in the DOM for False which is expected");
                clearFilter();

        }
    }

    public String extractData(WebElement ele){
        wait1s();
        return ele.getText();
    }

    public void filterLogic(String column){
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
    }

    public void filterValueForInput(String in){
        filterValueInput.sendKeys(in);
        wait1s();
    }


    public void filterValueForTrueFalse(String boo){
        filterValueTrueFalse.click();
        WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select//*[text()='"+boo+"']")));
        ele.click();
        wait1s();
    }
    public void main(){
        try {
            selectTerminal("ATL");
            selectLanes();
            wait1s();
            validateToggleForAllShipmentsOrSBD();
            forCaste.click();
            for (String columns : shipmentOptions) {
                iconFilters(columns);
            }
        }catch (InterruptedException e){
            System.err.println("Thread was interrupted: " + e.getMessage());
        }

    }

    public void selectShipmentByDestination() throws InterruptedException{
        Thread.sleep(1000);
        drpDwn.click();
        shipmentByDestinationDrpDwn.click();
        Thread.sleep(2000);
        //String number1 = driver.findElement(By.xpath("//*[@aria-label='All Shipments']")).getText();
    }

    public void validateToggleForAllShipmentsOrSBD() throws InterruptedException {
        try {
            WebElement allShipmentsOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'All Shipments')]")));
            if (allShipmentsOption.isDisplayed()) {
                System.out.println("'All Shipments' option is visible.");
                selectShipmentByDestination();
            } else {
                System.out.println("'All Shipments' option exists but is hidden.");
            }
        } catch (TimeoutException  e) {
            System.out.println("'All Shipments' option is NOT present in the DOM.");
            selectShipmentByDestination();
        }
    }



    public void selectTerminal(String terminalName){
        wait1s();
        System.out.println("Terminal: "+ terminalName);
        terminal.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, terminalName);
        firstOptionTerminal.click();
        wait1s();
    }

    public void selectLanes() {
        wait.until(ExpectedConditions.visibilityOfAllElements(lanes));
        for (int i = 0; i < lanes.size(); i++) {
            WebElement projElement = lanes.get(i).findElement(By.xpath(".//div[@data-field='Proj']"));
            String projValue = projElement.getText();
            float proj = Float.parseFloat(projValue);
            System.out.println("projValue: " + projValue);
            if (proj>=14.0){
                projElement.click();
                break;
            }
        }
    }




    public void clearFilter() {
        wait2s();
        clearFilter.click();
        wait2s();
    }
}
