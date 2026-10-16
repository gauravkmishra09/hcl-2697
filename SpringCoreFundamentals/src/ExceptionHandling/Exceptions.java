package ExceptionHandling;

public class Exceptions {
    public static void main(String[] args) {
        try{
            int a = 10/0;
            System.out.println("not a valid thing");
        }
        catch(ArithmeticException e ){
            System.out.println("it will not be divided by zero");
        }
        finally {
            System.out.println("will run always");
        }
        System.out.println("program moving forward");
    }
}
