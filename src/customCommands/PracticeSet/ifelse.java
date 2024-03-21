package PracticeSet;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class ifelse {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //System.out.println(N);
            if (N%2==0){
                if (N>=2 && N<=5){
                    //even bracket
                    System.out.println("Not Weird");
                }if (N>=6 && N<=20){
                    System.out.println("Weird");
                }if(N>20){
                    System.out.println("Not Weird");
                }               // even bracket System.out.println("Its an Even Number: "+N);
            } else {
                System.out.println("Weird");
            }
        scanner.close();
    }
}
