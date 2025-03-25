package PracticeSet.OOPS;

public class OverRiding extends paneer{
    public void butterPaneer(){
        System.out.println("Make food with chicken not paneer");   // This will print.
    }

    public static void main(String[] args) {
        OverRiding or = new OverRiding();
        or.butterPaneer();
    }
}

class paneer{
    void butterPaneer(){
        System.out.println("The paneer food");
    }
}

//
//⚠️ Rule:
//        •	Method name same
//	•	Parameters same
//	•	Return type same