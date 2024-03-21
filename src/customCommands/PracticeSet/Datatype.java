package PracticeSet;
import java.util.Scanner;

public class Datatype {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Read number of test cases
        long t = in.nextLong();

        // Consume newline character after reading int
        in.nextLine();

        // Loop over each test case
        for (int i = 0; i < t; i++) {
            try {
                // Read input number as a long
                long num = Long.parseLong(in.nextLine()); // Input number

                // Print the input number and determine which data types it can fit into
                System.out.println();
                System.out.println(num + " can be fitted in:");
                if (num >= Byte.MIN_VALUE && num <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                if (num >= Short.MIN_VALUE && num <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                if (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                if (num >= Long.MIN_VALUE && num <= Long.MAX_VALUE) {
                    System.out.println("* long");
                }
            } catch (NumberFormatException e) {
                // If input cannot be parsed as a long, print that it can't be fitted anywhere
                System.out.println(" can't be fitted anywhere.");
            }
        }

        // Close the scanner
        in.close();
    }
}
