package com.verizon.competency.notificationservice.model;

public class Notification {
    String routingKey;
    String message;

    public Notification(){}

    public Notification(String routingKey, String message) {
        this.routingKey = routingKey;
        this.message = message;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
