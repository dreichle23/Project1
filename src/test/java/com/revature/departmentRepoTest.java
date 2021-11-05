package com.revature;

import com.revature.models.Department;
import com.revature.repositories.DepartmentRepo;
import com.revature.repositories.DepartmentRepoHBImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class departmentRepoTest {
    static DepartmentRepo dr = new DepartmentRepoHBImpl();
    static Department addDepartment = new Department("History", 62);
    static Department updateDepartment = new Department("History", 62);

    static Department deleteDepartment = new Department("History", 62);

    @Test
    public void addDepartmentTest(){
        Department actual = dr.addDepartment(addDepartment);
        addDepartment.setDepartment_id(actual.getDepartment_id());
        Assertions.assertEquals(addDepartment, actual);
    }

    @Test
    public void getAllDepartmentsTest(){
        List<Department> getAll;
        getAll = dr.getAllDepartments();
        Assertions.assertNotNull(getAll);
    }
    @Test
    public void updateDepartmetTest(){
        updateDepartment = dr.addDepartment(updateDepartment);
        Department actual = dr.updateDepartment(updateDepartment);
        Assertions.assertEquals(updateDepartment, actual);
    }
    @Test
    public void deleteDepartmentTest(){
        deleteDepartment = dr.addDepartment(deleteDepartment);
        Department actual = dr.deleteDepartment(deleteDepartment);
        Assertions.assertEquals(deleteDepartment,actual);
    }
    @AfterAll
    public static void deletion(){
        dr.deleteDepartment(updateDepartment);
        dr.deleteDepartment(addDepartment);

    }

}
