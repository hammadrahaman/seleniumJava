package maj;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.LaunchBrowser;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

//jus was checking commands was mentioned here
public class utility {
    public WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public WebDriver opnBrw(){
        LaunchBrowser.setDriver();
        driver = LaunchBrowser.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
       // driver.get("https://qtripdynamic-qa-frontend.vercel.app/");
        return driver;
    }

@AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.close();
}

}
