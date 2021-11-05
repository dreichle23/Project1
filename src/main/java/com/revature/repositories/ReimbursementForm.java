package com.revature.repositories;


import com.revature.models.ReimburseFile;

import java.util.List;

public interface ReimbursementForm {
    public ReimburseFile getForm(int id);
    public List<ReimburseFile> getAllForms();
    public ReimburseFile addForm(ReimburseFile f);
    public ReimburseFile updateForm (ReimburseFile change);
    public ReimburseFile deleteForm(ReimburseFile f);



}
