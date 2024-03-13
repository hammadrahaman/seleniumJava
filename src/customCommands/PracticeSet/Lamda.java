package PracticeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;
import java.util.List;

public class Lamda {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
       List<WebElement> veg =  driver.findElements(By.xpath("//tbody/tr/td[1]"));
        LinkedList<WebElement> vegitables = new LinkedList<>();
        vegitables.addAll(veg);
        System.out.println("The vegies: "+vegitables);
        for(WebElement a: vegitables ){
          String vegName =  a.getText();
            System.out.println();
            System.out.println(vegName);
            if(vegName.equals("Tomato")){
              String tomatoPrice = driver.findElement(By.xpath("(//td[contains(text(),'37')])[1]")).getText();
              String tomatoDisc = driver.findElement(By.xpath("//td[normalize-space()='26']")).getText();
                System.out.printf("The price of tomato is %s and discount is %s ", tomatoPrice, tomatoDisc);

            }
        }


        vegitables.stream()
                .map(WebElement::getText)
                .peek(System.out::println)
                .filter(vegName -> vegName.equals("Tomato"))
                .findFirst()
                .ifPresent(ignored -> {
                    String tomatoPrice = driver.findElement(By.xpath("(//td[contains(text(),'37')])[1]")).getText();
                    String tomatoDisc = driver.findElement(By.xpath("//td[normalize-space()='26']")).getText();
                    System.out.printf("The price of tomato is %s and discount is %s from stream:  ", tomatoPrice, tomatoDisc);
                });



        driver.close();
    }
}
