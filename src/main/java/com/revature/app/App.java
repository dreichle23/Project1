package com.revature.app;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.GradeController;
import com.revature.controllers.ReimbursementFileController;
import com.revature.controllers.StatusController;
import com.revature.repositories.*;
import com.revature.services.*;
import com.revature.util.HibernateUtil;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);
        establishRoutes(app);

        app.start();
    }

    private static void establishRoutes(Javalin app) {
        employeeRoutes(app);
        reimbursementFileRoutes(app);
        gradeRoutes(app);
    }

    private static void gradeRoutes(Javalin app) {
        GradeRepo gr = new GradeRepoHBImpl();
        GradeService gs = new GradeServiceImpl(gr);
        GradeController gc = new GradeController(gs);

        StatusRepo sr = new StatusRepoHBImpl();
        StatusService ss = new StatusServiceImpl(sr);
        StatusController sc = new StatusController(ss);

        app.get("/grade/:id", gc.getGradeById);
        app.get("/status/:id", sc.getStatusById);
    }

    private static void reimbursementFileRoutes(Javalin app) {
        ReimbursementForm rf = new ReimbursementFormRepoHBImpl();
        ReimbursementServices rs = new ReimbursementServicesImpl(rf);
        ReimbursementFileController rc = new ReimbursementFileController(rs);
        app.get("/files", rc.getAllFiles);
        app.get("/files/:id", rc.getFileById);
        app.post("/files", rc.addFile);
        app.delete("/files/:id", rc.deleteFile);
        app.put("files/:id", rc.updateFile);
        app.get("/files/employee/:id", rc.getAllFilesByEmp);
        app.get("/files/employee/approval/:id", rc.getAllFilesForApproval);
        app.get("/files/employee/pending/:id", rc.getAllPendingFiles);


        HibernateUtil.getSession();

    }

    private static void employeeRoutes(Javalin app) {
        EmployeeRepo er = new EmployeeRepoHBImpl();
        EmployeeService es = new EmployeeServiceImpl(er);
        EmployeeController ec = new EmployeeController(es);

        app.get("/employees", ec.getAllEmployees);
        app.get("/employees/:id", ec.getEmployeeById);
        app.get("/employeesu/:username", ec.getEmployeeByUsername);
        app.post("/employees", ec.addEmployee);
        app.delete("/employees/:id", ec.deleteEmployee);
        app.put("/employees/:id", ec.updateEmployee);

        HibernateUtil.getSession();

    }


}
