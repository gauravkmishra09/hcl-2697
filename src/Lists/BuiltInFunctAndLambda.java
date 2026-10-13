package Lists;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctAndLambda {
    public static void main(String[] args) {

        // ---------- 1. PREDICATE: true/false dene wala ----------
        // Input: Integer (marks), Output: boolean
        // "marks >= 40" true ho to pass, warna fail
        Predicate<Integer> isPass = marks -> marks >= 40;

        // ---------- 2. FUNCTION: ek type se doosra type banana ----------
        // Input: Integer (marks), Output: String (grade)
        // Pehla type = input, doosra type = output
        Function<Integer, String> getGrade = marks -> {
            if (marks >= 90) return "A";     // 90 ya upar = A
            else if (marks >= 75) return "B"; // 75 se 89 = B
            else if (marks >= 40) return "C"; // 40 se 74 = C
            else return "F";                  // 40 se kam = F
        };

        // ---------- 3. SUPPLIER: bina input ke value dena ----------
        // Input: kuch nahi (isliye khali bracket ()), Output: Integer
        // Math.random() 0 se 1 ke beech aata hai, 101 se multiply karke 0-100 marks banaye
        Supplier<Integer> randomMarks = () -> (int) (Math.random() * 101);

        // ---------- 4. CONSUMER: value le kar kaam karna, return kuch nahi ----------
        // Input: String, Output: void
        // Yahan kaam = screen par print karna
        Consumer<String> printer = text -> System.out.println(text);

        // ================= Ab chaaron ko ek saath use karte hain =================

        int marks = randomMarks.get();            // Supplier ka get(): random marks mile

        boolean passed = isPass.test(marks);      // Predicate ka test(): pass hai ya nahi

        String grade = getGrade.apply(marks);     // Function ka apply(): marks se grade mila

        printer.accept("Marks  : " + marks);                          // Consumer ka accept(): print
        printer.accept("Result : " + (passed ? "PASS" : "FAIL"));     // ternary: true ho to PASS
        printer.accept("Grade  : " + grade);

    }
}

