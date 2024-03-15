package custom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import test.java.Fake;


public class LOpsReg extends Commands {

    private static By companyName;
    private static By dotReg;
    private static By firstName;
    private static By lastName;
    private static By address;
    private static By city;
    private static By zip;
    private static By emailReg;
    private static By passwordReg;
    private static By signUp;

    private static By verification;
    private static String fakeCompanyName = Fake.fake("company");
    private static String fakeFirstName = Fake.fake("first name");

    private static String fakeLastName = Fake.fake("last name");

    public static final String fakeDot= Fake.fake("dot");

    private static String fakeZip = Fake.fake("zip");

    private static String fakeCity = Fake.fake("city");

    private static String fakeAddress = Fake.fake("address");

    private static String validationMessage = "Complete Verification";

   private static By searchMailinatorEmail ;
   private static By clickSearch;
   private static By selectEmailMailinator;
    private static By dot;
    private static By loadEmail;
private static By loginBtn;
    private static By loadPassword;
    private static By activationBtn;


    public LOpsReg(){
        super(driver);
        verification = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1t4hfgp']");
        companyName = By.cssSelector("input[name='organizationName']");
        dotReg = By.cssSelector("input[name='dot']");
        firstName = By.cssSelector("input[name='firstName']");
        lastName =By.cssSelector("input[name='lastName']");
        address = By.xpath("//input[@name='address']");
        city = By.cssSelector("input[name='city']");
        zip = By.cssSelector("input[name='zipcode']");
        emailReg= By.cssSelector("input[name='email']");
        passwordReg = By.cssSelector("input[name='password']");
        signUp = By.xpath("//button[normalize-space()='Sign Up']");
        searchMailinatorEmail = By.cssSelector("input#search-mobile");
        clickSearch = By.xpath("//button[@aria-label='Search for inbox']");
        selectEmailMailinator = By.xpath("//td[normalize-space()='Welcome to LoadOps!']");
        loginBtn = By.cssSelector("button#login-btn");
        dot = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1n7222t'])[1]");
        loadEmail = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1n7222t'])[2]");
        loadPassword = By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1n7222t'])[3]");
    activationBtn=     By.xpath("//a[@class='link_text']");

    }


    public void setCompanyName(){
        setText(companyName, fakeCompanyName);
    }

    public void setDotReg(){
        setText(dotReg, fakeDot);
        System.out.println(fakeDot);
    }

    public void setFirstLastname(){
        setText(firstName, fakeFirstName);
        setText(lastName,fakeLastName);

    }

    public void setAddressCityZip(){
        setText(address,fakeAddress);
        setText(city, fakeCity);
        setText(zip, fakeZip);
    }

    public void setEmailPassword(){
        setText(emailReg, "nick13@mailinator.com");
        setText(passwordReg, "tarzan@1");
    }

    public void selectSignUp(){
        waitClick(signUp);
    }

    public void visitRegistrationPage(){
        driver.navigate().to("https://qa.loadops.com/registration");
    }

    public void checkRegistration(){
        Assertion checker = new Assertion();
        checker.verificationeMessage(verification, validationMessage, "The message doesn't match");
    }



    public void searchTabClick(){
        driver.navigate().to("https://www.mailinator.com/v4/public/inboxes.jsp?msgid=nick13-1710265710-833874011&to=nick13");
      /*  setText(searchMailinatorEmail, "nick13@mailinator.com");
        waitClick(clickSearch); */
    }

    public void openEmailMailinator(){
        waitClick(selectEmailMailinator);
    }

    public void clickActivationLink(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -500);");
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#html_msg_body")));// switching to iframe
        js.executeScript("window.scrollBy(0, -500);");
        waitClick(activationBtn);

    }

    public void visitQA(){
        driver.navigate().to("https://qa.loadops.com/");
    }

    public  void enterCredentials(){
        setText(dot, fakeDot);
        setText(loadEmail,"nick13@mailinator.com");
        setText(loadPassword, "tarzan@1");
        sleep.mediumWait();
    }

    public void clickSignIn(){
        waitClick(loginBtn);
    }
}
