package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.ReimburseFile;

import com.revature.services.ReimbursementServices;
import io.javalin.http.Handler;

import java.util.List;

public class ReimbursementFileController {
    ReimbursementServices rs;

    Gson gson = new Gson();
    public ReimbursementFileController(ReimbursementServices rs){
        this.rs = rs;
    }
    public Handler getAllFiles = (context)->{
        List<ReimburseFile> fileList = rs.getAllFiles();

        context.result(gson.toJson(fileList));
    };
    public Handler getFileById = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        ReimburseFile rf = rs.getFile(id);
        if (rf!= null){
            context.result(gson.toJson(rf));
        }else{
            context.status(400);
        }

    };

    public Handler addFile = (context) ->{
        ReimburseFile rf = gson.fromJson(context.body(), ReimburseFile.class);
        rf = rs.addFile(rf);
        context.result((rf!=null) ? gson.toJson(rf): "{}");
    };

    public Handler updateFile = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        ReimburseFile rf = gson.fromJson(context.body(), ReimburseFile.class);
        rf.setFileId(id);
        rs.updateFile(rf);
        if (rf!= null){
            context.result(gson.toJson(rf));
        }else{
            context.status(400);
        }

    };

    public Handler deleteFile= (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        ReimburseFile rf = rs.deleteFile(id);
        if (rf!= null){
            context.result(gson.toJson(rf));
        }else{
            context.status(400);
        }

    };

    public Handler getAllFilesByEmp = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        List<ReimburseFile> fileList = rs.getAllFilesByEmp(id);

        context.result(gson.toJson(fileList));
    };
    public Handler getAllFilesForApproval = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        List<ReimburseFile> fileList = rs.getAllForApproval(id);

        context.result(gson.toJson(fileList));
    };
    public Handler getAllPendingFiles = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        List<ReimburseFile> fileList = rs.getAllPendingfiles(id);

        context.result(gson.toJson(fileList));
    };

}
