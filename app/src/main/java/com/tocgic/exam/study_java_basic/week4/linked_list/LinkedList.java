package com.tocgic.exam.study_java_basic.week4.linked_list;

/**
 * ## 과제 2. LinkedList를 구현하세요.
 *
 * - LinkedList에 대해 공부하세요.
 * - 정수를 저장하는 ListNode 클래스를 구현하세요.
 * - ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
 * - ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
 * - boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
 */
public class LinkedList {

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        if (nodeToAdd == null) {
            return null;
        }
        ListNode cur = get(head, position);
        if (cur != null) {
            nodeToAdd.setNext(cur.getNext());
            cur.setNext(nodeToAdd);
            return nodeToAdd;
        }
        return null;
    }

    /**
     * 노드 제거
     * @param head head
     * @param positionToRemove 제거할 아이템 위치
     * @return 제거된 ListNode
     */
    public ListNode remove(ListNode head, int positionToRemove) {
        if (positionToRemove < 0) {
            return null;
        }
        ListNode cur = null;
        if (positionToRemove == 0) {
            cur = head;
            if (cur != null) {
                ListNode tmp = new ListNode(cur.getData());
                tmp.setNext(cur.getNext());

                ListNode next = cur.getNext();
                // head 를 제거 해야 하는데, head 는 외부에서 관리가 되기 때문에, 데이터만 제거 하는 형태로 처리 한다.
                if (next != null) {
                    cur.setData(next.getData());
                    cur.setNext(next.getNext());
                } else {
                    cur.setData(0);
                    cur.setNext(null);
                }
                return tmp;
            }
        } else {
            ListNode prev = get(head, positionToRemove - 1);
            if (prev != null) {
                cur = prev.getNext();
                prev.setNext(cur != null ? cur.getNext() : null);
            }
            return cur;
        }
        return null;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        int position = 0;
        ListNode node;
        while ((node = get(head, position++)) != null) {
            if (node == nodeToCheck) {
                return true;
            }
        }
        return false;
    }

    public ListNode get(ListNode head, int position) {
        if (head == null || position < 0) {
            return null;
        }
        ListNode cur = head;
        while (position-- > 0) {
            cur = cur.getNext();
        }
        return cur;
    }
}
