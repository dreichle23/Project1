package com.revature.services;

import com.revature.models.Status;
import com.revature.repositories.StatusRepo;

public class StatusServiceImpl implements StatusService{

StatusRepo sr;

public StatusServiceImpl(StatusRepo sr){this.sr = sr;}
    @Override
    public Status getStatus(int id) {
        return sr.getStatus(id);
    }
}
