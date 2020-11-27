package com.tocgic.exam.study_java_basic.week3.instance_of;

public class SmartPhone extends Phone implements GamePlayer, MusicPlayer, VideoPlayer {
    @Override
    public void playGame() {
        System.out.println("playGame");
    }

    @Override
    public void playVideo() {
        System.out.println("playVideo");
    }

    @Override
    public void playMusic() {
        System.out.println("playMusic");
    }
}
