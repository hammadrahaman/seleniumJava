import custom.sleep;
import maj.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;
import custom.Actions;


public class TestCase extends utility {
   // actions act = new actions();

    @Test(priority = 0, description = "Test 4", enabled = false)

    public void register(){
        Actions registerAccount=new Actions();
        SessionId s=((RemoteWebDriver)driver).getSessionId();
        System.out.println("SessionID1:"+s);
        driver.navigate().to("https://qtripdynamic-qa-frontend.vercel.app/");
        registerAccount.registerPage();
        registerAccount.enterEmail();
        registerAccount.enterPassword();
        registerAccount.reEnterPassword();
        registerAccount.registerBtn();
        sleep.mediumWait();
    }
}
