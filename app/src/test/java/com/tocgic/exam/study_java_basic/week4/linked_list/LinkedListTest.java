package com.tocgic.exam.study_java_basic.week4.linked_list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    static LinkedList linkedList;
    static ListNode head;

    @Test
    @BeforeAll
    static void create() {
        linkedList = new LinkedList();
        head = new ListNode(0);
    }

    @Test
    @DisplayName("get() test")
    void getTest() {
        assertNull(linkedList.get(null, 0));
        assertNull(linkedList.get(null, 1));
        assertEquals(linkedList.get(head, 0), head);
        assertNull(linkedList.get(head, 1));
    }

    @Test
    @DisplayName("add() test")
    void addTest() {
        //예외처리 검증
        assertNull(linkedList.add(null, null, 0));
        assertNull(linkedList.add(null, new ListNode(1), 0));
        assertNull(linkedList.add(null, new ListNode(1), 1));
        assertNull(linkedList.add(head, null, 0));
        assertNull(linkedList.add(head, null, 1));

        //0,1,2 추가 및 검증
        ListNode item;
        item = new ListNode(2);
        assertEquals(linkedList.add(head, item, 0), item);
        item = new ListNode(1);
        assertEquals(linkedList.add(head, item, 0), item);
        for (int i = 0; i < 3; i++) {
            int data = linkedList.get(head, i).getData();
            System.out.println("position:" + i + ", data:" + data);
            assertEquals(data, i);
        }
    }

    @Test
    void removeTest() {
        addTest();

        ListNode item2 = linkedList.get(head, 2);
        assertEquals(item2.getData(), 2);
        ListNode item1 = linkedList.get(head, 1);
        assertEquals(item1.getData(), 1);

        ListNode removedItem1 = linkedList.remove(head, 1);
        assertEquals(removedItem1.getData(), 1);
        assertEquals(removedItem1, item1);

        int backupHeadData = head.getData();
        System.out.println("backupHeadData, data:" + backupHeadData);
        ListNode removedHead = linkedList.remove(head, 0);
        assertEquals(removedHead.getData(), backupHeadData);
        System.out.println("head, data:" + head.getData());
        assertEquals(head.getData(), item2.getData());
    }

    @Test
    void containTest() {
        ListNode item1 = new ListNode(1);
        assertEquals(linkedList.add(head, item1, 0), item1);
        ListNode item2 = new ListNode(2);
        assertEquals(linkedList.add(head, item2, 1), item2);

        assertTrue(linkedList.contains(head, head));
        assertTrue(linkedList.contains(head, item1));
        assertTrue(linkedList.contains(head, item2));
        assertFalse(linkedList.contains(head, new ListNode(3)));
        assertFalse(linkedList.contains(head, new ListNode(4)));
    }
}