package com.tocgic.exam.study_java_basic.week10;

public class ThreadTest {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i + ":" + Thread.interrupted());
                    System.out.println(i + ":" + Thread.interrupted());
                }
            }
        }.start();

        System.out.println("Thread.MAX_PRIORITY:" + Thread.MAX_PRIORITY);
        System.out.println("Thread.MAX_PRIORITY:" + Thread.MAX_PRIORITY);
        System.out.println("Thread.MAX_PRIORITY:" + Thread.MAX_PRIORITY);
    }
}
