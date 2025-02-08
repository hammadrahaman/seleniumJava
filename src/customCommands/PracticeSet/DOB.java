package PracticeSet;

import java.util.Scanner;

public class DOB {

     void tasmiyaDOB(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the DOB in year: ");
        int a = in.nextInt();
        System.out.println("Enter the current year: ");
        int b = in.nextInt();
        int age = b-a;
        System.out.println("Your actual age is: "+age);

    }
    public static void main(String[] args) {

        DOB a = new DOB();
        a.tasmiyaDOB();
    }
}
