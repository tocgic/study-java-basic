package com.tocgic.exam.study_java_basic.week3;

import com.tocgic.exam.study_java_basic.week3.instance_of.*;
import org.junit.Test;

import javax.annotation.Nullable;

public class InstanceOfTest {
    @Test
    public void test() {
        phoneTest(new SmartPhone());
    }

    public void phoneTest(@Nullable Phone phone) {
        if (phone instanceof GamePlayer) {
            ((GamePlayer) phone).playGame();
        }
        if (phone instanceof RadioPlayer) {
            ((RadioPlayer) phone).playRadio(2.3f);
        }
        if (phone instanceof VideoPlayer) {
            ((VideoPlayer) phone).playVideo();
        }
        if (phone instanceof MusicPlayer) {
            ((MusicPlayer) phone).playMusic();
        }
    }
}
