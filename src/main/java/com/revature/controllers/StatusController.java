package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.models.Status;
import com.revature.services.StatusService;
import io.javalin.http.Handler;

public class StatusController {

    StatusService ss;
    Gson gson = new Gson();


    public StatusController ( StatusService ss){this.ss = ss;}
    public Handler getStatusById = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        Status s = ss.getStatus(id);
        if (s!= null){
            context.result(gson.toJson(s));
        }else{
            context.status(400);
        }

    };

}
