package com.revature.services;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeRepo;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    EmployeeRepo er;

    public EmployeeServiceImpl(EmployeeRepo er){this.er = er;}

    @Override
    public Employee getEmployee(int id) {
        return er.getEmployee(id);
    }

    @Override
    public Employee getEmployee(String username) {
        return er.getEmployee(username);
    }

    @Override
    public List<Employee> getallEmployees() {
        return er.getAllEmployees();
    }

    @Override
    public Employee addEmployee(Employee em) {
        return er.addEmployee(em);
    }

    @Override
    public Employee updateEmployee(Employee change) {
        return er.updateEmployee(change);
    }

    @Override
    public Employee deleteEmployee(int id) {
        Employee em = er.getEmployee(id);

        return er.deleteEmployee(em);
    }
}
