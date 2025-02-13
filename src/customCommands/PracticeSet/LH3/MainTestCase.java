package PracticeSet.LH3;

import PracticeSet.LH.Base;
import PracticeSet.LH.OUValue_Calc;
import PracticeSet.LH.WeightCubeHandling;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCase extends Base2 {

    @BeforeTest
    public void setup() {
        driver = initializeDriver();
    }


@Test(priority = 1, enabled = true)
public void shipmentByDestination(){
    ShipmentByDestinationRough filters = new ShipmentByDestinationRough(driver);
        filters.main();
       filters.multiFilter();

}

@Test(priority = 1, enabled = true)
public void allShipments(){
        AllShipments filter = new AllShipments(driver);
        filter.selectLanes();
        filter.selectAllShipments();
        filter.filterLogic();
}

    @Test(priority = 1, enabled = true)
    public void check1(){
        FiltersRough ch = new FiltersRough(driver);
        ch.filter();
        ch.lastFiveFilter();
    }

    @Test(priority = 1, enabled = true)
    public void allLanesFilter(){
        Filters ch = new Filters(driver);
        ch.filter();
        ch.lastFiveFilter();
    }




    //@AfterTest
    public void closeBrowser(){
        driver.close();
    }





}
