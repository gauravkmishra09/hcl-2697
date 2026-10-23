package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class EmpRepoImp implements EmployeeRepo{
    List<Employee> empList=new ArrayList<>();
    @Override
    public String addEmp(Employee emp) {
        empList.add(emp);
        return "Added";
    }
    @Override
    public String addEmpbulk(List<Employee> bulkEmp){
        List<Employee> emplist = List.of(new Empl)

    }

    @Override
    public String addEmpBulk(List<Employee> bulkEmp) {
        return "";
    }

    @Override
    public Employee getEmp() {
        return null;
    }

    @Override
    public Employee getEmpById(long empid) {
        return null;
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
