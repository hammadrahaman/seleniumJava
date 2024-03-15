import custom.LOpsReg;
import custom.sleep;
import maj.utility;
import org.testng.annotations.Test;

public class LOpsTestCase extends utility {


    @Test(priority = 1, alwaysRun = true)
    public void registration(){
        LOpsReg register = new LOpsReg();
        register.visitRegistrationPage();
        register.setCompanyName();
        register.setDotReg();
        register.setFirstLastname();
        register.setAddressCityZip();
        register.setEmailPassword();
        register.selectSignUp();
        sleep.highWait();
        register.checkRegistration();
       // sleep.highWait();

    }
   @Test(priority = 2, alwaysRun = true)
    public void activationFromMail(){
        LOpsReg register = new LOpsReg();
        register.searchTabClick();
        register.openEmailMailinator();
        register.clickActivationLink();
       sleep.highWait();
    }

    @Test(priority = 3, alwaysRun = true)
    public void loginAndValidate(){
        LOpsReg login = new LOpsReg();
        login.visitQA();
        login.enterCredentials();
        login.clickSignIn();
        sleep.highWait();
    }
}
