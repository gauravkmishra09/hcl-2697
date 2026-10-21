package CollectionFramework;
import java.util.*;

public class QueueClass {
    public static void main(String[] args) {


        Queue<Integer> q = new LinkedList<>();
        q.add(12);
        q.offer(21);
        q.offer(1);
        System.out.println(q.poll());
        q.offer(1);
        System.out.println(q.isEmpty());
        System.out.println(q);

    }
}
