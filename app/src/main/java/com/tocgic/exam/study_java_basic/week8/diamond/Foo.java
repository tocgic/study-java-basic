package com.tocgic.exam.study_java_basic.week8.diamond;

public interface Foo {
    default void print() {
        System.out.println("Foo");
    }
}
