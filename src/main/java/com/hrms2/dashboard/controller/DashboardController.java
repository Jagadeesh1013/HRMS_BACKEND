package com.hrms2.dashboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms2.dashboard.dto.HrmsDashboardDto;
import com.hrms2.dashboard.entity.HrmsDashboard;
import com.hrms2.dashboard.service.HrmsDashboardService;

@RestController
@RequestMapping("/hrms/dashboard")
@CrossOrigin(origins = "http://localhost:4200/")
public class DashboardController {

	@Autowired
	private HrmsDashboardService dashboardService;

	@GetMapping("/hrmsDashboardCounts")
	public ResponseEntity<HrmsDashboardDto> getHrmsDashboardCounts(@RequestParam(required = false) String fromDate,
			@RequestParam(required = false) String toDate) {
		return ResponseEntity.ok(dashboardService.getHrmsDashboardCounts(fromDate, toDate));
	}

	@GetMapping("/totalCounts")
	public ResponseEntity<List<Map<String, Object>>> getDashboardCounts(@RequestParam(required = false) String fromDate,
			@RequestParam(required = false) String toDate, @RequestParam String type) {
		return ResponseEntity.ok(dashboardService.getDashboardCounts(fromDate, toDate, type));
	}

	// Get dashboard counts with optional date filters
	@GetMapping("/counts")
	public ResponseEntity<List<Map<String, Object>>> getDashboardCounts(@RequestParam(required = false) String fromDate,
			@RequestParam(required = false) String toDate) {
		return ResponseEntity.ok(dashboardService.getDashboardCounts(fromDate, toDate));
	}

	// ✅ Get detailed records (Show only date range records if filter applied)
	@GetMapping("/details")
	public ResponseEntity<List<HrmsDashboard>> getDetails(@RequestParam String eventName, @RequestParam String type,
			@RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate) {
		return ResponseEntity.ok(dashboardService.getDetails(eventName, type, fromDate, toDate));
	}

	@GetMapping("/hrmsDashboardDummy")
	public HrmsDashboardDto getHrmsDashboardDummy() {
		HrmsDashboardDto hrmsDashboardDto = new HrmsDashboardDto(132l, 98l, 48l, 29l, 75l, 50l);
		return hrmsDashboardDto;
	}

}
