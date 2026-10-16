package Module1_Program;

public class Solution2 {
    interface A2 {
        void m1();
        void m2();
    }

    static class B implements A2 {
        public void m1() {
            System.out.println("world");
        }
        public void m2() {
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {
        A2 obj = new B();
        obj.m1();
        obj.m2();
    }
}