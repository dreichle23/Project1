package com.revature.services;

import com.revature.models.ReimburseFile;
import com.revature.repositories.ReimbursementForm;

import java.util.List;

public interface ReimbursementServices {

    public ReimburseFile getFile(int id);
    public List<ReimburseFile> getAllFiles();
    public ReimburseFile addFile(ReimburseFile r);
    public ReimburseFile updateFile(ReimburseFile change);
    public ReimburseFile deleteFile(int id);
    public List<ReimburseFile> getAllFilesByEmp(int id);
    public List<ReimburseFile> getAllForApproval(int id);


    public List<ReimburseFile> getAllPendingfiles(int id);
}
