package com.xdq.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author xdq
 */
class SolutionTest {

    @Test
    @DisplayName("一个节点，1->null")
    void test1DetectCycle() {
        ListNode listNode = new ListNode(1);
        listNode.setNext(null);
        Assertions.assertNull(Solution.detectCycle(listNode));
    }

    @Test
    @DisplayName("多个节点，没有环，1->2->3->4")
    void test2DetectCycle() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(null);
        Assertions.assertNull(Solution.detectCycle(head));
    }

    @Test
    @DisplayName("多个节点，头环和尾成环，1->2->3->4->1")
    void test3DetectCycle() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(head);
        Assertions.assertTrue(head == Solution.detectCycle(head));
    }

    @Test
    @DisplayName("多个节点，第二环节点和尾成环，1->2->3->4->2")
    void test4DetectCycle() {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(second);
        Assertions.assertTrue(second == Solution.detectCycle(head));
    }

}