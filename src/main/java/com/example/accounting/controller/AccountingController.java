package com.example.accounting.controller;

import com.example.accounting.model.Report;
import com.example.accounting.service.AccountingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/")
public class AccountingController {
    @Autowired
    private AccountingService accountingService;
    private Gson gson;

    {
        gson = new Gson();
    }

    @RequestMapping(value = "/withoutOneTrack", method = RequestMethod.GET)
    public String getTodayTrackedUserNames() throws IOException {
        List<String> listOfNonReportedTasks = accountingService.getTodayTrackedUserNames();
        String json = gson.toJson(listOfNonReportedTasks);
        return json;
    }

    @RequestMapping(value = "/withoutThreeTrack", method = RequestMethod.GET)
    public String getThreeDayTrackedUserNames() throws IOException {
        List<String> listOfNonReportedTasks = accountingService.getThreeDayTrackedUserNames();
        String json = gson.toJson(listOfNonReportedTasks);
        return json;
    }

    @RequestMapping(value = "/nonReportedTasks", method = RequestMethod.GET)
    public void getReports(String userName, String userRole, Integer userId, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        List<Report> listOfNonReportedTasks = accountingService.getReports();
        String json = gson.toJson(listOfNonReportedTasks);
        out.print(json);
        out.flush();
        return;
    }

    @RequestMapping(value = "/insertNewTrack", method = RequestMethod.POST, headers = "Content-Type=application/json")
    public void addReport(@RequestBody Report report) throws IOException {
        accountingService.addReport(report);
    }
}
