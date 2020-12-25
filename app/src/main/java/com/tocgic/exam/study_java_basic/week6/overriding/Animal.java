package com.tocgic.exam.study_java_basic.week6.overriding;

public class Animal {
    public static void print() {
        System.out.println("Animal.print()");
    }

    public static void print2() {
        System.out.println("Animal.print2()");
    }

    public void callMove() {
        System.out.println("Animal.callMove() -> this.move()");
        this.move();
    }

    public void move() {
        System.out.println("Animal.move()");
    }
}
