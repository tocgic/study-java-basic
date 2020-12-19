package com.tocgic.exam.study_java_basic.week5.access;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

class DefaultTest {
    @Test
    @DisplayName("default 접근제어자 확인 - 동일 패키지명")
    void defaultTest() throws Exception {
        Class<?> clazz = Class.forName("com.tocgic.exam.study_java_basic.week5.access.Default");
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.newInstance();
    }
}