package com.revature;

import com.revature.models.*;
import com.revature.repositories.*;
import com.revature.services.ReimbursementServices;
import com.revature.services.ReimbursementServicesImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReimbureServicesTests {
    static DepartmentRepo dr = new DepartmentRepoHBImpl();
    static Department d = dr.getDepartment(4);
    static EmployeeRepo er = new EmployeeRepoHBImpl();
    static Employee em = er.getEmployee(20);
    static GradeRepo gr = new GradeRepoHBImpl();
    static Grade g = gr.getGrade(1);
    static StatusRepo sr = new StatusRepoHBImpl();
    static Status s = sr.getStatus(1);
    static ReimbursementForm rf = new ReimbursementFormRepoHBImpl();
    static ReimbursementServices rs = new ReimbursementServicesImpl(rf);
    static ReimburseFile addForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);
    static ReimburseFile updateForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);
    static ReimburseFile deleteForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);
    static ReimburseFile getForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);

    @Test
    public void addFormTest(){
        ReimburseFile actual = rs.addFile(addForm);
        addForm.setFileId(actual.getFileId());
        Assertions.assertEquals(addForm, actual);

    }
    @Test
    public void getFormTest(){
        getForm = rf.addForm(getForm);
        ReimburseFile actual = rs.getFile(getForm.getFileId());
        ReimburseFile expected = actual;

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void getAllFormsTest(){
        List<ReimburseFile> getAll;
        getAll = rs.getAllFiles();

        Assertions.assertNotNull(getAll);
    }
    @Test
    public void deleteFormTest(){
        deleteForm = rf.addForm(deleteForm);
        ReimburseFile actual = rs.deleteFile(deleteForm.getFileId());

        Assertions.assertEquals(deleteForm, actual);

    }
    @Test
    public void updateFormTest(){
        updateForm = rf.addForm(updateForm);
        ReimburseFile actual = rs.updateFile(updateForm);
        Assertions.assertEquals(updateForm, actual);
    }
    @Test
    public void getByEmployeeTest(){
        List<ReimburseFile> getAll;
        getAll = rs.getAllFilesByEmp(20);
        Assertions.assertNotNull(getAll);

    }
    @Test
    public void getforApproval(){
        List<ReimburseFile> getAll;
        getAll = rs.getAllForApproval(11);
        Assertions.assertNotNull(getAll);
    }

    @AfterAll
    public static void deletion(){
        rf.deleteForm(updateForm);
        rf.deleteForm(addForm);
        rf.deleteForm(getForm);
    }
}
