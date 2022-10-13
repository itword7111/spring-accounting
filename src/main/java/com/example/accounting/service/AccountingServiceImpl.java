package com.example.accounting.service;

import com.example.accounting.entity.ReportEntity;
import com.example.accounting.model.Report;
import com.example.accounting.repository.AccountingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountingServiceImpl implements AccountingService {
    @Autowired
    AccountingRepository accountingRepository;

    public List<Report> getReports() {
        List<ReportEntity> reportEntityList = accountingRepository.getReports();
        List<Report> reportList = new ArrayList<Report>();
        for (ReportEntity reportEntity : reportEntityList) {
            reportList.add(new Report(reportEntity.getUserName(), reportEntity.getTask(), reportEntity.getTimeOfTrack(), reportEntity.getTimeForTrack()));
        }
        return reportList;
    }

    public List<String> getTodayTrackedUserNames() {
        return accountingRepository.getTodayTrackedUserNames();
    }

    public List<String> getThreeDayTrackedUserNames() {
        return accountingRepository.getThreeDayTrackedUserNames();
    }

    public void addReport(Report report) {
        accountingRepository.addReport(new ReportEntity(report.getUserName(), report.getTask(), report.getTimeOfTrack(), report.getTimeForTrack()));
    }
}
