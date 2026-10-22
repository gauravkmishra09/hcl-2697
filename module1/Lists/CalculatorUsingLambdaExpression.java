package Lists;
interface Calculator { //interface
    int calculate(int a, int b);//method
}

public class CalculatorUsingLambdaExpression {

    public static void main(String[] args) {

        int x = 20, y = 6;

        // 1. Addition
        Calculator add = (a, b) -> a + b;

        // 2. Subtraction
        Calculator sub = (a, b) -> a - b;

        // 3. Multiplication
        Calculator mul = (a, b) -> a * b;

        // 4. Division (integer)
        Calculator div = (a, b) -> a / b;

        // 5. Remainder (modulus)
        Calculator mod = (a, b) -> a % b;

        // 6. Maximum
        Calculator max = (a, b) -> a > b ? a : b;

        // 7. Minimum
        Calculator min = (a, b) -> Math.min(a, b);

        // 8. Power (a ki power b)
        Calculator pow = (a, b) -> (int) Math.pow(a, b);

        // 9. Average (integer)
        Calculator avg = (a, b) -> (a + b) / 2;

        // 10. Difference (hamesha positive)
        Calculator diff = (a, b) -> Math.abs(a - b);

        System.out.println("Add      : " + add.calculate(x, y));
        System.out.println("Sub      : " + sub.calculate(x, y));
        System.out.println("Mul      : " + mul.calculate(x, y));
        System.out.println("Div      : " + div.calculate(x, y));
        System.out.println("Mod      : " + mod.calculate(x, y));
        System.out.println("Max      : " + max.calculate(x, y));
        System.out.println("Min      : " + min.calculate(x, y));
        System.out.println("Power    : " + pow.calculate(2, 5));
        System.out.println("Average  : " + avg.calculate(x, y));
        System.out.println("Diff     : " + diff.calculate(y, x));
    }
}

