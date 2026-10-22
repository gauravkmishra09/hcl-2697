package Streams;
import java.util.ArrayList;
import java.util.List;

public class StringStreamFilter {
    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("Ramesh");
        ls.add("Suresh");
        ls.add("Gaurav");
        ls.add("Aman");
        ls.add("Sumit");
        ls.add("Ayush");
        ls.add("Tushar");
        ls.add("Ranbir");
        System.out.println("Original :" + ls);

        List<String> StartR = ls.stream().filter( w-> w.startsWith("R")).toList();
        System.out.println(" Words starting from R :" + StartR);

        List<String> EndsT = ls.stream().filter( w-> w.endsWith("t")).toList();
        System.out.println("Words ends with T :" + EndsT);

        //either of them
        List<String> Anything = ls.stream().filter(w -> w.startsWith("R") || w.endsWith("T")).toList();
        System.out.println("any of them true :" + Anything);




    }
}
