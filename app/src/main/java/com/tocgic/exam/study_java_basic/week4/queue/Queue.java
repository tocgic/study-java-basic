package com.tocgic.exam.study_java_basic.week4.queue;

/**
 * ## 과제 5. Queue를 구현하세요.
 *
 * - 배열을 사용해서 한번
 */
public class Queue {
    private final int memorySize;
    private final int[] memory;
    private int cursor;

    public Queue(int memorySize) throws IllegalArgumentException {
        if (memorySize < 1) {
            throw new IllegalArgumentException("Must be greater than 0");
        }
        this.memorySize = memorySize;
        this.memory = new int[memorySize];
        this.cursor = -1;
    }

    public void push(int data) {
        if (cursor + 1 < memorySize) {
            memory[++cursor] = data;
        }
    }

    public int pop() {
        if (cursor >= 0) {
            int data = memory[0];
            cursor--;

            for (int i = 0; i <= cursor; i++) {
                memory[i] = memory[i + 1];
            }
            return data;
        }
        return -1;
    }
}
