package com.tocgic.exam.study_java_basic.week5.tree.module;

import com.tocgic.exam.study_java_basic.week5.tree.Node;

import java.util.List;

/**
 * Depth First Search (Inorder)
 */
public class DfsInorder implements Module {
    @Override
    public void search(List<Integer> result, Node node) {
        if (node != null) {
            search(result, node.getLeft());
            result.add(node.getValue());
            search(result, node.getRight());
        }
    }
}
