package com.tocgic.exam.study_java_basic.week8.diamond;

public interface Bar {
    float PIE = 3.141592f;
    public abstract void printName();

    default void print() {
        System.out.println("Bar");
    }
}
