public class Student{
    private String name ;
    private int rollNo;
    private int age;
    private double marks;
    public Student( String name , int rollNo, int age , double marks){
        this.name = name;
        this.rollNo= rollNo;
        this.age= age;
        this.marks = marks;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getRollNo(){
        return rollNo;
    }
    public void setRollNo(int rollNo){
        this.rollNo= rollNo;

    }

    @Override
    public String toString() {
        return "Student{rollNo=" + rollNo + ", name=" + name + "}";
}
}
