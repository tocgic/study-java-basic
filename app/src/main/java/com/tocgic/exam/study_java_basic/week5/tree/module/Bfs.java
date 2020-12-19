package com.tocgic.exam.study_java_basic.week5.tree.module;

import com.tocgic.exam.study_java_basic.week5.tree.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Breadth First Search (너비우선 탐색)
 *
 * - 수준(Level)이 낮은 노드를 우선으로 방문
 * - 같은 수준의 노드들 사이에서는 부모 노드의 방문 순서에 따라 방문, 왼쪽 자식 노드를 오른쪽 자식보다 먼저 방문
 * - 한 노드를 방문했을 때, 나중에 방문할 노드들을 순서대로 기록해 두어야함
 */
public class Bfs implements Module {
    @Override
    public void search(List<Integer> result, Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (queue.size() > 0) {
            Node node = queue.poll();
            result.add(node.getValue());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }
}
