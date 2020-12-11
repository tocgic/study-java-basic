package com.tocgic.exam.study_java_basic.week4.stack;

import com.tocgic.exam.study_java_basic.week4.linked_list.LinkedList;
import com.tocgic.exam.study_java_basic.week4.linked_list.ListNode;

/**
 * ## 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.
 *
 * - ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
 * - void push(int data)를 구현하세요.
 * - int pop()을 구현하세요.
 */
public class ListNodeStack {
    private final LinkedList stack;
    private final ListNode head;

    public ListNodeStack() {
        this.stack = new LinkedList();
        head = new ListNode(0);
    }

    public void push(int data) {
        stack.add(head, new ListNode(data), stack.getSize(head) - 1);
    }

    public int pop() {
        int data = -1;
        int stackSize = stack.getSize(head);
        if (stackSize > 1) {
            ListNode node = stack.remove(head, stackSize - 1);
            data = node.getData();
        }
        return data;
    }

}
