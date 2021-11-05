package com.revature.services;

import com.revature.models.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployee(int id);
    public Employee getEmployee(String username);
    public List<Employee> getallEmployees();
    public Employee addEmployee(Employee em);
    public Employee updateEmployee(Employee change);
    public Employee deleteEmployee(int id);

}
