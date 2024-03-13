import custom.sleep;
import maj.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.Test;
import custom.Actions;


public class TestCase extends utility {
   // actions act = new actions();

    @Test(priority = -1, description = "Test 4")

    public void register(){
        Actions registerAccount=new Actions();
        SessionId s=((RemoteWebDriver)driver).getSessionId();
        System.out.println("SessionID1:"+s);
        registerAccount.registerPage();
        registerAccount.enterEmail();
        registerAccount.enterPassword();
        registerAccount.reEnterPassword();
        registerAccount.registerBtn();
        sleep.mediumWait();


    }
    @Test(priority=1,description="Test3",alwaysRun=true)

    public void loginValidation(){
        Actions login=new Actions();
        SessionId s=((RemoteWebDriver)driver).getSessionId();
        System.out.println("SessionID1:"+s);
        login.visitLoginUrl();
        login.visitLoginPage();
        login.enterEmailLogin();
        login.enterPassword();
        sleep.mediumWait();
        login.loginToAccount();
//driver.close();
    }
    @Test(priority=1,description="Test3",alwaysRun=true)

    public void loginValidation1(){
        Actions login=new Actions();
        SessionId s=((RemoteWebDriver)driver).getSessionId();
        System.out.println("SessionID1:"+s);
        login.visitLoginUrl();
        login.visitLoginPage();
        login.enterEmailLogin();
        login.enterPassword();
        sleep.mediumWait();
        login.loginToAccount();
//driver.close();
    }

    @Test(priority=1,description="Test3",alwaysRun=true)
    public void registration(){

    }

}
