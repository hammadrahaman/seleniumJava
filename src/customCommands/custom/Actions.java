package custom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import test.java.Fake;
public class Actions extends Commands{

    private static By register;
    private static By password;
    private static By reTypePassword;
    private static By emailAddress;
    private static By clickRegisterBtn;
    private static By loginBtn;
    private static By loginEmail;
    private static By loginBtn2;
    private static By dot;
    private static By loadEmail;

    private static By loadPassword;

    protected final String email= Fake.fake("email");
    public static  String email2;

    public Actions(){
        super(driver);
        register = By.xpath("//a[normalize-space()='Register']");
        password = By.xpath("(//input[@id='floatingPassword'])[1]");
        reTypePassword = By.xpath("(//input[@id='floatingPassword'])[2]");
        emailAddress = By.cssSelector("#floatingInput");
        clickRegisterBtn = By.cssSelector(".d-grid");
        loginBtn = By.cssSelector("a[class='nav-link login']");
        loginEmail = By.cssSelector("#floatingInput");
        loginBtn2 = By.xpath("//button[normalize-space()='Login to QTrip']");
        email2 = email;
        dot = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1n7222t'])[1]");
        loadEmail = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1n7222t'])[2]");
        loadPassword = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1n7222t'])[3]");

    }

    public void enterEmail(){
        System.out.println(email);
        setText(loginEmail, email);
    }

    public void enterPassword(){
        setText(password, "National@1");
    }

    public void reEnterPassword(){
        setText(reTypePassword, "National@1");
    }

    public void registerBtn(){
        waitClick(clickRegisterBtn);
    }

    public  void registerPage(){

        waitClick(register);
    }

    public void visitLoginPage(){
            assertElementVisible(loginBtn);
            waitClick(loginBtn);
            sleep.mediumWait();
    }


    public void visitLoginUrl(){

        driver.navigate().to("https://qtripdynamic-qa-frontend.vercel.app/pages/login/");
    }
    public void loginToAccount(){
        waitClick(loginBtn2);
    }

    public void enterEmailLogin(){
        setText(emailAddress, email2);
    }

    public void qaLoad(){
        System.out.println("The driver: "+ driver);
         setText(dot, "9040");
         setText(loadEmail,"ham@mailinator.com");
         setText(loadPassword, "National@1");
        sleep.mediumWait();
    }

}
