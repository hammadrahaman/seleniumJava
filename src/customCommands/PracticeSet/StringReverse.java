package PracticeSet;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        String name = "Tuh";
        StringBuilder baigan = new StringBuilder(name);
        System.out.println(baigan);
        String reverse = baigan.reverse().toString();
        System.out.printf("The Name %s is revered to %s", name, reverse);
        StringReverse obj = new StringReverse();
        obj.reverseStringInput();
        obj.reverseStringLoop();

    }

    public StringReverse(){
        String name = "Hammad";
        String reverse= "";
        System.out.println(name.length());
        System.out.println("\n"+name.charAt(0));
        for (int i=name.length()-1;i>=0; i--){
             reverse = reverse+name.charAt(i);

        }
        System.out.println(reverse);
    }

    public void reverseStringInput(){
    Scanner input = new Scanner(System.in);
    System.out.println("\nEnter the word which needs to be reversed: ");
    String word = input.nextLine();
    StringBuilder b = new StringBuilder(word);
    String Reversed = b.reverse().toString();
    System.out.printf("\nThe word ==> %s and the reverse of the word is ==> %s", word, Reversed);
    if(word.equalsIgnoreCase(Reversed)){
        System.out.println("\nThe word is a palindrome:  "+ word);
    } else {
        System.out.println("\nThe word is not a palindrome.");
    }

    }


    public void reverseStringLoop(){
        Scanner input = new Scanner(System.in);
        String reverse = "";
        System.out.println("Enter the word to reverse: ");
        String word = input.nextLine();
        for (int i=word.length()-1; i>=0;i--){
            reverse+=word.charAt(i);

        }
        System.out.printf("\nThe word ==> %s and the reverse of the word is ==> %s", word, reverse);
        if(word.equalsIgnoreCase(reverse)){
            System.out.println("\nThe word is a palindrome:  "+ word);
        } else {
            System.out.println("\nThe word is not a palindrome.");
        }

    }


}
