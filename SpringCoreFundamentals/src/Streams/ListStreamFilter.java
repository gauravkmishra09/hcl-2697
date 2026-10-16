package Streams;
import java.util.ArrayList;
import java.util.List;


public class ListStreamFilter {
    public static void main(String[] args) {
       List<Integer> nums = new ArrayList<>();
       nums.add(5);
       nums.add(12);
       nums.add(8);
       nums.add(21);
       nums.add(30);
       nums.add(7);
        System.out.println("original :"+ nums);

        //list and filter of number >10//
        List<Integer> bigger = nums.stream().filter(n  -> n>10).toList();
        System.out.println("bigger than 10 :" + bigger);
         //NEW FILTER OF EVEN NUMBER//
        List<Integer> evens = nums.stream().filter( n -> n%2==0).toList();
        System.out.println("even :" + evens);

        System.out.println("Original list:" + nums);
    }
}
