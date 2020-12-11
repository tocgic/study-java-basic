package com.tocgic.exam.study_java_basic.week4.queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeQueueTest {
    static ListNodeQueue queue;

    @Test
    @BeforeAll
    static void create() {
        queue = new ListNodeQueue();
    }

    @Test
    @DisplayName("Push & Pop Test")
    void pushPopTest() {
        for (int i = 0; i < 15; i++) {
            queue.push(i + 1);
        }
        for (int i = 0; i < 15; i++) {
            assertEquals(queue.pop(), i + 1);
        }
        assertEquals(queue.pop(), -1);
        assertEquals(queue.pop(), -1);
        queue.push(15);
        queue.push(5);
        queue.push(1);
        assertEquals(queue.pop(), 15);
        assertEquals(queue.pop(), 5);
        assertEquals(queue.pop(), 1);
    }
}