package com.xdq.t2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author xdq
 */
class SolutionTest {

    Solution solution = new Solution();
    @Test
    @DisplayName("空节点:{}")
    void test1() {
        ListNode reverseList = solution.reverseList(null);
        assertNull(reverseList);
    }

    @Test
    @DisplayName("一个结点:{1}")
    void test2() {
        ListNode listNode = new ListNode(1);
        listNode.next = null;

        ListNode reverseList = solution.reverseList(listNode);

        assertEquals(listNode, reverseList);
    }

    @Test
    @DisplayName("2个结点:{1,2}")
    void test3() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        listNode2.next = null;

        ListNode reverseList = solution.reverseList(listNode);

        listNode2.next = listNode;
        listNode.next = null;
        assertEquals(listNode2, reverseList);
    }

    @Test
    @DisplayName("多个结点:{1,2,3}")
    void test4() {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = null;

        ListNode reverseList = solution.reverseList(listNode);

        listNode3.next = listNode2;
        listNode2.next = listNode;
        listNode.next = null;
        assertEquals(listNode3, reverseList);
    }

}