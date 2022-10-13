package com.example.accounting.repository;

import com.example.accounting.entity.ReportEntity;

import java.util.List;

public interface AccountingRepository {
    List<ReportEntity> getReports();

    List<String> getTodayTrackedUserNames();

    List<String> getThreeDayTrackedUserNames();

    void addReport(ReportEntity report);
}
