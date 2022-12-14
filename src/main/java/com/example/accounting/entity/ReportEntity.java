package com.example.accounting.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tasks", schema = "public")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "task")
    private String task;
    @Column(name = "time_of_track")
    private Timestamp timeOfTrack;
    @Column(name = "time_for_track")
    private Timestamp timeForTrack;

    public ReportEntity(String userName, String task, Timestamp timeOfTrack, Timestamp timeForTrack) {
        this.userName = userName;
        this.task = task;
        this.timeOfTrack = timeOfTrack;
        this.timeForTrack=timeForTrack;
    }

    public ReportEntity() {
    }

    public Timestamp getTimeForTrack() {
        return timeForTrack;
    }

    public void setTimeForTrack(Timestamp timeForTrack) {
        this.timeForTrack = timeForTrack;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Timestamp getTimeOfTrack() {
        return timeOfTrack;
    }

    public void setTimeOfTrack(Timestamp timeOfTrack) {
        this.timeOfTrack = timeOfTrack;
    }
}
