package com.tocgic.exam.study_java_basic.week14.generic1;

import java.util.ArrayList;
import java.util.List;

public class Play<T> {
    public static void main(String[] args) {
        List<? super RankGame> list = new ArrayList<>();
    }

    public void doSomething(Play<? super LoL> play) {

    }
}
