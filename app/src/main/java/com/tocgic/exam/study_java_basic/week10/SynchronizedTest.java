package com.tocgic.exam.study_java_basic.week10;

import javax.annotation.Nonnull;

public class SynchronizedTest {
    private int value;

    public void increase(@Nonnull Object lockInstance) {
        synchronized (lockInstance) {
            this.value++;
        }
    }

    public void decrease(@Nonnull Object lockInstance) {
        synchronized (lockInstance) {
            this.value--;
        }
    }

    public void calc(boolean increase, @Nonnull Object lockInstance) {
        for (int i = 0; i < 1000; i++) {
            if (increase) increase(lockInstance);
            else decrease(lockInstance);
        }
    }

    public int getValue() {
        return value;
    }

    public static class Task extends Thread {
        SynchronizedTest synchronizedTest;
        Object lockInstance;
        boolean isIncrease;

        public Task(SynchronizedTest synchronizedTest, Object lockInstance, boolean isIncrease) {
            this.synchronizedTest = synchronizedTest;
            this.lockInstance = lockInstance;
            this.isIncrease = isIncrease;
        }

        @Override
        public void run() {
            synchronizedTest.calc(isIncrease, lockInstance);
        }
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Task race1 = new Task(synchronizedTest, "LOCK", true);
        Task race2 = new Task(synchronizedTest, "LOCK", false);
        race1.start();
        race2.start();
        try {
            race1.join();
            race2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(synchronizedTest.getValue());
        }
    }
}