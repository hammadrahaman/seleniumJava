package PracticeSet;

import java.util.Scanner;
/* ￼(a+2^0*B), (a+2^0*B+a+2^1*b), (a+2^0*B+a+2^1*b+a+2^2*b)...N-1
power in formula would be i and how many times sequence goes.
double formula = a + Math.pow(2, 0) * b;
        System.out.println(formula);

*/
public class LoopsChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=0;
        System.out.println("Enter input terms= "+t);
         t = in.nextInt();

        int n = 0;
        int a = 0;
        int b =0;
        for (int i = 0; i < t; i++) {
            //System.out.println("Enter input a= "+a);
            a = in.nextInt();
             //System.out.println("Enter input b= "+b);
            b = in.nextInt();
             //System.out.println("Enter input n loops n-1= "+n);
            n = in.nextInt();

            for (int x = 0; x < n; x++) {
                int result = a;
                for (int z = 0; z <= x; z++) {
                    //System.out.println("value of x "+ x);
                    result = (int) (result+Math.pow(2, z) * b); // casting to int
                }
                System.out.print(result + " ");
            }

        }


        System.out.println();
       // System.out.println();
        in.close();

    }
}
