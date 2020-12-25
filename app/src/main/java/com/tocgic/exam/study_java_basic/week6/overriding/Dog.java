package com.tocgic.exam.study_java_basic.week6.overriding;

public class Dog extends Animal {
    public static void print() {
        System.out.println("Dog.print()");
    }

    @Override
    public void callMove() {
        System.out.println("Dog.callMove -> super.callMove()");
        super.callMove();
    }

    @Override
    public void move() {
        System.out.println("Dog.move()");
    }
}
