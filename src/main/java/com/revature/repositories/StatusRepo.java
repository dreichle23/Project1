package com.revature.repositories;


import com.revature.models.Status;

import java.util.List;

public interface StatusRepo {
    public Status getStatus(int id);
    public List<Status> getAllStatuses();
    public Status addStatus(Status s);
    public Status updateStatus(Status change);
    public Status deleteStatus(Status s);
}
