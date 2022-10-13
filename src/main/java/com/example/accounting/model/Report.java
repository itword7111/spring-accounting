package com.example.accounting.model;

import java.sql.Timestamp;

public class Report {
    private String userName;
    private String task;
    private Timestamp timeOfTrack;

    public Report(String userName, String task, Timestamp timeOfTrack) {
        this.userName = userName;
        this.task = task;
        this.timeOfTrack = timeOfTrack;
    }

    public Report() {
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
