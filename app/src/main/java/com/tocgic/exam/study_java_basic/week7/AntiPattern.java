package com.tocgic.exam.study_java_basic.week7;

public class AntiPattern implements Constants {
    //private static final String NAME = "AntiPattern.name";

    public void out() {
        System.out.println(AntiPattern.NAME); // -> Constants.NAME
    }
}
