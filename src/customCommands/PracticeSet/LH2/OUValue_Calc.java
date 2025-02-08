package PracticeSet.LH2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

import static PracticeSet.LH.waits.wait1s;


//1. O/U value - Formula is Projected + Relay -Scheduled.
//2. Calc - Formula is LoD+Exp
public class OUValue_Calc {

    WebDriver driver;
    WebDriverWait wait;
    SoftAssert should;

    public OUValue_Calc(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
        should = new SoftAssert();
    }

    @FindBy(xpath = "//*[contains(text(), 'Lanes:')]/ancestor::div[5]//*[contains(@role, 'row') and contains(@class, 'MuiDataGrid-row')]")
    List<WebElement> lanes;

    @FindBy(xpath = "//*[@id='terminalListAutoComplete']")
    WebElement terminal;

    @FindBy(xpath = "//*[@data-option-index=\"0\"]")
    WebElement firstOptionTerminal;

    public void selectTerminal(String terminalName){
        wait1s();
        System.out.println("Terminal: "+ terminalName);
        terminal.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, terminalName);
        firstOptionTerminal.click();
        wait1s();
    }






    public void OUCalculations() {
        selectTerminal("ATL");
        wait.until(ExpectedConditions.visibilityOfAllElements(lanes));
        for (int i = 0; i < lanes.size(); i++) {
            System.out.println("-----------------------");
            double proj = parseFieldValue(lanes.get(i), "Proj");
            double rel = parseFieldValue(lanes.get(i), "Rel");
            double sched = parseFieldValue(lanes.get(i), "Sch");
            double oi = parseFieldValue(lanes.get(i), "O|U");
            double o_u_value = proj + rel - sched;
            System.out.printf("Iteration %d => Proj: %f, Rel: %f, Sch: %f, O/U: %f, Calculated O/U: %f%n", i, proj, rel, sched, oi, o_u_value);
            should.assertEquals(o_u_value, oi, "Calculated O/U does not match displayed O/U");
        }

        should.assertAll();
    }


    public void calcCalculations(){
        selectTerminal("ATL");
        wait.until(ExpectedConditions.visibilityOfAllElements(lanes));
        for (int i = 0; i < lanes.size(); i++) {
            System.out.println("-----------------------");
            double Loa = parseFieldValue(lanes.get(i), "Loa");
            double Exp = parseFieldValue(lanes.get(i), "Exp");
            double Calc = parseFieldValue(lanes.get(i), "Cal");
            double cio = parseFieldValue(lanes.get(i), "Clo" );
            double calculatedCalc = Loa + Exp + cio;
            System.out.printf("Iteration %d => Loa: %f, Exp: %f, CIO: %f, Calc: %f, Calculated O/U: %f%n",i, Loa, Exp, cio,  Calc, calculatedCalc);
            should.assertEquals(Calc, calculatedCalc, "For iteration: " + i);

        }
        should.assertAll();
    }
    public double parseFieldValue(WebElement lane, String field) {
        WebElement fieldElement = lane.findElement(By.xpath(".//div[@data-field='" + field + "']"));
        String fieldValue = fieldElement.getText();
            return Double.parseDouble(fieldValue.trim());
        }

    }













