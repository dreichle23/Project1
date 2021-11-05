package com.revature.app;

import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.models.Grade;
import com.revature.models.ReimburseFile;
import com.revature.repositories.*;

public class RepoHBTest {
    public static void main(String[] args) {
        EmployeeRepo er = new EmployeeRepoHBImpl();
        DepartmentRepo dr = new DepartmentRepoHBImpl();
        GradeRepo gr = new GradeRepoHBImpl();
        StatusRepo sr = new StatusRepoHBImpl();
        ReimbursementForm rr = new ReimbursementFormRepoHBImpl();

        System.out.println(rr.getForm(1));
        Employee e = new Employee();
        Department d = dr.getDepartment(1);
        Grade g = gr.getGrade(2);


        e = er.getEmployee(1);

        ReimburseFile rf = new ReimburseFile(5668, 909090, 909090, "USC", "Java training", 700, "Course", g,e);

        //rf = rr.addForm(rf);
        System.out.println(rf);





        System.out.println(e);
        Employee e2 = new Employee("Sarah Polski", d, "polski@rev.net", 1, false, "polski1", "sarahpolski");

        //er.addEmployee(e2);
        System.out.println(e2);



    }
}
