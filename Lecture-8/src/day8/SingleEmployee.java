package day8;
public class SingleEmployee {
    //rule 1 make constructor private
    private SingleEmployee(){//constructor

    }
    //rule 2 make static final obj
   static final SingleEmployee obj = new SingleEmployee();// static final so that it belong to clss and never change
    public static SingleEmployee makeInstance(){//function
        return obj;
    }
    public String getMsg(){
        return "Heyy.. i am using java";

    }
}

