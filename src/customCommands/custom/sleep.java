package custom;

public class sleep {

    public static void lowWait(){
        try
        {
            Thread.sleep(2000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void mediumWait(){
        try
        {
            Thread.sleep(5000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void highWait(){
        try
        {
            Thread.sleep(10000);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
