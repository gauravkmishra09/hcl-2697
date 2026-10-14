import java.util.Scanner;
public class SwitchExpression {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter day number (1-7): ");
            int day = sc.nextInt();

            String result = switch (day) {
                case 1, 2, 3, 4, 5 -> "Weekday";
                case 6, 7 -> "Weekend";
                default -> "Invalid day";
            };

            System.out.println(result);

            sc.close();
        }
    }