package Module1_Program;

public class Interface {

    interface A {
        void m1();
        void m2();
    }

    static class B implements A {
        public void m1() {
            System.out.println("world");
        }
        public void m2() {
            System.out.println("hello");
        }
    }

    static class C implements A {
        public void m1() {
            System.out.println("C: m1");
        }
        public void m2() {
            System.out.println("C: m2");
        }
    }

    public static void main(String[] args) {
        A[] objs = { new B(), new C() };
        for (A obj : objs) {
            obj.m1();
            obj.m2();
        }
    }
}