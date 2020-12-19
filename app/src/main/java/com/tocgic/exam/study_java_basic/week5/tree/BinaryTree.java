package com.tocgic.exam.study_java_basic.week5.tree;

import com.tocgic.exam.study_java_basic.week5.tree.module.Module;

import java.util.*;

public class BinaryTree {
    public String search(Module module, Node root) {
        List<Integer> searchResult = new ArrayList<>();
        if (root != null && module != null) {
            module.search(searchResult, root);
        }
        return Arrays.toString(searchResult.toArray());
    }
}
