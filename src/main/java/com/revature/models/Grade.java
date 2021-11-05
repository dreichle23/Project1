package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "Grades")
public class Grade {

    @Id
    @Column(name = "grade_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradeId;

    @Column(name = "grade_name")
    private String gradeType;

    public Grade() {
    }

    public Grade(int gradeId, String gradeType) {
        this.gradeId = gradeId;
        this.gradeType = gradeType;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeType='" + gradeType + '\'' +
                '}';
    }
}
