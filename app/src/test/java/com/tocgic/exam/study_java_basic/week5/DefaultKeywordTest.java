package com.tocgic.exam.study_java_basic.week5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultKeywordTest {
    @Test
    @DisplayName("default 키워드 인터페이스")
    void defaultKeywordTest() {
        DefaultKeyword impl = new DefaultKeyword() {
            @Override
            public void must() {
                System.out.println("impl 의 must");
            }
        };
        impl.must();
        impl.option();

        DefaultKeyword impl2 = new DefaultKeyword() {
            @Override
            public void must() {
                System.out.println("impl 의 must");
            }

            @Override
            public void option() {
                System.out.println("impl 의 option");
            }
        };
        impl2.must();
        impl2.option();
    }
}