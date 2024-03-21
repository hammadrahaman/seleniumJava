package PracticeSet;

import custom.Assertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.LinkedList;

public class CardList {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/shop");

        // Locate the app-card-list element
        WebElement cardList = driver.findElement(By.tagName("app-card-list"));

        LinkedList<String> productName = new LinkedList<>();
        productName.add("iphone X");
        productName.add("Samsung Note 8");
        productName.add("Nokia Edge");
        productName.add("Blackberry");


        // Find all child elements (cards) within the app-card-list
        List<WebElement> cards = cardList.findElements(By.tagName("app-card"));
        for(int i=0;i<productName.size();i++){
            String product = productName.get(i);
            if(product.equals("Blackberry")){
                System.out.println();
                break;
            }
            System.out.println();
            String card = (cards.get(i).getText());
            System.out.println(product+" "+card);
            Assert.assertTrue(card.contains(product), "doesn't contains thr product name");
        }


        // Assert that there are at least some cards present


        // Close the browser
        driver.quit();
    }
}

