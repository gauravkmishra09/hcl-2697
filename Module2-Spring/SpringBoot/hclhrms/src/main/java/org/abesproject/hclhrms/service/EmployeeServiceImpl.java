package org.abesproject.hclhrms;

import org.abesproject.hclhrms.entity.Employee;
import org.abesproject.hclhrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmpRepoImp emprepo;
    Employee emp1=new Employee(200l,"Rahul","FSD","Java","ptomer40@yahoo.com");

    public String addEmp(){
        //Employee emp1=new Employee(200l,"Rahul","FSD","Java","ptomer40@yahoo.com");
        return emprepo.addemp(emp1);
    }

    public List<Employee> getEmp(){
        return emprepo.getEmp();
    }

    public Employee getEmpById(){
        return  emprepo.getEmpById(2001);
    }


    public String addBulkEmp(){
        return  emprepo.addEmpbulk();
    }


}