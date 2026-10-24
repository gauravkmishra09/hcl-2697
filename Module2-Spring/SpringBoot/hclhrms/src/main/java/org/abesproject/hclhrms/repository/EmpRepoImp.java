package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpRepoImp implements EmployeeRepo {
    List<Employee> emplist=new ArrayList<>();

    @Override
    public String addemp(Employee emp) {
        emplist.add(emp);
        return "Employoee Addedd successfully";
    }

    @Override
    public String addEmpbulk() {
        List <Employee> employeesList=List.of(new Employee(890,"Ram","Test Engineer","java","abc@gmail.com"),new Employee(891,"Amit","Test Engineer","java","amit@gmail.com"));
        emplist.addAll(employeesList);
        return "All employees added";
    }

    @Override
    public List<Employee> getEmp() {
        return emplist;
    }

    @Override
    public Employee getEmpById(long empid) {
        return  emplist.stream().filter(e->e.getEmp_id()==empid).findFirst().orElse(null);

    }

    @Override
    public String deleteById(long empid) {



        return "";
    }

    @Override
    public String updateById(long empid, Employee updatedEmp) {


        return "";
    }
}