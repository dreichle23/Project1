package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    private String department_name;

    @Column(name = "department_head_id")
    private int departmentHeadId;

    public Department() {
    }

    public Department(int department_id, String department_name, int departmentHeadId) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.departmentHeadId = departmentHeadId;
    }

    public Department(String department_name, int departmentHeadId) {
        this.department_name = department_name;
        this.departmentHeadId = departmentHeadId;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getDepartmentHeadId() {
        return departmentHeadId;
    }

    public void setDepartmentHeadId(int departmentHeadId) {
        this.departmentHeadId = departmentHeadId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "department_id=" + department_id +
                ", department_name='" + department_name + '\'' +
                ", departmentHeadId=" + departmentHeadId +
                '}';
    }
}
