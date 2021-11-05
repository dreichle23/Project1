package com.revature.models;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="Reimbursement_Files")
public class ReimburseFile {

    @Id
    @Column(name = "file_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileId;

    @Column(name = "start_date")
    private long startDate;

    @Column(name = "submit_date")
    private long submitDate;

    @Column(name = "start_time")
    private long workTime;

    private String location;
    private String description;
    private long cost;

    @Column(name="event_type")
    private String eventType;
   // @Column (name="grade_id")
    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade gradeType;

    //@Column(name = "employee_id")
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    //@Column(name = "current_status")
    @ManyToOne
    @JoinColumn(name = "current_status")
    private Status statusId;
    @Column (name = "final_grade")
    private String finalGrade;

    public ReimburseFile() {
    }

    public ReimburseFile(int fileId, long startDate, long submitDate, long workTime, String location, String description, long cost, String eventType, Grade gradeType, Employee employeeId, Status statusId, String finalGrade) {
        this.fileId = fileId;
        this.startDate = startDate;
        this.workTime = workTime;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.eventType = eventType;
        this.gradeType = gradeType;
        this.employeeId = employeeId;
        this.statusId = statusId;
        this.finalGrade = finalGrade;
        this.submitDate = submitDate;
    }

    public ReimburseFile(int startDate, long workTime, long submitDate, String location, String description, long cost, String eventType, Grade gradeType, Employee employeeId) {
        this.startDate = startDate;
        this.workTime = workTime;
        this.location = location;
        this.description = description;
        this.cost = cost;
        this.eventType = eventType;
        this.gradeType = gradeType;
        this.employeeId = employeeId;
        this.submitDate = submitDate;
    }

    public long getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(long submitDate) {
        this.submitDate = submitDate;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getWorkTime() {
        return workTime;
    }

    public void setWorkTime(long workTime) {
        this.workTime = workTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Grade getGradeType() {
        return gradeType;
    }

    public void setGradeType(Grade gradeType) {
        this.gradeType = gradeType;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    @Override
    public String toString() {
        return "ReimburseFile{" +
                "fileId=" + fileId +
                ", startDate=" + startDate +
                ", submitDate=" + submitDate +
                ", workTime=" + workTime +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", eventType='" + eventType + '\'' +
                ", gradeType=" + gradeType +
                ", employeeId=" + employeeId +
                ", statusId=" + statusId +
                ", finalGrade='" + finalGrade + '\'' +
                '}';
    }
}
