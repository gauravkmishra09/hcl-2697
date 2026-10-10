package CollectionFramework;
import java.util.*;
public class LinkedHashMap {
    public static void main(String[] args) {
        Map<String,Integer> marks = new java.util.LinkedHashMap<>();
        marks.put("MOHIT", 80);
        marks.put("VINEET", 78);
        marks.put("RAVI",91);
        System.out.println(marks);
        System.out.println("ravi marks:" +marks.get("RAVI"));

    }
}
