package com.revature;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.repositories.DepartmentRepo;
import com.revature.repositories.DepartmentRepoHBImpl;
import com.revature.repositories.EmployeeRepo;
import com.revature.repositories.EmployeeRepoHBImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class EmployeeRepoTests {
    static DepartmentRepo dr = new DepartmentRepoHBImpl();
    static Department d = dr.getDepartment(4);
    static EmployeeRepo er = new EmployeeRepoHBImpl();
    static Employee getEmployee = new Employee("billy", d,"billy@rev", 13, false, "billy", "billy1");
    static Employee addEmployee = new Employee("ned", d,"ned@rev", 13, false, "ned", "ned1");
    static Employee deleteEmployee = new Employee("butcher", d,"butcher@rev", 13, false, "butcher", "butcher1");
    static Employee updateEmployee = new Employee("bute", d,"buter@rev", 13, false, "bute", "bute");
    static Employee getEmployeeName = new Employee("norm", d,"norm@rev", 13, false, "norm", "norm");


    @Test
    public void getEmployeeTest(){
        getEmployee = er.addEmployee(getEmployee);
        Employee actual = er.getEmployee(getEmployee.getEmployeeId());
        Employee expected = actual;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addEmployeeTest(){
        Employee actual = er.addEmployee(addEmployee);
         addEmployee.setEmployeeId(actual.getEmployeeId());
        Assertions.assertEquals(addEmployee, actual);
    }
    @Test
    public void getAllEmployeesTest(){
        List<Employee> actual;
        actual = er.getAllEmployees();
        Assertions.assertNotNull(actual);
    }
    @Test
    public void deleteEmployeeTest(){
        deleteEmployee = er.addEmployee(deleteEmployee);
        Employee actual = er.deleteEmployee(deleteEmployee);
        Assertions.assertEquals(deleteEmployee, actual);
    }
    @Test
    public void updateEmployeeTest(){
        updateEmployee = er.addEmployee(updateEmployee);
        Employee actual = er.updateEmployee(updateEmployee);
        Assertions.assertEquals(updateEmployee, actual);

    }
    @Test
    public void getEmployeeusername(){
        getEmployeeName = er.addEmployee(getEmployeeName);
        Employee actual = er.getEmployee(getEmployeeName.getUsername());
        Employee expected = actual;
        Assertions.assertEquals(expected, actual);
    }
    @AfterAll
    public static void deletion(){
        er.deleteEmployee(updateEmployee);
        er.deleteEmployee(addEmployee);
        er.deleteEmployee(getEmployee);
        er.deleteEmployee(getEmployeeName);
    }
}
