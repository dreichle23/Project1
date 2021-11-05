package com.revature.repositories;

import com.revature.models.Employee;
import com.revature.models.Grade;

import java.util.List;

public interface EmployeeRepo {
    public Employee getEmployee(int id);
    public Employee getEmployee(String username);
    public List<Employee> getAllEmployees();
    public Employee addEmployee(Employee em);
    public Employee updateEmployee(Employee change);
    public Employee deleteEmployee(Employee em);
}
