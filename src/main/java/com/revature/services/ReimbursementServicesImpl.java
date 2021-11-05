package com.revature.services;

import com.revature.models.Employee;
import com.revature.models.ReimburseFile;
import com.revature.models.Status;
import com.revature.repositories.*;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementServicesImpl implements ReimbursementServices{
   ReimbursementForm rf;

   public ReimbursementServicesImpl( ReimbursementForm rf){this.rf = rf;}

    @Override
    public ReimburseFile getFile(int id) {
        return rf.getForm(id);
    }

    @Override
    public List<ReimburseFile> getAllFiles() {

       return rf.getAllForms();
    }

    @Override
    public ReimburseFile addFile(ReimburseFile r) {
       // StatusRepo sr = new StatusRepoHBImpl();
//        if (r.getEmployeeId().getDepartment().getDepartmentHeadId() == r.getEmployeeId().getDsId()){
//            r.setStatusId(sr.getStatus(2));
//
//        }
//        if(r.getEmployeeId().getEmployeeId() == r.getEmployeeId().getDepartment().getDepartmentHeadId()){
//            r.setStatusId((sr.getStatus(3)));
//        }
       return rf.addForm(r);
    }

    @Override
    public ReimburseFile updateFile(ReimburseFile change) {
        return rf.updateForm(change);
    }

    @Override
    public ReimburseFile deleteFile(int id) {
       ReimburseFile rr = rf.getForm(id);
        return rf.deleteForm(rr);
    }

    @Override
    public List<ReimburseFile> getAllFilesByEmp(int id) {
       List<ReimburseFile> fileList = rf.getAllForms();
       List<ReimburseFile> employeeFileList = new ArrayList<>();

       for (ReimburseFile f : fileList)
           if (f.getEmployeeId().getEmployeeId() == id){
               employeeFileList.add(f);
           }

        return employeeFileList;
    }

    @Override
    public List<ReimburseFile> getAllForApproval(int id) {
       List<ReimburseFile> fileList = rf.getAllForms();
       List<ReimburseFile> employeeFileList = new ArrayList<>();
       boolean benCo = false;

        EmployeeRepo er = new EmployeeRepoHBImpl();
        Employee em = er.getEmployee(id);
        if( em.isBenCo()){
            benCo = true;
        }


       for (ReimburseFile f: fileList){
           if((f.getEmployeeId().getDepartment().getDepartmentHeadId() == id) && (f.getStatusId().getStatus_id() ==2)){
               employeeFileList.add(f);

           }else if(f.getEmployeeId().getDsId() == id && f.getStatusId().getStatus_id() == 1){
               employeeFileList.add(f);
            //|| (f.getStatusId().getStatus_id() == 5)
           }else if (benCo && (f.getStatusId().getStatus_id()==3) || (f.getStatusId().getStatus_id() == 5 ) && f.getEmployeeId().getEmployeeId() != id){

               employeeFileList.add(f);

           }else{

           }



       }//end for loop


        return employeeFileList;
    }

    @Override
    public List<ReimburseFile> getAllPendingfiles(int id) {
        List<ReimburseFile> fileList = rf.getAllForms();
        List<ReimburseFile> employeeFileList = new ArrayList<>();

        for (ReimburseFile f : fileList)
            if ((f.getEmployeeId().getEmployeeId() == id) && (f.getStatusId().getStatus_id() == 4)){
                employeeFileList.add(f);
            }

        return employeeFileList;
    }
}
