package com.tocgic.exam.study_java_basic.week8;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

class FunctionalInterfaceTest {

    @Test
    void functionTest() {
        Function<Integer, Integer> sum10 = (number) -> number + 10;
        Function<Integer, Integer> mod = (number) -> number % 2;
        System.out.println("(20 + 10) mod 2 = " + sum10.andThen(mod).apply(20));
        System.out.println("(20 + 10) mod 2 = " + mod.compose(sum10).apply(20));
    }

    @Test
    void biFunctionTest() {
        BiFunction<Integer, Integer, Integer> sum = (num1, num2) -> num1 + num2;
        BiFunction<Integer, Integer, Integer> multiply = (num1, num2) -> num1 * num2;
        //System.out.println("(1 + 2) * 3 = ", sum.andThen(multiply).apply()); // Error -> andThe(Function f)
        System.out.println("(1 + 2) * 3 = " + multiply.apply(sum.apply(1, 2), 3));
    }

    @Test
    void binaryOperatorTest() {
        BinaryOperator<Integer> sum = (num1, num2) -> num1 + num2;
        BinaryOperator<Integer> multiply = (num1, num2) -> num1 * num2;
        System.out.println("(1 + 2) * 3 = " + multiply.apply(sum.apply(1, 2), 3));
    }

    @Test
    void consumerTest() {
        Consumer<Integer> printHex = (number) -> System.out.printf("%02X(16)\n", number);
        Consumer<Integer> printOct = (number) -> System.out.printf("%02o(8)\n", number);
        printHex.accept(10);
        printOct.accept(10);
        printHex.andThen(printOct).accept(10);
        printOct.andThen(printHex).accept(10);
    }

    @Test
    void predicateTest() {
        Predicate<Integer> isEven = (number) -> number % 2 == 0;
        Predicate<Integer> isOdd = isEven.negate();
        System.out.println(isEven.test(10));
        System.out.println(isOdd.test(10));
    }
}