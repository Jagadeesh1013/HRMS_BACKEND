package com.hrms2.dashboard.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrms2.dashboard.dto.HrmsDashboardDto;
import com.hrms2.dashboard.entity.HrmsDashboard;

@Repository
public interface HrmsDashboardRepository extends JpaRepository<HrmsDashboard, Long> {

	// Fetch all Hrms dashboard counts
	@Query("""
			    SELECT new com.hrms2.dashboard.dto.HrmsDashboardDto(
			        COUNT(h.jsonSentDate),
			        COUNT(CASE WHEN h.pdfFileNameStatus = 'Y' THEN 1 ELSE NULL END),
			        COUNT(CASE WHEN h.hrmsReceivedStatus = 'Y' THEN 1 ELSE NULL END),
			        COUNT(CASE WHEN h.hrmsRejectedStatus = 'N' THEN 1 ELSE NULL END),
			        COUNT(CASE WHEN h.ddoReceivedStatus = 'Y' THEN 1 ELSE NULL END),
			        COUNT(CASE WHEN h.ddoRejectedStatus = 'N' THEN 1 ELSE NULL END)
			    )
			    FROM HrmsDashboard h
			""")
	HrmsDashboardDto getHrmsDashboardCounts();

	// Fetch dashboard counts with a date filter
	@Query("""
			SELECT new com.hrms2.dashboard.dto.HrmsDashboardDto(
			       COUNT(h.jsonSentDate),
			       COUNT(CASE WHEN h.pdfFileNameStatus = 'Y' THEN 1 ELSE NULL END),
			       COUNT(CASE WHEN h.hrmsReceivedStatus = 'Y' THEN 1 ELSE NULL END),
			       COUNT(CASE WHEN h.hrmsRejectedStatus = 'N' THEN 1 ELSE NULL END),
			       COUNT(CASE WHEN h.ddoReceivedStatus = 'Y' THEN 1 ELSE NULL END),
			       COUNT(CASE WHEN h.ddoRejectedStatus = 'N' THEN 1 ELSE NULL END)
			   )
			   FROM HrmsDashboard h
			WHERE CAST(h.createdAt AS DATE) BETWEEN TO_DATE(:fromDate, 'YYYY-MM-DD')
			                                    AND TO_DATE(:toDate, 'YYYY-MM-DD')
			""")
	HrmsDashboardDto getHrmsDashboardCountsByDateRange(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

	@Query("""
			    SELECT new map(
			        LOWER(h.eventName) as eventName,
			        CASE WHEN :type = 'jsonSent' THEN COUNT(h.jsonSentDate) ELSE NULL END as jsonSent,
			        CASE WHEN :type = 'pdfSent' THEN COUNT(CASE WHEN h.pdfFileNameStatus = 'Y' THEN 1 ELSE NULL END) ELSE NULL END as pdfSent,
			        CASE WHEN :type = 'hrmsReceived' THEN COUNT(CASE WHEN h.hrmsReceivedStatus = 'Y' THEN 1 ELSE NULL END) ELSE NULL END as hrmsReceived,
			        CASE WHEN :type = 'hrmsRejected' THEN COUNT(CASE WHEN h.hrmsRejectedStatus = 'N' THEN 1 ELSE NULL END) ELSE NULL END as hrmsRejected,
			        CASE WHEN :type = 'ddoReceived' THEN COUNT(CASE WHEN h.ddoReceivedStatus = 'Y' THEN 1 ELSE NULL END) ELSE NULL END as ddoReceived,
			        CASE WHEN :type = 'ddoRejected' THEN COUNT(CASE WHEN h.ddoRejectedStatus = 'N' THEN 1 ELSE NULL END) ELSE NULL END as ddoRejected
			    )
			    FROM HrmsDashboard h
			    GROUP BY LOWER(h.eventName)
			""")
	List<Map<String, Object>> getDashboardCounts(@Param("type") String type);

	@Query("""
			    SELECT new map(
			       LOWER(h.eventName) as eventName,
			       CASE WHEN :type = 'jsonSent' THEN COUNT(h.jsonSentDate) ELSE NULL END as jsonSent,
			       CASE WHEN :type = 'pdfSent' THEN COUNT(CASE WHEN h.pdfFileNameStatus = 'Y' THEN 1 ELSE NULL END) ELSE NULL END as pdfSent,
			       CASE WHEN :type = 'hrmsReceived' THEN COUNT(CASE WHEN h.hrmsReceivedStatus = 'Y' THEN 1 ELSE NULL END) ELSE NULL END as hrmsReceived,
			       CASE WHEN :type = 'hrmsRejected' THEN COUNT(CASE WHEN h.hrmsRejectedStatus = 'N' THEN 1 ELSE NULL END) ELSE NULL END as hrmsRejected,
			       CASE WHEN :type = 'ddoReceived' THEN COUNT(CASE WHEN h.ddoReceivedStatus = 'Y' THEN 1 ELSE NULL END) ELSE NULL END as ddoReceived,
			       CASE WHEN :type = 'ddoRejected' THEN COUNT(CASE WHEN h.ddoRejectedStatus = 'N' THEN 1 ELSE NULL END) ELSE NULL END as ddoRejected
			   )
			   FROM HrmsDashboard h
			    WHERE (:fromDate IS NULL OR CAST(h.createdAt AS DATE) >= TO_DATE(:fromDate, 'YYYY-MM-DD'))
			      AND (:toDate IS NULL OR CAST(h.createdAt AS DATE) <= TO_DATE(:toDate, 'YYYY-MM-DD'))
			    GROUP BY LOWER(h.eventName)
			""")
	List<Map<String, Object>> getDashboardCountsByDateRange(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate, @Param("type") String type);

	// Fetch all dashboard details without date filter
	@Query("""
			    SELECT h FROM HrmsDashboard h
			    WHERE LOWER(h.eventName) = LOWER(:eventName)
			    AND (
			        (:type = 'jsonSent' AND h.jsonSentDate IS NOT NULL)
			        OR (:type = 'pdfSent' AND h.pdfFileNameStatus = 'Y')
			        OR (:type = 'hrmsReceived' AND h.hrmsReceivedStatus = 'Y')
			        OR (:type = 'hrmsRejected' AND h.hrmsRejectedStatus = 'N')
			        OR (:type = 'ddoReceived' AND h.ddoReceivedStatus = 'Y')
			        OR (:type = 'ddoRejected' AND h.ddoRejectedStatus = 'N')
			    )
			""")
	List<HrmsDashboard> findByEventNameAndType(@Param("eventName") String eventName, @Param("type") String type);

	// Fetch all dashboard details with date filter
	@Query("""
			    SELECT h FROM HrmsDashboard h
			    WHERE LOWER(h.eventName) = LOWER(:eventName)
			    AND (
			        (:type = 'jsonSent' AND h.jsonSentDate IS NOT NULL)
			        OR (:type = 'pdfSent' AND h.pdfFileNameStatus = 'Y')
			        OR (:type = 'hrmsReceived' AND h.hrmsReceivedStatus = 'Y')
			        OR (:type = 'hrmsRejected' AND h.hrmsRejectedStatus = 'N')
			        OR (:type = 'ddoReceived' AND h.ddoReceivedStatus = 'Y')
			        OR (:type = 'ddoRejected' AND h.ddoRejectedStatus = 'N')
			    )
			    AND CAST(h.createdAt AS DATE) BETWEEN TO_DATE(:fromDate, 'YYYY-MM-DD')
			                                    AND TO_DATE(:toDate, 'YYYY-MM-DD')
			""")
	List<HrmsDashboard> findByEventNameAndTypeWithDateFilter(@Param("eventName") String eventName,
			@Param("type") String type, @Param("fromDate") String fromDate, @Param("toDate") String toDate);

	// Fetch all dashboard counts without date filter
	@Query("""
			SELECT new map(
			    LOWER(h.eventName) as eventName,
			    COUNT(h.jsonSentDate) as jsonSent,
			    COUNT(CASE WHEN h.pdfFileNameStatus = 'Y' THEN 1 ELSE NULL END) as pdfSent,
			    COUNT(CASE WHEN h.hrmsReceivedStatus = 'Y' THEN 1 ELSE NULL END) as hrmsReceived,
			    COUNT(CASE WHEN h.hrmsRejectedStatus = 'N' THEN 1 ELSE NULL END) as hrmsRejected,
			    COUNT(CASE WHEN h.ddoReceivedStatus = 'Y' THEN 1 ELSE NULL END) as ddoReceived,
			    COUNT(CASE WHEN h.ddoRejectedStatus = 'N' THEN 1 ELSE NULL END) as ddoRejected
			)
			FROM HrmsDashboard h
			GROUP BY LOWER(h.eventName)
			""")
	List<Map<String, Object>> getDashboardCounts();

	// Fetch dashboard counts with a date filter
	@Query("""
			SELECT new map(
			    LOWER(h.eventName) as eventName,
			    COUNT(h.jsonSentDate) as jsonSent,
			    COUNT(CASE WHEN h.pdfFileNameStatus = 'Y' THEN 1 ELSE NULL END) as pdfSent,
			    COUNT(CASE WHEN h.hrmsReceivedStatus = 'Y' THEN 1 ELSE NULL END) as hrmsReceived,
			    COUNT(CASE WHEN h.hrmsRejectedStatus = 'N' THEN 1 ELSE NULL END) as hrmsRejected,
			    COUNT(CASE WHEN h.ddoReceivedStatus = 'Y' THEN 1 ELSE NULL END) as ddoReceived,
			    COUNT(CASE WHEN h.ddoRejectedStatus = 'N' THEN 1 ELSE NULL END) as ddoRejected
			)
			FROM HrmsDashboard h
			WHERE CAST(h.createdAt AS DATE) BETWEEN TO_DATE(:fromDate, 'YYYY-MM-DD')
			                                    AND TO_DATE(:toDate, 'YYYY-MM-DD')
			GROUP BY LOWER(h.eventName)
			""")
	List<Map<String, Object>> getDashboardCountsByDateRange(@Param("fromDate") String fromDate,
			@Param("toDate") String toDate);

}
