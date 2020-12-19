package com.tocgic.exam.study_java_basic.week5.tree;

public class Node {
    private int value;
    private Node left, right;

    public Node(Node left, int value, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
