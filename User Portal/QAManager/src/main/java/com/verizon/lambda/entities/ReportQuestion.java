package com.verizon.lambda.entities;

public class ReportQuestion {
    private String qId;
    private String uId;

    public ReportQuestion(){}
    public ReportQuestion(String qId, String uId) {
        this.qId = qId;
        this.uId = uId;
    }

    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
