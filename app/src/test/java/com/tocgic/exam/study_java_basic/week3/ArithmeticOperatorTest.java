package com.tocgic.exam.study_java_basic.week3;

import org.junit.Test;

public class ArithmeticOperatorTest {
    @Test
    public void addition() {
        System.out.println("Total: " + 3 + 4); // "Total: 34"
        System.out.println("Total: " + (3 + 4)); // "Total: 7"
        System.out.println(3 + 4 + " is Total"); // "7 is Total"
        System.out.println(+ 3); // "3"
    }

    @Test
    public void subtraction() {
        System.out.println(7 - 3); // 4
        System.out.println(-3); // -3
        System.out.println(- 3); // -3
        System.out.println(-  3); // -3
    }

    @Test
    public void multiplication() {
        System.out.println(7 * 3); // 21
        System.out.println(7 * 3L); // 21
        System.out.println(7 * 3.0f); // 21.0
        System.out.println(7 * 3.0d); // 21.0
        //System.out.println(* 3); // compile error
    }

    @Test
    public void division() {
        System.out.println(7 / 3); // 2
        System.out.println(7 / 3L); // 2
        System.out.println(7L / 3); // 2
        System.out.println(7 / 3.0f); // 2.3333333
        System.out.println(7.0f / 3); // 2.3333333
        System.out.println(7.0f / 3.0f); // 2.3333333
        System.out.println(7 / 3.0); // 2.3333333333333335
        System.out.println(7 / 3.0d); // 2.3333333333333335
        System.out.println(-7 / 0.0); // -Infinity
        System.out.println(7 / 0.0); // Infinity
        System.out.println(0.0 / 0.0); // NaN
        System.out.println(Float.NaN); // NaN
        System.out.println(Float.NEGATIVE_INFINITY); // -Infinity
        System.out.println(Float.POSITIVE_INFINITY); // Infinity
        //System.out.println(7 / 0); // throw ArithmeticException
    }

    @Test
    public void modulo() {
        System.out.println(7 % 3); // 1
        System.out.println(7 % 3L); // 1
        System.out.println(7 % 2.1f); // 0.7000003
        System.out.println(7 % 2.1d); // 0.6999999999999997
        System.out.println(7.0f % 2.1f); // 0.7000003
        System.out.println(7.0d % 2.1d); // 0.6999999999999997
        System.out.println(4.3f % 2.1f); // 0.10000038
        System.out.println(4.3f % 2.1d); // 0.1000001907348631
        System.out.println(4.3d % 2.1d); // 0.09999999999999964
        System.out.println(4.3d % 2.1f); // 0.1000001907348631
        System.out.println(4.3 % 2.1); // 0.09999999999999964
        System.out.println(-7 % 0.0); // Nan
        System.out.println(7 % 0.0); // Nan
        System.out.println(0.0 % 0.0); // NaN
        //System.out.println(7 % 0); // throw ArithmeticException
    }

    @Test
    public void unaryMinus() {
        System.out.println(-2); // -2
        System.out.println(-2L); // -2
        System.out.println(-2.0f); // -2.0
        System.out.println(-2.0d); // -2.0
        System.out.println(-0); // 0
    }
}
