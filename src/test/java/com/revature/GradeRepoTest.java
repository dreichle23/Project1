package com.revature;

import com.revature.models.Grade;
import com.revature.repositories.GradeRepo;
import com.revature.repositories.GradeRepoHBImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GradeRepoTest {
    static GradeRepo gr = new GradeRepoHBImpl();
    static Grade addGrade = new Grade(9, "dance");
    static Grade deleteGrade = new Grade(10, "percent");
    static Grade updateGrade = new Grade(11, "percents");

    @Test
    public void addGradeTest(){
        Grade actual = gr.addGrade(addGrade);
        addGrade.setGradeId(actual.getGradeId());
        Assertions.assertEquals(addGrade, actual);
    }

    @Test
    public void getAllGradesTest(){
        List<Grade> getAll;
        getAll = gr.getAllGrades();

        Assertions.assertNotNull(getAll);
    }
    @Test
    public void deleteGradeTest(){
        deleteGrade = gr.addGrade(deleteGrade);
        Grade actual = gr.deleteGrade(deleteGrade);

        Assertions.assertEquals(deleteGrade, actual);
    }
    @Test
    public void updateGradeTest(){
        updateGrade = gr.addGrade(updateGrade);
        Grade actual = gr.updateGRade(updateGrade);
        Assertions.assertEquals(updateGrade, actual);
    }
    @AfterAll
    public static void deletion(){
        gr.deleteGrade(updateGrade);
        gr.deleteGrade(addGrade);
    }




}
