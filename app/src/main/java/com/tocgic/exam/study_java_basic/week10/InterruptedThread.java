package com.tocgic.exam.study_java_basic.week10;

public class InterruptedThread extends Thread {
    @Override
    public void run() {
        System.out.println("스레드 loop 시작");
        while (!isInterrupted()) {
            System.out.println("스레드 loop sleep-before> isInterrupted():" + getState().name());
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("스레드 catch + " + isInterrupted());
                interrupt();
                System.out.println(getName()+" interrupted again, status: "+isInterrupted());
            }
            System.out.println("스레드 loop sleep-after> isInterrupted():" + getState().name());
        }
        System.out.println("스레드 loop 종료");
    }

    public static void main(String[] args) {
        InterruptedThread interruptedThread = new InterruptedThread();
        interruptedThread.start();
        try {
            Thread.sleep(500);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main-interruptedThread.interrupt()");
        interruptedThread.interrupt();
    }
}
