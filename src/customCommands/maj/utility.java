package maj;

import custom.Actions;
import custom.sleep;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.LaunchBrowser;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

//jus was checking commands was mentioned here
public class utility {
    public WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void opnBrw(){
        LaunchBrowser.setDriver();
        driver = LaunchBrowser.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
       // driver.get("https://qtripdynamic-qa-frontend.vercel.app/");

    }

@AfterMethod(alwaysRun = true)
    public void closeBrowser(){
    driver.close();
}

}
