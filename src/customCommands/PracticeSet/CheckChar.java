package PracticeSet;

import java.util.Scanner;

public class CheckChar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the String which you would check: ");
        String i = input.nextLine();
        char first = i.charAt(0);
        System.out.println("\n" + first);
        checkingChar(i, first);

    }

    public static void checkingChar(String c, char first) {
        for (int i = 1; i < c.length(); i++) {
            char value = c.charAt(i);
            if (first == value) {
                System.out.printf("The Character '%c' is repeated more than one time at the place '%d' ==> " , first, i);
                break;
            } else {
                System.out.println("The Character is not repeated ==> " + first);

            }
        }

    }
}