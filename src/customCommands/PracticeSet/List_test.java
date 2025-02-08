package PracticeSet;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class List_test {



    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(20);
        a.add(30);
        a.add(40);
        a.add(50);
        a.forEach(ab->{
            System.out.println(ab);
        });

    }
}
