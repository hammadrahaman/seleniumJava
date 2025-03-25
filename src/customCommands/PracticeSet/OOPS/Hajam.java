package PracticeSet.OOPS;

class Hajam {
    void hairCut(){
        System.out.println("Need a hair cutt..!");
    }


}


public class Inherit extends Hajam {
    void aajaHajam(){
        System.out.println("aaja hajam ke pass");
    }
    @Override
    void hairCut(){
        System.out.println("Hajam says: Let's style your hair!");
    }

    public static void main(String[] args) {
        Hajam hajam = new Hajam();
        hajam.hairCut();
    }
}

