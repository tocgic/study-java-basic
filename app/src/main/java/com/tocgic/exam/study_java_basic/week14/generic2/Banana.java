package com.tocgic.exam.study_java_basic.week14.generic2;

public class Banana extends Entity<Integer> {
    public static Banana of(Integer id) {
        Banana banana = new Banana();
        banana.id = id;
        return banana;
    }
}
