package com.revature.repositories;

import com.revature.models.Department;
import com.revature.models.Grade;

import java.util.List;

public interface DepartmentRepo {
    public Department getDepartment(int id);
    public List<Department> getAllDepartments();
    public Department addDepartment(Department d);
    public Department updateDepartment(Department change);
    public Department deleteDepartment(Department d);
}
