package PracticeSet;

import java.util.Scanner;


public class Asquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of A: ");
        int a = sc.nextInt();
        System.out.println("Enter the value of B: ");
        int b = sc.nextInt();
        double result;
       // result = (int)(a*a)+(b*b)+2*a*b;
        result = Math.pow(a,2)+Math.pow(b,2)+2*a*b;
        int finalResult = (int)result;
        System.out.printf("The result of a+b square is %d", finalResult);

    }
}
