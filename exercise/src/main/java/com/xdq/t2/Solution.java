package com.xdq.t2;

/**
 * @author xdq
 */
public class Solution {

    /**
     * 单链表反转,{1,2,3}-> {3,2,1}
     * 要求：空间复杂度 O(1) ，时间复杂度 O(n)
     * 思路：
     * 移动头节点，记录前节点和下一个节点，只到头节点为null
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            //记录下一个节点
            next = head.next;
            head.next = pre;
            //之前的头节点相对于前一个节点
            pre = head;
            //移动头节点
            head = next;
        }
        return pre;
    }
}
