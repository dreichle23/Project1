package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;

import java.util.List;


public class EmployeeController {

    EmployeeService es;

    Gson gson = new Gson();
    public EmployeeController( EmployeeService es){
    this.es = es;
    }
    public Handler getAllEmployees = (context)->{
        List<Employee> employeeList = es.getallEmployees();

        context.result(gson.toJson(employeeList));
    };
    public Handler getEmployeeById = (context)->{
      String input = context.pathParam("id");
      int id;
      try{
          id = Integer.parseInt(input);
      }catch (NumberFormatException e){
          id= -1;
      }
      Employee em = es.getEmployee(id);
      if (em!= null){
          context.result(gson.toJson(em));
      }else{
          context.status(400);
      }

    };
    public Handler getEmployeeByUsername = (context)->{
        String input = context.pathParam("username");
        Employee em = es.getEmployee(input);
        if (em!= null){
            context.result(gson.toJson(em));
        }else{
            context.status(400);
        }

    };
    public Handler addEmployee = (context) ->{
      Employee em = gson.fromJson(context.body(), Employee.class);
      em = es.addEmployee(em);
      context.result((em!=null) ? gson.toJson(em): "{}");
    };

    public Handler updateEmployee = (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        Employee em = gson.fromJson(context.body(), Employee.class);
        em.setEmployeeId(id);
        es.updateEmployee(em);
        if (em!= null){
            context.result(gson.toJson(em));
        }else{
            context.status(400);
        }

    };

    public Handler deleteEmployee= (context)->{
        String input = context.pathParam("id");
        int id;
        try{
            id = Integer.parseInt(input);
        }catch (NumberFormatException e){
            id= -1;
        }
        Employee em = es.deleteEmployee(id);
        if (em!= null){
            context.result(gson.toJson(em));
        }else{
            context.status(400);
        }

    };



}
