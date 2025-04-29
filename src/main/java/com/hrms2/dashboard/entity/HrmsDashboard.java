package com.hrms2.dashboard.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "HRMS_STATUS_UPDATE", schema = "hrms2")
public class HrmsDashboard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TRANSACTION_ID")
	private String transactionId;

	@Column(name = "GE_NUMBER")
	private String geNumber;

	@Column(name = "EVENT_ID")
	private String eventId;

	@Column(name = "EVENT_NAME")
	private String eventName;

	@Column(name = "FILE_ID")
	private String fileId;

	@Column(name = "PDF_FILE_NAME")
	private String pdfFileName;

	@Column(name = "PDF_FILE_NAME_STATUS", length = 1)
	private String pdfFileNameStatus;

	@Column(name = "JSON_SENT_DATE")
	private LocalDateTime jsonSentDate;

	@Column(name = "HRMS_RECEIVED_STATUS")
	private String hrmsReceivedStatus;

	@Column(name = "HRMS_RECEIVED_DATE")
	private LocalDateTime hrmsReceivedDate;

	@Column(name = "HRMS_REJECTED_STATUS")
	private String hrmsRejectedStatus;

	@Column(name = "HRMS_REJECTED_DATE")
	private LocalDateTime hrmsRejectedDate;

	@Column(name = "DDO_RECEIVED_STATUS")
	private String ddoReceivedStatus;

	@Column(name = "DDO_RECEIVED_DATE")
	private LocalDateTime ddoReceivedDate;

	@Column(name = "DDO_REJECTED_STATUS")
	private String ddoRejectedStatus;

	@Column(name = "DDO_REJECTED_DATE")
	private LocalDateTime ddoRejectedDate;

	@Column(name = "DDO_REJECTED_COMMENTS")
	private String ddoRejectedComments;

	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "as_on_date", columnDefinition = "DATE")
	private LocalDate asOnDate;

	// Getters and Setters
	public LocalDate getAsOnDate() {
		return asOnDate;
	}

	public void setAsOnDate(LocalDate asOnDate) {
		this.asOnDate = asOnDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getGeNumber() {
		return geNumber;
	}

	public void setGeNumber(String geNumber) {
		this.geNumber = geNumber;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}

	public String getPdfFileNameStatus() {
		return pdfFileNameStatus;
	}

	public void setPdfFileNameStatus(String pdfFileNameStatus) {
		this.pdfFileNameStatus = pdfFileNameStatus;
	}

	public LocalDateTime getJsonSentDate() {
		return jsonSentDate;
	}

	public void setJsonSentDate(LocalDateTime jsonSentDate) {
		this.jsonSentDate = jsonSentDate;
	}

	public String getHrmsReceivedStatus() {
		return hrmsReceivedStatus;
	}

	public void setHrmsReceivedStatus(String hrmsReceivedStatus) {
		this.hrmsReceivedStatus = hrmsReceivedStatus;
	}

	public LocalDateTime getHrmsReceivedDate() {
		return hrmsReceivedDate;
	}

	public void setHrmsReceivedDate(LocalDateTime hrmsReceivedDate) {
		this.hrmsReceivedDate = hrmsReceivedDate;
	}

	public String getHrmsRejectedStatus() {
		return hrmsRejectedStatus;
	}

	public void setHrmsRejectedStatus(String hrmsRejectedStatus) {
		this.hrmsRejectedStatus = hrmsRejectedStatus;
	}

	public LocalDateTime getHrmsRejectedDate() {
		return hrmsRejectedDate;
	}

	public void setHrmsRejectedDate(LocalDateTime hrmsRejectedDate) {
		this.hrmsRejectedDate = hrmsRejectedDate;
	}

	public String getDdoReceivedStatus() {
		return ddoReceivedStatus;
	}

	public void setDdoReceivedStatus(String ddoReceivedStatus) {
		this.ddoReceivedStatus = ddoReceivedStatus;
	}

	public LocalDateTime getDdoReceivedDate() {
		return ddoReceivedDate;
	}

	public void setDdoReceivedDate(LocalDateTime ddoReceivedDate) {
		this.ddoReceivedDate = ddoReceivedDate;
	}

	public String getDdoRejectedStatus() {
		return ddoRejectedStatus;
	}

	public void setDdoRejectedStatus(String ddoRejectedStatus) {
		this.ddoRejectedStatus = ddoRejectedStatus;
	}

	public LocalDateTime getDdoRejectedDate() {
		return ddoRejectedDate;
	}

	public void setDdoRejectedDate(LocalDateTime ddoRejectedDate) {
		this.ddoRejectedDate = ddoRejectedDate;
	}

	public String getDdoRejectedComments() {
		return ddoRejectedComments;
	}

	public void setDdoRejectedComments(String ddoRejectedComments) {
		this.ddoRejectedComments = ddoRejectedComments;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
