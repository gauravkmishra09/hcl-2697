package org.abesproject.hclhrms.controller;
import org.abesproject.hclhrms.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to HCL HRMS";
    }

    @GetMapping("/addEmp")
    public String addNewEmployee() {
        return employeeService.addEmp();
    }
}