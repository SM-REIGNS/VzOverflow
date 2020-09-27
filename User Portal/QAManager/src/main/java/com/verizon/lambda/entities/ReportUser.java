package com.verizon.lambda.entities;

import java.util.HashSet;
import java.util.Set;

public class ReportUser {
	private Set<String> reportedBy = new HashSet<>();

	public ReportUser() {
	}

	public Set<String> getReportedBy() {
		return reportedBy;
	}

	public void setReportedBy(Set<String> reportedBy) {
		this.reportedBy = reportedBy;
	}
}
