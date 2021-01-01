package com.tocgic.exam.study_java_basic.week7_sub;

public class Print {
    public static final String NAME = Print.class.getSimpleName();

    public void print() {
        System.out.println(NAME + ".print()");
    }

    public static void staticPrint() {
        System.out.println(NAME + ".staticPrint()");
    }
}
