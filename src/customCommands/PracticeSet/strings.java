package PracticeSet;

public class strings {
    public static void main(String[] args) {
        String name = "Hammad";
        strings s = new strings(name);
        s.startWith(name);
        s.findinDexof(name);
        s.lastIndexof(name);




    }

    public strings(String name){
        System.out.print("endsWith: ");
        System.out.println(name.endsWith("d")); // true
    }

    public void findinDexof(String b){
        System.out.print("findinDexof: ");
      int a=  b.indexOf("d");
        System.out.println(a);
    }


    public void lastIndexof(String name){
        System.out.print("lastIndexof: ");
        int a = name.lastIndexOf("a");
        System.out.println(a);

    }

    public void startWith(String name){
        Boolean startWith = name.startsWith("h");
        System.out.println(startWith); //false lower cases
    }



}
