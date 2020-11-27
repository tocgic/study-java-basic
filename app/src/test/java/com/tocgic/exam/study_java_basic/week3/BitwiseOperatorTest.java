package com.tocgic.exam.study_java_basic.week3;

import org.junit.Test;

public class BitwiseOperatorTest {
    @Test
    public void complement() {
        byte a = 12;
        byte b = ~12;
        byte c = (byte) ~b;
        //byte c = ~b0; // error: incompatible types (비트연산시, long 이 아닌경우, 결과 int)
    }

    @Test
    public void and() {
        int a = 10;
        int b = 7;
        int c = a & b;
    }

    @Test
    public void or() {
        int a = 10;
        int b = 7;
        int c = a | b;
    }

    @Test
    public void xor() {
        int a = 10;
        int b = 7;
        int c = a ^ b;
    }

    @Test
    public void leftShift() {
        int a = 10;
        int b = -10;
        int a0 = 10 << 2;
        int b0 = -10 << 2;
        int a1 = 10 << 2;
        int b1 = -10 << 2;
    }

    @Test
    public void signedRightShift() {
        int a = 10;
        int b = -10;
        int a0 = 10 >> 2;
        int b0 = -10 >> 2;
        int a1 = 10 >> 2;
        int b1 = -10 >> 2;
    }

    @Test
    public void unsignedRightShift() {
        int a = 10;
        int b = -10;
        int a0 = 10 >>> 2;
        int b0 = -10 >>> 2;
        int a1 = 10 >>> 2;
        int b1 = -10 >>> 2;
    }

}
