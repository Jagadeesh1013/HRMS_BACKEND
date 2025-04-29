package com.hrms2.dashboard.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms2.dashboard.dto.HrmsDashboardDto;
import com.hrms2.dashboard.entity.HrmsDashboard;
import com.hrms2.dashboard.repository.HrmsDashboardRepository;
import com.hrms2.dashboard.service.HrmsDashboardService;

@Service
public class HrmsDashboardServiceImpl implements HrmsDashboardService {

	@Autowired
	private HrmsDashboardRepository repository;

	public HrmsDashboardDto getHrmsDashboardCounts(String fromDate, String toDate) {
		if (fromDate != null && toDate != null) {
			return repository.getHrmsDashboardCountsByDateRange(fromDate, toDate);
		}
		return repository.getHrmsDashboardCounts();
	}

	public List<Map<String, Object>> getDashboardCounts(String fromDate, String toDate, String type) {
		List<Map<String, Object>> rawData;

		if (fromDate != null && toDate != null && !fromDate.isEmpty() && !toDate.isEmpty()) {
			rawData = repository.getDashboardCountsByDateRange(fromDate, toDate, type);
		} else {
			rawData = repository.getDashboardCounts(type);
		}

		return rawData.stream().map(row -> {
			Map<String, Object> filtered = new LinkedHashMap<>();
			filtered.put("eventName", row.get("eventName"));
			if (row.get(type) != null) {
				filtered.put(type, row.get(type));
			}
			return filtered;
		}).collect(Collectors.toList());
	}

	public List<Map<String, Object>> getDashboardCounts(String fromDate, String toDate) {
		if (fromDate != null && toDate != null) {
			return repository.getDashboardCountsByDateRange(fromDate, toDate);
		}
		return repository.getDashboardCounts();
	}

	public List<HrmsDashboard> getDetails(String eventName, String type, String fromDate, String toDate) {
		String fromDateStr = (fromDate != null && !fromDate.isEmpty()) ? fromDate : null;
		String toDateStr = (toDate != null && !toDate.isEmpty()) ? toDate : null;

		if (fromDateStr == null && toDateStr == null) {
			return repository.findByEventNameAndType(eventName, type);
		} else {
			return repository.findByEventNameAndTypeWithDateFilter(eventName, type, fromDateStr, toDateStr);
		}
	}

}
