package com.tocgic.exam.study_java_basic.week4.stack;

/**
 * ## 과제 3. Stack을 구현하세요.
 *
 * - int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
 * - void push(int data)를 구현하세요.
 * - int pop()을 구현하세요.
 */
public class Stack {
    private final int stackSize;
    private final int[] stack;
    private int cursor;

    public Stack(int stackSize) throws IllegalArgumentException {
        if (stackSize < 1) {
            throw new IllegalArgumentException("Must be greater than 0");
        }
        this.stackSize = stackSize;
        this.stack = new int[stackSize];
        this.cursor = -1;
    }

    public void push(int data) {
        if (cursor + 1 < stackSize) {
            stack[++cursor] = data;
        }
    }

    public int pop() {
        if (cursor >= 0) {
            return stack[cursor--];
        }
        return -1;
    }
}
