package com.revature;

import com.revature.models.Grade;
import com.revature.models.Status;
import com.revature.repositories.GradeRepo;
import com.revature.repositories.GradeRepoHBImpl;
import com.revature.repositories.StatusRepo;
import com.revature.repositories.StatusRepoHBImpl;
import com.revature.services.GradeService;
import com.revature.services.GradeServiceImpl;
import com.revature.services.StatusService;
import com.revature.services.StatusServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class otherServicesTest {
    static GradeRepo gr = new GradeRepoHBImpl();
    static GradeService gs = new GradeServiceImpl(gr);
    static Grade getGrade = new Grade(9, "dance");
    static StatusRepo sr = new StatusRepoHBImpl();
    static StatusService ss = new StatusServiceImpl(sr);
    static Status getStatus = new Status(10, "not found");



    @Test
   public void getGradeTest(){
        getGrade = gr.addGrade(getGrade);
        Grade actual = gs.getGrade(getGrade.getGradeId());
        Grade expected = actual;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getStatusTest(){
        getStatus = sr.addStatus(getStatus);
        Status actual = ss.getStatus(getStatus.getStatus_id());
        Status expected = actual;
        Assertions.assertEquals(expected, actual);
    }
    @AfterAll
    public static void deletion(){
        gr.deleteGrade(getGrade);
        sr.deleteStatus(getStatus);
    }
}
