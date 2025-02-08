package PracticeSet;

public class rows {

    public static void main(String[] args) {

    rows obj = new rows();
    obj.reversePattern(5);
     
    obj.pattern1(5);
    }

    public void pattern(int n){
        for(int i=1; i<=n;i++){
            for(int j=1; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern1(int n){
        for(int i=n; i>=n;i--){
            for(int j=1; j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public void reversePattern(int n){
        for(int i=1; i<=n;i++){
            for (int space = 1; space <= n - i; space++) { // Inner loop for spaces
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){   // 5 5<1  5
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
