package com.tocgic.exam.study_java_basic.week4.linked_list;

public class ListNode {
    private ListNode next;
    private int data;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
