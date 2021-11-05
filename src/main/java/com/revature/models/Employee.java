package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "Employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employee_name")
    private String name;

   // @Column(name = "employee_department")
    @ManyToOne
    @JoinColumn(name = "employee_department")
    private Department department;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "direct_supe")
    private int dsId;

    @Column(name = "benefits_coord")
    private boolean benCo;
    private String password;
    private String username;

    public Employee() {
    }

    public Employee(int employeeId, String name, Department department, String emailAddress, int dsId, boolean benCo, String password, String username) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.emailAddress = emailAddress;
        this.dsId = dsId;
        this.benCo = benCo;
        this.password = password;
        this.username = username;
    }

    public Employee(String name, Department department, String emailAddress, int dsId, boolean benCo, String password, String username) {
        this.name = name;
        this.department = department;
        this.emailAddress = emailAddress;
        this.dsId = dsId;
        this.benCo = benCo;
        this.password = password;
        this.username = username;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getDsId() {
        return dsId;
    }

    public void setDsId(int dsId) {
        this.dsId = dsId;
    }

    public boolean isBenCo() {
        return benCo;
    }

    public void setBenCo(boolean benCo) {
        this.benCo = benCo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", dsId=" + dsId +
                ", benCo=" + benCo +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
