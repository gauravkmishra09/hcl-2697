package com.abes.hrms.model;

import com.abes.hrms.repository.EmpRepo;
import com.abes.hrms.repository.EmpRepoImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {
    @Autowired
    private EmpRepoImp empRepoImp;
    public int add(){
        return empRepoImp.add(30,20);

    }

    public double squareRoot(){
       return empRepoImp.squareRoot(2000);
    }

}
