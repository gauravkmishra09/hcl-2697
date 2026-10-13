package Lists;

import java.sql.SQLOutput;

class Box<T>{
    private T value;
    Box(T value){
        this.value = value;
    }
    T getValue(){
        return value;
    }
}

public class GenericClassFull {
    public static void main(String[] args) {
        Box<String> b1 = new Box<>("java");
        Box<Integer> b2 = new Box<>(100);
        System.out.println(b1.getValue());
        System.out.println(b2.getValue());
    }

}
