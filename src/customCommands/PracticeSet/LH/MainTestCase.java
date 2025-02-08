package PracticeSet.LH;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainTestCase extends Base {

    @BeforeTest
    public void setup() {
        driver = initializeDriver();
    }


    @Test(priority = 1)
    public void weightCubeHandling(){
        WeightCubeHandling sumWeightAllShipments = new WeightCubeHandling(driver);
        sumWeightAllShipments.selectLanes();
        sumWeightAllShipments.selectAllShipments();
        sumWeightAllShipments.calculateSum();
        sumWeightAllShipments.weightUi();
        sumWeightAllShipments.volumeUi();
        sumWeightAllShipments.handlingUi();

    }



    @Test(priority = 2)
    public void oiu(){
        OUValue_Calc test = new OUValue_Calc(driver);
        test.OUCalculations();
    }

    @Test(priority = 3)
    public void calc(){
        OUValue_Calc test = new OUValue_Calc(driver);
        test.calcCalculations();
    }



    @AfterTest
    public void closeBrowser(){
        driver.close();
    }





}
