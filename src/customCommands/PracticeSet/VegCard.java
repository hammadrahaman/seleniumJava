package PracticeSet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class VegCard {

    public static void sleep_10(){
        {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //driver.quit();
        }
    }

    public static void main(String[] args) {
       int desired_width = 1280;
       int desired_height = 720;
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");//ChromeOptions
        WebDriver driver = new ChromeDriver();
        options.addArguments("--window-size=" + desired_width + "," + desired_height);
        driver.manage().window().maximize();
        driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> carts = driver.findElements(By.xpath("//div[@class='products']//div"));
        System.out.println(carts.size());
        for (WebElement cart : carts) {
            cart.isDisplayed();
        }
        System.out.println("end");
        System.out.println();
        System.out.println();

        List<WebElement> carts2 = driver.findElements(By.xpath("//div[@class='products']/*"));

        for (WebElement checker : carts2) {
            List<WebElement> children = checker.findElements(By.xpath("*"));
            for (WebElement child : children) {
                // Do something with each child element
                System.out.println(child.getText());
                String veg = child.getText();
                if (veg.equals("Carrot - 1 Kg")) {
                    System.out.println("in if else:   " + veg);
                    WebElement parentElement = child.findElement(By.xpath(".."));
                    WebElement addToCartBtn = parentElement.findElement(By.xpath(".//div[@class='product-action']"));
                    String a = addToCartBtn.getText();
                    System.out.println("Check Btn " + a);
                    addToCartBtn.click();
                    driver.findElement(By.cssSelector("a.cart-icon")).click();

                }
            }
        }

        VegCard.sleep_10();
        driver.quit();
    }
}
