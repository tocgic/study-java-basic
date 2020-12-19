package com.tocgic.exam.study_java_basic.week5;

import com.tocgic.exam.study_java_basic.week5.live.Init;
import org.junit.jupiter.api.Test;

/**
 * 1. 초기화 블럭 -  static {}, {}
 * 2. 과제 : Double dispatch
 */
public class LiveTest {
    @Test
    void name() {
        Init init = new Init(3);
        System.out.println(init);
    }
}
