package PracticeSet;

import javax.script.ScriptEngine;
import java.util.Arrays;
import java.util.Scanner;

public class FindLetters {
    public static void main(String[] args) {
        check();
      //  checkSort();
     /*   factorial(7);
        String nor = "level";
        String rev = reserveString(nor);
        checkPalindromes(nor, rev);*/

    }


    public static void check(){
        char[] a = {'a', 'c', 'd','b' };
     //   System.out.println(a[3]);
         String b= Arrays.toString(a);
        System.out.println(b);
    }


    public static  String reserveString(String normal){
        String reversed="";
        for(int a = normal.length()-1; a>=0;a--){
            reversed += normal.charAt(a);
        }
        System.out.println("\nThe reversed String ==> "+ reversed);
        return reversed;
    }

    public static void checkPalindromes(String word, String rev){
        if(word.equalsIgnoreCase(rev)){
            System.out.println("Its a palindrome");
        } else {
            System.out.println("Its not a palindrome");
        }
    }

    public static  void factorial(int n ){
        int fact =1;
        for(int a= n ; a>1;a--){
             fact = a*fact;

        }
        System.out.println("The final factorial ==> "+ fact);
    }

    public void findingLetters(){
        int count = 0;
        Scanner enter = new Scanner(System.in);
        String a = enter.nextLine();
        System.out.println();
        String findValue = enter.nextLine();
        char target = findValue.charAt(0);
        System.out.printf("\nThe entered String is %s and finding the letter is %c ==> ", a, target);
        for(int x=a.length()-1; x>=0;x-- ){
            if (a.charAt(x)==target){
                count++;
            }

        }
        System.out.println("\nThe letter repeated is ==>"+ count);

    }


    public static void checkSort(){
        char a[]= {'a', 'c', 'd','b' };
        Arrays.sort(a);
        String val1 ="";
        for (char x :a){
        //    System.out.print(x);
            val1+= x;

        }
        System.out.print(val1);
    }
}
