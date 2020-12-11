package com.tocgic.exam.study_java_basic.week4.stack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeStackTest {
    static ListNodeStack stack;

    @Test
    @BeforeAll
    static void create() {
        stack = new ListNodeStack();
    }

    @Test
    @DisplayName("Push & Pop Test")
    void pushPopTest() {
        for (int i = 0; i < 15; i++) {
            stack.push(i + 1);
        }
        int value;
        for (int i = 15; i > 0; i--) {
            assertEquals(stack.pop(), i);
        }
        assertEquals(stack.pop(), -1);
        assertEquals(stack.pop(), -1);
        stack.push(15);
        stack.push(5);
        stack.push(1);
        assertEquals(stack.pop(), 1);
        assertEquals(stack.pop(), 5);
        assertEquals(stack.pop(), 15);
    }
}