package com.tocgic.exam.study_java_basic.week5.access;

import org.junit.jupiter.api.*;

import javax.annotation.Nonnull;
import java.lang.reflect.Constructor;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AccessKeywordTest {
    void createInstance(@Nonnull String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.newInstance();
    }

    @Test
    @Order(1) @DisplayName("[다른 패키지] default 접근제어자 확인")
    void other_defaultClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.other.Default");
    }

    @Test
    @Order(2) @DisplayName("[다른 패키지] public 접근제어자 확인")
    void other_publicClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.other.Public");
    }

    @Test
    @Order(3) @DisplayName("[다른 패키지] [public inner] public 접근제어자 확인")
    void other_subPublicClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.other.Public$InnerPublic");
    }

    @Test
    @Order(4) @DisplayName("[다른 패키지] [public inner] public static 접근제어자 확인")
    void other_subPublicStaticClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.other.Public$InnerPublicStatic");
    }

    @Test
    @Order(5) @DisplayName("[다른 패키지] [public inner] default static 접근제어자 확인")
    void other_subDefaultStaticClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.other.Public$InnerDefaultStatic");
    }

    @Test
    @Order(6) @DisplayName("[다른 패키지] [public inner] protected static 접근제어자 확인")
    void other_subProtectedClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.other.Public$InnerProtectedStatic");
    }

    @Test
    @Order(7) @DisplayName("[다른 패키지] [public inner] private static 접근제어자 확인")
    void other_subPrivateClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.other.Public$InnerPrivateStatic");
    }

    @Test
    @Order(8) @DisplayName("[동일 패키지] default 접근제어자 확인")
    void defaultClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.access.Default");
    }

    @Test
    @Order(9) @DisplayName("[동일 패키지] public 접근제어자 확인")
    void publicClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.access.Public");
    }

    @Test
    @Order(10) @DisplayName("[동일 패키지] [public inner] public 접근제어자 확인")
    void subPublicClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.access.Public$InnerPublic");
    }

    @Test
    @Order(11) @DisplayName("[동일 패키지] [public inner] public static 접근제어자 확인")
    void subPublicStaticClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.access.Public$InnerPublicStatic");
    }

    @Test
    @Order(12) @DisplayName("[동일 패키지] [public inner] default static 접근제어자 확인")
    void subDefaultStaticClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.access.Public$InnerDefaultStatic");
    }

    @Test
    @Order(13) @DisplayName("[동일 패키지] [public inner] protected static 접근제어자 확인")
    void subProtectedClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.access.Public$InnerProtectedStatic");
    }

    @Test
    @Order(14) @DisplayName("[동일 패키지] [public inner] private static 접근제어자 확인")
    void subPrivateClassTest() throws Exception {
        createInstance("com.tocgic.exam.study_java_basic.week5.access.Public$InnerPrivateStatic");
    }
}
