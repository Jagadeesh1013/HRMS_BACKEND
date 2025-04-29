package com.hrms2.dashboard.service;

import java.util.List;
import java.util.Map;

import com.hrms2.dashboard.dto.HrmsDashboardDto;
import com.hrms2.dashboard.entity.HrmsDashboard;

public interface HrmsDashboardService {

	HrmsDashboardDto getHrmsDashboardCounts(String fromDate, String toDate);

	List<Map<String, Object>> getDashboardCounts(String fromDate, String toDate, String type);

	List<Map<String, Object>> getDashboardCounts(String fromDate, String toDate);

	List<HrmsDashboard> getDetails(String eventName, String type, String fromDate, String toDate);

}
