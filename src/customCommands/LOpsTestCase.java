import custom.LOpsReg;
import custom.sleep;
import maj.utility;
import org.testng.annotations.Test;

public class LOpsTestCase extends utility {


    @Test(priority = 0, alwaysRun = true)
    public void registration(){
        LOpsReg register = new LOpsReg();
        register.visitRegistrationPage();
        register.setCompanyName();
        register.setDotReg();
        register.setFirstLastname();
        register.setAddressCityZip();
        register.setEmailPassword();
        register.selectSignUp();
        sleep.mediumWait();
        register.checkRegistration();
       // sleep.highWait();

    }
   @Test(priority = 0, alwaysRun = true)
    public void activationFromMail(){
        LOpsReg register = new LOpsReg();
        register.searchTabClick();
        register.openEmailMailinator();
        register.clickActivationLink();
       String fakeDot = register.fakeDot;
       System.out.println(" from second test: "+fakeDot);
       // System.out.println();
       sleep.highWait();
    }
}
