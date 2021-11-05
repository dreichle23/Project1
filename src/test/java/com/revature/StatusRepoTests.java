package com.revature;

import com.revature.models.Status;
import com.revature.repositories.StatusRepo;
import com.revature.repositories.StatusRepoHBImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StatusRepoTests {
    static StatusRepo sr = new StatusRepoHBImpl();
    static Status addStatus = new Status(10, "not found");
    static Status updateStatus = new Status(11, "not found");
    static Status deleteStatus = new Status(12, "not found");


    @Test
    public void addStatusTest(){
        Status actual = sr.addStatus(addStatus);
        addStatus.setStatus_id(actual.getStatus_id());
        Assertions.assertEquals(addStatus, actual);

    }
    @Test
    public void getAllStatusTest(){
        List<Status> getAll;
        getAll = sr.getAllStatuses();
        Assertions.assertNotNull(getAll);
    }
    @Test
    public void deleteStatusTest(){
        deleteStatus = sr.addStatus(deleteStatus);
        Status actual = sr.deleteStatus(deleteStatus);
        Assertions.assertEquals(deleteStatus, actual);
    }
    @Test
    public void updateStatusTest(){
        updateStatus = sr.addStatus(updateStatus);
        Status actual = sr.updateStatus(updateStatus);
        Assertions.assertEquals(updateStatus, actual);
    }

    @AfterAll
    public static void deletion(){
        sr.deleteStatus(updateStatus);
        sr.deleteStatus(addStatus);
    }




}
