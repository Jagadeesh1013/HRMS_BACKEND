package com.hrms2.dashboard.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms2.dashboard.model.DashboardStatus;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200/")
public class DashboardController {

	@GetMapping("/counts")
	public DashboardStatus getGemsDashboardCounts() {
	
		DashboardStatus stats = new DashboardStatus();
		stats.setJsonSent(123);
		stats.setPdfSent(97);
		stats.setHrmsReceived(88);
		stats.setHrmsRejected(5);
		stats.setDdoReceived(76);
		stats.setDdoRejected(4);
		return stats;
	}
}
