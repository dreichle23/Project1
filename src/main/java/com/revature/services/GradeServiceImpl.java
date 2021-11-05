package com.revature.services;

import com.revature.models.Grade;
import com.revature.repositories.GradeRepo;

public class GradeServiceImpl implements GradeService {

    GradeRepo gr;
    public GradeServiceImpl(GradeRepo gr){this.gr = gr;}

    @Override
    public Grade getGrade(int id) {
        return gr.getGrade(id);
    }
}
