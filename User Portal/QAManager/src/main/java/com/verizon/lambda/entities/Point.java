package com.verizon.lambda.entities;

public class Point {
    public Point() {
    }

    public Point(int points) {
        this.points = points;
    }

    private int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
