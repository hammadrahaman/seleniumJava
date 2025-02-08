package PracticeSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;




public class array_biggestNumber {
    public static void main(String[] args) {
        array_biggestNumber obj = new array_biggestNumber();
       // obj.array_inputMethod();
        obj.desendingOrder();

    }

    public array_biggestNumber() {
    //    int[] arr = {10, 20, 30, 40, 50};

       // int[] array = new int[5];
      int[]  array= {1998, 20, 30, 1999, 2000};
      int max = array[0];
      int secondLargest = array[0];
      for(int i =1; i<array.length; i++ ){

          if(array[i]>max){
              secondLargest = max;   // second largest
              max = array[i];
          }

      }
        System.out.printf("The second largest element ==> %d", secondLargest);
        System.out.printf("The largest number in array ==> %d", max);
    }


    public void array_inputMethod(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the size of array: ");
        int n = input.nextInt();

        int [] arr = new int[n];
        System.out.println("\nEnter the array items");

        for(int i=0; i<arr.length;i++){
            arr[i] = input.nextInt();
        }

        int max = arr[0];
        int secondLargest = arr[0];
        for(int i =1; i<arr.length; i++ ){

            if(arr[i]>max){
                secondLargest = max;   // second largest
                max = arr[i];
            }

        }
        System.out.printf("\nThe second largest element ==> %d", secondLargest);
        System.out.printf("\nThe largest number in array ==> %d", max);

    }


public void desendingOrder(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the size of array: ");
        int n = input.nextInt();
    ArrayList<Integer> d_sort = new ArrayList<Integer>();

        int [] arr = new int[n];
        System.out.println("\nEnter the array items");

        for(int i=0; i<arr.length;i++){
            arr[i] = input.nextInt();
        }

        int max = arr[0];
        int secondLargest = arr[0];
        for(int i =1; i<arr.length; i++ ){

            if(arr[i]>max){
                secondLargest = max;   // second largest
                max = arr[i];
                d_sort.add(arr[i]);
            }

        }
        System.out.printf("\nThe second largest element ==> %d", secondLargest);
        System.out.printf("\nThe largest number in array ==> %d", max);

    Collections.sort(d_sort, Collections.reverseOrder());
        for(int a: d_sort){
            System.out.println("\nsorted reverse: "+a);
        }

    }
}



