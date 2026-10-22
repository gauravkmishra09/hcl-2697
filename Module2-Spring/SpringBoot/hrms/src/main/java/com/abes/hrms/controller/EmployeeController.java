package com.abes.hrms.controller;

import com.abes.hrms.model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private DemoEmployee emp ;

    @GetMapping("/add")
    public int add(){
       return emp.add();
    }
    @GetMapping("/sqrt")
    public double getSquareRoot(){
        return emp.squareRoot();
    }
    @GetMapping("/grt")
    public int grt(){
        return emp.greatest();
    }
}
