package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int status_id;

    @Column(name = "status_name", nullable = false)
    private String status;

    public Status() {
    }

    public Status(int status_id, String status) {
        this.status_id = status_id;
        this.status = status;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status_id=" + status_id +
                ", status='" + status + '\'' +
                '}';
    }
}
