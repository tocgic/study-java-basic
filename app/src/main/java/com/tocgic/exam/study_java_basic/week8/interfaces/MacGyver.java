package com.tocgic.exam.study_java_basic.week8.interfaces;

public class MacGyver {
    interface Scissors {
        void cutPaper();
    }
    interface Knife {
        void cutSomething();
    }
    interface Driver {
        void screw();
        void unscrew();
    }
    interface Pliers {
        void cutWire();
    }
    interface Opener {
        void openBottle();
    }

    public static class MacGyverKnife implements Scissors, Knife, Driver, Pliers, Opener {
        String name = MacGyverKnife.class.getSimpleName();

        @Override
        public void cutPaper() {
            System.out.println("[" + name + "] 종이를 자르다");
        }

        @Override
        public void cutSomething() {
            System.out.println("[" + name + "] 칼로 베다");
        }

        @Override
        public void screw() {
            System.out.println("[" + name + "] 나사를 조이다");
        }

        @Override
        public void unscrew() {
            System.out.println("[" + name + "] 나사를 풀다");
        }

        @Override
        public void cutWire() {
            System.out.println("[" + name + "] 철사를 자르다");
        }

        @Override
        public void openBottle() {
            System.out.println("[" + name + "] 병을 따다");
        }
    }

    public static void main(String[] args) {
        MacGyverKnife macGyverKnife = new MacGyverKnife();
        Scissors scissors = macGyverKnife;
        scissors.cutPaper();
        Knife knife = macGyverKnife;
        knife.cutSomething();
        Driver driver = macGyverKnife;
        driver.screw();
        driver.unscrew();
        Pliers pliers = macGyverKnife;
        pliers.cutWire();
        Opener opener = macGyverKnife;
        opener.openBottle();
    }
}
