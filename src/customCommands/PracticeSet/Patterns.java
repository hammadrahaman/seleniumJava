package PracticeSet;

public class Patterns {

    public static void main(String[] args) {
        Patterns obj = new Patterns();
        obj.pyramid(4);
        System.out.println();
        obj.triangle(4);
        obj.halfTriangle();
    }

    public void halfTriangle(){
        int row= 5;
        for(int i=1;i<=5;i++){
           for (int f=1;f<i;i++){
                System.out.print("*");
            }
            for (int col=1;col<i;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public void triangle(int n){
        for(int row=1;row<=n; row++){
            for(int space=n;space>row;space--){
                System.out.print(" ");
            }
            for(int col=1;col<=row;col++){
             System.out.print("*");
         }
            for (int t=1;t<row;t++){
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public void pyramid(int rows){
       // Number of rows for the triangle

        for (int i = 1; i <= rows; i++) {
            // Print spaces for alignment
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }

            // Move to the next line
            System.out.println();
        }
    }
}
