package com.revature;

import com.revature.models.*;
import com.revature.repositories.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileRepoTest {
    static DepartmentRepo dr = new DepartmentRepoHBImpl();
    static Department d = dr.getDepartment(4);
    static EmployeeRepo er = new EmployeeRepoHBImpl();
    static Employee em = er.getEmployee(20);
    static GradeRepo gr = new GradeRepoHBImpl();
    static Grade g = gr.getGrade(1);
    static StatusRepo sr = new StatusRepoHBImpl();
    static Status s = sr.getStatus(1);
    static ReimbursementForm rf = new ReimbursementFormRepoHBImpl();
    static ReimburseFile addForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);
    static ReimburseFile updateForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);
    static ReimburseFile deleteForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);
    static ReimburseFile getForm = new ReimburseFile(80,80, 00, "loc", "des", 600, "Course", g, em);

    @Test
    public void addFormTest(){
        ReimburseFile actual = rf.addForm(addForm);
        addForm.setFileId(actual.getFileId());
        Assertions.assertEquals(addForm, actual);

    }
    @Test
    public void getFormTest(){
        getForm = rf.addForm(getForm);
        ReimburseFile actual = rf.getForm(getForm.getFileId());
        ReimburseFile expected = actual;

        Assertions.assertEquals(expected, actual);
    }
   @Test
    public void getAllFormsTest(){
       List<ReimburseFile> getAll;
       getAll = rf.getAllForms();

       Assertions.assertNotNull(getAll);
   }
   @Test
    public void deleteFormTest(){
        deleteForm = rf.addForm(deleteForm);
        ReimburseFile actual = rf.deleteForm(deleteForm);

        Assertions.assertEquals(deleteForm, actual);

   }
   @Test
   public void updateFormTest(){
        updateForm = rf.addForm(updateForm);
        ReimburseFile actual = rf.updateForm(updateForm);
        Assertions.assertEquals(updateForm, actual);
   }
   @AfterAll
    public static void deletion(){
        rf.deleteForm(updateForm);
        rf.deleteForm(addForm);
        rf.deleteForm(getForm);
   }


}
