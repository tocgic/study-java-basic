package com.tocgic.exam.study_java_basic.week5.live;

public class Init {
    private int number;
    // block 초기화 : 조건을 사용하기 용이
    {
        number = 10;
        System.out.println("init block");
    }

    public Init(int number) {
        this();
        this.number = number;
        System.out.println("Constructor");
    }

    public Init() {
        System.out.println("디폴트 생성사 호출 됨");
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
