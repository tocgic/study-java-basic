package com.tocgic.exam.study_java_basic.week5;

/**
 * Represents a Cartesian (x,y) point
 */
public class Point {
    // 포인트의 좌표
    public double x, y;

    public Point(double x, double y) { // 필드를 초기화하는 생성자
        this.x = x;
        this.y = y;
    }

    public double distanceFromOrigin() { // x 및 y 필드에서 작동하는 메서드
        return Math.sqrt(x * x + y * y);
    }
}
