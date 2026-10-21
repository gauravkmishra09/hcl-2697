package Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 1. Student class: Comparable implement karti hai (andar ka rule)
class Student implements Comparable<Student> {
    String name;
    int rollNo;
    int age;

    Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.rollNo, other.rollNo);
    }

    @Override
    public String toString() {
        return rollNo + "-" + name + "-" + age;
    }
}

// 2. Comparator ki alag class (bahar ka rule: age)
class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(a.age, b.age);
    }
}

// 3. Main class: file ke naam wali public class
public class Comparable_Comparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Amit", 103, 22));
        list.add(new Student("Gaurav", 101, 21));
        list.add(new Student("Riya", 102, 19));
        System.out.println("Original : " + list);

        Collections.sort(list);
        System.out.println("RollNo   : " + list);

        list.sort(new AgeComparator());
        System.out.println("Age      : " + list);

        list.sort((a, b) -> a.name.compareTo(b.name));
        System.out.println("Name     : " + list);
    }
}