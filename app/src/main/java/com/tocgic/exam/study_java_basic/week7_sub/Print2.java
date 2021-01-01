package com.tocgic.exam.study_java_basic.week7_sub;

public class Print2 {
    public static final String NAME = Print2.class.getSimpleName();

    public void print() {
        System.out.println(NAME + ".print()");
    }

    public static void staticPrint() {
        System.out.println(NAME + ".staticPrint()");
    }
}
