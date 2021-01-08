package com.tocgic.exam.study_java_basic.week8.interfaces;

import com.tocgic.exam.study_java_basic.week6.overriding.Dog;

public class ExplosiveSniffingDog extends Dog implements PoliceDog {

    @Override
    public void Tracking() {
        System.out.println("용의자를 추적합니다.");
    }

    @Override
    public void Detection() {
        System.out.println("마약을 탐지 합니다.");
    }
}
