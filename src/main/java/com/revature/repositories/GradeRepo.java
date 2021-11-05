package com.revature.repositories;

import com.revature.models.Grade;

import java.util.List;

public interface GradeRepo {
    public Grade getGrade(int id);
    public List<Grade> getAllGrades();
    public Grade addGrade(Grade g);
    public Grade updateGRade(Grade change);
    public Grade deleteGrade(Grade g);

}
