package com.tocgic.exam.study_java_basic.week8.interfaces;

public class Remote {
    interface RemoteControl {
        void powerOn();
        void powerOff();
    }

    interface TvControl {
        void changeChannel();
    }

    interface AudioControl {
        void volumeUp();
        void volumeDown();
        void mute(boolean isOn);
    }

    interface SmartTvRemoteControl extends RemoteControl, TvControl, AudioControl {
        boolean memoryChannel(int ch);
        boolean deleteChannel(int ch);
    }

}
