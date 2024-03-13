package PracticeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();
        System.out.println(N);
        for(int i=1;i<=10;i++){
            int mul = N*i;
            System.out.println(N+" X "+" "+i+" = "+mul);
        }

    }
}
