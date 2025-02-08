package PracticeSet;

import java.util.Scanner;

public class array_factorial {
    public static void main(String[] args) {
      /*  int [] a= {1,2,3,4,5};
        int sum = 1;
        int fact = 5;
        for(int mul: a){
            sum*=mul;  // sum = sum*mul;   1*5     5*4  20*3   60*2  120*1
            System.out.println(sum);
        }*/

        array_factorial arr = new array_factorial();
        arr.factorial();
    }


    public void factorial(){
        Scanner in = new Scanner(System.in);
        double fact = 1;
        System.out.println("Enter the number to get the factorial: ");
        double input = in.nextDouble();
        for(int i=1; i<=input;i++) {
            fact *= i; // fact = fact*i;
            System.out.println(fact);
        }
    }
}
