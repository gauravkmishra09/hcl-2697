package org.abesproject.hclhrms.service;

import org.abesproject.hclhrms.entity.Employee;
import org.abesproject.hclhrms.repository.EmoRepoImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmoRepoImp impl;
    public String addEmp(){
        Employee emp1=new Employee(1,"Akash","FSD","java","ak@gmail.com");
        impl.addEmp(emp1);
        return "emp1 gone to EmployeeImpl";
    }
}