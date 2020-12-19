package com.tocgic.exam.study_java_basic.week5.tree;

import com.tocgic.exam.study_java_basic.week5.tree.module.Bfs;
import com.tocgic.exam.study_java_basic.week5.tree.module.DfsInorder;
import com.tocgic.exam.study_java_basic.week5.tree.module.DfsPostorder;
import com.tocgic.exam.study_java_basic.week5.tree.module.DfsPreorder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {
    static Node root;

    /**
     *       1
     *    2     3
     * 4    5
     */
    @BeforeAll
    static void init() {
        Node n4 = new Node(null, 4, null);
        Node n5 = new Node(null, 5, null);
        Node n2 = new Node(n4, 2, n5);
        Node n3 = new Node(null, 3, null);
        root = new Node(n2, 1, n3);
    }

    @Test
    @DisplayName("BFS 테스트")
    void bfsTest() {
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(binaryTree.search(new Bfs(), root), "[1, 2, 3, 4, 5]");
    }

    @Test
    @DisplayName("DFS Inorder 테스트")
    void dfsInorderTest() {
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(binaryTree.search(new DfsInorder(), root), "[4, 2, 5, 1, 3]");
    }

    @Test
    @DisplayName("DFS Preorder 테스트")
    void dfsPreorderTest() {
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(binaryTree.search(new DfsPreorder(), root), "[1, 2, 4, 5, 3]");
    }

    @Test
    @DisplayName("DFS Postorder 테스트")
    void dfsPostorderTest() {
        BinaryTree binaryTree = new BinaryTree();
        assertEquals(binaryTree.search(new DfsPostorder(), root), "[4, 5, 2, 3, 1]");
    }
}