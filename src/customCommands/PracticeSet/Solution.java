package PracticeSet;

import java.util.Scanner;

/*java           100
cpp            065
python         050 */

public class Solution {
    public static void main(String[] args) {Scanner sc=new Scanner(System.in);
      /*  System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.println(s1+" "+ x);
            sc.nextLine();
            String s2 = sc.next();
            double d=  sc.nextDouble();
            System.out.println(s2+" "+ d);
            sc.nextLine();
            long p = sc.nextLong();
            String s3 = sc.next();

            System.out.println(s3+" "+p);
            sc.nextLine();
            //Complete this line
        }
        System.out.println("================================");*/


        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            //System.out.printf("%n");
            System.out.printf("%-15s%03d%n", s1, x);

            //Complete this line
        }
        System.out.println("================================");

    }
}
