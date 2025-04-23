package com.hrms2.dashboard.model;

public class DashboardStatus {
	
	private int jsonSent;
    private int pdfSent;
    private int hrmsReceived;
    private int hrmsRejected;
    private int ddoReceived;
    private int ddoRejected;

    // Getters & Setters

    public int getJsonSent() {
        return jsonSent;
    }

    public void setJsonSent(int jsonSent) {
        this.jsonSent = jsonSent;
    }

    public int getPdfSent() {
        return pdfSent;
    }

    public void setPdfSent(int pdfSent) {
        this.pdfSent = pdfSent;
    }

    public int getHrmsReceived() {
        return hrmsReceived;
    }

    public void setHrmsReceived(int hrmsReceived) {
        this.hrmsReceived = hrmsReceived;
    }

    public int getHrmsRejected() {
        return hrmsRejected;
    }

    public void setHrmsRejected(int hrmsRejected) {
        this.hrmsRejected = hrmsRejected;
    }

    public int getDdoReceived() {
        return ddoReceived;
    }

    public void setDdoReceived(int ddoReceived) {
        this.ddoReceived = ddoReceived;
    }

    public int getDdoRejected() {
        return ddoRejected;
    }

    public void setDdoRejected(int ddoRejected) {
        this.ddoRejected = ddoRejected;
    }

}
