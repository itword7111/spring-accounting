package com.example.accounting.repository;

import com.example.accounting.entity.ReportEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public class AccountingRepositoryImpl implements AccountingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<ReportEntity> getReports() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ReportEntity> criteriaQuery = criteriaBuilder.createQuery(ReportEntity.class);
        Root<ReportEntity> reportRoot = criteriaQuery.from(ReportEntity.class);
        criteriaQuery.select(reportRoot);
        TypedQuery<ReportEntity> typedQuery = entityManager.createQuery(criteriaQuery);
        List<ReportEntity> reportListList = typedQuery.getResultList();
        return reportListList;
    }

    public List<String> getTodayTrackedUserNames() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setDate(timestamp.getDate() - 1);
        List<String> listOfReportEntity = getUserNamesOfTrackedByTimestamp(timestamp);
        return listOfReportEntity;
    }

    public List<String> getThreeDayTrackedUserNames() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setDate(timestamp.getDate() - 3);
        List<String> listOfReportEntity = getUserNamesOfTrackedByTimestamp(timestamp);
        return listOfReportEntity;
    }

    public void addReport(ReportEntity report) {
        entityManager.persist(report);
    }

    private List<String> getUserNamesOfTrackedByTimestamp(Timestamp timestamp) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
        Root<ReportEntity> reportRoot = criteriaQuery.from(ReportEntity.class);
        Predicate userPredicate = criteriaBuilder.greaterThanOrEqualTo(reportRoot.get("timeOfTrack").as(Timestamp.class), timestamp);
        criteriaQuery.select(reportRoot.<String>get("userName")).where(userPredicate);
        TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
