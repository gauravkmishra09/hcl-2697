package ExceptionHandling;

public class ThrowDemo {

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age 18 se kam hai");   // rule toota, exception phenki
        }
        System.out.println("Vote de sakte ho");
    }

    public static void main(String[] args) {
        try {
            checkAge(15);                                 // yahan exception aayegi
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());   // pakad li
        }
        System.out.println("Program chalta raha");
    }
}
