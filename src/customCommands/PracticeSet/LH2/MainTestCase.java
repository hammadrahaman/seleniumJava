package PracticeSet.LH2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTestCase extends Base1 {

    @BeforeTest
    public void setup() {
        driver = initializeDriver();
    }


    @Test(priority = 0)
    public void weight(){
        PracticeSet.LH2.SumWeightAllShipments sumWeightAllShipments = new PracticeSet.LH2.SumWeightAllShipments(driver);
        sumWeightAllShipments.selectLanes();
        sumWeightAllShipments.selectAllShipments();
        sumWeightAllShipments.calculateWeight();
        sumWeightAllShipments.getWeightValueFromUi();
    }

    @Test(priority = 1)
    public void oiu(){
        OUValue_Calc test = new OUValue_Calc(driver);
        test.OUCalculations();
    }

    @Test(priority = 2)
    public void calc(){
        OUValue_Calc test = new OUValue_Calc(driver);
        test.calcCalculations();
    }


    @AfterTest
    public void closeBrowser(){
        driver.close();
    }





}
