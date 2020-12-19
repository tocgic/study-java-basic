package com.tocgic.exam.study_java_basic.week5;

public interface DefaultKeyword {
    void must();

    default void option() {
        System.out.println("option");
    }
}
