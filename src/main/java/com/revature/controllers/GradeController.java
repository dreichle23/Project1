package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.models.Grade;
import com.revature.services.GradeService;
import io.javalin.http.Handler;

public class GradeController {
    GradeService gradeService;

    public GradeController(GradeService gradeService){this.gradeService = gradeService;}

    Gson gson = new Gson();

    public Handler getGradeById = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        Grade g = gradeService.getGrade(id);

        if (g!= null){
            context.result(gson.toJson(g));
        }else{
            context.status(400);
        }

    };
}
