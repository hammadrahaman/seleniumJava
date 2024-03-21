package PracticeSet;

public class interfacce {

    public static void main(String[] args) {
        vegColor col = new vegColor();
        col.chiliColor();
        col.eggPlant();
    }
}


interface veg{
    void chiliColor();
    void eggPlant();

}

class vegColor implements veg{

    @Override
    public void chiliColor() {
        String color = "red";
        System.out.println(color);
    }

    @Override
    public void eggPlant() {
        String color = "blue";
        System.out.println(color);

    }
}
