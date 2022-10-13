package com.example.accounting.service;

import com.example.accounting.entity.ReportEntity;
import com.example.accounting.model.Report;
import com.example.accounting.repository.AccountingRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AccountingServiceImplTest {
    @Mock
    List<ReportEntity> reportEntityList;
    @Mock
    AccountingRepository accountingRepository;
    @InjectMocks
    AccountingServiceImpl accountingService;

    public AccountingServiceImplTest() {
    }

    @Test
    public void getReports() {
        ReportEntity firstReportEntity = new ReportEntity("Mike", "done", new Timestamp(1), new Timestamp(1));
        ReportEntity secondReportEntity = new ReportEntity("Danny", "not done", new Timestamp(1), new Timestamp(1));
        ReportEntity thirdReportEntity = new ReportEntity("Georg", "waiting teammates", new Timestamp(1), new Timestamp(1));

        Report firstReport = new Report("Mike", "done", new Timestamp(1), new Timestamp(1));
        Report secondReport = new Report("Danny", "not done", new Timestamp(1), new Timestamp(1));
        Report thirdReport = new Report("Georg", "waiting teammates", new Timestamp(1), new Timestamp(1));

        List<ReportEntity> reportEntityList = new ArrayList<ReportEntity>();
        List<Report> reportList = new ArrayList<Report>();

        reportEntityList.add(firstReportEntity);
        reportEntityList.add(secondReportEntity);
        reportEntityList.add(thirdReportEntity);

        reportList.add(firstReport);
        reportList.add(secondReport);
        reportList.add(thirdReport);

        when(accountingRepository.getReports()).thenReturn(reportEntityList);
        Assert.assertTrue(CompareLists(accountingService.getReports(), reportList));
    }

    private boolean CompareLists(List<Report> first, List<Report> second) {
        int count = 0;
        if (first.size() == second.size()) {
            for (Report report : first) {
                Report secondReport = second.get(count);
                if (!(report.getTask().equals(secondReport.getTask()) &&
                        report.getUserName().equals(secondReport.getUserName()) &&
                        report.getTimeOfTrack().equals(secondReport.getTimeOfTrack()))) {
                    return false;
                }
                count++;
            }
            return true;
        }
        return false;
    }
}