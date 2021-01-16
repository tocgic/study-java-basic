package com.tocgic.exam.study_java_basic.week9;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * - 책소개
 *    - 리팩터링 2 (http://www.yes24.com/Product/Goods/89649360) - js
 *          java 는 1판 (http://www.yes24.com/Product/Goods/267290)
 *    - GoF의 디자인 패턴
 * - IntelliJ tip : Surround With.. OptionCmdT
 *
 * - 10주차 과제 설명
 * Thread 클래스와 Runnable 인터페이스 : fork, join, full 은 패스, Thread & Runnable 에 있는 메소드, 인터페이스 공부
 * 쓰레드의 상태 : 어떤 상태가 있는가?
 * 쓰레드의 우선순위 : 우선순위 개념?
 * Main 쓰레드 : 무슨말인지 이해
 * 동기화 : 어떻게 하는지? 어떻게 처리 하는지?, 쓸때, Lock 으로 쓴는 Object 를 쓰는데 Lock 의 개념, dead lock 개념? 어떤상황에 발생하는지
 * 데드락 : 개념 + 예제
 */
public class LiveTest {
    @Test
    void name() {
        try {
            throw new NullPointerException();
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getClass());
        }

    }

    @Test
    void nameTest() throws IOException {
        String src = "asdf";
        String dest = "asdf";
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
