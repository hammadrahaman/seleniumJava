package PracticeSet.LH3;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestCase extends Base2 {

    @BeforeTest
    public void setup() throws Exception {


        driver = initializeDriver();
    }


@Test(priority = 2, enabled = true)
public void shipmentByDestination(){
    ShipmentByDestinationFilters filters = new ShipmentByDestinationFilters(driver);
        filters.main();
       filters.multiFilter();

}

@Test(priority = 3, enabled = true)
public void allShipments(){
    AllShipmentsFilter filter = new AllShipmentsFilter(driver);
        filter.selectLanes();
        filter.selectAllShipments();
        filter.filterLogic();
}



    @Test(priority = 1, enabled = true)
    public void allLanesFilter(){
        AllLanesFilter ch = new AllLanesFilter(driver);
        ch.filter();
        ch.iconFilters();
    }




 //   @AfterTest
    public void closeBrowser() throws Exception {
        driver.close();
    }





}
