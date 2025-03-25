package PracticeSet.DSA;

public class ArrayChallenge {
    int[] arr = {2, 2, 2, 2, 2};
    int target = 2;
// Output: First = 0, Last = 4

    public void searchArray(){
/*
        Use one for loop (you can go forward or backward)
	•	Don’t use Java functions like indexOf() or lastIndexOf() — pure logic chahiye 💪
	•	If target doesn’t exist, print: "Target not found"

    •	Agar target ek hi baar milta hai, toh first and last index dono same print hone chahiye
	•	Agar target nahi milta, toh "Target not found" print hona chahiye.

	*/
            boolean found = false;
            int  storeFoundedValue=0;
            int lastIndex=0;
            int firstIndex=0;
            for (int x = 0;x<=arr.length-1;x++){
                if (arr[x]==target){
                    storeFoundedValue++;
                    if (storeFoundedValue==1){
                        firstIndex=x;
                        lastIndex =x;
                    } else if (storeFoundedValue>1) {
                        lastIndex=x;
                    }
                    found=true;
                }
            }

            if (!found) {
                System.out.println("Target not found");
            }
            else {
                System.out.printf("First index of target: %d\n", firstIndex);
                System.out.printf("Last index of target: %d\n", lastIndex);
            }
    }

    public static void main(String[] args) {
        ArrayChallenge array = new ArrayChallenge();
        array.searchArray();  //
        array.insertValueAtIndexTwo();
        System.out.println("__________________");
        array.addFiveElementsArray();
        System.out.println("__________________");
        array.deleteValueAtIndexTwo();
        System.out.println("__________________");
        array.addFiveElementsArray();
    }

    public void insertValueAtIndexTwo(){
        for (int x=3 ;x>= 2; x-- ){
            a[x+1]= a[x];
            System.out.println(a[x+1]);
        }
        a[2]= 25;
    }

    int [] a = {1, 4, 89, 9, 87};
    public void deleteValueAtIndexTwo(){
        for (int x= 2; x< a.length-1;x++ ){
          a[x] =    a[x+1];
        }
        a[a.length - 1] = 0;
        for (int x : a){
            System.out.println(x);
        }

    }



    public void addFiveElementsArray(){
        for (int x : a){
            System.out.println(x);
        }
    }



}
