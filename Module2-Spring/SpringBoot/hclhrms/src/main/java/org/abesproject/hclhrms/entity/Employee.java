package org.abesproject.hclhrms.entity;
public class Employee {
    private long emp_id;
    private String emp_name;
    private String designation;
    private String progStack;
    private String email;

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getProgStack() {
        return progStack;
    }
    public void setProgStack(String progStack) {
        this.progStack = progStack;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Employee(long emp_id, String emp_name, String designation, String progStack, String email) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.designation = designation;
        this.progStack = progStack;
        this.email = email;
    }

}