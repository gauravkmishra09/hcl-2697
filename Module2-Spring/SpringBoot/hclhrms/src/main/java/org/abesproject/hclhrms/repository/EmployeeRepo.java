package org.abesproject.hclhrms.repository;

import org.abesproject.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {
    public String addEmp(Employee emp);
    String addEmpBulk(<List<Employee> bulkEmp);
    Employee getEmp();
    Employee getEmpById(long empid);
    String deleteById(long empid);
    String updateById(long empid, Employee updatedEmp);
}