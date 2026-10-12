package Lists;



interface Checking{
    boolean check(int n);
}
public class LambdaForOddEven {
    public static void main(String[] args) {
        Checking isEven = n ->n %2 ==0;
        Checking isOdd = n-> n%2 !=0;
        int num = 7;
        System.out.println( num +" even? " + isEven.check(num));
        System.out.println(num +" odd? "+ isOdd.check(num));
    }

}
