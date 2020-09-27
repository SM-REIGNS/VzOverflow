package com.verizon.lambda.entities;

public class QuestionReport {
    private int questionReportCount;
    private String userId;

    public QuestionReport() {
    }

    public QuestionReport(int questionReportCount, String userId) {
        this.questionReportCount = questionReportCount;
        this.userId = userId;
    }

    public QuestionReport(int questionReportCount) {
        this.questionReportCount = questionReportCount;
    }

    public int getQuestionReportCount() {
        return questionReportCount;
    }

    public void setQuestionReportCount(int questionReportCount) {
        this.questionReportCount = questionReportCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
