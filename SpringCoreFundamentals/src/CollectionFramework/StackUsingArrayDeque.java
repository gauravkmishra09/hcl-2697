package CollectionFramework;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;


public class StackUsingArrayDeque<T> {




        private final ArrayDeque<T> deque = new ArrayDeque<>();

        // Add to the top
        public void push(T item) {
            deque.addFirst(item);
        }

        // Remove and return the top
        public T pop() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return deque.removeFirst();
        }

        // Return the top without removing it
        public T peek() {
            if (isEmpty()) {
                throw new NoSuchElementException("Stack is empty");
            }
            return deque.peekFirst();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public int size() {
            return deque.size();
        }

        public static void main(String[] args) {
            StackUsingArrayDeque<Integer> stack = new StackUsingArrayDeque<>();

            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Top: " + stack.peek());   // 30
            System.out.println("Popped: " + stack.pop()); // 30
            System.out.println("Popped: " + stack.pop()); // 20
            System.out.println("Size: " + stack.size());  // 1
            System.out.println("Empty? " + stack.isEmpty()); // false
        }
    }


