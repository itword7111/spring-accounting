package com.example.accounting.service;

import com.example.accounting.model.Report;

import java.util.List;

public interface AccountingService {
    List<Report> getReports();

    List<String> getTodayTrackedUserNames();

    List<String> getThreeDayTrackedUserNames();

    void addReport(Report report);
}
