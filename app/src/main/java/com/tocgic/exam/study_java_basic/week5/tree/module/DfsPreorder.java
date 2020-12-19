package com.tocgic.exam.study_java_basic.week5.tree.module;

import com.tocgic.exam.study_java_basic.week5.tree.Node;

import java.util.List;

/**
 * Depth First Search (Preorder)
 */
public class DfsPreorder implements Module {
    @Override
    public void search(List<Integer> result, Node node) {
        if (node != null) {
            result.add(node.getValue());
            search(result, node.getLeft());
            search(result, node.getRight());
        }
    }
}
